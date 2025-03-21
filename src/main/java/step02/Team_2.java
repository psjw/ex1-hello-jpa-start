package step02;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Team_2 {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    //조회만 가능 연관관계의 주인이 아님
    @OneToMany(mappedBy = "team") //1:다 매핑에서 무엇이랑 연결되어 있나? Member의 team과 연결
    private List<Member_2> members = new ArrayList<>(); //add 시 nullPoint에러 방지

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member_2> getMembers() {
        return members;
    }

    public void setMembers(List<Member_2> members) {
        this.members = members;
    }

    //연관관계 편의 메서드
    public void addMember(Member_2 member) {
        member.setTeam(this);
        members.add(member);
    }
}
