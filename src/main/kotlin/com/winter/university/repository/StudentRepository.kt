package com.winter.university.repository

import com.winter.university.domain.Student
import org.springframework.data.repository.CrudRepository

interface StudentRepository : CrudRepository<Student, Int> {
}