package com.clementserrano.myapplication;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnToast;
    private Button btnCustomToast;
    private Button btnLog;

    private final String TAG = "HELLOTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToast = (Button) findViewById(R.id.btnToast);
        btnCustomToast = (Button) findViewById(R.id.btnCustomToast);
        btnLog = (Button) findViewById(R.id.btnLog);

        btnToast.setOnClickListener(this);
        btnCustomToast.setOnClickListener(this);
        btnLog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(btnToast)) {
            //display toast
            Toast.makeText(this, "displaying a toast !", Toast.LENGTH_LONG).show();
        } else if (v.equals(btnCustomToast)) {
            //display custom toast
            displayCustomToast();
        } else if (v.equals(btnLog)) {
            //display log
            Log.i(TAG, "displaying a log !");
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"Welcome Back !", Toast.LENGTH_LONG).show();
    }

    private void displayCustomToast() {
        LayoutInflater inflater = getLayoutInflater();
        //construct view using xml layout
        View layout = inflater.inflate(R.layout.toast_layout,
                (ViewGroup) findViewById(R.id.toast_layout_root));
        //get textView component
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("This is a custom toast");
        //prepare the toast and display to
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(500,VibrationEffect.DEFAULT_AMPLITUDE));
        }else{
            //deprecated in API 26
            v.vibrate(2000);
        }
    }
}
