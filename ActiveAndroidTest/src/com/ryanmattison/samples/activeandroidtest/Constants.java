package com.ryanmattison.samples.activeandroidtest;

import android.graphics.Color;
public class Constants {
	//Twitter Constants Should remove later
	public static String TWITTER_CONSUMER_KEY = "XodLiAhqW9HgdgflmU80MLFJm";
    public static String TWITTER_CONSUMER_SECRET = "bwnT7FAcaSG1IXqZJdDjp0AJFaWBP3PCFXdKfA8bJBOUHcDVfv";
    public static String TWITTER_BLANK_CALLBACK_URL = "oauth://com.yo.tv.dialogs.BlankDialogActivity";
    public static String TWITTER_POST_CALLBACK_URL = "oauth://com.yo.tv.dialogs.TwitterDialogActivity";
    public static String URL_PARAMETER_TWITTER_OAUTH_VERIFIER = "oauth_verifier";
    public static String PREFERENCE_TWITTER_OAUTH_TOKEN="TWITTER_OAUTH_TOKEN";
    public static String PREFERENCE_TWITTER_OAUTH_TOKEN_SECRET="TWITTER_OAUTH_TOKEN_SECRET";
    public static String PREFERENCE_TWITTER_IS_LOGGED_IN="TWITTER_IS_LOGGED_IN";
    public static String STRING_EXTRA_AUTHENCATION_URL = "AuthencationUrl";

//    //Ends Here
//	public static final  int GENRE_ACTION = R.string.Action;
//	public static final  int GENRE_ANIMATION = R.string.Animation;
//	public static final  int GENRE_AUTO = R.string.Automotive;
//	public static final  int GENRE_COMEDY = R.string.Comedy;
//	public static final  int GENRE_DOCU = R.string.Documentary;
//	public static final  int GENRE_DRAMA = R.string.Drama;
//	public static final  int GENRE_FAMILY = R.string.Family;
//	public static final  int GENRE_GAME = R.string.Game_Show;
//	public static final  int GENRE_HORROR = R.string.Genre;
//	public static final  int GENRE_LIFE = R.string.Lifestyle;
//	public static final  int GENRE_MUSIC = R.string.Music;
//	public static final  int GENRE_NEWS = R.string.News;
//	public static final  int GENRE_ARTS = R.string.Performance_002fAwards;
//	public static final  int GENRE_ROMANCE = R.string.Romance;
//	public static final  int GENRE_SCIFI = R.string.Sci_Fi;
//	public static final  int GENRE_SOAP = R.string.Soap;
//	public static final  int GENRE_SPORTS = R.string.Sports;
//	public static final  int GENRE_TALK = R.string.Chat_Show;

	public static final  int GENRE_FAMILY_INT = 2;
	public static final  int GENRE_LIFE_INT = 3;
	public static final  int GENRE_MUSIC_INT = 5;
	public static final  int GENRE_NEWS_INT = 6;
	public static final  int GENRE_SPORTS_INT = 8;
	public static final  int GENRE_COMEDY_INT = 10;
	public static final  int GENRE_SOAP_INT = 11;
	public static final  int GENRE_DRAMA_INT = 12;
	public static final  int GENRE_TALK_INT = 13;
	public static final  int GENRE_GAME_INT = 14;
	public static final  int GENRE_SCIFI_INT = 15;
	public static final  int GENRE_DOCU_INT = 16;
	public static final  int GENRE_AUTO_INT = 17;
	public static final  int GENRE_HORROR_INT = 18;
	public static final  int GENRE_ACTION_INT = 19;
	public static final  int GENRE_ROMANCE_INT = 20;
	public static final  int GENRE_ARTS_INT = 21;
	public static final  int GENRE_ANIMATION_INT = 22;
	
	public static final int JUMP_ACTIVITY_ENGAGE = 57;
	public static final int JUMP_ACTIVITY_SEARCH = 55;
	public static final int JUMP_ACTIVITY_NOWNEXT = 1;
	public static final int JUMP_ACTIVITY_FAVORITES = 2;
	public static final int JUMP_ACTIVITY_ALERTS = 3;
	public static final int JUMP_ACTIVITY_CONTACT = 5;
	public static final int JUMP_ACTIVITY_SORTSELECT = 56;
	public static final int JUMP_ACTIVITY_FACEBOOK = 0;
	public static final int JUMP_ACTIVITY_FULLDAY = 58;
	
