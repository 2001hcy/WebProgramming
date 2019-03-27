package kr.hs.dgsw.web_326.Service;

import kr.hs.dgsw.web_326.Domain.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User viewUser(Long id);
    List<User> listUser();
    User updateUser(Long id,User user);
    boolean deleteUser(Long id);
}
