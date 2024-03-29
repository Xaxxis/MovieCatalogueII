package id.xaxxis.moviecatalogue.activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

import id.xaxxis.moviecatalogue.R;
import id.xaxxis.moviecatalogue.adapter.SectionPagerAdapter;
import id.xaxxis.moviecatalogue.model.Movie;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Movie> movies;

    private TypedArray dataImgCover;
    private TypedArray dataImageBanner;
    private TypedArray dataImageCategory;
    private String[] dataMovieTitle;
    private String[] dataMovieYear;
    private String[] dataMovieRate;
    private String[] dataMovieSynopsis;
    private String[] dataMovieGenre;
    private String[] dataMovieDuration;
    private String[] dataMovieCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareActionBar();
        moviePrepare();
        addMovieItem();
        showFragment();
    }


    private void showFragment(){
        SectionPagerAdapter sectionsSectionPagerAdapter = new SectionPagerAdapter(this, getSupportFragmentManager(), movies);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsSectionPagerAdapter);
        TabLayout tabs = findViewById(R.id.tl_tabs);
        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_lang){
            Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }


    private void moviePrepare(){
        dataImgCover = getResources().obtainTypedArray(R.array.data_movie_image);
        dataImageBanner = getResources().obtainTypedArray(R.array.data_movie_banner);
        dataMovieTitle = getResources().getStringArray(R.array.data_movie_title);
        dataMovieYear = getResources().getStringArray(R.array.data_movie_year);
        dataMovieRate = getResources().getStringArray(R.array.data_movie_rate);
        dataMovieDuration = getResources().getStringArray(R.array.data_movie_duration);
        dataMovieSynopsis = getResources().getStringArray(R.array.data_movie_synopsis);
        dataMovieGenre = getResources().getStringArray(R.array.data_movie_genre);
        dataMovieCategory = getResources().getStringArray(R.array.data_movie_category);
        dataImageCategory = getResources().obtainTypedArray(R.array.data_cat_image);
    }

    private void addMovieItem(){
        movies = new ArrayList<>();
        for(int i=0; i<dataMovieTitle.length; i++){
            Movie movie = new Movie();
            movie.setPhotoCover(dataImgCover.getResourceId(i, -1));
            movie.setPhotoBanner(dataImageBanner.getResourceId(i, -1));
            movie.setImgCategory(dataImageCategory.getResourceId(i, -1));
            movie.setTitle(dataMovieTitle[i]);
            movie.setDuration(dataMovieDuration[i]);
            movie.setDateRelease(dataMovieYear[i]);
            movie.setSynopsis(dataMovieSynopsis[i]);
            movie.setGenre(dataMovieGenre[i]);
            movie.setRating(dataMovieRate[i]);
            movie.setCategory(dataMovieCategory[i]);
            movies.add(movie);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_app_bar, menu);
        return true;
    }

    private void prepareActionBar(){
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
}
