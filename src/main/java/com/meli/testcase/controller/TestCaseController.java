package com.meli.testcase.controller;

import com.meli.testcase.model.TestCaseBD;
import com.meli.testcase.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    private ITestCaseService service;

    @PostMapping("/new")
    public ResponseEntity<TestCaseBD> insert(@RequestBody TestCaseBD testCase) {
        return new ResponseEntity<>(service.insert(testCase), HttpStatus.CREATED);
    }
}
