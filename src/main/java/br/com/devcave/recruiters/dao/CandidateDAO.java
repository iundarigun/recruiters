package br.com.devcave.recruiters.dao;

import br.com.devcave.recruiters.entity.AreaEntity;
import br.com.devcave.recruiters.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateDAO extends JpaRepository<CandidateEntity,Long> {
}
