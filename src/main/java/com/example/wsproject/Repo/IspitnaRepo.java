package com.example.wsproject.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.wsproject.Entity.Ispitna;

@Repository
public interface IspitnaRepo extends CrudRepository<Ispitna, Integer> {

}
