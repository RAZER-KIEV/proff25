package ua.com.jon;

import android.app.ListActivity;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SimpleListActivity extends ListActivity {
    private ArrayAdapter<String> adapter;
    HashMap<String,String> hashMap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            public void run() {
                new MyDownloadTask().execute();
                handler.postDelayed(this, 5000);
            }
        };
        handler.postDelayed(runnable, 1);
       /* List<String> values = new ArrayList<String>(Arrays.asList("Android", "iPhone", "WindowsMobile"));

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);*/
    }
    public void updateList(StringBuffer stringBuffer){

    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        final String item = adapter.getItem(position);
        System.out.println(hashMap.get(item));
        sendOrderTake(hashMap.get(item));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public static String connect() {
        String urlStr = "http://10.0.2.2:8085/getFreeOrders";
        URL url = null;
        HttpURLConnection con = null;
        String response = "";
        try {
            url = new URL(urlStr);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setDoInput(true);
            con.setDoOutput(true);

            /*Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("phone", "User1")
                    .appendQueryParameter("password", "1111");
            String query = builder.build().getEncodedQuery();

            OutputStream os = con.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(query);
            writer.flush();
            writer.close();
            os.close();*/

            con.connect();


            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response+=inputLine+"\n";

                //System.out.println(inputLine+"qqqqqqq" + '\n');
            }

            return response;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
        return response;
    }
    public static void sendOrderTake(String orderId) {
        String urlStr = "http://10.0.2.2:8085/takeOrder";
        URL url = null;
        HttpURLConnection con = null;
        String response = "";
        try {
            url = new URL(urlStr);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setDoInput(true);
            con.setDoOutput(true);

            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("order", orderId);
            String query = builder.build().getEncodedQuery();

            OutputStream os = con.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(query);
            writer.flush();
            writer.close();
            os.close();

            con.connect();


            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response+=inputLine+"\n";

                //System.out.println(inputLine+"qqqqqqq" + '\n');
            }
            System.out.println(response);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }

    }

    class MyDownloadTask extends AsyncTask<Void, Void, String> {
        protected void onPreExecute() {
            //display progress dialog.
        }

        protected String doInBackground(Void... params) {
            return connect();
        }

        protected void onPostExecute(String result) {
            String[] values = result.split("break");
            hashMap = new HashMap<String, String>();
            String val="";
            List<String> list = new ArrayList<String>();
            for(int i=0;i<values.length-1;i++){
                String[] data = values[i].split("p11p");
                val = data[3] + " " + data[1] + "-" + data[2];
                list.add(val);
                hashMap.put(val, data[0]);
            }
            adapter = new ArrayAdapter<String>(SimpleListActivity.this,
                    android.R.layout.simple_list_item_1, list);
            setListAdapter(adapter);
            // dismiss progress dialog and update ui
        }
    }
}

