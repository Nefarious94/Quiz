package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int index;
    private String[] preguntas, respuestas;
    private Toast toast;
    private TextView Q;
    Button T, F, N, P;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);
        index = 0;
        preguntas = getResources().getStringArray(R.array.preguntas);
        respuestas = getResources().getStringArray(R.array.respuestas);
        T = (Button) findViewById(R.id.True);
        F = (Button) findViewById(R.id.False);
        N = (Button) findViewById(R.id.Next);
        P = (Button) findViewById(R.id.Previous);
        Q = (TextView) findViewById(R.id.Question);
        Q.setText(preguntas[index]);

        T.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                toast.show();
                if (respuestas[index].equals("True")) {
                    toast.setText("Correct!");
                } else {
                    toast.setText("Incorrect!");
                }

            }
        });

        F.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                toast.show();
                if (respuestas[index].equals("False")) {
                    toast.setText("Correct!");
                } else {
                    toast.setText("Incorrect!");
                }

            }
        });
        N.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
              index++;
              refresh();
              Q.setText(preguntas[index]);
            }
        });
        P.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                index--;
                refresh();
                Q.setText(preguntas[index]);
            }
        });
    }

    private void refresh() {
        if(index==preguntas.length){
            index=0;
        }else if(index<0){
            index = preguntas.length-1;
        }
    }
}
