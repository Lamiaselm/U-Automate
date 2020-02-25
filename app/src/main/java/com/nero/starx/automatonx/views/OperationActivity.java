package com.nero.starx.automatonx.views;

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
            operationBinding.layout.setBackgroundColor(getColor(R.color.SuccessPrimary));
            operationBinding.output.setText("This word belongs to the automate");
        }else{
            operationBinding.layout.setBackgroundColor(getColor(R.color.FailurePrimary));
            operationBinding.output.setText("This word does not belong to the automate");
        }
    };
}
