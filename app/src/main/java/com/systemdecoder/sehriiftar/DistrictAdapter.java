package com.systemdecoder.sehriiftar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DistrictAdapter extends RecyclerView.Adapter<DistrictAdapter.DistrictViewHolder> {

    Context context;
    String[] district_name;

    public DistrictAdapter(Context context, String[] district_name) {
        this.context = context;
        this.district_name = district_name;
    }

    @NonNull
    @Override
    public DistrictViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.district_recycle_list, parent, false);
        return new DistrictViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DistrictViewHolder holder, int position) {
        holder.district_name_view.setText(district_name[position]);
    }

    @Override
    public int getItemCount() {
        return district_name.length;
    }

    class DistrictViewHolder extends RecyclerView.ViewHolder {

        TextView district_name_view;
        public DistrictViewHolder(@NonNull View itemView) {
            super(itemView);
            district_name_view = itemView.findViewById(R.id.district_name);
        }
    }
}
