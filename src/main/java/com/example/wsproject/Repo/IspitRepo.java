package com.example.wsproject.Repo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.wsproject.Entity.Ispit;
import java.util.List;

@Repository
public interface IspitRepo extends CrudRepository<Ispit, Integer> {
    List<Ispit> findByIsp_Id(int isp);
    List<Ispit> findByKol(int kol);
}
    