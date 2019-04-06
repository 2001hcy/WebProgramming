package kr.hs.dgsw.web_326.Service;

import kr.hs.dgsw.web_326.Domain.User;
import kr.hs.dgsw.web_326.Protocol.AttachmentProtocol;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User viewUser(Long id);
    List<User> listUser();
    User updateUser(Long id,User user);
    boolean deleteUser(Long id);
    AttachmentProtocol applyProfilePicture(Long id, MultipartFile srcFile);
}
