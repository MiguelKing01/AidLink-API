package co.edu.ue.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Categoria", nullable = false)
    private int id_Categoria;

    @Column(name = "desc_Categoria", length = 50)
    private String desc_Categoria;

    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;

    public Categoria(){}

    public Categoria(String desc_Categoria, String tipo){
        this.desc_Categoria = desc_Categoria;
        this.tipo = tipo;
    }

    public int getId_Categoria() {
        return id_Categoria;
    }

    public void setId_Categoria(int id_Categoria) {
        this.id_Categoria = id_Categoria;
    }

    public String getDesc_Categoria() {
        return desc_Categoria;
    }

    public void setDesc_Categoria(String desc_Categoria) {
        this.desc_Categoria = desc_Categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    


}
