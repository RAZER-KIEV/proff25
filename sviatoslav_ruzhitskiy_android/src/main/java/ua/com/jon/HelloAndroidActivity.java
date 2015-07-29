package ua.com.jon;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HelloAndroidActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        final Button hello = (Button) findViewById(R.id.button1);
        ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);
        Handler handler = new Handler();
        // EditText text = (EditText)findViewById(R.id.editText);
        hello.setOnClickListener(new OnClickListener() {
            int i;

            public void onClick(View v) {
                new MyDownloadTask().execute();
                //hello.setText("Hello");
                //      text.setText("Button");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    static class MyDownloadTask extends AsyncTask<Void, Void, Void> {
        protected void onPreExecute() {
        }

        protected Void doInBackground(Void... params) {
            connect();
            return null;
        }

        protected void onPostExecute(Void result) {
        }
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
                System.out.println("OuTpUt: "+inputLine + '\n');
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
}

