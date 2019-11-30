package com.example.application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private ArrayList<Pokemon> arrayList;
    private Context context;
    private View.OnClickListener listener;

    public Adapter(ArrayList<Pokemon> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    public void setOnItemClickListner(View.OnClickListener itemClickListner){

        listener = itemClickListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Picasso.get().load(arrayList.get(position).getPokemonImage()).into(holder.pokemonImage);
        holder.Name.setText(arrayList.get(position).getPokemonName());



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView pokemonImage;
        TextView Name;





        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pokemonImage = itemView.findViewById(R.id.image);
            Name = itemView.findViewById(R.id.pokemonName);


            itemView.setTag(this);
            itemView.setOnClickListener(listener);

        }
    }

}
