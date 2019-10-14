package com.dedun.repository;

import com.dedun.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {

    Employer getByLogin(String login);
    Employer getById(int id);

    Optional<Employer> findById(int id);
}
