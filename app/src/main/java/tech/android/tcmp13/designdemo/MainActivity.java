package tech.android.tcmp13.designdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

import tech.android.tcmp13.designdemo.list.ListActivity;

public class MainActivity extends AppCompatActivity {

    private View top;
    private View center;
    private View fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Top Click
        top = findViewById(R.id.top);
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Center Click
        center = findViewById(R.id.center);
        center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.nextActionItem) {
            dance();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void dance() {

        top.startAnimation(generateFadeSlideOutAnimationSet(top, 0, false));
        center.startAnimation(generateFadeSlideOutAnimationSet(center, 100, false));
        fab.startAnimation(generateFadeSlideOutAnimationSet(fab, 200, true));
    }

    private AnimationSet generateFadeSlideOutAnimationSet(final View view, long delay, final boolean last) {

        //Attributes Set is the list of xml attributes applied to the object
        AnimationSet set = new AnimationSet(this, null);
        set.addAnimation(new AlphaAnimation(1f, 0f));
        set.addAnimation(new TranslateAnimation(0, -view.getWidth(), 0, 0));
        set.setInterpolator(new AccelerateInterpolator());
        set.setDuration(getResources().getInteger(android.R.integer.config_mediumAnimTime));
        set.setStartOffset(delay);
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                view.setVisibility(View.GONE);
                if (last) {
                    startActivity(new Intent(MainActivity.this, ListActivity.class));
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        return set;
    }

}
