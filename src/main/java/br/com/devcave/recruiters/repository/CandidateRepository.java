package br.com.devcave.recruiters.repository;

import br.com.devcave.recruiters.domain.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long>, CandidateRepositoryCustom {

    Candidate findByEmail(String email);

    Long countByEmailIgnoreCase(String email);

    Long countByEmailIgnoreCaseAndIdNot(String email, Long id);
}
