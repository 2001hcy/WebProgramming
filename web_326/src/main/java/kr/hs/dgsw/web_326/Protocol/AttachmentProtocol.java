package kr.hs.dgsw.web_326.Protocol;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AttachmentProtocol {
    private String profileImagePath;
    private String profileImageName;

    public AttachmentProtocol(String profileImagePath, String profileImageName) {
        this.profileImagePath = profileImagePath;
        this.profileImageName = profileImageName;
    }
}
