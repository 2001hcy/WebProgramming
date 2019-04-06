package kr.hs.dgsw.web_326.Controller;


import kr.hs.dgsw.web_326.Protocol.AttachmentProtocol;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
public class AttachmentController {
    @PostMapping("/attachment")
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
}
