package jipyo.community.domain;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@Getter
public class ResponseBoardVO {
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    private LocalDateTime date;

    public ResponseBoardVO(Long id, String name, String title, String content, LocalDateTime date) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
        this.date = date;
    }
}
