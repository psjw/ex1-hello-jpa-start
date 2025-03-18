package hellojpa;

import jakarta.persistence.*;

//@Entity
//@Table(name = "MBR")
public class Member_1 {
    @Id
    private Long id;
//    @Column(name = "username")
    @Column(unique=true, length = 10)
    private String name;
    private int age;

    public Member_1() {
    }

    public Member_1(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
}
