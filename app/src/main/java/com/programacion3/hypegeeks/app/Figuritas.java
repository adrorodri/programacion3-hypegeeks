package com.programacion3.hypegeeks.app;

public class Figuritas {

    private int id;
    private int foto;
    private int bandera;
    private String numeroDeFigurita;

    public Figuritas(int id,int bandera, int foto, String numeroDeFigurita) {
        this.bandera = bandera;
        this.foto=foto;
        this.numeroDeFigurita= numeroDeFigurita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroDeFigurita() {
        return numeroDeFigurita;
    }

    public void setNumeroDeFigurita(String numeroDeFigurita) {
        this.numeroDeFigurita = numeroDeFigurita;
    }

    public int getFoto() {

        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getBandera() {

        return bandera;
    }

    public void setBandera(int bandera) {
        this.bandera = bandera;
    }
}
