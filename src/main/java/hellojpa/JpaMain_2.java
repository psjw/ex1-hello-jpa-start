package hellojpa;

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

            Member_2 member2 = new Member_2();
            member2.setId(1L);
            member2.setUsername("A");
            member2.setRoleType(RoleType.USER);

            em.persist(member2);
            Member_2 member21 = new Member_2();
            member21.setId(2L);
            member21.setUsername("B");
            member21.setRoleType(RoleType.ADMIN);

            em.persist(member21);

            System.out.println("####");
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
