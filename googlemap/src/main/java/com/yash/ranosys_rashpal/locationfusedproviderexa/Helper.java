package com.yash.ranosys_rashpal.locationfusedproviderexa;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by ranosys-rashpal on 8/2/17.
 */

public class Helper {

    public static ProgressDialog showProgressDialog(Context context){
        ProgressDialog progressDialog = new ProgressDialog(context, R.style.NewDialog);
        progressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        progressDialog.setCancelable(false);
        progressDialog.show();
        return progressDialog;
    }


    public static void hideKeyboard(Context context, View focusView) {
        if (focusView == null)
            return;
        InputMethodManager im = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(focusView.getWindowToken(), 0);

    }
}
