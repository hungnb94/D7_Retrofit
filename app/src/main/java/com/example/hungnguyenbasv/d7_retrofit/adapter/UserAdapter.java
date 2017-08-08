package com.example.hungnguyenbasv.d7_retrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hungnguyenbasv.d7_retrofit.R;
import com.example.hungnguyenbasv.d7_retrofit.model.User;

import java.util.List;

/**
 * Created by hung.nguyenba.sv on 7/18/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<User> users;
    private int rowLayout;
    private Context context;

    public UserAdapter(List<User> users, int rowLayout, Context context) {
        this.users = users;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(users.get(position).getName());
        holder.email.setText(users.get(position).getEmail());
        holder.phone.setText(users.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, email, phone;

        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.tvName);
            email = (TextView) view.findViewById(R.id.tvEmail);
            phone = (TextView) view.findViewById(R.id.tvPhone);
        }
    }
}
