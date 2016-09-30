package com.citrix.hackathon.ansible;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.List;

/**
 * Created by sanketmishra on 9/26/16.
 */

@RestController
@RequestMapping("/deployment")
public class DeploymentController {

    @Autowired
    PlaybookService playbookService;

    @RequestMapping("/playbooks")
    List<Playbook> getAllPlaybooks(){
        return  playbookService.getAllPlaybooksFromDirectory();
    }

    @RequestMapping("/demo")
    Boolean runDemoPlaybook(){
        return playbookService.triggerPlaybook();
    }

    @RequestMapping("/logs")
    String getPlaybookLogs(){
        return playbookService.getPlaybookLogs();
    }

}
