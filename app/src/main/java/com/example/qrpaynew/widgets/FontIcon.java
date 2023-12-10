package com.example.qrpaynew.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;

import androidx.appcompat.widget.AppCompatTextView;
import com.example.qrpaynew.R;

/**
 * Created by faseel.saeed on 02/05/2017.
 * Used by hamzath.anees on 06/12/2023.
 */


public class FontIcon extends AppCompatTextView {
    private String font = "faisafont";

    public FontIcon(Context context, AttributeSet attrs) {
        super(context, attrs);

        Log.v("FT3","font:"+font);
        Log.v("context","context:"+context);
        Log.v("attrs","attrs:"+attrs);

        initializeAttributes(context, attrs);

        Log.v("FT3","font:"+ "fonts/"+font+".ttf");
        Log.v("FT3","assets" + context.getAssets());

        Typeface mTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/"+font+".ttf");

        Log.v("FT3","mTypeface:"+mTypeface);
        this.setTypeface(mTypeface);

    }

    private void initializeAttributes(Context context, AttributeSet attrs){
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FontIcon);
        font = ta.getString(R.styleable.FontIcon_fontFile);
        ta.recycle();
    }
}
