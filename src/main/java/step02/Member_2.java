package step02;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//@Entity
public class Member_2 {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;

//    @ManyToOne (fetch = FetchType.LAZY) //지연 전략 ->  쿼리 2번 나감
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team_2 team;


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

    public Team_2 getTeam() {
        return team;
    }

    public void setTeam(Team_2 team) {
        this.team = team;
    }

    public void changeTeam(Team_2 team) {
        this.team = team;
        //연관관계 편의 메소드
        team.getMembers().add(this);
    }
}
