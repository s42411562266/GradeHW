package com.example.grade;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class ResultC extends AppCompatActivity {
    private TextView ans;
    private Button endButton;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cacl);
        ans=findViewById(R.id.textView2);
        endButton=findViewById(R.id.button2);
        showText();
    }

    private void showText() {
        NumberFormat nf=NumberFormat.getInstance();
        Bundle bundle=getIntent().getExtras();
        int prog=bundle.getInt("prog");
        int struct=bundle.getInt("struct");
        int algo=bundle.getInt("algo");
        int sum=prog+struct+algo;
        double avg=(double)sum/3.0;
        String text="programming= "+prog+"\ndata structure= "+struct+"\nAlgorithm= "+algo+"\nsum= "+sum+"\nAverage= "+nf.format(avg);
        ans.setText(text);
        ans.setTextSize(25);
    }

    public void close(View v){
        finish();
    }
}
