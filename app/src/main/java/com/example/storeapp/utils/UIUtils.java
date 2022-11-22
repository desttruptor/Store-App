package com.example.storeapp.utils;

import android.view.View;

public class UIUtils {
    public static int isVisibleOrGone (boolean visibility) {
        if (visibility) {
            return View.VISIBLE;
        } else {
            return View.GONE;
        }
    }
}