	public static final int JUMP_ACTIVITY_ALSOON = 61;
	public static final int JUMP_ACTIVITY_CASTCREW = 62;
	public static final int JUMP_ACTIVITY_EPISODEGUIDE = 63;
	public static final int JUMP_ACTIVITY_GOOGLEWEBVIEW = 64;
	public static final int JUMP_ACTIVITY_IMAGES = 65;
	public static final int JUMP_ACTIVITY_RELATED = 66;
	public static final int JUMP_ACTIVITY_ROTTENTOMATOES = 67;
	public static final int JUMP_ACTIVITY_TWITTERHASHTAG = 68;
	public static final int JUMP_ACTIVITY_TWITTERUSER = 69;
	public static final int JUMP_ACTIVITY_WIKI = 70;
	
	
//	
//	public static final Class<SearchActivity> JUMP_ACTIVITY_SEARCH_STRING = SearchActivity.class;
//    public static final Class<NowAndNextMainActivity> JUMP_ACTIVITY_NOWNEXT_STRING = NowAndNextMainActivity.class;
//    public static final Class<FavoritesMainActivity> JUMP_ACTIVITY_FAVORITES_STRING = FavoritesMainActivity.class;
//    public static final Class<AlertsMainActivity> JUMP_ACTIVITY_ALERTS_STRING = AlertsMainActivity.class;
//    public static final Class<EngagePanelMainActivity> JUMP_ACTIVITY_ENGAGE_STRING = EngagePanelMainActivity.class;
//    public static final Class<ContactHelpActivity> JUMP_ACTIVITY_CONTACT_STRING = ContactHelpActivity.class;
//    public static final Class<SortSelectChannels> JUMP_ACTIVITY_SORTSELECT_STRING = SortSelectChannels.class;
//    public static final Class<FacebookLoginActivity> JUMP_ACTIVITY_FACEBOOK_STRING = FacebookLoginActivity.class;
//    public static final Class<FullDayMainActivity> JUMP_ACTIVITY_FULLDAY_STRING = FullDayMainActivity.class;
//
//    public static final Class<AlsoOnActivity> JUMP_ACTIVITY_ALSOON_STRING = AlsoOnActivity.class;
//    public static final Class<CastCrewActivity> JUMP_ACTIVITY_CASTCREW_STRING = CastCrewActivity.class;
//    public static final Class<EpisodeGuideActivity> JUMP_ACTIVITY_EPISODEGUIDE_STRING = EpisodeGuideActivity.class;
//    public static final Class<GoogleWebViewActivity> JUMP_ACTIVITY_GOOGLEWEBVIEW_STRING = GoogleWebViewActivity.class;
//    public static final Class<ImagesPageActivity> JUMP_ACTIVITY_IMAGES_STRING = ImagesPageActivity.class;
//    public static final Class<RelatedActivity> JUMP_ACTIVITY_RELATED_STRING = RelatedActivity.class;
//    public static final Class<RottenTomatoesActivity> JUMP_ACTIVITY_ROTTENTOMATOES_STRING = RottenTomatoesActivity.class;
//    public static final Class<TwitterHashTagActivity> JUMP_ACTIVITY_TWITTERHASHTAG_STRING = TwitterHashTagActivity.class;
//    public static final Class<TwitterUserActivity> JUMP_ACTIVITY_TWITTERUSER_STRING = TwitterUserActivity.class;
//    public static final Class<WikiPageActivity> JUMP_ACTIVITY_WIKI_STRING = WikiPageActivity.class;
	
	public static final String SKY_PROVIDER = "2";
	public static final String VIRGIN_TIVO_PROVIDER = "3";
	public static final String CHANNEL_ID = "ChannelId";
	public static final String EVENT_ID = "EventId";
	public static final String START_TIME = "StartTime";
	public static final String DATA_START="data-start";
	public static final String EPISODE_ID = "EP";
	public static final String CHANNEL_NUMBER = "ChannelNumber";
	public static final String LOGIN_ARGUMENT_IS_SERIES_RECORDING = "isSeriesRecording";
	public static final String MASTER_PASSWORD = "St@y hungry, st@";
	public static final String INSTALLATION = "YOTVAPPID2";
	public static final String DB_NAME_OLD_TVGUIDE_UK = "TVGuideUK.db";
	public static final String DB_NAME = "YoTV.db";
	public static final String INITIALIZATION_VECTOR = "pZUorjfjDYP94ITL";

