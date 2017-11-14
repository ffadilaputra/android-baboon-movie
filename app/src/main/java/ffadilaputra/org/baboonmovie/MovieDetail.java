package ffadilaputra.org.baboonmovie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by wirasyafri on 14/11/2017.
 */

public class MovieDetail extends AppCompatActivity {

    TextView txtMovieName,txtSyn,txtYear;
    Button btnCategory,btnActor;
    Long idMovie;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        Intent intent = getIntent();
        idMovie = intent.getLongExtra("id",0L);
        txtMovieName = (TextView)findViewById(R.id.txtNama);
        txtMovieName.setText(intent.getStringExtra("movieName"));

        txtSyn = (TextView)findViewById(R.id.txtSyn);
        txtSyn.setText(intent.getStringExtra("synopsys"));

        txtYear = (TextView)findViewById(R.id.txtYear);
        txtYear.setText(intent.getStringExtra("year"));

        btnCategory = (Button)findViewById(R.id.btnGenre);
        btnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(),GenreActivity.class);
                intent1.putExtra("idMovies",MovieDetail.this.idMovie);
                startActivity(intent1);
            }
        });

        btnActor = (Button)findViewById(R.id.btnActor);
        btnActor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent asiqiin = new Intent(getApplicationContext(),ActorActivity.class);
                asiqiin.putExtra("idMovies",MovieDetail.this.idMovie);
                startActivity(asiqiin);
            }
        });

    }
}
