package br.com.devcave.recruiters.service;

import br.com.devcave.recruiters.entity.CandidateEntity;
import br.com.devcave.recruiters.vo.CandidateSearchVO;

import java.util.List;

public interface CandidateService {
    List<CandidateEntity> search(CandidateSearchVO candidateSearchVO);
}
