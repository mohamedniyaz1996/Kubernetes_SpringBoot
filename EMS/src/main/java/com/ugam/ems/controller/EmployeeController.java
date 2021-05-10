package com.ugam.ems.controller;

import com.ugam.ems.entity.Employee;
import com.ugam.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/getEmp", method = RequestMethod.GET)
    public String getEmployeesByID(@ModelAttribute(name = "listEmp") Employee listEmp, Model model) {
        Optional<Employee> employee = employeeService.findById(listEmp.getEmp_id());
        if (employee.isPresent()) {
            model.addAttribute("employees", employee.get());
            return "listemployees";
        } else {
            model.addAttribute("InvalidCredential", true);
            return "input";
        }
    }

    @RequestMapping(value = "/getEmpName", method = RequestMethod.GET)
    public String getEmployeesByName(@ModelAttribute(name = "listEmpName") Employee listEmpName, Model model) {
        Optional<List<Employee>> employee = employeeService.findByName(listEmpName.getName());
        if (!employee.get().isEmpty()) {
            model.addAttribute("employees", employee.get());
            return "listemployees";
        } else {
            model.addAttribute("InvalidCredential", true);
            return "input";
        }
    }


}
