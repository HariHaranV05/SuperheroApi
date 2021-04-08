package com.example.herotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.squareup.picasso.Picasso.Priority.HIGH;

public class GenderFilter extends AppCompatActivity {
    Button btn_ml,btn_fm;
    ListView lv_vw;
    ImageView img_gen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_filter);
        btn_ml = findViewById(R.id.btn_male);
        btn_fm = findViewById(R.id.btn_female);
        img_gen = findViewById(R.id.img_gender);

        btn_ml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 732; i++) {
                    String url = "https://superheroapi.com/api/532645521053616/" + i + "/appearance";
                    int finalI = i;
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public synchronized void onResponse(JSONObject response) {
                            try {
                                String gen = response.getString("gender");
                                String name = response.getString("name");
                                String id = response.getString("id");
                                if (gen.equals("Male")){
                                    showToast(name,id,gen);
                                    //Toast.makeText(GenderFilter.this,"Name: "+name.toString(),Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });
                    MySingleton.getInstance(GenderFilter.this).addToRequestQueue(request);
                }
            }
        });
        btn_fm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 732; i++) {
                    String url = "https://superheroapi.com/api/532645521053616/" + i + "/appearance";
                    int finalI = i;
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public synchronized void onResponse(JSONObject response) {
                            try {
                                String gen = response.getString("gender");
                                String name = response.getString("name");
                                String id = response.getString("id");
                                if (gen.equals("Female")){
                                    showToast(name,id,gen);
                                    //Toast.makeText(GenderFilter.this,"Name: "+name.toString(),Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });
                    MySingleton.getInstance(GenderFilter.this).addToRequestQueue(request);
                }
            }
        });
    }

    synchronized void showToast(String name, String id, String gen) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.layout_toast, (ViewGroup) findViewById(R.id.toast_root));
        TextView toastText = layout.findViewById(R.id.textView);
        String display = "ID :"+id+"\n"+"Name :"+name+"\n"+"Gender :"+gen;
        toastText.setText(display);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}