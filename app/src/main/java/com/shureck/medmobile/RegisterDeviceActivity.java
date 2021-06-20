package com.shureck.medmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.shureck.medmobile.Models.DoctorMessage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterDeviceActivity extends AppCompatActivity {

    private String token;
    String strr;
    private final OkHttpClient client = new OkHttpClient();
    EditText manufacturer;
    EditText model;
    EditText serial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_device);

        WorkWithToken workWithToken = new WorkWithToken(RegisterDeviceActivity.this);
        token = workWithToken.readToken();

        manufacturer = findViewById(R.id.manufacturer);
        model = findViewById(R.id.model);
        serial = findViewById(R.id.serial);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IOAsyncTask().execute("http://10.50.3.240:8080/patient/addTonometer");
            }
        });
    }


    class IOAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            return sendData(params[0]);
        }

        @Override
        protected void onPostExecute(String response) {
            strr = response;
            System.out.println(strr);
            Gson gson = new Gson();
//            List<DoctorMessage> previews = stringToArray(strr, DoctorMessage[].class);
//            System.out.println("DDD "+previews.get(0).getDoctorName());
        }
    }

    public static <T> List<T> stringToArray(String s, Class<T[]> clazz) {
        T[] arr = new Gson().fromJson(s, clazz);
        return Arrays.asList(arr); //or return Arrays.asList(new Gson().fromJson(s, clazz)); for a one-liner
    }

    public String sendData(String str){
        try {
            RequestBody formBody = new FormBody.Builder()
                    .add("model", model.getText().toString())
                    .add("serialNumber", serial.getText().toString())
                    .add("manufacturer", manufacturer.getText().toString())
                    .build();

            Request request = new Request.Builder()
                    .url(str)
                    .header("Authorization","Bearer "+token)
                    .post(formBody)
                    .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }
}