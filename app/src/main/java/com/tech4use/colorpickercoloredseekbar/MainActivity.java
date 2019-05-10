package com.tech4use.colorpickercoloredseekbar;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import yuku.ambilwarna.AmbilWarnaDialog;

public class MainActivity extends AppCompatActivity {

    Button colorDialog_btn;
    LinearLayout linearLayout;
    int default_color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.linearLayout);
        colorDialog_btn = findViewById(R.id.colorDialog_btn);

        // adding the default color
        default_color = ContextCompat.getColor(MainActivity.this, R.color.white);

        colorDialog_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPicker();
            }
        });
    }
    public void openColorPicker() {
        // creating instance of the color picker class
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, default_color,
                new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {
                        // do nothing
                    }

                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        // getting the new color picked by the user
                        default_color = color;
                        linearLayout.setBackgroundColor(default_color);
                    }
                });
        dialog.show();
    }

    // inflating the menu items
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // actions on menu items click

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_seekbar :
                startActivity(new Intent(this, SeekBarActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
