package com.example.home.engineeringidea.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.home.engineeringidea.R;
import com.example.home.engineeringidea.model.User;
import com.example.home.engineeringidea.ui.UserActivity;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {
    private List<User> users;
    private Context context;

    public UsersAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    public void setUsers(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(users.get(position).getName());
        holder.phone.setText(users.get(position).getPhone());
        holder.email.setText(users.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView phone;
        private TextView email;

         ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_user_name);
            phone = itemView.findViewById(R.id.item_user_phone);
            email = itemView.findViewById(R.id.item_user_email);
            itemView.setOnClickListener(v ->
                    UserActivity.start(context, users.get(getAdapterPosition())));
        }
    }
}
