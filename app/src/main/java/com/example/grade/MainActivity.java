package com.example.grade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText prog,struct,algo;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//2.3
        prog=findViewById(R.id.editText);
        struct=findViewById(R.id.editText2);
        algo=findViewById(R.id.editText3);
        bt=findViewById(R.id.button);
    }

    private boolean isVaild(EditText text){
        String flag="1[0]{2}|[0-9]{1,2}";
        String str=text.getText().toString();
        if(str.matches(flag))
            return true;
        else{
            text.setError("0~100");
            return false;
        }
    }

    public void clickDown(View v){
        if(!isVaild(prog)||!isVaild(struct)||!isVaild(algo))
            return;
        Bundle bundle=new Bundle();
        Intent intent=new Intent(this,ResultC.class);
        bundle.putInt("prog",Integer.parseInt(prog.getText().toString()));
        bundle.putInt("struct",Integer.parseInt(struct.getText().toString()));
        bundle.putInt("algo",Integer.parseInt(algo.getText().toString()));
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
