package com.winter.university.domain

import jakarta.persistence.*
import java.time.LocalTime

@Entity
@Table(name = "lecture")
class Lecture (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    var name: String,

    var time: LocalTime,

    @ManyToOne
    @JoinColumn(name = "professor_id")
    var professor: Professor? = null
)