package fr.mds.pokeapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SpriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprite);
    }

}
