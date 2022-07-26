package xyz.gaborohez.starwarsencyclopedia.ui.home.interactor;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import xyz.gaborohez.starwarsencyclopedia.data.PeopleResponse;
import xyz.gaborohez.starwarsencyclopedia.network.ApiEndPoint;
import xyz.gaborohez.starwarsencyclopedia.network.RetrofitClient;
import xyz.gaborohez.starwarsencyclopedia.ui.home.presenter.HomeContract;

public class HomeInteractor  implements HomeContract.Interactor{

    @Override
    public Single<PeopleResponse> getPeople() {
        return RetrofitClient.getInstance()
                .retrofit.create(ApiEndPoint.class)
                .getPeople()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
