package br.com.devcave.recruiters.dao;

import java.util.List;

import br.com.devcave.recruiters.entity.CandidateEntity;
import br.com.devcave.recruiters.vo.CandidateFilter;

public interface CandidateDAOCustom {

    List<CandidateEntity> findByFilter (CandidateFilter filterVO);

}
