package xyz.gaborohez.starwarsencyclopedia.base;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

public abstract class BaseFragment<T, B extends ViewBinding> extends Fragment {

    protected T presenter;
    protected B binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void addFragment(Fragment fragment, int parentLayout) {
        getChildFragmentManager().beginTransaction()
                .add(parentLayout, fragment, fragment.getClass().getName())
                .addToBackStack(fragment.getClass().getName())
                .commitAllowingStateLoss();

    }

    public void replaceFragment(Fragment fragment, int parentLayout) {
        getChildFragmentManager().beginTransaction()
                .replace(parentLayout, fragment, fragment.getClass().getName())
                .commit();
    }

    @Override
    public void onDestroy() {
        if (presenter != null) {
            ((BasePresenter) presenter).detachView();
            presenter = null;
        }

        if (binding != null) {
            binding = null;
        }
        Log.i(this.getClass().getSimpleName(), "onDestroy");
        super.onDestroy();
    }
}
