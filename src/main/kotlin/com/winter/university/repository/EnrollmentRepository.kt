package com.winter.university.repository

import com.winter.university.domain.Enrollment
import com.winter.university.domain.Lecture
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface EnrollmentRepository : CrudRepository<Enrollment, Int> {

    @Query("SELECT e.lecture FROM Enrollment e WHERE e.student.id = :studentId")
    fun findLecturesByStudentId(@Param("studentId") studentId: Int): List<Lecture>

    fun existsByStudentIdAndLectureId(studentId: Int, lectureId: Int): Boolean

    fun deleteEnrollmentByStudentIdAndLectureId(studentId: Int, lectureId: Int)
}