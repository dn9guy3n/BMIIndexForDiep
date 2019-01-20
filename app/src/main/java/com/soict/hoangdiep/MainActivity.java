package com.soict.hoangdiep;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextInputLayout mInputTextHeight, mInputTextWeight;
    private Button mButtonCalculate;
    private TextView mTextBMIIndex, mTextBMIStatus;
    private float mHeight, mWeight, mBMIIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInputTextHeight = findViewById(R.id.text_input_height);
        mInputTextWeight = findViewById(R.id.text_input_weight);
        mButtonCalculate = findViewById(R.id.button_calculate);
        mTextBMIIndex = findViewById(R.id.text_bmi_index);
        mTextBMIStatus = findViewById(R.id.text_bmi_status);
        mButtonCalculate.setOnClickListener(this);
    }

    private float calculateBMI(float weight, float height) {
        return weight / (height / 100) / (height / 100);
    }

    private String getBMIStatus(float bmiIndex) {
        if (bmiIndex < 18.5) {
            return "Gay";
        } else if (bmiIndex < 24.9) {
            return "Binh Thuong";
        } else if (bmiIndex < 29.9) {
            return "Hoi Beo";
        } else if (bmiIndex < 34.9) {
            return "Beo Phi Cap Do 1";
        } else if (bmiIndex < 39.9) {
            return "Beo Phi Cap Do 2";
        } else {
            return "Beo Phi Cap Do 3";
        }
    }

    @Override
    public void onClick(View v) {
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        mHeight = Float.valueOf(mInputTextHeight.getEditText().getText().toString());
        mWeight = Float.valueOf(mInputTextWeight.getEditText().getText().toString());
        mBMIIndex = calculateBMI(mWeight, mHeight);
        mTextBMIIndex.setText(String.format("Your BMI index is %.1f", mBMIIndex));
        mTextBMIStatus.setText(getBMIStatus(mBMIIndex));
    }
}
