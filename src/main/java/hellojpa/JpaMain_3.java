package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain_3 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //code
        try {

            Member_4 member41 = new Member_4();
            member41.setUsername("A");

            Member_4 member42 = new Member_4();
            member42.setUsername("B");

            Member_4 member43 = new Member_4();
            member43.setUsername("C");

            em.persist(member41); //1, 51
            em.persist(member42); // 메모리
            em.persist(member43); // 메모리

            System.out.println("member1.getId() = " + member41.getId());
            System.out.println("member2.getId() = " + member42.getId());
            System.out.println("member3.getId() = " + member43.getId());


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
