package com.ryanmattison.samples.activeandroidtest.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.ryanmattison.samples.activeandroidtest.Constants;
import com.ryanmattison.samples.activeandroidtest.Singleton;
import com.ryanmattison.samples.activeandroidtest.model.LineupItem;



public class Util {

	public static final int SCREEN_SIZE_NORMALP = 420;
	public static final int SCREEN_SIZE_LARGEP = 720;
	public static final int SCREEN_SIZE_NORMALL = 720;
	public static final int SCREEN_SIZE_LARGEL = 1080;


	static public boolean isNonEmptyString(String data) {
		String info = data;
		return info != null && info.length() != 0 && !(info.equals("null"));
	}

	static public boolean isEmptyString(String data) {
		return data == null || data.length() == 0 || data.equals("null");
	}

	/**
	 * These methods returns true if the input   is null or its length is zero.
	 * @param string
	 * @return true | false
	 */

	public static boolean isEmpty( Collection<?> collection ){
		if( collection == null || collection.isEmpty() ){
			return true;
		}
		return false;
	}


	public static boolean isEmpty( Map<?, ?> map ){
		if( map == null || map.isEmpty() ){
			return true;
		}
		return false;
	}


	public static boolean isEmpty( Object object ){
		if( object == null ){
			return true;
		}
		return false;
	}


	public static boolean isEmpty( Object[] array ){
		if( array == null || array.length == 0 ){
			return true;
		}
		return false;
	}


	public static boolean isEmpty( String string ){
		if( string == null || string.trim().length() == 0 ){
			return true;
		}
		return false;
	}

