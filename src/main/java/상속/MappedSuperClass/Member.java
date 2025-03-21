package 상속.MappedSuperClass;

import jakarta.persistence.*;
import 일대일양방향.Locker;

import java.time.LocalDateTime;

@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "MEBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;

    //모든 테이블의 공통속성
//    private String createBy;
//    private LocalDateTime createDate;
//    private String lasModifiedBy;
//    private LocalDateTime lastModifiedDate;



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
