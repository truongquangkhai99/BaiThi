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
    @Autowired
    EmployeeService employeeService;
    @Autowired
    OfficeService officeService;

    @GetMapping("/")
    public ModelAndView listPerson(Pageable pageable){
        Page<Employee> employees= employeeService.findAll(pageable);
        ModelAndView modelAndView=new ModelAndView("employees/list");
        modelAndView.addObject("employees",employees);
        return modelAndView;
    }

    @GetMapping("/delete-employee/{id}")
    public ModelAndView delete(@PathVariable long id, Pageable pageable){
        ModelAndView modelAndView=new ModelAndView("employees/delete");
        Employee employee= employeeService.findById(id);
        Page<Office> offices= officeService.findAll(pageable);
        modelAndView.addObject("employee",employee);
        return modelAndView;
    }

    @PostMapping("/delete-employee")
    public String deleteEmployee(@RequestParam long id){
        employeeService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/create-employee")
    public ModelAndView createEmployee(Pageable pageable){
        Page<Office> offices= officeService.findAll(pageable);
        ModelAndView modelAndView=new ModelAndView("employees/create");
        modelAndView.addObject("employee",new Employee());
        modelAndView.addObject("offices",offices);
        return modelAndView;
    }

    @PostMapping("/create-employee")
    public ModelAndView saveEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, Pageable pageable){
        ModelAndView modelAndView=new ModelAndView("employees/create");
        System.out.println(employee);
        Page<Office> offices= officeService.findAll(pageable);
        modelAndView.addObject("offices",offices);
        if (bindingResult.hasFieldErrors()) {
            return modelAndView;
        }
        employee= employeeService.save(employee);
        modelAndView.addObject("employee",new Employee());
        modelAndView.addObject("message","Created employee!!");
        return modelAndView;
    }

    @GetMapping("/edit-employee/{id}")
    public ModelAndView editEmployee(@PathVariable long id, Pageable pageable){
        ModelAndView modelAndView=new ModelAndView("employees/edit");
        Employee employee= employeeService.findById(id);
        Page<Office> offices= officeService.findAll(pageable);
        modelAndView.addObject("employee",employee);
        modelAndView.addObject("offices",offices);
        return modelAndView;
    }

    @PostMapping("/update-employee")
    public ModelAndView updateEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, Pageable pageable){
        ModelAndView modelAndView=new ModelAndView("employees/edit");
        Page<Office> offices= officeService.findAll(pageable);
        modelAndView.addObject("offices",offices);
        if (bindingResult.hasFieldErrors()) {
            return modelAndView;
        }
        employee= employeeService.save(employee);
        modelAndView.addObject("employee",employee);
        modelAndView.addObject("message","Updated employee!!");
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView editEmployee(@RequestParam String search, Pageable pageable){
        Page<Employee> employees= employeeService.findAllByNameContaining(search,pageable);
        ModelAndView modelAndView=new ModelAndView("employees/list");
        modelAndView.addObject("employees",employees);
        return modelAndView;
    }



}
