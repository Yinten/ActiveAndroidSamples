package com.ryanmattison.samples.activeandroidtest.util;


import com.ryanmattison.samples.activeandroidtest.Constants;


/*

 * SUPPORTING GS flags
 Schedule Flags
 PPCCAACCAASHHYS	(16 characters)
 In order:
 P = program showing type
 C = caption type
 A = audio level
 C = color type
 A = airing type
 S = subtitled
 H = HDTV level
 Y = has sign language interpretation
 S = audio description
 */
/*
 * * SUPPORTING GS flags
 Program_Schedule Flags
 SSCCHHAAMMO	 (11 characters)
 In order:
 S = show type
 C = category
 H = HDTV level
 A = audio levelO
 M = movie type
 O = on demand flag
 */

/*
 * * SUPPORTING old get schedule flags
 Format is:
 IPPCCAASCCAASJBAADHHS33YZ
 (25 characters)
 In order:
 I = is time approximate
 P = program showing type
 C = caption type
 A = audio level
 S = is SAP
 C = color type
 A = airing type
 S = subtitled
 J = joined in progress
 B = subject to blackout
 A = aspect ratio
 D = descriptive video service
 H = HDTV level
 S = is syndicated
 3 = 3d level
 In the UK two extra fields go on the end:
 YZ
 Y = has sign language interpretation
 Z = is audio described
 */

/*
 * * * SUPPORTING old get schedule flags
 server format at the time of writing appears to be:
 SSGCCSHHAAMMCC33 (16 characters)

 In order:

 S = show type
 G = is group language primary
 C = category
 S = is syndicated
 H = HDTV level
 A = audio level
 M = movie type
 C = color type
 3 = 3d level

 */
public class FlagUtil {

	public static int getDescribedAudio(String flags) {
		int audioDescribed = 0;
		if (flags != null) {
			audioDescribed = Integer.valueOf(flags.substring(14, 15));
		}
		return audioDescribed;

	}

//	public static String getHdtvLevel(String flags) {
//		int length = flags.length();
//		int hdtvLevel = 0;
//		if (length <= 16) {
//			hdtvLevel = Integer.valueOf(flags.substring(11, 13)); // from 15char
//																	// text (6,
//																	// 8)
//		} else {
//			hdtvLevel = Integer.valueOf(flags.substring(18, 20)); // from 25char
//			// text (6, 8)
//		}
//		String result = "";
//		switch (hdtvLevel) {
//		case Constants.PROGRAM_HdtvLevelId_1080i:
//			result = Singleton.getInstance().getContext().getString(R.string._1080i);
//			break;
//		case Constants.PROGRAM_HdtvLevelId_1080p:
//			result = Singleton.getInstance().getContext().getString(R.string._1080p);
//			break;
//		case Constants.PROGRAM_HdtvLevelId_480p:
//			result = Singleton.getInstance().getContext().getString(R.string._480p);
//			break;
//		case Constants.PROGRAM_HdtvLevelId_720p:
//			result = Singleton.getInstance().getContext().getString(R.string._720p);
//			break;
//		case Constants.PROGRAM_HdtvLevelId_HD:
//			result = Singleton.getInstance().getContext().getString(R.string.HD);
//			break;
//		case Constants.PROGRAM_HdtvLevelId_SD:
//			result = Singleton.getInstance().getContext().getString(R.string.SD);
//			break;
//
//		}
//		return result;
//	}

//	public static String getAudioLevel(String flags) {
//		int AudioLevel = 0;
//		int length = flags.length();
//		if (length <= 15) {
//			AudioLevel = Integer.valueOf(flags.substring(4, 6)); // from 11 ch
//																	// (8, 10)
//		} else {
//			AudioLevel = Integer.valueOf(flags.substring(5, 7)); // from 17
//																	// chars
//
//		}
//		String result = null;
//		switch (AudioLevel) {
//		case Constants.PROGRAM_AudioLevel_Dolby:
//			result = Singleton.getInstance().getContext().getString(R.string.Dolby_5_1);
//			break;
//		case Constants.PROGRAM_AudioLevel_DSS:
//			result = Singleton.getInstance().getContext().getString(R.string.DSS__0028Surround_Sound_0029);
//			break;
//		case Constants.PROGRAM_AudioLevel_STEREO:
//			result = Singleton.getInstance().getContext().getString(R.string.Stereo);
//			break;
//
//		}
//		return result;
//
//	}

