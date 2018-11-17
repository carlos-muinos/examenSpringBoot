package com.examen.springboot.repositories;

import com.examen.springboot.domain.Policies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PoliciesRepository extends CrudRepository<Policies, Integer>{
}

