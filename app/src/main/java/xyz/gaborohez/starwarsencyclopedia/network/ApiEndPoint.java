package xyz.gaborohez.starwarsencyclopedia.network;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import xyz.gaborohez.starwarsencyclopedia.data.ImageCharacterResponse;
import xyz.gaborohez.starwarsencyclopedia.data.PeopleResponse;

public interface ApiEndPoint {

    @GET("people/")
    Single<PeopleResponse> getPeople();

    @GET("characters/{name}")
    Single<ImageCharacterResponse> getImageCharacter(@Path("name") String name);
}
