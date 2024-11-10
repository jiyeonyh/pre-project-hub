package com.winter.university.service

import com.winter.university.domain.Enrollment
import com.winter.university.repository.EnrollmentRepository
import com.winter.university.repository.LectureRepository
import com.winter.university.repository.StudentRepository
import org.springframework.stereotype.Service

@Service
class EnrollmentService(
    private val enrollmentRepository: EnrollmentRepository,
    private val studentRepository: StudentRepository,
    private val lectureRepository: LectureRepository
) {
    fun enrollStudentInLecture(studentId: Int, lectureId:Int) {
        val student = studentRepository.findById(studentId)
            .orElseThrow { IllegalArgumentException("등록되지 않은 학생 아이디 : $studentId") }

        val lecture = lectureRepository.findById(lectureId)
            .orElseThrow { IllegalArgumentException("등록되지 않은 강의 아이디 : $lectureId") }

        if (!enrollmentRepository.existsByStudentIdAndLectureId(studentId, lectureId)) {
            val enrollment = Enrollment(studentId = studentId, lectureId = lectureId)
            enrollmentRepository.save(enrollment)
        }else{
            throw IllegalStateException("이미 수강신청 내역이 존재합니다.")
        }
    }

    fun deleteEnrollment(studentId: Int, lectureId: Int) {
        if (enrollmentRepository.existsByStudentIdAndLectureId(studentId, lectureId)) {
            enrollmentRepository.deleteEnrollmentByStudentIdAndLectureId(studentId, lectureId)
        }else{
            throw IllegalArgumentException("삭제할 수강신청 내역이 존재하지않습니다.")
        }
    }

}