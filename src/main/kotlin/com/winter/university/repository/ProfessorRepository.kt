package com.winter.university.repository

import com.winter.university.domain.Professor
import org.springframework.data.repository.CrudRepository

interface ProfessorRepository : CrudRepository<Professor, Int> {

}