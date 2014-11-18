package com.ryanmattison.samples.activeandroidtest.model;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Sources")
public class Source extends Model {

	public Source() {

	}

	public Source(int sourceId) {

		this.sourceId = sourceId;
	}

	@Column(name = "SourceType")
	public String sourceType;

	@Column(name = "SourceTypeId")
	public Integer sourceTypeId;

	public List<LineupItem> lineupItems() {
		return getMany(LineupItem.class, "Source");
	}

	public List<Schedule> schedules() {

		return getMany(Schedule.class, "Source");
	}

	@Column(name = "sourceId", unique = true, onUniqueConflict = Column.ConflictAction.IGNORE)
	public int sourceId;

}
