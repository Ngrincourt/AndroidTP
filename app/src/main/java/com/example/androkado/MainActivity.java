package com.example.androkado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import bo.Article;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_EXTRA_ARTICLE = "KEY_EXTRA_ARTICLE";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final Article article = new Article("Pain au chocolat", 5, "Ceci est un pain au chocolat", 2, "cecicestuneurl");

        TextView textViewTitre = findViewById(R.id.textViewTitre);
        TextView textViewPrix = findViewById(R.id.textViewPrix);
        TextView textViewDescription = findViewById(R.id.textViewDescription);
        RatingBar ratingBarDegreEnvie = findViewById(R.id.ratingBarDegreEnvie);

        textViewTitre.setText(article.getNom());
        textViewPrix.setText(String.valueOf(article.getPrix()));
        textViewDescription.setText(article.getDescription());
        ratingBarDegreEnvie.setRating(article.getDegreEnvie());

        ImageButton buttonWeb = findViewById(R.id.imageButtonWeb);
        buttonWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, article.getUrl(), Toast.LENGTH_SHORT).show();
               Intent intentToInfoUrl = new Intent(MainActivity.this, InfoUrlActivity.class);
               intentToInfoUrl.putExtra(KEY_EXTRA_ARTICLE, article);
               startActivity(intentToInfoUrl);
            }
        });


    }


}
