package bo;

import android.os.Parcel;
import android.os.Parcelable;

public class Article implements Parcelable {
    private String nom;
    private float prix;
    private String description;
    private int degreEnvie;
    private String url;

    public Article(String nom, float prix, String description, int degreEnvie, String url) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.degreEnvie = degreEnvie;
        this.url = url;
    }

    protected Article(Parcel in) {
        nom = in.readString();
        prix = in.readFloat();
        description = in.readString();
        degreEnvie = in.readInt();
        url = in.readString();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDegreEnvie() {
        return degreEnvie;
    }

    public void setDegreEnvie(int degreEnvie) {
        this.degreEnvie = degreEnvie;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeFloat(prix);
        dest.writeString(description);
        dest.writeInt(degreEnvie);
        dest.writeString(url);
    }
}
