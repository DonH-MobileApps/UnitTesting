package com.example.customviewandviewgroups;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CompoundView extends LinearLayout {
    TextView tvCounterOne;
    TextView tvCounterTwo;

    public CompoundView(Context context) {
        super(context, null);
    }

    public CompoundView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CompoundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    private void init() {
        inflate(getContext(),R.layout.compound_layout, this);
        tvCounterOne = findViewById(R.id.tvCounterOne);
        tvCounterTwo = findViewById(R.id.tvCounterTwo);

    }

    public void setCounterOne(int counter) {
        tvCounterOne.setText(String.valueOf(counter));

    }

    public void setCounterTwo(int counter) {
        tvCounterTwo.setText(String.valueOf(counter));

    }
}
