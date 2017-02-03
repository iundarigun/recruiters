package br.com.devcave.recruiters.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.devcave.recruiters.domain.Candidate;
import br.com.devcave.recruiters.dto.CandidateFilter;
import br.com.devcave.recruiters.repository.CandidateRepository;

@Service
@Transactional(readOnly = true)
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidate> search(CandidateFilter filterVO) {
        return candidateRepository.findByFilter(filterVO);
    }

}
