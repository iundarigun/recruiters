package br.com.devcave.recruiters.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.devcave.recruiters.repository.CandidateRepository;
import br.com.devcave.recruiters.domain.Candidate;
import br.com.devcave.recruiters.service.CandidateService;
import br.com.devcave.recruiters.dto.CandidateFilter;

@Controller
@RequestMapping("/candidate")
public class CandidateController {

    private static final String CANDIDATE_DEFAULT = "/";
    private static final String CANDIDATE_SEARCH = "/search";
    private static final String CANDIDATE_NEW = "/new";
    private static final String CANDIDATE_DETAILS = "/details";

    private static final String CANDIDATE_SEARCH_RESOURCE = "candidate/search";
    private static final String CANDIDATE_NEW_RESOURCE = "candidate/new";

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private CandidateService candidateService;

    @RequestMapping(value = { "", CANDIDATE_DEFAULT, CANDIDATE_SEARCH })
    public ModelAndView search(CandidateFilter candidateFilter) {
        ModelAndView modelAndView = new ModelAndView(CANDIDATE_SEARCH_RESOURCE);
        modelAndView.addObject("list", candidateService.search(candidateFilter));
        return modelAndView;
    }

    @RequestMapping(value = CANDIDATE_NEW, method = RequestMethod.GET)
    public String newCandidate() {

        return CANDIDATE_NEW_RESOURCE;
    }

    @RequestMapping(value = CANDIDATE_NEW, method = RequestMethod.POST)
    public String saveCandidate(@Valid Candidate candidate, BindingResult result) {
        if (result.hasErrors()) {
            return CANDIDATE_NEW_RESOURCE;
        }

        candidateRepository.save(candidate);

        return CANDIDATE_SEARCH_RESOURCE;
    }

    @RequestMapping(value = CANDIDATE_DETAILS, method = RequestMethod.GET)
    @ResponseBody
    public String getCandidate(Long id) {

        Candidate candidate = candidateRepository.getOne(id);

        return candidate.toString();
    }

}
