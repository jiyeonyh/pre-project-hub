package com.winter.university.controller

import com.winter.university.domain.Lecture
import com.winter.university.domain.Student
import com.winter.university.service.StudentService
import org.springframework.web.bind.annotation.*

@RestController
class StudentController(
    private val studentService: StudentService
) {
    @GetMapping("/students")
    fun get():List<Student>{
        return studentService.getAllStudents()
    }

    @GetMapping("/student/lectures")
    fun lecturesForStudent(@RequestParam studentId: Int): List<Lecture> {
        return studentService.getLecturesByStudentId(studentId)
    }
}