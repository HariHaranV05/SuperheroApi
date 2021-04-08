package com.example.herotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class FilterActivity extends AppCompatActivity {
    Button btn_gender,btn_alignment,btn_publisher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        btn_alignment = findViewById(R.id.btn_align);
        btn_gender = findViewById(R.id.btn_gen);
        btn_publisher = findViewById(R.id.btn_publr);

        btn_gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGenderfilter();
            }
        });
        btn_alignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAlignmentfilter();
            }
        });
        btn_publisher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPublisherfilter();
            }
        });
    }
    public void openAlignmentfilter() {
        Intent intent = new Intent(this, AlignmentFilter.class);
        startActivity(intent);
    }

    public void openGenderfilter(){
        Intent intent = new Intent(this, GenderFilter.class);
        startActivity(intent);
    }
    public void openPublisherfilter(){
        Intent intent = new Intent(this, PublisherFilter.class);
        startActivity(intent);
    }
}