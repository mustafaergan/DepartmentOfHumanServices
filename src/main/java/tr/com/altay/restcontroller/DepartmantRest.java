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
import tr.com.altay.Entity.Departmant;
import tr.com.altay.service.interfaces.DepartmantService;

import java.util.List;

/**
 * Created by mustafa.ergan on 25.02.2017.
 */
@RestController
public class DepartmantRest {

    @Autowired
    @Qualifier("departmantServiceImp")
    DepartmantService service;

    Gson gson = new Gson();

    @RequestMapping(value = "/info/", method = RequestMethod.GET,headers="Accept=application/json")
    public ResponseEntity getInfo() {
        return new ResponseEntity(gson.toJson("DepartmantService"), HttpStatus.OK);
    }

    @RequestMapping(value = "/departmant/", method = RequestMethod.GET,headers="Accept=application/json")
    public ResponseEntity getDepartmantByAll() {
        List<Departmant> departmants =  service.findAll();
        return new ResponseEntity(gson.toJson(departmants), HttpStatus.OK);
    }

    @RequestMapping(value = "/departmant/{id}", method = RequestMethod.GET,headers="Accept=application/json")
    public ResponseEntity getDepartmantById(@PathVariable("id") int id) {
        Departmant departmant =  null;
        return new ResponseEntity(gson.toJson(departmant), HttpStatus.OK);
    }

}
