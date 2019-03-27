package kr.hs.dgsw.web_326.Protocol;

import kr.hs.dgsw.web_326.Domain.Comment;

public class CommentUserIdProtocol extends Comment {
    private String username;
    public CommentUserIdProtocol(Comment comment, String username) {
        super(comment);
        this.username = username;
    }
}
