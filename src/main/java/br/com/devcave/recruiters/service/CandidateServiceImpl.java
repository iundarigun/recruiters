package br.com.devcave.recruiters.service;

import java.util.List;

import br.com.devcave.recruiters.dao.CandidateDAO;
import br.com.devcave.recruiters.entity.CandidateEntity;
import br.com.devcave.recruiters.vo.CandidateFilterVO;
import br.com.devcave.recruiters.vo.CandidateSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateDAO candidateDAO;

    public List<CandidateEntity> search(CandidateFilterVO filterVO){
        return candidateDAO.findByFilter(filterVO);
    }

    @Override
    public List<CandidateEntity> search(CandidateSearchVO candidateSearchVO){
        return candidateDAO.findAll();
    }
}
