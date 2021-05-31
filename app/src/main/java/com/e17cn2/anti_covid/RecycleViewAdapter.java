package com.e17cn2.anti_covid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.e17cn2.anti_covid.model.Declaration;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<com.e17cn2.anti_covid.RecycleViewAdapter.OrderViewHolder> {

    private List<Declaration> list;

    public RecycleViewAdapter() {
      list = new ArrayList<>();
    }

    public List<Declaration> getList() {
        return list;
    }

    public void setList(List<Declaration> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater  inflater =LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.phieu_card, parent, false);
        return new OrderViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        Declaration declaration = list.get(position);
        holder.idMaKBYT.setText("Mã số KBYT: "+String.valueOf(declaration.getId()));
        holder.idNoiDi.setText(declaration.getNoiDi()+"->");
        holder.idNoiDen.setText(declaration.getDestination());
        holder.idImg.setImageResource(R.drawable.logo_byt);
        holder.idNgayDi.setText(declaration.getArrivalDate());
        holder.idNgayVe.setText(declaration.getReturnDate());
    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        else
            return 0;
    }

    class OrderViewHolder extends RecyclerView.ViewHolder{

        private TextView idMaKBYT;
        private TextView idNoiDen;
        private TextView idNoiDi;
        private ImageView idImg;
        private TextView idNgayDi;
        private TextView idNgayVe;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            idMaKBYT =itemView.findViewById(R.id.idMaKBYT);
            idNoiDen = itemView.findViewById(R.id.idNoiDen);
            idNoiDi = itemView.findViewById(R.id.idNoiDi);
            idImg = itemView.findViewById(R.id.idImg);
            idNgayDi = itemView.findViewById(R.id.idNgayDi);
            idNgayVe = itemView.findViewById(R.id.idNgayVe);
        }
    }
}

