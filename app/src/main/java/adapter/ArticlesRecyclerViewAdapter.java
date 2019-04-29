package adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androkado.MainActivity;
import com.example.androkado.R;

import java.util.ArrayList;

import bo.Article;

public class ArticlesRecyclerViewAdapter extends RecyclerView.Adapter<ArticlesRecyclerViewAdapter.ArticleViewHolder> {

    private static final String KEY_EXTRA_ARTICLE = "KEY_EXTRA_ARTICLE";
    private ArrayList<Article> listArticles;

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNom;
        TextView textViewPrix;
        RatingBar ratingBarDegreEnvie;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNom = itemView.findViewById(R.id.textViewNom);
            textViewPrix = itemView.findViewById(R.id.textViewPrix);
            ratingBarDegreEnvie = itemView.findViewById(R.id.ratingBarDegreEnvie);
        }
    }

    public ArticlesRecyclerViewAdapter(ArrayList<Article> arrayList) {
        this.listArticles = arrayList;
    }

    @Override
    public int getItemCount() {
        // On retourne la taille de la liste
        return listArticles.size();
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // On  récupère la vue de la ligne contenant un item et on la retourne
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout_article, viewGroup, false);
        return new ArticleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder articleViewHolder, int i) {
        // On récupère les articles et on les affiches 1 par 1
        final Article articleToDisplay = listArticles.get(i);
        articleViewHolder.textViewNom.setText(articleToDisplay.getNom());
        articleViewHolder.textViewPrix.setText(String.valueOf(articleToDisplay.getPrix()));
        articleViewHolder.ratingBarDegreEnvie.setRating(articleToDisplay.getDegreEnvie());

        // CHANGER LE RATING BAR PERMET DE LE CHANGER EN BDD 
        articleViewHolder.ratingBarDegreEnvie.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
               articleToDisplay.setDegreEnvie(rating);


            }
        });

        // Permet de rendre clickable un élément de la liste
        articleViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(), articleToDisplay.getNom(), Toast.LENGTH_SHORT).show();
                Intent intentToMainActivity = new Intent(v.getContext(), MainActivity.class);
                intentToMainActivity.putExtra(KEY_EXTRA_ARTICLE, articleToDisplay);
                v.getContext().startActivity(intentToMainActivity);
            }

        });

    }


}
