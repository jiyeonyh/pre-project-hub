package com.winter.university.domain

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.IdClass
import jakarta.persistence.Id
import jakarta.persistence.Column
import jakarta.persistence.ManyToOne
import jakarta.persistence.JoinColumn
import java.io.Serializable

@Entity
@Table(name = "enrollment")
@IdClass(EnrollmentId::class)
class Enrollment() {
    @Id
    @Column(name = "student_id")
    var studentId: Int? = null

    @Id
    @Column(name = "lecture_id")
    var lectureId: Int? = null

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
    val studentId: Int,
    val lectureId: Int
) : Serializable