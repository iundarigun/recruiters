package br.com.devcave.recruiters.service;

import java.util.List;

import br.com.devcave.recruiters.domain.Candidate;
import br.com.devcave.recruiters.dto.CandidateFilter;

public interface CandidateService {
    List<Candidate> search(CandidateFilter candidateFilter);
}
