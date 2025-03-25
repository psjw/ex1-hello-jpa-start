package 프록시;

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

            Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("member3");
            em.persist(member3);



            em.flush();
            em.clear();

            Member m1 = em.find(Member.class, member1.getId());
            Member m2 = em.find(Member.class, member2.getId());

            //타입 비교시 true
            System.out.println("m1 == m2 : " + (m1.getClass() == m2.getClass()));

            Member m3 = em.getReference(Member.class, member3.getId());

            //타입 비교시 false
            System.out.println("m1 == m3 : " + (m1.getClass() == m3.getClass()));
            logic(m1, m3);
            logic1(m1, m3);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    //proxy로 넘어올지 타입으로 넘어올지 알수 없음
    private static void logic(Member m1, Member m2) {
        System.out.println("(m1 == m2 = " + (m1.getClass() == m2.getClass()));
    }

    //타입에 대한 검증은 instance of를 사용하자
    private static void logic1(Member m1, Member m2) {
        System.out.println("(m1 instance Member = " + (m1 instanceof Member));
        System.out.println("(m2 instance Member = " + (m2 instanceof Member));
    }

}
