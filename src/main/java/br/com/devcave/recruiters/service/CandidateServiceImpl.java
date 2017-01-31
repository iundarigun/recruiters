package br.com.devcave.recruiters.service;

import br.com.devcave.recruiters.dao.CandidateDAO;
import br.com.devcave.recruiters.entity.CandidateEntity;
import br.com.devcave.recruiters.vo.CandidateSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateDAO candidateDAO;

    public void test(){
        candidateDAO.findAll();
        candidateDAO.save(new CandidateEntity());
        candidateDAO.save(Arrays.asList(new CandidateEntity(),new CandidateEntity()));
        candidateDAO.count();
        candidateDAO.delete(new CandidateEntity());
        candidateDAO.delete(1L);
        candidateDAO.exists(1L);
        candidateDAO.findAll(Example.of(new CandidateEntity()));
        candidateDAO.findOne(1L);
    }

    @Override
    public List<CandidateEntity> search(CandidateSearchVO candidateSearchVO){
        return candidateDAO.findAll();
    }
}
