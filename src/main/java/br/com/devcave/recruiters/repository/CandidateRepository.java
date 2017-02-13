package br.com.devcave.recruiters.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devcave.recruiters.domain.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long>, CandidateRepositoryCustom {

    Candidate findByEmail(String email);

    Long countByEmailIgnoreCase(String email);

    Long countByEmailIgnoreCaseAndIdNot(String email, Long id);
}
