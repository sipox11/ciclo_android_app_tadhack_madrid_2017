package ciclo.tadhack.com.ciclotadhack;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.security.Permission;
import java.util.concurrent.TimeUnit;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        try {
            Intent i = new Intent(SplashActivity.this, MainActivity.class);
            String[] params = getIntent().getData().toString().split("videocall", 2)[1].substring(1).split("&");
            if (params != null) {
                for (String s : params) {
                    String key = s.split("=")[0];
                    String value = s.split("=")[1];
                    Log.d("Splash", "Key: " + key + " - Value: " + value);
                    i.putExtra(key, value);
                }
            }
            final Handler handler = new Handler();
            handler.postDelayed(new MyRunnable(i), 3000);
        } catch (Exception e){
            e.printStackTrace();
            Intent i = new Intent(SplashActivity.this, MainActivity.class);
            final Handler handler2 = new Handler();
            handler2.postDelayed(new MyRunnable(i), 3000);
        }

    }
    private class MyRunnable implements Runnable {
        private Intent intent;
        private MyRunnable(Intent intent) {
            this.intent = intent;
        }

        public void run() {
            startActivity(intent);
        }
    }
}
