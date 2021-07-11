package udoido.project.first.model.project.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import udoido.project.first.model.work.entity.Work;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    // 프로젝트 이름
    private String name;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<ProjectMember> projectMembers = new ArrayList<>();

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<Work> works = new ArrayList<>();
}
