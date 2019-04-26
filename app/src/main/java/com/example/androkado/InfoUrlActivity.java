package com.example.androkado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import bo.Article;

import static com.example.androkado.MainActivity.KEY_EXTRA_ARTICLE;

public class InfoUrlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_url);

        Article article = getIntent().getParcelableExtra(KEY_EXTRA_ARTICLE);

        TextView textViewUrl = findViewById(R.id.textViewUrl);
        textViewUrl.setText(article.getUrl());
    }
}
