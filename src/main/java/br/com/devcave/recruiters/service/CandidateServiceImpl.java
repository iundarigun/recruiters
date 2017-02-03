package br.com.devcave.recruiters.service;

import java.util.List;

import br.com.devcave.recruiters.dao.CandidateDAO;
import br.com.devcave.recruiters.entity.CandidateEntity;
import br.com.devcave.recruiters.vo.CandidateFilter;
import br.com.devcave.recruiters.vo.CandidateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateDAO candidateDAO;

    public List<CandidateEntity> search(CandidateFilter filterVO){
        return candidateDAO.findByFilter(filterVO);
    }

    @Override
    public List<CandidateEntity> search(CandidateVO candidateVO){
        return candidateDAO.findAll();
    }
}
