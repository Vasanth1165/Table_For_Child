package com.example.tablesforchild;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerViewTable;

    public void generateTableInRecyclerView(int table){

        ArrayList<String> arr=new ArrayList<>();
        for(int i=1;i<=20;i++){
            String str=table+" X "+ i+" = ";
            str+=String.valueOf(i*table);
            arr.add(str);
        }
        mRecyclerViewTable.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewTable.setAdapter(new RecycleViewAdapter(arr,this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerViewTable=findViewById(R.id.tablesRecyleView);
        SeekBar mSeekBar=findViewById(R.id.numberseekBar);
        int min=1,max=21,StartPosition=1;
        mSeekBar.setMin(min);
        mSeekBar.setMax(max);
        mSeekBar.setProgress(StartPosition);
        generateTableInRecyclerView(StartPosition);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int seekNumber;
                if(i<min){
                    seekNumber=min;
                    mSeekBar.setProgress(seekNumber);
                }else{
                    seekNumber=i;
                }
                generateTableInRecyclerView(seekNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setProgress(0);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}