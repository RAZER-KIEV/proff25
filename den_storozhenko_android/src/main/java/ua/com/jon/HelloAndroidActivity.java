package ua.com.jon;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

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
                hello.setText("Hello");
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

}

