package fr.m2i.signaturecomposant;

import android.Manifest;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TagEdit tg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // question demandé à l'utilisateur, ici aura elle aura le code 1
        ActivityCompat.requestPermissions(this, new String[]
                {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tg = findViewById(R.id.zoneSignature);
        tg.setTagColor(Color.BLUE);
        tg.setTagWidth(10);
    }

    public void effacer(View v) {

        tg.clear();

    }

    public void save(View view) {
        try {
            tg.save("monDessin.png");
        } catch (TagEdit.TagEditException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
