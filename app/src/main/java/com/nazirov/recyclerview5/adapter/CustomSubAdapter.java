package com.nazirov.recyclerview5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nazirov.recyclerview5.R;
import com.nazirov.recyclerview5.model.MemberSub;

import java.util.List;

public class CustomSubAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<MemberSub> memberSubs;

    public CustomSubAdapter(Context context , List<MemberSub> memberSubs) {
        this.context =context;
        this.memberSubs =memberSubs;

    }

    @Override
    public int getItemCount() {
        return memberSubs.size();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View footer = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_custom_layout_view_sub,viewGroup,false);
        return new CustomViewSubHolder(footer);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MemberSub memberSub = memberSubs.get(position);

    }
    //Holders here

    public class CustomViewSubHolder extends RecyclerView.ViewHolder{
        public View view;

        public CustomViewSubHolder( View v) {
            super(v);
            view=v;
        }
    }

    public class CustomListSubHolder extends RecyclerView.ViewHolder{
        public RecyclerView recyclerView;
        public View view;

        public CustomListSubHolder( View v) {
            super(v);
            view = v;

            recyclerView =view.findViewById(R.id.recyclerView);
        }
    }

}
