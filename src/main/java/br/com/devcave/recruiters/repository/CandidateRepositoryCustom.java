package br.com.devcave.recruiters.repository;

import br.com.devcave.recruiters.dto.CandidateFilter;
import br.com.devcave.recruiters.dto.CandidateVO;
import org.springframework.data.domain.Page;

public interface CandidateRepositoryCustom {

    Page<CandidateVO> findByFilter (CandidateFilter filterVO);

}
