package com.meli.testcase.repository;

import com.meli.testcase.model.TestCaseBD;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestCaseRepo extends JpaRepository<TestCaseBD, Long> {
    List<TestCaseBD> findAllByDescriptionContaining(String last_update);
}
