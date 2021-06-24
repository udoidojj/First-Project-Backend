package udoido.project.first.model.work.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Work {

    @Id
    @GeneratedValue
    private int id;

    // 업무명
    private String name;

    // 설명
    private String desc;

    // 중요도
    private int proiroty;

    // 상위 업무 아이디
    private int parentID;

    // 시작 날짜
    private LocalDate startDate;

    // 종료날짜
    private LocalDate endDate;

    // 업무 상태
    // TODO enum 타입으로 변경하기
    private String state;

    //등록 날짜
    @CreationTimestamp
    private LocalDateTime regDate;

    // TODO Project 엔티티랑 조인


}

