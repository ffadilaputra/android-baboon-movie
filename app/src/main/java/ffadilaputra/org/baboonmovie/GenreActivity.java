package ffadilaputra.org.baboonmovie;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import ffadilaputra.org.baboonmovie.adapter.GenreAdapter;
import ffadilaputra.org.baboonmovie.adapter.MoviesAdapter;
import ffadilaputra.org.baboonmovie.model.Genre;
import ffadilaputra.org.baboonmovie.model.Movies;

/**
 * Created by wirasyafri on 14/11/2017.
 */

public class GenreActivity extends AppCompatActivity {

    public Button btnAdd;
    public List<Genre> genreList = new ArrayList<>();
    public GenreAdapter genreAdapter;
    public RecyclerView recyclerView;

    private Long idMovies;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.genre_main);

        recyclerView = (RecyclerView)findViewById(R.id.rcGenreList);
        btnAdd= (Button)findViewById(R.id.btnTambah);

        Intent i = getIntent();
        idMovies = i.getLongExtra("idMovies",0L);

        genreList = Genre.find(Genre.class,"movies = ?",String.valueOf(idMovies));
        recyclerView = (RecyclerView)findViewById(R.id.rcGenreList);
        genreAdapter = new GenreAdapter(R.layout.genre_list,genreList);

        genreAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener(){

            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Genre genre = genreList.get(position);
                switch (view.getId()){
                    case R.id.btnDelete:
                        genre.delete();
                        genreList.clear();
                        genreList = Genre.listAll(Genre.class);
                        genreAdapter.setNewData(genreList);
                        genreAdapter.notifyDataSetChanged();
                    break;
                }
            }
        });

        btnAdd = (Button)findViewById(R.id.btnTambah);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AddGenre.class);
                i.putExtra("idMovies",GenreActivity.this.idMovies);
                startActivity(i);
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(genreAdapter);
        genreAdapter.notifyDataSetChanged();

    }

    @Override
    protected void onResume() {
        genreList.clear();
        genreList = Genre.find(Genre.class,"movies = ?", String.valueOf(idMovies));
        genreAdapter.setNewData(genreList);
        genreAdapter.notifyDataSetChanged();
        super.onResume();
    }

}