	public static String FILE_NAME_ENABLED_AND_DISABLED_CHANNELS = "en_disable_chan.bin";
	public static String FILE_NAME_ENABLED_CHANNELS = "enabled_chan.bin";
	public static String FILE_NAME_MSO= "mso.bin";
	public static String FILE_NAME_REMOTE_RECORD_PROVIDERS = "remote_record.bin";
	//	public static String FILE_NAME_SKY = "sky.bin";
	//	public static String FILE_NAME_VIRGIN = "virgin.bin";

	public static final int DIALOG_PROGRESS_ID = 1;
	public static final String PREFERENCE_FILE_NAME = "YoPreference";
	public static final String PREFERENCE_OPTION_SETTINGS = "OptionsSetting";
	public static final int PREFERENCE_OPTIONS_SETTING_DEFAULT = 0;
	//public static final String PREFERENCE_MSO = "mso";
	//public static final String PREFERENCE_SOURCE_LIST ="source_list";
	//public static final String PREFERENCE_ENABLED_AND_DISABLED_CHANNELS = "enabled_disabled_channels";
	//public static final String PREFERENCE_NOW_AND_NEXT_LINEUP = "now_and_next_lineup";
	//public static final String PREFERENCE_LONGER_SOURCE_LIST ="longer_source_list";
	//public static final String PREFERENCE_SKY = "sky_preference";
	//public static final String PREFERENCE_VIRGIN = "virgin_preference";
	// public static final String PREFERENCE_OLD_MSO = "old_mso";
	public static final String PREFERENCE_DELAY_TIME = "DelayTime";
	public static final int PREFERENCE_DELAY_TIME_DEFAULT = 5;
	public static final String PREFERENCE_FULL_DAY_FAILURE_STATUS ="FullDayFailure";
	public static final String PREFERENCE_SERVICE_BUSY_STATUS = "ServiceBusyStatus";




	public static final byte PROGRAM_TYPE_ALERT = 0;
	public static final byte PROGRAM_TYPE_FAVORITE = 0x1;
	public static final byte PROGRAM_TYPE_ALSO_ON = 0x2;
	public static final byte PROGRAM_TYPE_SEARCH_RESULT = 0x3;
	public static final byte PROGRAM_TYPE_LINEUP = 0x4;
	public static final byte PROGRAM_TYPE_GRID = 0x5;
	public static final byte PROGRAM_TYPE_FULL_DAY = 0x6;

	public static final String YOTV_EMAIL_ADDRESS = "support@yo.tv";

	public static final int USER_EVENT_ADD_ALERT = 1;
	public static final int USER_EVENT_REMOTE_RECORD = 2;
	public static final int USER_EVENT_ADD_CALENDAR = 3;
	public static final int USER_EVENT_ADD_FAVORITE = 4;
	public static final int USER_EVENT_SHARE = 5;
	public static final int USER_EVENT_RATE = 6;
	public static final int USER_EVENT_WATCH= 7;
	public static final int USER_EVENT_SAMSUNG_CHANNEL_CHANGE=8;
	public static final int USER_EVENT_SHOW = 10;
	public static final int USER_EVENT_ENGAGEMENT_PANEL=11;
	public static final int USER_EVENT_PLUS_BUTTON = 13;
	public static final byte PROGRAM_ON_DEMAND = 0x1;

	public static final byte PROGRAM_SHOW_TYPE_MOVIE = 0x2;
	public static final byte PROGRAM_HdtvLevelId_1080i = 0x2;
	public static final byte PROGRAM_HdtvLevelId_1080p = 0x3;
	public static final byte PROGRAM_HdtvLevelId_480p = 0x4;
	public static final byte PROGRAM_HdtvLevelId_720p = 0x5;
	public static final byte PROGRAM_HdtvLevelId_HD = 0x6;
	public static final byte PROGRAM_HdtvLevelId_SD = 0x7;
	public static final byte PROGRAM_AudioLevel_Dolby = 0x2;
	public static final byte PROGRAM_AudioLevel_DSS = 0x3;
	public static final byte PROGRAM_AudioLevel_STEREO = 0x5;

//	public static final int PROGRAM_AIR_TYPE_REPEAT = R.string.Repeat;
//	public static final int PROGRAM_AIR_TYPE_LIVE = R.string.Live;
//	public static final int PROGRAM_AIR_TYPE_NEW = R.string.New;
//	public static final int PROGRAM_AIR_TYPE_TAPED = R.string.Taped;

