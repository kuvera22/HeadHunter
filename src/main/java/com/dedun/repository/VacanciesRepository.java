package com.dedun.repository;

import com.dedun.model.Vacancies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VacanciesRepository extends JpaRepository<Vacancies, Integer> {

    Optional<Vacancies> findById(int id);

    Vacancies getById(int id);

    Optional<Vacancies> findByEmployerId(int id);

    Optional<Vacancies> findAllByEmployerId(int id);

}
