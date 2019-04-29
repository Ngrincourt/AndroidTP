package com.example.androkado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import adapter.ArticlesRecyclerViewAdapter;
import bo.Article;

public class ListeArticlesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_articles);

        // On créé un tableau pour simuler un DB
        ArrayList<Article> listeArticles = new ArrayList<>();
        listeArticles.add(new Article("Pain au chocolat", 0.9, "Ceci est un pain au chocolat", 2.5f, "cecicestuneurl", false));
        listeArticles.add(new Article("Croissant", 1.9, "Ceci est un croissant", 1.5f, "cecicestuneurl", false));
        listeArticles.add(new Article("Beignet", 0.9, "Ceci est un beignet", 3.5f, "cecicestuneurl", false));

        // On récupère le recyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // On met le tableau d'article dans les lignes
        ArticlesRecyclerViewAdapter articleRecyclerViewAdapter = new ArticlesRecyclerViewAdapter(listeArticles);

        // On met la ligne dans le recyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // On modifie le recyclerview
        recyclerView.setAdapter(articleRecyclerViewAdapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_liste, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuAdd:
                Toast.makeText(this, "ADD", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuConfiguration:
                Toast.makeText(this, "CONFIGURATION", Toast.LENGTH_SHORT).show();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}

