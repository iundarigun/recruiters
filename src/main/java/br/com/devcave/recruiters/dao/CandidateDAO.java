package br.com.devcave.recruiters.dao;

import br.com.devcave.recruiters.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Calendar;
import java.util.List;

public interface CandidateDAO extends JpaRepository<CandidateEntity,Long> {

    List<CandidateEntity> findByName(String name);
    CandidateEntity findByEmail(String email);
    List<CandidateEntity> findTop5ByCreationDate(Calendar creationDate);
    Long countByNameLike(String partOfName);
    List<CandidateEntity> findByNameLikeOrderByCreationDateAsc(String partOfName);
}
