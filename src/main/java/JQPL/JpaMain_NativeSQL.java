package JQPL;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;


public class JpaMain_NativeSQL {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //code
        try {
            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

            //flush -> commit, query

            //DB커넥션 획득 -> dbconn.executeQuery("select * from member");
            // JPA랑 관련 없으므로 flush 호출이 안되므로 데이터 조회 안됨 -> 강제로 flush 호출

            //Native SQL
            List<Member> result = em.createNativeQuery(
                    "select MEMBER_ID, city, street, zipcode, username from MEMBER",
                    Member.class).getResultList();

            for (Member member1 : result) {
                System.out.println("member1 = " + member1);
            }
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
