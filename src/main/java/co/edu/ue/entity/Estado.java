package co.edu.ue.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estado")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Estado", nullable = false)
    private int id_Estado;

    @Column(name = "nombre_Estado", nullable = false, length = 15)
    private String nombre_Estado;

    public Estado(){}

    public Estado(String nombre_Estado){
        this.nombre_Estado = nombre_Estado;
    }

    public int getId_Estado() {
        return id_Estado;
    }

    public void setId_Estado(int id_Estado) {
        this.id_Estado = id_Estado;
    }

    public String getNombre_Estado() {
        return nombre_Estado;
    }

    public void setNombre_Estado(String nombre_Estado) {
        this.nombre_Estado = nombre_Estado;
    }
    
}
