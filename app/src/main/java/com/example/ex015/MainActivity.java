package com.example.ex015;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int mainPage;
    Double numa,numb,numc;
    EditText opa,opb,opc;
    TextView x1,x2;
    Random rnd = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opa=(EditText) findViewById(R.id.opa);
        opb=(EditText) findViewById(R.id.opb);
        opc=(EditText) findViewById(R.id.opc);
        x1=(TextView) findViewById(R.id.x1);
        x2=(TextView) findViewById(R.id.x2);

        mainPage=1;
    }

    public void random(View view) {
        numa=Double.MIN_VALUE+(Double.MAX_VALUE-Double.MIN_VALUE)*rnd.nextDouble();
        numb=Double.MIN_VALUE+(Double.MAX_VALUE-Double.MIN_VALUE)*rnd.nextDouble();
        numc=Double.MIN_VALUE+(Double.MAX_VALUE-Double.MIN_VALUE)*rnd.nextDouble();
        opa.setText(numa.toString());
        opb.setText(numb.toString());
        opc.setText(numc.toString());
    }

    public void solving(View view) {
        numa=Double.parseDouble(opa.getText().toString());
        numb=Double.parseDouble(opb.getText().toString());
        numc=Double.parseDouble(opc.getText().toString());

        Intent goSolve= new Intent(this,Solving.class);
        goSolve.putExtra("para",numa);
        goSolve.putExtra("parb",numb);
        goSolve.putExtra("parc",numc);
        startActivityForResult(goSolve,mainPage);
    }
    protected void onActivityResult(int source,int good,@Nullable Intent data_back) {
        super.onActivityResult(source, good, data_back);
        if ((source == mainPage)) {
            if (data_back != null) {
                x1.setText("X1= " + data_back.getDoubleExtra("answer1", 0.0));
                x2.setText("X2= " + data_back.getDoubleExtra("answer2", 0.0));
            }
        }
    }
}