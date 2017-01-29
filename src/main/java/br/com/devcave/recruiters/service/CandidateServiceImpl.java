package br.com.devcave.recruiters.service;

import br.com.devcave.recruiters.dao.CandidateDAO;
import br.com.devcave.recruiters.entity.CandidateEntity;
import br.com.devcave.recruiters.vo.CandidateSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateDAO candidateDAO;

    @Override
    public List<CandidateEntity> search(CandidateSearchVO candidateSearchVO){
        return candidateDAO.findAll();
    }
}
