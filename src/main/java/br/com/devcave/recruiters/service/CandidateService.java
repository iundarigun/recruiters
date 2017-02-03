package br.com.devcave.recruiters.service;

import java.util.List;

import br.com.devcave.recruiters.entity.CandidateEntity;
import br.com.devcave.recruiters.vo.CandidateFilter;

public interface CandidateService {
    List<CandidateEntity> search(CandidateFilter candidateFilter);
}
