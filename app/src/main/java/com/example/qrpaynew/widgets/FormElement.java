package com.example.qrpaynew.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.qrpaynew.R;

/**
 * TODO: document your custom view class.
 */
public class FormElement extends ConstraintLayout {

    LayoutParams layoutParams;
    private String hint;
    private String hintColor;

    private int inputType;

    private String label;

    private String boxBackground;

    private String boxPadding;

    public FormElement(Context context) {
        super(context);
        init(context, null, 0);
    }

    public FormElement(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public FormElement(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {

        layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        LayoutInflater.from(context).inflate(R.layout.sample_form_element, this, true);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FormElement, defStyle, 0);

        hint = a.getString(R.styleable.FormElement_FormElementTextHint);
        hintColor = a.getString(R.styleable.FormElement_FormElementTextHintColor);
        String getInputType =  a.getString(R.styleable.FormElement_FormElementInputType);
        label = a.getString(R.styleable.FormElement_FormElementLabel);
//        boxBackground = a.getString(R.styleable.FormElement_FormElementBoxBackground);
        boxPadding = a.getString(R.styleable.FormElement_FormElementBoxPadding);

        if (getInputType.equals("text")) {
            inputType = InputType.TYPE_CLASS_TEXT;
        } else if (getInputType.equals("number")) {
            inputType = InputType.TYPE_CLASS_NUMBER;
        } else if (getInputType.equals("password")) {
            inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD;
        } else if (getInputType.equals("email")) {
            inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS;
        } else if (getInputType.equals("phone")) {
            inputType = InputType.TYPE_CLASS_PHONE;
        } else if (getInputType.equals("date")) {
            inputType = InputType.TYPE_CLASS_DATETIME;
        } else {
            inputType = InputType.TYPE_CLASS_TEXT;
        }

        //get the Input Element
        EditText inputElement = (EditText) findViewById(R.id.fieldInput);
        TextView labelElement = (TextView) findViewById(R.id.fieldLabel);
        ConstraintLayout boxElement = (ConstraintLayout) findViewById(R.id.inputLayout);
//        Integer backgroudIdentifier =  getResources().getIdentifier(boxBackground, "drawable", context.getPackageName());
//        Drawable background = getResources().getDrawable(backgroudIdentifier);

        inputElement.setHint(hint);
        inputElement.setHintTextColor(Color.parseColor(hintColor));
        inputElement.setInputType(inputType);
        labelElement.setText(label);
//        boxElement.setBackground(background);
        boxElement.setPadding(Integer.parseInt(boxPadding), Integer.parseInt(boxPadding), Integer.parseInt(boxPadding), Integer.parseInt(boxPadding));

        a.recycle();
    }

}