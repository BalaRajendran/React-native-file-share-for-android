
package com.ReactNativeFileShareForAndroid;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import android.widget.Toast;
import android.content.Context;

import android.app.Activity;
import java.util.Map;
import java.util.ArrayList;
import android.content.Intent;
import android.net.Uri;

public class ReactNativeFileShareForAndroidModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public ReactNativeFileShareForAndroidModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "ReactNativeFileShareForAndroid";
  }
  @ReactMethod
  public void getFilepath(Callback callback) {
    Activity indentActivity = getCurrentActivity();

    if (indentActivity == null) {
      return;
    }
    Intent intent = indentActivity.getIntent();
    //
    String fileType = intent.getType();
    String action = intent.getAction();

    if (Intent.ACTION_SEND.equals(action) && fileType != null) {
      if (fileType.startsWith("text/") || fileType.startsWith("image/") || fileType.startsWith("video/")
          || fileType.startsWith("application/")) {
        Uri getFileUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
        if (getFileUri != null) {
          String extension = getFileUri.toString().substring(getFileUri.toString().lastIndexOf("."));
          String result = "{ext:\"" + extension + "\",filename:\"" + getFileUri.toString() + "\"}";
          callback.invoke(result);
        }
      } else {
        Toast.makeText(reactContext, "Sorry! File is not supported", Toast.LENGTH_LONG).show();
      }
    } else if (Intent.ACTION_SEND_MULTIPLE.equals(action) && fileType != null) {
      if (fileType.startsWith("text/") || fileType.startsWith("image/") || fileType.startsWith("video/")
          || fileType.startsWith("application/")) {
        ArrayList<Uri> getFileUris = intent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
        if (getFileUris != null) {
          String allFileUris = new String();
          String extension = new String();
          for (Uri uri : getFileUris) {
            extension += uri.toString().substring(uri.toString().lastIndexOf(".")) + ",";
            allFileUris += uri.toString() + ",";
          }
          String result = "{ext:\"" + extension + "\",filename:\"" + allFileUris + "\"}";
          callback.invoke(result);
        }
      } else {
        Toast.makeText(reactContext, "Sorry! File is not supported", Toast.LENGTH_LONG).show();
      }
    }
  }

}