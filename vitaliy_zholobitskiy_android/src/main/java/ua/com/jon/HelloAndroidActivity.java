package ua.com.jon;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import org.apache.http.NameValuePair;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

public class HelloAndroidActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        final Button buttonLogin = (Button) findViewById(R.id.buttonLogin);
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                new MyDownloadTask().execute();
            }
        });
        /*final Button hello = (Button) findViewById(R.id.button1);
        final Button button2 = (Button) findViewById(R.id.button2);
        final EditText editText = (EditText) findViewById(R.id.editText2);
        ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);
        Handler handler = new Handler();
        // EditText text = (EditText)findViewById(R.id.editText);
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                editText.setText(button2.getText().toString());

            }
        });
        hello.setOnClickListener(new OnClickListener() {
            int i;
            public void onClick(View v) {
                editText.setText(hello.getText().toString());
                //      text.setText("Button");
            }
        });*/


    }


    class MyDownloadTask extends AsyncTask<Void, Void, String> {
        protected void onPreExecute() {
        }

        protected String doInBackground(Void... params) {
            return connect();
        }

        protected void onPostExecute(String result) {
            if(!result.equals("FALSE")){
                Intent intent = new Intent(HelloAndroidActivity.this, SimpleListActivity.class);
                startActivity(intent);
            }
        }
    }

    public String connect() {
        String urlStr = "http://10.0.2.2:8085/loginDriver";//
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
            final EditText editTextLogin = (EditText) findViewById(R.id.editTextLogin);
            final EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);
            System.out.println(editTextLogin.getText().toString());
            System.out.println(editTextPassword.getText().toString());
            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("phone", editTextLogin.getText().toString())
                    .appendQueryParameter("password", editTextPassword.getText().toString());

                    /*.appendQueryParameter("phone", "380992222222")
                    .appendQueryParameter("password", "1111");*/
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
                response+=inputLine;
            }
            System.out.println("---"+response+"---");
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

}

