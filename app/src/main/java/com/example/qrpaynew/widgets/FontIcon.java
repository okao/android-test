package com.example.qrpaynew.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
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
        initializeAttributes(context, attrs);
        Typeface mTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/"+font+".ttf");
        this.setTypeface(mTypeface);

    }

    private void initializeAttributes(Context context, AttributeSet attrs){
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FontIcon);
        font = ta.getString(R.styleable.FontIcon_fontFile);
        ta.recycle();

    }
}
