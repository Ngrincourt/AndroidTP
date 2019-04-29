package bo;

import android.os.Parcel;
import android.os.Parcelable;

public class Article implements Parcelable {
    private String nom;
    private double prix;
    private String description;
    private float degreEnvie;
    private String url;
    private boolean isAchete;

    public Article(String nom, double prix, String description, float degreEnvie, String url, boolean isAchete) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.degreEnvie = degreEnvie;
        this.url = url;
        this.isAchete = isAchete;
    }

    protected Article(Parcel in) {
        nom = in.readString();
        prix = in.readDouble();
        description = in.readString();
        degreEnvie = in.readFloat();
        url = in.readString();
        isAchete = in.readByte() != 0;
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getDegreEnvie() {
        return degreEnvie;
    }

    public void setDegreEnvie(float degreEnvie) {
        this.degreEnvie = degreEnvie;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isAchete() {
        return isAchete;
    }

    public void setAchete(boolean achete) {
        isAchete = achete;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeDouble(prix);
        dest.writeString(description);
        dest.writeFloat(degreEnvie);
        dest.writeString(url);
        dest.writeByte((byte) (isAchete ? 1 : 0));
    }
}
