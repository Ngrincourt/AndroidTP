package com.example.androkado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import bo.Article;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        final Article article = new Article("Pain au chocolat", 5, "Ceci est un pain au chocolat", 4, "cecicestuneurl");
        TextView titre = findViewById(R.id.textViewTitre);
        TextView prix = findViewById(R.id.textViewPrix);
        TextView description = findViewById(R.id.textViewDescription);



        titre.setText(article.getNom());
        prix.setText(String.valueOf(article.getPrix()));
        description.setText(article.getDescription());

        ImageButton buttonWeb = findViewById(R.id.imageButtonWeb);
        buttonWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, article.getUrl(), Toast.LENGTH_SHORT).show();

            }
        });


    }


}
