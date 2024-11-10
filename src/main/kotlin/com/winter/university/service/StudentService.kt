package com.winter.university.service

import com.winter.university.domain.Lecture
import com.winter.university.domain.Student
import com.winter.university.repository.EnrollmentRepository
import com.winter.university.repository.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentService(
    private val studentRepository: StudentRepository,
    private val enrollmentRepository: EnrollmentRepository,
) {
    fun getAllStudents(): List<Student> {
        return studentRepository.findAll().toList()
    }

    fun getLecturesByStudentId(studentId: Int): List<Lecture> {
        return enrollmentRepository.findLecturesByStudentId(studentId)
    }
}