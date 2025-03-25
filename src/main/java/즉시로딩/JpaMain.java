package 즉시로딩;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {
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

            Member findMember = em.find(Member.class, member1.getId()); //Proxy

            System.out.println("findMember.getTeam" + findMember.getTeam().getClass()); //프록시로 조회

            findMember.getTeam();

            System.out.println("=================");
            System.out.println("teamName = " + findMember.getTeam().getName());

            System.out.println("=================");

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
