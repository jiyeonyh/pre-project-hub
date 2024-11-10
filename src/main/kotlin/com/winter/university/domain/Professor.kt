package com.winter.university.domain

import jakarta.persistence.*

@Entity
@Table(name = "professor")
class Professor (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var name: String,
    var salary: Int,
)