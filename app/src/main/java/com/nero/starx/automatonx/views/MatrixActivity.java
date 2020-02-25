package com.nero.starx.automatonx.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.nero.starx.automatonx.R;
import com.nero.starx.automatonx.databinding.ActivityMatrixBinding;
import com.nero.starx.automatonx.viewmodels.TransitionViewModel;

public class MatrixActivity extends AppCompatActivity {
    ActivityMatrixBinding matrixBind;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = getSharedPreferences("DATA" , MODE_PRIVATE);
        setTheme(R.style.AppTheme);
        matrixBind = DataBindingUtil.setContentView(this , R.layout.activity_matrix);
        matrixBind.setTransitionViewModel(new TransitionViewModel(prefs));
        matrixBind.executePendingBindings();

        matrixBind.state1.setText(matrixBind.getTransitionViewModel().getStates().get(0).getName());
        matrixBind.state12.setText(matrixBind.getTransitionViewModel().getStates().get(0).getName());

        matrixBind.state2.setText(matrixBind.getTransitionViewModel().getStates().get(1).getName());
        matrixBind.state22.setText(matrixBind.getTransitionViewModel().getStates().get(1).getName());

        matrixBind.state3.setText(matrixBind.getTransitionViewModel().getStates().get(2).getName());
        matrixBind.state32.setText(matrixBind.getTransitionViewModel().getStates().get(2).getName());

        matrixBind.confirmAutomate.setOnClickListener(ConfirmListener);

    }

    View.OnClickListener ConfirmListener = (v) -> {
        matrixBind.getTransitionViewModel().emergeData(prefs);
        startActivity(new Intent(MatrixActivity.this , OperationActivity.class));
    };




}
