package ffadilaputra.org.baboonmovie.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import ffadilaputra.org.baboonmovie.R;
import ffadilaputra.org.baboonmovie.model.Genre;

/**
 * Created by wirasyafri on 14/11/2017.
 */

public class GenreAdapter extends BaseQuickAdapter<Genre,BaseViewHolder> {

    public GenreAdapter(@LayoutRes int layoutResId, @Nullable List<Genre> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Genre item) {
        helper.setText(R.id.txtGenre,item.getGenreName());
        helper.addOnClickListener(R.id.btnDelete);
    }
}
