package co.edu.ue.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "envio")
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Envio", nullable = false)
    private int id_Envio;

    @Column(name = "fecha_Envio", nullable = false)
    private Date fecha_Envio;

    @Column(name = "desc_Envio", length = 50)
    private String desc_Envio;

    @ManyToOne
    @JoinColumn(name = "DonacionId", nullable = false)
    private Donacion donacionId;

    @ManyToOne
    @JoinColumn(name = "PeticionId", nullable = false)
    private Peticion peticionId;

    @ManyToOne
    @JoinColumn(name = "EstadoId", nullable = false)
    private Estado estadoId;

    public Envio(){}

    public Envio(Date fecha_Envio, String desc_Envio, Donacion donacionId, Peticion peticionId, Estado estadoId){
        this.fecha_Envio = fecha_Envio;
        this.desc_Envio = desc_Envio;
        this.donacionId = donacionId;
        this.peticionId = peticionId;
        this.estadoId = estadoId;
    }

    public int getId_Envio() {
        return id_Envio;
    }

    public void setId_Envio(int id_Envio) {
        this.id_Envio = id_Envio;
    }

    public Date getFecha_Envio() {
        return fecha_Envio;
    }

    public void setFecha_Envio(Date fecha_Envio) {
        this.fecha_Envio = fecha_Envio;
    }

    public String getDesc_Envio() {
        return desc_Envio;
    }

    public void setDesc_Envio(String desc_Envio) {
        this.desc_Envio = desc_Envio;
    }

    public Donacion getDonacionId() {
        return donacionId;
    }

    public void setDonacionId(Donacion donacionId) {
        this.donacionId = donacionId;
    }

    public Peticion getPeticionId() {
        return peticionId;
    }

    public void setPeticionId(Peticion peticionId) {
        this.peticionId = peticionId;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }
    
}
