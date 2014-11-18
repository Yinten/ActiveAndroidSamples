package com.ryanmattison.samples.activeandroidtest.model;

import java.io.IOException;
import java.io.InputStream;

import com.activeandroid.ActiveAndroid;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ryanmattison.samples.activeandroidtest.ItemParser;
import com.ryanmattison.samples.activeandroidtest.Singleton;
import com.ryanmattison.samples.activeandroidtest.util.Diagnostics;
import com.ryanmattison.samples.activeandroidtest.util.InputStreamExtensions;

public class InitDatabase {
	private static final String TAG = "DatabaseInit";

	public static void init() {

		try {

			Diagnostics.StartMethodTracingByKey(TAG, TAG + "Load");
			ActiveAndroid.initialize(Singleton.getInstance().getContext());

			loadLineUps();
			loadSchedulesandPrograms();
			Diagnostics.StopMethodTracingByKey(TAG, TAG + "Load", "DB Load: ");
			

		} catch (Exception z) {
			z.printStackTrace();
		}
	}

	private static void loadLineUps() throws IOException {
		InputStream is = Singleton.getInstance().getContext().getAssets()
				.open("channels.json");

		Diagnostics.StartMethodTracingByKey(TAG, "InputStreamToString");
		String json = InputStreamExtensions.InputStreamToString(is);
		Diagnostics.StopMethodTracingByKey(TAG, "InputStreamToString",
				"InputStreamToString: ");
		ItemParser.parseLineupItem(json);
	}

	private static void loadSchedulesandPrograms() throws IOException {
		InputStream is = Singleton.getInstance().getContext().getAssets()
				.open("schedules.json");

		Diagnostics.StartMethodTracingByKey(TAG, "InputStreamToString");
		String json = InputStreamExtensions.InputStreamToString(is);
		Diagnostics.StopMethodTracingByKey(TAG, "InputStreamToString",
				"InputStreamToString: ");

		ObjectMapper m = new ObjectMapper();
		JsonNode rootNode = m.readTree(json);

		ItemParser.parsePrograms(rootNode.get(1).get("Value"));
		ItemParser.parseSchedules(rootNode.get(0).get("Value"));

	}
}
