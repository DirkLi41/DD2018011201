package tw.com.pcschool.dd2018011201;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View v)
    {
        RequestQueue queue1 = Volley.newRequestQueue(MainActivity.this);
        StringRequest request1 = new StringRequest(
                "http://data.ntpc.gov.tw/od/data/api/BF90FA7E-C358-4CDA-B579-B6C84ADC96A1?$format=json",
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        Log.d("NET", response);
//                        try {
//                            JSONArray array1 = new JSONArray(response);
//                            for (int i = 0;i < array1.length();i++)
//                            {
//                                JSONObject object1 = array1.getJSONObject(i);
//                                String str1 = object1.getString("district");
//                                Log.d("NET", str1);
//                            }
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
                        Gson gson1 = new Gson();
                        AnimalHouse[] animalHouse = gson1.fromJson(response, AnimalHouse[].class);
                        for (AnimalHouse a:animalHouse)
                        {
                            Log.d("NET", "地區:" + a.district + ",地址:" + a.address + ",電話:" + a.tel + ",開放時間:" + a.opening_hours);
                        }

                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        queue1.add(request1);
        queue1.start();
    }
}
