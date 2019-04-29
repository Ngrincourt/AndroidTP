package com.example.androkado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


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

        final Article article = getIntent().getParcelableExtra(KEY_EXTRA_ARTICLE);

        TextView textViewTitre = findViewById(R.id.textViewTitre);
        TextView textViewPrix = findViewById(R.id.textViewPrix);
        TextView textViewDescription = findViewById(R.id.textViewDescription);
        RatingBar ratingBarDegreEnvie = findViewById(R.id.ratingBarDegreEnvie);
        ToggleButton toogleButtonAchete = findViewById(R.id.toggleButtonAchete);
        ImageButton imageButtonWeb = findViewById(R.id.imageButtonWeb);

        textViewTitre.setText(article.getNom());
        textViewPrix.setText(String.valueOf(article.getPrix()));
        textViewDescription.setText(article.getDescription());
        ratingBarDegreEnvie.setRating(article.getDegreEnvie());
        toogleButtonAchete.setChecked(article.isAchete());



        // Permet de changer le true / false en fonction de l'appuie
        toogleButtonAchete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                article.setAchete(isChecked);
            }
        });

        imageButtonWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, article.getUrl(), Toast.LENGTH_SHORT).show();
                Intent intentToInfoUrl = new Intent(MainActivity.this, InfoUrlActivity.class);
                intentToInfoUrl.putExtra(KEY_EXTRA_ARTICLE, article);
                startActivity(intentToInfoUrl);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuStylo:
                Toast.makeText(this, "STYLO", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuEnvoye:
                Toast.makeText(this, "ENVOYEE", Toast.LENGTH_SHORT).show();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }


}
