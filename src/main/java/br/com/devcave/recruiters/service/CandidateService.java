package br.com.devcave.recruiters.service;

import br.com.devcave.recruiters.dto.CandidateFilter;
import br.com.devcave.recruiters.dto.CandidateForm;
import br.com.devcave.recruiters.dto.CandidateVO;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

public interface CandidateService {
    Page<CandidateVO> search(CandidateFilter candidateFilter);

    CandidateForm getDetails(Long id);

    void save(CandidateForm candidateForm, MultipartFile curriculum);
}
