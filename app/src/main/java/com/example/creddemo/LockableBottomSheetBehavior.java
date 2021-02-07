package com.example.creddemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class LockableBottomSheetBehavior <V extends View> extends BottomSheetBehavior<V> {
    private boolean mAllowUserDragging = true;
    /**
     * Default constructor for instantiating BottomSheetBehaviors.
     */
    public LockableBottomSheetBehavior() {
        super();
    }


    public LockableBottomSheetBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setAllowUserDragging(boolean allowUserDragging) {
        mAllowUserDragging = allowUserDragging;
    }

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        if (!mAllowUserDragging) {
            return false;
        }
        return super.onInterceptTouchEvent(parent, child, event);
    }
}
