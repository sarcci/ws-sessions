package com.example.wsproject.Service;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.wsproject.Entity.Ispit;
import com.example.wsproject.Repo.IspitRepo;

@Service
public class IspitService {
    
    @Autowired
    private IspitRepo repo;

    public List<Ispit> listAll() {
        return (List<Ispit>) this.repo.findAll();
    }

    public void saveOrUpdate(Ispit ex) {
        repo.save(ex);
    }

    public Ispit getExById(int id) {
        return repo.findById(id).get();
    }

    public Ispit get(int id) {
        return repo.findById(id).get(); 
    }
    public List<Ispit> listAllEx(int isp) {
        return (List<Ispit>) this.repo.findByIsp_Id(isp); 
    }

    public void update (Ispit ex, int id) {
        repo.save(ex);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public List<Ispit> allExams(String studiska) {
        return StreamSupport.stream(repo.findAll().spliterator(), false)
            .filter(e -> e.getIsp().getStudiska().equals(studiska))
            .toList();
    }

}
