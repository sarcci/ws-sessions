package com.example.wsproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wsproject.Entity.Ispit;
import com.example.wsproject.Service.IspitService;

@RestController
public class IspitController {
    @Autowired
    private IspitService service;

    @GetMapping("/getEx")
    public List<Ispit>getEx() {
        return service.listAll();
    }
    @GetMapping("/GetAllEx/{isp}")
    public List<Ispit> getIspits(@PathVariable int isp) {
        return service.listAllEx(isp);
    }

    @PostMapping(value = "/SaveEx")
    private int saveIsp(@RequestBody Ispit ex) {
        service.saveOrUpdate(ex);
        return ex.getId();
    }

    @RequestMapping("/Ex/{id}")
    private Ispit getIsp(@PathVariable(name="id") int id) {
        return service.getExById(id);
    }

    @PutMapping("/EditEx/{id}")
    private Ispit update(@RequestBody Ispit ex, @PathVariable int id) {
        ex.setId(id);
        service.saveOrUpdate(ex);
        return ex;
    }

    @DeleteMapping("/DeleteEx/{id}")
    private void delete(@PathVariable int id) {
        service.delete(id);
    }

    @GetMapping("/allExams/{studiska}")
    public List<Ispit> allExams(@PathVariable String studiska) { 
        studiska = studiska.replace("-", "/");
        return service.allExams(studiska);
    }

}
