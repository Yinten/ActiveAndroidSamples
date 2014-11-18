package com.ryanmattison.samples.activeandroidtest.model;

import java.io.Serializable;
import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

@Table(name = "Programs")
public class Program extends Model implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "episodeSeasonNumber")
	public int episodeSeasonNumber;

	@Column(name = "episodeSeasonSequence")
	public int episodeSeasonSequence;

	@Column(name = "episodeSeriesSequence")
	public int episodeSeriesSequence;

	@Column(name = "episodeTitle")
	public String episodeTitle;

	@Column(name = "episodeTotal")
	public int episodeTotal;

	@Column(name = "flags")
	public String flags;

	@Column(name = "longTitle")
	public String longTitle;

	@Column(name = "originalAirDateInt")
	public int originalAirDateInt;

	@Column(name = "pictureURL_ProgramID")
	public String pictureURL_ProgramID;

	@Column(name = "pictureURL_SeriesID")
	public String pictureURL_SeriesID;

	@Column(name = "programDescription")
	public String programDescription;

	@Column(name = "programId", unique = true, onUniqueConflict = Column.ConflictAction.IGNORE)
	public int programId;

	@Column(name = "rating_Program_Average")
	public double rating_Program_Average;

	@Column(name = "rating_Series_Average")
	public double rating_Series_Average;

	@Column(name = "releaseYear")
	public int releaseYear;

	@Column(name = "seriesId")
	public int seriesId;


	public Program(){
		super();
	}

	


	public Program(int programId) {
		this.programId = programId; 
	}




	public static List<Program> getAllPrograms(){
		return new Select().from(Program.class).execute();
	}


	public static Program getProgram(String prg) {
		return new Select().from(Program.class).where("programId = ?", prg  ).executeSingle();
	}

	public static Program getProgramById(String prg) {
		return new Select().from(Program.class).where("programId = ?", prg  ).executeSingle();
	}

	public static Program getRandProgram(String prg) {
		return new Select().from(Program.class).orderBy("RANDOM()").executeSingle();
	}

	public static void deleteAllPrograms() {
		new Delete().from(Program.class).execute();
	}

	public static List<Program> getProgramBySeriesId(String prg) {
		return new Select().from(Program.class).where("seriesId = ?", prg  ).execute();
	}
	public static List<Program> getProgramBySeriesId(String seriesId, String prgid) {
		return new Select().from(Program.class).where("seriesId = ? AND programId != ?", seriesId, prgid  ).execute();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Program)) {
			return false;
		}
		if(!(this.programId == ((Program)obj).programId))
			return false;
		return true;
	}



	



}


