package 프록시;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain_2 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //code
        try {

            Member member = new Member();
            member.setUsername("hello");

            em.persist(member);

            em.flush();
            em.clear();

//            Member findMember = em.find(Member.class, 1L);
            Member findMember = em.getReference(Member.class, member.getId()); //단독 실행시 select 쿼리가 안나감
            System.out.println("findMember.getClass() = " + findMember.getClass()); //Member$HibernateProxy$sNEvqXfy 가짜클래스
            //실제 사용되는 시점에서 쿼리가 호출됨
//            System.out.println("findMember.getId() = " + findMember.getId()); //ID는 파라미터로 넣어서 DB조회 안함
            System.out.println("before findMember.getClass() = " + findMember.getClass());
            System.out.println("findMember.getUsername() = " + findMember.getUsername()); //username은 DB에서 조회
//            System.out.println("findMember.getUsername() = " + findMember.getUsername()); //username은 DB에서 조회
            System.out.println("after findMember.getClass() = " + findMember.getClass()); //프록시는 유지되고 내부 target변수에 값이 채워짐



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void printMember(Member member) {
        String username = member.getUsername();
        System.out.println("username = " + username);
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUsername();
        System.out.println("username = " + username);

        Team team = member.getTeam();
        System.out.println("team = " + team.getName());
    }
}
