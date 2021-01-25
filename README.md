# Jpa_Basic

-----

### < Persistence Option >
+ property name="hibernate.show_sql" value="true" : sql 출력해줌
+ property name="hibernate.format_sql" value="true" : sql 보기쉽게 포맷해줌 
+ property name="hibernate.use_sql_comments" value="true" : 트랜잭션을 주석으로 보여줌 
---

### < TIPS >

+ JPA를 시작할 때 EntityManagerFactory 를 선언해야 한다.
  + persistenceUnitName 은 DB 마다 하나씩 고유 값을 가진다.(persistence.xml 내부에 선언)
+ Factory 에서 EntityManager 를 선언한다
  + 클라이언트의 요청마다 하나의 EntityManager 가 선언되고 EM은 DB 커넥션을 다.
+ JPA는 한 트랜잭션 안에서만 crud 해야한다.

 < 영속 컨텍스트 >
 + JPA 사용시 객체를 선언하고 객체를 영속 컨텍스트로 등록해야 한다.
    + EM이 관리하는 영속 컨텍스트를 1차 캐시라고 부르고 변경되지 않는 한 DB가 아닌 1차 캐시에서 값을 읽어온다.( 1차 캐시에 없으면 DB에서 가져옴)
    + 1차 캐시에 등록 됐다고 해서 DB에 저장 된건 아님(commit 해야 적용된다)
  + 쓰기 지연을 지원한다 (persist 시 트랜잭션 commit 전까지 쓰기 지연 sql 저장소에 저장된다.)
+ Dirty Checking(변경 감지)를 지원한다 
  + 1차캐시의 엔티티와 스냅샷을 비교후 변경이 있다면 쓰기 지연 sql에 update 쿼리 저장.
    
 < 연관관계 매핑 >
+ 진짜 매핑(연관 관계의 주인)은 FK가 있는 곳에서 매핑한다.
    + @JoinColumn 으로
+ 가짜 매핑은 주인의 반대편에서 매핑한다.
    + 이 프로젝트에서는 Member 가 주인 Team 이 가
    
-------

##< Annotation >

< JPA Mapping Annotation >

+ @Column : 컬럼 매핑
+ @Enumerated : DB에서 Enum 타입 쓰고싶을때 객체(변수) 위에 선언
+ @Temporal : 날짜 타입을 쓸때 객체(변수)위에 선언
+ @Lob : DB에 varchar 를 넘어서는 큰 값을 넣고싶을때(BLOB,CLOB 매핑)
+ @Transient : 특정 필드를 컬럼에서 제거하고 싶을때(메모리에서만 사용하고 DB에 안넣고 싶을때)
