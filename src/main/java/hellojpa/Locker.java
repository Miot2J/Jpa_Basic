package hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Locker {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    //locker계 와 양방향 연관 관계
    @OneToOne(mappedBy = "locker")
    private Member member;
}
