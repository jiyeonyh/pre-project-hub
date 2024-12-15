package com.winter.university.controller

import com.winter.university.controller.reponse.BaseResponse
import com.winter.university.domain.Lecture
import com.winter.university.domain.Student
import com.winter.university.service.StudentService
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@RestController
@RequestMapping("/student")
class StudentController(
    private val studentService: StudentService
) {
    @GetMapping("/students")
    fun get():BaseResponse<List<Student>>{
        val result = studentService.getAllStudents()
        return BaseResponse.success(result)
    }

    @GetMapping("/lectures")
    fun lecturesForStudent(@RequestParam studentId: Int): BaseResponse<List<Lecture>>{
        val result = studentService.getLecturesByStudentId(studentId)
        return BaseResponse.success(result)
    }
}