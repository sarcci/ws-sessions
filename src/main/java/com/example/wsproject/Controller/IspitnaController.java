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

import com.example.wsproject.Entity.Ispitna;
import com.example.wsproject.Service.IspitnaService;

@RestController
public class IspitnaController {
    @Autowired
    private IspitnaService service;

    @GetMapping("/getIsp")
    public List<Ispitna>getIsp() {
        return service.listAll();
    }

    @PostMapping(value = "/SaveIsp")
    private int saveIsp(@RequestBody Ispitna isp) {
        service.saveOrUpdate(isp);
        return isp.getID();
    }

    @RequestMapping("/Isp/{id}")
    private Ispitna getIsp(@PathVariable(name="id") int id) {
        return service.getIspById(id);
    }

    @PutMapping("/EditIsp/{id}")
    private Ispitna update(@RequestBody Ispitna isp, @PathVariable int id) {
        isp.setID(id);
        service.saveOrUpdate(isp);
        return isp;
    }

    @DeleteMapping("/DeleteIsp/{id}")
    private void delete(@PathVariable int id) {
        service.delete(id);
    }

    @GetMapping("/current")
    public List<Ispitna> getCurrentSession() {
        return service.getCurrentSession();
    }
}
