package shop.mtcoding.blog.board;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.blog.util.MyDateUtil;

import java.sql.Timestamp;

@NoArgsConstructor // 빈생성자 만들어주기
@Data // 변경되는 데이터에만 setter가 필요함
@Table(name = "board_tb")
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String username;

    @CreationTimestamp // PC로 인해 DB에 INSERT될 때 날짜 주입
    private Timestamp createdAt;

    public Board(String title, String content, String username) {
        this.title = title;
        this.content = content;
        this.username = username;
    }

    public String getBoardDate(){
        return MyDateUtil.timestampFormat(createdAt);
    }
}