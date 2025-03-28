package 값타입.값타입과불변객체;

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
            Address homeAddress = new Address("city", "street", "zipcode");
            Member member1 = new Member();
            member1.setHomeAddress(homeAddress);
            member1.setUsername("member1");
            em.persist(member1);

//            Address copyAddress = new Address(homeAddress.getCity(), homeAddress.getStreet(), homeAddress.getZipcode());
//
//            Member member2 = new Member();
//            member2.setHomeAddress(copyAddress);
//            member2.setUsername("member2");
//            em.persist(member2);

            //Member1의 homeAddress의 city를 newCity로 변경
            // -> 실행시 member1과 member2의 homeAddress의 city도 newCity로 변경됨
            // -> Address를 Entity로 만들어야 함
            // -> Address를 불변객체로 만들어서 해결
//            member1.getHomeAddress().setCity("newCity"); //컴파일 에러 발생 setter가 private이기 때문
            Address newAddress = new Address(homeAddress.getCity(), homeAddress.getStreet(), homeAddress.getZipcode());
            member1.setHomeAddress(newAddress);

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
