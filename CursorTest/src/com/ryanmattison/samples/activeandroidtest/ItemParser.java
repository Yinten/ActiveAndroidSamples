package com.ryanmattison.samples.activeandroidtest;

import java.io.IOException;

import android.util.Log;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ryanmattison.samples.activeandroidtest.model.LineupItem;
import com.ryanmattison.samples.activeandroidtest.model.Program;
import com.ryanmattison.samples.activeandroidtest.model.Schedule;
import com.ryanmattison.samples.activeandroidtest.model.Source;
import com.ryanmattison.samples.activeandroidtest.util.Diagnostics;

public class ItemParser {

	private static final String TAG = "ItemParser";

	/*
	 * Each lineup has a schedule (sourceId) and schedules have a list of
	 * programs (programs that exist with this program Id)
	 */
	public static void parseLineupItem(String lineups)
			throws JsonProcessingException, IOException {
		Diagnostics.StartMethodTracingByKey(TAG, TAG + "parseLineupItem");
		ObjectMapper m = new ObjectMapper();

		JsonNode rootNode = m.readTree(lineups);
		JsonNode arrayNode;
		Long[] sources = new Long[rootNode.size()];

		LineupItem lineupItem;
		try {

			ActiveAndroid.beginTransaction();
			for (int i = 1; i < rootNode.size(); i++) {
				arrayNode = rootNode.get(i);

				Source source = new Source(arrayNode.get(7).asInt());
				source.sourceType = arrayNode.get(8).asText();
				source.sourceTypeId = arrayNode.get(13).asInt();
				sources[i] = source.save();

			}

			ActiveAndroid.setTransactionSuccessful();

			ActiveAndroid.endTransaction();

			ActiveAndroid.beginTransaction();
			for (int i = 1; i < rootNode.size(); i++) {
				arrayNode = rootNode.get(i);

				lineupItem = new LineupItem();
				lineupItem.callLetters = arrayNode.get(0).asText();
				lineupItem.channelNumber = arrayNode.get(1).asText();
				lineupItem.cluId = arrayNode.get(2).asInt();
				lineupItem.disabledByDefault = arrayNode.get(3).asText();
				lineupItem.isDisabled = arrayNode.get(3).asText();
				lineupItem.fullName = arrayNode.get(4).asText();
				lineupItem.imageURL = arrayNode.get(5).asText();
				lineupItem.shortName = arrayNode.get(6).asText();
				lineupItem.source = Source.load(Source.class, sources[i]);
				lineupItem.streamURL = arrayNode.get(9).asText();
				lineupItem.primaryLanguage = arrayNode.get(10).asText();
				lineupItem.highlight = arrayNode.get(11).asText();
				lineupItem.isHdtv = arrayNode.get(12).asText();
				lineupItem.position = i;
				lineupItem.save();

			}

			ActiveAndroid.setTransactionSuccessful();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ActiveAndroid.endTransaction();
		}
		Diagnostics.StopMethodTracingByKey(TAG, TAG + "parseLineupItem",
				"parseLineupItem took: ");

	}

	public static void parseSchedules(JsonNode schedulesNode) {
		Diagnostics.StartMethodTracingByKey(TAG, TAG + "parseSchedules");
		JsonNode arrayNode;
		Schedule schedule;
		try {
			ActiveAndroid.beginTransaction();
			Log.e(TAG, "Schedule Size: " + schedulesNode.size());
			for (int i = 1; i < schedulesNode.size(); i++) {
				arrayNode = schedulesNode.get(i);
				schedule = new Schedule();
				schedule.flags = arrayNode.get(6).asText();
				schedule.scheduleId = arrayNode.get(0).asInt();
				schedule.schedulePopularity = arrayNode.get(7).asDouble();
				schedule.startDateTimeint = arrayNode.get(2).asLong();
				schedule.endDateTimeint = arrayNode.get(3).asInt();
				schedule.tvRating = arrayNode.get(5).asText();

				Program program = new Select().from(Program.class)
						.where("programId = ?", arrayNode.get(4).asInt())
						.executeSingle();

				if (program != null) {
					schedule.program = program;
				}

				Source source = new Select().from(Source.class)
						.where("sourceId = ?", arrayNode.get(1).asInt())
						.executeSingle();
				if (source != null) {
					schedule.source = source;
				}

				schedule.save();

			}
			ActiveAndroid.setTransactionSuccessful();

			Log.i(TAG, "Transaction Success");
		} catch (Exception z) {
			z.printStackTrace();
		} finally {
			ActiveAndroid.endTransaction();
		}
		Diagnostics.StopMethodTracingByKey(TAG, TAG + "parseSchedules",
				"parseSchedules took: ");

	}

	public static void parsePrograms(JsonNode programsNode) {

		Diagnostics.StartMethodTracingByKey(TAG, TAG + "parsePrograms");
		JsonNode arrayNode;
		Program prgt;
		try {
			ActiveAndroid.beginTransaction();
			for (int i = 1; i < programsNode.size(); i++) {
				arrayNode = programsNode.get(i);

				prgt = new Program();

				prgt.episodeSeasonNumber = arrayNode.get(6).asInt();
				prgt.episodeSeasonSequence = arrayNode.get(7).asInt();
				prgt.episodeTitle = arrayNode.get(3).asText();
				prgt.episodeTotal = arrayNode.get(8).asInt();
				prgt.flags = arrayNode.get(5).asText();
				prgt.longTitle = arrayNode.get(2).asText();
				prgt.originalAirDateInt = arrayNode.get(10).asInt();
				prgt.pictureURL_ProgramID = arrayNode.get(13).asText();
				prgt.pictureURL_SeriesID = arrayNode.get(14).asText();
				prgt.programDescription = arrayNode.get(9).asText();
				prgt.programId = arrayNode.get(0).asInt();
				prgt.rating_Program_Average = arrayNode.get(12).asDouble();
				prgt.rating_Series_Average = arrayNode.get(11).asDouble();

				prgt.releaseYear = arrayNode.get(4).asInt();
				prgt.seriesId = arrayNode.get(1).asInt();

				prgt.save();

			}
			ActiveAndroid.setTransactionSuccessful();
			Log.i(TAG, "Transaction Success");
		} catch (Exception z) {
			z.printStackTrace();
		} finally {
			ActiveAndroid.endTransaction();
		}
		Diagnostics.StopMethodTracingByKey(TAG, TAG + "parsePrograms",
				"parsePrograms took: ");
	}

}
