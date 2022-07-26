package xyz.gaborohez.starwarsencyclopedia.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Character {
    @Expose
    @SerializedName("gender")
    private String gender;
    @Expose
    @SerializedName("name")
    private String name;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Character{" +
                "gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
