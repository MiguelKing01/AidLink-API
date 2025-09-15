package co.edu.ue.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Peticion")
// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Peticion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_peticion", nullable = false)
    private Integer id_Peticion;

    @Column(name = "nombre_Peticion", nullable = false, length = 50)
    private String nombre_Peticion;

    @Column(name = "desc_Peticion", nullable = false, length = 100)
    private String desc_Peticion;

    @Column(name = "cantidad_Peticion", nullable = false)
    private int cantidad_Peticion;

    @Column(name = "fecha_Peticion", nullable = false)
    private Date fecha_Peticion;

    @Column(name = "estado_Peticion", nullable = false)
    private int estado_Peticion;

    @ManyToOne
    @JoinColumn(name = "UsuarioId", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "CategoriaId", nullable = false)
    private Categoria categoria;

    public Peticion() {
    }

    public Peticion(String nombre_Peticion, String desc_Peticion, int cantidad_Peticion, Date fecha_Peticion,
            int estado_Peticion, Usuario usuario, Categoria categoria) {
        this.nombre_Peticion = nombre_Peticion;
        this.desc_Peticion = desc_Peticion;
        this.cantidad_Peticion = cantidad_Peticion;
        this.fecha_Peticion = fecha_Peticion;
        this.estado_Peticion = estado_Peticion;
        this.usuario = usuario;
        this.categoria = categoria;
    }

    public Integer getId_peticion() {
        return id_Peticion;
    }

    public void setId_peticion(Integer id_peticion) {
        this.id_Peticion = id_peticion;
    }

    public String getNombre_peticion() {
        return nombre_Peticion;
    }

    public void setNombre_peticion(String nombre_Peticion) {
        this.nombre_Peticion = nombre_Peticion;
    }

    public String getDesc_peticion() {
        return desc_Peticion;
    }

    public void setDesc_peticion(String desc_Peticion) {
        this.desc_Peticion = desc_Peticion;
    }

    public int getCantidad_peticion() {
        return cantidad_Peticion;
    }

    public void setCantidad_peticion(int cantidad_Peticion) {
        this.cantidad_Peticion = cantidad_Peticion;
    }

    public Date getFecha_peticion() {
        return fecha_Peticion;
    }

    public void setFecha_peticion(Date fecha_Peticion) {
        this.fecha_Peticion = fecha_Peticion;
    }

    public int getEstado_peticion() {
        return estado_Peticion;
    }

    public void setEstado_peticion(int estado_Peticion) {
        this.estado_Peticion = estado_Peticion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
