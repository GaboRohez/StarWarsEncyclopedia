package xyz.gaborohez.starwarsencyclopedia.ui.home.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import xyz.gaborohez.starwarsencyclopedia.base.BaseFragment;
import xyz.gaborohez.starwarsencyclopedia.databinding.FragmentHomeBinding;
import xyz.gaborohez.starwarsencyclopedia.ui.home.interactor.HomeInteractor;
import xyz.gaborohez.starwarsencyclopedia.ui.home.presenter.HomeContract;
import xyz.gaborohez.starwarsencyclopedia.ui.home.presenter.HomePresenter;

public class HomeFragment extends BaseFragment<HomeContract.Presenter, FragmentHomeBinding> implements HomeContract.View {

    private FragmentHomeBinding binding;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        presenter = new HomePresenter(this, new HomeInteractor());
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}