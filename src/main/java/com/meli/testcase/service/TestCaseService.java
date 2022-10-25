package com.meli.testcase.service;

import com.meli.testcase.model.TestCaseBD;
import com.meli.testcase.repository.TestCaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService implements ITestCaseService {
    @Autowired
    private TestCaseRepo repo;

    @Override
    public TestCaseBD insert(TestCaseBD testCase) {
        return repo.save(testCase);
    }

    @Override
    public List<TestCaseBD> findAll() {
        return null;
    }

    @Override
    public Optional<TestCaseBD> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public TestCaseBD update(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<TestCaseBD> findAll(String last_update_data) {
        return null;
    }
}
