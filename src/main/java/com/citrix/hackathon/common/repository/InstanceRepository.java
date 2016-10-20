package com.citrix.hackathon.common.repository;

import com.citrix.hackathon.common.model.Instance;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sanketmishra on 10/8/16.
 */
public interface InstanceRepository extends JpaRepository<Instance, Long> {

}
