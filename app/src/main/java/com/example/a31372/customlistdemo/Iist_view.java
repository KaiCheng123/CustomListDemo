package com.example.a31372.customlistdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Iist_view extends Activity {

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_layout);

        textView = (TextView) findViewById(R.id.text);
        imageView = (ImageView) findViewById(R.id.image);

        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("AnimalName"));
        imageView.setImageResource(intent.getIntExtra("image",0));
    }
}
