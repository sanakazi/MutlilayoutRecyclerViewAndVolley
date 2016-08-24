package com.example.sanakazi.recyclerandvolleyexampleproject.fragments;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sanakazi.recyclerandvolleyexampleproject.R;
import com.example.sanakazi.recyclerandvolleyexampleproject.adapters.RecyclerViewAdapter;
import com.example.sanakazi.recyclerandvolleyexampleproject.pojos.ContactsJson;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by SanaKazi on 8/23/2016.
 */
public class RecyclerViewFragment extends Fragment {
    private String urlJsonObj1 = "http://api.androidhive.info/contacts/";
    ArrayList<ContactsJson.Contacts> contactList;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.recycler_view_fragment, container, false);
        recyclerView = (RecyclerView)v.findViewById(R.id.recycler_view);
        makeJsonObjectRequestForCategory();
        return v;
    }

    private void makeJsonObjectRequestForCategory() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlJsonObj1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.w("response", response.toString());

                        ContactsJson responseJson = new Gson().fromJson(response.toString(), ContactsJson.class);
                      //  contactListArray = responseJson.getContacts();
                        contactList = new ArrayList<ContactsJson.Contacts>(Arrays.asList(responseJson.getContacts()));
                        Log.w("contactList", contactList.toString());
                        Log.w("contactList at 1 ", contactList.get(1).getName() + " ");

                        mAdapter = new RecyclerViewAdapter(getActivity(),contactList);
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
                        recyclerView.setLayoutManager(mLayoutManager);
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setAdapter(mAdapter);


                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.w("TAG", error.toString());
                    //    Toast.makeText(BuyServiceActivity.this,error.toString(),Toast.LENGTH_LONG).show();

                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }
}
