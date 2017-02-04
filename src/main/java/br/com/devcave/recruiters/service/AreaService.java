package br.com.devcave.recruiters.service;

import br.com.devcave.recruiters.domain.Candidate;
import br.com.devcave.recruiters.dto.AreaVO;
import br.com.devcave.recruiters.dto.CandidateFilter;

import java.util.List;

public interface AreaService {
    List<AreaVO> findAll();
}
