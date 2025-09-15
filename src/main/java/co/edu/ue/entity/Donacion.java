package co.edu.ue.entity;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "Donacion")
public class Donacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Donacion", nullable = false)
    private int id_Donacion;

    @Column(name = "desc_Donacion", length = 100)
    private String desc_Donacion;

    @Column(name = "cantidad_Donacion", nullable = false)
    private int cantidad_Donacion;

    @Column(name = "fecha_Donacion", nullable = false)
    private LocalDate fecha_Donacion;

    @Column(name = "estado_Donacion", nullable = false)
    private int estado_Donacion;

    @ManyToOne
    @JoinColumn(name = "UsuarioId", nullable = false)
    private Usuario usuarioId;

    @ManyToOne
    @JoinColumn(name = "CategoriaId", nullable = false)
    private Categoria categoriaId;

    @ManyToOne
    @JoinColumn(name = "PeticionId", nullable = false)
    private Peticion peticionId;

    public Donacion() {}

    public Donacion(String desc_Donacion, int cantidad_Donacion, LocalDate fecha_Donacion,
        int estado_Donacion, Usuario usuarioId, Categoria categoriaId, Peticion peticionId) {
        this.desc_Donacion = desc_Donacion;
        this.cantidad_Donacion = cantidad_Donacion;
        this.fecha_Donacion = fecha_Donacion;
        this.estado_Donacion = estado_Donacion;
        this.usuarioId = usuarioId;
        this.categoriaId = categoriaId;
        this.peticionId = peticionId;
    }

    public int getId_Donacion() {
        return id_Donacion;
    }

    public void setId_Donacion(int id_Donacion) {
        this.id_Donacion = id_Donacion;
    }

    public String getDesc_Donacion() {
        return desc_Donacion;
    }

    public void setDesc_Donacion(String desc_Donacion) {
        this.desc_Donacion = desc_Donacion;
    }

    public int getCantidad_Donacion() {
        return cantidad_Donacion;
    }

    public void setCantidad_Donacion(int cantidad_Donacion) {
        this.cantidad_Donacion = cantidad_Donacion;
    }

    public LocalDate getFecha_Donacion() {
        return fecha_Donacion;
    }

    public void setFecha_Donacion(LocalDate fecha_Donacion) {
        this.fecha_Donacion = fecha_Donacion;
    }

    public int getEstado_Donacion() {
        return estado_Donacion;
    }

    public void setEstado_Donacion(int estado_Donacion) {
        this.estado_Donacion = estado_Donacion;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Categoria getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Categoria categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Peticion getPeticionId() {
        return peticionId;
    }

    public void setPeticionId(Peticion peticionId) {
        this.peticionId = peticionId;
    }
}
