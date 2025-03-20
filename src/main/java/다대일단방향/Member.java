package 다대일단방향;

import jakarta.persistence.*;
import step02.Team_2;

//@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;




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

    public Member(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
