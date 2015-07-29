package ua.com.jon;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleListActivity extends ListActivity {
    private ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<String> values = new ArrayList<String>(Arrays.asList("Android", "iPhone", "WindowsMobile"));

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        final String item = adapter.getItem(position);
        final Handler handler = new Handler();


        Runnable runnable = new Runnable() {
            public void run() {
                adapter.add(item);
                handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(runnable, 1);

        new MyDownloadTask().execute();
        Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(ua.com.jon.R.menu.main, menu);
        return true;
    }

    public static void connect() {
        String urlStr = "http://www.google.com.ua/search?q=cofee%20java";
        URL url = null;
        HttpURLConnection con = null;
        try {
            url = new URL(urlStr);

            con = (HttpURLConnection) url.openConnection();
//        con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            //StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine).append('\n');
                System.out.println(inputLine + '\n');
            }
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

    static class MyDownloadTask extends AsyncTask<Void, Void, Void> {
        protected void onPreExecute() {
            //display progress dialog.
        }

        protected Void doInBackground(Void... params) {
            connect();
            return null;
        }

        protected void onPostExecute(Void result) {
            // dismiss progress dialog and update ui
        }
    }
}

