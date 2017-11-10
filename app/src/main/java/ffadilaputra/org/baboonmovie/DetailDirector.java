package ffadilaputra.org.baboonmovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ffadilaputra.org.baboonmovie.model.Director;

/**
 * Created by aura on 10/11/17.
 */

public class DetailDirector extends AppCompatActivity{

    TextView directirName,experience;
    Button btnUpdate,btnDelete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.director_detail);

        Intent intent = getIntent();
        final long directorId = intent.getLongExtra("directorId",0L);
        Director detail = Director.findById(Director.class,directorId);
        directirName = (TextView)findViewById(R.id.directorName);
        directirName.setText(detail.getName());

        experience = (TextView)findViewById(R.id.experience);
        experience.setText(detail.getExperience());

        btnUpdate = (Button)findViewById(R.id.editDirector);
        btnDelete = (Button)findViewById(R.id.deleteDirector);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Director director = Director.findById(Director.class,directorId);
                Intent intent1 = new Intent(view.getContext(),EditDirector.class);
                intent1.putExtra("directorId",director.getId());
                view.getContext().startActivity(intent1);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Director director = Director.findById(Director.class,directorId);
                director.delete();
                Intent i = new Intent(view.getContext(),DirectorActivity.class);
                view.getContext().startActivity(i);
            }
        });

    }
}
