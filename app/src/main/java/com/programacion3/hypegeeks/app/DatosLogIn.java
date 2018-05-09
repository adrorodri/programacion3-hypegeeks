package com.programacion3.hypegeeks.app;

import java.io.Serializable;

public class DatosLogIn implements Serializable {
    private String usuario;
    private String password;

    public DatosLogIn(String username, String password) {
        this.usuario = username;
        this.password = password;
    }
    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) { this.usuario = usuario; }

}
