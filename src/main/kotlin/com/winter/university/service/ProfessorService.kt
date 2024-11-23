package com.winter.university.service

import com.winter.university.domain.Lecture
import com.winter.university.domain.Professor
import com.winter.university.repository.LectureRepository
import com.winter.university.repository.ProfessorRepository
import org.springframework.stereotype.Service

@Service
class ProfessorService(
    private val professorRepository: ProfessorRepository,
    private val lectureRepository: LectureRepository,
) {
    fun getLecturesByProfessorId(professorId: Int): List<Lecture> {
        return lectureRepository.getLecturesByProfessorId(professorId)
    }
}