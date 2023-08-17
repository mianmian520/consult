package com.boge.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boge.system.entity.FileEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件表(File)表服务接口
 *
 * @author boge
 * @since 2023-08-8 08:36:16
 */
public interface FileService extends IService<FileEntity> {

    /**
     * 文件上传
     * @param file 文件
     * @return 文件信息
     */
    FileEntity upload(MultipartFile file);
}

