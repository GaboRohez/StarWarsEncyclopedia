package xyz.gaborohez.starwarsencyclopedia.ui.home.presenter;

import io.reactivex.Single;
import xyz.gaborohez.starwarsencyclopedia.data.PeopleResponse;

public interface HomeContract {
    interface View {

        void showCharacters(PeopleResponse response);
    }

    interface Presenter {

        void getPeople();
    }

    interface Interactor {

        Single<PeopleResponse> getPeople();
    }
}
