package 프록시;

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
            Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);
            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member1.getId()); //Proxy
            System.out.println("refMember.getClass() = " + refMember.getClass());

            Member findMember = em.find(Member.class, member1.getId());
            System.out.println("findMember.getClass() = " + findMember.getClass()); // Member

            //JPA에서는 하나의 트랜잭션에서는 동일한 조회를 했을 경우 == 비교시 항상 true 반환
            //    -> 이경우 최초 조회가 Proxy 이므로 실제 DB 조회 이후에도 Proxy로 반환
            System.out.println("refMember == findMember : " + (refMember == findMember));

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

}
