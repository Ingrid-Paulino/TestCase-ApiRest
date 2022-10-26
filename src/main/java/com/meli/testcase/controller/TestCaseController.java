package com.meli.testcase.controller;

import com.meli.testcase.advice.exeption.NotFoundException;
import com.meli.testcase.model.TestCaseBD;
import com.meli.testcase.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    private ITestCaseService service;

    @PostMapping("/new")
    public ResponseEntity<TestCaseBD> insert(@RequestBody TestCaseBD testCase) {
        return new ResponseEntity<>(service.insert(testCase), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TestCaseBD>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TestCaseBD>> findById(@PathVariable long id) throws NotFoundException {
        Optional<TestCaseBD> optionalTestCase = service.findById(id);
        return new ResponseEntity<>(optionalTestCase, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseBD> update(@PathVariable(value="id") Long id,
                                         @RequestBody TestCaseBD testCase)  throws NotFoundException {
        TestCaseBD TestCaseUpdated = service.update(testCase, id);
        return new ResponseEntity<>(TestCaseUpdated, HttpStatus.OK);
    }

    // TODO: Implementar atualizaçaõ com o patch
}
