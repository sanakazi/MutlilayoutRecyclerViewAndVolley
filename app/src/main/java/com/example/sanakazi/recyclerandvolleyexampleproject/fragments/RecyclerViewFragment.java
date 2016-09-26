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

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sanakazi.recyclerandvolleyexampleproject.R;
import com.example.sanakazi.recyclerandvolleyexampleproject.adapters.RecyclerViewAdapter;
import com.example.sanakazi.recyclerandvolleyexampleproject.pojos.ContactsJson;
import com.example.sanakazi.recyclerandvolleyexampleproject.singleton.MySingleton;
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
                      // contactListArray = responseJson.getContacts();
                        contactList = new ArrayList<>(Arrays.asList(responseJson.getContacts()));
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

                    }
                });


// Add a request (in this example, called stringRequest) to your RequestQueue.
        MySingleton.getInstance(getActivity()).addToRequestQueue(stringRequest);

        //Set a retry policy in case of SocketTimeout & ConnectionTimeout Exceptions.
        //Volley does retry for you if you have specified the policy.
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(6000,
                2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }
}




/*
JSON RESPONSE IS

        {
        "contacts": [
        {
        "id": "c200",
        "name": "Ravi Tamada",
        "email": "ravi@gmail.com",
        "address": "xx-xx-xxxx,x - street, x - country",
        "gender" : "male",
        "phone": {
        "mobile": "+91 0000000000",
        "home": "00 000000",
        "office": "00 000000"
        }
        },
        {
        "id": "c201",
        "name": "Johnny Depp",
        "email": "johnny_depp@gmail.com",
        "address": "xx-xx-xxxx,x - street, x - country",
        "gender" : "male",
        "phone": {
        "mobile": "+91 0000000000",
        "home": "00 000000",
        "office": "00 000000"
        }
        },
        {
        "id": "c202",
        "name": "Leonardo Dicaprio",
        "email": "leonardo_dicaprio@gmail.com",
        "address": "xx-xx-xxxx,x - street, x - country",
        "gender" : "male",
        "phone": {
        "mobile": "+91 0000000000",
        "home": "00 000000",
        "office": "00 000000"
        }
        },
        {
        "id": "c203",
        "name": "John Wayne",
        "email": "john_wayne@gmail.com",
        "address": "xx-xx-xxxx,x - street, x - country",
        "gender" : "male",
        "phone": {
        "mobile": "+91 0000000000",
        "home": "00 000000",
        "office": "00 000000"
        }
        },
        {
        "id": "c204",
        "name": "Angelina Jolie",
        "email": "angelina_jolie@gmail.com",
        "address": "xx-xx-xxxx,x - street, x - country",
        "gender" : "female",
        "phone": {
        "mobile": "+91 0000000000",
        "home": "00 000000",
        "office": "00 000000"
        }
        },
        {
        "id": "c205",
        "name": "Dido",
        "email": "dido@gmail.com",
        "address": "xx-xx-xxxx,x - street, x - country",
        "gender" : "female",
        "phone": {
        "mobile": "+91 0000000000",
        "home": "00 000000",
        "office": "00 000000"
        }
        },
        {
        "id": "c206",
        "name": "Adele",
        "email": "adele@gmail.com",
        "address": "xx-xx-xxxx,x - street, x - country",
        "gender" : "female",
        "phone": {
        "mobile": "+91 0000000000",
        "home": "00 000000",
        "office": "00 000000"
        }
        },
        {
        "id": "c207",
        "name": "Hugh Jackman",
        "email": "hugh_jackman@gmail.com",
        "address": "xx-xx-xxxx,x - street, x - country",
        "gender" : "male",
        "phone": {
        "mobile": "+91 0000000000",
        "home": "00 000000",
        "office": "00 000000"
        }
        },
        {
        "id": "c208",
        "name": "Will Smith",
        "email": "will_smith@gmail.com",
        "address": "xx-xx-xxxx,x - street, x - country",
        "gender" : "male",
        "phone": {
        "mobile": "+91 0000000000",
        "home": "00 000000",
        "office": "00 000000"
        }
        },
        {
        "id": "c209",
        "name": "Clint Eastwood",
        "email": "clint_eastwood@gmail.com",
        "address": "xx-xx-xxxx,x - street, x - country",
        "gender" : "male",
        "phone": {
        "mobile": "+91 0000000000",
        "home": "00 000000",
        "office": "00 000000"
        }
        },
        {
        "id": "c2010",
        "name": "Barack Obama",
        "email": "barack_obama@gmail.com",
        "address": "xx-xx-xxxx,x - street, x - country",
        "gender" : "male",
        "phone": {
        "mobile": "+91 0000000000",
        "home": "00 000000",
        "office": "00 000000"
        }
        },
        {
        "id": "c2011",
        "name": "Kate Winslet",
        "email": "kate_winslet@gmail.com",
        "address": "xx-xx-xxxx,x - street, x - country",
        "gender" : "female",
        "phone": {
        "mobile": "+91 0000000000",
        "home": "00 000000",
        "office": "00 000000"
        }
        },
        {
        "id": "c2012",
        "name": "Eminem",
        "email": "eminem@gmail.com",
        "address": "xx-xx-xxxx,x - street, x - country",
        "gender" : "male",
        "phone": {
        "mobile": "+91 0000000000",
        "home": "00 000000",
        "office": "00 000000"
        }
        }
        ]
        }*/
