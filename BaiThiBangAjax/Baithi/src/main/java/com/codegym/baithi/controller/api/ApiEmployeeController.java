package com.codegym.baithi.controller.api;

import com.codegym.baithi.model.Employee;
import com.codegym.baithi.model.message.MessageNotification;
import com.codegym.baithi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiEmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees/")
    public ResponseEntity<List<Employee>> list( ){
        List<Employee> employees=employeeService.findAll();
        if (employees.isEmpty()){
            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getById(@PathVariable long id){
        Employee employee=employeeService.findById(id);
        if (employee==null){
            return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> delete(@PathVariable long id){
        Employee employee=employeeService.delete(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

//    @RequestMapping(value = "/employee/",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Employee> save(@RequestBody Employee employee){
//        employeeService.save(employee);
//        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/employee/",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Employee> update(@RequestBody Employee employee){
//        employeeService.save(employee);
//        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
//    }

//    Validate Back End

    @PutMapping(value = "/employee/")
    @ResponseBody
    public ResponseEntity<Object> getBlogById(@Validated Employee employee, BindingResult bindingResult) {
        return validate(employee,bindingResult);

    }
    @RequestMapping(value = "/employee/",produces = MediaType.APPLICATION_JSON_VALUE,method =RequestMethod.POST)
    public ResponseEntity<Object> create(@Valid @RequestBody Employee employee, BindingResult bindingResult) {
        return validate(employee,bindingResult);
    }
    @RequestMapping(value = "/employee/",produces = MediaType.APPLICATION_JSON_VALUE,method =RequestMethod.PUT)
    public ResponseEntity<Object> edit(@Valid @RequestBody Employee employee, BindingResult bindingResult) {
        return validate(employee,bindingResult);
    }

    public ResponseEntity<Object> validate(Employee employee , BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            List<String> fieldString = new ArrayList<>();
            for (FieldError e: fieldErrors) {
                fieldString.add(e.getField()+": " +e.getDefaultMessage());
            }
            MessageNotification messageNotification = new MessageNotification();
            messageNotification.setCode(-2);
            messageNotification.setStringListMessage(fieldString);
            return new ResponseEntity<Object>(messageNotification,HttpStatus.OK);
        }else {
            employeeService.save(employee);
            MessageNotification messageNotification = new MessageNotification();
            messageNotification.setCode(2);
            messageNotification.setObject(employee);
            return new ResponseEntity<Object>(messageNotification, HttpStatus.OK);
        }
    }


}
