package com.programacion3.hypegeeks.app;

public class ObjetosDeTienda {
   private int id;
   private int foto;
   private String precio;

    public ObjetosDeTienda(int id,int foto, String precio) {
        this.foto = foto;
        this.id=id;
        this.precio=precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
