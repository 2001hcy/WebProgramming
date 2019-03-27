package kr.hs.dgsw.web_326.Controller;

import kr.hs.dgsw.web_326.Domain.Comment;
import kr.hs.dgsw.web_326.Protocol.CommentUserIdProtocol;
import kr.hs.dgsw.web_326.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comment/add")
    private Comment addComment(@RequestBody Comment comment){
        return this.commentService.commentAdd(comment);
    }

    @GetMapping("/comment/view/{id}")
    private Comment viewComment(@PathVariable Long id){
        return this.commentService.commentView(id);
    }

    @GetMapping("/comment/viewbyuserid/{userId}")
    private List<CommentUserIdProtocol> viewCommentbyId(@PathVariable String userId){
        return this.commentService.commentViewbyuserId(userId);
    }

    @GetMapping("/comment/list")
    private List<Comment> commentListAll(){
        return this.commentService.commentListAll();
    }

    @PutMapping("/comment/update/{id}")
    private Comment commentUpdate(@PathVariable Long id,@RequestBody Comment comment){  //댓글번호, 수정할 댓글 내용
        return this.commentService.commentUpdate(id,comment);
    }

    @DeleteMapping("/comment/delete/{id}")
    private boolean commentDelete(@PathVariable Long id){   //댓글번호
        return this.commentService.commentDelete(id);
    }

}
