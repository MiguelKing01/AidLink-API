package co.edu.ue.entity;

import java.sql.Date;

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
public class Peticion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_peticion", nullable = false)
    private Integer id_peticion;

    @Column(name = "nombre_peticion", nullable = false, length = 50)
    private String nombre_peticion;

    @Column(name = "desc_peticion", nullable = false, length = 100)
    private String desc_peticion;

    @Column(name = "cantidad_peticion", nullable = false)
    private int cantidad_peticion;

    @Column(name = "fecha_peticion", nullable = false)
    private Date fecha_peticion;

    @Column(name = "estado_peticion", nullable = false)
    private int estado_peticion;

    @Column(name = "direccion", nullable = true)
    private String direccion;

    @Column(name = "nequi", nullable = false)
    private String nequi;

    @ManyToOne
    @JoinColumn(name = "UsuarioId", nullable = false)
    private Usuario usuario; // ⚡ Cambiado a 'usuario'

    @Column(name = "CategoriaId", nullable = false)
    private int categoriaId;

    // Getters y setters
    public Integer getId_peticion() { return id_peticion; }
    public void setId_peticion(Integer id_peticion) { this.id_peticion = id_peticion; }

    public String getNombre_peticion() { return nombre_peticion; }
    public void setNombre_peticion(String nombre_peticion) { this.nombre_peticion = nombre_peticion; }

    public String getDesc_peticion() { return desc_peticion; }
    public void setDesc_peticion(String desc_peticion) { this.desc_peticion = desc_peticion; }

    public int getCantidad_peticion() { return cantidad_peticion; }
    public void setCantidad_peticion(int cantidad_peticion) { this.cantidad_peticion = cantidad_peticion; }

    public Date getFecha_peticion() { return fecha_peticion; }
    public void setFecha_peticion(Date fecha_peticion) { this.fecha_peticion = fecha_peticion; }

    public int getEstado_peticion() { return estado_peticion; }
    public void setEstado_peticion(int estado_peticion) { this.estado_peticion = estado_peticion; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getNequi() { return nequi; }
    public void setNequi(String nequi) { this.nequi = nequi; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public int getCategoriaId() { return categoriaId; }
    public void setCategoriaId(int categoriaId) { this.categoriaId = categoriaId; }
}
