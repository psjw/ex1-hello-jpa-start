package step02;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

public class JpaMain_2 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //code
        try {

            Team_2 team = new Team_2();
            team.setName("TeamA");
            //연관관계 주인이므로 데이터 업데이트 안됨
//            team.getMembers().add(member);
            em.persist(team);

            Member_2 member = new Member_2();
            member.setUsername("MemberA");
            //연관관계 편의 메서드 두개 중 하나만 사용
            //방법1. 연관관계 편의 메서드
            member.changeTeam(team);
            //방법2. 연관관걔 편의 메서드
            team.addMember(member);
            em.persist(member);


            //양방향 연관관계 일 경우 양쪽에 다 넣어주지 않으면 문제 발생
            // -> flush , clear 없으면 문제 발생  -> 1차 캐시에서 바로 조회됨 ->DB Select 쿼리가 안나감
//            team.getMembers().add(member); //Member의 setTeam에 연관관계 편의 메소드 생성

            em.flush();
            em.clear();
            Team_2 findTeam = em.find(Team_2.class, team.getId()); //1차 캐시
            List<Member_2> members = findTeam.getMembers();
            for (Member_2 m : members) {
                System.out.println("m = " + m.getUsername());
            }

            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
