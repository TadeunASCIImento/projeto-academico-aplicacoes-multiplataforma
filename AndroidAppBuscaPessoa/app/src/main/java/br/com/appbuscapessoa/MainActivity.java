package br.com.appbuscapessoa;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;

public class MainActivity extends AppCompatActivity {

    private static final int ESPERA_SPLASH = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            setContentView (R.layout.activity_splash);
            final Intent intent = new Intent (this,LoginActivity.class);
            new Handler ().postDelayed (new Runnable () {

                @Override
                public void run() {
                    if(!(getSupportActionBar ().equals (null))){
                        getSupportActionBar ().show ();
                    }
                    startActivity (intent);
                }


            },ESPERA_SPLASH);



        }

    }

}
