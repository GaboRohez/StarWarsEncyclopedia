package xyz.gaborohez.starwarsencyclopedia.ui.home.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import xyz.gaborohez.starwarsencyclopedia.base.BaseFragment;
import xyz.gaborohez.starwarsencyclopedia.data.Character;
import xyz.gaborohez.starwarsencyclopedia.data.PeopleResponse;
import xyz.gaborohez.starwarsencyclopedia.databinding.FragmentHomeBinding;
import xyz.gaborohez.starwarsencyclopedia.ui.home.adapter.ItemCharacterAdapter;
import xyz.gaborohez.starwarsencyclopedia.ui.home.interactor.HomeInteractor;
import xyz.gaborohez.starwarsencyclopedia.ui.home.presenter.HomeContract;
import xyz.gaborohez.starwarsencyclopedia.ui.home.presenter.HomePresenter;

public class HomeFragment extends BaseFragment<HomeContract.Presenter, FragmentHomeBinding> implements HomeContract.View, ItemCharacterAdapter.ItemCharacterIn {

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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.getPeople();
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void showCharacters(PeopleResponse response) {
        ItemCharacterAdapter adapter = new ItemCharacterAdapter(response.getResults(), this);
        binding.recycler.setLayoutManager(new LinearLayoutManager(requireActivity()));
        binding.recycler.setHasFixedSize(true);
        binding.recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        binding.recycler.setVisibility(View.VISIBLE);
    }

    @Override
    public void onCharacterClick(Character character) {
        Toast.makeText(requireContext(), character.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoader() {
        binding.contentShimmer.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoader() {
        binding.contentShimmer.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        binding.tvErrorMessage.setText(message);
        binding.tvErrorMessage.setVisibility(View.VISIBLE);
    }
}