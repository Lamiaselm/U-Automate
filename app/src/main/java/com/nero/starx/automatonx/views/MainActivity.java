package com.nero.starx.automatonx.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.nero.starx.automatonx.R;
import com.nero.starx.automatonx.databinding.ActivityMainBinding;
import com.nero.starx.automatonx.viewmodels.AutomatonViewModel;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        activityMainBinding = DataBindingUtil.setContentView(this , R.layout.activity_main);
        activityMainBinding.setAutomatonModel(new AutomatonViewModel());
        activityMainBinding.executePendingBindings();
        preferences = getSharedPreferences("DATA" , MODE_PRIVATE);
        activityMainBinding.button.setOnClickListener(listener1);
    }

    View.OnClickListener listener1 = (v) -> {
        activityMainBinding.getAutomatonModel().storeData(preferences);
        startActivity(new Intent(MainActivity.this , MatrixActivity.class));
    };

}
