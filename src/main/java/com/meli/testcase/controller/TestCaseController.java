package com.meli.testcase.controller;

import com.meli.testcase.model.TestCaseBD;
import com.meli.testcase.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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
}
