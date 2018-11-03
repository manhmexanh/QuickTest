package com.example.administrator.quicktest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Create by Nguyen Tuan Manh 20142871
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtInputTime;
    private EditText edtStartTime;
    private EditText edtEndTime;
    private Button btnTest;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        edtInputTime = findViewById(R.id.edt_input_time);
        edtStartTime = findViewById(R.id.edt_start_time_scope);
        edtEndTime = findViewById(R.id.edt_end_time_scope);
        btnTest = findViewById(R.id.btn_test);
        tvResult = findViewById(R.id.tv_result);
        btnTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
                showResult();
                break;
        }
    }

    private boolean checkTime(int timeCheck, int timeStart, int timeEnd) {
        if (timeCheck < 0 || timeCheck > 23) {
            Toast.makeText(this, "time check must be >=0 & <=23", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (timeStart < 0 || timeStart > 23) {
            Toast.makeText(this, "time start must be >=0 & <=23", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (timeEnd < 0 || timeEnd > 23){
            Toast.makeText(this,"time end must be >=0 & <=23",Toast.LENGTH_SHORT).show();
            return false;
        }

        else if (timeStart <= timeEnd) {
            return timeCheck >= timeStart && timeCheck <= timeEnd;
        }

        else {
            return timeCheck >= timeStart || timeCheck <= timeEnd;
        }
    }

    private boolean checkInputType() {
        int timeCheck;
        int timeStart;
        int timeEnd;
        if (edtInputTime.getText().toString().equals("")) {
            Toast.makeText(this,"please input time check",Toast.LENGTH_SHORT).show();
            return false;
        } else if (edtStartTime.getText().toString().equals("")) {
            Toast.makeText(this,"please input time start",Toast.LENGTH_SHORT).show();
            return false;
        } else if (edtEndTime.getText().toString().equals("")) {
            Toast.makeText(this,"please input time end",Toast.LENGTH_SHORT).show();
            return false;
        } else {
            timeCheck = Integer.parseInt(edtInputTime.getText().toString());
            timeStart = Integer.parseInt(edtStartTime.getText().toString());
            timeEnd = Integer.parseInt(edtEndTime.getText().toString());
            return checkTime(timeCheck, timeStart, timeEnd);
        }
    }

    private void showResult() {
        if (checkInputType()) {
            tvResult.setText(getString(R.string.true_result));
        } else {
            tvResult.setText(getString(R.string.false_result));
        }
    }
}
