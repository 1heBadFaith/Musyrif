package com.example.gt.musyrif;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class KelasAdapter extends RecyclerView.Adapter<KelasAdapter.ViewHolder> {
    private String[] siswaviii;

    public KelasAdapter(String[] data) {
        this.siswaviii = data;
    }

    @NonNull
    @Override
    public KelasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_siswa, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KelasAdapter.ViewHolder viewHolder, int i) {
        viewHolder.txtNama.setText(siswaviii[i]);
    }

    @Override
    public int getItemCount() {
        return siswaviii.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNama;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNama = (TextView)itemView.findViewById(R.id.txtNama);
        }
    }
}
