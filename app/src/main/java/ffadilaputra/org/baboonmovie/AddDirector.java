package ffadilaputra.org.baboonmovie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ffadilaputra.org.baboonmovie.model.Director;

/**
 * Created by aura on 10/11/17.
 */

public class AddDirector extends AppCompatActivity {

    EditText txtName,txtExperience;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_director_activity);

        Button btn = (Button)findViewById(R.id.submit);
        txtName = (EditText)findViewById(R.id.directorName);
        txtExperience = (EditText)findViewById(R.id.experience);

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Director mDirector = new Director(txtName.getText().toString(),txtExperience.getText().toString());
                mDirector.save();
                txtName.setText("");
                txtExperience.setText("");

                Snackbar popup =Snackbar.make(findViewById(R.id.eue),"Data Tersimpan",Snackbar.LENGTH_SHORT);
                popup.show();
            }
        });

    }
}
