package my.lesson_4;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserGithub {

    @SerializedName("login")
    @Expose
    private String name;

    @SerializedName("avatar_url")
    @Expose
    private String faceWharton;

    public String getFaceWhartonUrl() {
        return faceWharton;
    }

    public void setFaceWharton(String faceWharton) {
        this.faceWharton = faceWharton;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
