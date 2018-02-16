package me.mehdi.imagefilter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import net.alhazmy13.imagefilter.ImageFilter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    Button grayBtn, reliefBtn, oilBtn, neonBtn, pixelateBtn, tvBtn, invertBtn;
    ImageView imageView;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grayBtn = findViewById(R.id.gray);
        reliefBtn = findViewById(R.id.relief);
        oilBtn = findViewById(R.id.oil);
        neonBtn = findViewById(R.id.neon);
        pixelateBtn = findViewById(R.id.pixelate);
        tvBtn= findViewById(R.id.tv);
        invertBtn = findViewById(R.id.invert);

        grayBtn.setOnClickListener(this);
        reliefBtn.setOnClickListener(this);
        oilBtn.setOnClickListener(this);
        neonBtn.setOnClickListener(this);
        pixelateBtn.setOnClickListener(this);
        tvBtn.setOnClickListener(this);
        invertBtn.setOnClickListener(this);


        imageView = findViewById(R.id.image);
        bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();

    }

    @Override
    public void onClick(View v) {
        Bitmap tmpBmp = null;
        switch (v.getId()) {
            case R.id.gray:
                Log.d(TAG, "onClick: ");
                tmpBmp = ImageFilter.applyFilter(bitmap, ImageFilter.Filter.GRAY);
                break;
            case R.id.relief:
                tmpBmp = ImageFilter.applyFilter(bitmap, ImageFilter.Filter.RELIEF);
                break;
            case R.id.oil:
                tmpBmp = ImageFilter.applyFilter(bitmap, ImageFilter.Filter.OIL);

                break;
            case R.id.neon:
                tmpBmp = ImageFilter.applyFilter(bitmap, ImageFilter.Filter.NEON);
                break;

            case R.id.pixelate:
                tmpBmp = ImageFilter.applyFilter(bitmap, ImageFilter.Filter.PIXELATE);

                break;
            case R.id.tv:
                tmpBmp = ImageFilter.applyFilter(bitmap, ImageFilter.Filter.TV);

                break;
            case R.id.invert:
                tmpBmp = ImageFilter.applyFilter(bitmap, ImageFilter.Filter.INVERT);
                break;

        }
                imageView.setImageBitmap(tmpBmp);

    }
}
