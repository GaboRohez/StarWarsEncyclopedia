package xyz.gaborohez.starwarsencyclopedia.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeopleResponse {
    @Expose
    @SerializedName("results")
    private List<Character> results;
    @Expose
    @SerializedName("previous")
    private String previous;
    @Expose
    @SerializedName("next")
    private String next;
    @Expose
    @SerializedName("count")
    private int count;

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "PeopleResponse{" +
                "results=" + results +
                ", previous='" + previous + '\'' +
                ", next='" + next + '\'' +
                ", count=" + count +
                '}';
    }
}
