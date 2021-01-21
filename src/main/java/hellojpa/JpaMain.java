package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //생성(입력코드)
         /*   Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");
            em.persist(member);
            */

            //수정 코드
            /*  Member findMember = em.find(Member.class,1L);
            findMember.setName("HelloJPA");*/

            //삭제코드
           /* Member findMember = em.find(Member.class,1L);
              em.remove();
            */


            //전체 검색 코드(1~10까지)
            /*List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(10)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.getName() = " + member.getName());
            }*/

            tx.commit();

        } catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
