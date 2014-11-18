package com.ryanmattison.samples.activeandroidtest.model;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

@Table(name = "LineupItems")
public class LineupItem extends Model {


	@Column(name = "CluId", unique = true, onUniqueConflict = Column.ConflictAction.IGNORE)
	public int cluId;

	@Column(name = "msoId")
	public int msoId;

	@Column(name = "Source")
	public Source source;  
	
	
	
	//public 

	@Column(name = "CallLetters")
	public String callLetters;

	@Column(name = "ChannelNumber")
	public String channelNumber;

	@Column(name = "FullName")
	public String fullName;

	@Column(name = "ImageURL")
	public String imageURL;

	@Column(name = "ShortName")
	public String shortName;



	@Column(name = "DisabledByDefault")
	public String disabledByDefault;

	@Column(name = "StreamURL")
	public String streamURL;

	@Column(name = "PrimaryLanguage")
	public String primaryLanguage;

	@Column(name = "Highlight")
	public String highlight;

	@Column(name = "IsHdtv")
	public String isHdtv;
	


	@Column(name = "isDisabled")
	public String isDisabled;

	@Column(name = "Position")
	public int position;



	public LineupItem() {
		super();

	}

	public LineupItem(String callLetters) {
		super();
		this.callLetters = callLetters;
	}


	public static LineupItem getLineupItemBySourceId(String srcId) {
		return new Select().from(LineupItem.class).where("SourceId = ?", srcId)
				.executeSingle();

	}

	public static List<LineupItem> getAllLineupItems() {
		return new Select().from(LineupItem.class).execute();
	}

	public static List<LineupItem> getAllLineupItemsAlpha() {
		return new Select().from(LineupItem.class)
				.orderBy("FullName ASC, ChannelNumber ASC").execute();
	}

	public static List<LineupItem> getAllLineupItemsEnabled() {
		return new Select().from(LineupItem.class)
				.where("isDisabled = ?", "false").orderBy("Position ASC")
				.execute();
	}

	public static void deleteAllLineupItem() {
		new Delete().from(LineupItem.class).execute();
	}

}
