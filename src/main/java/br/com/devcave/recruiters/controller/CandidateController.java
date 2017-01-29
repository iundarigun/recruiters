package br.com.devcave.recruiters.controller;

import br.com.devcave.recruiters.dao.CandidateDAO;
import br.com.devcave.recruiters.entity.CandidateEntity;
import br.com.devcave.recruiters.service.CandidateService;
import br.com.devcave.recruiters.vo.CandidateSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/candidate")
public class CandidateController {

    private static final String CANDIDATE_DEFAULT = "/";
    private static final String CANDIDATE_SEARCH = "/search";
    private static final String CANDIDATE_NEW = "/new";

    private static final String CANDIDATE_SEARCH_RESOURCE = "candidate/search";
    private static final String CANDIDATE_NEW_RESOURCE = "candidate/new";

    @Autowired
    private CandidateDAO candidateDAO;

    @Autowired
    private CandidateService candidateService;

    @RequestMapping(value = {"", CANDIDATE_DEFAULT, CANDIDATE_SEARCH})
    public ModelAndView search(CandidateSearchVO candidateSearchVO) {
        ModelAndView modelAndView = new ModelAndView(CANDIDATE_SEARCH_RESOURCE);
        modelAndView.addObject("list", candidateService.search(candidateSearchVO));
        return modelAndView;
    }

    @RequestMapping(value = CANDIDATE_NEW, method = RequestMethod.GET)
    public String newCandidate() {

        return CANDIDATE_NEW_RESOURCE;
    }

    @RequestMapping(value = CANDIDATE_NEW, method = RequestMethod.POST)
    public String saveCandidate(@Valid CandidateEntity candidateEntity, BindingResult result) {
        if (result.hasErrors()) {
            return CANDIDATE_NEW_RESOURCE;
        }

        candidateDAO.save(candidateEntity);

        return CANDIDATE_SEARCH_RESOURCE;
    }

}
