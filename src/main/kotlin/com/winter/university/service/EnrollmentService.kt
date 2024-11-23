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
    private val lectureRepository: LectureRepository,
) {
    fun enrollStudentInLecture(studentId: Int, lectureId:Int) {
        studentRepository.findById(studentId)
            .orElseThrow { IllegalArgumentException("등록되지 않은 학생 아이디 : $studentId") }

        lectureRepository.findById(lectureId)
            .orElseThrow { IllegalArgumentException("등록되지 않은 강의 아이디 : $lectureId")
        }

        enrollmentRepository.existsByStudentIdAndLectureId(studentId, lectureId).takeUnless { it }?.let {
            val enrollment = Enrollment(studentId = studentId, lectureId = lectureId)
            enrollmentRepository.save(enrollment)
        } ?: throw IllegalStateException("이미 수강신청 내역이 존재합니다.")
    }

    fun deleteEnrollment(studentId: Int, lectureId: Int) {
        enrollmentRepository.existsByStudentIdAndLectureId(studentId, lectureId).takeUnless { it }?.let {
            enrollmentRepository.deleteEnrollmentByStudentIdAndLectureId(studentId, lectureId)
        } ?: throw IllegalStateException("삭제할 수강신청 내역이 존재하지않습니다.")
    }

}