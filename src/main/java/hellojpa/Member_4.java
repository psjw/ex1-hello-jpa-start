package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;
import jakarta.persistence.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;

//테이블
//@Entity
//@TableGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        table = "MY_SEQUENCES",
//        pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
public class Member_4 {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동증가
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "MEMBER_SEQ_GENERATOR") //시퀀스
    private Long id;
    @Column(name = "name", nullable = false)
    private String username;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    @Transient //DB에서는 미사용
    private int temp;

    public Member_4() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}