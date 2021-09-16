package com.example.covidupdates;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<CoronaItem> coronaItemArrayList;
    private RequestQueue requestQueue;
    private TextView dateHeader,dailyConfirmed ,totalConfirmed ,dailyRecovered,totalRecovered,dailyDeaths,totalDeaths;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateHeader=(TextView) findViewById(R.id.dateHeader);
        dailyConfirmed=(TextView)findViewById(R.id.dailyConfirmed);
        totalConfirmed=(TextView)findViewById(R.id.totalConfirmed);
        dailyRecovered=(TextView)findViewById(R.id.dailyRecovered);
        totalRecovered=(TextView)findViewById(R.id.totalRecovered);
        dailyDeaths=(TextView)findViewById(R.id.dailyDeaths);
        totalDeaths=(TextView)findViewById(R.id.totalDeaths);

        recyclerView=findViewById(R.id.myRecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(manager);


coronaItemArrayList=new ArrayList<>();





requestQueue= Volley.newRequestQueue(this);
parseJson();

    }

    private void parseJson() {

        String url ="https://data.covid19india.org/data.json";

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {    JSONArray array=response.getJSONArray("statewise");
                         JSONObject jsonObject=array.getJSONObject(0);

                         String dailyconfirmed =jsonObject.getString("deltaconfirmed");
                         String dailyrecovered =jsonObject.getString("deltarecovered");
                         String dailydeaths =jsonObject.getString("deltadeaths");
                         String dateheader =jsonObject.getString("lastupdatedtime").substring(0,5);

                         dateHeader.setText(dateheader);
                         dailyConfirmed.setText(dailyconfirmed);
                         dailyRecovered.setText(dailyrecovered);
                         dailyDeaths.setText(dailydeaths);

                         String totalconfirmed =jsonObject.getString("confirmed");
                         String totalrecoverd =jsonObject.getString("recovered");
                         String totaldeaths =jsonObject.getString("deaths");

                         totalConfirmed.setText(totalconfirmed);
                         totalDeaths.setText(totaldeaths);
                         totalRecovered.setText(totalrecoverd);

                         for(int i=1;i<array.length();i++){
                             JSONObject obj =array.getJSONObject(i);
                             String lastupdated=obj.getString("lastupdatedtime");
                             String death =obj.getString("deaths");
                             String todaydeaths =obj.getString("deltadeaths");
                             String activecases =obj.getString("active");
                             String recovered =obj.getString("recovered");
                             String todayrecoverd =obj.getString("deltarecovered");
                             String confirmed =obj.getString("confirmed");
                             String todayconfirmed =obj.getString("deltaconfirmed");
                             String state =obj.getString("state");

                             CoronaItem coronaItem=new CoronaItem(lastupdated,death,todaydeaths,activecases,todayconfirmed,recovered,todayrecoverd,confirmed,state);
                             coronaItemArrayList.add(coronaItem);
                    }

                    RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(MainActivity.this,coronaItemArrayList);

                    recyclerView.setHasFixedSize(true);
                    recyclerView.setAdapter(recyclerViewAdapter);
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "Error",
                            Toast.LENGTH_LONG).show();

                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    //This indicates that the reuest has either time out or there is no connection
                  Toast.makeText(getApplicationContext(),"No connection or timeout",Toast.LENGTH_LONG).show();
                } else if (error instanceof AuthFailureError) {
                    // Error indicating that there was an Authentication Failure while performing the request
                    Toast.makeText(getApplicationContext(),"Authentication Failure",Toast.LENGTH_LONG).show();
                } else if (error instanceof ServerError) {
                    //Indicates that the server responded with a error response
                    Toast.makeText(getApplicationContext(),"Error response",Toast.LENGTH_LONG).show();

                } else if (error instanceof NetworkError) {
                    //Indicates that there was network error while performing the request
                    Toast.makeText(getApplicationContext(),"Network Error",Toast.LENGTH_LONG).show();
                } else if (error instanceof ParseError) {
                    // Indicates that the server response could not be parsed
                    Toast.makeText(getApplicationContext(),"Parse error",Toast.LENGTH_LONG).show();

                }
            }
        });

requestQueue.add(jsonObjectRequest);


    }
}