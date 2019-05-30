package com.example.grade;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
        alert(avg);
    }

    public void close(View v){
        finish();
    }

    private void alert(double avg){
        String text=new String();
        String title=new String();
        int pic;

        if(avg>=60){
            text="恭喜您及格了!!!";
            title="Pass!";
            pic=R.drawable.pass;
        }
        else{
            text="天啊你不及格....GGGGGG...";
            title="It's very sad....QQ";
            pic=R.drawable.fail;
        }

        AlertDialog.Builder build=new AlertDialog.Builder(this);
        build.setMessage(text);
        build.setTitle(title);
        build.setIcon(pic);
        build.setPositiveButton("OK",null);
        build.setNegativeButton("Cancel",null);
        build.setNeutralButton("Nothing",null);
        build.show();
    }
}
