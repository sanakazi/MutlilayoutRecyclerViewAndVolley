package com.example.sanakazi.recyclerandvolleyexampleproject.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sanakazi.recyclerandvolleyexampleproject.R;
import com.example.sanakazi.recyclerandvolleyexampleproject.pojos.ContactsJson;

import java.util.ArrayList;

/**
 * Created by SanaKazi on 8/23/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>  {
    private static final int MALE = 0;
    private static final int FEMALE = 1;
    public String getGender;
    View v;

    public interface OnItemClickListener {
        void onItemClick(ContactsJson.Contacts usersList);
    }

    private final ArrayList<ContactsJson.Contacts> usersList;
    private final Context context;


    public RecyclerViewAdapter(Context context, ArrayList<ContactsJson.Contacts> usersList) {
        this.context=context;
        this.usersList=usersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        MyViewHolder viewholder = null;

        Log.w("layout = ", viewType + " ");
        switch (viewType) {
            case MALE:
                v = inflater.inflate(R.layout.contact_list_row, null);
                viewholder = new MyViewHolder(v, viewType);
                break;
            case FEMALE:
                v = inflater.inflate(R.layout.contact_list_row2, null);
                viewholder = new MyViewHolder(v, viewType);
                break;

        }
        return viewholder;

    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        ContactsJson.Contacts contact = usersList.get(position);
        getGender= contact.getGender().toString();
        Log.w("getGender= ", getGender);
        if(getGender.equals("male"))
        {
            holder.name.setText(contact.getName().toString());
            holder.email.setText(contact.getEmail().toString());
            holder.number.setText(contact.getPhone().getMobile().toString());

            Log.w("adapter name are ", contact.getName().toString());

        }

        else if (getGender.equals("female"))
        {
            holder.name.setText(contact.getName().toString());
            holder.email.setText(contact.getEmail().toString());
            holder.number.setText(contact.getPhone().getMobile().toString());


            Log.w("adapter name are ", contact.getName().toString());
        }

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    //this method is called before calling onCreateViewHolder
    @Override
    public int getItemViewType(int position) {
        if (usersList.get(position).getGender().equals("male")) {
            return 0;

        }else
        {
            return 1;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, email, number;

        public MyViewHolder(View itemView,int position) {
            super(itemView);

            if(position==MALE) {
                name = (TextView) itemView.findViewById(R.id.name);
                email = (TextView) itemView.findViewById(R.id.email);
                number = (TextView) itemView.findViewById(R.id.number);
            }
            else if(position==FEMALE)
            {
                name = (TextView) itemView.findViewById(R.id.name);
                email = (TextView) itemView.findViewById(R.id.email);
                number = (TextView) itemView.findViewById(R.id.number);

            }
        }
    }


}
