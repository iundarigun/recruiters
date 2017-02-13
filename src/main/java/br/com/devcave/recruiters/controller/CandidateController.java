package br.com.devcave.recruiters.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.devcave.recruiters.dto.CandidateFilter;
import br.com.devcave.recruiters.dto.CandidateForm;
import br.com.devcave.recruiters.exception.RecruitersGenericException;
import br.com.devcave.recruiters.service.AreaService;
import br.com.devcave.recruiters.service.CandidateService;

@Controller
@RequestMapping(CandidateController.CANDIDATE_BASE)
public class CandidateController extends BaseController {

    protected static final String CANDIDATE_BASE = "/candidate";
    private static final String CANDIDATE_DEFAULT = "/";
    private static final String CANDIDATE_SEARCH = "/search";
    private static final String CANDIDATE_NEW = "/new";
    private static final String CANDIDATE_DETAILS = "/details";

    private static final String CANDIDATE_SEARCH_RESOURCE = "candidate/search";
    private static final String CANDIDATE_NEW_RESOURCE = "candidate/new";

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private CacheManager cacheManager;

    @RequestMapping(value = { "", CANDIDATE_DEFAULT, CANDIDATE_SEARCH }, method = RequestMethod.GET)
    public ModelAndView search(CandidateFilter candidateFilter, Boolean search) {
        ModelAndView modelAndView = new ModelAndView(CANDIDATE_SEARCH_RESOURCE);
        modelAndView.addObject("areaList", areaService.findAll());

        if (Boolean.TRUE.equals(search)) {
            modelAndView.addObject("resultList", candidateService.search(candidateFilter));
        }

        return modelAndView;
    }

    @RequestMapping(value = CANDIDATE_NEW, method = RequestMethod.GET)
    public ModelAndView newCandidate(CandidateForm candidateForm) {
        ModelAndView modelAndView = new ModelAndView(CANDIDATE_NEW_RESOURCE);
        modelAndView.addObject("areaList", areaService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = CANDIDATE_NEW, method = RequestMethod.POST)
    public ModelAndView saveCandidate(MultipartFile curriculum, @Valid CandidateForm candidateForm,
            BindingResult result,
            HttpServletRequest request, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            List<String> errorList = new ArrayList<>();
            result.getAllErrors().forEach(e -> errorList.add(e.getDefaultMessage()));
            request.setAttribute(ERROR_MESSAGES, errorList);
            return newCandidate(candidateForm);
        }
        try {
            candidateService.save(candidateForm, curriculum);
        } catch (RecruitersGenericException e) {
            request.setAttribute(ERROR_MESSAGES, Collections.singletonList(e.getMessage()));
            return newCandidate(candidateForm);
        }

        redirectAttributes.addFlashAttribute(SUCCESS_MESSAGE, getMessage("recruiters.candidate.new.success"));

        return new ModelAndView("redirect:" + CANDIDATE_BASE + CANDIDATE_SEARCH);
    }

}
