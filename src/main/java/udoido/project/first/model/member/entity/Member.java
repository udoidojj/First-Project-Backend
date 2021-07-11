package udoido.project.first.model.member.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import udoido.project.first.model.project.entity.ProjectMember;
import udoido.project.first.model.work.entity.Work;
import udoido.project.first.model.work.entity.WorkComment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Member {

    // 회원 아이디
    @Id
    private String memberId;

    // 비밀번호
    private String passwd;

    // 이름
    private String name;

    // 참여하는 프로젝트들
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<ProjectMember> projectMembers = new ArrayList<>();

    // 할당된 업무들
    @ManyToMany(mappedBy = "members", fetch = FetchType.LAZY)
    private List<Work> works;
    
    // 작선한 코멘트
    @OneToMany(mappedBy = "member")
    private List<WorkComment> comments;
}
