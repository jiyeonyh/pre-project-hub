package com.winter.university.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.ManyToOne
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn

@Entity
@Table(name = "enrollment")
class Enrollment(
    @Column(name = "student_id")
    var studentId: Int,

    @Column(name = "lecture_id")
    var lectureId: Int,
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    lateinit var student: Student

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id", insertable = false, updatable = false)
    lateinit var lecture: Lecture
}