package br.com.devcave.recruiters.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devcave.recruiters.domain.Candidate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CandidateRepository extends JpaRepository<Candidate, Long>, CandidateRepositoryCustom {

    Candidate findByEmail(String email);

    Long countByEmailIgnoreCase(String email);

    Long countByEmailIgnoreCaseAndIdNot(String email, Long id);

    @Query("SELECT c.curriculum FROM Candidate c WHERE c.id = :id ")
    byte[] getCurriculumById(@Param("id") Long id);
}
