package com.nero.starx.automatonx.views;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.nero.starx.automatonx.R;
import com.nero.starx.automatonx.databinding.ActivityOperationBinding;
import com.nero.starx.automatonx.viewmodels.CheckerViewModel;

public class OperationActivity extends AppCompatActivity {

    ActivityOperationBinding operationBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setTheme(R.style.Light);
        operationBinding = DataBindingUtil.setContentView(this , R.layout.activity_operation);
        operationBinding.setCheckerViewModel(new CheckerViewModel());
        operationBinding.checkButton.setOnClickListener(operationListener);

    }

    View.OnClickListener operationListener = (v) -> {
        operationBinding.getCheckerViewModel().StartOperation();
        if(operationBinding.getCheckerViewModel().isEncluded()){

            operationBinding.output.setText("Ce mot appartient à l'Automate");
            operationBinding.output.setTextColor(Color.GREEN);
        }else{

            operationBinding.output.setText("Ce mot n'appartient pas à l'Automate");
            operationBinding.output.setTextColor(Color.RED);
        }
    };
}
