package udoido.project.first.model.work.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import udoido.project.first.model.member.entity.Member;

import javax.persistence.*;
import java.time.LocalDateTime;

// 업무 코멘트
@Getter
@Setter
@ToString
@Entity
public class WorkComment {

    @Id
    @GeneratedValue
    private Long id;

    // 작성한 회원
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    // 업무
    @ManyToOne
    @JoinColumn(name = "work_id")
    private Work work;

    // 코멘트 내용
    private String content;
    
    // 등록 시간
    @CreationTimestamp
    private LocalDateTime regDate;

    // 수정 시간
    @UpdateTimestamp
    private LocalDateTime modDate;
}
