package com.ryanmattison.samples.activeandroidtest.util;

import android.util.Log;

import com.ryanmattison.samples.activeandroidtest.Singleton;

public class Diagnostics {

	private static final String TAG = "Diagnostics";

	public static void StartMethodTracingByKey(String Tag, String key) {
		Singleton.getInstance().getMethodTraceMilliSecondsKeyMap().put(key, System.currentTimeMillis());
	}

	public static void StopMethodTracingByKey(String Tag, String key, String leadingMessage) {

		if (Singleton.getInstance().getMethodTraceMilliSecondsKeyMap().containsKey(key)) {

			Log.i(TAG, Tag + "   " + leadingMessage + (System.currentTimeMillis() - Singleton.getInstance().getMethodTraceMilliSecondsKeyMap().get(key)) + " milliseconds");
		}

	}

}
