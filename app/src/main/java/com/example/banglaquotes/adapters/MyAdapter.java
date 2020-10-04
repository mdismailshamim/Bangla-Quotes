package com.example.banglaquotes.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.banglaquotes.R;
import com.example.banglaquotes.ShowPage.ShowActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context mContext;
    List<Quotes> quotesList;

    public MyAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setListQuotes(ArrayList<Quotes> quotesList) {
        this.quotesList = quotesList;
    }

    public MyAdapter(List<Quotes> quotesList) {
        this.quotesList = quotesList;
    }

    public MyAdapter(Context mContext, List<Quotes> quotesList) {
        this.mContext = mContext;
        this.quotesList = quotesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.titleTv.setText(quotesList.get(position).getTitle());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent singleIntent = new Intent(mContext, ShowActivity.class);
                singleIntent.putExtra(ShowActivity.EXTRA_SHOW_PAGE,quotesList.get(position));
                mContext.startActivity(singleIntent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return quotesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTv;
        private ImageView showPage;
        private LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.titleTv);
            showPage = itemView.findViewById(R.id.showPage);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
