package com.wp.api;

import com.wp.common.file.FileTransferComponent;
import com.wp.pojo.constant.SysEnum;
import com.wp.pojo.dto.HandlerResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

@RestController
@RequestMapping(path = "/file")
public class FileApi {

    /**
     * 文件存放路径
     */
    private String filePath = SysEnum.UPLOAD_FILE_ADDR.getValue();

    @Resource
    private FileTransferComponent fileTransferComponent;

    /**
     * 多文件上传
     * @param request 请求信息
     * @return 上传结果
     */
    @RequestMapping(path = "/upload")
    public HandlerResult fileUpload(MultipartHttpServletRequest request){
        System.out.println(request.getContentType());
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("password"));
        List<MultipartFile> files = request.getFiles("file");
        fileTransferComponent.fileUpload(files,filePath);
        return HandlerResult.success();
    }

    /**
     * 下载文件
     * @param request 请求
     * @param response 应答
     */
    @RequestMapping(path = "/download")
    public void fileDownload(HttpServletRequest request, HttpServletResponse response){
        String fileId = request.getParameter("fileId");
        File file = new File(filePath+fileId);
        fileTransferComponent.fileDownload(file,response);
    }
}
