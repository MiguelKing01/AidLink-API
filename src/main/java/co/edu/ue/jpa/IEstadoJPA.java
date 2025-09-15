package co.edu.ue.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Estado;

public interface IEstadoJPA extends JpaRepository<Estado, Integer>{
    
}
