package com.example.sanakazi.recyclerandvolleyexampleproject.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sanakazi.recyclerandvolleyexampleproject.R;
import com.example.sanakazi.recyclerandvolleyexampleproject.pojos.ContactsJson;

import java.util.ArrayList;

/**
 * Created by SanaKazi on 8/23/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>  {

    private final ArrayList<ContactsJson.Contacts> usersList;
    private final Context context;

    public RecyclerViewAdapter(Context context, ArrayList<ContactsJson.Contacts> usersList) {
        this.context=context;
        this.usersList=usersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ContactsJson.Contacts contact = usersList.get(position);
        holder.name.setText(contact.getName().toString());
        holder.email.setText(contact.getEmail().toString());
        holder.number.setText(contact.getPhone().getMobile().toString());

        Log.w("adapter name are " , contact.getName().toString() );


    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, email, number;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            email = (TextView) view.findViewById(R.id.email);
            number = (TextView) view.findViewById(R.id.number);
        }
    }
}
