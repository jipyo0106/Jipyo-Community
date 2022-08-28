package jipyo.community.domain;

import jipyo.community.domain.entity.Board;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
public class RegisteBoardDTO {
    @NotEmpty
    private String name;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;

    private LocalDateTime date;

    public RegisteBoardDTO(String name, String title, String content) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.date = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
    }

    public Board toBoardEntity() {
        return new Board(null, name, title, content, date);
    }

}
