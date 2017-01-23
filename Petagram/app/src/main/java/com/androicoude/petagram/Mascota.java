package com.androicoude.petagram;

/**
 * Created by Gustavo Ovelar on 21/01/2017.
 */

public class Mascota {
    private int foto;
    private String nombre;
    private String raiting;

    public Mascota(int foto,String nombre,String reiting){
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

    public String getRaiting() {
        return raiting;
    }

    public void setRaiting(String raiting) {
        this.raiting = raiting;
    }
}
