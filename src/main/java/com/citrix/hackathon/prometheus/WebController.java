package com.citrix.hackathon.prometheus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sanketmishra on 9/24/16.
 */


@RestController
public class WebController {

    @RequestMapping(value={"/", "index"})
    ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping("/playbook")
    ModelAndView playbook(){
        return new ModelAndView("playbook");
    }

    @RequestMapping("/blank")
    ModelAndView blank(){
        return new ModelAndView("blank");
    }

}