package ffadilaputra.org.baboonmovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ffadilaputra.org.baboonmovie.model.Director;

/**
 * Created by ardha_winata on 10-Nov-17.
 */

public class EditDirector extends AppCompatActivity {

    EditText edtDirector,edtExperience;
    Button btnUpdate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.director_edit);

        Intent i = getIntent();
        final Long idDirector = i.getLongExtra("directorId",0L);
        Director detel = Director.findById(Director.class,idDirector);

        edtDirector   = (EditText)findViewById(R.id.directorName);
        edtExperience = (EditText)findViewById(R.id.experience);
        btnUpdate     = (Button)findViewById(R.id.editEx);

        edtDirector.setText(detel.getName());
        edtExperience.setText(detel.getExperience());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Director director = Director.findById(Director.class,idDirector);
                director.setName(edtDirector.getText().toString());
                director.setExperience(edtExperience.getText().toString());
                director.save();
            }
        });

    }
}
