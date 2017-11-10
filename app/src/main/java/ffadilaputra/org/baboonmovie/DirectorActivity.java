package ffadilaputra.org.baboonmovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import ffadilaputra.org.baboonmovie.adapter.DirectorAdapter;
import ffadilaputra.org.baboonmovie.model.Director;

/**
 * Created by ardha_winata on 10-Nov-17.
 */

public class DirectorActivity extends AppCompatActivity {

    private DirectorAdapter directorAdapter;
    private List<Director> mListDirector = new ArrayList<>();
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.director_main);
        mListDirector = Director.listAll(Director.class);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerDirector);
        recyclerView.setHasFixedSize(true);
        directorAdapter = new DirectorAdapter(getApplicationContext(),mListDirector);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(directorAdapter);
        directorAdapter.notifyDataSetChanged();

        button = (Button)findViewById(R.id.addDrector);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),AddDirector.class);
                startActivity(i);
            }
        });

    }
}
