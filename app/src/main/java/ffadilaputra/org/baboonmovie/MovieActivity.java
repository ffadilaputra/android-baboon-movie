package ffadilaputra.org.baboonmovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import ffadilaputra.org.baboonmovie.adapter.MoviesAdapter;
import ffadilaputra.org.baboonmovie.model.Movies;

/**
 * Created by wirasyafri on 14/11/2017.
 */

public class MovieActivity extends AppCompatActivity {

        public Button btnAdd;
        public List<Movies> listMovies = new ArrayList<>();
        public Movies itemMovies;
        public MoviesAdapter moviesAdapter;
        public RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_main);

        

        listMovies = Movies.listAll(Movies.class);
        mRecyclerView = (RecyclerView)findViewById(R.id.movieList);
        moviesAdapter = new MoviesAdapter(R.layout.movie_list,listMovies);

        btnAdd = (Button) findViewById(R.id.btnTambah);
        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(moviesAdapter);
        moviesAdapter.notifyDataSetChanged();

        moviesAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener(){

            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    Movies movies = listMovies.get(position);
                    switch (view.getId()){
                        case R.id.movieName:
                            Intent i = new Intent(getApplicationContext(),MovieDetail.class);
                            i.putExtra("id",movies.getId());
                            i.putExtra("movieName",movies.getName());
                            i.putExtra("synopsys",movies.getSynopsys());
                            i.putExtra("year",movies.getYear());
                            startActivity(i);
                        break;
                        case R.id.btnDelete:
                            movies.delete();
                            listMovies.clear();
                            listMovies = Movies.listAll(Movies.class);
                            moviesAdapter.setNewData(listMovies);
                            moviesAdapter.notifyDataSetChanged();

                        break;
                        case R.id.btnEdit:
                            Intent intent = new Intent(getApplicationContext(),EditMovies.class);
                            intent.putExtra("id",movies.getId());
                            intent.putExtra("movieName",movies.getName());
                            intent.putExtra("synopsys",movies.getSynopsys());
                            intent.putExtra("year",movies.getYear());
                            startActivity(intent);
                            break;
                    }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MovieAdd.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        listMovies.clear();
        listMovies = Movies.listAll(Movies.class);
        moviesAdapter.setNewData(listMovies);
        moviesAdapter.notifyDataSetChanged();
        super.onResume();
    }

}
