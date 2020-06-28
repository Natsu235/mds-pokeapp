package fr.mds.pokeapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class SpriteActivity extends AppCompatActivity {

    private ProgressBar sp_sprite;
    private TextView tv_sprite;
    private ImageView img_sprite;
    private Drawable decamarkSprite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprite);

        Intent intent = getIntent();
        String pokemonSpriteName = intent.getStringExtra("pokemonSpriteName");
        String pokemonSprite = intent.getStringExtra("pokemonSprite");

        sp_sprite = (ProgressBar) findViewById(R.id.sp_pokemon);
        sp_sprite.setVisibility(View.VISIBLE);
        tv_sprite = (TextView) findViewById(R.id.tv_sprite);
        img_sprite = (ImageView) findViewById(R.id.img_sprite);
        decamarkSprite = SpriteActivity.this.getResources().getDrawable(R.drawable.decamark);

        tv_sprite.setText(pokemonSpriteName);
        Picasso.get().load(pokemonSprite).placeholder(decamarkSprite).error(decamarkSprite).into(img_sprite);
        sp_sprite.setVisibility(View.GONE);
    }

}
