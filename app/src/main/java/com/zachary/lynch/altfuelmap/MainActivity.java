package com.zachary.lynch.altfuelmap;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private StationData mFuelStations;
    // @BindView(R.id.textBox) TextView mTextView;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ButterKnife.bind(this);
        mTextView = (TextView) findViewById(R.id.textBox);

        // hid api key from GitHub
        ApiKey apiKey = new ApiKey();

        // TODO: 1. build the url
        String fuelUrl = "https://developer.nrel.gov/api/alt-fuel-stations/v1.json?limit=1&api_key="
                + apiKey.getAPI_KEY();

        if(isNetworkAvailable()){

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(fuelUrl)
                    .build();
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    String jsonData = response.body().string();
                    if (response.isSuccessful()){
                        try {
                            mFuelStations = getDetails(jsonData);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mTextView.setText(mFuelStations.getTotal() + "");
                                }
                            });

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }
            });
        }
    }

    private StationData getDetails(String jsonData) throws JSONException {
        JSONObject stations = new JSONObject(jsonData);
        int total = stations.getInt("total_results");
        Log.i(TAG, "From JSON " + total);
        StationData stationData = new StationData();
        stationData.setTotal(stations.getInt("total_results"));
        return stationData;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager)
                getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        Boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()){
            isAvailable = true;
        }
        return isAvailable;
    }

}
