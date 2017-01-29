package com.androicoude.petagram;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Gustavo Ovelar on 21/01/2017.
 */

public class Mascota implements Parcelable {
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

    protected Mascota(Parcel in) {
        foto = in.readInt();
        nombre = in.readString();
        raiting = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(foto);
        dest.writeString(nombre);
        dest.writeString(raiting);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Mascota> CREATOR = new Parcelable.Creator<Mascota>() {
        @Override
        public Mascota createFromParcel(Parcel in) {
            return new Mascota(in);
        }

        @Override
        public Mascota[] newArray(int size) {
            return new Mascota[size];
        }
    };
}
