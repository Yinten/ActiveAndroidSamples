package com.ryanmattison.samples.activeandroidtest.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import android.util.Log;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ryanmattison.samples.activeandroidtest.ItemParser;
import com.ryanmattison.samples.activeandroidtest.Singleton;
import com.ryanmattison.samples.activeandroidtest.util.Diagnostics;
import com.ryanmattison.samples.activeandroidtest.util.InputStreamExtensions;

public class InitDatabase {
	private static final String TAG = "DatabaseInit";

	public void init() {

		try {

			ActiveAndroid.initialize(Singleton.getInstance().getContext());
			InsertThread it = new InsertThread();
			it.start();
			QueryThread qt = new QueryThread();
			qt.start();

		} catch (Exception z) {
			z.printStackTrace();
		}
	}

	public class QueryThread extends Thread {

		public QueryThread() {
			this.setName("Query Thread -- Thomas is a noob that can't thread trace");
			this.setPriority(NORM_PRIORITY);
		}

		@Override
		public void interrupt() {

			super.interrupt();
			Log.i(TAG, this.getName() + ":" + " was interuptted");
		}

		@Override
		public void run() {

			super.run();

			for (int i = 0; i < 100; i++) {
				try {
					Diagnostics.StartMethodTracingByKey(TAG, TAG + "Query");

					List<Program> programs = new Select().from(Program.class)
							.execute();
					if (programs == null) {

						throw new Exception("Programs are null");
					}
					if (programs.size() == 0) {
						throw new Exception("No Programs");
					}
					List<LineupItem> lineups = new Select().from(
							LineupItem.class).execute();
					if (lineups == null) {
						throw new Exception("lineups are null");
					}
					if (lineups.size() == 0) {
						throw new Exception("No lineups");
					}

					if (lineups.get(0).source.lineupItems().size() == 0) {
						throw new Exception("No sources");
					}

					List<Schedule> schedules = lineups.get(25).source
							.schedules();
					Log.e(TAG, "Lineup Schedules: " + schedules.size());

					if (schedules.size() == 0) {
						throw new Exception("No schedules");
					}

					Program program = schedules.get(0).program;

					if (program == null) {
						throw new Exception("program is null");
					}

					Diagnostics.StopMethodTracingByKey(TAG, TAG + "Query",
							"DB Query Time: ");
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			Diagnostics.StopMethodTracingByKey(TAG, TAG + "Load", "DB Load: ");
		}

		@Override
		public void setUncaughtExceptionHandler(UncaughtExceptionHandler handler) {
			Log.i(TAG, this.getName() + ":" + " set exception handler");
			super.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

				@Override
				public void uncaughtException(Thread thread, Throwable ex) {
					Log.i(TAG, thread.getName() + " " + ex.getMessage());

				}
			});
		}

		@Override
		public synchronized void start() {

			super.start();
			Log.i(TAG, this.getName() + ":" + " was interuptted");
		}

	}

	public class InsertThread extends Thread {

		public InsertThread() {
			this.setName("Insert Thread -- Thomas is a noob that can't thread trace");
			this.setPriority(Thread.NORM_PRIORITY);
		}

		@Override
		public void interrupt() {

			super.interrupt();
			Log.i(TAG, this.getName() + ":" + " was interuptted");
		}

		@Override
		public void run() {

			super.run();
			for (int i = 0; i < 100; i++) {
				Diagnostics.StartMethodTracingByKey(TAG, TAG + "Load");

				try {

					Diagnostics.StartMethodTracingByKey(TAG, TAG + "Load");
					loadLineUps();
					loadSchedulesandPrograms();

					Diagnostics.StopMethodTracingByKey(TAG, TAG + "Load",
							"DB Load: ");
				} catch (IOException e) {
					e.printStackTrace();
				}
				// try {
				// Thread.sleep(30);
				// } catch (InterruptedException e) {
				// e.printStackTrace();
				// }
			}
			Diagnostics.StopMethodTracingByKey(TAG, TAG + "Load", "DB Load: ");
		}

		@Override
		public void setUncaughtExceptionHandler(UncaughtExceptionHandler handler) {
			Log.i(TAG, this.getName() + ":" + " set exception handler");
			super.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

				@Override
				public void uncaughtException(Thread thread, Throwable ex) {
					Log.i(TAG, thread.getName() + " " + ex.getMessage());

				}
			});
		}

		@Override
		public synchronized void start() {

			super.start();
			Log.i(TAG, this.getName() + ":" + " was interuptted");
		}

		private void loadLineUps() throws IOException {
			InputStream is = Singleton.getInstance().getContext().getAssets()
					.open("channels.json");

			Diagnostics.StartMethodTracingByKey(TAG, "InputStreamToString");
			String json = InputStreamExtensions.InputStreamToString(is);
			Diagnostics.StopMethodTracingByKey(TAG, "InputStreamToString",
					"InputStreamToString: ");
			ItemParser.parseLineupItem(json);
		}

		private void loadSchedulesandPrograms() throws IOException {
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
}
