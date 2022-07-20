package xyz.gaborohez.starwarsencyclopedia;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void addFragment(Fragment fragment, int parentLayout){
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

}
