package com.jpa.demo.entity.solution;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Subject {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="academy_id" , foreignKey = @ForeignKey (name="FK_SUBJECT_ACADEMY"))
    private Academy academy;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id" , foreignKey = @ForeignKey (name="FK_SUBJECT_TEACHER"))
    private Teacher teacher;

    private String name;

    @Builder
    public Subject(String name, Academy academy , Teacher teacher) {
        this.name = name;
        this.academy = academy;
        this.teacher = teacher;
    }

    public void updateAcademy(Academy academy) {
        this.academy = academy;
    }

}
