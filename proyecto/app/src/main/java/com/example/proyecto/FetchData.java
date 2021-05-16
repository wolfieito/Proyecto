package com.example.proyecto;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class  FetchData {

    private String host ;
    Context context;

    public FetchData(Context context){
        host = "https://appointmemx.herokuapp.com/";
        this.context = context;
    }



    public void fetch(int  requeestType,String endPpoint,JSONObject sendingData, Response.Listener<JSONObject> onResponse ){

        String postUrl = "https://appointmemx.herokuapp.com/" + endPpoint ;

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(requeestType, postUrl, sendingData,onResponse
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);

    }
}
