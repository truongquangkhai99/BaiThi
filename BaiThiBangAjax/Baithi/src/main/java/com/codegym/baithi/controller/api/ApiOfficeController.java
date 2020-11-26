package com.codegym.baithi.controller.api;

import com.codegym.baithi.model.Employee;
import com.codegym.baithi.model.Office;
import com.codegym.baithi.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiOfficeController {
    @Autowired
    OfficeService officeService;

    @GetMapping("/offices/")
    public ResponseEntity<List<Office>> list(){
        List<Office> offices=officeService.findAll();
        if (offices.isEmpty()){
            return new ResponseEntity<List<Office>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Office>>(offices, HttpStatus.OK);
    }
}
