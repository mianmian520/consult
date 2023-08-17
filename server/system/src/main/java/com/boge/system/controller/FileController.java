package com.boge.system.controller;


import cn.hutool.core.io.FileUtil;
import com.boge.core.common.consts.HttpHeaderConstants;
import com.boge.core.common.exception.CustomException;
import com.boge.core.common.response.Result;
import com.boge.system.entity.FileEntity;
import com.boge.system.service.FileService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 文件表(File)表控制层
 *
 * @author boge
 * @since 2023-08-8 08:36:16
 */
@Api(tags = "文件控制器", value = "文件控制器")
@RestController
@RequestMapping("/file")
public class FileController {

    /**
     * 服务对象
     */
    @Resource
    private FileService fileService;

    /**
     * 上传数据
     *
     * @param file 文件
     * @return 文件信息
     */
    @ApiOperation("文件上传")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文件id,修改时使用"),
            @ApiImplicitParam(name = "file", value = "文件", required = true)
    })
    @PostMapping("/upload")
    public Result<FileEntity> upload(Long id, MultipartFile file) {
        return Result.success(fileService.upload(id, file));
    }

    /**
     * 文件下载
     * @param id 文件id
     */
    @ApiOperation("根据文件id下载")
    @GetMapping("/download/{id}")
    public void download(@PathVariable("id") @ApiParam("文件id") Long id, HttpServletResponse response) throws CustomException {
        try {
            FileEntity entity = fileService.getById(id);
            byte[] bytes = FileUtil.readBytes(entity.getFilePath());
            String fileName = URLEncoder.encode(entity.getOriginName(), StandardCharsets.UTF_8.name());
            response.reset();
            response.setHeader(HttpHeaderConstants.EXPOSE_HEADERS, HttpHeaderConstants.CONTENT_DISPOSITION);
            response.setHeader(HttpHeaderConstants.CONTENT_TYPE, HttpHeaderConstants.OCTET_STREAM);
            response.setHeader(HttpHeaderConstants.CONTENT_DISPOSITION, "attachment; fileName=" + fileName);
            response.setHeader(HttpHeaderConstants.ALLOW_HEADERS, "*");
            response.setHeader(HttpHeaderConstants.CONTENT_LENGTH, bytes.length+"");
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            bos.write(bytes);
            bos.flush();
            bos.close();
        } catch (Exception e) {
            throw new CustomException("下载失败");
        }
    }

    /**
     * 文件下载
     * @param path 文件路径
     */
    @ApiOperation("根据文件路径下载")
    @GetMapping("/download")
    public void download(@ApiParam(value = "文件路径", required = true) String path, HttpServletResponse response) throws CustomException {
        byte[] bytes = FileUtil.readBytes(path);
        try {
            String fileName = URLEncoder.encode("xxx", StandardCharsets.UTF_8.name());
            response.reset();
            response.setHeader(HttpHeaderConstants.EXPOSE_HEADERS, HttpHeaderConstants.CONTENT_DISPOSITION);
            response.setHeader(HttpHeaderConstants.CONTENT_TYPE, HttpHeaderConstants.OCTET_STREAM);
            response.setHeader(HttpHeaderConstants.CONTENT_DISPOSITION, "attachment; fileName=" + fileName);
            response.setHeader(HttpHeaderConstants.ALLOW_HEADERS, "*");
            response.setHeader(HttpHeaderConstants.CONTENT_LENGTH, bytes.length+"");
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            bos.write(bytes);
            bos.flush();
            bos.close();
        } catch (Exception e) {
            throw new CustomException("下载失败");
        }
    }
}

