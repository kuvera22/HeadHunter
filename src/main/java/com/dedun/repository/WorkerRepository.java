package com.dedun.repository;

import com.dedun.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {

     Worker getByLogin(String login);
     Worker getById(int id);

     Optional<Worker> findById(int id);
}
