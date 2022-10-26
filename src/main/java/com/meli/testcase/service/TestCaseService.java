package com.meli.testcase.service;

import com.meli.testcase.advice.exeption.NotFoundException;
import com.meli.testcase.model.TestCaseBD;
import com.meli.testcase.repository.TestCaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService {
    @Autowired
    private TestCaseRepo repo;

    @Override
    public TestCaseBD insert(TestCaseBD testCase) {
        testCase.setLast_update(LocalDateTime.now());
        return repo.save(testCase);
    }

    @Override
    public List<TestCaseBD> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<TestCaseBD> findById(Long id) throws NotFoundException {
        // TODO: pesquisar se não existe uma forma de procurar e retornar um unico valor ao emves de uma lista
        List<TestCaseBD> existTestCase = findAll().stream()
                .filter(t -> t.getId_case() == id)
                .collect(Collectors.toList());
        if(existTestCase.isEmpty())
            throw new NotFoundException("Test case not found!");

        return repo.findById(id);
    }

    @Override
    public TestCaseBD update(TestCaseBD testCase, Long id) throws NotFoundException {
        // TODO: em java nn tem função asiincrona?
        findById(id);
        testCase.setLast_update(LocalDateTime.now());
        return repo.save(testCase);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<TestCaseBD> findAll(String last_update_data) {
        return null;
    }
}
