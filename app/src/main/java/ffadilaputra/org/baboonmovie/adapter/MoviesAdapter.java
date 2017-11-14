package ffadilaputra.org.baboonmovie.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import ffadilaputra.org.baboonmovie.R;
import ffadilaputra.org.baboonmovie.model.Movies;

/**
 * Created by wirasyafri on 14/11/2017.
 */

public class MoviesAdapter extends BaseQuickAdapter<Movies,BaseViewHolder> {

    public MoviesAdapter(@LayoutRes int layoutResId, @Nullable List<Movies> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Movies item) {
        helper.setText(R.id.movieName,item.getName());
        helper.addOnClickListener(R.id.btnDelete);
        helper.addOnClickListener(R.id.btnEdit);
        helper.addOnClickListener(R.id.movieName);
    }


}
