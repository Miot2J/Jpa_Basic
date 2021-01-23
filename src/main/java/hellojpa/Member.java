package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@SequenceGenerator(name = "member_seq_generator",
        sequenceName = "member_seq", //매핑할 DB 시퀀스 이름
        initialValue = 1,
        allocationSize = 50 //50개씩 미리 확보해놔서 동시성 이슈 해결한다.
)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "member_seq_generator")
    @Column(name = "MEMBER_ID")
    private Long id;

    //객체는 username DB는 USERNAME 으로 표기하고 싶을때
    @Column(name = "USERNAME")
    private String username;

    /*
        @Column(name = "TEAM_ID")
        private Long teamId;
    */
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    /*private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    @Lob
    private String description;*/

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
