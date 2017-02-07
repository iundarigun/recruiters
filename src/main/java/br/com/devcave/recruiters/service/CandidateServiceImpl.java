package br.com.devcave.recruiters.service;

import java.io.IOException;

import br.com.devcave.recruiters.dto.CandidateForm;
import br.com.devcave.recruiters.dto.CandidateVO;
import br.com.devcave.recruiters.exception.CurriculumException;
import br.com.devcave.recruiters.exception.EmailAlreadyExistsException;
import br.com.devcave.recruiters.repository.AreaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.devcave.recruiters.domain.Candidate;
import br.com.devcave.recruiters.dto.CandidateFilter;
import br.com.devcave.recruiters.repository.CandidateRepository;

@Service
@Transactional(readOnly = true)
@Slf4j
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private AreaRepository areaRepository;

    @Override
    public Page<CandidateVO> search(CandidateFilter filterVO) {

        return candidateRepository.findByFilter(filterVO);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(CandidateForm candidateForm) {
        final Candidate candidate;

        // Validar se o email já existe
        Long count = (candidateForm.getId() == null ? //
                candidateRepository.countByEmailIgnoreCase(candidateForm.getEmail()) : //
                candidateRepository.countByEmailIgnoreCaseAndIdNot(candidateForm.getEmail(), candidateForm.getId()));
        if (count > 0) {
            throw new EmailAlreadyExistsException("O email já existe");
        }
        // Validar se precisa criar ou recuperar
        if (candidateForm.getId() == null) {
            candidate = new Candidate();
        } else {
            candidate = candidateRepository.findOne(candidateForm.getId());
        }
        try {
            candidate.update(candidateForm.getName(), candidateForm.getEmail(), candidateForm.getPhoneNumber(),
                    candidateForm.getSkypeUser(),
                    candidateForm.getCurriculum() == null ? null : candidateForm.getCurriculum().getOriginalFilename(), candidateForm.getCurriculum() == null ? null : candidateForm.getCurriculum().getBytes());
            candidateForm.getArea().forEach(a->candidate.addArea(areaRepository.findOne(a)));
        } catch (IOException e) {
            log.error("M=save, message={}",e.getMessage(), e);
            throw new CurriculumException();
        }
        candidateRepository.save(candidate);
    }
}
