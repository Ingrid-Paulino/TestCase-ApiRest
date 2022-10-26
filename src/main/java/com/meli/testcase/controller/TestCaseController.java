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
    } // http://localhost:8080/api/testcases/new

    @GetMapping
    public ResponseEntity<List<TestCaseBD>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    } // http://localhost:8080/api/testcases

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TestCaseBD>> findById(@PathVariable long id) throws NotFoundException {
        Optional<TestCaseBD> optionalTestCase = service.findById(id);
        return new ResponseEntity<>(optionalTestCase, HttpStatus.OK);
    } //http://localhost:8080/api/testcases/1

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseBD> update(@PathVariable(value="id") Long id,
                                         @RequestBody TestCaseBD testCase)  throws NotFoundException {
        TestCaseBD TestCaseUpdated = service.update(testCase, id);
        return new ResponseEntity<>(TestCaseUpdated, HttpStatus.OK);
    } // http://localhost:8080/api/testcases/1

    @PatchMapping("/{id}")
    public ResponseEntity<TestCaseBD> updateTestedPassedAndNumberOfTries(@RequestBody TestCaseBD testCaseUpdate,
                                                                         @PathVariable Long id) throws NotFoundException {
        TestCaseBD testCaseupdated = service.updateTestedPassedAndNumberOfTries(testCaseUpdate, id);
        return new ResponseEntity<>(testCaseupdated, HttpStatus.OK);
    } // http://localhost:8080/api/testcases/2

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value="id") Long id) throws NotFoundException {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } // http://localhost:8080/api/testcases/1

    @PutMapping
    public ResponseEntity<List<TestCaseBD>> getAllByLastUpdateData(@RequestParam String last_update,
                                                                   @RequestBody TestCaseBD testCase) {
        List<TestCaseBD> lastUpdateData = service.getAllByLastUpdateData(last_update);
        return new ResponseEntity<>(lastUpdateData, HttpStatus.OK);
    }  // http://localhost:8080/api/testcases?last_update="2017-11-27T18:13:24"

    @DeleteMapping
    public ResponseEntity<String> deleteAll() {
        return new ResponseEntity<>(service.deleteAll(),HttpStatus.NO_CONTENT);
    } // http://localhost:8080/api/testcases
}
