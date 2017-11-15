package ffadilaputra.org.baboonmovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ffadilaputra.org.baboonmovie.model.Genre;
import ffadilaputra.org.baboonmovie.model.Movies;

/**
 * Created by wirasyafri on 14/11/2017.
 */

public class AddGenre extends AppCompatActivity {

    private Long idMovies;
    Button btnSave;
    EditText txtGenreName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.genre_add);

        Intent i = getIntent();
        idMovies = i.getLongExtra("idMovies", 0L);
        txtGenreName = (EditText) findViewById(R.id.txtGenreName);
        btnSave = (Button) findViewById(R.id.btnSimpan);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movies movies = Movies.findById(Movies.class, AddGenre.this.idMovies);
                Genre genre = new Genre(txtGenreName.getText().toString(), movies);
                genre.save();

                Snackbar mySnackbar = Snackbar.make(findViewById(R.id.genre_layout), "Data Berhasil Disimpan", Snackbar.LENGTH_SHORT);
                mySnackbar.show();
            }
        });

    }
}
