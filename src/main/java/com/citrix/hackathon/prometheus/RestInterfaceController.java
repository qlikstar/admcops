package com.citrix.hackathon.prometheus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

/**
 * Created by sanketmishra on 9/24/16.
 */

@RestController
@RequestMapping("/monitor")
public class RestInterfaceController {


    @Value("${prometheus.server.url}")
    private String PROMETHEUS_SERVER_URL;

    @RequestMapping("/{metric}")
    Object returnObjectFromPrometheus( @PathVariable("metric") String metricName ){
        RestTemplate restTemplate = new RestTemplate();
        long now = Instant.now().getEpochSecond();
        long past = now-90L;
        int step = 5;

        String url = String.format("%s/api/v1/query_range?query=%s&start=%d&end=%d&step=%d",
                PROMETHEUS_SERVER_URL, metricName ,past,now, step);
        System.out.println(url);

        return restTemplate.getForObject(url, Object.class);

    }


}
