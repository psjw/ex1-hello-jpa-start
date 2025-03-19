package step02;

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
            Team_2 team = new Team_2();
            team.setName("TeamA");
            em.persist(team);

            Member_2 member = new Member_2();
            member.setUsername("MemberA");
            member.setTeam(team);
            em.persist(member);

            //강제 DB 삽입 후 초기화
            em.flush();
            em.clear();

            Member_2 findMember = em.find(Member_2.class, member.getId());
//            Team findTeam = findMember.getTeam();
//            System.out.println("findTeam.getName() = " + findTeam.getName());

//            Team newTeam = em.find(Team.class, 100L);
//            findMember.setTeam(newTeam);

            List<Member_2> members = findMember.getTeam().getMembers();
            for (Member_2 m : members) {
                System.out.println("m = "+ m.getUsername());
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
