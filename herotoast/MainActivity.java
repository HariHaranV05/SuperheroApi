package com.example.herotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
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
import com.squareup.picasso.Target;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

import static com.squareup.picasso.Picasso.Priority.HIGH;

public class MainActivity extends AppCompatActivity {
    Button btn_search,btn_fil,btn_clear;
    TextView txt_entered;
    ImageView img_hero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_search = findViewById(R.id.btn_search);
        txt_entered = findViewById(R.id.txt_input);
        btn_fil = findViewById(R.id.btn_filter);
        img_hero = findViewById(R.id.img_result);
        btn_clear = findViewById(R.id.btn_clr);

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_entered.setText("");
                img_hero.setImageBitmap(null);
            }
        });
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://superheroapi.com/api/532645521053616/search/" + txt_entered.getText().toString();
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String[] arr;
                            int count;
                            String nid;
                            JSONArray results = response.getJSONArray("results");
                            count = results.length();
                            arr = new String[count];
                            HeroProperties properties = new HeroProperties();
                            for (int i = 0; i < results.length(); i++) {
                                JSONObject resul = results.getJSONObject(i);
                                String id = resul.getString("id");
                                properties.setId(resul.getString("id"));
                                properties.setName(resul.getString("name"));
                                arr[i] = id;
                            }
                            for (int i = 0; i < count; i++) {
                                nid = arr[i];
                                jsonImage(nid);
                                jsonPowerstats(nid);
                                jsonBiography(nid);
                                jsonAppearance(nid);
                                jsonWork(nid);
                                jsonConnections(nid);
                            }

                        } catch (JSONException e) {
                            Toast.makeText(MainActivity.this, "Enter Name Correctly", Toast.LENGTH_LONG).show();

                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                MySingleton.getInstance(MainActivity.this).addToRequestQueue(request);
            }

         synchronized void jsonPowerstats(String id) {
                int hid = Integer.parseInt(id);
                //Toast.makeText(MainActivity.this,"ID:"+id,Toast.LENGTH_SHORT).show();
                String url = "https://superheroapi.com/api/532645521053616/" + hid + "/powerstats";
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    public synchronized void onResponse(JSONObject response) {
                        try {
                            //Toast.makeText(MainActivity.this,response.toString(),Toast.LENGTH_SHORT).show();
                            HeroPowerstats powerstats = new HeroPowerstats();
                            powerstats.setId(response.getString("id"));
                            powerstats.setName(response.getString("name"));
                            powerstats.setIntelligence(response.getString("intelligence"));
                            powerstats.setCombat(response.getString("combat"));
                            powerstats.setDurability(response.getString("durability"));
                            powerstats.setPower(response.getString("power"));
                            powerstats.setSpeed(response.getString("speed"));
                            powerstats.setStrength(response.getString("strength"));
                            //Toast.makeText(MainActivity.this, powerstats.toString(), Toast.LENGTH_LONG).show();
                            showToast(powerstats.toString());
                        } catch (JSONException e) {
                            Toast.makeText(MainActivity.this, "ERROR AT POWER", Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                MySingleton.getInstance(MainActivity.this).addToRequestQueue(request);
            }

            synchronized void jsonBiography(String id) {
                int hid = Integer.parseInt(id);
                //Toast.makeText(MainActivity.this,"ID:"+id,Toast.LENGTH_SHORT).show();
                String url = "https://superheroapi.com/api/532645521053616/" + hid + "/biography";
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    public synchronized void onResponse(JSONObject response) {
                        HeroBiography heroBiography = new HeroBiography();
                        try {
                            String[] aliase;
                            int count;
                            JSONArray result = response.getJSONArray("aliases");
                            count = result.length();
                            aliase = new String[count];
                            for (int i = 0; i < count; i++) {
                                aliase[i] = result.getString(i);
                            }
                            heroBiography.setId(response.getString("id"));
                            heroBiography.setName(response.getString("name"));
                            heroBiography.setFull_name(response.getString("full-name"));
                            heroBiography.setAlter_egos(response.getString("alter-egos"));
                            heroBiography.setPlace_of_birth(response.getString("place-of-birth"));
                            heroBiography.setFirst_appearance(response.getString("first-appearance"));
                            heroBiography.setPublisher(response.getString("publisher"));
                            heroBiography.setAlignment(response.getString("alignment"));
                            //Toast.makeText(MainActivity.this, heroBiography.toString() + "\n" +"Aliases:"+ Arrays.toString(aliase) + "\n" + '}', Toast.LENGTH_SHORT).show();
                            showToast(heroBiography.toString());
                        } catch (JSONException e) {
                            Toast.makeText(MainActivity.this,"ERROR AT BIOGRAPHY", Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                MySingleton.getInstance(MainActivity.this).addToRequestQueue(request);
            }

            synchronized void jsonAppearance(String id) {
                int hid = Integer.parseInt(id);
                //Toast.makeText(MainActivity.this,"ID:"+id,Toast.LENGTH_SHORT).show();
                String url = "https://superheroapi.com/api/532645521053616/" + hid + "/appearance";
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    public synchronized void onResponse(JSONObject response) {
                        HeroAppearance heroAppearance = new HeroAppearance();
                        try {
                            String[] height,weight;
                            int count1,count2;
                            JSONArray result1 = response.getJSONArray("height");
                            JSONArray result2 = response.getJSONArray("weight");
                            count1 = result1.length();
                            count2 = result2.length();
                            height = new String[count1];
                            weight = new String[count2];
                            for (int i = 0; i < count1; i++) {
                                height[i] = result1.getString(i);
                            }
                            for (int i = 0; i < count2; i++) {
                                weight[i] = result2.getString(i);
                            }
                            heroAppearance.setId(response.getString("id"));
                            heroAppearance.setName(response.getString("name"));
                            heroAppearance.setGender(response.getString("gender"));
                            heroAppearance.setRace(response.getString("race"));
                            heroAppearance.setEye_color(response.getString("eye-color"));
                            heroAppearance.setHair_color(response.getString("hair-color"));
                            showToast(heroAppearance.toString());
                            //Toast.makeText(MainActivity.this, heroAppearance.toString() + "\n" +"Height:"+ Arrays.toString(height) + "\n" +"Weight:"+Arrays.toString(weight)+ '}', Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            Toast.makeText(MainActivity.this,"ERROR AT APPEARANCE", Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                MySingleton.getInstance(MainActivity.this).addToRequestQueue(request);
            }
            synchronized void jsonConnections(String id) {
                int hid = Integer.parseInt(id);
                //Toast.makeText(MainActivity.this,"ID:"+id,Toast.LENGTH_SHORT).show();
                String url = "https://superheroapi.com/api/532645521053616/" + hid + "/connections";
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    public synchronized void onResponse(JSONObject response) {
                        HeroConnections heroConnections = new HeroConnections();
                        try {
                            heroConnections.setId(response.getString("id"));
                            heroConnections.setName(response.getString("name"));
                            heroConnections.setGroup_affiliation(response.getString("group-affiliation"));
                            heroConnections.setRelatives(response.getString("relatives"));
                            //Toast.makeText(MainActivity.this, heroConnections.toString() + "\n"+'}', Toast.LENGTH_LONG).show();
                            showToast(heroConnections.toString());
                        } catch (JSONException e) {
                           Toast.makeText(MainActivity.this,"ERROR AT CONNECTIONS",Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                MySingleton.getInstance(MainActivity.this).addToRequestQueue(request);
            }
            synchronized void jsonWork(String id) {
                int hid = Integer.parseInt(id);
                //Toast.makeText(MainActivity.this,"ID:"+id,Toast.LENGTH_SHORT).show();
                String url = "https://superheroapi.com/api/532645521053616/" + hid + "/work";
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    public synchronized void onResponse(JSONObject response) {
                        HeroWork heroWork = new HeroWork();
                        try {
                            heroWork.setId(response.getString("id"));
                            heroWork.setName(response.getString("name"));
                            heroWork.setOccupation(response.getString("occupation"));
                            heroWork.setBase(response.getString("base"));
                            //Toast.makeText(MainActivity.this, heroWork.toString() + "\n"+'}', Toast.LENGTH_LONG).show();
                            showToast(heroWork.toString());
                        } catch (JSONException e) {
                            Toast.makeText(MainActivity.this,"ERROR AT WORK",Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                MySingleton.getInstance(MainActivity.this).addToRequestQueue(request);
            }
            synchronized void jsonImage(String id){
                int hid = Integer.parseInt(id);
                String url = "https://superheroapi.com/api/532645521053616/"+hid+"/image";
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>(){
                    @Override
                    public synchronized void onResponse(JSONObject response) {
                        HeroImage heroImage = new HeroImage();
                        try {
                            heroImage.setId(response.getString("id"));
                            heroImage.setName(response.getString("name"));
                            heroImage.setUrl(response.getString("url"));
                            String imgurl = response.getString("url");
                            Picasso.with(MainActivity.this).load(imgurl).priority(HIGH).into(img_hero);
                            //Toast.makeText(MainActivity.this,heroImage.toString()+"\n"+'}',Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            Toast.makeText(MainActivity.this,"ERROR AT IMAGE",Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                MySingleton.getInstance(MainActivity.this).addToRequestQueue(request);
            }
        });
        btn_fil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFilterpage();
            }
        });
    }

    public void showToast(String s) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.layout_toast, (ViewGroup) findViewById(R.id.toast_root));
        TextView toastText = layout.findViewById(R.id.textView);

        toastText.setText(s);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    public void openFilterpage(){
        Intent intent = new Intent(this, FilterActivity.class);
        startActivity(intent);
    }

}