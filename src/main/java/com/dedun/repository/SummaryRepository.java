package com.dedun.repository;

import com.dedun.model.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SummaryRepository extends JpaRepository<Summary, Integer> {

    Optional<Summary> findById(int id);
    Summary getById(int id);
    Optional<Summary> findByWorkerId(int id);

}
