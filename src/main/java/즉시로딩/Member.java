package 즉시로딩;

import jakarta.persistence.*;

//@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;

    @ManyToOne(fetch = FetchType.EAGER) //ㅖProxy객체로 조회함
    @JoinColumn(name = "TEAM_ID")
    private Team team;


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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
