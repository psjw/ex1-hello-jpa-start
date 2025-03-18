package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;

//시퀀스
@Entity
@SequenceGenerator(name ="member_seq_generator_3", sequenceName = "member_seq_3", initialValue = 1, allocationSize = 50)
public class Member_3 {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동증가
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator_3") //시퀀스
    private Long id;
    @Column(name = "name", nullable = false)
    private String username;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    @Transient //DB에서는 미사용
    private int temp;

    public Member_3() {
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