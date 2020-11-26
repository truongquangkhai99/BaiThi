package com.codegym.baithi.controller;

import com.codegym.baithi.model.Employee;
import com.codegym.baithi.model.Office;
import com.codegym.baithi.service.EmployeeService;
import com.codegym.baithi.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@RequestMapping("/")
public class EmployeeController {

    @GetMapping("/")
    public ModelAndView list(Pageable pageable){
        ModelAndView modelAndView=new ModelAndView("employees/list");
        return modelAndView;
    }

}
