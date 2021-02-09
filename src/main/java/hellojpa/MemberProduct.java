package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;

// N:N 을 1:N, N:1 관계로 풀어 쓰기 위해 생성한다.
@Entity
public class MemberProduct {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    private int count;
    private int price;

    private LocalDateTime orderDateTime;
}
