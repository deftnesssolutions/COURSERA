package com.androicoude.petagram;

/**
 * Created by Gustavo Ovelar on 21/01/2017.
 */

public class Mascota {
    private int foto;
    private String nombre;
    private int raiting;

    public Mascota(int foto,String nombre,int reiting){
        this.foto=foto;
        this.nombre=nombre;
        this.raiting=reiting;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }
}
