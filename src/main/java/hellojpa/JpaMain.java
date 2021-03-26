package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
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

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setCreatedBy("cha");
            member.setCreatedDate(LocalDateTime.now());

            member.changeTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

 /*         양방향 매핑시에는 Team 과 Member 둘 다 연관관계 매핑이 필요햐다.
            Member.C 의 연관 관계 편의 메소드로 해결하자!

            team.getMembers().add(member);
            */
//            em.flush();
//            em.clear();

            Member findMember = em.find(Member.class, member.getId()); //1차 캐시에서 가져옴
            Team findTeam = findMember.getTeam();
            List<Member> members = findMember.getTeam().getMembers();

            for (Member m : members) {
                System.out.println("---------------");
                System.out.println("m.getUsername() = " + m.getUsername());
            }
            System.out.println("findTeam.getName() = " + findTeam.getName());


            tx.commit();

        } catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
