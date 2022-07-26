package xyz.gaborohez.starwarsencyclopedia.network;

import io.reactivex.Single;
import retrofit2.http.GET;
import xyz.gaborohez.starwarsencyclopedia.data.PeopleResponse;

public interface ApiEndPoint {

    @GET("people/")
    Single<PeopleResponse> getPeople();

}
