package com.example.tam_u2_caso3_gonzalezcruzalondra;

import java.io.Serializable;

public class Usuario implements Serializable {

    private Integer id;
    private String nombre;
    private String nocontrol;
    private String cel;
    private String email;
    private String carrera;

    public Usuario(Integer id, String nombre, String nocontrol, String cel, String email, String carrera) {
        this.id = id;
        this.nombre = nombre;
        this.nocontrol = nocontrol;
        this.cel = cel;
        this.email = email;
        this.carrera = carrera;

    }

    public Usuario(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNocontrol() {
        return nocontrol;
    }

    public void setNocontrol(String nocontrol) {
        this.nocontrol = nocontrol;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) { this.cel = cel; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
