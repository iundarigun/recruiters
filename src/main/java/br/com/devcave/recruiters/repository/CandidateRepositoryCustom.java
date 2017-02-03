package br.com.devcave.recruiters.repository;

import java.util.List;

import br.com.devcave.recruiters.domain.Candidate;
import br.com.devcave.recruiters.dto.CandidateFilter;

public interface CandidateRepositoryCustom {

    List<Candidate> findByFilter (CandidateFilter filterVO);

}
