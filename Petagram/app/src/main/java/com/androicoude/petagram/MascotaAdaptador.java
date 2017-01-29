package com.androicoude.petagram;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gustavo Ovelar on 21/01/2017.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;
    ArrayList<String> mascotasFavoritos  = new ArrayList<>();
    public int craiting=0;
    public MascotaAdaptador(ArrayList<Mascota> mascotas,Activity activity){
        this.mascotas=mascotas;
        this.activity=activity;
    }
    @Override //Inflar el Layout y pasar al ViewHolder para que optenga los Views
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvRaitingCV.setText(mascota.getRaiting());
        mascotaViewHolder.btnLikeCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                craiting = Integer.parseInt(mascota.getRaiting());
                craiting = craiting +1;
                mascota.setRaiting(String.valueOf(craiting));
                mascotaViewHolder.tvRaitingCV.setText(mascota.getRaiting());
            }
        });

    }

    @Override
    public int getItemCount() {//Cantidad de elementos que tiene la lista Mascotas
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvRaitingCV;
        private ImageButton btnLikeCV;

        public MascotaViewHolder(View itemView)
        {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvRaitingCV = (TextView) itemView.findViewById(R.id.tvRaitingCV);
            btnLikeCV = (ImageButton) itemView.findViewById(R.id.btnLike);

        }
    }



}
