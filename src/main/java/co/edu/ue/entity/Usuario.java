package co.edu.ue.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private int id_usuario;

    @Column(name = "nombre_user", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido_user", nullable = false, length = 50)
    private String apellido;

    @Column(name = "correo_user", nullable = false, length = 50)
    private String correo;

    @Column(name = "contrasena_user", nullable = false, length = 50)
    private String contrasena;

    @Column(name = "estado_user", nullable = false)
    private int estado;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String correo, String contrasena, int estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.estado = estado;
    }

    public int getId() {
        return id_usuario;
    }

    public void setId(int id) {
        this.id_usuario = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
