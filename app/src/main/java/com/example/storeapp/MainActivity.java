package com.example.storeapp;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< Updated upstream:app/src/main/java/com/example/storeapp/MainActivity.java
import android.os.Bundle;
=======
import com.example.storeapp.R;
import com.example.storeapp.StoreApplication;
import com.example.storeapp.di.application.AppComponent;
>>>>>>> Stashed changes:app/src/main/java/com/example/storeapp/ui/MainActivity.java

public class MainActivity extends AppCompatActivity {

    private AppComponent appComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        appComponent = ((StoreApplication) getApplication()).getDaggerAppComponent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public AppComponent getAppComponent () {
        return appComponent;
    }
}