package xyz.gaborohez.starwarsencyclopedia.ui.home.presenter;

import xyz.gaborohez.starwarsencyclopedia.base.BasePresenter;

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter{

    private HomeContract.Interactor interactor;

    public HomePresenter(HomeContract.View view, HomeContract.Interactor interactor) {
        super(view);
        this.interactor = interactor;
    }
}