	public static final int PROGRAM_SHOWTYPE_PREMIERE = 3;
	public static final int PROGRAM_SHOWTYPE_SEASON_PREMIERE = 6;
	public static final int PROGRAM_SHOWTYPE_SEASON_SERIES_PREMIERE = 7;

//	public static final int PROGRAM_CAPTION_TYPE_CC = R.string.CC;
//	public static final int PROGRAM_CAPTION_TYPE_CC_SL = R.string.CC_002fSL;
//	public static final int PROGRAM_CAPTION_TYPE_OC = R.string.OC;
//	public static final int PROGRAM_CAPTION_TYPE_SL = R.string.SL;
//	public static final int PROGRAM_CAPTION_TYPE_OC_SL = R.string.OC_002fSL;

	public static final int PROGRAM_CATEGORY_ACTION = Color
			.parseColor("#336666");
	public static final int PROGRAM_CATEGORY_ANIMATION = Color
			.parseColor("#0edecb");
	public static final int PROGRAM_CATEGORY_LIFESTYLE = Color
			.parseColor("#97cee2");
	public static final int PROGRAM_CATEGORY_PERFORMANCE = Color
			.parseColor("#decb0e");
	public static final int PROGRAM_CATEGORY_ROMANCE = Color
			.parseColor("#ff3399");
	public static final int PROGRAM_CATEGORY_CHILD = Color
			.parseColor("#e3bb00");
	public static final int PROGRAM_CATEGORY_MUSIC = Color
			.parseColor("#ff9933");
	public static final int PROGRAM_CATEGORY_NEWS = Color.parseColor("#636363");
	public static final int PROGRAM_CATEGORY_NEWS_VALUE = 6;
	public static final int PROGRAM_CATEGORY_SPORT = Color
			.parseColor("#52ce32");
	public static final int PROGRAM_CATEGORY_SPORT_VALUE = 8;
	public static final int PROGRAM_CATEGORY_COMEDY = Color
			.parseColor("#3253cf");
	public static final int PROGRAM_CATEGORY_SOAP = Color.parseColor("#ab337d");
	public static final int PROGRAM_CATEGORY_DRAMA = Color
			.parseColor("#ce3d32");
	public static final int PROGRAM_CATEGORY_CHAT_SHOW = Color
			.parseColor("#800000");
	public static final int PROGRAM_CATEGORY_GAME_SHOW = Color
			.parseColor("#669999");
	public static final int PROGRAM_CATEGORY_SCI_FI = Color
			.parseColor("#666699");
	public static final int PROGRAM_CATEGORY_DOCUMENTARY = Color
			.parseColor("#cccccc");
	public static final int PROGRAM_CATEGORY_MOTORING = Color
			.parseColor("#996633");
	public static final int PROGRAM_CATEGORY_HORROR = Color
			.parseColor("#666633");
	public static final byte SINGLE_LINEUP_ADAPTER_TYPE_NO_CHANNEL = 0;
	public static final byte SINGLE_LINEUP_ADAPTER_TYPE_ALSO_ON = 0x1;
	public static final byte SINGLE_LINEUP_ADAPTER_CLIENT_FAVORITE = 0x2;
	public static final byte SINGLE_LINEUP_ADAPTER_CLIENT_ALARM = 0x3;

	public static final int SINGLE_LINEUP_ADAPTER_ALSO_ON_CATEGORY_NEW = 4;
	public static final int SINGLE_LINEUP_ADAPTER_ALSO_ON_CATEGORY_UP_COMING_FILM = 5;
	public static final int SINGLE_LINEUP_ADAPTER_ALSO_ON_CATEGORY_TOP_RATED = 6;
	public static final int SINGLE_LINEUP_ADAPTER_ALSO_ON_CATEGORY_TRENDING = 7;
	public static final int SINGLE_LINEUP_ADAPTER_ALSO_ON_CATEGORY_SPORTS=8;

	static public final byte IMAGE_SETTING_WIFI = 0;
	static public final byte IMAGE_SETTING_ALWAYS = 0x1;
	static public final byte IMAGE_SETTING_NEVER = 0x2;
	static public final byte IMAGE_SETTING_DEFAULT = IMAGE_SETTING_WIFI;

