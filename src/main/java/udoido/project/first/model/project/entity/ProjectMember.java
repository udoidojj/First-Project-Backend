package udoido.project.first.model.project.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import udoido.project.first.model.member.entity.Member;
import udoido.project.first.model.project.type.ProjectMemberLevel;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class ProjectMember {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "proejct_id")
    private Project project;

    // 프로젝트의 회원 권한 레벨
    @Enumerated(EnumType.STRING)
    private ProjectMemberLevel level;
}
