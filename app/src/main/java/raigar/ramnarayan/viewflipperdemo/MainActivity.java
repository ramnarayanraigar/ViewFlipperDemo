package raigar.ramnarayan.viewflipperdemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewFlipper mViewFlipper;
    private RelativeLayout mRelativeLayoutOne, mRelativeLayoutSec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initClick();
    }

    // Initialize views
    private void initView() {
        mViewFlipper = findViewById(R.id.flipper);
        mRelativeLayoutOne = findViewById(R.id.rel_one);
        mRelativeLayoutSec = findViewById(R.id.rel_sec);
    }

    // clicks initialization on views
    private void initClick() {
        mRelativeLayoutOne.setOnClickListener(this);
        mRelativeLayoutSec.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mRelativeLayoutOne) {
            flipView(mRelativeLayoutOne);
        } else if ((v == mRelativeLayoutSec)) {
            flipView(mRelativeLayoutSec);
        }
    }

    // flipping views
    private void flipView( final RelativeLayout relativeLayout) {
        mViewFlipper.setAutoStart(true);
        mViewFlipper.setFlipInterval(1000);
        mViewFlipper.startFlipping();
        relativeLayout.setEnabled(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mViewFlipper.stopFlipping();
                relativeLayout.setEnabled(true);
            }
        },1002);
    }
}
