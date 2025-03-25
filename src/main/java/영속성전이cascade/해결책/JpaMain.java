package 영속성전이cascade.해결책;

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

            //총 3번 persist 호출
            //Parent가 Child를 관리해주었으면함
            //CASCADE 사용시 -> Parent만 persist하면 Child도 persist됨
            //CASECADE는 단일 엔티티에만 적용되는 것이 아니라 연관관계에 있는 모든 엔티티에 적용됨 -> 단일 엔티티일 경우에면 사용
            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);
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