	@Deprecated
	public static String getMovieType(String flags) {
		int AudioLevel = Integer.valueOf(flags.substring(10, 12));
		String result = null;
		switch (AudioLevel) {
		case 2:
			result = "Direct to Video";
			break;
		case 3:
			result = "Made for Cable";
			break;
		}
		return result;
	}

	
	public static String getColorType(String flags) {
		int colorType;	
		String result = null;
		if (flags.length() <= 16) {
			colorType  = Integer.valueOf(flags.substring(6, 8)); // from
																	// 15chars
																	// (3,5)
		} else {
			colorType  = Integer.valueOf(flags.substring(8, 10));
		}
		switch (colorType) {
		case 2:
			result = " (Black and White)";
			break;
		}
		return result;
	}

//	public static String getcaptionType(String flags) {
//		int length = flags.length();
//		int captionType = 0;
//		if (length <= 16) {
//			captionType = Integer.valueOf(flags.substring(2, 4)); // from
//																	// 15chars
//																	// (3,5)
//		} else {
//			captionType = Integer.valueOf(flags.substring(3, 5));
//		}
//		String result = null;
//		switch (captionType) {
//		case 2:
//			result = Singleton.getInstance().getContext().getString(Constants.PROGRAM_CAPTION_TYPE_CC);
//			break;
//		case 3:
//			result = Singleton.getInstance().getContext().getString(Constants.PROGRAM_CAPTION_TYPE_CC_SL);
//			break;
//		case 5:
//			result = Singleton.getInstance().getContext().getString(Constants.PROGRAM_CAPTION_TYPE_OC);
//			break;
//		case 6:
//			result = Singleton.getInstance().getContext().getString(Constants.PROGRAM_CAPTION_TYPE_OC_SL);
//			break;
//		case 7:
//			result = Singleton.getInstance().getContext().getString(Constants.PROGRAM_CAPTION_TYPE_SL);
//			break;
//		}
//		return result;
//	}

