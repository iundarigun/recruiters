package br.com.devcave.recruiters.service;

import br.com.devcave.recruiters.domain.Candidate;
import br.com.devcave.recruiters.dto.AreaVO;
import br.com.devcave.recruiters.dto.CandidateFilter;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface AreaService {
    @Cacheable("areas")
    List<AreaVO> findAll();
}
