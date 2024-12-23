package com.example.artbookjava;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.artbookjava.databinding.RecycleRowBinding;

import java.util.ArrayList;

public class ArtAdapter extends RecyclerView.Adapter<ArtAdapter.ArtHolder> {

    ArrayList<Art> artArrayList;
    public  ArtAdapter(ArrayList<Art> artArrayList){
        this.artArrayList = artArrayList;
    }

    @NonNull
    @Override
    public ArtHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecycleRowBinding recycleRowBinding = RecycleRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent,false );
        return new ArtHolder(recycleRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtHolder holder, int position) {
        holder.binding.recyclerViewTextView.setText(artArrayList.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ArtActivity.class);
                intent.putExtra("info", "old");
                intent.putExtra("artId", artArrayList.get(position).id);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return artArrayList.size();
    }

    public  class ArtHolder extends RecyclerView.ViewHolder{
        private RecycleRowBinding binding;
        public ArtHolder(RecycleRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
