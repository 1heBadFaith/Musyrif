package com.example.gt.musyrif;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.ViewHolder> {
    private String[] jadwall;
    private String[] jam2;


    public JadwalAdapter(String[] data) {
        this.jadwall = data;
    }


    @NonNull
    @Override
    public JadwalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_jadwal, viewGroup, false);
        return new JadwalAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalAdapter.ViewHolder viewHolder, int i) {
        viewHolder.txtNama.setText(jadwall[i]);
        viewHolder.txtJam.setText(jam2[i]);
    }

    @Override
    public int getItemCount() {
        return jadwall.length + jam2.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNama, txtJam;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtJam = (TextView)itemView.findViewById(R.id.txtjam);
            txtNama = (TextView)itemView.findViewById(R.id.txtNamaNgajar);
        }
    }
}
