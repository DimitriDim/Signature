package fr.m2i.signaturecomposant;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private TagEdit tg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tg = findViewById(R.id.zoneSignature);
        tg.setTagColor(Color.BLUE);
       // tg.setTagWidth(10);
    }

   public void effacer(View v){

       tg.clear();

    }
}
