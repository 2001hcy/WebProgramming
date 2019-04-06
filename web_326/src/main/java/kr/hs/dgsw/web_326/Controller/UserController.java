package kr.hs.dgsw.web_326.Controller;

import kr.hs.dgsw.web_326.Domain.User;
import kr.hs.dgsw.web_326.Protocol.AttachmentProtocol;
import kr.hs.dgsw.web_326.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/add")
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }

    @GetMapping("/user/view/{id}")
    public User viewUser(@PathVariable Long id){
        return this.userService.viewUser(id);
    }

    @GetMapping("/user/list")
    public List<User> listUser(){
        return this.userService.listUser();
    }

    @PutMapping("/user/update/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User user){
        return this.userService.updateUser(id,user);
    }

    @DeleteMapping("/user/delete/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        return this.userService.deleteUser(id);
    }

    @PostMapping("/user/applyPP/{id}")
    public AttachmentProtocol applyProfilePicture(@PathVariable Long id,@RequestPart MultipartFile srcFile){
        return this.userService.applyProfilePicture(id,srcFile);
    }
}
