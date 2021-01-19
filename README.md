# Jpa_Basic

-----

### < Persistence Option >
+ property name="hibernate.show_sql" value="true" : sql 출력해줌
+ property name="hibernate.format_sql" value="true" : sql 보기쉽게 포맷해줌 
+ property name="hibernate.use_sql_comments" value="true" : 트랜잭션을 주석으로 보여줌 
---

< TIPS >

+ JPA를 시작할 때 EntityManagerFactory 를 선언해야 한다.
  + persistenceUnitName 은 DB 마다 하나씩 고유 값을 가진다.(persistence.xml 내부에 선언)
+ Factory 에서 EntityManager 를 선언한다
+ JPA는 한 트랜잭션 안에서만 crud 해야한다.