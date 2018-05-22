package com.pinery.audioedit;

import android.app.Application;
import android.os.Handler;

import com.pinery.audioedit.util.CrashUtils;

/**
 * App
 */
public class App extends Application {

  public static App sInstance;

  public Handler mHandler;

  public static App getInstance() {
    return sInstance;
  }

  @Override public void onCreate() {
    super.onCreate();

    try {
      mHandler = new Handler();
      sInstance = this;

      CrashUtils.init(this);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  @Override public void onTerminate() {
    super.onTerminate();

    mHandler = null;
    sInstance = null;
  }
}
