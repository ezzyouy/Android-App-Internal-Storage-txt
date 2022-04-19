package com.example.storageinterne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {


    private TextView txtmsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtmsg=findViewById(R.id.txt);
    }

    public void Ecrire(View view){
        try {
            FileOutputStream fileOutputStream=openFileOutput("MyFile.txt", MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(txtmsg.getText().toString());
            outputStreamWriter.close();
            Toast.makeText(this, "the file is saved successfully", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Lire(View view){
        int READ_BLOCK_SIZE = 100;
        try {
            FileInputStream fileInputStream=openFileInput("MyFile.txt");
            InputStreamReader reader= new InputStreamReader(fileInputStream);
            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String n="";
            int charRead;

            while((charRead=reader.read(inputBuffer))>0){
                String readerString= String.copyValueOf(inputBuffer,0,charRead);
                n+=readerString;
            }
            reader.close();
            txtmsg.setText(n);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}