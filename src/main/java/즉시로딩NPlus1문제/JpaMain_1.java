package 즉시로딩NPlus1문제;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain_1 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //code
        try {
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setTeam(team);
            em.persist(member1);


            em.flush();
            em.clear();


            //Member findMember = em.find(Member.class, member1.getId());
            //2번 조회됨 -> N+1 문제
            //Member를 조회한 이후에 Team의 즉시로딩 정보를 확인하고 다시 조회됨 -> Lazy면 Proxy 넣으면 됨
            List<Member> members = em.createQuery("select m from Member m", Member.class)
                    .getResultList();

            //SQL : select * from Member
            //SQL : select * from Team where TEAM_ID = xxx


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }

}
