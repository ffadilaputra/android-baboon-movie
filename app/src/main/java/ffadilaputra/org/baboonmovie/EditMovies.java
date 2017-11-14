package ffadilaputra.org.baboonmovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ffadilaputra.org.baboonmovie.model.Movies;

/**
 * Created by wirasyafri on 14/11/2017.
 */

public class EditMovies extends AppCompatActivity {

    TextView txtMovieName,txtSyn,txtYear;
    Button btnUpdate;
    Long idMovie;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_edit);

        Intent intent = getIntent();
        idMovie = intent.getLongExtra("id",0L);
        txtMovieName = (TextView)findViewById(R.id.txtNama);
        txtMovieName.setText(intent.getStringExtra("movieName"));

        txtSyn = (TextView)findViewById(R.id.txtSyn);
        txtSyn.setText(intent.getStringExtra("synopsys"));

        txtYear = (TextView)findViewById(R.id.txtYear);
        txtYear.setText(intent.getStringExtra("year"));

        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movies movies = Movies.findById(Movies.class,idMovie);
                movies.setName(txtMovieName.getText().toString());
                movies.setSynopsys(txtSyn.getText().toString());
                movies.setYear(txtYear.getText().toString());
                movies.save();
            }
        });
    }
}