	public static int getSubtitled(String flags) {
		int result = 0;
		try {
			if (Util.isNonEmptyString(flags)) {
				int length = flags.length();
				if (length <= 16) {
					result = Integer.valueOf(flags.substring(10, 11));
				} else {
					result = Integer.valueOf(flags.substring(11, 12));
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return result;

	}

//	public static String getAiringType(String flags) {
//		int length = flags.length();
//		int airType = 0;
//		if(length <= 0)
//			return null;
//		if (length <= 16) {
//			airType = Integer.valueOf(flags.substring(8, 10)); // from
//																// 15chars10, 12
//		} else {
//			airType = Integer.valueOf(flags.substring(10, 12)); // from
//																// 25chars10, 12
//		}
//		String result = null;
//		switch (airType) {
//		case 2:
//			result = Singleton.getInstance().getContext().getString(Constants.PROGRAM_AIR_TYPE_LIVE);
//			break;
//		case 3:
//			result = Singleton.getInstance().getContext().getString(Constants.PROGRAM_AIR_TYPE_NEW);
//			break;
//		case 4:
//			result = Singleton.getInstance().getContext().getString(Constants.PROGRAM_AIR_TYPE_REPEAT);
//			break;
//		case 5:
//			result = Singleton.getInstance().getContext().getString(Constants.PROGRAM_AIR_TYPE_TAPED);
//			break;
//		}
//		return result;
//	}

	/*returns the color code information on the category*/
	public static int getCategory(String flags) {
		int type = 0;
		int length = flags.length();
		if(length <= 0)
			return 0;
		if (length <= 18) {
			type = Integer.valueOf(flags.substring(2, 4)); // from 17chars (3,5)
		} else {
			type = Integer.valueOf(flags.substring(8, 10)); // from 25
		}
		int result = 0;
		switch (type) {
		case 2:
			result = Constants.PROGRAM_CATEGORY_CHILD;
			break;
		case 3:
			result = Constants.PROGRAM_CATEGORY_LIFESTYLE;
			break;
		case 5:
			result = Constants.PROGRAM_CATEGORY_MUSIC;
			break;
		case 6:
			result = Constants.PROGRAM_CATEGORY_NEWS;
			break;
		case 8:
			result = Constants.PROGRAM_CATEGORY_SPORT;
			break;
		case 10:
			result = Constants.PROGRAM_CATEGORY_COMEDY;
			break;
		case 11:
			result = Constants.PROGRAM_CATEGORY_SOAP;
			break;
		case 12:
			result = Constants.PROGRAM_CATEGORY_DRAMA;
			break;
		case 13:
			result = Constants.PROGRAM_CATEGORY_CHAT_SHOW;
			break;
		case 14:
			result = Constants.PROGRAM_CATEGORY_GAME_SHOW;
			break;
		case 15:
			result = Constants.PROGRAM_CATEGORY_SCI_FI;
			break;
		case 16:
			result = Constants.PROGRAM_CATEGORY_DOCUMENTARY;
			break;
		case 17:
			result = Constants.PROGRAM_CATEGORY_MOTORING;
			break;
		case 18:
			result = Constants.PROGRAM_CATEGORY_HORROR;
			break;
		case 19:
			result = Constants.PROGRAM_CATEGORY_ACTION;
			break;
		case 20:
			result = Constants.PROGRAM_CATEGORY_ROMANCE;
			break;
		case 21:
			result = Constants.PROGRAM_CATEGORY_PERFORMANCE;
			break;
		case 22:
			result = Constants.PROGRAM_CATEGORY_ANIMATION;
			break;
		}

		return result;
	}
	public static int getCategorySearch(String flags) {
		int type = 0;
		int length = flags.length();
		if (length <= 18) {
			type = Integer.valueOf(flags.substring(3, 5)); // from 17chars (3,5)
		} else {
			type = Integer.valueOf(flags.substring(8, 10)); // from 25
		}
		int result = 0;
		switch (type) {
		case 2:
			result = Constants.PROGRAM_CATEGORY_CHILD;
			break;
		case 3:
			result = Constants.PROGRAM_CATEGORY_LIFESTYLE;
			break;
		case 5:
			result = Constants.PROGRAM_CATEGORY_MUSIC;
			break;
		case 6:
			result = Constants.PROGRAM_CATEGORY_NEWS;
			break;
		case 8:
			result = Constants.PROGRAM_CATEGORY_SPORT;
			break;
		case 10:
			result = Constants.PROGRAM_CATEGORY_COMEDY;
			break;
		case 11:
			result = Constants.PROGRAM_CATEGORY_SOAP;
			break;
		case 12:
			result = Constants.PROGRAM_CATEGORY_DRAMA;
			break;
		case 13:
			result = Constants.PROGRAM_CATEGORY_CHAT_SHOW;
			break;
		case 14:
			result = Constants.PROGRAM_CATEGORY_GAME_SHOW;
			break;
		case 15:
			result = Constants.PROGRAM_CATEGORY_SCI_FI;
			break;
		case 16:
			result = Constants.PROGRAM_CATEGORY_DOCUMENTARY;
			break;
		case 17:
			result = Constants.PROGRAM_CATEGORY_MOTORING;
			break;
		case 18:
			result = Constants.PROGRAM_CATEGORY_HORROR;
			break;
		case 19:
			result = Constants.PROGRAM_CATEGORY_ACTION;
			break;
		case 20:
			result = Constants.PROGRAM_CATEGORY_ROMANCE;
			break;
		case 21:
			result = Constants.PROGRAM_CATEGORY_PERFORMANCE;
			break;
		case 22:
			result = Constants.PROGRAM_CATEGORY_ANIMATION;
			break;
		}

		return result;
	}
	
	public static int getCategoryByInt(String flags) {
		int type = Integer.valueOf(flags);
		int result = 0;
		switch (type) {
		case 2:
			result = Constants.PROGRAM_CATEGORY_CHILD;
			break;
		case 3:
			result = Constants.PROGRAM_CATEGORY_LIFESTYLE;
			break;
		case 5:
			result = Constants.PROGRAM_CATEGORY_MUSIC;
			break;
		case 6:
			result = Constants.PROGRAM_CATEGORY_NEWS;
			break;
		case 8:
			result = Constants.PROGRAM_CATEGORY_SPORT;
			break;
		case 10:
			result = Constants.PROGRAM_CATEGORY_COMEDY;
			break;
		case 11:
			result = Constants.PROGRAM_CATEGORY_SOAP;
			break;
		case 12:
			result = Constants.PROGRAM_CATEGORY_DRAMA;
			break;
		case 13:
			result = Constants.PROGRAM_CATEGORY_CHAT_SHOW;
			break;
		case 14:
			result = Constants.PROGRAM_CATEGORY_GAME_SHOW;
			break;
		case 15:
			result = Constants.PROGRAM_CATEGORY_SCI_FI;
			break;
		case 16:
			result = Constants.PROGRAM_CATEGORY_DOCUMENTARY;
			break;
		case 17:
			result = Constants.PROGRAM_CATEGORY_MOTORING;
			break;
		case 18:
			result = Constants.PROGRAM_CATEGORY_HORROR;
			break;
		case 19:
			result = Constants.PROGRAM_CATEGORY_ACTION;
			break;
		case 20:
			result = Constants.PROGRAM_CATEGORY_ROMANCE;
			break;
		case 21:
			result = Constants.PROGRAM_CATEGORY_PERFORMANCE;
			break;
		case 22:
			result = Constants.PROGRAM_CATEGORY_ANIMATION;
			break;
		}

		return result;
	}

	public static int getSignLanguageInterpretation(String flags) {
		int result = 0;
		try {
			if (Util.isNonEmptyString(flags)) {
				if (flags.length() > 20) {
					result = Integer.valueOf(flags.substring(23, 24));
				} else if (flags.length() <= 16) {
					result = Integer.valueOf(flags.substring(14, 15));
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return result;
	}

	public static int getShowType(String flags) {
		int showType = 0;
		if (Util.isNonEmptyString(flags)) {
			try {
				if(flags.length() <= 16) {
				showType = Integer.valueOf(flags.substring(0, 2));
				} else {
					showType = Integer.valueOf(flags.substring(1, 3));
				}
			} catch (Exception e) {
				showType = 0;
			}
		}
		return showType;
	}

	public static int getOnDemandFlag(String flags) {
		int onDemand = 0;
		if (Util.isNonEmptyString(flags)) {
			try {
				if (flags.length() > 16) {
					onDemand = Integer.valueOf(flags.substring(16, 17));
				} else {
					onDemand = Integer.valueOf(flags.substring(10, 11));
				}
			} catch (Exception e) {
				onDemand = -1;
			}
		}
		return onDemand;
	}

//	/*returns the String value of Program Show Type*/
//	public static String getProgramShowType(String flags) {
//		String result = null;
//
//		int programShowType = 0;
//		if (Util.isNonEmptyString(flags)) {
//			try {
//				int length = flags.length();
//				if (length > 20) {
//					// old get schedule system
//					programShowType = Integer.valueOf(flags.substring(1, 3));
//				} else if (length <= 16) {
//					// new get schedule system
//					programShowType = Integer.valueOf(flags.substring(0, 2));
//				}
//
//				switch (programShowType) {
//				case 2: // finale
//					result = Singleton.getInstance().getContext().getString(R.string.Finale);
//					break;
//				case 3: // premiere
//					result = Singleton.getInstance().getContext().getString(R.string.premiere);
//				case 6: // season premiere
//					result = Singleton.getInstance().getContext().getString(R.string.season_premiere);
//				case 7: // series premiere
//					result = Singleton.getInstance().getContext().getString(R.string.series_premiere);
//					break;
//				case 4: // season finale
//					result = Singleton.getInstance().getContext().getString(R.string.season_finale);
//					break;
//				case 5: // series finale
//					result = Singleton.getInstance().getContext().getString(R.string.series_finale);
//					break;
//				}
//			} catch (Throwable t) {
//				t.printStackTrace();
//			}
//		}
//		return result;
//	}
//	


	

}
