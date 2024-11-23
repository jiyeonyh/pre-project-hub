package com.winter.university.service

import com.winter.university.domain.Enrollment
import com.winter.university.domain.Lecture
import com.winter.university.repository.LectureRepository
import com.winter.university.repository.ProfessorRepository
import org.springframework.stereotype.Service

@Service
class LectureService(
    private val lectureRepository: LectureRepository,
    private val professorRepository: ProfessorRepository,
) {
    fun getLectureListForProfessor(professorId: Int): List<Lecture> {
        val professor = professorRepository.findById(professorId)
            .orElseThrow { IllegalArgumentException("등록되지 않은 교수 아이디 : $professorId") }

        return lectureRepository.getLecturesByProfessorId(professorId)
    }

    fun updateLectureProfessor(lectureId: Int, professorId: Int){
        val lecture = lectureRepository.findById(lectureId)
            .orElseThrow{ IllegalArgumentException("존재하지 않는 강의 id : $lectureId")}

        val professor = professorRepository.findById(professorId)
            .orElseThrow{ IllegalArgumentException("존재하지 않는 교수 id : $professorId") }

        lecture.professor = professor
        lectureRepository.save(lecture)
    }
}