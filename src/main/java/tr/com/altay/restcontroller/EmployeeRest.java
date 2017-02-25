package tr.com.altay.restcontroller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tr.com.altay.Entity.Employee;
import tr.com.altay.service.interfaces.EmployeeService;

import java.util.List;

/**
 * Created by mustafa.ergan on 25.02.2017.
 */
@RestController
public class EmployeeRest {

    @Autowired
    @Qualifier("employeeServiceImp")
    EmployeeService service;

    Gson gson = new Gson();

    @RequestMapping(value = "/employee/", method = RequestMethod.GET,headers="Accept=application/json")
    public ResponseEntity getEmployeeByAll() {
        List<Employee> employees =  service.findAll();
        return new ResponseEntity(gson.toJson(employees), HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET,headers="Accept=application/json")
    public ResponseEntity getEmployeeById(@PathVariable("id") int id) {
        Employee employee = null;
        return new ResponseEntity(gson.toJson(employee), HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/departmant/{id}", method = RequestMethod.GET,headers="Accept=application/json")
    public ResponseEntity getEmployeeByDepartmant(@PathVariable("id") int departmantId) {
        List<Employee> employees =  service.findByDepartmant(departmantId);
        return new ResponseEntity(gson.toJson(employees), HttpStatus.OK);
    }


}
