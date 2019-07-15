package id.xaxxis.moviecatalogue.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import id.xaxxis.moviecatalogue.R;
import id.xaxxis.moviecatalogue.model.Movie;

public class DetailMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        showMovieDetail();
    }

    public void showMovieDetail(){
        ImageView imgCover, imgBackdrop, icoShowCat;
        TextView tvDetTitle, tvDetRate, tvDetRelease, tvDetGenre, tvDetDesc;

        Movie detailMovie = getIntent().getParcelableExtra("movie");
        prepareActionBar(detailMovie.getTitle());

        imgCover = findViewById(R.id.img_det_cover);
        Glide.with(this).load(detailMovie.getPhotoCover()).into(imgCover);

        imgBackdrop = findViewById(R.id.img_det_backdrop);
        Glide.with(this).load(detailMovie.getPhotoBanner()).into(imgBackdrop);

        icoShowCat = findViewById(R.id.ico_cat_show);
        Glide.with(this).load(detailMovie.getImgCategory()).into(icoShowCat);

        tvDetTitle = findViewById(R.id.tv_det_title);
        tvDetTitle.setText(detailMovie.getTitle());

        tvDetRate = findViewById(R.id.tv_det_rating);
        tvDetRate.setText(detailMovie.getRating());

        tvDetRelease = findViewById(R.id.tv_det_release);
        tvDetRelease.setText(detailMovie.getDateRelease());

        tvDetGenre = findViewById(R.id.tv_det_genre);
        tvDetGenre.setText(detailMovie.getGenre());

        tvDetDesc = findViewById(R.id.tv_det_desc);
        tvDetDesc.setText(detailMovie.getSynopsis());

    }

    private void prepareActionBar(String title){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }
}
