package indi.yuluo.rest.controller;

import indi.yuluo.rest.bean.Employee;
import indi.yuluo.rest.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * @author: yuluo
 * @FileName: EmployeeController.java
 * @createTime: 2022/3/31 16:36
 * @Description:
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model) {

        Collection<Employee> employeeLists = employeeDao.getAll();
        model.addAttribute("employeeList", employeeLists);

        return "employee_list";
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id) {

        employeeDao.delete(id);

        // 重定向到list页面
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addEmployee(Employee employee) {
        employeeDao.save(employee);

        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable("id") Integer id, Model model) {

        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);

        return "employee_update";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee) {

        employeeDao.save(employee);

        return "redirect:/employee";

    }

}
