package com.citrix.hackathon.common.repository;

import com.citrix.hackathon.common.model.Cloud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by sanketmishra on 10/8/16.
 */
public interface CloudRepository extends JpaRepository<Cloud, Long>{

}
