package kr.hs.dgsw.web_326.Service;

import kr.hs.dgsw.web_326.Domain.Comment;
import kr.hs.dgsw.web_326.Protocol.CommentUserIdProtocol;

import java.util.List;

public interface CommentService {
    Comment commentAdd(Comment comment);
    Comment commentView(Long id);
    List<CommentUserIdProtocol> commentViewbyuserId(String userId);
    List<Comment> commentListAll();
    Comment commentUpdate(Long id,Comment comment);
    boolean commentDelete(Long id);
}
