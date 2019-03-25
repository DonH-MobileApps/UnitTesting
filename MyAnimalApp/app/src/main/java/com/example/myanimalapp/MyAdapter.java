package com.example.myanimalapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    ArrayList<Animal> animalArrayList;

    public MyAdapter(ArrayList<Animal> animalArrayList) {
        this.animalArrayList = animalArrayList;


    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout parentLayout;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }


    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {



        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout));


    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
