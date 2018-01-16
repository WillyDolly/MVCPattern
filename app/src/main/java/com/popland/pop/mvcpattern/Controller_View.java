package com.popland.pop.mvcpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Observable;
import java.util.Observer;

//Activity is controller and view, it observes model
public class Controller_View extends AppCompatActivity implements Observer, View.OnClickListener {
Button btn0, btn1, btn2;
Model mModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller__view);
        mModel = new Model();
        mModel.addObserver(this);//model register to Activity
        btn0 = (Button)findViewById(R.id.btn0);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //controller call Model
        switch(view.getId()){
            case R.id.btn0:
                mModel.setValueAtIndex(0);
                break;
            case R.id.btn1:
                mModel.setValueAtIndex(1);
                break;
            case R.id.btn2:
                mModel.setValueAtIndex(2);
                break;
        }
    }

    @Override
    public void update(Observable observable, Object o) {//Model modify data and update UI
        btn0.setText("count "+mModel.getValueAtIndex(0));
        btn1.setText("count "+mModel.getValueAtIndex(1));
        btn2.setText("count "+mModel.getValueAtIndex(2));
    }
}
