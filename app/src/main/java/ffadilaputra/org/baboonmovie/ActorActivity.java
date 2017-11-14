package ffadilaputra.org.baboonmovie;

import android.app.Activity;
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

import ffadilaputra.org.baboonmovie.adapter.ActorAdapter;
import ffadilaputra.org.baboonmovie.adapter.GenreAdapter;
import ffadilaputra.org.baboonmovie.model.Actor;
import ffadilaputra.org.baboonmovie.model.Genre;

/**
 * Created by wirasyafri on 15/11/2017.
 */

public class ActorActivity extends AppCompatActivity {

    public Button btnAdd;
    public List<Actor> actorList = new ArrayList<>();
    public ActorAdapter actorAdapter;
    public RecyclerView recyclerView;
    private Long idMovies;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actor_main);

        recyclerView = (RecyclerView)findViewById(R.id.actoreList);
        btnAdd= (Button)findViewById(R.id.btnTambah);

        Intent i = getIntent();
        idMovies = i.getLongExtra("idMovies",0L);

        actorList = Actor.find(Actor.class,"movies = ?",String.valueOf(idMovies));
        recyclerView = (RecyclerView)findViewById(R.id.actoreList);
        actorAdapter = new ActorAdapter(R.layout.actor_list,actorList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(actorAdapter);
        actorAdapter.notifyDataSetChanged();


        actorAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Actor actor = actorList.get(position);
                switch (view.getId()){
                    case R.id.btnDelete:
                        actor.delete();
                        actorList.clear();
                        actorList = Actor.listAll(Actor.class);
                        actorAdapter.setNewData(actorList);
                        actorAdapter.notifyDataSetChanged();
                        break;
                }
            }
        });

        btnAdd = (Button)findViewById(R.id.btnTambah);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AddActor.class);
                i.putExtra("idMovies",ActorActivity.this.idMovies);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        actorList.clear();
        actorList = Actor.find(Actor.class,"movies = ?", String.valueOf(idMovies));
        actorAdapter.setNewData(actorList);
        actorAdapter.notifyDataSetChanged();
        super.onResume();
    }

}
