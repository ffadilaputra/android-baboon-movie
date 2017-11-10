package ffadilaputra.org.baboonmovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ffadilaputra.org.baboonmovie.DetailDirector;
import ffadilaputra.org.baboonmovie.R;
import ffadilaputra.org.baboonmovie.model.Director;

/**
 * Created by aura on 10/11/17.
 */

public class DirectorAdapter extends RecyclerView.Adapter<DirectorAdapter.DirecotorViewHolder> {

    private Context context;
    private List<Director> directorList;

    public DirectorAdapter(Context context, List<Director> listDirector) {
        this.context = context;
        this.directorList = listDirector;
    }


    public class DirecotorViewHolder extends RecyclerView.ViewHolder {

        public TextView directorTitle;

        public DirecotorViewHolder(View itemView) {
            super(itemView);
            directorTitle = itemView.findViewById(R.id.directorName);
        }
    }

    @Override
    public DirecotorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.director_item,parent,false);
        return new DirecotorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DirecotorViewHolder holder, int position) {
        final Director director = directorList.get(position);
        holder.directorTitle.setText(director.getName());
        holder.directorTitle.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),DetailDirector.class);
                i.putExtra("directorId",director.getId());
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return directorList.size();
    }
}