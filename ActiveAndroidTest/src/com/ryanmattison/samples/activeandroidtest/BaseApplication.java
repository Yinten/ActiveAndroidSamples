package com.ryanmattison.samples.activeandroidtest;

import android.app.Application;

import com.activeandroid.ActiveAndroid;


public class BaseApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		Singleton.getInstance().setContext(this); 
		ActiveAndroid.initialize(this); 
	}
	
	
	
}
