package com.example.herotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import static com.squareup.picasso.Picasso.Priority.HIGH;

public class PublisherFilter extends AppCompatActivity {
    Button btn_mar,btn_dc,btn_image;
    ImageView img_pub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publisher_filter);
        btn_mar = findViewById(R.id.btn_mar);
        btn_dc = findViewById(R.id.btn_dc);
        btn_image = findViewById(R.id.btn_img);
        img_pub = findViewById(R.id.img_publish);

        btn_mar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 732; i++) {
                    String url = "https://superheroapi.com/api/532645521053616/" + i + "/biography";
                    int finalI=i;
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public synchronized void onResponse(JSONObject response) {
                            try {
                                String gen = response.getString("publisher");
                                String name = response.getString("name");
                                String id = response.getString("id");
                                if (gen.equals("Marvel Comics")){
                                    showToast(name,id,gen);
                                    //Toast.makeText(PublisherFilter.this,"Name: "+name.toString(),Toast.LENGTH_LONG).show();
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
                    MySingleton.getInstance(PublisherFilter.this).addToRequestQueue(request);
                }
            }
        });
        btn_dc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 732; i++) {
                    String url = "https://superheroapi.com/api/532645521053616/" + i + "/biography";
                    int finalI=i;
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public synchronized void onResponse(JSONObject response) {
                            try {
                                String gen = response.getString("publisher");
                                String name = response.getString("name");
                                String id = response.getString("id");
                                if (gen.equals("DC Comics")){
                                    showToast(name,id,gen);
                                    //Toast.makeText(PublisherFilter.this,"Name: "+name.toString(),Toast.LENGTH_LONG).show();
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
                    MySingleton.getInstance(PublisherFilter.this).addToRequestQueue(request);
                }
            }
        });
        btn_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 732; i++) {
                    String url = "https://superheroapi.com/api/532645521053616/" + i + "/biography";
                    int finalI=i;
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public synchronized void onResponse(JSONObject response) {
                            try {
                                String gen = response.getString("publisher");
                                String name = response.getString("name");
                                String id = response.getString("id");
                                if (gen.equals("Image Comics")){
                                    showToast(name,id,gen);
                                    //Toast.makeText(PublisherFilter.this,"Name: "+name.toString(),Toast.LENGTH_LONG).show();
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
                    MySingleton.getInstance(PublisherFilter.this).addToRequestQueue(request);
                }
            }
        });
    }

    synchronized void showToast(String name,String id, String gen) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.layout_toast, (ViewGroup) findViewById(R.id.toast_root));
        TextView toastText = layout.findViewById(R.id.textView);
        String display = "ID :"+id+"\n"+"Name :"+name+"\n"+"Publisher :"+gen;
        toastText.setText(display);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}