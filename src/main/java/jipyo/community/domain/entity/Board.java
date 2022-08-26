package jipyo.community.domain.entity;

import jipyo.community.domain.ResponseBoardVO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "board")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 20)
    private String name;
    @Column(length = 100)
    private String title;
    @Column(length = 255)
    private String content;
    @Column(columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private LocalDateTime date;

    public ResponseBoardVO toResponseBoardDTO() {
        return new ResponseBoardVO(id, name, title, content, date);
    }
}
