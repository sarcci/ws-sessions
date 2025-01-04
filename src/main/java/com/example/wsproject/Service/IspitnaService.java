package com.example.wsproject.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wsproject.Entity.Ispitna;
import com.example.wsproject.Repo.IspitnaRepo;

@Service
public class IspitnaService {
    
    @Autowired
    private IspitnaRepo repo;

    public List<Ispitna> listAll() {
        return (List<Ispitna>) this.repo.findAll();
    }

    public void saveOrUpdate(Ispitna isp) {
        repo.save(isp);
    }

    public Ispitna getIspById(int id) {
        return repo.findById(id).get();
    }

    public Ispitna get(int id) {
        return repo.findById(id).get(); 
    }

    public void update (Ispitna isp, int id) {
        repo.save(isp);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public List<Ispitna> getCurrentSession() {
        LocalDate currentDate = LocalDate.now();
        List<Ispitna> allIspitna = new ArrayList<>();
        repo.findAll().forEach(allIspitna::add);
        int currentYear = currentDate.getYear();
    
        return allIspitna.stream()
                .filter(ispitna -> {
                    String sessionMonth = getSessionForDate(currentDate.getMonthValue());
                    String[] years = ispitna.getStudiska().split("/");
                    int sessionYear = Integer.parseInt(years[1]);
                    return sessionMonth.equalsIgnoreCase(ispitna.getMesec()) 
                            && sessionYear == currentYear;
                })
                .collect(Collectors.toList());
    }

    
    private String getSessionForDate(int month) {
        if (month == 9 || month == 8) {
            return "трета";
        } else if (month == 1 || month == 2) {
            return "прва";
        } else if (month == 6 && month == 7) {
            return "втора";
        }
        return "Неодредена";
    }
    

}
