package by.erizo.gifapi.screens;

import android.annotation.SuppressLint;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import by.erizo.domain.entity.GifsEntity;
import by.erizo.domain.interactors.GifsUseCase;
import by.erizo.domain.interactors.SearchGifsUseCase;
import by.erizo.gifapi.R;
import by.erizo.gifapi.app.App;
import by.erizo.gifapi.base.BaseViewModel;
import by.erizo.gifapi.databinding.ItemGifsBinding;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Erizo on 26.03.2018.
 */

public class GifsViewModel extends BaseViewModel {

    @Inject
    public GifsUseCase gifsUseCase;

    @Inject
    public SearchGifsUseCase searchGifsUseCase;

    private String search;

    @SuppressLint("StaticFieldLeak")
    @Inject
    public Context context;

    private GifsAdapter adapter = new GifsAdapter();
    private boolean activityStarted = false;

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    public GifsViewModel() {
        loadNextPage("10", "G");
    }

    class GifsHolder extends RecyclerView.ViewHolder {
        ItemGifsBinding binding;

        public GifsHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            binding.setViewModel(new ItemGifsViewModel());
        }
    }

    public class GifsAdapter extends RecyclerView.Adapter<GifsHolder> {
        private List<GifsEntity> gifsEntityList = new ArrayList<>();


        public void addUserEntities(List<GifsEntity> gifsEntities) {
            this.gifsEntityList.addAll(gifsEntities);
        }

        @Override
        public GifsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            ItemGifsBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_gifs, parent, false);
            return new GifsHolder(binding.getRoot());
        }

        @Override
        public void onBindViewHolder(GifsHolder holder, int position) {
            holder.binding.getViewModel().setEntity(gifsEntityList.get(position));
            if (position == gifsEntityList.size() - 1) {
                getNextGifs(String.valueOf(position));
            }
        }

        @Override
        public int getItemCount() {
            return gifsEntityList.size();
        }

        public void clear() {
            gifsEntityList.clear();
        }

        public void update(List<GifsEntity> gifsEntities) {
            if (gifsEntities.size() != 0) {
                adapter.addUserEntities(gifsEntities);
                adapter.notifyDataSetChanged();
            }
        }
    }

    public void search(String search) {
        this.search = search;
        adapter.clear();
        getNextGifs(search);
    }

    private void getNextGifs(String search) {
        this.search = search;
        if (search == null || search.length() == 0) {
            loadNextPage("10", "G");
        } else {
            searchGifs(search, "0", "10", "G");
        }
    }


    private void loadNextPage(String limit, String rating) {
        gifsUseCase.get(limit, rating).subscribe(new Observer<List<GifsEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(List<GifsEntity> gifsEntities) {
                adapter.update(gifsEntities);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println();
            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void searchGifs(String s, String offset, String limit, String rating) {
        searchGifsUseCase.searchGifs(s, offset, limit, rating).subscribe(new Observer<List<GifsEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(List<GifsEntity> gifsEntities) {
                adapter.update(gifsEntities);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void onResume() {
        if (activityStarted) {
            activityStarted = false;
            adapter.clear();
            loadNextPage("10", "G");
        }
    }

    public GifsAdapter getAdapter() {
        return adapter;
    }

}
