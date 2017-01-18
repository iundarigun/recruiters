package br.com.devcave.recruiters.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.devcave.recruiters.common.RecruitersUtil;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {

        // Testando modulo
        System.out.println(RecruitersUtil.helloworld("Oriol"));

        return "homepage";
    }

}
