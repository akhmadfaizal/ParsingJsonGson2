package com.afi.latihan.parsingjsongson2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.ListViewVolder> {
    /*
   Store variable group for user.
   Simpan kelompok variabel untuk user
*/
    private ArrayList<User> listUser;

    /*
        put array user to constructor.
        Menempatkan user array ke kontruktor.
    */

    public ListUserAdapter(ArrayList<User> listUser) {
        this.listUser = listUser;
    }

    @NonNull
    @Override
    public ListViewVolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate the custom layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        // Returning a new holder instance
        return new ListViewVolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewVolder holder, int position) {
        // Get the data model based on position
        final User user = listUser.get(position);

        // Set item views based on your views and data model
        holder.tvFirstName.setText(user.getFirstName());
        holder.tvEmail.setText(user.getEmail());

        // Used to load an image
        Glide.with(holder.itemView.getContext())
                .load(user.getAvatar())
                .apply(new RequestOptions().override(100,100))
                .into(holder.imgAvatar);

    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class ListViewVolder extends RecyclerView.ViewHolder {
        TextView tvFirstName, tvEmail;
        ImageView imgAvatar;
        public ListViewVolder(@NonNull View itemView) {
            super(itemView);
            tvFirstName = itemView.findViewById(R.id.tv_first_name);
            tvEmail = itemView.findViewById(R.id.tv_email);
            imgAvatar = itemView.findViewById(R.id.img_avatar);
        }
    }
}