package com.boge.system.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boge.system.dao.FileDao;
import com.boge.system.entity.FileEntity;
import com.boge.system.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * 文件表(File)表服务实现类
 *
 * @author boge
 * @since 2023-08-8 08:36:16
 */
@Service("fileService")
public class FileServiceImpl extends ServiceImpl<FileDao, FileEntity> implements FileService {

    @Value("${system.upload.path}")
    private String uploadPath;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public FileEntity upload(MultipartFile file) {
        FileEntity fileEntity = new FileEntity();
        String uuid = UUID.fastUUID().toString().replace("-", "");
        String fileType = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf("."), file.getOriginalFilename().length());
        fileEntity.setFileName(uuid + fileType);
        fileEntity.setOriginName(file.getOriginalFilename());
        fileEntity.setFilePath(uploadPath + "/" + uuid + fileType);
        save(fileEntity);
        try {
            FileUtil.writeFromStream(file.getInputStream(), fileEntity.getFilePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileEntity;
    }
}

