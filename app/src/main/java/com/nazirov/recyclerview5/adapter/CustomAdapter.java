package com.nazirov.recyclerview5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nazirov.recyclerview5.R;
import com.nazirov.recyclerview5.model.Member;
import com.nazirov.recyclerview5.model.MemberSub;

import java.util.List;
import java.util.PrimitiveIterator;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM_VIEW = 0;
    private static final int TYPE_ITEM_LIST = 1;

    private Context context;
    private List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.members = members;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (members.get(position).getMemberSubs() != null) return TYPE_ITEM_LIST;
        Member member = members.get(position);

        return TYPE_ITEM_VIEW;
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == TYPE_ITEM_LIST) {
            View header = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_custom_layout_list, viewGroup, false);
            return new CustomViewHolder(header);
        }
        View footer = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_custom_layout_view, viewGroup, false);
        return new CustomViewHolder(footer);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);
        if (holder instanceof CustomViewHolder) {

        }
        if (holder instanceof CustomListHolder) {
            RecyclerView recyclerView = ((CustomListHolder) holder).recyclerView;
            recyclerView.setLayoutManager(new GridLayoutManager (context ,1));

            List<MemberSub> memberSubs = member.getMemberSubs();
            refreshSubAdapter( recyclerView ,memberSubs);
        }

    }

    private void refreshSubAdapter(RecyclerView recyclerView, List<MemberSub> memberSubs) {
        CustomAdapter adapter = new CustomAdapter(context ,memberSubs);
        recyclerView.setAdapter(adapter);

    }
    public class CustomViewHolder extends RecyclerView.ViewHolder{
        public View view;

        public CustomViewHolder(@NonNull View v) {
            super(v);
            view=v;
        }
    }

    public class CustomListHolder extends RecyclerView.ViewHolder {
        public View view;
        public RecyclerView recyclerView;

        public CustomListHolder(@NonNull View v) {
            super(v);
            view = v;
        }
    }



}
