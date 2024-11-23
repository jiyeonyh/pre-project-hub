package com.winter.university.domain

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.ManyToOne
import jakarta.persistence.JoinColumn
import java.time.LocalTime

@Entity
@Table(name = "lecture")
class Lecture (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    var lectureName: String,

    var time: LocalTime,

    @ManyToOne
    @JoinColumn(name = "professor_id")
    var professor: Professor? = null
)