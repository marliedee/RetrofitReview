package org.pursuit.nasa_roverview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DisplayActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();

        imageView = findViewById(R.id.imageviewtwo);
        textView = findViewById(R.id.text2);

        String date = intent.getStringExtra("date");
        Picasso.get()
                .load("https" + intent.getStringExtra("image").substring(4))
                .into(imageView);
        textView.setText(date);


    }
}
