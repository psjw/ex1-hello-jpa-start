package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //code
        try {
            //비영속
//            Member member = new Member();
//            member.setId(2L);
//            member.setId(101L);
//            member.setName("HelloB");

            //영속
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");
            
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);

//            System.out.println("findMember1.getId() = " + findMember1.getId());
//            System.out.println("findMember1.getName() = " + findMember1.getName());

//            System.out.println("(findMember1==findMember2) = " + (findMember1==findMember2));

//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);

//            Member findMember = em.find(Member.class, 150L);
//            findMember.setName("ZZZZ");

//            Member member = new Member(200L, "member200");
//            em.persist(member);
//
//            em.flush();

            Member findMember = em.find(Member.class, 150L);
            findMember.setName("AAAA");
//            em.detach(findMember);
            em.clear();
            Member findMember1 = em.find(Member.class, 150L);

            System.out.println("========================");
            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
