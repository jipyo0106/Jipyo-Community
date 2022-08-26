package jipyo.community.domain;

import jipyo.community.domain.entity.Board;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@Getter @Setter
public class RegisteBoardDTO {
    @NotEmpty
    private String name;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;

    public Board toBoardEntity() {
        return new Board(null, name, title, content, LocalDateTime.now());
    }

}
