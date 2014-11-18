package com.ryanmattison.samples.activeandroidtest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Column.ForeignKeyAction;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

@Table(name = "Schedules")
public class Schedule extends Model implements Serializable {

	private static final long serialVersionUID = 1L;

	public int _id;

	@Column(name = "scheduleId", unique = true, onUniqueConflict = Column.ConflictAction.IGNORE)
	public int scheduleId;

	
	
	@Column(name = "startDateTimeint")
	public long startDateTimeint;

	@Column(name = "endDateTimeint")
	public int endDateTimeint;


	@Column(name = "startUnixTimeLong")
	public long startUnixTimeLong;

	@Column(name = "endUnixTimeLong")
	public long endUnixTimeLong;

	@Column(name = "tvRating")
	public String tvRating;

	@Column(name = "flags")
	public String flags;

	@Column(name = "schedulePopularity")
	public double schedulePopularity;

	@Column(name = "isRecordingNow")
	public boolean isRecordingNow;

	@Column(name = "showSpinner")
	public boolean showSpinner;
	
	@Column(name = "Source", onDelete = ForeignKeyAction.NO_ACTION)
	public Source source;
	
	@Column(name = "Program", onDelete = ForeignKeyAction.NO_ACTION)
	public Program program;
	
	public Boolean expanded;
	
	public Schedule(){
		super();
		this.expanded = false;
	}

	




	public static Schedule getScheduleByScheduleId(String srcId) {
		return new Select().from(Schedule.class).where("scheduleId = ?", srcId  ).executeSingle();
	}
	public static List<Schedule> getScheduleByProgramId(String prgId) {
		return new Select().from(Schedule.class).where("programId = ?", prgId  ).orderBy("startUnixTimeLong ASC").execute();
	}

	public static Schedule getFirstScheduleByProgramId(String prgId) {
		return new Select().from(Schedule.class).where("programId = ?", prgId  ).orderBy("startUnixTimeLong ASC").executeSingle();
	}

	public static Schedule getFirstScheduleBySeriesID(String seriesId) {
		List<Program> programs = new Select().from(Program.class).where("seriesId = ?" , seriesId).execute();
		ArrayList<Schedule> schedules = new ArrayList<Schedule>();
		for(int i = 0; i < programs.size(); i++) {
			List<Schedule> sch_set = new Select().from(Schedule.class).where("programId = ? AND endUnixTimeLong >= ?", programs.get(i).programId, System.currentTimeMillis()).execute();
			schedules.addAll(sch_set);
		}
		Collections.sort(schedules, new Comparator<Schedule>() {
			@Override
			public int compare(Schedule lhs, Schedule rhs) {
				return (int) (lhs.startUnixTimeLong - rhs.startUnixTimeLong);
			}
		});
		if(schedules.size() == 0) {
			return null;
		}
		return schedules.get(0);
	}

	public static List<Schedule> getAllSchedulesBySeriesID(String seriesId) {
		List<Program> programs = new Select().from(Program.class).where("seriesId = ?" , seriesId).execute();
		ArrayList<Schedule> schedules = new ArrayList<Schedule>();
		for(int i = 0; i < programs.size(); i++) {
			List<Schedule> sch_set = new Select().from(Schedule.class).where("programId = ? AND endUnixTimeLong >= ?", programs.get(i).programId, System.currentTimeMillis()).execute();
			schedules.addAll(sch_set);
		}
		Collections.sort(schedules, new Comparator<Schedule>() {
			@Override
			public int compare(Schedule lhs, Schedule rhs) {
				return (int) (lhs.startUnixTimeLong - rhs.startUnixTimeLong);
			}
		});
		return schedules;	
	}

	public static List<Schedule> getAllSchedulesBySeriesIDExceptOriginal(String seriesId, String startTime, String sourceId) {
		List<Program> programs = new Select().from(Program.class).where("seriesId = ?" , seriesId).execute();
		ArrayList<Schedule> schedules = new ArrayList<Schedule>();
		for(int i = 0; i < programs.size(); i++) {
			List<Schedule> sch_set = new Select().from(Schedule.class).where("programId = ? AND startUnixTimeLong >= ?", programs.get(i).programId, System.currentTimeMillis()).execute();
			schedules.addAll(sch_set);
		}
		Collections.sort(schedules, new Comparator<Schedule>() {
			@Override
			public int compare(Schedule lhs, Schedule rhs) {
				return (int) (lhs.startUnixTimeLong - rhs.startUnixTimeLong);
			}
		});
		return schedules;	
	}

	
	//#TODO: rewrite
	/*
	public static List<Schedule> getScheduleBySource(String srcId) {
		return new Select().from(Schedule.class).where("sourceId = ?", srcId  ).orderBy("startUnixTimeLong ASC").execute();
	}

	public static List<Schedule> getScheduleBySourceAfterTime(String srcId, String endTime) {
		return new Select().from(Schedule.class).where("sourceId = ? AND endUnixTimeLong >= ?", srcId, endTime  ).orderBy("startUnixTimeLong ASC").execute();
	}

	public static List<Schedule> getScheduleBySourceAfterTimeLimit3(String srcId, String endTime) {
		return new Select().from(Schedule.class).where("sourceId = ? AND endUnixTimeLong >= ?", srcId, endTime  ).limit(4).orderBy("startUnixTimeLong ASC").execute();
	}
	*/ 

	public Schedule getScheduleByProgramTime(String prgId, String string) {
		return new Select().from(Schedule.class).where("programId = ? AND startDateTimeint > ?", prgId, string  ).executeSingle();
	}

	
	//#TODO: rewrite
	
	
	/*public static List<Schedule> getScheduleByDate(String srcId) {
		return new Select().from(Schedule.class).where("sourceId = ?", srcId  ).orderBy("startUnixTimeLong ASC").execute();
	}*/ 

	
	
	public static List<Schedule> getAllSchedules(){
		return new Select().from(Schedule.class).execute();
	}

	public static List<Schedule> getAllSchedulesAtCurrentTime(){
		return new Select().from(Schedule.class).where("endUnixTimeLong >= ? AND startUnixTimeLong <= ?", System.currentTimeMillis(), System.currentTimeMillis() + 3600000).execute();
	}


	public static void deleteAllSchedules(){
		new Delete().from(Schedule.class).execute();
	}
	
}
