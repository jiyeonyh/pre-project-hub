package com.winter.university.repository

import com.winter.university.domain.Lecture
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface LectureRepository : CrudRepository<Lecture, Int> {

    @Query("SELECT l FROM Lecture l WHERE l.professor.id = :professorId")
    fun getLecturesByProfessorId(@Param("professorId") professorId: Int): List<Lecture>

}