package com.winter.university.domain

import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "enrollment")
@IdClass(EnrollmentId::class)
class Enrollment() {
    @Id
    @Column(name = "student_id")
    var studentId: Int = 0

    @Id
    @Column(name = "lecture_id")
    var lectureId: Int = 0

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    var student: Student? = null

    @ManyToOne
    @JoinColumn(name = "lecture_id", insertable = false, updatable = false)
    var lecture: Lecture? = null

    constructor(studentId: Int, lectureId: Int) : this() {
        this.studentId = studentId
        this.lectureId = lectureId
    }
}

data class EnrollmentId(
    @Column(name = "student_id")
    val studentId: Int,

    @Column(name = "lecture_id")
    val lectureId: Int
) : Serializable