package step01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain_5 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //code
        try {
            Team_5 team5 = new Team_5();
            team5.setName("TeamA");
            em.persist(team5);

            Member_5 member = new Member_5();
            member.setUsername("MemberA");
            member.setTeamId(team5.getId());
            em.persist(member);

            Member_5 findMember = em.find(Member_5.class, member.getId());
            Long findTeamId = findMember.getTeamId();
            Team_5 findTeam5 = em.find(Team_5.class, findTeamId);

            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
