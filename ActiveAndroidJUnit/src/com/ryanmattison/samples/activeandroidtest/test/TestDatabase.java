package com.ryanmattison.samples.activeandroidtest.test;

import java.util.List;

import android.test.AndroidTestCase;
import android.util.Log;

import com.activeandroid.query.Select;
import com.ryanmattison.samples.activeandroidtest.Singleton;
import com.ryanmattison.samples.activeandroidtest.model.InitDatabase;
import com.ryanmattison.samples.activeandroidtest.model.LineupItem;
import com.ryanmattison.samples.activeandroidtest.model.Program;
import com.ryanmattison.samples.activeandroidtest.model.Schedule;
import com.ryanmattison.samples.activeandroidtest.util.Diagnostics;

public class TestDatabase extends AndroidTestCase {

	private static final String TAG = "TestDatabase";

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Log.i(TAG, "Setup");

		if (!new Select().from(Program.class).exists()) {
			InitDatabase.init();
		}
	}

	@Override
	public void testAndroidTestCaseSetupProperly() {
		super.testAndroidTestCaseSetupProperly();

		assertNotNull(Singleton.getInstance().getContext());

	}

	public void testDatabaseHasValues()
	{
		
		Diagnostics.StartMethodTracingByKey(TAG, TAG);
		List<Program> programs = new Select().from(Program.class).execute();
		assertNotNull(programs); 
		assertTrue(programs.size() > 0);
		List<LineupItem> lineups = new Select().from(LineupItem.class).execute();
		assertNotNull(lineups); 
		assertTrue(lineups.size() > 0);
		assertNotNull(lineups.get(0).source); 
		assertNotNull(lineups.get(0).source.lineupItems());
		Log.e(TAG, "Lineup Count: " + lineups.get(25).source.lineupItems().size());
		
		assertTrue(lineups.get(0).source.lineupItems().size() > 0); 
		List<Schedule> schedules = lineups.get(25).source.schedules(); 
		Log.e(TAG, "Lineup Schedules: " + schedules.size());
		assertNotNull(schedules); 
		assertTrue(schedules.size() > 0); 
		
		
		Program program = schedules.get(0).program;
		
		assertNotNull(program);
		
		Log.i(TAG, "Program title: " + program.longTitle); 
		
		Diagnostics.StopMethodTracingByKey(TAG, TAG, "testDatabase Has Values; ");
		
		
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		Log.i(TAG, "Tear Down");
	}

}
