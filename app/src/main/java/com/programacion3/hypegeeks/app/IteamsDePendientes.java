package com.programacion3.hypegeeks.app;

public class IteamsDePendientes {


    private int primeraFigurita;
    private int segundaFigurita;
    private int icono;
    private int boton;

    public IteamsDePendientes(int primeraFigurita, int segundaFigurita) {
    this.primeraFigurita= primeraFigurita;
    this.segundaFigurita= segundaFigurita;
    this.boton= boton;
    }

    public int getPrimeraFigurita() {
        return primeraFigurita;
    }

    public void setPrimeraFigurita(int primeraFigurita) {
        this.primeraFigurita = primeraFigurita;
    }

    public int getSegundaFigurita() {
        return segundaFigurita;
    }

    public void setSegundaFigurita(int segundaFigurita) {
        this.segundaFigurita = segundaFigurita;
    }

    public int getBoton() {
        return boton;
    }

    public void setBoton(int boton) {
        this.boton = boton;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }
}