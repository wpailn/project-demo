package com.wp.common.file;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 文件传输组件
 */
@Component
public class FileTransferComponent {

    /**
     *
     * @param files 上传文件
     * @param path 存放路径
     * @return 上传结果
     */
    public Boolean fileUpload(List<MultipartFile> files, String path){
        boolean result = true;
        for (MultipartFile upFile:files) {
            File file = new File(path+upFile.getOriginalFilename());
            System.out.println(upFile.getContentType());
            try {
                upFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
                result = false;
                break;
            }
        }
        return result;
    }

    public void fileDownload(File file, HttpServletResponse response){
        try {
            String downloadFileName = new String(file.getName().getBytes(StandardCharsets.UTF_8),"ISO8859-1");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName="+downloadFileName);
            FileInputStream inputStream = new FileInputStream(file);
            ServletOutputStream outputStream = response.getOutputStream();
            int num;
            byte[] b = new byte[1024];
            while ((num = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, num);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
