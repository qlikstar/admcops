package com.citrix.hackathon.common.controller;

import com.citrix.hackathon.common.model.App;
import com.citrix.hackathon.common.model.Cloud;
import com.citrix.hackathon.common.model.Control;
import com.citrix.hackathon.common.model.Instance;
import com.citrix.hackathon.common.repository.AppRepository;
import com.citrix.hackathon.common.repository.CloudRepository;
import com.citrix.hackathon.common.repository.ControlRepository;
import com.citrix.hackathon.common.repository.InstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sanketmishra on 10/8/16.
 */

@RestController
@RequestMapping("/domain")
public class DomainController {

    @Autowired
    AppRepository appRepository;

    @Autowired
    CloudRepository cloudRepository;

    @Autowired
    ControlRepository controlRepository;

    @Autowired
    InstanceRepository instanceRepository;

    @RequestMapping("/app")
    public List<App> findAllApps(){
        return appRepository.findAll();
    }

    @RequestMapping("/cloud")
    public List<Cloud> findAllClouds(){
        return cloudRepository.findAll();
    }

    @RequestMapping("/control")
    public List<Control> findAllControls(){
        return controlRepository.findAll();
    }

    @RequestMapping("/instance")
    public List<Instance> findAllInstances(){
        return instanceRepository.findAll();
    }


}
