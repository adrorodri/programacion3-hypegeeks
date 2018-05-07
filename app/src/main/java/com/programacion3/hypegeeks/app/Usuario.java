package com.programacion3.hypegeeks.app;

import com.google.gson.annotations.Expose;
import java.io.Serializable;

public class Usuario implements Serializable {

    @Expose
    private String username;

    @Expose
    private String password;

    @Expose
    private String email;

    @Expose
    private int telefono;

    @Expose
    private String puntoDeEncuentro;

    public Usuario(String username, String password, int telefono, String email,String puntoDeEncuentro) {
        this.username = username;
        this.password = password;
        this.telefono = telefono;
        this.email = email;
        this.puntoDeEncuentro = puntoDeEncuentro;
    }
    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) { this.username = username; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String apellido) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int codigoUpb) {
        this.telefono = telefono;
    }

    public String getPuntoDeEncuentro() { return puntoDeEncuentro; }

    public void setPuntoDeEncuentro(String puntoDeEncuentro) {
        this.puntoDeEncuentro = puntoDeEncuentro;
    }

}