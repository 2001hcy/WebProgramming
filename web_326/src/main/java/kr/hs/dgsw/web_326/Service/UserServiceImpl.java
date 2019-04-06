package kr.hs.dgsw.web_326.Service;


import kr.hs.dgsw.web_326.Domain.User;
import kr.hs.dgsw.web_326.Protocol.AttachmentProtocol;
import kr.hs.dgsw.web_326.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @PostConstruct
    void init(){
        this.userRepository.save(new User("aaa","aaa@dgsw","profiles\\default\\default.jpg","default.jpg"));
        this.userRepository.save(new User("bbb","bbb@dgsw","profiles\\default\\default.jpg","default.jpg"));
        this.userRepository.save(new User("ccc","ccc@dgsw","profiles\\default\\default.jpg","default.jpg"));
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User viewUser(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> listUser() {
        return this.userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> found = this.userRepository.findById(id);
        if (found.isPresent()) {
            User u = found.get();
            u.setUsername(user.getUsername());
            u.setEmail(user.getEmail());
            u.setProfileImagePath((user.getProfileImagePath()));
            u.setProfileImageName((user.getProfileImageName()));
            return this.userRepository.save(u);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteUser(Long id) {
        try {
            this.userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public AttachmentProtocol applyProfilePicture(Long id, MultipartFile srcFile) {
        return null;
    }
}
