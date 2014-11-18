package com.ryanmattison.samples.activeandroidtest.model;

import java.util.ArrayList;
import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

@Table(name = "SeasonItem")
public class SeasonItem extends Model {

	@Column(name = "title")
	private String title;

	@Column(name = "seriesId")
	private int seriesId;

	@Column(name = "numWatched")
	private int numWatched;

	@Column(name = "totalEpisodes")
	private int totalEpisodes;

	@Column(name = "season")
	private int season;

	@Column(name = "seasonId", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
	private String seasonId;

	@Column(name = "episodesWatched")
	private ArrayList<Integer> episodesWatched = new ArrayList<Integer>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean getWatched() {
		return numWatched >= totalEpisodes;
	}

	public int getNumWatched() {
		return numWatched;
	}

	public void setNumWatched(int numWatched) {
		this.numWatched = numWatched;
		if (numWatched > totalEpisodes) {
			numWatched = totalEpisodes;
		}
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public int getTotalEpisodes() {
		return totalEpisodes;
	}

	public void setTotalEpisodes(int totalEpisodes) {
		this.totalEpisodes = totalEpisodes;
	}

	public static List<SeasonItem> getSeasonItemsForShow(String seriesId) {
		return new Select().from(SeasonItem.class).where("seriesId = ?", seriesId).orderBy("season ASC").execute();
	}

	public int getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(int seriesId) {
		this.seriesId = seriesId;
	}

	public ArrayList<Integer> getEpisodesWatched() {
		return episodesWatched;
	}

	public void setEpisodesWatched(ArrayList<Integer> episodesWatched) {
		this.episodesWatched = episodesWatched;
	}

	public void addEpisodeWatched(Integer episode) {
		if (!episodesWatched.contains(episode)) {
			episodesWatched.add(episode);
		}
	}

	public void removeEpisodeWatched(Integer episode) {
		if (episodesWatched.contains(episode)) {
			episodesWatched.remove(episode);
		}
	}

	public String getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(String seasonId) {
		this.seasonId = seasonId;
	}

}
