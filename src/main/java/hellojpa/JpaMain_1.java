package hellojpa;

import jakarta.persistence.*;

public class JpaMain_1 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //code
        try {

            Member_1 findMember = em.find(Member_1.class, 150L);
            findMember.setName("AAAA");
//            em.detach(findMember);
//            em.clear();
            Member_1 findMember11 = em.find(Member_1.class, 150L);

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
