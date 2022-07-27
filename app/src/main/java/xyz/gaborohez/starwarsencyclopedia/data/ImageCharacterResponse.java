package xyz.gaborohez.starwarsencyclopedia.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageCharacterResponse {
    @Expose
    @SerializedName("data")
    private Data data;
    @Expose
    @SerializedName("message")
    private String message;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Data {
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("image_url")
        private String urlImage;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrlImage() {
            return urlImage;
        }

        public void setUrlImage(String urlImage) {
            this.urlImage = urlImage;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "name='" + name + '\'' +
                    ", urlImage='" + urlImage + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ImageCharacterResponse{" +
                "data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
