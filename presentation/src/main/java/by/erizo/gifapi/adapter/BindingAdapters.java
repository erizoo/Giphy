package by.erizo.gifapi.adapter;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import by.erizo.gifapi.screens.GifsViewModel;

/**
 * Created by Erizo on 26.03.2018.
 */

public class BindingAdapters {

    @BindingAdapter({"adapter"})
    public static void initRecyclerView(RecyclerView recyclerView, GifsViewModel.GifsAdapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter({"src"})
    public static void loadImage(ImageView view, String url) {
        if (url == null)
            return;
        Log.d("TAG", url);
        Glide.with(view.getContext()).load(url).into(view);
    }
}
