package udoido.project.first.model.work.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import udoido.project.first.model.member.entity.Member;
import udoido.project.first.model.project.entity.Project;
import udoido.project.first.model.work.type.WorkState;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Work {

    @Id
    @GeneratedValue
    private Long id;

    // 업무명
    private String name;

    // 설명
    private String desc;

    // 중요도
    private Byte priority;

    // 상위 업무 아이디
    private Long parentID;

    // 시작 날짜
    private LocalDate startDate;

    // 종료날짜
    private LocalDate endDate;

    // 업무 상태
    @Enumerated(EnumType.STRING)
    private WorkState state;

    //등록 날짜
    @CreationTimestamp
    private LocalDateTime regDate;

    // 프로젝트 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    // 회원 매핑
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "work_member",
            joinColumns = @JoinColumn(name="member_id"),
            inverseJoinColumns = @JoinColumn(name="work_id")
    )
    private List<Member> members;

    @OneToMany(mappedBy = "work", fetch = FetchType.LAZY)
    private List<WorkComment> comments;
}

