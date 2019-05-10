package com.tech4use.colorpickercoloredseekbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.rtugeek.android.colorseekbar.ColorSeekBar;

public class SeekBarActivity extends AppCompatActivity {

    TextView textView;
    ColorSeekBar colorSeekBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekbar_activity);

        textView = findViewById(R.id.textView);
        colorSeekBar = findViewById(R.id.colorSeekbar);

        // adding on color change listener on the seekBar
        colorSeekBar.setOnColorChangeListener(new ColorSeekBar.OnColorChangeListener() {
            @Override
            public void onColorChangeListener(int colorBarPosition, int alphaBarPosition, int color) {
                textView.setTextColor(color);
            }
        });

    }
}
