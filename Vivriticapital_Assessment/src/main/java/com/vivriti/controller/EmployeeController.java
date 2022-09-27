package com.vivriti.controller;

import com.vivriti.entity.EmployeeEntity;
import com.vivriti.pojo.Error;
import com.vivriti.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
    EmployeeService employeeService;

    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Optional<EmployeeEntity> employeeEntityOptional) {
        System.out.println("add employee called ");
        if (employeeEntityOptional.isPresent()) {
            return new ResponseEntity<>(employeeService.addEmployee(employeeEntityOptional.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(value = "/update/{user_id}", produces = "application/json")
    public ResponseEntity<Object> updateEmployee(@PathVariable("user_id") Long userId, @RequestBody Optional<EmployeeEntity> employeeEntityOptional) {
        if (employeeEntityOptional.isPresent() && Optional.ofNullable(employeeEntityOptional.get().getFirstName()).isPresent()) {
            return new ResponseEntity<>(employeeService.updateEmployee(employeeEntityOptional.get().getFirstName(), userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Error.builder().status("failed").reason("either requestObj or firstName is null").build(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/delete", produces = "application/json")
    public ResponseEntity<Object> deleteEmployee(@RequestParam("userId") Optional<Long> userIdOptional) {
        if (userIdOptional.isPresent()) {
            employeeService.deleteEmployee(userIdOptional.get());
            Map<String,String> map = new HashMap<>();
            map.put("status","Success");
            map.put("msg","User Deleted Successfully");
            return new ResponseEntity<>( map, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Error.builder().status("failed").reason("Invalid input").build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="/get-list", produces = "application/json")
    public ResponseEntity<Object> getEmployeeList(){
        return new ResponseEntity<>(employeeService.getEmployeeList(),HttpStatus.OK);
    }
}
