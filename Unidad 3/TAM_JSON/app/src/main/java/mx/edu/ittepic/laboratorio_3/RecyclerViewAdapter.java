package mx.edu.ittepic.laboratorio_3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Alumnos> mData ;



    public RecyclerViewAdapter( List<Alumnos> mData) {
        this.mData = mData;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_alumnos,null,false);
        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.numerocontrol.setText(mData.get(position).getNumerocontrol());
        holder.nombre.setText(mData.get(position).getName());
        holder.u1.setText(mData.get(position).getU1());
        holder.u2.setText(mData.get(position).getU2());
        holder.u3.setText(mData.get(position).getU3());
        String s =mData.get(position).getU1().substring(4,5);
        String s2 =mData.get(position).getU2().substring(4,5);
        String s3 =mData.get(position).getU3().substring(4,5);

        try {
            if(Integer.valueOf(s)>=7 || Integer.valueOf(s2)>=7 || Integer.valueOf(s3)>=7)holder.cons.setBackgroundColor(Color.YELLOW);
            if(Integer.valueOf(s)>=7 && Integer.valueOf(s2)>=7 && Integer.valueOf(s3)>=7)holder.cons.setBackgroundColor(Color.GREEN);

            if(Integer.valueOf(s)<7 && Integer.valueOf(s2)<7 && Integer.valueOf(s3)<7)holder.cons.setBackgroundColor(Color.RED);
        }catch (Exception e){
        }

    }

    @Override
    public int getItemCount() {

        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView numerocontrol ;
        TextView nombre ;
        TextView u1 ;
        TextView u2;
        TextView u3;;
        LinearLayout view_container;
        ConstraintLayout cons;


        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            numerocontrol = itemView.findViewById(R.id.alumnos_numerocontrol);
            nombre = itemView.findViewById(R.id.name);
            u1 = itemView.findViewById(R.id.u1);
            u2 = itemView.findViewById(R.id.u2);
            u3 = itemView.findViewById(R.id.u3);
            cons = itemView.findViewById(R.id.cardview);


        }
    }

}
