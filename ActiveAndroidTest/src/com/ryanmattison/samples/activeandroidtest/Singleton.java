package com.ryanmattison.samples.activeandroidtest;

import java.util.HashMap;

import android.content.Context;

public class Singleton {

	private static Singleton instance;

	private Context context;

	private HashMap<String, Long> methodTraceMillis;

	public static Singleton getInstance() {
		if (instance == null) {
			// Create the instance
			instance = new Singleton();
		}
		return instance;
	}

	private Singleton() {
		// Constructor hidden because this is a singleton
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public HashMap<String, Long> getMethodTraceMilliSecondsKeyMap() {
		if (methodTraceMillis == null) {
			methodTraceMillis = new HashMap<String, Long>();
		}
		return methodTraceMillis;
	}

}