	public static final String YOTV_INTENT_EXTRA_CATEOGORY = "category";
	public static final String YOTV_INTENT_EXTRA_TITLE = "title";
	public static final String YOTV_INTENT_EXTRA_FROM = "from";
	public static final String YOTV_INTENT_EXTRA_IS_NEW_SYSTEM = "intent_extra_new_system_selected";
	public static final String YOTV_NOW_AND_NEXT = "NowAndNext";
	public static final String YOTV_INTENT_EXTRA_MESSAGE = "message";
	public static final String YOTV_INTENT_EXTRA_COUNTRY = "country";
	public static final String YOTV_INTENT_EXTRA_CITY = "city";
	public static final String YOTV_INTENT_EXTRA_POSTALCODE = "postalcode";
	public static final String YOTV_INTENT_EXTRA_PROGRAM_TITLE = "programTitle";
	public static final String YOTV_INTENT_EXTRA_IS_NOTIFY = "isNotify";
	public static final String YOTV_INTENT_EXTRA_IS_NOTIFY_VALUE = "true";
	public static final String YOTV_INTENT_EXTRA_SORT_CHANNEL = "sort_channel";
	public static final String YOTV_INTENT_EXTRA_SELECT_CHANNEL = "select_channel";;
	public static final String YOTV_INTENT_ACTION_SELECT_AND_SORT_CHANNEL = "com.yo.tv.core.action.SORT_CHANNELS";
	public static final String YOTV_INTENT_EXTRA_SELECT_AND_SORT_CHANNEL = "sort_select_channel";
	public static final String YOTV_INTENT_EXTRA_NOW_AND_NEXT_FROM_MENU = "now_and_next_menu";
	public static final String YOTV_INTENT_EXTRA_NEW_MSO = "new_mso";
	public static final String YOTV_INTENT_EXTRA_MSO = "mso";
	public static final String YOTV_INTENT_EXTRA_REGION_ID = "regionid";
	public static final String YOTV_INTENT_EXTRA_STREAM_URL = "stream_url";
	public static final String YOTV_INTENT_EXTRA_GRID_URL = "grid_url";
	public static final String YOTV_INTENT_EXTRA_DATE_TIME = "date_time";
	public static final String YOTV_INTENT_EXTRA_FULL_DAY = "full_day";
	public static final String YOTV_INTENT_EXTRA_FIRST_INDEX = "firstIndex";
	public static final String YOTV_INTENT_EXTRA_LAST_INDEX = "lastIndex";
	public static final String YOTV_INTENT_EXTRA_SOURCE_POSITION = "source_position";

	public static final String YOTV_BUNDLE_EXTRA_SCHEDULE_ID = "scheduleId";
	public static final String YOTV_BUNDLE_EXTRA_REGION_ID ="regionId";
	public static final String YOTV_BUNDLE_EXTRA_LONG_TITLE = "longTitle";
	public static final String YOTV_BUNDLE_EXTRA_START_DATE_TIME= "startDateTime";
	public static final String YOTV_BUNDLE_EXTRA_MESSAGE="message";
	public static final String YOTV_BUNDLE_EXTRA_SOURCE_FULLNAME= "fullname";
	public static final String YOTV_BUNDLE_EXTRA_KEY="notification";
	public static final String YOTV_BUNDLE_EXTRA_SOURCE_COUNTRY = "country";
	public static final String YOTV_BUNDLE_EXTRA_SOURCE_HEADENDID = "headendId";
	public static final String YOTV_BUNDLE_EXTRA_SOURCE_SOURCEID = "sourceId";
	public static final String YOTV_BUNDLE_EXTRA_SOURCE_CHANNELNUMBER = "channelNumber";

	public static final String YOTV_INTENT_EXTRA_MESSENGER_GET_COUNTRY_CLIENT = "MESSENGER_GET_COUNTRY_CLIENT";
	public static final String YOTV_INTENT_EXTRA_MESSENGER_SINGLE_LINEUP_CLIENT = "MESSENGER_SINGLELINEUP_CLIENT";
	public static final String YOTV_INTENT_EXTRA_MESSENGER_NOW_AND_NEXT_CLIENT = "MESSENGER_NOW_AND_NEXT_CLIENT";
	public static final String YOTV_INTENT_EXTRA_MESSENGER_POST_CITY_CLIENT = "MESSENGER_GET_POST_CITY_CLIENT";

	public static final String ACTION_GET_CITY = "ACTION_GET_CITY";
	public static final String ACTION_GET_COUNTRY = "ACTION_GET_COUNTRY";
	public static final String ACTION_GET_POSTAL_CODE = "ACTION_GET_POSTAL_CODE";
	public static final String ACTION_GET_SINGLE_LINEUP = "ACTION_GET_SINGLE_LINEUP";
	public static final String ACTION_GET_SOURCE = "ACTION_GET_SOURCE";
	public static final String ACTION_GET_SCHEDULE = "ACTION_GET_SCHEDULE";
	public static final String ACTION_GET_SOURCE_DATA_CLIENT = "ACTION_GET_SOURCE_DATA_CLIENT";
	public static final String ACTION_GET_FULL_DAY_LISTING ="ACTION_GET_FULL_DAY_LISTING";

