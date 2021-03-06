package kr.hs.dgsw.web_326.Service;

import kr.hs.dgsw.web_326.Domain.Comment;
import kr.hs.dgsw.web_326.Protocol.CommentUserIdProtocol;
import kr.hs.dgsw.web_326.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @PostConstruct
    public void init(){
        this.commentRepository.save(new Comment("aaa", "A Comment 1"));
        this.commentRepository.save(new Comment("bbb", "B Comment 1"));
        this.commentRepository.save(new Comment("ccc", "C Comment 1"));
    }

    @Override
    public Comment commentAdd(Comment comment) {
        return this.commentRepository.save(comment);
    }

    @Override
    public Comment commentView(Long id) {
        return this.commentRepository.findById(id).orElse(null);
    }

    @Override
    public List<CommentUserIdProtocol> commentViewbyuserId(String userId) {
        List<Comment> commentList = this.commentRepository.findAll();
        List<CommentUserIdProtocol> foundList = new ArrayList<>();
        for (Comment comment : commentList) {
            Optional<Comment> found = this.commentRepository.findById(comment.getId());
            if (found.isPresent()){
                if (found.get().getUserId().equals(userId)) {
                    foundList.add(new CommentUserIdProtocol(comment,userId));
                }
            } else {
                return null;
            }
        }
        return foundList;
    }

    @Override
    public List<Comment> commentListAll() {
        return this.commentRepository.findAll();
    }

    @Override
    public Comment commentUpdate(Long id, Comment comment) {
        Optional<Comment> found = this.commentRepository.findById(id);
        if (found.isPresent()) {
            Comment com = found.get();
            com.setUserId(comment.getUserId());
            com.setContent(comment.getContent());
            return this.commentRepository.save(com);
        } else {
            return null;
        }
    }

    @Override
    public boolean commentDelete(Long id) {
        try {
            this.commentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
