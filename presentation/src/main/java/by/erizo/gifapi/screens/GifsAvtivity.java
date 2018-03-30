package by.erizo.gifapi.screens;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import by.erizo.gifapi.R;
import by.erizo.gifapi.base.BaseMvvmActivity;
import by.erizo.gifapi.base.BaseViewModel;
import by.erizo.gifapi.databinding.ActivityMainBinding;

/**
 * Created by Erizo on 26.03.2018.
 */

public class GifsAvtivity extends BaseMvvmActivity {

    private ActivityMainBinding dataBinding;

    @Override
    public int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public BaseViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(GifsViewModel.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = (ActivityMainBinding) binding;
        RecyclerView recyclerView = binding.getRoot().findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataBinding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                search(newText);
                return true;
            }
        });
    }

    private void search(String key) {
        dataBinding.getViewModel().search(key);
    }


}
