package kr.hs.dgsw.web_326.Controller;


import kr.hs.dgsw.web_326.Protocol.AttachmentProtocol;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
public class AttachmentController {
    @PostMapping("/attachment")


    //내가 만든 post
    public AttachmentProtocol upload(@RequestPart MultipartFile srcFile) {
        String uid = UUID.randomUUID().toString();
        String destFilename
                = "D:\\Java\\web_326\\src\\main\\resources\\static\\profiles\\"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy\\MM/dd\\"))
                + uid
                + "_" + srcFile.getOriginalFilename();
        try {
            File destFile = new File(destFilename);
            destFile.getParentFile().mkdirs();
            srcFile.transferTo(destFile);
            destFilename = "profiles\\"
                    + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy\\MM\\dd\\"))
                    + uid
                    + "_" + srcFile.getOriginalFilename();
            return new AttachmentProtocol(destFilename, srcFile.getOriginalFilename());
        } catch (IOException e) {
            return null;
        }
    }


    @GetMapping("/attachment")
    public void download(HttpServletRequest req, HttpServletResponse res) {
        try {
            String filePath = "D:\\Java\\web_326\\uploads\\2019\\04\\08\\ce3dc818-3d82-49f9-9345-2616e19ef76f_testphoto.jpg";
            String fileName = "c3.jpg";
            File file = new File(filePath);
            if (!file.exists()) {
                return;
            }
            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }

            res.setContentType(mimeType);
            res.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
            res.setContentLength((int) file.length());

            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            FileCopyUtils.copy(inputStream, res.getOutputStream());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //선생님 post
//    public AttachmentProtocol upload(@RequestPart MultipartFile srcFile) {
//        String uid = UUID.randomUUID().toString();
//        String destFilename
//                = "D:\\Java\\web_326\\uploads\\"
//                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy\\MM/dd\\"))
//                + uid
//                + "_" + srcFile.getOriginalFilename();
//        try {
//            File destFile = new File(destFilename);
//            destFile.getParentFile().mkdirs();
//            srcFile.transferTo(destFile);
//            return new AttachmentProtocol(destFilename, srcFile.getOriginalFilename());
//        } catch (IOException e) {
//            return null;
//        }
//    }
}
