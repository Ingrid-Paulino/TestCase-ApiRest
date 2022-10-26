package com.meli.testcase.service;

import com.meli.testcase.advice.exeption.NotFoundException;
import com.meli.testcase.model.TestCaseBD;

import java.util.List;
import java.util.Optional;

public interface ITestCaseService {
    TestCaseBD insert(TestCaseBD testCase);
    List<TestCaseBD> findAll();
    Optional<TestCaseBD> findById(Long id) throws NotFoundException;
    TestCaseBD update(TestCaseBD testCase, Long id) throws NotFoundException;
    void delete(Long id);
    List<TestCaseBD> findAll(String last_update_data)
;}
