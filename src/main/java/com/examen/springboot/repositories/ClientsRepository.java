package com.examen.springboot.repositories;

import com.examen.springboot.domain.Clients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientsRepository  extends CrudRepository<Clients, Integer>{
}
