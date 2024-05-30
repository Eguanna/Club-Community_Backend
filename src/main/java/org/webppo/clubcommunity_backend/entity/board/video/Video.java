package org.webppo.clubcommunity_backend.entity.board.video;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.webppo.clubcommunity_backend.entity.board.File;

@Entity
@Getter
@DiscriminatorValue("video")
@NoArgsConstructor
public class Video extends File {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private VideoBoard videoBoard;

    private final static String[] supportedExtension = {"mp4", "avi", "mov", "wmv", "flv"};

    static {
        supportedExtensions = supportedExtension;
    }

    public Video(String originName) {
        super(originName);
    }

    public void setVideoBoard(VideoBoard videoBoard) {
        if (this.videoBoard == null) {
            this.videoBoard = videoBoard;
        }
    }
}
