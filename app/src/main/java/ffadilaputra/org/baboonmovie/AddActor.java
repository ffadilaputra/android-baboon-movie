package ffadilaputra.org.baboonmovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ffadilaputra.org.baboonmovie.model.Actor;
import ffadilaputra.org.baboonmovie.model.Genre;
import ffadilaputra.org.baboonmovie.model.Movies;

/**
 * Created by wirasyafri on 15/11/2017.
 */

public class AddActor extends AppCompatActivity {

    private Long idMovies;
    Button btnSave,btnAdd;
    EditText txtActor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actor_add);

        Intent i = getIntent();
        idMovies = i.getLongExtra("idMovies",0L);
        txtActor = (EditText) findViewById(R.id.txtActorName);
        btnSave = (Button) findViewById(R.id.btnSimpan);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movies movies = Movies.findById(Movies.class,AddActor.this.idMovies);
                Actor actor = new Actor(txtActor.getText().toString(),movies);
                actor.save();

                Snackbar mySnackbar = Snackbar.make(findViewById(R.id.actor_layout),"Data Berhasil Disimpan",Snackbar.LENGTH_SHORT);
                mySnackbar.show();

            }
        });
    }
}