	public static String calculateDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date resultdate;
		try {
			resultdate = formatter.parse(date);

			SimpleDateFormat resformatter = new SimpleDateFormat("d MMM yyyy");
			String resultstring = resformatter.format(resultdate);
			return resultstring;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String calculateOrigAirDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Date resultdate;
		try {
			resultdate = formatter.parse(date);

			SimpleDateFormat resformatter;
			if(Locale.getDefault().getCountry().equals("US")) {
				resformatter = new SimpleDateFormat("M/d/yyyy");
			} else {
				resformatter = new SimpleDateFormat("d/MM/yyyy");
			}
			String resultstring = resformatter.format(resultdate);
			return resultstring;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static boolean isSystemAvailable(Context context) throws Exception {
		File file = new File(context.getFilesDir(), Constants.FILE_NAME_MSO);
		return file.exists();
	}

	public static void marshallClass(Context context, Object object,
			String filename) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(new File(context.getFilesDir(),
							filename)));
			oos.writeObject(object);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Object unmarshallClass(Context context, String filename) {
		try {
			File file = new File(context.getFilesDir(), filename);
			if (file.exists()) {
				ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream(file));
				Object o = ois.readObject();
				ois.close();
				Log.d("Read Object", "Object: " + o);
				return o;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

//	public static MSO getSystem(Context context) {
//		com.yo.tv.model.MSO mso = null;
//		try {
//			mso = (MSO) Util.unmarshallClass(context, Constants.FILE_NAME_MSO);
//		} catch (Exception e) {
//			Log.e("UTIL ERROR","Error occured retrieving System:", e);
//		}
//		return mso;
//	}

	public static void copyStream(InputStream is, OutputStream os) {
		final int buffer_size = 1024;
		try {
			byte[] bytes = new byte[buffer_size];
			for (;;) {
				int count = is.read(bytes, 0, buffer_size);
				if (count == -1) {
					break;
				}
				os.write(bytes, 0, count);
			}
		} catch (Exception e) {
			Log.e("UTIL ERROR","Error occured @ CopyStream:", e);
		}
	}

	public static byte[] downloadImage(String urlPath) {
		byte[] rawByte = null;
		try {
			if (Util.isNonEmptyString(urlPath)) {
				URL url = new URL(urlPath);
				URLConnection connection = url.openConnection();
				connection.setDoInput(true);
				InputStream is = new BufferedInputStream(url.openStream());
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] buf = new byte[1024];
				int n = 0;
				while (-1 != (n = is.read(buf))) {
					baos.write(buf, 0, n);
				}
				baos.close();
				is.close();
				rawByte = baos.toByteArray();
			}
		} catch (Exception e) {
			Log.e("UTIL ERROR","Error occured downloading image:", e);
		}
		return rawByte;
	}

	public static void saveDataToFile(Context context, String filename,
			String data) {
		try {
			File file = new File(context.getFilesDir(), filename);
			FileWriter fw = new FileWriter(file);
			fw.write(data);
			fw.flush();
			fw.close();
		} catch (Exception e) {
			Log.e("UTIL ERROR","Error occured copying data to file:", e);
		}
	}

	public static void logDataToFile(Context context, String filename,
			String data) {
		try {
			File file = new File(context.getExternalCacheDir(), filename);
			FileWriter fw = new FileWriter(file);
			fw.write(data);
			fw.flush();
			fw.close();
		} catch (Exception e) {
			Log.e("UTIL ERROR","Error occured copying data to file:", e);
		}
	}

	public static boolean deleteFile(Context context, String filename) {
		try {
			File file = new File(context.getFilesDir(), filename);
			if (file.exists()) {
				return file.delete();
			}
		} catch (Exception e) {
			Log.e("UTIL ERROR","Error occured deleting file:" + filename, e);
		}
		return false;
	}

	public static int getPackageVersionCode(Context context, String pkgName) {
		PackageManager pm = context.getPackageManager();
		try {
			PackageInfo pi = pm.getPackageInfo(pkgName, 0);
			return pi.versionCode;
		} catch (NameNotFoundException ex) {
			Log.e("UTIL ERROR","Error getting package version: " + pkgName, ex);
			return 0;
		}
	}

	public static int getVersionCode(Context context) {
		try {
			// read current version information about this package
			PackageManager manager = context.getPackageManager();
			PackageInfo info = manager.getPackageInfo(context.getPackageName(),
					0);
			return info.versionCode;
		} catch (Exception ex) {
			Log.e("UTIL ERROR","Error checking version...", ex);
			return 0;
		}
	}

	public static String getVersionString(Context context) {
		String ver = "0";
		try {
			// read current version information about this package
			PackageManager manager = context.getPackageManager();
			PackageInfo info = manager.getPackageInfo(context.getPackageName(),
					0);
			ver = info.versionName;
		} catch (Exception e) {
			Log.e("UTIL ERROR",
					"Exception - Couldn't find package information in PackageManager",
					e);
		}
		return ver;
	}

//	public static void getURLList(Context context, ArrayList<com.yo.tv.model.Source> sources,
//			String urlPath) {
//		StringBuilder sBuilder = new StringBuilder(urlPath);
//		ArrayList<Integer> sourceList = new ArrayList<Integer>();
//		ArrayList<com.yo.tv.model.Source> source = sources;
//		for (Source sourceIds : source) {
//			sourceList.add(sourceIds.getSourceId());
//		}
//		Collections.sort(sourceList);
//		ArrayList<Integer> differenceCollection = new ArrayList<Integer>();
//		int len = sourceList.size();
//		int length = 0;
//		for (int i = len - 1; i > 0; i--) {
//			int diff = Integer.valueOf(sourceList.get(i))
//					- Integer.valueOf(sourceList.get(i - 1));
//			differenceCollection.add(diff);
//			length = sBuilder.append(diff).append(",").length();
//			Log.d("UTIL","length of url" + length);
//			if (length > 1900) {
//				Log.d("UTIL","Exceeding length of URL, cut now");
//				differenceCollection
//				.add(Integer.valueOf(sourceList.get(i - 1)));
//			}
//		}
//
//	}

	/*
	 * Source List used for Now&Next, a more optimized list of Source List that
	 * helps in compressing URL lengths in the WebService call
	 */
	public static ArrayList<Integer> getShortSourceList(List<Integer> sourceList) {

		ArrayList<Integer> normalisedCollection = new ArrayList<Integer>();
		if (sourceList != null && sourceList.size() > 0) {
			Collections.sort(sourceList);
			/*
			 * collect the difference between subsequent elements in the list,
			 * starting from behind
			 */
			ArrayList<Integer> differenceCollection = new ArrayList<Integer>();
			int len = sourceList.size();
			for (int i = len - 1; i > 0; i--) {
				differenceCollection.add(sourceList.get(i)
						- sourceList.get(i - 1));
			}
			/*
			 * append first element from the source list as our base and then
			 * reverse the whole list
			 */
			differenceCollection.add(sourceList.get(0));
			Collections.reverse(differenceCollection); // THIS can be returned
			// if
			// the below is not
			// desired

			/*
			 * further optimization, converting series to 1's to a negative sum
			 * of subsequent 1's
			 */

			int addOnes = 0;
			for (int x = 0; x < len; ++x) {
				if (differenceCollection.get(x) == 1) {
					addOnes--;
				} else {
					if (addOnes < 0) {
						normalisedCollection.add(addOnes);
						addOnes = 0;
					}
					normalisedCollection.add(differenceCollection.get(x));
				}
			}

			for (int p = 0; p < normalisedCollection.size(); p++) {
				if (normalisedCollection.get(p) == -1) {
					normalisedCollection.set(p, 1);
				}
			}
		}
		return normalisedCollection;
	}

	public static ArrayList<Integer> getShortSourceListLineupItems(List<LineupItem> sourceList) {

		ArrayList<Integer> normalisedCollection = new ArrayList<Integer>();
		if (sourceList != null && sourceList.size() > 0) {
			List<LineupItem> sources = new ArrayList<LineupItem>(sourceList);
			Collections.sort(sources, new Comparator<LineupItem>() {

				@Override
				public int compare(LineupItem lhs, LineupItem rhs) {
					return lhs.source.sourceId - rhs.source.sourceId;
				}
			});
			/*
			 * collect the difference between subsequent elements in the list,
			 * starting from behind
			 */
			ArrayList<Integer> differenceCollection = new ArrayList<Integer>();
			int len = sources.size();
			for (int i = len - 1; i > 0; i--) {
				differenceCollection.add(sources.get(i).source.sourceId
						- sources.get(i - 1).source.sourceId);
			}
			/*
			 * append first element from the source list as our base and then
			 * reverse the whole list
			 */
			differenceCollection.add(Integer.valueOf(sources.get(0).source.sourceId));
			Collections.reverse(differenceCollection); // THIS can be returned
			// if
			// the below is not
			// desired

			/*
			 * further optimization, converting series to 1's to a negative sum
			 * of subsequent 1's
			 */

			int addOnes = 0;
			for (int x = 0; x < len; ++x) {
				if (differenceCollection.get(x) == 1) {
					addOnes--;
				} else {
					if (addOnes < 0) {
						normalisedCollection.add(addOnes);
						addOnes = 0;
					}
					normalisedCollection.add(differenceCollection.get(x));
				}
			}

			for (int p = 0; p < normalisedCollection.size(); p++) {
				if (normalisedCollection.get(p) == -1) {
					normalisedCollection.set(p, 1);
				}
			}
		}
		return normalisedCollection;
	}

//	public synchronized static void waitForInternetConnection(Context context) {
//		try {
//			long futureTime = System.currentTimeMillis() + 30000l;
//			if (!ConnectionUtil.isConnected(context)) {
//				// wait 30 seconds if there's Internet
//				// connectivity while
//				// downloading content
//
//				while (System.currentTimeMillis() < futureTime) {
//					Log.d("UTIL","Waiting for internet connectivity....");
//					Thread.sleep(500l);
//					if (ConnectionUtil.isConnected(context)) {
//						break;
//					}
//				}
//			}
//		} catch (Exception e) {
//			Log.e("UTIL ERROR","Error occured waiting for thread to expire:", e);
//		}
//	}


	public static int getActivityWidth(Activity current) {
		DisplayMetrics displaymetrics = new DisplayMetrics();
		current.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int width = displaymetrics.widthPixels;
		return width;
	}

	public static int getActivityWidth(Context current) {
		DisplayMetrics displaymetrics = new DisplayMetrics();
		WindowManager wm = (WindowManager) current.getApplicationContext()
				.getSystemService(Context.WINDOW_SERVICE);
		wm.getDefaultDisplay().getMetrics(displaymetrics);
		int width = displaymetrics.widthPixels;
		return width;
	}

	public static int getActivityHeight(Activity current) {
		DisplayMetrics displaymetrics = new DisplayMetrics();
		current.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int height = displaymetrics.heightPixels;
		return height;
	}

	public static int getActivityHeight(Context current) {
		DisplayMetrics displaymetrics = new DisplayMetrics();
		WindowManager wm = (WindowManager) current.getApplicationContext()
				.getSystemService(Context.WINDOW_SERVICE);
		wm.getDefaultDisplay().getMetrics(displaymetrics);
		int height = displaymetrics.heightPixels;
		return height;
	}

	public static int getScaleOfScreen(Context ctxx) {
		int cols = 1;
		// no activity required
		WindowManager wm = (WindowManager) ctxx.getApplicationContext()
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();

		int width = display.getWidth();
		int widthdp = (int) (width / Singleton.getInstance().getContext().getResources().getDisplayMetrics().density);

		if (Singleton.getInstance().getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
			if (widthdp < SCREEN_SIZE_NORMALP) {
				cols = 1;
			} else if (widthdp < SCREEN_SIZE_LARGEP) {
				cols = 2;
			} else {
				cols = 3;
			} 
		} else {
			if (widthdp < SCREEN_SIZE_NORMALL) {
				cols = 2;
			} else if (widthdp < SCREEN_SIZE_LARGEL) {
				cols = 3;
			} else {
				cols = 4;
			} 
		}
		return cols;
	}

	public static ArrayList<ArrayList<String>> buildFlagViewGroup(int pageId, int schdId, int viewType, String[] flags) {
		ArrayList<ArrayList<String>> flagGroups = new ArrayList<ArrayList<String>>();

		if(flags[0] != null) {
			ArrayList<String> pageIds = new ArrayList<String>();
			String programShowTypeId = flags[0].substring(0, 2);
			String captionTypeId = flags[0].substring(2,4);
			String audioLevelId = flags[0].substring(4,6);
			String colorTypeId = flags[0].substring(6,8);
			String airingTypeId = flags[0].substring(8,10);
			String subtitled = flags[0].substring(10,11);
			String hdtvLevelId = flags[0].substring(11,13);
			String sign_lang = flags[0].substring(13,14);
			String audio_des = flags[0].substring(14,15);
			String iPlayer_flag = flags[0].substring(15,16);
			pageIds.add(programShowTypeId);
			pageIds.add(captionTypeId);
			pageIds.add(audioLevelId);
			pageIds.add(colorTypeId);
			pageIds.add(airingTypeId);
			pageIds.add(subtitled);
			pageIds.add(hdtvLevelId);
			pageIds.add(sign_lang);
			pageIds.add(audio_des);
			pageIds.add(iPlayer_flag);
			flagGroups.add(pageIds);
		}
		if(flags[1] != null) {
			ArrayList<String> schIds = new ArrayList<String>();
			String time_approximate = flags[1].substring(0,1);
			String program_showing_type = flags[1].substring(1,3);
			String caption_type = flags[1].substring(3,5);
			String audio_level = flags[1].substring(5,7);
			String sAP = flags[1].substring(7,8);
			String color_type = flags[1].substring(8,10);
			String airing_type = flags[1].substring(10,12);
			String is_subtitled = flags[1].substring(12,13);
			String joined_in_progress = flags[1].substring(13,14);
			String subject_to_blackout = flags[1].substring(14,15);
			String aspect_ratio = flags[1].substring(15,17);
			String descriptive_video_service = flags[1].substring(17,18);
			String hDTV_level = flags[1].substring(18,20);
			String is_syndicated = flags[1].substring(20,21);
			String ThreeDimensionalLevelId = flags[1].substring(21,23);
			String sign_lang = flags[1].substring(23,24);
			//			String audio_des = flags[1].substring(24,25);
			schIds.add(time_approximate);
			schIds.add(program_showing_type);
			schIds.add(caption_type);
			schIds.add(audio_level);
			schIds.add(sAP);
			schIds.add(color_type);
			schIds.add(airing_type);
			schIds.add(is_subtitled);
			schIds.add(joined_in_progress);
			schIds.add(subject_to_blackout);
			schIds.add(aspect_ratio);
			schIds.add(descriptive_video_service);
			schIds.add(hDTV_level);
			schIds.add(is_syndicated);
			schIds.add(ThreeDimensionalLevelId);
			schIds.add(sign_lang);
			flagGroups.add(schIds);
		}
		return flagGroups;
	}

	public static String readFlags(ArrayList<String> flags, boolean isSched) {
		String output = "";

		if(isSched) {

		} else {
			for(String i: flags) {
				Log.d("Flags are" , "Flag " + i);
			}
			String input = flags.get(0);
			if(input.equals("02")) {
				output += "MO";
			} else if(input.equals("03")) {
				output += "OT";
			} else if(input.equals("04")) {
				output += "SE";
			} else if(input.equals("05")) {
				output += "SM";
			}

			input = flags.get(1);
			switch(Integer.valueOf(input)) {
			case 2:
				output += "CC";
				break;
			case 3:
				output += "CC/SL";
				break;
			case 5:
				output += "OC";
				break;
			case 6:
				output += "OC/SL";
				break;
			case 7:
				output += "SL";
			}

			input = flags.get(2);
			if(input.equals("02")) {
				output += "Dolby 5.1";
			} else if(input.equals("03")) {
				output += "Surround Sound";
			} else if(input.equals("04")) {
				output += "None";
			} else if(input.equals("05")) {
				output += "Stereo";
			}

			input = flags.get(3);
			if(input.equals("02")) {
				output += "Black and White";
			} else if(input.equals("03")) {
				output += "Color";
			} else if(input.equals("04")) {
				output += "Color & BW Episodes";
			} else if(input.equals("05")) {
				output += "Colorized";
			} else if(input.equals("06")) {
				output += "May be colorized";
			}
			input = flags.get(4);
			switch(Integer.valueOf(input)) {
			case 2:
				output += "Live";
				break;
			case 3:
				output += "New";
				break;
			case 4:
				output += "Repeat";
				break;
			case 5:
				output += "Taped";
				break;
			}

			input = flags.get(6);
			if(input.equals("02")) {
				output += "1080i";
			} else if(input.equals("03")) {
				output += "1080p";
			} else if(input.equals("04")) {
				output += "480p";
			} else if(input.equals("05")) {
				output += "720p";
			} else if(input.equals("06")) {
				output += "HD Level Unknown";
			} else if(input.equals("07")) {
				output += "None";
			}


		}
		return output;
	}
	public static int findMinColumn(Integer[] heights, int currCol) {
		int min = heights[currCol-1];
		int col = currCol-1;
		for(int i = 0; i < heights.length; i++) {
			Log.d("FindMinColumn" , "Height of: " + i + " Is: " + heights[i] + " min " + min);
			if(heights[i] < min) {
				Log.d("swapped", "Height Swapped");
				min = heights[i];
				col = i;
			}
		}
		return col + 1;
	}
//	public static void goToActivity(Context current, int target) {
//		try {
//			Log.d("The Go To Activity target", "Target is " + target);
//			Intent intent = new Intent(current, ActivityUtil.getActivityLabel(target));
//			if(target == Constants.JUMP_ACTIVITY_NOWNEXT) {
//				Log.d("Reorder", "Reorder");
//				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
//			}
//			current.startActivity(intent);
//
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	public static void goToActivity(Context current, int target, Object ... extras) {
//		try {
//			Log.d("The Go To Activity target", "Target is " + target);
//			Intent intent = new Intent(current, ActivityUtil.getActivityLabel(target));
//			for(int i = 0; i < extras.length; i+=2) {
//				if(extras[i+1] instanceof String) {
//					intent.putExtra((String) extras[i], (String) extras[i+1]);
//				} else if(extras[i+1] instanceof Integer) {
//					intent.putExtra((String) extras[i], (Integer) extras[i+1]);
//				} else if(extras[i+1] instanceof Boolean) {
//					intent.putExtra((String) extras[i], (Boolean) extras[i+1]);
//				}
//			}
//			if(target == Constants.JUMP_ACTIVITY_NOWNEXT) {
//				Log.d("Reorder", "Reorder");
//				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
//			}
//			current.startActivity(intent);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	public static SpannableString parseTwitterText(String text, FragmentManager sfm) {
//		SpannableString ss = new SpannableString(text);
//		int i = 0;
//		int j = 0;
//		while(i < text.length() && i > -1 && j < text.length() && j > -1) {
//			i = text.indexOf("#", j);
//			if(i > -1 && i < text.length()) {
//				j = text.indexOf(" ", i);
//			} else {
//				j = -1;
//			}
//			if(j > -1 && j < text.length()) {
//				ss.setSpan(new HashTagSpan(text.substring(i, j)), i, j, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//			} else if(i > -1 && i < text.length()) {
//				ss.setSpan(new HashTagSpan(text.substring(i)), i, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//			}
//		}
//
//		i = 0;
//		j = 0;
//		while(i < text.length() && i > -1 && j < text.length() && j > -1) {
//			i = text.indexOf("@", j);
//			if(i > -1 && i < text.length()) {
//				int temp = text.indexOf(": ", i);
//				j = text.indexOf(" ", i);
//				if(temp > 0 && temp < j) {
//					j = temp;
//				}
//			} else {
//				j = -1;
//			}
//			if(j > -1 && j < text.length()) {
//				ss.setSpan(new UserTagSpan(text.substring(i, j)), i, j, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//			} else if(i > -1 && i < text.length()) {
//				ss.setSpan(new UserTagSpan(text.substring(i)), i, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//			}
//		}
//
//		i = 0;
//		j = 0;
//		while(i < text.length() && i > -1 && j < text.length() && j > -1) {
//			i = text.indexOf("http://", j);
//			if(i > -1 && i < text.length()) {
//				j = text.indexOf(" ", i);
//			} else {
//				j = -1;
//			}
//			if(j > -1 && j < text.length()) {
//				ss.setSpan(new LinkSpan(text.substring(i, j)), i, j, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//			} else if(i > -1 && i < text.length()) {
//				ss.setSpan(new LinkSpan(text.substring(i)), i, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//			}
//		}
//		return ss;
//	}
//
//	public static void initializeSession(Activity activity, StatusCallback callback) {
//		Session session = Session.getActiveSession();
//		if(session != null) {
//			Log.d("session:" ,"Session: " + session.isOpened());
//		}
//		else{
//			Log.d("Null", "Null");
//			Session.openActiveSession(activity, false, callback);
//		}
//	}
//	public static boolean isLoggedInFB() {
//		Session session = Session.getActiveSession();
//		if(session != null)
//			Log.d("session:" ,"Session: " + session.isOpened());
//
//		else{
//			Log.d("Null", "Null");
//		}
//		return (session != null && session.isOpened());
//	}

//	public static SpannableString parseFacebookText(String text) {
//		SpannableString ss = new SpannableString(text);
//		int i = 0;
//		int j = 0;
//
//		while(i < text.length() && i > -1 && j < text.length() && j > -1) {
//			i = text.indexOf("http://", j);
//			if(i > -1 && i < text.length()) {
//				j = text.indexOf(" ", i);
//			} else {
//				j = -1;
//			}
//			if(j > -1 && j < text.length()) {
//				ss.setSpan(new LinkSpan(text.substring(i, j)), i, j, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//			} else if(i > -1 && i < text.length()) {
//				ss.setSpan(new LinkSpan(text.substring(i)), i, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//			}
//		}
//		return ss;
//	}

	public static String parseContentForImage(String content) {
		int indexOfJpg = content.indexOf(".jpg\"") + 4;
		for(int i = indexOfJpg-4; i >= 0; i--) {
			if(content.substring(i, i+4).equals("http")) {
				String returnstring = content.substring(i, indexOfJpg);
				returnstring = returnstring.replace("s130x130", "p480x480");
				return returnstring;
			}
		}

		return "";
	}

	public static String parseContentForMessage(String content) {
		int index = content.indexOf("<");
		if(index != -1) 
			return content.substring(0, index);
		return "";
	}

//	public static boolean isRemoteRecordAvailable(Context context) {
//		List<RemoteRecord> providers = PersistYoTvData.getInstance()
//				.getRemoteRecordProvider(context);
//		return (providers != null && providers.size() > 0);
//	}
//
//	public static void showSpinner(ProgressBar mSeriesRecordSpinner, Context context) {
//		mSeriesRecordSpinner.setVisibility(View.VISIBLE);
//		mSeriesRecordSpinner.startAnimation(AnimationUtils
//				.loadAnimation(context, R.anim.splash_spinner));
//
//	}

	public static void removeSpinner(ProgressBar mSeriesRecordSpinner) {
		mSeriesRecordSpinner.clearAnimation();
		mSeriesRecordSpinner.setVisibility(View.GONE);

	}

//	public static boolean isSkyProviderAvailable(Context context) {
//		ArrayList<RemoteRecord> remoteRecorder = PersistYoTvData.getInstance()
//				.getRemoteRecordProvider(context);
//		if (remoteRecorder != null) {
//			for (RemoteRecord rr : remoteRecorder) {
//				if (rr.getProviderId().equals(Constants.SKY_PROVIDER)) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}

	public static String getDayOfWeek(int day) {
		String[] temp = DateFormatSymbols.getInstance().getWeekdays();
		return temp[day];
	}
//	public static boolean isVirginProviderAvailable(Context context) {
//		ArrayList<RemoteRecord> remoteRecorder = PersistYoTvData.getInstance()
//				.getRemoteRecordProvider(context);
//		if (remoteRecorder != null) {
//			for (RemoteRecord rr : remoteRecorder) {
//				if (rr.getProviderId().equals(Constants.VIRGIN_TIVO_PROVIDER)) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}

}
