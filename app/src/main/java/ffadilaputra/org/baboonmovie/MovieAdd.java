package ffadilaputra.org.baboonmovie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ffadilaputra.org.baboonmovie.model.Movies;

/**
 * Created by wirasyafri on 14/11/2017.
 */

public class MovieAdd extends AppCompatActivity {

    EditText name,syn,year;
    Button submit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_add);

        name = (EditText)findViewById(R.id.txtName);
        syn  = (EditText)findViewById(R.id.txtSyn);
        year = (EditText)findViewById(R.id.txtYear);
        submit = (Button)findViewById(R.id.btnSave);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movies movies = new Movies(name.getText().toString(),syn.getText().toString(),(year.getText().toString()));
                movies.save();

                Snackbar mySnackbar = Snackbar.make(findViewById(R.id.movie_layout),"Data Berhasil Disimpan",Snackbar.LENGTH_SHORT);
                mySnackbar.show();

            }
        });

    }
}
