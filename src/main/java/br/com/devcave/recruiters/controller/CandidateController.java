package br.com.devcave.recruiters.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/candidate")
public class CandidateController {

    private static final String CANDIDATE_DEFAULT = "/";
    private static final String CANDIDATE_SEARCH = "/search";
    private static final String CANDIDATE_NEW = "/new";

    private static final String CANDIDATE_SEARCH_RESOURCE = "candidate/search";
    private static final String CANDIDATE_NEW_RESOURCE = "candidate/new";

    @RequestMapping(value = {"", CANDIDATE_DEFAULT, CANDIDATE_SEARCH})
    public String search() throws InterruptedException {
        return CANDIDATE_SEARCH_RESOURCE;
    }

    @RequestMapping(value = CANDIDATE_NEW,method = RequestMethod.GET)
    public String getCandidateNew(){

        return CANDIDATE_NEW_RESOURCE;
    }
}