	public static final String YOTV_INTENT_SERIALIZABLE_EXTRA_COUNTRY = "country";
	public static final String YOTV_INTENT_SERIALIZABLE_EXTRA_CITY = "city";
	public static final String YOTV_INTENT_SERIALIZABLE_EXTRA_SOURCE_DATA = "source_data";
	public static final String YOTV_INTENT_SERIALIZABLE_EXTRA_SELECTED_PROGRAM = "selectedProgram";
	public static final String YOTV_INTENT_SERIALIZABLE_EXTRA_POSTALCODE = "postalcode";
	public static final String YOTV_INTENT_SERIALIZABLE_EXTRA_REGIONID = "regionid";
	public static final String YOTV_POSTCODE_ADAPTER = "PostCodeAdapter";
	public static final String YOTV_CITY_ADAPTER = "CityAdapter";
	public static int CURSOR_MAX_COUNT = 100;
	public static final int NOW_AND_NEXT_PROGRAMMES_ROW_COUNT = 3;

	// Interval constants (in milliseconds)
	public static final long INTERVAL_1_SECOND = (1000L);
	public static final long INTERVAL_2_SECONDS = (2L * INTERVAL_1_SECOND);
	public static final long INTERVAL_1_MINUTE = (60L * INTERVAL_1_SECOND);
	public static final long INTERVAL_2_MINUTES = (2L * INTERVAL_1_MINUTE);
	public static final long INTERVAL_1_HOUR = (60L * INTERVAL_1_MINUTE);
	public static final long INTERVAL_24_HOURS = (24L * INTERVAL_1_HOUR);
	public static final long INTERVAL_1_DAY = INTERVAL_24_HOURS;
	public static final long INTERVAL_1_WEEK = INTERVAL_1_DAY * 7L;
	public static final long INTERVAL_1_MONTH = (30L * INTERVAL_1_DAY);
	public static final int DAY = 1;
	public static final int MINUTE = 1;
	// constants for AppService class

	// public static final byte MESSENGER_GET_COUNTRY_CLIENT = 0xA;
	public static final byte MESSENGER_GET_CITY_CLIENT = 0x2;
	public static final byte MESSENGER_GET_POSTAL_CODE_CLIENT = 0x3;
	public static final byte MESSENGER_GET_SINGLE_LINEUP_CLIENT = 0x4;
	public static final byte MESSENGER_GET_SOURCE_CLIENT = 0x5;
	public static final byte MESSENGER_GET_SCHEDULE_CLIENT = 0x6;	
	public static final byte MESSENGER_GET_SOURCE_DATA_CLIENT = 0x7;


	public static final String YOTV_SESSION_LOCAL_REQUEST_GS_TIME = "LASTGSREQUESTTIME";
	public static final String YOTV_SESSION_LOCAL_REQUEST_EP_TIME = "LASTEPREQUESTTIME";
	public static final String YOTV_SESSION_LOCAL_REQUEST_GSL_TIME = "LASTGSLREQUESTTIME";

	public static final String KEY_ACCTID = "acctid";
	public static final String KEY_COUNTRY = "country";
	public static final String KEY_POSTAL = "postal";
	public static final String KEY_HEADENDS = "headends";
	public static final String KEY_REGION = "region";
	public static final String KEY_SOURCELIST = "sourcelist";
	public static final String KEY_SOURCELIST_LONG = "sourcelistLong";
	public static final String KEY_DOWNLOAD_IMAGES = "downloadImages";
	public static final String KEY_DOWNLOAD_LISTINGS = "downloadListings";
	public static final String KEY_ALERT_DELAY = "alertDelay";
	public static final String KEY_FB_ID = "fb_id";
	public static final String KEY_FB_NAME = "fb_name";
	public static final String KEY_CHANNEL_DEVICE = "channelDevice";
	public static final String KEY_INITIALIZED = "initialized";
	public static final String KEY_SKY_U = "sky_u";
	public static final String KEY_VIRGIN_U = "virgin_u";
	public static final String KEY_SKY_P = "sky_p";
	public static final String KEY_VIRGIN_P = "virgin_p";
	public static final String KEY_LAST_REQEUEST_NOWNEXT = "now_next";
	public static final String KEY_SPINNER = "spinner";
	public static final String KEY_LAST_LISTING_UPDATE= "channelListingsUpdate";
}
