package com.jcpdev.PiholeDbEndpoint.Models.Repos;


import com.jcpdev.PiholeDbEndpoint.Models.queries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface queriesRepo extends JpaRepository<queries, Integer> {


}
