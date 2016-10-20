package com.citrix.hackathon.common.repository;

import com.citrix.hackathon.common.model.App;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sanketmishra on 10/8/16.
 */
public interface AppRepository extends JpaRepository<App, Long> {

    App findByAppName(String appName);
    App findById (Long id);

}
