package xyz.gaborohez.starwarsencyclopedia.ui.home.presenter;

import android.util.Log;

import xyz.gaborohez.starwarsencyclopedia.base.BasePresenter;
import xyz.gaborohez.starwarsencyclopedia.base.StarWarsApplication;

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter{

    private static final String TAG = "HomePresenter";

    private HomeContract.Interactor interactor;

    public HomePresenter(HomeContract.View view, HomeContract.Interactor interactor) {
        super(view);
        this.interactor = interactor;
    }

    @Override
    public void getPeople() {
        addSubscription(interactor
                .getPeople()
                .doOnSubscribe(disposable -> view.showLoader())
                .doAfterTerminate(() -> view.hideLoader())
                .subscribe(response -> {
                    if (!response.getResults().isEmpty()){
                        view.showCharacters(response);
                    }else {
                        view.showError(StarWarsApplication.androidResourceManager.getEmptyListError());
                    }
                }, throwable -> {
                    view.showError(StarWarsApplication.androidResourceManager.getErrorMessage());
                }));
    }
}
