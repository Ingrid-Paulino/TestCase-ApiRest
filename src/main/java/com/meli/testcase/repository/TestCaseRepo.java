package com.meli.testcase.repository;

import com.meli.testcase.model.TestCaseBD;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepo extends JpaRepository<TestCaseBD, Long> {
}
