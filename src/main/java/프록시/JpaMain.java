package 프록시;

import jakarta.persistence.*;
import org.hibernate.Hibernate;
import org.hibernate.jpa.internal.PersistenceUnitUtilImpl;

public class JpaMain {
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

//            em.detach(refMember);
            //AbstractLazyInitializer.initialize() 메서드에서 예외 여부를 체크
            //5.4.0 Final 버전  !session.isOpen()
            //5.4.1 Final 버전  !session.isOpenOrWaitingForAutoClose()
            //이 WaitingForAutoClose는 트랜잭션이 끝났는지 여부까지 한번 더 체크하게 됩니다.
            // 따라서 기존에는 단순히 세션(엔티티메니져)이 끝나면 예외가 터졌어야 하는데,
            // 이제부터는 트랜잭션이 유지되면 Lazy로딩을 사용할 수 있습니다.
            // 트랜잭션을 종료하지 않은 상태에서 세션(엔티티메니져)을 닫았기 때문에 아직 트랜잭션이 살아있습니다
//            em.close();

            //org.hibernate.LazyInitializationException: could not initialize proxy - no Session
           //-> 영속성 컨텍스트가 없음
//            System.out.println("refMember.getUsername() = " + refMember.getUsername());//강제초기화
            Hibernate.initialize(refMember); //강제 초기화
            //refMember.getUsername() -> 프록시 초기화 미호출시 false / 호출시 true
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));

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
