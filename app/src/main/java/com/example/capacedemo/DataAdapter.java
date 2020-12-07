package com.example.capacedemo;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.io.Serializable;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    public Context context;
    public  List<JSONResponse.Datum> array_list;

    DataAdapter(Context context, List<JSONResponse.Datum> array_list){
        this.context = context;
        this.array_list = array_list;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {

        JSONResponse.Datum datum = array_list.get(position);

        String img_url = datum.getImage();

       RequestOptions requestOptions = new RequestOptions()
               .transform(new RoundedCorners(20));

        Glide.with(context)
                .load(img_url)
                .apply(requestOptions)
                .into(holder.image_id);

        holder.e_id.setText("ID : "+array_list.get(position).getId());
        holder.tx_name_id.setText("Name : "+array_list.get(position).getName());
        holder.caterogy_id.setText("Category : "+array_list.get(position).getCategory());
        holder.emp_id.setText("EMP ID : "+array_list.get(position).getEmpcode());
        holder.descrition_id.setText("Descrition : "+array_list.get(position).getDescription());
        holder.contact_id.setText("Phone : "+array_list.get(position).getContact());
        holder.address_id.setText("Address : "+array_list.get(position).getAddress());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                JSONResponse.Datum list = new JSONResponse.Datum();
//                Intent i = new Intent(context,SingleItemClass.class);
//                i.putExtra("mypojo", (Serializable) list);
//                context.startActivity(i);

                Intent intent = new Intent(context,SingleItemClass.class);
                intent.putExtra("id",array_list.get(position).getId());
                intent.putExtra("name",array_list.get(position).getName());
                intent.putExtra("category",array_list.get(position).getCategory());
                intent.putExtra("empid",array_list.get(position).getEmpcode());
                intent.putExtra("description",array_list.get(position).getDescription());
                intent.putExtra("phone",array_list.get(position).getContact());
                intent.putExtra("address",array_list.get(position).getAddress());
                intent.putExtra("image",array_list.get(position).getImage());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return array_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView card_id;
        ImageView image_id;
        TextView e_id,tx_name_id,caterogy_id,emp_id,address_id,descrition_id,contact_id;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();

            image_id = itemView.findViewById(R.id.image_id);
            e_id = itemView.findViewById(R.id.e_id);
            tx_name_id = itemView.findViewById(R.id.tx_name_id);
            caterogy_id = itemView.findViewById(R.id.caterogy_id);
            emp_id = itemView.findViewById(R.id.emp_id);
            address_id = itemView.findViewById(R.id.address_id);
            descrition_id = itemView.findViewById(R.id.descrition_id);
            contact_id = itemView.findViewById(R.id.contact_id);
            card_id = itemView.findViewById(R.id.card_id);
        }
    }
}
