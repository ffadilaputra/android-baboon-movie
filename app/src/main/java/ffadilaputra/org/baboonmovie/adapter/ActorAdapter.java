package ffadilaputra.org.baboonmovie.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import ffadilaputra.org.baboonmovie.R;
import ffadilaputra.org.baboonmovie.model.Actor;

/**
 * Created by wirasyafri on 15/11/2017.
 */

public class ActorAdapter extends BaseQuickAdapter<Actor,BaseViewHolder> {


    public ActorAdapter(@LayoutRes int layoutResId, @Nullable List<Actor> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Actor item) {
        helper.setText(R.id.txtActor,item.getActorName());
        helper.addOnClickListener(R.id.btnDelete);
    }
}
