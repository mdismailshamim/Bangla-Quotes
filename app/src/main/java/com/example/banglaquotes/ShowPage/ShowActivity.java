package com.example.banglaquotes.ShowPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.banglaquotes.R;
import com.example.banglaquotes.adapters.Quotes;

public class ShowActivity extends AppCompatActivity {
    private ImageView imageTv;
    private TextView titleTv;
    private TextView detailsTv;
    public static final String EXTRA_SHOW_PAGE = "extra_page";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        imageTv = findViewById(R.id.imageTv);
        titleTv= findViewById(R.id.titleTv);
        detailsTv = findViewById(R.id.detailsTv);
        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            final Quotes quotes = (Quotes) intent.getSerializableExtra(EXTRA_SHOW_PAGE);
            imageTv.setImageResource(quotes.getImages());
            titleTv.setText(quotes.getTitle());
            detailsTv.setText(quotes.getDetails());
            imageTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ShowActivity.this, quotes.getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void back(View view) {
        onBackPressed();
    }
}