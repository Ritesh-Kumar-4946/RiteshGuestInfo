package com.example.ritesh.guestinfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by ritesh on 17/11/16.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    /*http://www.theappguruz.com/blog/android-using-sqlite-database*/
    /*http://www.theappguruz.com/blog/android-using-sqlite-database*/

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "SQLiteDatabase.db";

    // Contacts table a_name
    private static final String TABLE_NAME = "POST";

    // Contacts Table Columns names
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_POST_ID = "post_id";
    public static final String COLUMN_a_welcome = "a_welcome";
    public static final String COLUMN_a_logo = "a_logo";
    public static final String COLUMN_a_picture = "a_picture";
    public static final String COLUMN_a_address = "a_address";
    public static final String COLUMN_a_zip = "a_zip";
    public static final String COLUMN_a_town = "a_town";
    public static final String COLUMN_a_country = "a_country";

    public static final String COLUMN_a_map = "a_map";
    public static final String COLUMN_a_map_address = "a_map_address";
    public static final String COLUMN_a_map_address_lng = "a_map_address_lng";
    public static final String COLUMN_a_map_address_lat = "a_map_address_lat";

    public static final String COLUMN_a_website = "a_website";
    public static final String COLUMN_a_telephone = "a_telephone";
    public static final String COLUMN_a_facebook = "a_facebook";
    public static final String COLUMN_a_twitter = "a_twitter";

    public static final String COLUMN_l_firstname = "l_firstname";
    public static final String COLUMN_l_lastname = "l_lastname";
    public static final String COLUMN_l_address = "l_address";
    public static final String COLUMN_l_zip = "l_zip";
    public static final String COLUMN_l_town = "l_town";
    public static final String COLUMN_l_country = "l_country";
    public static final String COLUMN_l_telephone = "l_telephone";
    public static final String COLUMN_l_mobile = "l_mobile";
    public static final String COLUMN_l_email = "l_email";
    public static final String COLUMN_l_skype = "l_skype";
    public static final String COLUMN_l_facebook = "l_facebook";
    public static final String COLUMN_l_twitter = "l_twitter";
    public static final String COLUMN_l_language = "l_language";

    public static final String COLUMN_o_firstname = "o_firstname";
    public static final String COLUMN_o_lastname = "o_lastname";
    public static final String COLUMN_o_address = "o_address";
    public static final String COLUMN_o_zip = "o_zip";
    public static final String COLUMN_o_town = "o_town";
    public static final String COLUMN_o_country = "o_country";
    public static final String COLUMN_o_telephone = "o_telephone";
    public static final String COLUMN_o_mobile = "o_mobile";
    public static final String COLUMN_o_email = "o_email";
    public static final String COLUMN_o_skype = "o_skype";
    public static final String COLUMN_o_facebook = "o_facebook";
    public static final String COLUMN_o_twitter = "o_twitter";
    public static final String COLUMN_o_language = "o_language";


    public static final String COLUMN_fdb_time = "fdb_time";
    public static final String COLUMN_fdb_where = "fdb_where";
    public static final String COLUMN_fdl_time = "fdl_time";
    public static final String COLUMN_fdl_where = "fdl_where";
    public static final String COLUMN_fdd_time = "fdd_time";
    public static final String COLUMN_fdd_where = "fdd_where";
    public static final String COLUMN_trt_name = "trt_name";
    public static final String COLUMN_trt_phone = "trt_phone";
    public static final String COLUMN_trt_address = "trt_address";
    public static final String COLUMN_trt_address_address = "trt_address_address";
    public static final String COLUMN_trt_address_lat = "trt_address_address_lat";
    public static final String COLUMN_trt_address_lng = "trt_address_lng";
    public static final String COLUMN_trt_website = "trt_website";
    public static final String COLUMN_trt_email = "trt_email";
    public static final String COLUMN_trc_name = "trc_name";
    public static final String COLUMN_trc_phone = "trc_phone";
    public static final String COLUMN_trc_address = "trc_address";
    public static final String COLUMN_trc_website = "trc_website";
    public static final String COLUMN_trc_email = "trc_email";


    public static final String COLUMN_trb_name = "trb_name";
    public static final String COLUMN_trb_phone = "trb_phone";
    public static final String COLUMN_trb_address = "trb_address";
    public static final String COLUMN_trb_website = "trb_website";
    public static final String COLUMN_trb_email = "trb_email";
    public static final String COLUMN_trm_name = "trm_name";
    public static final String COLUMN_trm_phone = "trm_phone";
    public static final String COLUMN_trm_address = "trm_address";
    public static final String COLUMN_trm_website = "trm_website";
    public static final String COLUMN_trm_email = "trm_email";
    public static final String COLUMN_trp_bus = "trp_bus";
    public static final String COLUMN_trp_metro = "trp_metro";
    public static final String COLUMN_trp_train = "trp_train";
    public static final String COLUMN_trair_name = "trair_name";
    public static final String COLUMN_trair_phone = "trair_phone";
    public static final String COLUMN_trair_address = "trair_address";
    public static final String COLUMN_trair_address_address = "trair_address_address";
    public static final String COLUMN_trair_address_lat = "trair_address_lat";
    public static final String COLUMN_trair_address_lng = "trair_address_lng";
    public static final String COLUMN_trair_website = "trair_website";
    public static final String COLUMN_trair_email = "trair_website_email";
    public static final String COLUMN_moatm_address = "moatm_address";
    public static final String COLUMN_ser_checkintime = "ser_checkintime";
    public static final String COLUMN_ser_checkouttime = "ser_checkouttime";
    public static final String COLUMN_attr_repeat = "attr_repeat";
    public static final String COLUMN_attr_repeat_0_attr_name = "attr_repeat_0_attr_name";
    public static final String COLUMN_attr_repeat_0_attr_website = "attr_repeat_0_attr_website";
    public static final String COLUMN_attr_repeat_0_attr_picture = "attr_repeat_0_attr_picture";
    public static final String COLUMN_attr_repeat_0_attr_descript = "attr_repeat_0_attr_descript";
    public static final String COLUMN_attr_repeat_1_attr_name = "attr_repeat_1_attr_name";
    public static final String COLUMN_attr_repeat_1_attr_website = "attr_repeat_1_attr_website";
    public static final String COLUMN_attr_repeat_1_attr_picture = "attr_repeat_1_attr_picture";
    public static final String COLUMN_attr_repeat_1_attr_descript = "attr_repeat_1_attr_descript";
    public static final String COLUMN_ser_atm_address = "ser_atm_address";
    public static final String COLUMN_ser_atm_location = "ser_atm_location";
    public static final String COLUMN_ser_atm_location_address = "ser_atm_location_address";
    public static final String COLUMN_ser_atm_location_lat = "ser_atm_location_lat";
    public static final String COLUMN_ser_atm_location_lng = "ser_atm_location_lng";
    public static final String COLUMN_ser_wifi_pass = "ser_wifi_pass";
    public static final String COLUMN_ser_wifi_details = "ser_wifi_details";
    public static final String COLUMN_ser_park_details = "ser_park_details";
    public static final String COLUMN_ser_park_map = "ser_park_map";
    public static final String COLUMN_ser_park_map_address = "ser_park_map_address";
    public static final String COLUMN_ser_park_map_address_lat = "ser_park_map_address_lat";
    public static final String COLUMN_ser_park_map_address_lng = "ser_park_map_address_lng";
    public static final String COLUMN_ser_tv_details = "ser_tv_details";


    public static final String COLUMN_em_general = "em_general";
    public static final String COLUMN_em_fire = "em_fire";
    public static final String COLUMN_em_ambulance = "em_ambulance";
    public static final String COLUMN_em_police = "em_police";
    public static final String COLUMN_em_assistance = "em_assistance";
    public static final String COLUMN_em_docter_name = "em_docter_name";
    public static final String COLUMN_em_docter_telephone = "em_docter_telephone";
    public static final String COLUMN_em_docter_address = "em_docter_address";
    public static final String COLUMN_em_docter_address_address = "em_docter_address_address";
    public static final String COLUMN_em_docter_address_lat = "em_docter_address_lat";
    public static final String COLUMN_em_docter_address_lng = "em_docter_address_lng";
    public static final String COLUMN_em_pharmacy_name = "em_pharmacy_name";
    public static final String COLUMN_em_pharmacy_telephone = "em_pharmacy_telephone";
    public static final String COLUMN_em_pharmacy_address = "em_pharmacy_address";
    public static final String COLUMN_em_pharmacy_address_address = "em_pharmacy_address_address";
    public static final String COLUMN_em_pharmacy_address_lat = "em_pharmacy_address_lat";
    public static final String COLUMN_em_pharmacy_address_lng = "em_pharmacy_address_lng";
    public static final String COLUMN_rsb = "rsb";
    public static final String COLUMN_ent_0_ent_type = "ent_0_ent_type";
    public static final String COLUMN_ent_0_ent_name = "ent_0_ent_name";
    public static final String COLUMN_ent_0_ent_website = "ent_0_ent_website";
    public static final String COLUMN_ent_0_ent_phone = "ent_0_ent_phone";
    public static final String COLUMN_ent_0_ent_map = "ent_0_ent_map";
    public static final String COLUMN_ent_0_ent_map_address = "ent_0_ent_map_address";
    public static final String COLUMN_ent_0_ent_map_lat = "ent_0_ent_map_lat";
    public static final String COLUMN_ent_0_ent_map_lng = "ent_0_ent_map_lng";
    public static final String COLUMN_ent = "ent";
    public static final String COLUMN_rsb_0_rbs_type = "rsb_0_rbs_type";
    public static final String COLUMN_rsb_0_rbs_name = "rsb_0_rbs_name";
    public static final String COLUMN_rsb_0_rbs_website = "rsb_0_rbs_website";
    public static final String COLUMN_rsb_0_rbs_phone = "rsb_0_rbs_phone";
    public static final String COLUMN_rsb_0_rbs_map = "rsb_0_rbs_map";
    public static final String COLUMN_rsb_0_rbs_map_address = "rsb_0_rbs_map_address";
    public static final String COLUMN_rsb_0_rbs_map_lat = "rsb_0_rbs_map_lat";
    public static final String COLUMN_rsb_0_rbs_map_lng = "rsb_0_rbs_map_lng";
    public static final String COLUMN_rsb_1_rbs_type = "rsb_1_rbs_type";
    public static final String COLUMN_rsb_1_rbs_name = "rsb_1_rbs_name";
    public static final String COLUMN_rsb_1_rbs_website = "rsb_1_rbs_website";
    public static final String COLUMN_rsb_1_rbs_phone = "rsb_1_rbs_phone";
    public static final String COLUMN_rsb_1_rbs_map = "rsb_1_rbs_map";
    public static final String COLUMN_rsb_1_rbs_map_address = "rsb_1_rbs_map_address";
    public static final String COLUMN_rsb_1_rbs_map_lat = "rsb_1_rbs_map_lat";
    public static final String COLUMN_rsb_1_rbs_map_lng = "rsb_1_rbs_map_lng";
    public static final String COLUMN_rsb_2_rbs_type = "rsb_2_rbs_type";
    public static final String COLUMN_rsb_2_rbs_name = "rsb_2_rbs_name";
    public static final String COLUMN_rsb_2_rbs_website = "rsb_2_rbs_website";
    public static final String COLUMN_rsb_2_rbs_phone = "rsb_2_rbs_phone";
    public static final String COLUMN_rsb_2_rbs_map = "rsb_2_rbs_map";
    public static final String COLUMN_rsb_2_rbs_map_address = "rsb_2_rbs_map_address";
    public static final String COLUMN_rsb_2_rbs_map_lat = "rsb_2_rbs_map_lat";
    public static final String COLUMN_rsb_2_rbs_map_lng = "rsb_2_rbs_map_lng";
    public static final String COLUMN_attr_repeat_0_attr_map = "attr_repeat_0_attr_map";
    public static final String COLUMN_attr_repeat_0_attr_map_address = "attr_repeat_0_attr_map_address";
    public static final String COLUMN_attr_repeat_0_attr_map_lat = "attr_repeat_0_attr_map_lat";
    public static final String COLUMN_attr_repeat_0_attr_maplng = "attr_repeat_0_attr_map_lng";
    public static final String COLUMN_attr_repeat_1_attr_map = "attr_repeat_1_attr_map";
    public static final String COLUMN_attr_repeat_1_attr_map_address = "attr_repeat_1_attr_map_address";
    public static final String COLUMN_attr_repeat_1_attr_map_lat = "attr_repeat_1_attr_map_lat";
    public static final String COLUMN_attr_repeat_1_attr_map_lng = "attr_repeat_1_attr_map_lng";


    public static final String COLUMN_com_laun_details = "com_laun_details";
    public static final String COLUMN_com_lug_details = "com_lug_details";
    public static final String COLUMN_com_hair_details = "com_hair_details";
    public static final String COLUMN_com_ct_details = "com_ct_details";
    public static final String COLUMN_com_room_details = "com_room_details";


    public static final String COLUMN_a_logo_image = "a_logo_image";
    public static final String COLUMN_a_picture_image = "a_picture_image";


    public static final String COLUMN_attr_repeat_2_attr_name = " attr_repeat_2_attr_name";
    public static final String COLUMN_attr_repeat_2_attr_website = " attr_repeat_2_attr_website";
    public static final String COLUMN_attr_repeat_2_attr_picture = " attr_repeat_2_attr_picture";
    public static final String COLUMN_attr_repeat_2_attr_descript = " attr_repeat_2_attr_descript";
    public static final String COLUMN_attr_repeat_2_attr_map = " attr_repeat_2_attr_map";
    public static final String COLUMN_attr_repeat_2_attr_map_address = " attr_repeat_2_attr_map_address";
    public static final String COLUMN_attr_repeat_2_attr_map_lat = " attr_repeat_2_attr_map_lat";
    public static final String COLUMN_attr_repeat_2_attr_map_lng = " attr_repeat_2_attr_map_lng";
    public static final String COLUMN_attr_repeat_3_attr_name = " attr_repeat_3_attr_name";
    public static final String COLUMN_attr_repeat_3_attr_website = " attr_repeat_3_attr_website";
    public static final String COLUMN_attr_repeat_3_attr_picture = " attr_repeat_3_attr_picture";
    public static final String COLUMN_attr_repeat_3_attr_descript = " attr_repeat_3_attr_descript";
    public static final String COLUMN_attr_repeat_3_attr_map = " attr_repeat_3_attr_map";
    public static final String COLUMN_attr_repeat_3_attr_map_address = " attr_repeat_3_attr_map_address";
    public static final String COLUMN_attr_repeat_3_attr_map_lat = " attr_repeat_3_attr_map_lat";
    public static final String COLUMN_attr_repeat_3_attr_map_lng = " attr_repeat_3_attr_map_lng";
    public static final String COLUMN_attr_repeat_4_attr_name = " attr_repeat_4_attr_name";
    public static final String COLUMN_attr_repeat_4_attr_website = " attr_repeat_4_attr_website";
    public static final String COLUMN_attr_repeat_4_attr_picture = " attr_repeat_4_attr_picture";
    public static final String COLUMN_attr_repeat_4_attr_descript = " attr_repeat_4_attr_descript";
    public static final String COLUMN_attr_repeat_4_attr_map = " attr_repeat_4_attr_map";
    public static final String COLUMN_attr_repeat_4_attr_map_address = " attr_repeat_4_attr_map_address";
    public static final String COLUMN_attr_repeat_4_attr_map_lat = " attr_repeat_4_attr_map_lat";
    public static final String COLUMN_attr_repeat_4_attr_map_lng = " attr_repeat_4_attr_map_lng";
    public static final String COLUMN_ent_1_ent_type = " ent_1_ent_type";
    public static final String COLUMN_ent_1_ent_name = " ent_1_ent_name";
    public static final String COLUMN_ent_1_ent_website = " ent_1_ent_website";
    public static final String COLUMN_ent_1_ent_phone = " ent_1_ent_phone";
    public static final String COLUMN_ent_1_ent_map = " ent_1_ent_map";
    public static final String COLUMN_ent_1_ent_map_address = " ent_1_ent_map_address";
    public static final String COLUMN_ent_1_ent_map_lat = " ent_1_ent_map_lat";
    public static final String COLUMN_ent_1_ent_map_lng = " ent_1_ent_map_lng";
    public static final String COLUMN_ent_2_ent_type = " ent_2_ent_type";
    public static final String COLUMN_ent_2_ent_name = " ent_2_ent_name";
    public static final String COLUMN_ent_2_ent_website = " ent_2_ent_website";
    public static final String COLUMN_ent_2_ent_phone = " ent_2_ent_phone";
    public static final String COLUMN_ent_2_ent_map = " ent_2_ent_map";
    public static final String COLUMN_ent_2_ent_map_address = " ent_2_ent_map_address";
    public static final String COLUMN_ent_2_ent_map_lat = " ent_2_ent_map_lat";
    public static final String COLUMN_ent_2_ent_map_lng = " ent_2_ent_map_lng";
    public static final String COLUMN_ent_3_ent_type = " ent_3_ent_type";
    public static final String COLUMN_ent_3_ent_name = " ent_3_ent_name";
    public static final String COLUMN_ent_3_ent_website = " ent_3_ent_website";
    public static final String COLUMN_ent_3_ent_phone = " ent_3_ent_phone";
    public static final String COLUMN_ent_3_ent_map = " ent_3_ent_map";
    public static final String COLUMN_ent_3_ent_map_address = " ent_3_ent_map_address";
    public static final String COLUMN_ent_3_ent_map_lat = " ent_3_ent_map_lat";
    public static final String COLUMN_ent_3_ent_map_lng = " ent_3_ent_map_lng";
    public static final String COLUMN_ent_4_ent_type = " ent_4_ent_type";
    public static final String COLUMN_ent_4_ent_name = " ent_4_ent_name";
    public static final String COLUMN_ent_4_ent_website = " ent_4_ent_website";
    public static final String COLUMN_ent_4_ent_phone = " ent_4_ent_phone";
    public static final String COLUMN_ent_4_ent_map = " ent_4_ent_map";
    public static final String COLUMN_ent_4_ent_map_address = " ent_4_ent_map_address";
    public static final String COLUMN_ent_4_ent_map_lat = " ent_4_ent_map_lat";
    public static final String COLUMN_ent_4_ent_map_lng = " ent_4_ent_map_lng";
    public static final String COLUMN_ent_5_ent_type = " ent_5_ent_type";
    public static final String COLUMN_ent_5_ent_name = " ent_5_ent_name";
    public static final String COLUMN_ent_5_ent_website = " ent_5_ent_website";
    public static final String COLUMN_ent_5_ent_phone = " ent_5_ent_phone";
    public static final String COLUMN_ent_5_ent_map = " ent_5_ent_map";
    public static final String COLUMN_ent_5_ent_map_address = " ent_5_ent_map_address";
    public static final String COLUMN_ent_5_ent_map_lat = " ent_5_ent_map_lat";
    public static final String COLUMN_ent_5_ent_map_lng = " ent_5_ent_map_lng";
    public static final String COLUMN_ent_6_ent_type = " ent_6_ent_type";
    public static final String COLUMN_ent_6_ent_name = " ent_6_ent_name";
    public static final String COLUMN_ent_6_ent_website = " ent_6_ent_website";
    public static final String COLUMN_ent_6_ent_phone = " ent_6_ent_phone";
    public static final String COLUMN_ent_6_ent_map = " ent_6_ent_map";
    public static final String COLUMN_ent_6_ent_map_address = " ent_6_ent_map_address";
    public static final String COLUMN_ent_6_ent_map_lat = " ent_6_ent_map_lat";
    public static final String COLUMN_ent_6_ent_map_lng = " ent_6_ent_map_lng";
    public static final String COLUMN_ent_7_ent_type = " ent_7_ent_type";
    public static final String COLUMN_ent_7_ent_name = " ent_7_ent_name";
    public static final String COLUMN_ent_7_ent_website = " ent_7_ent_website";
    public static final String COLUMN_ent_7_ent_phone = " ent_7_ent_phone";
    public static final String COLUMN_ent_7_ent_map = " ent_7_ent_map";
    public static final String COLUMN_ent_7_ent_map_address = " ent_7_ent_map_address";
    public static final String COLUMN_ent_7_ent_map_lat = " ent_7_ent_map_lat";
    public static final String COLUMN_ent_7_ent_map_lng = " ent_7_ent_map_lng";
    public static final String COLUMN_ent_8_ent_type = " ent_8_ent_type";
    public static final String COLUMN_ent_8_ent_name = " ent_8_ent_name";
    public static final String COLUMN_ent_8_ent_website = " ent_8_ent_website";
    public static final String COLUMN_ent_8_ent_phone = " ent_8_ent_phone";
    public static final String COLUMN_ent_8_ent_map = " ent_8_ent_map";
    public static final String COLUMN_ent_8_ent_map_address = " ent_8_ent_map_address";
    public static final String COLUMN_ent_8_ent_map_lat = " ent_8_ent_map_lat";
    public static final String COLUMN_ent_8_ent_map_lng = " ent_8_ent_map_lng";
    public static final String COLUMN_rsb_3_rbs_type = " rsb_3_rbs_type";
    public static final String COLUMN_rsb_3_rbs_name = " rsb_3_rbs_name";
    public static final String COLUMN_rsb_3_rbs_website = " rsb_3_rbs_website";
    public static final String COLUMN_rsb_3_rbs_phone = " rsb_3_rbs_phone";
    public static final String COLUMN_rsb_3_rbs_map = " rsb_3_rbs_map";
    public static final String COLUMN_rsb_3_rbs_map_address = " rsb_3_rbs_map_address";
    public static final String COLUMN_rsb_3_rbs_map_lat = " rsb_3_rbs_map_lat";
    public static final String COLUMN_rsb_3_rbs_map_lng = " rsb_3_rbs_map_lng";
    public static final String COLUMN_rsb_4_rbs_type = " rsb_4_rbs_type";
    public static final String COLUMN_rsb_4_rbs_name = " rsb_4_rbs_name";
    public static final String COLUMN_rsb_4_rbs_website = " rsb_4_rbs_website";
    public static final String COLUMN_rsb_4_rbs_phone = " rsb_4_rbs_phone";
    public static final String COLUMN_rsb_4_rbs_map = " rsb_4_rbs_map";
    public static final String COLUMN_rsb_4_rbs_map_address = " rsb_4_rbs_map_address";
    public static final String COLUMN_rsb_4_rbs_map_lat = " rsb_4_rbs_map_lat";
    public static final String COLUMN_rsb_4_rbs_map_lng = " rsb_4_rbs_map_lng";
    public static final String COLUMN_rsb_5_rbs_type = " rsb_5_rbs_type";
    public static final String COLUMN_rsb_5_rbs_name = " rsb_5_rbs_name";
    public static final String COLUMN_rsb_5_rbs_website = " rsb_5_rbs_website";
    public static final String COLUMN_rsb_5_rbs_phone = " rsb_5_rbs_phone";
    public static final String COLUMN_rsb_5_rbs_map = " rsb_5_rbs_map";
    public static final String COLUMN_rsb_5_rbs_map_address = " rsb_5_rbs_map_address";
    public static final String COLUMN_rsb_5_rbs_map_lat = " rsb_5_rbs_map_lat";
    public static final String COLUMN_rsb_5_rbs_map_lng = " rsb_5_rbs_map_lng";
    public static final String COLUMN_rsb_6_rbs_type = " rsb_6_rbs_type";
    public static final String COLUMN_rsb_6_rbs_name = " rsb_6_rbs_name";
    public static final String COLUMN_rsb_6_rbs_website = " rsb_6_rbs_website";
    public static final String COLUMN_rsb_6_rbs_phone = " rsb_6_rbs_phone";
    public static final String COLUMN_rsb_6_rbs_map = " rsb_6_rbs_map";
    public static final String COLUMN_rsb_6_rbs_map_address = " rsb_6_rbs_map_address";
    public static final String COLUMN_rsb_6_rbs_map_lat = " rsb_6_rbs_map_lat";
    public static final String COLUMN_rsb_6_rbs_map_lng = " rsb_6_rbs_map_lng";
    public static final String COLUMN_rsb_7_rbs_type = " rsb_7_rbs_type";
    public static final String COLUMN_rsb_7_rbs_name = " rsb_7_rbs_name";
    public static final String COLUMN_rsb_7_rbs_website = " rsb_7_rbs_website";
    public static final String COLUMN_rsb_7_rbs_phone = " rsb_7_rbs_phone";
    public static final String COLUMN_rsb_7_rbs_map = " rsb_7_rbs_map";
    public static final String COLUMN_rsb_7_rbs_map_address = " rsb_7_rbs_map_address";
    public static final String COLUMN_rsb_7_rbs_map_lat = " rsb_7_rbs_map_lat";
    public static final String COLUMN_rsb_7_rbs_map_lng = " rsb_7_rbs_map_lng";
    public static final String COLUMN_rsb_8_rbs_type = " rsb_8_rbs_type";
    public static final String COLUMN_rsb_8_rbs_name = " rsb_8_rbs_name";
    public static final String COLUMN_rsb_8_rbs_website = " rsb_8_rbs_website";
    public static final String COLUMN_rsb_8_rbs_phone = " rsb_8_rbs_phone";
    public static final String COLUMN_rsb_8_rbs_map = " rsb_8_rbs_map";
    public static final String COLUMN_rsb_8_rbs_map_address = " rsb_8_rbs_map_address";
    public static final String COLUMN_rsb_8_rbs_map_lat = " rsb_8_rbs_map_lat";
    public static final String COLUMN_rsb_8_rbs_map_lng = " rsb_8_rbs_map_lng";
    public static final String COLUMN_name = " a_name";
    public static final String COLUMN_attr_repeat_0_attr_picture_image = " attr_repeat_0_attr_picture_image ";
    public static final String COLUMN_attr_repeat_1_attr_picture_image = " attr_repeat_1_attr_picture_image ";
    public static final String COLUMN_attr_repeat_2_attr_picture_image = " attr_repeat_2_attr_picture_image ";
    public static final String COLUMN_attr_repeat_3_attr_picture_image = " attr_repeat_3_attr_picture_image ";
    public static final String COLUMN_attr_repeat_4_attr_picture_image = " attr_repeat_4_attr_picture_image ";

    public static final String COLUMN_trc_address_address = " trc_address_address ";
    public static final String COLUMN_trc_address_address_lat = " trc_address_address_lat ";
    public static final String COLUMN_trc_address_address_lng = " trc_address_address_lng ";

    public static final String COLUMN_trb_address_address = " trb_address_address ";
    public static final String COLUMN_trb_address_address_lat = " trb_address_address_lat ";
    public static final String COLUMN_trb_address_address_lng = " trb_address_address_lng ";

    public static final String COLUMN_trm_address_address = " trm_address_address ";
    public static final String COLUMN_trm_address_address_lat = " trm_address_address_lat ";
    public static final String COLUMN_trm_address_address_lng = " trm_address_address_lng ";


    private SQLiteDatabase database;


    /*done*/
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }
    /*done*/


    /*done*/
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME
                + " ( "
                + COLUMN_ID + " INTEGER PRIMARY KEY ,"
                + COLUMN_POST_ID + " TEXT,"
                + COLUMN_a_welcome + " TEXT,"
                + COLUMN_a_logo + " TEXT,"
                + COLUMN_a_picture + " TEXT,"
                + COLUMN_a_address + " TEXT,"
                + COLUMN_a_zip + " TEXT,"
                + COLUMN_a_town + " TEXT,"
                + COLUMN_a_country + " TEXT,"
                + COLUMN_a_map + " TEXT,"
                + COLUMN_a_map_address + " TEXT,"
                + COLUMN_a_map_address_lng + " TEXT,"
                + COLUMN_a_map_address_lat + " TEXT,"
                + COLUMN_a_website + " TEXT,"
                + COLUMN_a_telephone + " TEXT,"
                + COLUMN_a_facebook + " TEXT,"
                + COLUMN_a_twitter + " TEXT,"

                + COLUMN_l_firstname + " TEXT,"
                + COLUMN_l_lastname + " TEXT,"
                + COLUMN_l_address + " TEXT,"
                + COLUMN_l_zip + " TEXT,"
                + COLUMN_l_town + " TEXT,"
                + COLUMN_l_country + " TEXT,"
                + COLUMN_l_telephone + " TEXT,"
                + COLUMN_l_mobile + " TEXT,"
                + COLUMN_l_email + " TEXT,"
                + COLUMN_l_skype + " TEXT,"
                + COLUMN_l_facebook + " TEXT,"
                + COLUMN_l_twitter + " TEXT,"
                + COLUMN_l_language + " TEXT,"

                + COLUMN_o_firstname + " TEXT,"
                + COLUMN_o_lastname + " TEXT,"
                + COLUMN_o_address + " TEXT,"
                + COLUMN_o_zip + " TEXT,"
                + COLUMN_o_town + " TEXT,"
                + COLUMN_o_country + " TEXT,"
                + COLUMN_o_telephone + " TEXT,"
                + COLUMN_o_mobile + " TEXT,"
                + COLUMN_o_email + " TEXT,"
                + COLUMN_o_skype + " TEXT,"
                + COLUMN_o_facebook + " TEXT,"
                + COLUMN_o_twitter + " TEXT,"
                + COLUMN_o_language + " TEXT,"

                + COLUMN_fdb_time + " TEXT,"
                + COLUMN_fdb_where + " TEXT,"
                + COLUMN_fdl_time + " TEXT,"
                + COLUMN_fdl_where + " TEXT,"
                + COLUMN_fdd_time + " TEXT,"
                + COLUMN_fdd_where + " TEXT,"
                + COLUMN_trt_name + " TEXT,"
                + COLUMN_trt_phone + " TEXT,"
                + COLUMN_trt_address + " TEXT,"
                + COLUMN_trt_address_address + " TEXT,"
                + COLUMN_trt_address_lat + " TEXT,"
                + COLUMN_trt_address_lng + " TEXT,"
                + COLUMN_trt_website + " TEXT,"
                + COLUMN_trt_email + " TEXT,"
                + COLUMN_trc_name + " TEXT,"
                + COLUMN_trc_phone + " TEXT,"
                + COLUMN_trc_address + " TEXT,"
                + COLUMN_trc_website + " TEXT,"
                + COLUMN_trc_email + " TEXT,"

                + COLUMN_trb_name + " TEXT,"
                + COLUMN_trb_phone + " TEXT,"
                + COLUMN_trb_address + " TEXT,"
                + COLUMN_trb_website + " TEXT,"
                + COLUMN_trb_email + " TEXT,"
                + COLUMN_trm_name + " TEXT,"
                + COLUMN_trm_phone + " TEXT,"
                + COLUMN_trm_address + " TEXT,"
                + COLUMN_trm_website + " TEXT,"
                + COLUMN_trm_email + " TEXT,"
                + COLUMN_trp_bus + " TEXT,"
                + COLUMN_trp_metro + " TEXT,"
                + COLUMN_trp_train + " TEXT,"
                + COLUMN_trair_name + " TEXT,"
                + COLUMN_trair_phone + " TEXT,"
                + COLUMN_trair_address + " TEXT,"
                + COLUMN_trair_address_address + " TEXT,"
                + COLUMN_trair_address_lat + " TEXT,"
                + COLUMN_trair_address_lng + " TEXT,"
                + COLUMN_trair_website + " TEXT,"
                + COLUMN_trair_email + " TEXT,"
                + COLUMN_moatm_address + " TEXT,"
                + COLUMN_ser_checkintime + " TEXT,"
                + COLUMN_ser_checkouttime + " TEXT,"
                + COLUMN_attr_repeat + " TEXT,"
                + COLUMN_attr_repeat_0_attr_name + " TEXT,"
                + COLUMN_attr_repeat_0_attr_website + " TEXT,"
                + COLUMN_attr_repeat_0_attr_picture + " TEXT,"
                + COLUMN_attr_repeat_0_attr_descript + " TEXT,"
                + COLUMN_attr_repeat_1_attr_name + " TEXT,"
                + COLUMN_attr_repeat_1_attr_website + " TEXT,"
                + COLUMN_attr_repeat_1_attr_picture + " TEXT,"
                + COLUMN_attr_repeat_1_attr_descript + " TEXT,"
                + COLUMN_ser_atm_address + " TEXT,"
                + COLUMN_ser_atm_location + " TEXT,"
                + COLUMN_ser_atm_location_address + " TEXT,"
                + COLUMN_ser_atm_location_lat + " TEXT,"
                + COLUMN_ser_atm_location_lng + " TEXT,"
                + COLUMN_ser_wifi_pass + " TEXT,"
                + COLUMN_ser_wifi_details + " TEXT,"
                + COLUMN_ser_park_details + " TEXT,"
                + COLUMN_ser_park_map + " TEXT,"
                + COLUMN_ser_park_map_address + " TEXT,"
                + COLUMN_ser_park_map_address_lat + " TEXT,"
                + COLUMN_ser_park_map_address_lng + " TEXT,"
                + COLUMN_ser_tv_details + " TEXT,"


                + COLUMN_em_general + " TEXT,"
                + COLUMN_em_fire + " TEXT,"
                + COLUMN_em_ambulance + " TEXT,"
                + COLUMN_em_police + " TEXT,"
                + COLUMN_em_assistance + " TEXT,"
                + COLUMN_em_docter_name + " TEXT,"
                + COLUMN_em_docter_telephone + " TEXT,"
                + COLUMN_em_docter_address + " TEXT,"
                + COLUMN_em_docter_address_address + " TEXT,"
                + COLUMN_em_docter_address_lat + " TEXT,"
                + COLUMN_em_docter_address_lng + " TEXT,"
                + COLUMN_em_pharmacy_name + " TEXT,"
                + COLUMN_em_pharmacy_telephone + " TEXT,"
                + COLUMN_em_pharmacy_address + " TEXT,"
                + COLUMN_em_pharmacy_address_address + " TEXT,"
                + COLUMN_em_pharmacy_address_lat + " TEXT,"
                + COLUMN_em_pharmacy_address_lng + " TEXT,"
                + COLUMN_rsb + " TEXT,"
                + COLUMN_ent_0_ent_type + " TEXT,"
                + COLUMN_ent_0_ent_name + " TEXT,"
                + COLUMN_ent_0_ent_website + " TEXT,"
                + COLUMN_ent_0_ent_phone + " TEXT,"
                + COLUMN_ent_0_ent_map + " TEXT,"
                + COLUMN_ent_0_ent_map_address + " TEXT,"
                + COLUMN_ent_0_ent_map_lat + " TEXT,"
                + COLUMN_ent_0_ent_map_lng + " TEXT,"
                + COLUMN_ent + " TEXT,"
                + COLUMN_rsb_0_rbs_type + " TEXT,"
                + COLUMN_rsb_0_rbs_name + " TEXT,"
                + COLUMN_rsb_0_rbs_website + " TEXT,"
                + COLUMN_rsb_0_rbs_phone + " TEXT,"
                + COLUMN_rsb_0_rbs_map + " TEXT,"
                + COLUMN_rsb_0_rbs_map_address + " TEXT,"
                + COLUMN_rsb_0_rbs_map_lat + " TEXT,"
                + COLUMN_rsb_0_rbs_map_lng + " TEXT,"
                + COLUMN_rsb_1_rbs_type + " TEXT,"
                + COLUMN_rsb_1_rbs_name + " TEXT,"
                + COLUMN_rsb_1_rbs_website + " TEXT,"
                + COLUMN_rsb_1_rbs_phone + " TEXT,"
                + COLUMN_rsb_1_rbs_map + " TEXT,"
                + COLUMN_rsb_1_rbs_map_address + " TEXT,"
                + COLUMN_rsb_1_rbs_map_lat + " TEXT,"
                + COLUMN_rsb_1_rbs_map_lng + " TEXT,"
                + COLUMN_rsb_2_rbs_type + " TEXT,"
                + COLUMN_rsb_2_rbs_name + " TEXT,"
                + COLUMN_rsb_2_rbs_website + " TEXT,"
                + COLUMN_rsb_2_rbs_phone + " TEXT,"
                + COLUMN_rsb_2_rbs_map + " TEXT,"
                + COLUMN_rsb_2_rbs_map_address + " TEXT,"
                + COLUMN_rsb_2_rbs_map_lat + " TEXT,"
                + COLUMN_rsb_2_rbs_map_lng + " TEXT,"
                + COLUMN_attr_repeat_0_attr_map + " TEXT,"
                + COLUMN_attr_repeat_0_attr_map_address + " TEXT,"
                + COLUMN_attr_repeat_0_attr_map_lat + " TEXT,"
                + COLUMN_attr_repeat_0_attr_maplng + " TEXT,"
                + COLUMN_attr_repeat_1_attr_map + " TEXT,"
                + COLUMN_attr_repeat_1_attr_map_address + " TEXT,"
                + COLUMN_attr_repeat_1_attr_map_lat + " TEXT,"
                + COLUMN_attr_repeat_1_attr_map_lng + " TEXT,"


                + COLUMN_com_laun_details + " TEXT,"
                + COLUMN_com_lug_details + " TEXT,"
                + COLUMN_com_hair_details + " TEXT,"
                + COLUMN_com_ct_details + " TEXT,"
                + COLUMN_com_room_details + " TEXT,"


                + COLUMN_a_logo_image + " TEXT,"
                + COLUMN_a_picture_image + " TEXT,"


                + COLUMN_attr_repeat_2_attr_name + " TEXT,"
                + COLUMN_attr_repeat_2_attr_website + " TEXT,"
                + COLUMN_attr_repeat_2_attr_picture + " TEXT,"
                + COLUMN_attr_repeat_2_attr_descript + " TEXT,"
                + COLUMN_attr_repeat_2_attr_map + " TEXT,"
                + COLUMN_attr_repeat_2_attr_map_address + " TEXT,"
                + COLUMN_attr_repeat_2_attr_map_lat + " TEXT,"
                + COLUMN_attr_repeat_2_attr_map_lng + " TEXT,"
                + COLUMN_attr_repeat_3_attr_name + " TEXT,"
                + COLUMN_attr_repeat_3_attr_website + " TEXT,"
                + COLUMN_attr_repeat_3_attr_picture + " TEXT,"
                + COLUMN_attr_repeat_3_attr_descript + " TEXT,"
                + COLUMN_attr_repeat_3_attr_map + " TEXT,"
                + COLUMN_attr_repeat_3_attr_map_address + " TEXT,"
                + COLUMN_attr_repeat_3_attr_map_lat + " TEXT,"
                + COLUMN_attr_repeat_3_attr_map_lng + " TEXT,"
                + COLUMN_attr_repeat_4_attr_name + " TEXT,"
                + COLUMN_attr_repeat_4_attr_website + " TEXT,"
                + COLUMN_attr_repeat_4_attr_picture + " TEXT,"
                + COLUMN_attr_repeat_4_attr_descript + " TEXT,"
                + COLUMN_attr_repeat_4_attr_map + " TEXT,"
                + COLUMN_attr_repeat_4_attr_map_address + " TEXT,"
                + COLUMN_attr_repeat_4_attr_map_lat + " TEXT,"
                + COLUMN_attr_repeat_4_attr_map_lng + " TEXT,"
                + COLUMN_ent_1_ent_type + " TEXT,"
                + COLUMN_ent_1_ent_name + " TEXT,"
                + COLUMN_ent_1_ent_website + " TEXT,"
                + COLUMN_ent_1_ent_phone + " TEXT,"
                + COLUMN_ent_1_ent_map + " TEXT,"
                + COLUMN_ent_1_ent_map_address + " TEXT,"
                + COLUMN_ent_1_ent_map_lat + " TEXT,"
                + COLUMN_ent_1_ent_map_lng + " TEXT,"
                + COLUMN_ent_2_ent_type + " TEXT,"
                + COLUMN_ent_2_ent_name + " TEXT,"
                + COLUMN_ent_2_ent_website + " TEXT,"
                + COLUMN_ent_2_ent_phone + " TEXT,"
                + COLUMN_ent_2_ent_map + " TEXT,"
                + COLUMN_ent_2_ent_map_address + " TEXT,"
                + COLUMN_ent_2_ent_map_lat + " TEXT,"
                + COLUMN_ent_2_ent_map_lng + " TEXT,"
                + COLUMN_ent_3_ent_type + " TEXT,"
                + COLUMN_ent_3_ent_name + " TEXT,"
                + COLUMN_ent_3_ent_website + " TEXT,"
                + COLUMN_ent_3_ent_phone + " TEXT,"
                + COLUMN_ent_3_ent_map + " TEXT,"
                + COLUMN_ent_3_ent_map_address + " TEXT,"
                + COLUMN_ent_3_ent_map_lat + " TEXT,"
                + COLUMN_ent_3_ent_map_lng + " TEXT,"
                + COLUMN_ent_4_ent_type + " TEXT,"
                + COLUMN_ent_4_ent_name + " TEXT,"
                + COLUMN_ent_4_ent_website + " TEXT,"
                + COLUMN_ent_4_ent_phone + " TEXT,"
                + COLUMN_ent_4_ent_map + " TEXT,"
                + COLUMN_ent_4_ent_map_address + " TEXT,"
                + COLUMN_ent_4_ent_map_lat + " TEXT,"
                + COLUMN_ent_4_ent_map_lng + " TEXT,"
                + COLUMN_ent_5_ent_type + " TEXT,"
                + COLUMN_ent_5_ent_name + " TEXT,"
                + COLUMN_ent_5_ent_website + " TEXT,"
                + COLUMN_ent_5_ent_phone + " TEXT,"
                + COLUMN_ent_5_ent_map + " TEXT,"
                + COLUMN_ent_5_ent_map_address + " TEXT,"
                + COLUMN_ent_5_ent_map_lat + " TEXT,"
                + COLUMN_ent_5_ent_map_lng + " TEXT,"
                + COLUMN_ent_6_ent_type + " TEXT,"
                + COLUMN_ent_6_ent_name + " TEXT,"
                + COLUMN_ent_6_ent_website + " TEXT,"
                + COLUMN_ent_6_ent_phone + " TEXT,"
                + COLUMN_ent_6_ent_map + " TEXT,"
                + COLUMN_ent_6_ent_map_address + " TEXT,"
                + COLUMN_ent_6_ent_map_lat + " TEXT,"
                + COLUMN_ent_6_ent_map_lng + " TEXT,"
                + COLUMN_ent_7_ent_type + " TEXT,"
                + COLUMN_ent_7_ent_name + " TEXT,"
                + COLUMN_ent_7_ent_website + " TEXT,"
                + COLUMN_ent_7_ent_phone + " TEXT,"
                + COLUMN_ent_7_ent_map + " TEXT,"
                + COLUMN_ent_7_ent_map_address + " TEXT,"
                + COLUMN_ent_7_ent_map_lat + " TEXT,"
                + COLUMN_ent_7_ent_map_lng + " TEXT,"
                + COLUMN_ent_8_ent_type + " TEXT,"
                + COLUMN_ent_8_ent_name + " TEXT,"
                + COLUMN_ent_8_ent_website + " TEXT,"
                + COLUMN_ent_8_ent_phone + " TEXT,"
                + COLUMN_ent_8_ent_map + " TEXT,"
                + COLUMN_ent_8_ent_map_address + " TEXT,"
                + COLUMN_ent_8_ent_map_lat + " TEXT,"
                + COLUMN_ent_8_ent_map_lng + " TEXT,"
                + COLUMN_rsb_3_rbs_type + " TEXT,"
                + COLUMN_rsb_3_rbs_name + " TEXT,"
                + COLUMN_rsb_3_rbs_website + " TEXT,"
                + COLUMN_rsb_3_rbs_phone + " TEXT,"
                + COLUMN_rsb_3_rbs_map + " TEXT,"
                + COLUMN_rsb_3_rbs_map_address + " TEXT,"
                + COLUMN_rsb_3_rbs_map_lat + " TEXT,"
                + COLUMN_rsb_3_rbs_map_lng + " TEXT,"
                + COLUMN_rsb_4_rbs_type + " TEXT,"
                + COLUMN_rsb_4_rbs_name + " TEXT,"
                + COLUMN_rsb_4_rbs_website + " TEXT,"
                + COLUMN_rsb_4_rbs_phone + " TEXT,"
                + COLUMN_rsb_4_rbs_map + " TEXT,"
                + COLUMN_rsb_4_rbs_map_address + " TEXT,"
                + COLUMN_rsb_4_rbs_map_lat + " TEXT,"
                + COLUMN_rsb_4_rbs_map_lng + " TEXT,"
                + COLUMN_rsb_5_rbs_type + " TEXT,"
                + COLUMN_rsb_5_rbs_name + " TEXT,"
                + COLUMN_rsb_5_rbs_website + " TEXT,"
                + COLUMN_rsb_5_rbs_phone + " TEXT,"
                + COLUMN_rsb_5_rbs_map + " TEXT,"
                + COLUMN_rsb_5_rbs_map_address + " TEXT,"
                + COLUMN_rsb_5_rbs_map_lat + " TEXT,"
                + COLUMN_rsb_5_rbs_map_lng + " TEXT,"
                + COLUMN_rsb_6_rbs_type + " TEXT,"
                + COLUMN_rsb_6_rbs_name + " TEXT,"
                + COLUMN_rsb_6_rbs_website + " TEXT,"
                + COLUMN_rsb_6_rbs_phone + " TEXT,"
                + COLUMN_rsb_6_rbs_map + " TEXT,"
                + COLUMN_rsb_6_rbs_map_address + " TEXT,"
                + COLUMN_rsb_6_rbs_map_lat + " TEXT,"
                + COLUMN_rsb_6_rbs_map_lng + " TEXT,"
                + COLUMN_rsb_7_rbs_type + " TEXT,"
                + COLUMN_rsb_7_rbs_name + " TEXT,"
                + COLUMN_rsb_7_rbs_website + " TEXT,"
                + COLUMN_rsb_7_rbs_phone + " TEXT,"
                + COLUMN_rsb_7_rbs_map + " TEXT,"
                + COLUMN_rsb_7_rbs_map_address + " TEXT,"
                + COLUMN_rsb_7_rbs_map_lat + " TEXT,"
                + COLUMN_rsb_7_rbs_map_lng + " TEXT,"
                + COLUMN_rsb_8_rbs_type + " TEXT,"
                + COLUMN_rsb_8_rbs_name + " TEXT,"
                + COLUMN_rsb_8_rbs_website + " TEXT,"
                + COLUMN_rsb_8_rbs_phone + " TEXT,"
                + COLUMN_rsb_8_rbs_map + " TEXT,"
                + COLUMN_rsb_8_rbs_map_address + " TEXT,"
                + COLUMN_rsb_8_rbs_map_lat + " TEXT,"
                + COLUMN_rsb_8_rbs_map_lng + " TEXT,"
                + COLUMN_name + " TEXT,"

                + COLUMN_attr_repeat_0_attr_picture_image + " TEXT,"
                + COLUMN_attr_repeat_1_attr_picture_image + " TEXT,"
                + COLUMN_attr_repeat_2_attr_picture_image + " TEXT,"
                + COLUMN_attr_repeat_3_attr_picture_image + " TEXT,"
                + COLUMN_attr_repeat_4_attr_picture_image + " TEXT,"

                + COLUMN_trc_address_address + " TEXT,"
                + COLUMN_trc_address_address_lat + " TEXT,"
                + COLUMN_trc_address_address_lng + " TEXT,"
                + COLUMN_trb_address_address + " TEXT,"
                + COLUMN_trb_address_address_lat + " TEXT,"
                + COLUMN_trb_address_address_lng + " TEXT,"
                + COLUMN_trm_address_address + " TEXT,"
                + COLUMN_trm_address_address_lat + " TEXT,"
                + COLUMN_trm_address_address_lng + " TEXT)");


    }
    /*done*/


    /*done*/
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }
    /*done*/


    /*done*/

    /***
     * All CRUD(Create, Read, Update, Delete) Operations
     */
    // Adding new contact
    public void Add_New_Contact(Contact contact) {
        database = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_POST_ID, contact.getPOST_ID());
        values.put(COLUMN_a_welcome, contact.geta_welcome());
        values.put(COLUMN_a_logo, contact.geta_logo());
        values.put(COLUMN_a_picture, contact.geta_picture());
        values.put(COLUMN_a_address, contact.geta_address());
        values.put(COLUMN_a_zip, contact.geta_zip());
        values.put(COLUMN_a_town, contact.geta_town());
        values.put(COLUMN_a_country, contact.geta_country());
        values.put(COLUMN_a_map, contact.geta_map());
        values.put(COLUMN_a_map_address, contact.geta_map_address());
        values.put(COLUMN_a_map_address_lng, contact.geta_map_address_lng());
        values.put(COLUMN_a_map_address_lat, contact.geta_map_address_lat());
        values.put(COLUMN_a_website, contact.geta_website());
        values.put(COLUMN_a_telephone, contact.geta_telephone());
        values.put(COLUMN_a_facebook, contact.geta_facebook());
        values.put(COLUMN_a_twitter, contact.geta_twitter());

        values.put(COLUMN_l_firstname, contact.getl_firstname());
        values.put(COLUMN_l_lastname, contact.getl_lastname());
        values.put(COLUMN_l_address, contact.getl_address());
        values.put(COLUMN_l_zip, contact.getl_zip());
        values.put(COLUMN_l_town, contact.getl_town());
        values.put(COLUMN_l_country, contact.getl_country());
        values.put(COLUMN_l_telephone, contact.getl_telephone());
        values.put(COLUMN_l_mobile, contact.getl_mobile());
        values.put(COLUMN_l_email, contact.getl_email());
        values.put(COLUMN_l_skype, contact.getl_skype());
        values.put(COLUMN_l_facebook, contact.getl_facebook());
        values.put(COLUMN_l_twitter, contact.getl_twitter());
        values.put(COLUMN_l_language, contact.getl_language());

        values.put(COLUMN_o_firstname, contact.geto_firstname());
        values.put(COLUMN_o_lastname, contact.geto_lastname());
        values.put(COLUMN_o_address, contact.geto_address());
        values.put(COLUMN_o_zip, contact.geto_zip());
        values.put(COLUMN_o_town, contact.geto_town());
        values.put(COLUMN_o_country, contact.geto_country());
        values.put(COLUMN_o_telephone, contact.geto_telephone());
        values.put(COLUMN_o_mobile, contact.geto_mobile());
        values.put(COLUMN_o_email, contact.geto_email());
        values.put(COLUMN_o_skype, contact.geto_skype());
        values.put(COLUMN_o_facebook, contact.geto_facebook());
        values.put(COLUMN_o_twitter, contact.geto_twitter());
        values.put(COLUMN_o_language, contact.geto_language());

        values.put(COLUMN_fdb_time, contact.getfdb_time());
        values.put(COLUMN_fdb_where, contact.getfdb_where());
        values.put(COLUMN_fdl_time, contact.getfdl_time());
        values.put(COLUMN_fdl_where, contact.getfdl_where());
        values.put(COLUMN_fdd_time, contact.getfdd_time());
        values.put(COLUMN_fdd_where, contact.getfdd_where());
        values.put(COLUMN_trt_name, contact.gettrt_name());
        values.put(COLUMN_trt_phone, contact.gettrt_phone());
        values.put(COLUMN_trt_address, contact.gettrt_address());
        values.put(COLUMN_trt_address_address, contact.gettrt_address_address());
        values.put(COLUMN_trt_address_lat, contact.gettrt_address_lat());
        values.put(COLUMN_trt_address_lng, contact.gettrt_address_lng());
        values.put(COLUMN_trt_website, contact.gettrt_website());
        values.put(COLUMN_trt_email, contact.gettrt_email());
        values.put(COLUMN_trc_name, contact.gettrc_name());
        values.put(COLUMN_trc_phone, contact.gettrc_phone());
        values.put(COLUMN_trc_address, contact.gettrc_address());
        values.put(COLUMN_trc_website, contact.gettrc_website());
        values.put(COLUMN_trc_email, contact.gettrc_email());

        values.put(COLUMN_trb_name, contact.gettrb_name());
        values.put(COLUMN_trb_phone, contact.gettrb_phone());
        values.put(COLUMN_trb_address, contact.gettrb_address());
        values.put(COLUMN_trb_website, contact.gettrb_website());
        values.put(COLUMN_trb_email, contact.gettrb_email());
        values.put(COLUMN_trm_name, contact.gettrm_name());
        values.put(COLUMN_trm_phone, contact.gettrm_phone());
        values.put(COLUMN_trm_address, contact.gettrm_address());
        values.put(COLUMN_trm_website, contact.gettrm_website());
        values.put(COLUMN_trm_email, contact.gettrm_email());
        values.put(COLUMN_trp_bus, contact.gettrp_bus());
        values.put(COLUMN_trp_metro, contact.gettrp_metro());
        values.put(COLUMN_trp_train, contact.gettrp_train());
        values.put(COLUMN_trair_name, contact.gettrair_name());
        values.put(COLUMN_trair_phone, contact.gettrair_phone());
        values.put(COLUMN_trair_address, contact.gettrair_address());
        values.put(COLUMN_trair_address_address, contact.gettrair_address_address());
        values.put(COLUMN_trair_address_lat, contact.gettrair_address_lat());
        values.put(COLUMN_trair_address_lng, contact.gettrair_address_lng());
        values.put(COLUMN_trair_website, contact.gettrair_website());
        values.put(COLUMN_trair_email, contact.gettrair_email());
        values.put(COLUMN_moatm_address, contact.getmoatm_address());
        values.put(COLUMN_ser_checkintime, contact.getser_checkintime());
        values.put(COLUMN_ser_checkouttime, contact.getser_checkouttime());
        values.put(COLUMN_attr_repeat, contact.getattr_repeat());
        values.put(COLUMN_attr_repeat_0_attr_name, contact.getattr_repeat_0_attr_name());
        values.put(COLUMN_attr_repeat_0_attr_website, contact.getattr_repeat_0_attr_website());
        values.put(COLUMN_attr_repeat_0_attr_picture, contact.getattr_repeat_0_attr_picture());
        values.put(COLUMN_attr_repeat_0_attr_descript, contact.getattr_repeat_0_attr_descript());
        values.put(COLUMN_attr_repeat_1_attr_name, contact.getattr_repeat_1_attr_name());
        values.put(COLUMN_attr_repeat_1_attr_website, contact.getattr_repeat_1_attr_website());
        values.put(COLUMN_attr_repeat_1_attr_picture, contact.getattr_repeat_1_attr_picture());
        values.put(COLUMN_attr_repeat_1_attr_descript, contact.getattr_repeat_1_attr_descript());
        values.put(COLUMN_ser_atm_address, contact.getser_atm_address());
        values.put(COLUMN_ser_atm_location, contact.getser_atm_location());
        values.put(COLUMN_ser_atm_location_address, contact.getser_atm_location_address());
        values.put(COLUMN_ser_atm_location_lat, contact.getser_atm_location_lat());
        values.put(COLUMN_ser_atm_location_lng, contact.getser_atm_location_lng());
        values.put(COLUMN_ser_wifi_pass, contact.getser_wifi_pass());
        values.put(COLUMN_ser_wifi_details, contact.getser_wifi_details());
        values.put(COLUMN_ser_park_details, contact.getser_park_details());
        values.put(COLUMN_ser_park_map, contact.getser_park_map());
        values.put(COLUMN_ser_park_map_address, contact.getser_park_map_address());
        values.put(COLUMN_ser_park_map_address_lat, contact.getser_park_map_address_lat());
        values.put(COLUMN_ser_park_map_address_lng, contact.getser_park_map_address_lng());
        values.put(COLUMN_ser_tv_details, contact.getser_tv_details());

        values.put(COLUMN_em_general, contact.getem_general());
        values.put(COLUMN_em_fire, contact.getem_fire());
        values.put(COLUMN_em_ambulance, contact.getem_ambulance());
        values.put(COLUMN_em_police, contact.getem_police());
        values.put(COLUMN_em_assistance, contact.getem_assistance());
        values.put(COLUMN_em_docter_name, contact.getem_docter_name());
        values.put(COLUMN_em_docter_telephone, contact.getem_docter_telephone());
        values.put(COLUMN_em_docter_address, contact.getem_docter_address());
        values.put(COLUMN_em_docter_address_address, contact.getem_docter_address_address());
        values.put(COLUMN_em_docter_address_lat, contact.getem_docter_address_lat());
        values.put(COLUMN_em_docter_address_lng, contact.getem_docter_address_lng());
        values.put(COLUMN_em_pharmacy_name, contact.getem_pharmacy_name());
        values.put(COLUMN_em_pharmacy_telephone, contact.getem_pharmacy_telephone());
        values.put(COLUMN_em_pharmacy_address, contact.getem_pharmacy_address());
        values.put(COLUMN_em_pharmacy_address_address, contact.getem_pharmacy_address_address());
        values.put(COLUMN_em_pharmacy_address_lat, contact.getem_pharmacy_address_lat());
        values.put(COLUMN_em_pharmacy_address_lng, contact.getem_pharmacy_address_lng());
        values.put(COLUMN_rsb, contact.getrsb());
        values.put(COLUMN_ent_0_ent_type, contact.getent_0_ent_type());
        values.put(COLUMN_ent_0_ent_name, contact.getent_0_ent_name());
        values.put(COLUMN_ent_0_ent_website, contact.getent_0_ent_website());
        values.put(COLUMN_ent_0_ent_phone, contact.getent_0_ent_phone());
        values.put(COLUMN_ent_0_ent_map, contact.getent_0_ent_map());
        values.put(COLUMN_ent_0_ent_map_address, contact.getent_0_ent_map_address());
        values.put(COLUMN_ent_0_ent_map_lat, contact.getent_0_ent_map_lat());
        values.put(COLUMN_ent_0_ent_map_lng, contact.getent_0_ent_map_lng());
        values.put(COLUMN_ent, contact.getent());
        values.put(COLUMN_rsb_0_rbs_type, contact.getrsb_0_rbs_type());
        values.put(COLUMN_rsb_0_rbs_name, contact.getrsb_0_rbs_name());
        values.put(COLUMN_rsb_0_rbs_website, contact.getrsb_0_rbs_website());
        values.put(COLUMN_rsb_0_rbs_phone, contact.getrsb_0_rbs_phone());
        values.put(COLUMN_rsb_0_rbs_map, contact.getrsb_0_rbs_map());
        values.put(COLUMN_rsb_0_rbs_map_address, contact.getrsb_0_rbs_map_address());
        values.put(COLUMN_rsb_0_rbs_map_lat, contact.getrsb_0_rbs_map_lat());
        values.put(COLUMN_rsb_0_rbs_map_lng, contact.getrsb_0_rbs_map_lng());
        values.put(COLUMN_rsb_1_rbs_type, contact.getrsb_1_rbs_type());
        values.put(COLUMN_rsb_1_rbs_name, contact.getrsb_1_rbs_name());
        values.put(COLUMN_rsb_1_rbs_website, contact.getrsb_1_rbs_website());
        values.put(COLUMN_rsb_1_rbs_phone, contact.getrsb_1_rbs_phone());
        values.put(COLUMN_rsb_1_rbs_map, contact.getrsb_1_rbs_map());
        values.put(COLUMN_rsb_1_rbs_map_address, contact.getrsb_1_rbs_map_address());
        values.put(COLUMN_rsb_1_rbs_map_lat, contact.getrsb_1_rbs_map_lat());
        values.put(COLUMN_rsb_1_rbs_map_lng, contact.getrsb_1_rbs_map_lng());
        values.put(COLUMN_rsb_2_rbs_type, contact.getrsb_2_rbs_type());
        values.put(COLUMN_rsb_2_rbs_name, contact.getrsb_2_rbs_name());
        values.put(COLUMN_rsb_2_rbs_website, contact.getrsb_2_rbs_website());
        values.put(COLUMN_rsb_2_rbs_phone, contact.getrsb_2_rbs_phone());
        values.put(COLUMN_rsb_2_rbs_map, contact.getrsb_2_rbs_map());
        values.put(COLUMN_rsb_2_rbs_map_address, contact.getrsb_2_rbs_map_address());
        values.put(COLUMN_rsb_2_rbs_map_lat, contact.getrsb_2_rbs_map_lat());
        values.put(COLUMN_rsb_2_rbs_map_lng, contact.getrsb_2_rbs_map_lng());
        values.put(COLUMN_attr_repeat_0_attr_map, contact.getattr_repeat_0_attr_map());
        values.put(COLUMN_attr_repeat_0_attr_map_address, contact.getattr_repeat_0_attr_map_address());
        values.put(COLUMN_attr_repeat_0_attr_map_lat, contact.getattr_repeat_0_attr_map_lat());
        values.put(COLUMN_attr_repeat_0_attr_maplng, contact.getattr_repeat_0_attr_map_lng());
        values.put(COLUMN_attr_repeat_1_attr_map, contact.getattr_repeat_1_attr_map());
        values.put(COLUMN_attr_repeat_1_attr_map_address, contact.getattr_repeat_1_attr_map_address());
        values.put(COLUMN_attr_repeat_1_attr_map_lat, contact.getattr_repeat_1_attr_map_lat());
        values.put(COLUMN_attr_repeat_1_attr_map_lng, contact.getattr_repeat_1_attr_map_lng());

        values.put(COLUMN_com_laun_details, contact.getcom_laun_details());
        values.put(COLUMN_com_lug_details, contact.getcom_lug_details());
        values.put(COLUMN_com_hair_details, contact.getcom_hair_details());
        values.put(COLUMN_com_ct_details, contact.getcom_ct_details());
        values.put(COLUMN_com_room_details, contact.getcom_room_details());


        values.put(COLUMN_a_logo_image, contact.geta_logo_image());
        values.put(COLUMN_a_picture_image, contact.geta_picture_image());


        values.put(COLUMN_attr_repeat_2_attr_name, contact.getattr_repeat_2_attr_name());
        values.put(COLUMN_attr_repeat_2_attr_website, contact.getattr_repeat_2_attr_website());
        values.put(COLUMN_attr_repeat_2_attr_picture, contact.getattr_repeat_2_attr_picture());
        values.put(COLUMN_attr_repeat_2_attr_descript, contact.getattr_repeat_2_attr_descript());
        values.put(COLUMN_attr_repeat_2_attr_map, contact.getattr_repeat_2_attr_map());
        values.put(COLUMN_attr_repeat_2_attr_map_address, contact.getattr_repeat_2_attr_map_address());
        values.put(COLUMN_attr_repeat_2_attr_map_lat, contact.getattr_repeat_2_attr_map_lat());
        values.put(COLUMN_attr_repeat_2_attr_map_lng, contact.getattr_repeat_2_attr_map_lng());
        values.put(COLUMN_attr_repeat_3_attr_name, contact.getattr_repeat_3_attr_name());
        values.put(COLUMN_attr_repeat_3_attr_website, contact.getattr_repeat_3_attr_website());
        values.put(COLUMN_attr_repeat_3_attr_picture, contact.getattr_repeat_3_attr_picture());
        values.put(COLUMN_attr_repeat_3_attr_descript, contact.getattr_repeat_3_attr_descript());
        values.put(COLUMN_attr_repeat_3_attr_map, contact.getattr_repeat_3_attr_map());
        values.put(COLUMN_attr_repeat_3_attr_map_address, contact.getattr_repeat_3_attr_map_address());
        values.put(COLUMN_attr_repeat_3_attr_map_lat, contact.getattr_repeat_3_attr_map_lat());
        values.put(COLUMN_attr_repeat_3_attr_map_lng, contact.getattr_repeat_3_attr_map_lng());
        values.put(COLUMN_attr_repeat_4_attr_name, contact.getattr_repeat_4_attr_name());
        values.put(COLUMN_attr_repeat_4_attr_website, contact.getattr_repeat_4_attr_website());
        values.put(COLUMN_attr_repeat_4_attr_picture, contact.getattr_repeat_4_attr_picture());
        values.put(COLUMN_attr_repeat_4_attr_descript, contact.getattr_repeat_4_attr_descript());
        values.put(COLUMN_attr_repeat_4_attr_map, contact.getattr_repeat_4_attr_map());
        values.put(COLUMN_attr_repeat_4_attr_map_address, contact.getattr_repeat_4_attr_map_address());
        values.put(COLUMN_attr_repeat_4_attr_map_lat, contact.getattr_repeat_4_attr_map_lat());
        values.put(COLUMN_attr_repeat_4_attr_map_lng, contact.getattr_repeat_4_attr_map_lng());
        values.put(COLUMN_ent_1_ent_type, contact.getent_1_ent_type());
        values.put(COLUMN_ent_1_ent_name, contact.getent_1_ent_name());
        values.put(COLUMN_ent_1_ent_website, contact.getent_1_ent_website());
        values.put(COLUMN_ent_1_ent_phone, contact.getent_1_ent_phone());
        values.put(COLUMN_ent_1_ent_map, contact.getent_1_ent_map());
        values.put(COLUMN_ent_1_ent_map_address, contact.getent_1_ent_map_address());
        values.put(COLUMN_ent_1_ent_map_lat, contact.getent_1_ent_map_lat());
        values.put(COLUMN_ent_1_ent_map_lng, contact.getent_1_ent_map_lng());
        values.put(COLUMN_ent_2_ent_type, contact.getent_2_ent_type());
        values.put(COLUMN_ent_2_ent_name, contact.getent_2_ent_name());
        values.put(COLUMN_ent_2_ent_website, contact.getent_2_ent_website());
        values.put(COLUMN_ent_2_ent_phone, contact.getent_2_ent_phone());
        values.put(COLUMN_ent_2_ent_map, contact.getent_2_ent_map());
        values.put(COLUMN_ent_2_ent_map_address, contact.getent_2_ent_map_address());
        values.put(COLUMN_ent_2_ent_map_lat, contact.getent_2_ent_map_lat());
        values.put(COLUMN_ent_2_ent_map_lng, contact.getent_2_ent_map_lng());
        values.put(COLUMN_ent_3_ent_type, contact.getent_3_ent_type());
        values.put(COLUMN_ent_3_ent_name, contact.getent_3_ent_name());
        values.put(COLUMN_ent_3_ent_website, contact.getent_3_ent_website());
        values.put(COLUMN_ent_3_ent_phone, contact.getent_3_ent_phone());
        values.put(COLUMN_ent_3_ent_map, contact.getent_3_ent_map());
        values.put(COLUMN_ent_3_ent_map_address, contact.getent_3_ent_map_address());
        values.put(COLUMN_ent_3_ent_map_lat, contact.getent_3_ent_map_lat());
        values.put(COLUMN_ent_3_ent_map_lng, contact.getent_3_ent_map_lng());
        values.put(COLUMN_ent_4_ent_type, contact.getent_4_ent_type());
        values.put(COLUMN_ent_4_ent_name, contact.getent_4_ent_name());
        values.put(COLUMN_ent_4_ent_website, contact.getent_4_ent_website());
        values.put(COLUMN_ent_4_ent_phone, contact.getent_4_ent_phone());
        values.put(COLUMN_ent_4_ent_map, contact.getent_4_ent_map());
        values.put(COLUMN_ent_4_ent_map_address, contact.getent_4_ent_map_address());
        values.put(COLUMN_ent_4_ent_map_lat, contact.getent_4_ent_map_lat());
        values.put(COLUMN_ent_4_ent_map_lng, contact.getent_4_ent_map_lng());
        values.put(COLUMN_ent_5_ent_type, contact.getent_5_ent_type());
        values.put(COLUMN_ent_5_ent_name, contact.getent_5_ent_name());
        values.put(COLUMN_ent_5_ent_website, contact.getent_5_ent_website());
        values.put(COLUMN_ent_5_ent_phone, contact.getent_5_ent_phone());
        values.put(COLUMN_ent_5_ent_map, contact.getent_5_ent_map());
        values.put(COLUMN_ent_5_ent_map_address, contact.getent_5_ent_map_address());
        values.put(COLUMN_ent_5_ent_map_lat, contact.getent_5_ent_map_lat());
        values.put(COLUMN_ent_5_ent_map_lng, contact.getent_5_ent_map_lng());
        values.put(COLUMN_ent_6_ent_type, contact.getent_6_ent_type());
        values.put(COLUMN_ent_6_ent_name, contact.getent_6_ent_name());
        values.put(COLUMN_ent_6_ent_website, contact.getent_6_ent_website());
        values.put(COLUMN_ent_6_ent_phone, contact.getent_6_ent_phone());
        values.put(COLUMN_ent_6_ent_map, contact.getent_6_ent_map());
        values.put(COLUMN_ent_6_ent_map_address, contact.getent_6_ent_map_address());
        values.put(COLUMN_ent_6_ent_map_lat, contact.getent_6_ent_map_lat());
        values.put(COLUMN_ent_6_ent_map_lng, contact.getent_6_ent_map_lng());
        values.put(COLUMN_ent_7_ent_type, contact.getent_7_ent_type());
        values.put(COLUMN_ent_7_ent_name, contact.getent_7_ent_name());
        values.put(COLUMN_ent_7_ent_website, contact.getent_7_ent_website());
        values.put(COLUMN_ent_7_ent_phone, contact.getent_7_ent_phone());
        values.put(COLUMN_ent_7_ent_map, contact.getent_7_ent_map());
        values.put(COLUMN_ent_7_ent_map_address, contact.getent_7_ent_map_address());
        values.put(COLUMN_ent_7_ent_map_lat, contact.getent_7_ent_map_lat());
        values.put(COLUMN_ent_7_ent_map_lng, contact.getent_7_ent_map_lng());
        values.put(COLUMN_ent_8_ent_type, contact.getent_8_ent_type());
        values.put(COLUMN_ent_8_ent_name, contact.getent_8_ent_name());
        values.put(COLUMN_ent_8_ent_website, contact.getent_8_ent_website());
        values.put(COLUMN_ent_8_ent_phone, contact.getent_8_ent_phone());
        values.put(COLUMN_ent_8_ent_map, contact.getent_8_ent_map());
        values.put(COLUMN_ent_8_ent_map_address, contact.getent_8_ent_map_address());
        values.put(COLUMN_ent_8_ent_map_lat, contact.getent_8_ent_map_lat());
        values.put(COLUMN_ent_8_ent_map_lng, contact.getent_8_ent_map_lng());
        values.put(COLUMN_rsb_3_rbs_type, contact.getrsb_3_rbs_type());
        values.put(COLUMN_rsb_3_rbs_name, contact.getrsb_3_rbs_name());
        values.put(COLUMN_rsb_3_rbs_website, contact.getrsb_3_rbs_website());
        values.put(COLUMN_rsb_3_rbs_phone, contact.getrsb_3_rbs_phone());
        values.put(COLUMN_rsb_3_rbs_map, contact.getrsb_3_rbs_map());
        values.put(COLUMN_rsb_3_rbs_map_address, contact.getrsb_3_rbs_map_address());
        values.put(COLUMN_rsb_3_rbs_map_lat, contact.getrsb_3_rbs_map_lat());
        values.put(COLUMN_rsb_3_rbs_map_lng, contact.getrsb_3_rbs_map_lng());
        values.put(COLUMN_rsb_4_rbs_type, contact.getrsb_4_rbs_type());
        values.put(COLUMN_rsb_4_rbs_name, contact.getrsb_4_rbs_name());
        values.put(COLUMN_rsb_4_rbs_website, contact.getrsb_4_rbs_website());
        values.put(COLUMN_rsb_4_rbs_phone, contact.getrsb_4_rbs_phone());
        values.put(COLUMN_rsb_4_rbs_map, contact.getrsb_4_rbs_map());
        values.put(COLUMN_rsb_4_rbs_map_address, contact.getrsb_4_rbs_map_address());
        values.put(COLUMN_rsb_4_rbs_map_lat, contact.getrsb_4_rbs_map_lat());
        values.put(COLUMN_rsb_4_rbs_map_lng, contact.getrsb_4_rbs_map_lng());
        values.put(COLUMN_rsb_5_rbs_type, contact.getrsb_5_rbs_type());
        values.put(COLUMN_rsb_5_rbs_name, contact.getrsb_5_rbs_name());
        values.put(COLUMN_rsb_5_rbs_website, contact.getrsb_5_rbs_website());
        values.put(COLUMN_rsb_5_rbs_phone, contact.getrsb_5_rbs_phone());
        values.put(COLUMN_rsb_5_rbs_map, contact.getrsb_5_rbs_map());
        values.put(COLUMN_rsb_5_rbs_map_address, contact.getrsb_5_rbs_map_address());
        values.put(COLUMN_rsb_5_rbs_map_lat, contact.getrsb_5_rbs_map_lat());
        values.put(COLUMN_rsb_5_rbs_map_lng, contact.getrsb_5_rbs_map_lng());
        values.put(COLUMN_rsb_6_rbs_type, contact.getrsb_6_rbs_type());
        values.put(COLUMN_rsb_6_rbs_name, contact.getrsb_6_rbs_name());
        values.put(COLUMN_rsb_6_rbs_website, contact.getrsb_6_rbs_website());
        values.put(COLUMN_rsb_6_rbs_phone, contact.getrsb_6_rbs_phone());
        values.put(COLUMN_rsb_6_rbs_map, contact.getrsb_6_rbs_map());
        values.put(COLUMN_rsb_6_rbs_map_address, contact.getrsb_6_rbs_map_address());
        values.put(COLUMN_rsb_6_rbs_map_lat, contact.getrsb_6_rbs_map_lat());
        values.put(COLUMN_rsb_6_rbs_map_lng, contact.getrsb_6_rbs_map_lng());
        values.put(COLUMN_rsb_7_rbs_type, contact.getrsb_7_rbs_type());
        values.put(COLUMN_rsb_7_rbs_name, contact.getrsb_7_rbs_name());
        values.put(COLUMN_rsb_7_rbs_website, contact.getrsb_7_rbs_website());
        values.put(COLUMN_rsb_7_rbs_phone, contact.getrsb_7_rbs_phone());
        values.put(COLUMN_rsb_7_rbs_map, contact.getrsb_7_rbs_map());
        values.put(COLUMN_rsb_7_rbs_map_address, contact.getrsb_7_rbs_map_address());
        values.put(COLUMN_rsb_7_rbs_map_lat, contact.getrsb_7_rbs_map_lat());
        values.put(COLUMN_rsb_7_rbs_map_lng, contact.getrsb_7_rbs_map_lng());
        values.put(COLUMN_rsb_8_rbs_type, contact.getrsb_8_rbs_type());
        values.put(COLUMN_rsb_8_rbs_name, contact.getrsb_8_rbs_name());
        values.put(COLUMN_rsb_8_rbs_website, contact.getrsb_8_rbs_website());
        values.put(COLUMN_rsb_8_rbs_phone, contact.getrsb_8_rbs_phone());
        values.put(COLUMN_rsb_8_rbs_map, contact.getrsb_8_rbs_map());
        values.put(COLUMN_rsb_8_rbs_map_address, contact.getrsb_8_rbs_map_address());
        values.put(COLUMN_rsb_8_rbs_map_lat, contact.getrsb_8_rbs_map_lat());
        values.put(COLUMN_rsb_8_rbs_map_lng, contact.getrsb_8_rbs_map_lng());
        values.put(COLUMN_name, contact.getname());
        values.put(COLUMN_attr_repeat_0_attr_picture_image, contact.getattr_repeat_0_attr_picture_image());
        values.put(COLUMN_attr_repeat_1_attr_picture_image, contact.getattr_repeat_1_attr_picture_image());
        values.put(COLUMN_attr_repeat_2_attr_picture_image, contact.getattr_repeat_2_attr_picture_image());
        values.put(COLUMN_attr_repeat_3_attr_picture_image, contact.getattr_repeat_3_attr_picture_image());
        values.put(COLUMN_attr_repeat_4_attr_picture_image, contact.getattr_repeat_4_attr_picture_image());


        values.put(COLUMN_trc_address_address, contact.gettrc_address_address());
        values.put(COLUMN_trc_address_address_lat, contact.gettrc_address_address_lat());
        values.put(COLUMN_trc_address_address_lng, contact.gettrc_address_address_lng());
        values.put(COLUMN_trb_address_address, contact.gettrb_address_address());
        values.put(COLUMN_trb_address_address_lat, contact.gettrb_address_address_lat());
        values.put(COLUMN_trb_address_address_lng, contact.gettrb_address_address_lng());
        values.put(COLUMN_trm_address_address, contact.gettrm_address_address());
        values.put(COLUMN_trm_address_address_lat, contact.gettrm_address_address_lat());
        values.put(COLUMN_trm_address_address_lng, contact.gettrm_address_address_lng());

        // Inserting Row
        database.insert(TABLE_NAME, null, values);
        //2nd argument is String containing nullColumnHack
        database.close(); // Closing database connection
    }
    /*done*/


    /*done*/
    // Getting single contact
    public void Get_Contact(Contact contact) {
        database = this.getReadableDatabase();
        database.execSQL("INSERT INTO "
                + TABLE_NAME +
                "("
                + COLUMN_POST_ID + ","
                + COLUMN_a_welcome + ","
                + COLUMN_a_logo + ","
                + COLUMN_a_picture + ","
                + COLUMN_a_address + ","
                + COLUMN_a_zip + ","
                + COLUMN_a_town + ","
                + COLUMN_a_country + ","
                + COLUMN_a_map + ","
                + COLUMN_a_map_address + ","
                + COLUMN_a_map_address_lng + ","
                + COLUMN_a_map_address_lat + ","
                + COLUMN_a_website + ","
                + COLUMN_a_telephone + ","
                + COLUMN_a_facebook + ","
                + COLUMN_a_twitter + ","

                + COLUMN_l_firstname + ","
                + COLUMN_l_lastname + ","
                + COLUMN_l_address + ","
                + COLUMN_l_zip + ","
                + COLUMN_l_town + ","
                + COLUMN_l_country + ","
                + COLUMN_l_telephone + ","
                + COLUMN_l_mobile + ","
                + COLUMN_l_email + ","
                + COLUMN_l_skype + ","
                + COLUMN_l_facebook + ","
                + COLUMN_l_twitter + ","
                + COLUMN_l_language + ","

                + COLUMN_o_firstname + ","
                + COLUMN_o_lastname + ","
                + COLUMN_o_address + ","
                + COLUMN_o_zip + ","
                + COLUMN_o_town + ","
                + COLUMN_o_country + ","
                + COLUMN_o_telephone + ","
                + COLUMN_o_mobile + ","
                + COLUMN_o_email + ","
                + COLUMN_o_skype + ","
                + COLUMN_o_facebook + ","
                + COLUMN_o_twitter + ","
                + COLUMN_o_language + ","

                + COLUMN_fdb_time + ","
                + COLUMN_fdb_where + ","

                + COLUMN_fdl_time + ","
                + COLUMN_fdl_where + ","

                + COLUMN_fdd_time + ","
                + COLUMN_fdd_where + ","

                + COLUMN_trt_name + ","
                + COLUMN_trt_phone + ","
                + COLUMN_trt_address + ","
                + COLUMN_trt_address_address + ","
                + COLUMN_trt_address_lat + ","
                + COLUMN_trt_address_lng + ","
                + COLUMN_trt_website + ","
                + COLUMN_trt_email + ","

                + COLUMN_trc_name + ","
                + COLUMN_trc_phone + ","
                + COLUMN_trc_address + ","
                + COLUMN_trc_website + ","
                + COLUMN_trc_email + ","

                + COLUMN_trb_name + ","
                + COLUMN_trb_phone + ","
                + COLUMN_trb_address + ","
                + COLUMN_trb_website + ","
                + COLUMN_trb_email + ","

                + COLUMN_trm_name + ","
                + COLUMN_trm_phone + ","
                + COLUMN_trm_address + ","
                + COLUMN_trm_website + ","
                + COLUMN_trm_email + ","

                + COLUMN_trp_bus + ","
                + COLUMN_trp_metro + ","
                + COLUMN_trp_train + ","

                + COLUMN_trair_name + ","
                + COLUMN_trair_phone + ","
                + COLUMN_trair_address + ","
                + COLUMN_trair_address_address + ","
                + COLUMN_trair_address_lat + ","
                + COLUMN_trair_address_lng + ","
                + COLUMN_trair_website + ","
                + COLUMN_trair_email + ","

                + COLUMN_moatm_address + ","

                + COLUMN_ser_checkintime + ","
                + COLUMN_ser_checkouttime + ","

                + COLUMN_attr_repeat + ","
                + COLUMN_attr_repeat_0_attr_name + ","
                + COLUMN_attr_repeat_0_attr_website + ","
                + COLUMN_attr_repeat_0_attr_picture + ","
                + COLUMN_attr_repeat_0_attr_descript + ","
                + COLUMN_attr_repeat_1_attr_name + ","
                + COLUMN_attr_repeat_1_attr_website + ","
                + COLUMN_attr_repeat_1_attr_picture + ","
                + COLUMN_attr_repeat_1_attr_descript + ","

                + COLUMN_ser_atm_address + ","
                + COLUMN_ser_atm_location + ","
                + COLUMN_ser_atm_location_address + ","
                + COLUMN_ser_atm_location_lat + ","
                + COLUMN_ser_atm_location_lng + ","

                + COLUMN_ser_wifi_pass + ","
                + COLUMN_ser_wifi_details + ","

                + COLUMN_ser_park_details + ","
                + COLUMN_ser_park_map + ","
                + COLUMN_ser_park_map_address + ","
                + COLUMN_ser_park_map_address_lat + ","
                + COLUMN_ser_park_map_address_lng + ","

                + COLUMN_ser_tv_details + ","

                + COLUMN_em_general + ","
                + COLUMN_em_fire + ","
                + COLUMN_em_ambulance + ","
                + COLUMN_em_police + ","
                + COLUMN_em_assistance + ","
                + COLUMN_em_docter_name + ","
                + COLUMN_em_docter_telephone + ","
                + COLUMN_em_docter_address + ","
                + COLUMN_em_docter_address_address + ","
                + COLUMN_em_docter_address_lat + ","
                + COLUMN_em_docter_address_lng + ","
                + COLUMN_em_pharmacy_name + ","
                + COLUMN_em_pharmacy_telephone + ","
                + COLUMN_em_pharmacy_address + ","
                + COLUMN_em_pharmacy_address_address + ","
                + COLUMN_em_pharmacy_address_lat + ","
                + COLUMN_em_pharmacy_address_lng + ","
                + COLUMN_rsb + ","
                + COLUMN_ent_0_ent_type + ","
                + COLUMN_ent_0_ent_name + ","
                + COLUMN_ent_0_ent_website + ","
                + COLUMN_ent_0_ent_phone + ","
                + COLUMN_ent_0_ent_map + ","
                + COLUMN_ent_0_ent_map_address + ","
                + COLUMN_ent_0_ent_map_lat + ","
                + COLUMN_ent_0_ent_map_lng + ","
                + COLUMN_ent + ","
                + COLUMN_rsb_0_rbs_type + ","
                + COLUMN_rsb_0_rbs_name + ","
                + COLUMN_rsb_0_rbs_website + ","
                + COLUMN_rsb_0_rbs_phone + ","
                + COLUMN_rsb_0_rbs_map + ","
                + COLUMN_rsb_0_rbs_map_address + ","
                + COLUMN_rsb_0_rbs_map_lat + ","
                + COLUMN_rsb_0_rbs_map_lng + ","
                + COLUMN_rsb_1_rbs_type + ","
                + COLUMN_rsb_1_rbs_name + ","
                + COLUMN_rsb_1_rbs_website + ","
                + COLUMN_rsb_1_rbs_phone + ","
                + COLUMN_rsb_1_rbs_map + ","
                + COLUMN_rsb_1_rbs_map_address + ","
                + COLUMN_rsb_1_rbs_map_lat + ","
                + COLUMN_rsb_1_rbs_map_lng + ","
                + COLUMN_rsb_2_rbs_type + ","
                + COLUMN_rsb_2_rbs_name + ","
                + COLUMN_rsb_2_rbs_website + ","
                + COLUMN_rsb_2_rbs_phone + ","
                + COLUMN_rsb_2_rbs_map + ","
                + COLUMN_rsb_2_rbs_map_address + ","
                + COLUMN_rsb_2_rbs_map_lat + ","
                + COLUMN_rsb_2_rbs_map_lng + ","
                + COLUMN_attr_repeat_0_attr_map + ","
                + COLUMN_attr_repeat_0_attr_map_address + ","
                + COLUMN_attr_repeat_0_attr_map_lat + ","
                + COLUMN_attr_repeat_0_attr_maplng + ","
                + COLUMN_attr_repeat_1_attr_map + ","
                + COLUMN_attr_repeat_1_attr_map_address + ","
                + COLUMN_attr_repeat_1_attr_map_lat + ","
                + COLUMN_attr_repeat_1_attr_map_lng + ","
                + COLUMN_com_laun_details + ","
                + COLUMN_com_lug_details + ","
                + COLUMN_com_hair_details + ","
                + COLUMN_com_ct_details + ","
                + COLUMN_com_room_details + ","
                + COLUMN_a_logo_image + ","
                + COLUMN_a_picture_image + ","


                + COLUMN_attr_repeat_2_attr_name + ","
                + COLUMN_attr_repeat_2_attr_website + ","
                + COLUMN_attr_repeat_2_attr_picture + ","
                + COLUMN_attr_repeat_2_attr_descript + ","
                + COLUMN_attr_repeat_2_attr_map + ","
                + COLUMN_attr_repeat_2_attr_map_address + ","
                + COLUMN_attr_repeat_2_attr_map_lat + ","
                + COLUMN_attr_repeat_2_attr_map_lng + ","
                + COLUMN_attr_repeat_3_attr_name + ","
                + COLUMN_attr_repeat_3_attr_website + ","
                + COLUMN_attr_repeat_3_attr_picture + ","
                + COLUMN_attr_repeat_3_attr_descript + ","
                + COLUMN_attr_repeat_3_attr_map + ","
                + COLUMN_attr_repeat_3_attr_map_address + ","
                + COLUMN_attr_repeat_3_attr_map_lat + ","
                + COLUMN_attr_repeat_3_attr_map_lng + ","
                + COLUMN_attr_repeat_4_attr_name + ","
                + COLUMN_attr_repeat_4_attr_website + ","
                + COLUMN_attr_repeat_4_attr_picture + ","
                + COLUMN_attr_repeat_4_attr_descript + ","
                + COLUMN_attr_repeat_4_attr_map + ","
                + COLUMN_attr_repeat_4_attr_map_address + ","
                + COLUMN_attr_repeat_4_attr_map_lat + ","
                + COLUMN_attr_repeat_4_attr_map_lng + ","
                + COLUMN_ent_1_ent_type + ","
                + COLUMN_ent_1_ent_name + ","
                + COLUMN_ent_1_ent_website + ","
                + COLUMN_ent_1_ent_phone + ","
                + COLUMN_ent_1_ent_map + ","
                + COLUMN_ent_1_ent_map_address + ","
                + COLUMN_ent_1_ent_map_lat + ","
                + COLUMN_ent_1_ent_map_lng + ","
                + COLUMN_ent_2_ent_type + ","
                + COLUMN_ent_2_ent_name + ","
                + COLUMN_ent_2_ent_website + ","
                + COLUMN_ent_2_ent_phone + ","
                + COLUMN_ent_2_ent_map + ","
                + COLUMN_ent_2_ent_map_address + ","
                + COLUMN_ent_2_ent_map_lat + ","
                + COLUMN_ent_2_ent_map_lng + ","
                + COLUMN_ent_3_ent_type + ","
                + COLUMN_ent_3_ent_name + ","
                + COLUMN_ent_3_ent_website + ","
                + COLUMN_ent_3_ent_phone + ","
                + COLUMN_ent_3_ent_map + ","
                + COLUMN_ent_3_ent_map_address + ","
                + COLUMN_ent_3_ent_map_lat + ","
                + COLUMN_ent_3_ent_map_lng + ","
                + COLUMN_ent_4_ent_type + ","
                + COLUMN_ent_4_ent_name + ","
                + COLUMN_ent_4_ent_website + ","
                + COLUMN_ent_4_ent_phone + ","
                + COLUMN_ent_4_ent_map + ","
                + COLUMN_ent_4_ent_map_address + ","
                + COLUMN_ent_4_ent_map_lat + ","
                + COLUMN_ent_4_ent_map_lng + ","
                + COLUMN_ent_5_ent_type + ","
                + COLUMN_ent_5_ent_name + ","
                + COLUMN_ent_5_ent_website + ","
                + COLUMN_ent_5_ent_phone + ","
                + COLUMN_ent_5_ent_map + ","
                + COLUMN_ent_5_ent_map_address + ","
                + COLUMN_ent_5_ent_map_lat + ","
                + COLUMN_ent_5_ent_map_lng + ","
                + COLUMN_ent_6_ent_type + ","
                + COLUMN_ent_6_ent_name + ","
                + COLUMN_ent_6_ent_website + ","
                + COLUMN_ent_6_ent_phone + ","
                + COLUMN_ent_6_ent_map + ","
                + COLUMN_ent_6_ent_map_address + ","
                + COLUMN_ent_6_ent_map_lat + ","
                + COLUMN_ent_6_ent_map_lng + ","
                + COLUMN_ent_7_ent_type + ","
                + COLUMN_ent_7_ent_name + ","
                + COLUMN_ent_7_ent_website + ","
                + COLUMN_ent_7_ent_phone + ","
                + COLUMN_ent_7_ent_map + ","
                + COLUMN_ent_7_ent_map_address + ","
                + COLUMN_ent_7_ent_map_lat + ","
                + COLUMN_ent_7_ent_map_lng + ","
                + COLUMN_ent_8_ent_type + ","
                + COLUMN_ent_8_ent_name + ","
                + COLUMN_ent_8_ent_website + ","
                + COLUMN_ent_8_ent_phone + ","
                + COLUMN_ent_8_ent_map + ","
                + COLUMN_ent_8_ent_map_address + ","
                + COLUMN_ent_8_ent_map_lat + ","
                + COLUMN_ent_8_ent_map_lng + ","
                + COLUMN_rsb_3_rbs_type + ","
                + COLUMN_rsb_3_rbs_name + ","
                + COLUMN_rsb_3_rbs_website + ","
                + COLUMN_rsb_3_rbs_phone + ","
                + COLUMN_rsb_3_rbs_map + ","
                + COLUMN_rsb_3_rbs_map_address + ","
                + COLUMN_rsb_3_rbs_map_lat + ","
                + COLUMN_rsb_3_rbs_map_lng + ","
                + COLUMN_rsb_4_rbs_type + ","
                + COLUMN_rsb_4_rbs_name + ","
                + COLUMN_rsb_4_rbs_website + ","
                + COLUMN_rsb_4_rbs_phone + ","
                + COLUMN_rsb_4_rbs_map + ","
                + COLUMN_rsb_4_rbs_map_address + ","
                + COLUMN_rsb_4_rbs_map_lat + ","
                + COLUMN_rsb_4_rbs_map_lng + ","
                + COLUMN_rsb_5_rbs_type + ","
                + COLUMN_rsb_5_rbs_name + ","
                + COLUMN_rsb_5_rbs_website + ","
                + COLUMN_rsb_5_rbs_phone + ","
                + COLUMN_rsb_5_rbs_map + ","
                + COLUMN_rsb_5_rbs_map_address + ","
                + COLUMN_rsb_5_rbs_map_lat + ","
                + COLUMN_rsb_5_rbs_map_lng + ","
                + COLUMN_rsb_6_rbs_type + ","
                + COLUMN_rsb_6_rbs_name + ","
                + COLUMN_rsb_6_rbs_website + ","
                + COLUMN_rsb_6_rbs_phone + ","
                + COLUMN_rsb_6_rbs_map + ","
                + COLUMN_rsb_6_rbs_map_address + ","
                + COLUMN_rsb_6_rbs_map_lat + ","
                + COLUMN_rsb_6_rbs_map_lng + ","
                + COLUMN_rsb_7_rbs_type + ","
                + COLUMN_rsb_7_rbs_name + ","
                + COLUMN_rsb_7_rbs_website + ","
                + COLUMN_rsb_7_rbs_phone + ","
                + COLUMN_rsb_7_rbs_map + ","
                + COLUMN_rsb_7_rbs_map_address + ","
                + COLUMN_rsb_7_rbs_map_lat + ","
                + COLUMN_rsb_7_rbs_map_lng + ","
                + COLUMN_rsb_8_rbs_type + ","
                + COLUMN_rsb_8_rbs_name + ","
                + COLUMN_rsb_8_rbs_website + ","
                + COLUMN_rsb_8_rbs_phone + ","
                + COLUMN_rsb_8_rbs_map + ","
                + COLUMN_rsb_8_rbs_map_address + ","
                + COLUMN_rsb_8_rbs_map_lat + ","
                + COLUMN_rsb_8_rbs_map_lng + ","
                + COLUMN_name + ","
                + COLUMN_attr_repeat_0_attr_picture_image + ","
                + COLUMN_attr_repeat_1_attr_picture_image + ","
                + COLUMN_attr_repeat_2_attr_picture_image + ","
                + COLUMN_attr_repeat_3_attr_picture_image + ","
                + COLUMN_attr_repeat_4_attr_picture_image + ","
                + COLUMN_trc_address_address + ","
                + COLUMN_trc_address_address_lat + ","
                + COLUMN_trc_address_address_lng + ","
                + COLUMN_trb_address_address + ","
                + COLUMN_trb_address_address_lat + ","
                + COLUMN_trb_address_address_lng + ","
                + COLUMN_trm_address_address + ","
                + COLUMN_trm_address_address_lat + ","
                + COLUMN_trm_address_address_lng +
                ") VALUES('"
                + contact.getPOST_ID() + "','"
                + contact.geta_welcome() + "','"
                + contact.geta_logo() + "','"
                + contact.geta_picture() + "','"
                + contact.geta_address() + "','"
                + contact.geta_zip() + "','"
                + contact.geta_town() + "','"
                + contact.geta_country() + "','"
                + contact.geta_map() + "','"
                + contact.geta_map_address() + "','"
                + contact.geta_map_address_lng() + "','"
                + contact.geta_map_address_lat() + "','"
                + contact.geta_website() + "','"
                + contact.geta_telephone() + "','"
                + contact.geta_facebook() + "','"
                + contact.geta_twitter() + "', '"
                + contact.getl_firstname() + "','"
                + contact.getl_lastname() + "','"
                + contact.getl_address() + "','"
                + contact.getl_zip() + "','"
                + contact.getl_town() + "','"
                + contact.getl_country() + "','"
                + contact.getl_telephone() + "','"
                + contact.getl_mobile() + "','"
                + contact.getl_email() + "','"
                + contact.getl_skype() + "','"
                + contact.getl_facebook() + "','"
                + contact.getl_twitter() + "','"
                + contact.getl_language() + "', '"
                + contact.geto_firstname() + "','"
                + contact.geto_lastname() + "','"
                + contact.geto_address() + "','"
                + contact.geto_zip() + "','"
                + contact.geto_town() + "','"
                + contact.geto_country() + "','"
                + contact.geto_telephone() + "','"
                + contact.geto_mobile() + "','"
                + contact.geto_email() + "','"
                + contact.geto_skype() + "','"
                + contact.geto_facebook() + "','"
                + contact.geto_twitter() + "','"
                + contact.geto_language() + "', '"
                + contact.getfdb_time() + "','"
                + contact.getfdb_where() + "', '"
                + contact.getfdl_time() + "','"
                + contact.getfdl_where() + "', '"
                + contact.getfdd_time() + "','"
                + contact.getfdd_where() + "', '"
                + contact.gettrt_name() + "','"
                + contact.gettrt_phone() + "','"
                + contact.gettrt_address() + "','"
                + contact.gettrt_address_address() + "','"
                + contact.gettrt_address_lat() + "','"
                + contact.gettrt_address_lng() + "','"
                + contact.gettrt_website() + "','"
                + contact.gettrt_email() + "','"
                + contact.gettrc_name() + "','"
                + contact.gettrc_phone() + "','"
                + contact.gettrc_address() + "','"
                + contact.gettrc_website() + "','"
                + contact.gettrc_email() + "', '"
                + contact.gettrb_name() + "','"
                + contact.gettrb_phone() + "','"
                + contact.gettrb_address() + "','"
                + contact.gettrb_website() + "','"
                + contact.gettrb_email() + "','"
                + contact.gettrm_name() + "','"
                + contact.gettrm_phone() + "','"
                + contact.gettrm_address() + "','"
                + contact.gettrm_website() + "','"
                + contact.gettrm_email() + "','"
                + contact.gettrp_bus() + "','"
                + contact.gettrp_metro() + "','"
                + contact.gettrp_train() + "','"
                + contact.gettrair_name() + "','"
                + contact.gettrair_phone() + "','"
                + contact.gettrair_address() + "','"
                + contact.gettrair_address_address() + "','"
                + contact.gettrair_address_lat() + "','"
                + contact.gettrair_address_lng() + "','"
                + contact.gettrair_website() + "','"
                + contact.gettrair_email() + "','"
                + contact.getmoatm_address() + "','"
                + contact.getser_checkintime() + "','"
                + contact.getser_checkouttime() + "','"
                + contact.getattr_repeat() + "','"
                + contact.getattr_repeat_0_attr_name() + "','"
                + contact.getattr_repeat_0_attr_website() + "','"
                + contact.getattr_repeat_0_attr_picture() + "','"
                + contact.getattr_repeat_0_attr_descript() + "','"
                + contact.getattr_repeat_1_attr_name() + "','"
                + contact.getattr_repeat_1_attr_website() + "','"
                + contact.getattr_repeat_1_attr_picture() + "','"
                + contact.getattr_repeat_1_attr_descript() + "','"
                + contact.getser_atm_address() + "','"
                + contact.getser_atm_location() + "','"
                + contact.getser_atm_location_address() + "','"
                + contact.getser_atm_location_lat() + "','"
                + contact.getser_atm_location_lng() + "','"
                + contact.getser_wifi_pass() + "','"
                + contact.getser_wifi_details() + "','"
                + contact.getser_park_details() + "','"
                + contact.getser_park_map() + "','"
                + contact.getser_park_map_address() + "','"
                + contact.getser_park_map_address_lat() + "','"
                + contact.getser_park_map_address_lng() + "','"
                + contact.getser_tv_details() + "','"
                + contact.getem_general() + "','"
                + contact.getem_fire() + "','"
                + contact.getem_ambulance() + "','"
                + contact.getem_police() + "','"
                + contact.getem_assistance() + "','"
                + contact.getem_docter_name() + "','"
                + contact.getem_docter_telephone() + "','"
                + contact.getem_docter_address() + "','"
                + contact.getem_docter_address_address() + "','"
                + contact.getem_docter_address_lat() + "','"
                + contact.getem_docter_address_lng() + "','"
                + contact.getem_pharmacy_name() + "','"
                + contact.getem_pharmacy_telephone() + "','"
                + contact.getem_pharmacy_address() + "','"
                + contact.getem_pharmacy_address_address() + "','"
                + contact.getem_pharmacy_address_lat() + "','"
                + contact.getem_pharmacy_address_lng() + "','"
                + contact.getrsb() + "','"
                + contact.getent_0_ent_type() + "','"
                + contact.getent_0_ent_name() + "','"
                + contact.getent_0_ent_website() + "','"
                + contact.getent_0_ent_phone() + "','"
                + contact.getent_0_ent_map() + "','"
                + contact.getent_0_ent_map_address() + "','"
                + contact.getent_0_ent_map_lat() + "','"
                + contact.getent_0_ent_map_lng() + "','"
                + contact.getent() + "','"
                + contact.getrsb_0_rbs_type() + "','"
                + contact.getrsb_0_rbs_name() + "','"
                + contact.getrsb_0_rbs_website() + "','"
                + contact.getrsb_0_rbs_phone() + "','"
                + contact.getrsb_0_rbs_map() + "','"
                + contact.getrsb_0_rbs_map_address() + "','"
                + contact.getrsb_0_rbs_map_lat() + "','"
                + contact.getrsb_0_rbs_map_lng() + "','"
                + contact.getrsb_1_rbs_type() + "','"
                + contact.getrsb_1_rbs_name() + "','"
                + contact.getrsb_1_rbs_website() + "','"
                + contact.getrsb_1_rbs_phone() + "','"
                + contact.getrsb_1_rbs_map() + "','"
                + contact.getrsb_1_rbs_map_address() + "','"
                + contact.getrsb_1_rbs_map_lat() + "','"
                + contact.getrsb_1_rbs_map_lng() + "','"
                + contact.getrsb_2_rbs_type() + "','"
                + contact.getrsb_2_rbs_name() + "','"
                + contact.getrsb_2_rbs_website() + "','"
                + contact.getrsb_2_rbs_phone() + "','"
                + contact.getrsb_2_rbs_map() + "','"
                + contact.getrsb_2_rbs_map_address() + "','"
                + contact.getrsb_2_rbs_map_lat() + "','"
                + contact.getrsb_2_rbs_map_lng() + "','"
                + contact.getattr_repeat_0_attr_map() + "','"
                + contact.getattr_repeat_0_attr_map_address() + "','"
                + contact.getattr_repeat_0_attr_map_lat() + "','"
                + contact.getattr_repeat_0_attr_map_lng() + "','"
                + contact.getattr_repeat_1_attr_map() + "','"
                + contact.getattr_repeat_1_attr_map_address() + "','"
                + contact.getattr_repeat_1_attr_map_lat() + "','"
                + contact.getattr_repeat_1_attr_map_lng() + "','"
                + contact.getcom_laun_details() + "','"
                + contact.getcom_lug_details() + "','"
                + contact.getcom_hair_details() + "','"
                + contact.getcom_ct_details() + "','"
                + contact.getcom_room_details() + "','"
                + contact.geta_logo_image() + "','"
                + contact.geta_picture_image() + "','"
                + contact.getattr_repeat_2_attr_name() + "','"
                + contact.getattr_repeat_2_attr_website() + "','"
                + contact.getattr_repeat_2_attr_picture() + "','"
                + contact.getattr_repeat_2_attr_descript() + "','"
                + contact.getattr_repeat_2_attr_map() + "','"
                + contact.getattr_repeat_2_attr_map_address() + "','"
                + contact.getattr_repeat_2_attr_map_lat() + "','"
                + contact.getattr_repeat_2_attr_map_lng() + "','"
                + contact.getattr_repeat_3_attr_name() + "','"
                + contact.getattr_repeat_3_attr_website() + "','"
                + contact.getattr_repeat_3_attr_picture() + "','"
                + contact.getattr_repeat_3_attr_descript() + "','"
                + contact.getattr_repeat_3_attr_map() + "','"
                + contact.getattr_repeat_3_attr_map_address() + "','"
                + contact.getattr_repeat_3_attr_map_lat() + "','"
                + contact.getattr_repeat_3_attr_map_lng() + "','"
                + contact.getattr_repeat_4_attr_name() + "','"
                + contact.getattr_repeat_4_attr_website() + "','"
                + contact.getattr_repeat_4_attr_picture() + "','"
                + contact.getattr_repeat_4_attr_descript() + "','"
                + contact.getattr_repeat_4_attr_map() + "','"
                + contact.getattr_repeat_4_attr_map_address() + "','"
                + contact.getattr_repeat_4_attr_map_lat() + "','"
                + contact.getattr_repeat_4_attr_map_lng() + "','"
                + contact.getent_1_ent_type() + "','"
                + contact.getent_1_ent_name() + "','"
                + contact.getent_1_ent_website() + "','"
                + contact.getent_1_ent_phone() + "','"
                + contact.getent_1_ent_map() + "','"
                + contact.getent_1_ent_map_address() + "','"
                + contact.getent_1_ent_map_lat() + "','"
                + contact.getent_1_ent_map_lng() + "','"
                + contact.getent_2_ent_type() + "','"
                + contact.getent_2_ent_name() + "','"
                + contact.getent_2_ent_website() + "','"
                + contact.getent_2_ent_phone() + "','"
                + contact.getent_2_ent_map() + "','"
                + contact.getent_2_ent_map_address() + "','"
                + contact.getent_2_ent_map_lat() + "','"
                + contact.getent_2_ent_map_lng() + "','"
                + contact.getent_3_ent_type() + "','"
                + contact.getent_3_ent_name() + "','"
                + contact.getent_3_ent_website() + "','"
                + contact.getent_3_ent_phone() + "','"
                + contact.getent_3_ent_map() + "','"
                + contact.getent_3_ent_map_address() + "','"
                + contact.getent_3_ent_map_lat() + "','"
                + contact.getent_3_ent_map_lng() + "','"
                + contact.getent_4_ent_type() + "','"
                + contact.getent_4_ent_name() + "','"
                + contact.getent_4_ent_website() + "','"
                + contact.getent_4_ent_phone() + "','"
                + contact.getent_4_ent_map() + "','"
                + contact.getent_4_ent_map_address() + "','"
                + contact.getent_4_ent_map_lat() + "','"
                + contact.getent_4_ent_map_lng() + "','"
                + contact.getent_5_ent_type() + "','"
                + contact.getent_5_ent_name() + "','"
                + contact.getent_5_ent_website() + "','"
                + contact.getent_5_ent_phone() + "','"
                + contact.getent_5_ent_map() + "','"
                + contact.getent_5_ent_map_address() + "','"
                + contact.getent_5_ent_map_lat() + "','"
                + contact.getent_5_ent_map_lng() + "','"
                + contact.getent_6_ent_type() + "','"
                + contact.getent_6_ent_name() + "','"
                + contact.getent_6_ent_website() + "','"
                + contact.getent_6_ent_phone() + "','"
                + contact.getent_6_ent_map() + "','"
                + contact.getent_6_ent_map_address() + "','"
                + contact.getent_6_ent_map_lat() + "','"
                + contact.getent_6_ent_map_lng() + "','"
                + contact.getent_7_ent_type() + "','"
                + contact.getent_7_ent_name() + "','"
                + contact.getent_7_ent_website() + "','"
                + contact.getent_7_ent_phone() + "','"
                + contact.getent_7_ent_map() + "','"
                + contact.getent_7_ent_map_address() + "','"
                + contact.getent_7_ent_map_lat() + "','"
                + contact.getent_7_ent_map_lng() + "','"
                + contact.getent_8_ent_type() + "','"
                + contact.getent_8_ent_name() + "','"
                + contact.getent_8_ent_website() + "','"
                + contact.getent_8_ent_phone() + "','"
                + contact.getent_8_ent_map() + "','"
                + contact.getent_8_ent_map_address() + "','"
                + contact.getent_8_ent_map_lat() + "','"
                + contact.getent_8_ent_map_lng() + "','"
                + contact.getrsb_3_rbs_type() + "','"
                + contact.getrsb_3_rbs_name() + "','"
                + contact.getrsb_3_rbs_website() + "','"
                + contact.getrsb_3_rbs_phone() + "','"
                + contact.getrsb_3_rbs_map() + "','"
                + contact.getrsb_3_rbs_map_address() + "','"
                + contact.getrsb_3_rbs_map_lat() + "','"
                + contact.getrsb_3_rbs_map_lng() + "','"
                + contact.getrsb_4_rbs_type() + "','"
                + contact.getrsb_4_rbs_name() + "','"
                + contact.getrsb_4_rbs_website() + "','"
                + contact.getrsb_4_rbs_phone() + "','"
                + contact.getrsb_4_rbs_map() + "','"
                + contact.getrsb_4_rbs_map_address() + "','"
                + contact.getrsb_4_rbs_map_lat() + "','"
                + contact.getrsb_4_rbs_map_lng() + "','"
                + contact.getrsb_5_rbs_type() + "','"
                + contact.getrsb_5_rbs_name() + "','"
                + contact.getrsb_5_rbs_website() + "','"
                + contact.getrsb_5_rbs_phone() + "','"
                + contact.getrsb_5_rbs_map() + "','"
                + contact.getrsb_5_rbs_map_address() + "','"
                + contact.getrsb_5_rbs_map_lat() + "','"
                + contact.getrsb_5_rbs_map_lng() + "','"
                + contact.getrsb_6_rbs_type() + "','"
                + contact.getrsb_6_rbs_name() + "','"
                + contact.getrsb_6_rbs_website() + "','"
                + contact.getrsb_6_rbs_phone() + "','"
                + contact.getrsb_6_rbs_map() + "','"
                + contact.getrsb_6_rbs_map_address() + "','"
                + contact.getrsb_6_rbs_map_lat() + "','"
                + contact.getrsb_6_rbs_map_lng() + "','"
                + contact.getrsb_7_rbs_type() + "','"
                + contact.getrsb_7_rbs_name() + "','"
                + contact.getrsb_7_rbs_website() + "','"
                + contact.getrsb_7_rbs_phone() + "','"
                + contact.getrsb_7_rbs_map() + "','"
                + contact.getrsb_7_rbs_map_address() + "','"
                + contact.getrsb_7_rbs_map_lat() + "','"
                + contact.getrsb_7_rbs_map_lng() + "','"
                + contact.getrsb_8_rbs_type() + "','"
                + contact.getrsb_8_rbs_name() + "','"
                + contact.getrsb_8_rbs_website() + "','"
                + contact.getrsb_8_rbs_phone() + "','"
                + contact.getrsb_8_rbs_map() + "','"
                + contact.getrsb_8_rbs_map_address() + "','"
                + contact.getrsb_8_rbs_map_lat() + "','"
                + contact.getrsb_8_rbs_map_lng() + "','"
                + contact.getname() + "','"
                + contact.getattr_repeat_0_attr_picture_image() + "','"
                + contact.getattr_repeat_1_attr_picture_image() + "','"
                + contact.getattr_repeat_2_attr_picture_image() + "','"
                + contact.getattr_repeat_3_attr_picture_image() + "','"
                + contact.getattr_repeat_4_attr_picture_image() + "','"
                + contact.gettrc_address_address() + "','"
                + contact.gettrc_address_address_lat() + "','"
                + contact.gettrc_address_address_lng() + "','"
                + contact.gettrb_address_address() + "','"
                + contact.gettrb_address_address_lat() + "','"
                + contact.gettrb_address_address_lng() + "','"
                + contact.gettrm_address_address() + "','"
                + contact.gettrm_address_address_lat() + "','"
                + contact.gettrm_address_address_lng() + "')");

        database.close();

    }
    /*done*/


    /*done*/
    // Getting All Contacts in a list view
    public ArrayList<Contact> Get_All_Contacts() {
        database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        Contact contact;
        // looping through all rows and adding to list
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                contact = new Contact();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setPOST_ID(cursor.getString(1));
                contact.seta_welcome(cursor.getString(2));
                contact.seta_logo(cursor.getString(3));
                contact.seta_picture(cursor.getString(4));
                contact.seta_address(cursor.getString(5));
                contact.seta_zip(cursor.getString(6));
                contact.seta_town(cursor.getString(7));
                contact.seta_country(cursor.getString(8));
                contact.seta_map(cursor.getString(9));
                contact.seta_map_address(cursor.getString(10));
                contact.seta_map_address_lat(cursor.getString(11));
                contact.seta_map_address_lng(cursor.getString(12));
                contact.seta_website(cursor.getString(13));
                contact.seta_telephone(cursor.getString(14));
                contact.seta_facebook(cursor.getString(15));
                contact.seta_twitter(cursor.getString(16));

                contact.setl_firstname(cursor.getString(17));
                contact.setl_lastname(cursor.getString(18));
                contact.setl_address(cursor.getString(19));
                contact.setl_zip(cursor.getString(20));
                contact.setl_town(cursor.getString(21));
                contact.setl_country(cursor.getString(22));
                contact.setl_telephone(cursor.getString(23));
                contact.setl_mobile(cursor.getString(24));
                contact.setl_email(cursor.getString(25));
                contact.setl_skype(cursor.getString(26));
                contact.setl_facebook(cursor.getString(27));
                contact.setl_twitter(cursor.getString(28));
                contact.setl_language(cursor.getString(29));

                contact.seto_firstname(cursor.getString(30));
                contact.seto_lastname(cursor.getString(31));
                contact.seto_address(cursor.getString(32));
                contact.seto_zip(cursor.getString(33));
                contact.seto_town(cursor.getString(34));
                contact.seto_country(cursor.getString(35));
                contact.seto_telephone(cursor.getString(36));
                contact.seto_mobile(cursor.getString(37));
                contact.seto_email(cursor.getString(38));
                contact.seto_skype(cursor.getString(39));
                contact.seto_facebook(cursor.getString(40));
                contact.seto_twitter(cursor.getString(41));
                contact.seto_language(cursor.getString(42));

                contact.setfdb_time(cursor.getString(43));
                contact.setfdb_where(cursor.getString(44));
                contact.setfdl_time(cursor.getString(45));
                contact.setfdl_where(cursor.getString(46));
                contact.setfdd_time(cursor.getString(47));
                contact.setfdd_where(cursor.getString(48));
                contact.settrt_name(cursor.getString(49));
                contact.settrt_phone(cursor.getString(50));
                contact.settrt_address(cursor.getString(51));
                contact.settrt_address_address(cursor.getString(52));
                contact.settrt_address_lat(cursor.getString(53));
                contact.settrt_address_lng(cursor.getString(54));
                contact.settrt_website(cursor.getString(55));
                contact.settrt_email(cursor.getString(56));
                contact.settrc_name(cursor.getString(57));
                contact.settrc_phone(cursor.getString(58));
                contact.settrc_address(cursor.getString(59));
                contact.settrc_website(cursor.getString(60));
                contact.settrc_email(cursor.getString(61));

                contact.settrb_name(cursor.getString(62));
                contact.settrb_phone(cursor.getString(63));
                contact.settrb_address(cursor.getString(64));
                contact.settrb_website(cursor.getString(65));
                contact.settrb_email(cursor.getString(66));
                contact.settrm_name(cursor.getString(67));
                contact.settrm_phone(cursor.getString(68));
                contact.settrm_address(cursor.getString(69));
                contact.settrm_website(cursor.getString(70));
                contact.settrm_email(cursor.getString(71));
                contact.settrp_bus(cursor.getString(72));
                contact.settrp_metro(cursor.getString(73));
                contact.settrp_train(cursor.getString(74));
                contact.settrair_name(cursor.getString(75));
                contact.settrair_phone(cursor.getString(76));
                contact.settrair_address(cursor.getString(77));
                contact.settrair_address_address(cursor.getString(78));
                contact.settrair_address_lat(cursor.getString(79));
                contact.settrair_address_lng(cursor.getString(80));
                contact.settrair_website(cursor.getString(81));
                contact.settrair_email(cursor.getString(82));
                contact.setmoatm_address(cursor.getString(83));
                contact.setser_checkintime(cursor.getString(84));
                contact.setser_checkouttime(cursor.getString(85));
                contact.setattr_repeat(cursor.getString(86));
                contact.setattr_repeat_0_attr_name(cursor.getString(87));
                contact.setattr_repeat_0_attr_website(cursor.getString(88));
                contact.setattr_repeat_0_attr_picture(cursor.getString(89));
                contact.setattr_repeat_0_attr_descript(cursor.getString(90));
                contact.setattr_repeat_1_attr_name(cursor.getString(91));
                contact.setattr_repeat_1_attr_website(cursor.getString(92));
                contact.setattr_repeat_1_attr_picture(cursor.getString(93));
                contact.setattr_repeat_1_attr_descript(cursor.getString(94));
                contact.setser_atm_address(cursor.getString(95));
                contact.setser_atm_location(cursor.getString(96));
                contact.setser_atm_location_address(cursor.getString(97));
                contact.setser_atm_location_lat(cursor.getString(98));
                contact.setser_atm_location_lng(cursor.getString(99));
                contact.setser_wifi_pass(cursor.getString(100));
                contact.setser_wifi_details(cursor.getString(101));
                contact.setser_park_details(cursor.getString(102));
                contact.setser_park_map(cursor.getString(103));
                contact.setser_park_map_address(cursor.getString(104));
                contact.setser_park_map_address_lat(cursor.getString(105));
                contact.setser_park_map_address_lng(cursor.getString(106));
                contact.setser_tv_details(cursor.getString(107));


                contact.setem_general(cursor.getString(108));
                contact.setem_fire(cursor.getString(109));
                contact.setem_ambulance(cursor.getString(110));
                contact.setem_police(cursor.getString(111));
                contact.setem_assistance(cursor.getString(112));
                contact.setem_docter_name(cursor.getString(113));
                contact.setem_docter_telephone(cursor.getString(114));
                contact.setem_docter_address(cursor.getString(115));
                contact.setem_docter_address_address(cursor.getString(116));
                contact.setem_docter_address_lat(cursor.getString(117));
                contact.setem_docter_address_lng(cursor.getString(118));
                contact.setem_pharmacy_name(cursor.getString(119));
                contact.setem_pharmacy_telephone(cursor.getString(120));
                contact.setem_pharmacy_address(cursor.getString(121));
                contact.setem_pharmacy_address_address(cursor.getString(122));
                contact.setem_pharmacy_address_lat(cursor.getString(123));
                contact.setem_pharmacy_address_lng(cursor.getString(124));
                contact.setrsb(cursor.getString(125));
                contact.setent_0_ent_type(cursor.getString(126));
                contact.setent_0_ent_name(cursor.getString(127));
                contact.setent_0_ent_website(cursor.getString(128));
                contact.setent_0_ent_phone(cursor.getString(129));
                contact.setent_0_ent_map(cursor.getString(130));
                contact.setent_0_ent_map_address(cursor.getString(131));
                contact.setent_0_ent_map_lat(cursor.getString(132));
                contact.setent_0_ent_map_lng(cursor.getString(133));
                contact.setent(cursor.getString(134));
                contact.setrsb_0_rbs_type(cursor.getString(135));
                contact.setrsb_0_rbs_name(cursor.getString(136));
                contact.setrsb_0_rbs_website(cursor.getString(137));
                contact.setrsb_0_rbs_phone(cursor.getString(138));
                contact.setrsb_0_rbs_map(cursor.getString(139));
                contact.setrsb_0_rbs_map_address(cursor.getString(140));
                contact.setrsb_0_rbs_map_lat(cursor.getString(141));
                contact.setrsb_0_rbs_map_lng(cursor.getString(142));
                contact.setrsb_1_rbs_type(cursor.getString(143));
                contact.setrsb_1_rbs_name(cursor.getString(144));
                contact.setrsb_1_rbs_website(cursor.getString(145));
                contact.setrsb_1_rbs_phone(cursor.getString(146));
                contact.setrsb_1_rbs_map(cursor.getString(147));
                contact.setrsb_1_rbs_map_address(cursor.getString(148));
                contact.setrsb_1_rbs_map_lat(cursor.getString(149));
                contact.setrsb_1_rbs_map_lng(cursor.getString(150));
                contact.setrsb_2_rbs_type(cursor.getString(151));
                contact.setrsb_2_rbs_name(cursor.getString(152));
                contact.setrsb_2_rbs_website(cursor.getString(153));
                contact.setrsb_2_rbs_phone(cursor.getString(154));
                contact.setrsb_2_rbs_map(cursor.getString(155));
                contact.setrsb_2_rbs_map_address(cursor.getString(156));
                contact.setrsb_2_rbs_map_lat(cursor.getString(157));
                contact.setrsb_2_rbs_map_lng(cursor.getString(158));
                contact.setattr_repeat_0_attr_map(cursor.getString(159));
                contact.setattr_repeat_0_attr_map_address(cursor.getString(160));
                contact.setattr_repeat_0_attr_map_lat(cursor.getString(161));
                contact.setattr_repeat_0_attr_maplng(cursor.getString(162));
                contact.setattr_repeat_1_attr_map(cursor.getString(163));
                contact.setattr_repeat_1_attr_map_address(cursor.getString(164));
                contact.setattr_repeat_1_attr_map_lat(cursor.getString(165));
                contact.setattr_repeat_1_attr_map_lng(cursor.getString(166));
                contact.setcom_laun_details(cursor.getString(167));
                contact.setcom_lug_details(cursor.getString(168));
                contact.setcom_hair_details(cursor.getString(169));
                contact.setcom_ct_details(cursor.getString(170));
                contact.setcom_room_details(cursor.getString(171));


                contact.seta_logo_image(cursor.getString(172));
                contact.seta_picture_image(cursor.getString(173));


                contact.setattr_repeat_2_attr_name(cursor.getString(174));
                contact.setattr_repeat_2_attr_website(cursor.getString(175));
                contact.setattr_repeat_2_attr_picture(cursor.getString(176));
                contact.setattr_repeat_2_attr_descript(cursor.getString(177));
                contact.setattr_repeat_2_attr_map(cursor.getString(178));
                contact.setattr_repeat_2_attr_map_address(cursor.getString(179));
                contact.setattr_repeat_2_attr_map_lat(cursor.getString(180));
                contact.setattr_repeat_2_attr_map_lng(cursor.getString(181));
                contact.setattr_repeat_3_attr_name(cursor.getString(182));
                contact.setattr_repeat_3_attr_website(cursor.getString(183));
                contact.setattr_repeat_3_attr_picture(cursor.getString(184));
                contact.setattr_repeat_3_attr_descript(cursor.getString(185));
                contact.setattr_repeat_3_attr_map(cursor.getString(186));
                contact.setattr_repeat_3_attr_map_address(cursor.getString(187));
                contact.setattr_repeat_3_attr_map_lat(cursor.getString(188));
                contact.setattr_repeat_3_attr_map_lng(cursor.getString(189));
                contact.setattr_repeat_4_attr_name(cursor.getString(190));
                contact.setattr_repeat_4_attr_website(cursor.getString(191));
                contact.setattr_repeat_4_attr_picture(cursor.getString(192));
                contact.setattr_repeat_4_attr_descript(cursor.getString(193));
                contact.setattr_repeat_4_attr_map(cursor.getString(194));
                contact.setattr_repeat_4_attr_map_address(cursor.getString(195));
                contact.setattr_repeat_4_attr_map_lat(cursor.getString(196));
                contact.setattr_repeat_4_attr_map_lng(cursor.getString(197));
                contact.setent_1_ent_type(cursor.getString(198));
                contact.setent_1_ent_name(cursor.getString(199));
                contact.setent_1_ent_website(cursor.getString(200));
                contact.setent_1_ent_phone(cursor.getString(201));
                contact.setent_1_ent_map(cursor.getString(202));
                contact.setent_1_ent_map_address(cursor.getString(203));
                contact.setent_1_ent_map_lat(cursor.getString(204));
                contact.setent_1_ent_map_lng(cursor.getString(205));
                contact.setent_2_ent_type(cursor.getString(206));
                contact.setent_2_ent_name(cursor.getString(207));
                contact.setent_2_ent_website(cursor.getString(208));
                contact.setent_2_ent_phone(cursor.getString(209));
                contact.setent_2_ent_map(cursor.getString(210));
                contact.setent_2_ent_map_address(cursor.getString(211));
                contact.setent_2_ent_map_lat(cursor.getString(212));
                contact.setent_2_ent_map_lng(cursor.getString(213));
                contact.setent_3_ent_type(cursor.getString(214));
                contact.setent_3_ent_name(cursor.getString(215));
                contact.setent_3_ent_website(cursor.getString(216));
                contact.setent_3_ent_phone(cursor.getString(217));
                contact.setent_3_ent_map(cursor.getString(218));
                contact.setent_3_ent_map_address(cursor.getString(219));
                contact.setent_3_ent_map_lat(cursor.getString(220));
                contact.setent_3_ent_map_lng(cursor.getString(221));
                contact.setent_4_ent_type(cursor.getString(222));
                contact.setent_4_ent_name(cursor.getString(223));
                contact.setent_4_ent_website(cursor.getString(224));
                contact.setent_4_ent_phone(cursor.getString(225));
                contact.setent_4_ent_map(cursor.getString(226));
                contact.setent_4_ent_map_address(cursor.getString(227));
                contact.setent_4_ent_map_lat(cursor.getString(228));
                contact.setent_4_ent_map_lng(cursor.getString(229));
                contact.setent_5_ent_type(cursor.getString(230));
                contact.setent_5_ent_name(cursor.getString(231));
                contact.setent_5_ent_website(cursor.getString(232));
                contact.setent_5_ent_phone(cursor.getString(233));
                contact.setent_5_ent_map(cursor.getString(234));
                contact.setent_5_ent_map_address(cursor.getString(235));
                contact.setent_5_ent_map_lat(cursor.getString(236));
                contact.setent_5_ent_map_lng(cursor.getString(237));
                contact.setent_6_ent_type(cursor.getString(238));
                contact.setent_6_ent_name(cursor.getString(239));
                contact.setent_6_ent_website(cursor.getString(240));
                contact.setent_6_ent_phone(cursor.getString(241));
                contact.setent_6_ent_map(cursor.getString(242));
                contact.setent_6_ent_map_address(cursor.getString(243));
                contact.setent_6_ent_map_lat(cursor.getString(244));
                contact.setent_6_ent_map_lng(cursor.getString(245));
                contact.setent_7_ent_type(cursor.getString(246));
                contact.setent_7_ent_name(cursor.getString(247));
                contact.setent_7_ent_website(cursor.getString(248));
                contact.setent_7_ent_phone(cursor.getString(249));
                contact.setent_7_ent_map(cursor.getString(250));
                contact.setent_7_ent_map_address(cursor.getString(251));
                contact.setent_7_ent_map_lat(cursor.getString(252));
                contact.setent_7_ent_map_lng(cursor.getString(253));
                contact.setent_8_ent_type(cursor.getString(254));
                contact.setent_8_ent_name(cursor.getString(255));
                contact.setent_8_ent_website(cursor.getString(256));
                contact.setent_8_ent_phone(cursor.getString(257));
                contact.setent_8_ent_map(cursor.getString(258));
                contact.setent_8_ent_map_address(cursor.getString(259));
                contact.setent_8_ent_map_lat(cursor.getString(260));
                contact.setent_8_ent_map_lng(cursor.getString(261));
                contact.setrsb_3_rbs_type(cursor.getString(262));
                contact.setrsb_3_rbs_name(cursor.getString(263));
                contact.setrsb_3_rbs_website(cursor.getString(264));
                contact.setrsb_3_rbs_phone(cursor.getString(265));
                contact.setrsb_3_rbs_map(cursor.getString(266));
                contact.setrsb_3_rbs_map_address(cursor.getString(267));
                contact.setrsb_3_rbs_map_lat(cursor.getString(268));
                contact.setrsb_3_rbs_map_lng(cursor.getString(269));
                contact.setrsb_4_rbs_type(cursor.getString(270));
                contact.setrsb_4_rbs_name(cursor.getString(271));
                contact.setrsb_4_rbs_website(cursor.getString(272));
                contact.setrsb_4_rbs_phone(cursor.getString(273));
                contact.setrsb_4_rbs_map(cursor.getString(274));
                contact.setrsb_4_rbs_map_address(cursor.getString(275));
                contact.setrsb_4_rbs_map_lat(cursor.getString(276));
                contact.setrsb_4_rbs_map_lng(cursor.getString(277));
                contact.setrsb_5_rbs_type(cursor.getString(278));
                contact.setrsb_5_rbs_name(cursor.getString(279));
                contact.setrsb_5_rbs_website(cursor.getString(280));
                contact.setrsb_5_rbs_phone(cursor.getString(281));
                contact.setrsb_5_rbs_map(cursor.getString(282));
                contact.setrsb_5_rbs_map_address(cursor.getString(283));
                contact.setrsb_5_rbs_map_lat(cursor.getString(284));
                contact.setrsb_5_rbs_map_lng(cursor.getString(285));
                contact.setrsb_6_rbs_type(cursor.getString(286));
                contact.setrsb_6_rbs_name(cursor.getString(287));
                contact.setrsb_6_rbs_website(cursor.getString(288));
                contact.setrsb_6_rbs_phone(cursor.getString(289));
                contact.setrsb_6_rbs_map(cursor.getString(290));
                contact.setrsb_6_rbs_map_address(cursor.getString(291));
                contact.setrsb_6_rbs_map_lat(cursor.getString(292));
                contact.setrsb_6_rbs_map_lng(cursor.getString(293));
                contact.setrsb_7_rbs_type(cursor.getString(294));
                contact.setrsb_7_rbs_name(cursor.getString(295));
                contact.setrsb_7_rbs_website(cursor.getString(296));
                contact.setrsb_7_rbs_phone(cursor.getString(297));
                contact.setrsb_7_rbs_map(cursor.getString(298));
                contact.setrsb_7_rbs_map_address(cursor.getString(299));
                contact.setrsb_7_rbs_map_lat(cursor.getString(300));
                contact.setrsb_7_rbs_map_lng(cursor.getString(301));
                contact.setrsb_8_rbs_type(cursor.getString(302));
                contact.setrsb_8_rbs_name(cursor.getString(303));
                contact.setrsb_8_rbs_website(cursor.getString(304));
                contact.setrsb_8_rbs_phone(cursor.getString(305));
                contact.setrsb_8_rbs_map(cursor.getString(306));
                contact.setrsb_8_rbs_map_address(cursor.getString(307));
                contact.setrsb_8_rbs_map_lat(cursor.getString(308));
                contact.setrsb_8_rbs_map_lng(cursor.getString(309));
                contact.setname(cursor.getString(310));
                contact.setattr_repeat_0_attr_picture_image(cursor.getString(311));
                contact.setattr_repeat_1_attr_picture_image(cursor.getString(312));
                contact.setattr_repeat_2_attr_picture_image(cursor.getString(313));
                contact.setattr_repeat_3_attr_picture_image(cursor.getString(314));
                contact.setattr_repeat_4_attr_picture_image(cursor.getString(315));

                contact.settrc_address_address(cursor.getString(316));
                contact.settrc_address_address_lat(cursor.getString(317));
                contact.settrc_address_address_lng(cursor.getString(318));

                contact.settrb_address_address(cursor.getString(319));
                contact.settrb_address_address_lat(cursor.getString(320));
                contact.settrb_address_address_lng(cursor.getString(321));

                contact.settrm_address_address(cursor.getString(322));
                contact.settrm_address_address_lat(cursor.getString(323));
                contact.settrm_address_address_lng(cursor.getString(324));


                contacts.add(contact);
            }
        }

        // return contact list
        cursor.close();
        database.close();

        return contacts;
    }
    /*done*/


    /*done*/
    // Getting All Contacts Alternate
    public ArrayList<Contact> Get_ContactsAlternate() {
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<Contact> contacts = new ArrayList<Contact>();
        Contact contact;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();

                contact = new Contact();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setPOST_ID(cursor.getString(1));
                contact.seta_welcome(cursor.getString(2));
                contact.seta_logo(cursor.getString(3));
                contact.seta_picture(cursor.getString(4));
                contact.seta_address(cursor.getString(5));
                contact.seta_zip(cursor.getString(6));
                contact.seta_town(cursor.getString(7));
                contact.seta_country(cursor.getString(8));
                contact.seta_map(cursor.getString(9));
                contact.seta_map_address(cursor.getString(10));
                contact.seta_map_address_lat(cursor.getString(11));
                contact.seta_map_address_lng(cursor.getString(12));
                contact.seta_website(cursor.getString(13));
                contact.seta_telephone(cursor.getString(14));
                contact.seta_facebook(cursor.getString(15));
                contact.seta_twitter(cursor.getString(16));

                contact.setl_firstname(cursor.getString(17));
                contact.setl_lastname(cursor.getString(18));
                contact.setl_address(cursor.getString(19));
                contact.setl_zip(cursor.getString(20));
                contact.setl_town(cursor.getString(21));
                contact.setl_country(cursor.getString(22));
                contact.setl_telephone(cursor.getString(23));
                contact.setl_mobile(cursor.getString(24));
                contact.setl_email(cursor.getString(25));
                contact.setl_skype(cursor.getString(26));
                contact.setl_facebook(cursor.getString(27));
                contact.setl_twitter(cursor.getString(28));
                contact.setl_language(cursor.getString(29));

                contact.seto_firstname(cursor.getString(30));
                contact.seto_lastname(cursor.getString(31));
                contact.seto_address(cursor.getString(32));
                contact.seto_zip(cursor.getString(33));
                contact.seto_town(cursor.getString(34));
                contact.seto_country(cursor.getString(35));
                contact.seto_telephone(cursor.getString(36));
                contact.seto_mobile(cursor.getString(37));
                contact.seto_email(cursor.getString(38));
                contact.seto_skype(cursor.getString(39));
                contact.seto_facebook(cursor.getString(40));
                contact.seto_twitter(cursor.getString(41));
                contact.seto_language(cursor.getString(42));

                contact.setfdb_time(cursor.getString(43));
                contact.setfdb_where(cursor.getString(44));
                contact.setfdl_time(cursor.getString(45));
                contact.setfdl_where(cursor.getString(46));
                contact.setfdd_time(cursor.getString(47));
                contact.setfdd_where(cursor.getString(48));
                contact.settrt_name(cursor.getString(49));
                contact.settrt_phone(cursor.getString(50));
                contact.settrt_address(cursor.getString(51));
                contact.settrt_address_address(cursor.getString(52));
                contact.settrt_address_lat(cursor.getString(53));
                contact.settrt_address_lng(cursor.getString(54));
                contact.settrt_website(cursor.getString(55));
                contact.settrt_email(cursor.getString(56));
                contact.settrc_name(cursor.getString(57));
                contact.settrc_phone(cursor.getString(58));
                contact.settrc_address(cursor.getString(59));
                contact.settrc_website(cursor.getString(60));
                contact.settrc_email(cursor.getString(61));

                contact.settrb_name(cursor.getString(62));
                contact.settrb_phone(cursor.getString(63));
                contact.settrb_address(cursor.getString(64));
                contact.settrb_website(cursor.getString(65));
                contact.settrb_email(cursor.getString(66));
                contact.settrm_name(cursor.getString(67));
                contact.settrm_phone(cursor.getString(68));
                contact.settrm_address(cursor.getString(69));
                contact.settrm_website(cursor.getString(70));
                contact.settrm_email(cursor.getString(71));
                contact.settrp_bus(cursor.getString(72));
                contact.settrp_metro(cursor.getString(73));
                contact.settrp_train(cursor.getString(74));
                contact.settrair_name(cursor.getString(75));
                contact.settrair_phone(cursor.getString(76));
                contact.settrair_address(cursor.getString(77));
                contact.settrair_address_address(cursor.getString(78));
                contact.settrair_address_lat(cursor.getString(79));
                contact.settrair_address_lng(cursor.getString(80));
                contact.settrair_website(cursor.getString(81));
                contact.settrair_email(cursor.getString(82));
                contact.setmoatm_address(cursor.getString(83));
                contact.setser_checkintime(cursor.getString(84));
                contact.setser_checkouttime(cursor.getString(85));
                contact.setattr_repeat(cursor.getString(86));
                contact.setattr_repeat_0_attr_name(cursor.getString(87));
                contact.setattr_repeat_0_attr_website(cursor.getString(88));
                contact.setattr_repeat_0_attr_picture(cursor.getString(89));
                contact.setattr_repeat_0_attr_descript(cursor.getString(90));
                contact.setattr_repeat_1_attr_name(cursor.getString(91));
                contact.setattr_repeat_1_attr_website(cursor.getString(92));
                contact.setattr_repeat_1_attr_picture(cursor.getString(93));
                contact.setattr_repeat_1_attr_descript(cursor.getString(94));
                contact.setser_atm_address(cursor.getString(95));
                contact.setser_atm_location(cursor.getString(96));
                contact.setser_atm_location_address(cursor.getString(97));
                contact.setser_atm_location_lat(cursor.getString(98));
                contact.setser_atm_location_lng(cursor.getString(99));
                contact.setser_wifi_pass(cursor.getString(100));
                contact.setser_wifi_details(cursor.getString(101));
                contact.setser_park_details(cursor.getString(102));
                contact.setser_park_map(cursor.getString(103));
                contact.setser_park_map_address(cursor.getString(104));
                contact.setser_park_map_address_lat(cursor.getString(105));
                contact.setser_park_map_address_lng(cursor.getString(106));
                contact.setser_tv_details(cursor.getString(107));


                contact.setem_general(cursor.getString(108));
                contact.setem_fire(cursor.getString(109));
                contact.setem_ambulance(cursor.getString(110));
                contact.setem_police(cursor.getString(111));
                contact.setem_assistance(cursor.getString(112));
                contact.setem_docter_name(cursor.getString(113));
                contact.setem_docter_telephone(cursor.getString(114));
                contact.setem_docter_address(cursor.getString(115));
                contact.setem_docter_address_address(cursor.getString(116));
                contact.setem_docter_address_lat(cursor.getString(117));
                contact.setem_docter_address_lng(cursor.getString(118));
                contact.setem_pharmacy_name(cursor.getString(119));
                contact.setem_pharmacy_telephone(cursor.getString(120));
                contact.setem_pharmacy_address(cursor.getString(121));
                contact.setem_pharmacy_address_address(cursor.getString(122));
                contact.setem_pharmacy_address_lat(cursor.getString(123));
                contact.setem_pharmacy_address_lng(cursor.getString(124));
                contact.setrsb(cursor.getString(125));
                contact.setent_0_ent_type(cursor.getString(126));
                contact.setent_0_ent_name(cursor.getString(127));
                contact.setent_0_ent_website(cursor.getString(128));
                contact.setent_0_ent_phone(cursor.getString(129));
                contact.setent_0_ent_map(cursor.getString(130));
                contact.setent_0_ent_map_address(cursor.getString(131));
                contact.setent_0_ent_map_lat(cursor.getString(132));
                contact.setent_0_ent_map_lng(cursor.getString(133));
                contact.setent(cursor.getString(134));
                contact.setrsb_0_rbs_type(cursor.getString(135));
                contact.setrsb_0_rbs_name(cursor.getString(136));
                contact.setrsb_0_rbs_website(cursor.getString(137));
                contact.setrsb_0_rbs_phone(cursor.getString(138));
                contact.setrsb_0_rbs_map(cursor.getString(139));
                contact.setrsb_0_rbs_map_address(cursor.getString(140));
                contact.setrsb_0_rbs_map_lat(cursor.getString(141));
                contact.setrsb_0_rbs_map_lng(cursor.getString(142));
                contact.setrsb_1_rbs_type(cursor.getString(143));
                contact.setrsb_1_rbs_name(cursor.getString(144));
                contact.setrsb_1_rbs_website(cursor.getString(145));
                contact.setrsb_1_rbs_phone(cursor.getString(146));
                contact.setrsb_1_rbs_map(cursor.getString(147));
                contact.setrsb_1_rbs_map_address(cursor.getString(148));
                contact.setrsb_1_rbs_map_lat(cursor.getString(149));
                contact.setrsb_1_rbs_map_lng(cursor.getString(150));
                contact.setrsb_2_rbs_type(cursor.getString(151));
                contact.setrsb_2_rbs_name(cursor.getString(152));
                contact.setrsb_2_rbs_website(cursor.getString(153));
                contact.setrsb_2_rbs_phone(cursor.getString(154));
                contact.setrsb_2_rbs_map(cursor.getString(155));
                contact.setrsb_2_rbs_map_address(cursor.getString(156));
                contact.setrsb_2_rbs_map_lat(cursor.getString(157));
                contact.setrsb_2_rbs_map_lng(cursor.getString(158));
                contact.setattr_repeat_0_attr_map(cursor.getString(159));
                contact.setattr_repeat_0_attr_map_address(cursor.getString(160));
                contact.setattr_repeat_0_attr_map_lat(cursor.getString(161));
                contact.setattr_repeat_0_attr_maplng(cursor.getString(162));
                contact.setattr_repeat_1_attr_map(cursor.getString(163));
                contact.setattr_repeat_1_attr_map_address(cursor.getString(164));
                contact.setattr_repeat_1_attr_map_lat(cursor.getString(165));
                contact.setattr_repeat_1_attr_map_lng(cursor.getString(166));
                contact.setcom_laun_details(cursor.getString(167));
                contact.setcom_lug_details(cursor.getString(168));
                contact.setcom_hair_details(cursor.getString(169));
                contact.setcom_ct_details(cursor.getString(170));
                contact.setcom_room_details(cursor.getString(171));


                contact.seta_logo_image(cursor.getString(172));
                contact.seta_picture_image(cursor.getString(173));


                contact.setattr_repeat_2_attr_name(cursor.getString(174));
                contact.setattr_repeat_2_attr_website(cursor.getString(175));
                contact.setattr_repeat_2_attr_picture(cursor.getString(176));
                contact.setattr_repeat_2_attr_descript(cursor.getString(177));
                contact.setattr_repeat_2_attr_map(cursor.getString(178));
                contact.setattr_repeat_2_attr_map_address(cursor.getString(179));
                contact.setattr_repeat_2_attr_map_lat(cursor.getString(180));
                contact.setattr_repeat_2_attr_map_lng(cursor.getString(181));
                contact.setattr_repeat_3_attr_name(cursor.getString(182));
                contact.setattr_repeat_3_attr_website(cursor.getString(183));
                contact.setattr_repeat_3_attr_picture(cursor.getString(184));
                contact.setattr_repeat_3_attr_descript(cursor.getString(185));
                contact.setattr_repeat_3_attr_map(cursor.getString(186));
                contact.setattr_repeat_3_attr_map_address(cursor.getString(187));
                contact.setattr_repeat_3_attr_map_lat(cursor.getString(188));
                contact.setattr_repeat_3_attr_map_lng(cursor.getString(189));
                contact.setattr_repeat_4_attr_name(cursor.getString(190));
                contact.setattr_repeat_4_attr_website(cursor.getString(191));
                contact.setattr_repeat_4_attr_picture(cursor.getString(192));
                contact.setattr_repeat_4_attr_descript(cursor.getString(193));
                contact.setattr_repeat_4_attr_map(cursor.getString(194));
                contact.setattr_repeat_4_attr_map_address(cursor.getString(195));
                contact.setattr_repeat_4_attr_map_lat(cursor.getString(196));
                contact.setattr_repeat_4_attr_map_lng(cursor.getString(197));
                contact.setent_1_ent_type(cursor.getString(198));
                contact.setent_1_ent_name(cursor.getString(199));
                contact.setent_1_ent_website(cursor.getString(200));
                contact.setent_1_ent_phone(cursor.getString(201));
                contact.setent_1_ent_map(cursor.getString(202));
                contact.setent_1_ent_map_address(cursor.getString(203));
                contact.setent_1_ent_map_lat(cursor.getString(204));
                contact.setent_1_ent_map_lng(cursor.getString(205));
                contact.setent_2_ent_type(cursor.getString(206));
                contact.setent_2_ent_name(cursor.getString(207));
                contact.setent_2_ent_website(cursor.getString(208));
                contact.setent_2_ent_phone(cursor.getString(209));
                contact.setent_2_ent_map(cursor.getString(210));
                contact.setent_2_ent_map_address(cursor.getString(211));
                contact.setent_2_ent_map_lat(cursor.getString(212));
                contact.setent_2_ent_map_lng(cursor.getString(213));
                contact.setent_3_ent_type(cursor.getString(214));
                contact.setent_3_ent_name(cursor.getString(215));
                contact.setent_3_ent_website(cursor.getString(216));
                contact.setent_3_ent_phone(cursor.getString(217));
                contact.setent_3_ent_map(cursor.getString(218));
                contact.setent_3_ent_map_address(cursor.getString(219));
                contact.setent_3_ent_map_lat(cursor.getString(220));
                contact.setent_3_ent_map_lng(cursor.getString(221));
                contact.setent_4_ent_type(cursor.getString(222));
                contact.setent_4_ent_name(cursor.getString(223));
                contact.setent_4_ent_website(cursor.getString(224));
                contact.setent_4_ent_phone(cursor.getString(2245));
                contact.setent_4_ent_map(cursor.getString(226));
                contact.setent_4_ent_map_address(cursor.getString(227));
                contact.setent_4_ent_map_lat(cursor.getString(228));
                contact.setent_4_ent_map_lng(cursor.getString(229));
                contact.setent_5_ent_type(cursor.getString(230));
                contact.setent_5_ent_name(cursor.getString(231));
                contact.setent_5_ent_website(cursor.getString(232));
                contact.setent_5_ent_phone(cursor.getString(233));
                contact.setent_5_ent_map(cursor.getString(234));
                contact.setent_5_ent_map_address(cursor.getString(235));
                contact.setent_5_ent_map_lat(cursor.getString(236));
                contact.setent_5_ent_map_lng(cursor.getString(237));
                contact.setent_6_ent_type(cursor.getString(238));
                contact.setent_6_ent_name(cursor.getString(239));
                contact.setent_6_ent_website(cursor.getString(240));
                contact.setent_6_ent_phone(cursor.getString(241));
                contact.setent_6_ent_map(cursor.getString(242));
                contact.setent_6_ent_map_address(cursor.getString(243));
                contact.setent_6_ent_map_lat(cursor.getString(244));
                contact.setent_6_ent_map_lng(cursor.getString(245));
                contact.setent_7_ent_type(cursor.getString(246));
                contact.setent_7_ent_name(cursor.getString(247));
                contact.setent_7_ent_website(cursor.getString(248));
                contact.setent_7_ent_phone(cursor.getString(249));
                contact.setent_7_ent_map(cursor.getString(250));
                contact.setent_7_ent_map_address(cursor.getString(251));
                contact.setent_7_ent_map_lat(cursor.getString(252));
                contact.setent_7_ent_map_lng(cursor.getString(253));
                contact.setent_8_ent_type(cursor.getString(254));
                contact.setent_8_ent_name(cursor.getString(255));
                contact.setent_8_ent_website(cursor.getString(256));
                contact.setent_8_ent_phone(cursor.getString(257));
                contact.setent_8_ent_map(cursor.getString(258));
                contact.setent_8_ent_map_address(cursor.getString(259));
                contact.setent_8_ent_map_lat(cursor.getString(260));
                contact.setent_8_ent_map_lng(cursor.getString(261));
                contact.setrsb_3_rbs_type(cursor.getString(262));
                contact.setrsb_3_rbs_name(cursor.getString(263));
                contact.setrsb_3_rbs_website(cursor.getString(264));
                contact.setrsb_3_rbs_phone(cursor.getString(265));
                contact.setrsb_3_rbs_map(cursor.getString(266));
                contact.setrsb_3_rbs_map_address(cursor.getString(267));
                contact.setrsb_3_rbs_map_lat(cursor.getString(268));
                contact.setrsb_3_rbs_map_lng(cursor.getString(269));
                contact.setrsb_4_rbs_type(cursor.getString(270));
                contact.setrsb_4_rbs_name(cursor.getString(271));
                contact.setrsb_4_rbs_website(cursor.getString(272));
                contact.setrsb_4_rbs_phone(cursor.getString(273));
                contact.setrsb_4_rbs_map(cursor.getString(274));
                contact.setrsb_4_rbs_map_address(cursor.getString(275));
                contact.setrsb_4_rbs_map_lat(cursor.getString(276));
                contact.setrsb_4_rbs_map_lng(cursor.getString(277));
                contact.setrsb_5_rbs_type(cursor.getString(278));
                contact.setrsb_5_rbs_name(cursor.getString(279));
                contact.setrsb_5_rbs_website(cursor.getString(280));
                contact.setrsb_5_rbs_phone(cursor.getString(281));
                contact.setrsb_5_rbs_map(cursor.getString(282));
                contact.setrsb_5_rbs_map_address(cursor.getString(283));
                contact.setrsb_5_rbs_map_lat(cursor.getString(284));
                contact.setrsb_5_rbs_map_lng(cursor.getString(285));
                contact.setrsb_6_rbs_type(cursor.getString(286));
                contact.setrsb_6_rbs_name(cursor.getString(287));
                contact.setrsb_6_rbs_website(cursor.getString(288));
                contact.setrsb_6_rbs_phone(cursor.getString(289));
                contact.setrsb_6_rbs_map(cursor.getString(290));
                contact.setrsb_6_rbs_map_address(cursor.getString(291));
                contact.setrsb_6_rbs_map_lat(cursor.getString(292));
                contact.setrsb_6_rbs_map_lng(cursor.getString(293));
                contact.setrsb_7_rbs_type(cursor.getString(294));
                contact.setrsb_7_rbs_name(cursor.getString(295));
                contact.setrsb_7_rbs_website(cursor.getString(296));
                contact.setrsb_7_rbs_phone(cursor.getString(297));
                contact.setrsb_7_rbs_map(cursor.getString(298));
                contact.setrsb_7_rbs_map_address(cursor.getString(299));
                contact.setrsb_7_rbs_map_lat(cursor.getString(300));
                contact.setrsb_7_rbs_map_lng(cursor.getString(301));
                contact.setrsb_8_rbs_type(cursor.getString(302));
                contact.setrsb_8_rbs_name(cursor.getString(303));
                contact.setrsb_8_rbs_website(cursor.getString(304));
                contact.setrsb_8_rbs_phone(cursor.getString(305));
                contact.setrsb_8_rbs_map(cursor.getString(306));
                contact.setrsb_8_rbs_map_address(cursor.getString(307));
                contact.setrsb_8_rbs_map_lat(cursor.getString(308));
                contact.setrsb_8_rbs_map_lng(cursor.getString(309));
                contact.setname(cursor.getString(310));
                contact.setattr_repeat_0_attr_picture_image(cursor.getString(311));
                contact.setattr_repeat_1_attr_picture_image(cursor.getString(312));
                contact.setattr_repeat_2_attr_picture_image(cursor.getString(313));
                contact.setattr_repeat_3_attr_picture_image(cursor.getString(314));
                contact.setattr_repeat_4_attr_picture_image(cursor.getString(315));

                contact.settrc_address_address(cursor.getString(316));
                contact.settrc_address_address_lat(cursor.getString(317));
                contact.settrc_address_address_lng(cursor.getString(318));

                contact.settrb_address_address(cursor.getString(319));
                contact.settrb_address_address_lat(cursor.getString(320));
                contact.settrb_address_address_lng(cursor.getString(321));

                contact.settrm_address_address(cursor.getString(322));
                contact.settrm_address_address_lat(cursor.getString(323));
                contact.settrm_address_address_lng(cursor.getString(324));

                contacts.add(contact);
            }
        }
        cursor.close();
        database.close();

        return contacts;
    }
    /*done*/


    /*done*/
    // Updating single contact
    public void Update_Contact(Contact contact) {
        database = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_POST_ID, contact.getPOST_ID());
        values.put(COLUMN_a_welcome, contact.geta_welcome());
        values.put(COLUMN_a_logo, contact.geta_logo());
        values.put(COLUMN_a_picture, contact.geta_picture());
        values.put(COLUMN_a_address, contact.geta_address());
        values.put(COLUMN_a_zip, contact.geta_zip());
        values.put(COLUMN_a_town, contact.geta_town());
        values.put(COLUMN_a_country, contact.geta_country());
        values.put(COLUMN_a_map, contact.geta_map());
        values.put(COLUMN_a_map_address, contact.geta_map_address());
        values.put(COLUMN_a_map_address_lng, contact.geta_map_address_lng());
        values.put(COLUMN_a_map_address_lat, contact.geta_map_address_lat());
        values.put(COLUMN_a_website, contact.geta_website());
        values.put(COLUMN_a_telephone, contact.geta_telephone());
        values.put(COLUMN_a_facebook, contact.geta_facebook());
        values.put(COLUMN_a_twitter, contact.geta_twitter());

        values.put(COLUMN_l_firstname, contact.getl_firstname());
        values.put(COLUMN_l_lastname, contact.getl_lastname());
        values.put(COLUMN_l_address, contact.getl_address());
        values.put(COLUMN_l_zip, contact.getl_zip());
        values.put(COLUMN_l_town, contact.getl_town());
        values.put(COLUMN_l_country, contact.getl_country());
        values.put(COLUMN_l_telephone, contact.getl_telephone());
        values.put(COLUMN_l_mobile, contact.getl_mobile());
        values.put(COLUMN_l_email, contact.getl_email());
        values.put(COLUMN_l_skype, contact.getl_skype());
        values.put(COLUMN_l_facebook, contact.getl_facebook());
        values.put(COLUMN_l_twitter, contact.getl_twitter());
        values.put(COLUMN_l_language, contact.getl_language());

        values.put(COLUMN_o_firstname, contact.geto_firstname());
        values.put(COLUMN_o_lastname, contact.geto_lastname());
        values.put(COLUMN_o_address, contact.geto_address());
        values.put(COLUMN_o_zip, contact.geto_zip());
        values.put(COLUMN_o_town, contact.geto_town());
        values.put(COLUMN_o_country, contact.geto_country());
        values.put(COLUMN_o_telephone, contact.geto_telephone());
        values.put(COLUMN_o_mobile, contact.geto_mobile());
        values.put(COLUMN_o_email, contact.geto_email());
        values.put(COLUMN_o_skype, contact.geto_skype());
        values.put(COLUMN_o_facebook, contact.geto_facebook());
        values.put(COLUMN_o_twitter, contact.geto_twitter());
        values.put(COLUMN_o_language, contact.geto_language());

        values.put(COLUMN_fdb_time, contact.getfdb_time());
        values.put(COLUMN_fdb_where, contact.getfdb_where());
        values.put(COLUMN_fdl_time, contact.getfdl_time());
        values.put(COLUMN_fdl_where, contact.getfdl_where());
        values.put(COLUMN_fdd_time, contact.getfdd_time());
        values.put(COLUMN_fdd_where, contact.getfdd_where());
        values.put(COLUMN_trt_name, contact.gettrt_name());
        values.put(COLUMN_trt_phone, contact.gettrt_phone());
        values.put(COLUMN_trt_address, contact.gettrt_address());
        values.put(COLUMN_trt_address_address, contact.gettrt_address_address());
        values.put(COLUMN_trt_address_lat, contact.gettrt_address_lat());
        values.put(COLUMN_trt_address_lng, contact.gettrt_address_lng());
        values.put(COLUMN_trt_website, contact.gettrt_website());
        values.put(COLUMN_trt_email, contact.gettrt_email());
        values.put(COLUMN_trc_name, contact.gettrc_name());
        values.put(COLUMN_trc_phone, contact.gettrc_phone());
        values.put(COLUMN_trc_address, contact.gettrc_address());
        values.put(COLUMN_trc_website, contact.gettrc_website());
        values.put(COLUMN_trc_email, contact.gettrc_email());

        values.put(COLUMN_trb_name, contact.gettrb_name());
        values.put(COLUMN_trb_phone, contact.gettrb_phone());
        values.put(COLUMN_trb_address, contact.gettrb_address());
        values.put(COLUMN_trb_website, contact.gettrb_website());
        values.put(COLUMN_trb_email, contact.gettrb_email());
        values.put(COLUMN_trm_name, contact.gettrm_name());
        values.put(COLUMN_trm_phone, contact.gettrm_phone());
        values.put(COLUMN_trm_address, contact.gettrm_address());
        values.put(COLUMN_trm_website, contact.gettrm_website());
        values.put(COLUMN_trm_email, contact.gettrm_email());
        values.put(COLUMN_trp_bus, contact.gettrp_bus());
        values.put(COLUMN_trp_metro, contact.gettrp_metro());
        values.put(COLUMN_trp_train, contact.gettrp_train());
        values.put(COLUMN_trair_name, contact.gettrair_name());
        values.put(COLUMN_trair_phone, contact.gettrair_phone());
        values.put(COLUMN_trair_address, contact.gettrair_address());
        values.put(COLUMN_trair_address_address, contact.gettrair_address_address());
        values.put(COLUMN_trair_address_lat, contact.gettrair_address_lat());
        values.put(COLUMN_trair_address_lng, contact.gettrair_address_lng());
        values.put(COLUMN_trair_website, contact.gettrair_website());
        values.put(COLUMN_trair_email, contact.gettrair_email());
        values.put(COLUMN_moatm_address, contact.getmoatm_address());
        values.put(COLUMN_ser_checkintime, contact.getser_checkintime());
        values.put(COLUMN_ser_checkouttime, contact.getser_checkouttime());
        values.put(COLUMN_attr_repeat, contact.getattr_repeat());
        values.put(COLUMN_attr_repeat_0_attr_name, contact.getattr_repeat_0_attr_name());
        values.put(COLUMN_attr_repeat_0_attr_website, contact.getattr_repeat_0_attr_website());
        values.put(COLUMN_attr_repeat_0_attr_picture, contact.getattr_repeat_0_attr_picture());
        values.put(COLUMN_attr_repeat_0_attr_descript, contact.getattr_repeat_0_attr_descript());
        values.put(COLUMN_attr_repeat_1_attr_name, contact.getattr_repeat_1_attr_name());
        values.put(COLUMN_attr_repeat_1_attr_website, contact.getattr_repeat_1_attr_website());
        values.put(COLUMN_attr_repeat_1_attr_picture, contact.getattr_repeat_1_attr_picture());
        values.put(COLUMN_attr_repeat_1_attr_descript, contact.getattr_repeat_1_attr_descript());
        values.put(COLUMN_ser_atm_address, contact.getser_atm_address());
        values.put(COLUMN_ser_atm_location, contact.getser_atm_location());
        values.put(COLUMN_ser_atm_location_address, contact.getser_atm_location_address());
        values.put(COLUMN_ser_atm_location_lat, contact.getser_atm_location_lat());
        values.put(COLUMN_ser_atm_location_lng, contact.getser_atm_location_lng());
        values.put(COLUMN_ser_wifi_pass, contact.getser_wifi_pass());
        values.put(COLUMN_ser_wifi_details, contact.getser_wifi_details());
        values.put(COLUMN_ser_park_details, contact.getser_park_details());
        values.put(COLUMN_ser_park_map, contact.getser_park_map());
        values.put(COLUMN_ser_park_map_address, contact.getser_park_map_address());
        values.put(COLUMN_ser_park_map_address_lat, contact.getser_park_map_address_lat());
        values.put(COLUMN_ser_park_map_address_lng, contact.getser_park_map_address_lng());
        values.put(COLUMN_ser_tv_details, contact.getser_tv_details());

        values.put(COLUMN_em_general, contact.getem_general());
        values.put(COLUMN_em_fire, contact.getem_fire());
        values.put(COLUMN_em_ambulance, contact.getem_ambulance());
        values.put(COLUMN_em_police, contact.getem_police());
        values.put(COLUMN_em_assistance, contact.getem_assistance());
        values.put(COLUMN_em_docter_name, contact.getem_docter_name());
        values.put(COLUMN_em_docter_telephone, contact.getem_docter_telephone());
        values.put(COLUMN_em_docter_address, contact.getem_docter_address());
        values.put(COLUMN_em_docter_address_address, contact.getem_docter_address_address());
        values.put(COLUMN_em_docter_address_lat, contact.getem_docter_address_lat());
        values.put(COLUMN_em_docter_address_lng, contact.getem_docter_address_lng());
        values.put(COLUMN_em_pharmacy_name, contact.getem_pharmacy_name());
        values.put(COLUMN_em_pharmacy_telephone, contact.getem_pharmacy_telephone());
        values.put(COLUMN_em_pharmacy_address, contact.getem_pharmacy_address());
        values.put(COLUMN_em_pharmacy_address_address, contact.getem_pharmacy_address_address());
        values.put(COLUMN_em_pharmacy_address_lat, contact.getem_pharmacy_address_lat());
        values.put(COLUMN_em_pharmacy_address_lng, contact.getem_pharmacy_address_lng());
        values.put(COLUMN_rsb, contact.getrsb());
        values.put(COLUMN_ent_0_ent_type, contact.getent_0_ent_type());
        values.put(COLUMN_ent_0_ent_name, contact.getent_0_ent_name());
        values.put(COLUMN_ent_0_ent_website, contact.getent_0_ent_website());
        values.put(COLUMN_ent_0_ent_phone, contact.getent_0_ent_phone());
        values.put(COLUMN_ent_0_ent_map, contact.getent_0_ent_map());
        values.put(COLUMN_ent_0_ent_map_address, contact.getent_0_ent_map_address());
        values.put(COLUMN_ent_0_ent_map_lat, contact.getent_0_ent_map_lat());
        values.put(COLUMN_ent_0_ent_map_lng, contact.getent_0_ent_map_lng());
        values.put(COLUMN_ent, contact.getent());
        values.put(COLUMN_rsb_0_rbs_type, contact.getrsb_0_rbs_type());
        values.put(COLUMN_rsb_0_rbs_name, contact.getrsb_0_rbs_name());
        values.put(COLUMN_rsb_0_rbs_website, contact.getrsb_0_rbs_website());
        values.put(COLUMN_rsb_0_rbs_phone, contact.getrsb_0_rbs_phone());
        values.put(COLUMN_rsb_0_rbs_map, contact.getrsb_0_rbs_map());
        values.put(COLUMN_rsb_0_rbs_map_address, contact.getrsb_0_rbs_map_address());
        values.put(COLUMN_rsb_0_rbs_map_lat, contact.getrsb_0_rbs_map_lat());
        values.put(COLUMN_rsb_0_rbs_map_lng, contact.getrsb_0_rbs_map_lng());
        values.put(COLUMN_rsb_1_rbs_type, contact.getrsb_1_rbs_type());
        values.put(COLUMN_rsb_1_rbs_name, contact.getrsb_1_rbs_name());
        values.put(COLUMN_rsb_1_rbs_website, contact.getrsb_1_rbs_website());
        values.put(COLUMN_rsb_1_rbs_phone, contact.getrsb_1_rbs_phone());
        values.put(COLUMN_rsb_1_rbs_map, contact.getrsb_1_rbs_map());
        values.put(COLUMN_rsb_1_rbs_map_address, contact.getrsb_1_rbs_map_address());
        values.put(COLUMN_rsb_1_rbs_map_lat, contact.getrsb_1_rbs_map_lat());
        values.put(COLUMN_rsb_1_rbs_map_lng, contact.getrsb_1_rbs_map());
        values.put(COLUMN_rsb_2_rbs_type, contact.getrsb_2_rbs_type());
        values.put(COLUMN_rsb_2_rbs_name, contact.getrsb_2_rbs_name());
        values.put(COLUMN_rsb_2_rbs_website, contact.getrsb_2_rbs_website());
        values.put(COLUMN_rsb_2_rbs_phone, contact.getrsb_2_rbs_phone());
        values.put(COLUMN_rsb_2_rbs_map, contact.getrsb_2_rbs_map());
        values.put(COLUMN_rsb_2_rbs_map_address, contact.getrsb_2_rbs_map_address());
        values.put(COLUMN_rsb_2_rbs_map_lat, contact.getrsb_2_rbs_map_lat());
        values.put(COLUMN_rsb_2_rbs_map_lng, contact.getrsb_2_rbs_map_lng());
        values.put(COLUMN_attr_repeat_0_attr_map, contact.getattr_repeat_0_attr_map());
        values.put(COLUMN_attr_repeat_0_attr_map_address, contact.getattr_repeat_0_attr_map_address());
        values.put(COLUMN_attr_repeat_0_attr_map_lat, contact.getattr_repeat_0_attr_map_lat());
        values.put(COLUMN_attr_repeat_0_attr_maplng, contact.getattr_repeat_0_attr_map_lng());
        values.put(COLUMN_attr_repeat_1_attr_map, contact.getattr_repeat_1_attr_map());
        values.put(COLUMN_attr_repeat_1_attr_map_address, contact.getattr_repeat_1_attr_map_address());
        values.put(COLUMN_attr_repeat_1_attr_map_lat, contact.getattr_repeat_1_attr_map_lat());
        values.put(COLUMN_attr_repeat_1_attr_map_lng, contact.getattr_repeat_1_attr_map_lng());

        values.put(COLUMN_com_laun_details, contact.getcom_laun_details());
        values.put(COLUMN_com_lug_details, contact.getcom_lug_details());
        values.put(COLUMN_com_hair_details, contact.getcom_hair_details());
        values.put(COLUMN_com_ct_details, contact.getcom_ct_details());
        values.put(COLUMN_com_room_details, contact.getcom_room_details());


        values.put(COLUMN_a_logo_image, contact.geta_logo_image());
        values.put(COLUMN_a_picture_image, contact.geta_picture_image());


        values.put(COLUMN_attr_repeat_2_attr_name, contact.getattr_repeat_2_attr_name());
        values.put(COLUMN_attr_repeat_2_attr_website, contact.getattr_repeat_2_attr_website());
        values.put(COLUMN_attr_repeat_2_attr_picture, contact.getattr_repeat_2_attr_picture());
        values.put(COLUMN_attr_repeat_2_attr_descript, contact.getattr_repeat_2_attr_descript());
        values.put(COLUMN_attr_repeat_2_attr_map, contact.getattr_repeat_2_attr_map());
        values.put(COLUMN_attr_repeat_2_attr_map_address, contact.getattr_repeat_2_attr_map_address());
        values.put(COLUMN_attr_repeat_2_attr_map_lat, contact.getattr_repeat_2_attr_map_lat());
        values.put(COLUMN_attr_repeat_2_attr_map_lng, contact.getattr_repeat_2_attr_map_lng());
        values.put(COLUMN_attr_repeat_3_attr_name, contact.getattr_repeat_3_attr_name());
        values.put(COLUMN_attr_repeat_3_attr_website, contact.getattr_repeat_3_attr_website());
        values.put(COLUMN_attr_repeat_3_attr_picture, contact.getattr_repeat_3_attr_picture());
        values.put(COLUMN_attr_repeat_3_attr_descript, contact.getattr_repeat_3_attr_descript());
        values.put(COLUMN_attr_repeat_3_attr_map, contact.getattr_repeat_3_attr_map());
        values.put(COLUMN_attr_repeat_3_attr_map_address, contact.getattr_repeat_3_attr_map_address());
        values.put(COLUMN_attr_repeat_3_attr_map_lat, contact.getattr_repeat_3_attr_map_lat());
        values.put(COLUMN_attr_repeat_3_attr_map_lng, contact.getattr_repeat_3_attr_map_lng());
        values.put(COLUMN_attr_repeat_4_attr_name, contact.getattr_repeat_4_attr_name());
        values.put(COLUMN_attr_repeat_4_attr_website, contact.getattr_repeat_4_attr_website());
        values.put(COLUMN_attr_repeat_4_attr_picture, contact.getattr_repeat_4_attr_picture());
        values.put(COLUMN_attr_repeat_4_attr_descript, contact.getattr_repeat_4_attr_descript());
        values.put(COLUMN_attr_repeat_4_attr_map, contact.getattr_repeat_4_attr_map());
        values.put(COLUMN_attr_repeat_4_attr_map_address, contact.getattr_repeat_4_attr_map_address());
        values.put(COLUMN_attr_repeat_4_attr_map_lat, contact.getattr_repeat_4_attr_map_lat());
        values.put(COLUMN_attr_repeat_4_attr_map_lng, contact.getattr_repeat_4_attr_map_lng());
        values.put(COLUMN_ent_1_ent_type, contact.getent_1_ent_type());
        values.put(COLUMN_ent_1_ent_name, contact.getent_1_ent_name());
        values.put(COLUMN_ent_1_ent_website, contact.getent_1_ent_website());
        values.put(COLUMN_ent_1_ent_phone, contact.getent_1_ent_phone());
        values.put(COLUMN_ent_1_ent_map, contact.getent_1_ent_map());
        values.put(COLUMN_ent_1_ent_map_address, contact.getent_1_ent_map_address());
        values.put(COLUMN_ent_1_ent_map_lat, contact.getent_1_ent_map_lat());
        values.put(COLUMN_ent_1_ent_map_lng, contact.getent_1_ent_map_lng());
        values.put(COLUMN_ent_2_ent_type, contact.getent_2_ent_type());
        values.put(COLUMN_ent_2_ent_name, contact.getent_2_ent_name());
        values.put(COLUMN_ent_2_ent_website, contact.getent_2_ent_website());
        values.put(COLUMN_ent_2_ent_phone, contact.getent_2_ent_phone());
        values.put(COLUMN_ent_2_ent_map, contact.getent_2_ent_map());
        values.put(COLUMN_ent_2_ent_map_address, contact.getent_2_ent_map_address());
        values.put(COLUMN_ent_2_ent_map_lat, contact.getent_2_ent_map_lat());
        values.put(COLUMN_ent_2_ent_map_lng, contact.getent_2_ent_map_lng());
        values.put(COLUMN_ent_3_ent_type, contact.getent_3_ent_type());
        values.put(COLUMN_ent_3_ent_name, contact.getent_3_ent_name());
        values.put(COLUMN_ent_3_ent_website, contact.getent_3_ent_website());
        values.put(COLUMN_ent_3_ent_phone, contact.getent_3_ent_phone());
        values.put(COLUMN_ent_3_ent_map, contact.getent_3_ent_map());
        values.put(COLUMN_ent_3_ent_map_address, contact.getent_3_ent_map_address());
        values.put(COLUMN_ent_3_ent_map_lat, contact.getent_3_ent_map_lat());
        values.put(COLUMN_ent_3_ent_map_lng, contact.getent_3_ent_map_lng());
        values.put(COLUMN_ent_4_ent_type, contact.getent_4_ent_type());
        values.put(COLUMN_ent_4_ent_name, contact.getent_4_ent_name());
        values.put(COLUMN_ent_4_ent_website, contact.getent_4_ent_website());
        values.put(COLUMN_ent_4_ent_phone, contact.getent_4_ent_phone());
        values.put(COLUMN_ent_4_ent_map, contact.getent_4_ent_map());
        values.put(COLUMN_ent_4_ent_map_address, contact.getent_4_ent_map_address());
        values.put(COLUMN_ent_4_ent_map_lat, contact.getent_4_ent_map_lat());
        values.put(COLUMN_ent_4_ent_map_lng, contact.getent_4_ent_map_lng());
        values.put(COLUMN_ent_5_ent_type, contact.getent_5_ent_type());
        values.put(COLUMN_ent_5_ent_name, contact.getent_5_ent_name());
        values.put(COLUMN_ent_5_ent_website, contact.getent_5_ent_website());
        values.put(COLUMN_ent_5_ent_phone, contact.getent_5_ent_phone());
        values.put(COLUMN_ent_5_ent_map, contact.getent_5_ent_map());
        values.put(COLUMN_ent_5_ent_map_address, contact.getent_5_ent_map_address());
        values.put(COLUMN_ent_5_ent_map_lat, contact.getent_5_ent_map_lat());
        values.put(COLUMN_ent_5_ent_map_lng, contact.getent_5_ent_map_lng());
        values.put(COLUMN_ent_6_ent_type, contact.getent_6_ent_type());
        values.put(COLUMN_ent_6_ent_name, contact.getent_6_ent_name());
        values.put(COLUMN_ent_6_ent_website, contact.getent_6_ent_website());
        values.put(COLUMN_ent_6_ent_phone, contact.getent_6_ent_phone());
        values.put(COLUMN_ent_6_ent_map, contact.getent_6_ent_map());
        values.put(COLUMN_ent_6_ent_map_address, contact.getent_6_ent_map_address());
        values.put(COLUMN_ent_6_ent_map_lat, contact.getent_6_ent_map_lat());
        values.put(COLUMN_ent_6_ent_map_lng, contact.getent_6_ent_map_lng());
        values.put(COLUMN_ent_7_ent_type, contact.getent_7_ent_type());
        values.put(COLUMN_ent_7_ent_name, contact.getent_7_ent_name());
        values.put(COLUMN_ent_7_ent_website, contact.getent_7_ent_website());
        values.put(COLUMN_ent_7_ent_phone, contact.getent_7_ent_phone());
        values.put(COLUMN_ent_7_ent_map, contact.getent_7_ent_map());
        values.put(COLUMN_ent_7_ent_map_address, contact.getent_7_ent_map_address());
        values.put(COLUMN_ent_7_ent_map_lat, contact.getent_7_ent_map_lat());
        values.put(COLUMN_ent_7_ent_map_lng, contact.getent_7_ent_map_lng());
        values.put(COLUMN_ent_8_ent_type, contact.getent_8_ent_type());
        values.put(COLUMN_ent_8_ent_name, contact.getent_8_ent_name());
        values.put(COLUMN_ent_8_ent_website, contact.getent_8_ent_website());
        values.put(COLUMN_ent_8_ent_phone, contact.getent_8_ent_phone());
        values.put(COLUMN_ent_8_ent_map, contact.getent_8_ent_map());
        values.put(COLUMN_ent_8_ent_map_address, contact.getent_8_ent_map_address());
        values.put(COLUMN_ent_8_ent_map_lat, contact.getent_8_ent_map_lat());
        values.put(COLUMN_ent_8_ent_map_lng, contact.getent_8_ent_map_lng());
        values.put(COLUMN_rsb_3_rbs_type, contact.getrsb_3_rbs_type());
        values.put(COLUMN_rsb_3_rbs_name, contact.getrsb_3_rbs_name());
        values.put(COLUMN_rsb_3_rbs_website, contact.getrsb_3_rbs_website());
        values.put(COLUMN_rsb_3_rbs_phone, contact.getrsb_3_rbs_phone());
        values.put(COLUMN_rsb_3_rbs_map, contact.getrsb_3_rbs_map());
        values.put(COLUMN_rsb_3_rbs_map_address, contact.getrsb_3_rbs_map_address());
        values.put(COLUMN_rsb_3_rbs_map_lat, contact.getrsb_3_rbs_map_lat());
        values.put(COLUMN_rsb_3_rbs_map_lng, contact.getrsb_3_rbs_map_lng());
        values.put(COLUMN_rsb_4_rbs_type, contact.getrsb_4_rbs_type());
        values.put(COLUMN_rsb_4_rbs_name, contact.getrsb_4_rbs_name());
        values.put(COLUMN_rsb_4_rbs_website, contact.getrsb_4_rbs_website());
        values.put(COLUMN_rsb_4_rbs_phone, contact.getrsb_4_rbs_phone());
        values.put(COLUMN_rsb_4_rbs_map, contact.getrsb_4_rbs_map());
        values.put(COLUMN_rsb_4_rbs_map_address, contact.getrsb_4_rbs_map_address());
        values.put(COLUMN_rsb_4_rbs_map_lat, contact.getrsb_4_rbs_map_lat());
        values.put(COLUMN_rsb_4_rbs_map_lng, contact.getrsb_4_rbs_map_lng());
        values.put(COLUMN_rsb_5_rbs_type, contact.getrsb_5_rbs_type());
        values.put(COLUMN_rsb_5_rbs_name, contact.getrsb_5_rbs_name());
        values.put(COLUMN_rsb_5_rbs_website, contact.getrsb_5_rbs_website());
        values.put(COLUMN_rsb_5_rbs_phone, contact.getrsb_5_rbs_phone());
        values.put(COLUMN_rsb_5_rbs_map, contact.getrsb_5_rbs_map());
        values.put(COLUMN_rsb_5_rbs_map_address, contact.getrsb_5_rbs_map_address());
        values.put(COLUMN_rsb_5_rbs_map_lat, contact.getrsb_5_rbs_map_lat());
        values.put(COLUMN_rsb_5_rbs_map_lng, contact.getrsb_5_rbs_map_lng());
        values.put(COLUMN_rsb_6_rbs_type, contact.getrsb_6_rbs_type());
        values.put(COLUMN_rsb_6_rbs_name, contact.getrsb_6_rbs_name());
        values.put(COLUMN_rsb_6_rbs_website, contact.getrsb_6_rbs_website());
        values.put(COLUMN_rsb_6_rbs_phone, contact.getrsb_6_rbs_phone());
        values.put(COLUMN_rsb_6_rbs_map, contact.getrsb_6_rbs_map());
        values.put(COLUMN_rsb_6_rbs_map_address, contact.getrsb_6_rbs_map_address());
        values.put(COLUMN_rsb_6_rbs_map_lat, contact.getrsb_6_rbs_map_lat());
        values.put(COLUMN_rsb_6_rbs_map_lng, contact.getrsb_6_rbs_map_lng());
        values.put(COLUMN_rsb_7_rbs_type, contact.getrsb_7_rbs_type());
        values.put(COLUMN_rsb_7_rbs_name, contact.getrsb_7_rbs_name());
        values.put(COLUMN_rsb_7_rbs_website, contact.getrsb_7_rbs_website());
        values.put(COLUMN_rsb_7_rbs_phone, contact.getrsb_7_rbs_phone());
        values.put(COLUMN_rsb_7_rbs_map, contact.getrsb_7_rbs_map());
        values.put(COLUMN_rsb_7_rbs_map_address, contact.getrsb_7_rbs_map_address());
        values.put(COLUMN_rsb_7_rbs_map_lat, contact.getrsb_7_rbs_map_lat());
        values.put(COLUMN_rsb_7_rbs_map_lng, contact.getrsb_7_rbs_map_lng());
        values.put(COLUMN_rsb_8_rbs_type, contact.getrsb_8_rbs_type());
        values.put(COLUMN_rsb_8_rbs_name, contact.getrsb_8_rbs_name());
        values.put(COLUMN_rsb_8_rbs_website, contact.getrsb_8_rbs_website());
        values.put(COLUMN_rsb_8_rbs_phone, contact.getrsb_8_rbs_phone());
        values.put(COLUMN_rsb_8_rbs_map, contact.getrsb_8_rbs_map());
        values.put(COLUMN_rsb_8_rbs_map_address, contact.getrsb_8_rbs_map_address());
        values.put(COLUMN_rsb_8_rbs_map_lat, contact.getrsb_8_rbs_map_lat());
        values.put(COLUMN_rsb_8_rbs_map_lng, contact.getrsb_8_rbs_map_lng());
        values.put(COLUMN_name, contact.getname());
        values.put(COLUMN_attr_repeat_0_attr_picture_image, contact.getattr_repeat_0_attr_picture_image());
        values.put(COLUMN_attr_repeat_1_attr_picture_image, contact.getattr_repeat_1_attr_picture_image());
        values.put(COLUMN_attr_repeat_2_attr_picture_image, contact.getattr_repeat_2_attr_picture_image());
        values.put(COLUMN_attr_repeat_3_attr_picture_image, contact.getattr_repeat_3_attr_picture_image());
        values.put(COLUMN_attr_repeat_4_attr_picture_image, contact.getattr_repeat_4_attr_picture_image());

        values.put(COLUMN_trc_address_address, contact.gettrc_address_address());
        values.put(COLUMN_trc_address_address_lat, contact.gettrc_address_address_lat());
        values.put(COLUMN_trc_address_address_lng, contact.gettrc_address_address_lng());
        values.put(COLUMN_trb_address_address, contact.gettrb_address_address());
        values.put(COLUMN_trb_address_address_lat, contact.gettrb_address_address_lat());
        values.put(COLUMN_trb_address_address_lng, contact.gettrb_address_address_lng());
        values.put(COLUMN_trm_address_address, contact.gettrm_address_address());
        values.put(COLUMN_trm_address_address_lat, contact.gettrm_address_address_lat());
        values.put(COLUMN_trm_address_address_lng, contact.gettrm_address_address_lng());


        // updating row
        database.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{String.valueOf(contact.getID())});
        database.close();
    }
    /*done*/


    /***********************************
     * NOT IN USE
     ***************************************/
    /*done*/
    // Updating All contact Alternate
    public void Update_ContactAlternate(Contact contact) {
        database = this.getWritableDatabase();


        database.execSQL("update " + TABLE_NAME +
                " set "
                + COLUMN_POST_ID + " = '" + contact.getPOST_ID() + "', "
                + COLUMN_a_welcome + " = '" + contact.geta_welcome() + "', "
                + COLUMN_a_logo + " = '" + contact.geta_logo() + "', "
                + COLUMN_a_picture + " = '" + contact.geta_picture() + "', "
                + COLUMN_a_address + " = '" + contact.geta_address() + "', "
                + COLUMN_a_zip + " = '" + contact.geta_zip() + "', "
                + COLUMN_a_town + " = '" + contact.geta_town() + "', "
                + COLUMN_a_country + " = '" + contact.geta_country() + "', "
                + COLUMN_a_map + " = '" + contact.geta_map() + "', "
                + COLUMN_a_map_address + " = '" + contact.geta_map_address() + "', "
                + COLUMN_a_map_address_lng + " = '" + contact.geta_map_address_lng() + "', "
                + COLUMN_a_map_address_lat + " = '" + contact.geta_map_address_lat() + "', "
                + COLUMN_a_website + " = '" + contact.geta_website() + "', "
                + COLUMN_a_telephone + " = '" + contact.geta_telephone() + "', "
                + COLUMN_a_facebook + " = '" + contact.geta_facebook() + "', "
                + COLUMN_a_twitter + " = '" + contact.geta_twitter() + "', "

                + COLUMN_l_firstname + " = '" + contact.getl_firstname() + "', "
                + COLUMN_l_lastname + " = '" + contact.getl_lastname() + "', "
                + COLUMN_l_address + " = '" + contact.getl_address() + "', "
                + COLUMN_l_zip + " = '" + contact.getl_zip() + "', "
                + COLUMN_l_town + " = '" + contact.getl_town() + "', "
                + COLUMN_l_country + " = '" + contact.getl_country() + "', "
                + COLUMN_l_telephone + " = '" + contact.getl_telephone() + "', "
                + COLUMN_l_mobile + " = '" + contact.getl_mobile() + "', "
                + COLUMN_l_email + " = '" + contact.getl_email() + "', "
                + COLUMN_l_skype + " = '" + contact.getl_skype() + "', "
                + COLUMN_l_facebook + " = '" + contact.getl_facebook() + "', "
                + COLUMN_l_twitter + " = '" + contact.getl_twitter() + "', "
                + COLUMN_l_language + " = '" + contact.getl_language() + "', "

                + COLUMN_o_firstname + " = '" + contact.geto_firstname() + "', "
                + COLUMN_o_lastname + " = '" + contact.geto_lastname() + "', "
                + COLUMN_o_address + " = '" + contact.geto_address() + "', "
                + COLUMN_o_zip + " = '" + contact.geto_zip() + "', "
                + COLUMN_o_town + " = '" + contact.geto_town() + "', "
                + COLUMN_o_country + " = '" + contact.geto_country() + "', "
                + COLUMN_o_telephone + " = '" + contact.geto_telephone() + "', "
                + COLUMN_o_mobile + " = '" + contact.geto_mobile() + "', "
                + COLUMN_o_email + " = '" + contact.geto_email() + "', "
                + COLUMN_o_skype + " = '" + contact.geto_skype() + "', "
                + COLUMN_o_facebook + " = '" + contact.geto_facebook() + "', "
                + COLUMN_o_twitter + " = '" + contact.geto_twitter() + "', "
                + COLUMN_o_language + " = '" + contact.geto_language() + "', "

                + COLUMN_fdb_time + " = '" + contact.getfdb_time() + "', "
                + COLUMN_fdb_where + " = '" + contact.getfdb_where() + "', "
                + COLUMN_fdl_time + " = '" + contact.getfdl_time() + "', "
                + COLUMN_fdl_where + " = '" + contact.getfdl_where() + "', "
                + COLUMN_fdd_time + " = '" + contact.getfdd_time() + "', "
                + COLUMN_fdd_where + " = '" + contact.getfdd_where() + "', "
                + COLUMN_trt_name + " = '" + contact.gettrt_name() + "', "
                + COLUMN_trt_phone + " = '" + contact.gettrt_phone() + "', "
                + COLUMN_trt_address + " = '" + contact.gettrt_address() + "', "
                + COLUMN_trt_address_address + " = '" + contact.gettrt_address_address() + "', "
                + COLUMN_trt_address_lat + " = '" + contact.gettrt_address_lat() + "', "
                + COLUMN_trt_address_lng + " = '" + contact.gettrt_address_lng() + "', "
                + COLUMN_trt_website + " = '" + contact.gettrt_website() + "', "
                + COLUMN_trt_email + " = '" + contact.gettrt_email() + "', "
                + COLUMN_trc_name + " = '" + contact.gettrc_name() + "', "
                + COLUMN_trc_phone + " = '" + contact.gettrc_phone() + "', "
                + COLUMN_trc_address + " = '" + contact.gettrc_address() + "', "
                + COLUMN_trc_website + " = '" + contact.gettrc_website() + "', "
                + COLUMN_trc_email + " = '" + contact.gettrc_email() + "', "

                + COLUMN_trb_name + " = '" + contact.gettrb_name() + "', "
                + COLUMN_trb_phone + " = '" + contact.gettrb_phone() + "', "
                + COLUMN_trb_address + " = '" + contact.gettrb_address() + "', "
                + COLUMN_trb_website + " = '" + contact.gettrb_website() + "', "
                + COLUMN_trb_email + " = '" + contact.gettrb_email() + "', "
                + COLUMN_trm_name + " = '" + contact.gettrm_name() + "', "
                + COLUMN_trm_phone + " = '" + contact.gettrm_phone() + "', "
                + COLUMN_trm_address + " = '" + contact.gettrm_address() + "', "
                + COLUMN_trm_website + " = '" + contact.gettrm_website() + "', "
                + COLUMN_trm_email + " = '" + contact.gettrm_email() + "', "
                + COLUMN_trp_bus + " = '" + contact.gettrp_bus() + "', "
                + COLUMN_trp_metro + " = '" + contact.gettrp_metro() + "', "
                + COLUMN_trp_train + " = '" + contact.gettrp_train() + "', "
                + COLUMN_trair_name + " = '" + contact.gettrair_name() + "', "
                + COLUMN_trair_phone + " = '" + contact.gettrair_phone() + "', "
                + COLUMN_trair_address + " = '" + contact.gettrair_address() + "', "
                + COLUMN_trair_address_address + " = '" + contact.gettrair_address_address() + "', "
                + COLUMN_trair_address_lat + " = '" + contact.gettrair_address_lat() + "', "
                + COLUMN_trair_address_lng + " = '" + contact.gettrair_address_lng() + "', "
                + COLUMN_trair_website + " = '" + contact.gettrair_website() + "', "
                + COLUMN_trair_email + " = '" + contact.gettrair_email() + "', "
                + COLUMN_moatm_address + " = '" + contact.getmoatm_address() + "', "
                + COLUMN_ser_checkintime + " = '" + contact.getser_checkintime() + "', "
                + COLUMN_ser_checkouttime + " = '" + contact.getser_checkouttime() + "', "
                + COLUMN_attr_repeat + " = '" + contact.getattr_repeat() + "', "
                + COLUMN_attr_repeat_0_attr_name + " = '" + contact.getattr_repeat_0_attr_name() + "', "
                + COLUMN_attr_repeat_0_attr_website + " = '" + contact.getattr_repeat_0_attr_website() + "', "
                + COLUMN_attr_repeat_0_attr_picture + " = '" + contact.getattr_repeat_0_attr_picture() + "', "
                + COLUMN_attr_repeat_0_attr_descript + " = '" + contact.getattr_repeat_0_attr_descript() + "', "
                + COLUMN_attr_repeat_1_attr_name + " = '" + contact.getattr_repeat_1_attr_name() + "', "
                + COLUMN_attr_repeat_1_attr_website + " = '" + contact.getattr_repeat_1_attr_website() + "', "
                + COLUMN_attr_repeat_1_attr_picture + " = '" + contact.getattr_repeat_1_attr_picture() + "', "
                + COLUMN_attr_repeat_1_attr_descript + " = '" + contact.getattr_repeat_1_attr_descript() + "', "
                + COLUMN_ser_atm_address + " = '" + contact.getser_atm_address() + "', "
                + COLUMN_ser_atm_location + " = '" + contact.getser_atm_location() + "', "
                + COLUMN_ser_atm_location_address + " = '" + contact.getser_atm_location_address() + "', "
                + COLUMN_ser_atm_location_lat + " = '" + contact.getser_atm_location_lat() + "', "
                + COLUMN_ser_atm_location_lng + " = '" + contact.getser_atm_location_lng() + "', "
                + COLUMN_ser_wifi_pass + " = '" + contact.getser_wifi_pass() + "', "
                + COLUMN_ser_wifi_details + " = '" + contact.getser_wifi_details() + "', "
                + COLUMN_ser_park_details + " = '" + contact.getser_park_details() + "', "
                + COLUMN_ser_park_map + " = '" + contact.getser_park_map() + "', "
                + COLUMN_ser_park_map_address + " = '" + contact.getser_park_map_address() + "', "
                + COLUMN_ser_park_map_address_lat + " = '" + contact.getser_park_map_address_lat() + "', "
                + COLUMN_ser_park_map_address_lng + " = '" + contact.getser_park_map_address_lng() + "', "
                + COLUMN_ser_tv_details + " = '" + contact.getser_tv_details() + "', "

                + COLUMN_em_general + " = '" + contact.getem_general() + "', "
                + COLUMN_em_fire + " = '" + contact.getem_fire() + "', "
                + COLUMN_em_ambulance + " = '" + contact.getem_ambulance() + "', "
                + COLUMN_em_police + " = '" + contact.getem_police() + "', "
                + COLUMN_em_assistance + " = '" + contact.getem_assistance() + "', "
                + COLUMN_em_docter_name + " = '" + contact.getem_docter_name() + "', "
                + COLUMN_em_docter_telephone + " = '" + contact.getem_docter_telephone() + "', "
                + COLUMN_em_docter_address + " = '" + contact.getem_docter_address() + "', "
                + COLUMN_em_docter_address_address + " = '" + contact.getem_docter_address_address() + "', "
                + COLUMN_em_docter_address_lat + " = '" + contact.getem_docter_address_lat() + "', "
                + COLUMN_em_docter_address_lng + " = '" + contact.getem_docter_address_lng() + "', "
                + COLUMN_em_pharmacy_name + " = '" + contact.getem_pharmacy_name() + "', "
                + COLUMN_em_pharmacy_telephone + " = '" + contact.getem_pharmacy_telephone() + "', "
                + COLUMN_em_pharmacy_address + " = '" + contact.getem_pharmacy_address() + "', "
                + COLUMN_em_pharmacy_address_address + " = '" + contact.getem_pharmacy_address_address() + "', "
                + COLUMN_em_pharmacy_address_lat + " = '" + contact.getem_pharmacy_address_lat() + "', "
                + COLUMN_em_pharmacy_address_lng + " = '" + contact.getem_pharmacy_address_lng() + "', "
                + COLUMN_rsb + " = '" + contact.getrsb() + "', "
                + COLUMN_ent_0_ent_type + " = '" + contact.getent_0_ent_type() + "', "
                + COLUMN_ent_0_ent_name + " = '" + contact.getent_0_ent_name() + "', "
                + COLUMN_ent_0_ent_website + " = '" + contact.getent_0_ent_website() + "', "
                + COLUMN_ent_0_ent_phone + " = '" + contact.getent_0_ent_phone() + "', "
                + COLUMN_ent_0_ent_map + " = '" + contact.getent_0_ent_map() + "', "
                + COLUMN_ent_0_ent_map_address + " = '" + contact.getent_0_ent_map_address() + "', "
                + COLUMN_ent_0_ent_map_lat + " = '" + contact.getent_0_ent_map_lat() + "', "
                + COLUMN_ent_0_ent_map_lng + " = '" + contact.getent_0_ent_map_lng() + "', "
                + COLUMN_ent + " = '" + contact.getent() + "', "
                + COLUMN_rsb_0_rbs_type + " = '" + contact.getrsb_0_rbs_type() + "', "
                + COLUMN_rsb_0_rbs_name + " = '" + contact.getrsb_0_rbs_name() + "', "
                + COLUMN_rsb_0_rbs_website + " = '" + contact.getrsb_0_rbs_website() + "', "
                + COLUMN_rsb_0_rbs_phone + " = '" + contact.getrsb_0_rbs_phone() + "', "
                + COLUMN_rsb_0_rbs_map + " = '" + contact.getrsb_0_rbs_map() + "', "
                + COLUMN_rsb_0_rbs_map_address + " = '" + contact.getrsb_0_rbs_map_address() + "', "
                + COLUMN_rsb_0_rbs_map_lat + " = '" + contact.getrsb_0_rbs_map_lat() + "', "
                + COLUMN_rsb_0_rbs_map_lng + " = '" + contact.getrsb_0_rbs_map_lng() + "', "
                + COLUMN_rsb_1_rbs_type + " = '" + contact.getrsb_1_rbs_type() + "', "
                + COLUMN_rsb_1_rbs_name + " = '" + contact.getrsb_1_rbs_name() + "', "
                + COLUMN_rsb_1_rbs_website + " = '" + contact.getrsb_1_rbs_website() + "', "
                + COLUMN_rsb_1_rbs_phone + " = '" + contact.getrsb_1_rbs_phone() + "', "
                + COLUMN_rsb_1_rbs_map + " = '" + contact.getrsb_1_rbs_map() + "', "
                + COLUMN_rsb_1_rbs_map_address + " = '" + contact.getrsb_1_rbs_map_address() + "', "
                + COLUMN_rsb_1_rbs_map_lat + " = '" + contact.getrsb_1_rbs_map_lat() + "', "
                + COLUMN_rsb_1_rbs_map_lng + " = '" + contact.getrsb_1_rbs_map() + "', "
                + COLUMN_rsb_2_rbs_type + " = '" + contact.getrsb_2_rbs_type() + "', "
                + COLUMN_rsb_2_rbs_name + " = '" + contact.getrsb_2_rbs_name() + "', "
                + COLUMN_rsb_2_rbs_website + " = '" + contact.getrsb_2_rbs_website() + "', "
                + COLUMN_rsb_2_rbs_phone + " = '" + contact.getrsb_2_rbs_phone() + "', "
                + COLUMN_rsb_2_rbs_map + " = '" + contact.getrsb_2_rbs_map() + "', "
                + COLUMN_rsb_2_rbs_map_address + " = '" + contact.getrsb_2_rbs_map_address() + "', "
                + COLUMN_rsb_2_rbs_map_lat + " = '" + contact.getrsb_2_rbs_map_lat() + "', "
                + COLUMN_rsb_2_rbs_map_lng + " = '" + contact.getrsb_2_rbs_map_lng() + "', "
                + COLUMN_attr_repeat_0_attr_map + " = '" + contact.getattr_repeat_0_attr_map() + "', "
                + COLUMN_attr_repeat_0_attr_map_address + " = '" + contact.getattr_repeat_0_attr_map_address() + "', "
                + COLUMN_attr_repeat_0_attr_map_lat + " = '" + contact.getattr_repeat_0_attr_map_lat() + "', "
                + COLUMN_attr_repeat_0_attr_maplng + " = '" + contact.getattr_repeat_0_attr_map_lng() + "', "
                + COLUMN_attr_repeat_1_attr_map + " = '" + contact.getattr_repeat_1_attr_map() + "', "
                + COLUMN_attr_repeat_1_attr_map_address + " = '" + contact.getattr_repeat_1_attr_map_address() + "', "
                + COLUMN_attr_repeat_1_attr_map_lat + " = '" + contact.getattr_repeat_1_attr_map_lat() + "', "
                + COLUMN_attr_repeat_1_attr_map_lng + " = '" + contact.getattr_repeat_1_attr_map_lng() + "', "

                + COLUMN_com_laun_details + " = '" + contact.getcom_laun_details() + "', "
                + COLUMN_com_lug_details + " = '" + contact.getcom_lug_details() + "', "
                + COLUMN_com_hair_details + " = '" + contact.getcom_hair_details() + "', "
                + COLUMN_com_ct_details + " = '" + contact.getcom_ct_details() + "', "
                + COLUMN_com_room_details + " = '" + contact.getcom_room_details() + "', "


                + COLUMN_a_logo_image + " = '" + contact.geta_logo_image() + "', "
                + COLUMN_a_picture_image + " = '" + contact.geta_picture_image() + "', "


                + COLUMN_attr_repeat_2_attr_name + " = '" + contact.getattr_repeat_2_attr_name() + "', "
                + COLUMN_attr_repeat_2_attr_website + " = '" + contact.getattr_repeat_2_attr_website() + "', "
                + COLUMN_attr_repeat_2_attr_picture + " = '" + contact.getattr_repeat_2_attr_picture() + "', "
                + COLUMN_attr_repeat_2_attr_descript + " = '" + contact.getattr_repeat_2_attr_descript() + "', "
                + COLUMN_attr_repeat_2_attr_map + " = '" + contact.getattr_repeat_2_attr_map() + "', "
                + COLUMN_attr_repeat_2_attr_map_address + " = '" + contact.getattr_repeat_2_attr_map_address() + "', "
                + COLUMN_attr_repeat_2_attr_map_lat + " = '" + contact.getattr_repeat_2_attr_map_lat() + "', "
                + COLUMN_attr_repeat_2_attr_map_lng + " = '" + contact.getattr_repeat_2_attr_map_lng() + "', "
                + COLUMN_attr_repeat_3_attr_name + " = '" + contact.getattr_repeat_3_attr_name() + "', "
                + COLUMN_attr_repeat_3_attr_website + " = '" + contact.getattr_repeat_3_attr_website() + "', "
                + COLUMN_attr_repeat_3_attr_picture + " = '" + contact.getattr_repeat_3_attr_picture() + "', "
                + COLUMN_attr_repeat_3_attr_descript + " = '" + contact.getattr_repeat_3_attr_descript() + "', "
                + COLUMN_attr_repeat_3_attr_map + " = '" + contact.getattr_repeat_3_attr_map() + "', "
                + COLUMN_attr_repeat_3_attr_map_address + " = '" + contact.getattr_repeat_3_attr_map_address() + "', "
                + COLUMN_attr_repeat_3_attr_map_lat + " = '" + contact.getattr_repeat_3_attr_map_lat() + "', "
                + COLUMN_attr_repeat_3_attr_map_lng + " = '" + contact.getattr_repeat_3_attr_map_lng() + "', "
                + COLUMN_attr_repeat_4_attr_name + " = '" + contact.getattr_repeat_4_attr_name() + "', "
                + COLUMN_attr_repeat_4_attr_website + " = '" + contact.getattr_repeat_4_attr_website() + "', "
                + COLUMN_attr_repeat_4_attr_picture + " = '" + contact.getattr_repeat_4_attr_picture() + "', "
                + COLUMN_attr_repeat_4_attr_descript + " = '" + contact.getattr_repeat_4_attr_descript() + "', "
                + COLUMN_attr_repeat_4_attr_map + " = '" + contact.getattr_repeat_4_attr_map() + "', "
                + COLUMN_attr_repeat_4_attr_map_address + " = '" + contact.getattr_repeat_4_attr_map_address() + "', "
                + COLUMN_attr_repeat_4_attr_map_lat + " = '" + contact.getattr_repeat_4_attr_map_lat() + "', "
                + COLUMN_attr_repeat_4_attr_map_lng + " = '" + contact.getattr_repeat_4_attr_map_lng() + "', "
                + COLUMN_ent_1_ent_type + " = '" + contact.getent_1_ent_type() + "', "
                + COLUMN_ent_1_ent_name + " = '" + contact.getent_1_ent_name() + "', "
                + COLUMN_ent_1_ent_website + " = '" + contact.getent_1_ent_website() + "', "
                + COLUMN_ent_1_ent_phone + " = '" + contact.getent_1_ent_phone() + "', "
                + COLUMN_ent_1_ent_map + " = '" + contact.getent_1_ent_map() + "', "
                + COLUMN_ent_1_ent_map_address + " = '" + contact.getent_1_ent_map_address() + "', "
                + COLUMN_ent_1_ent_map_lat + " = '" + contact.getent_1_ent_map_lat() + "', "
                + COLUMN_ent_1_ent_map_lng + " = '" + contact.getent_1_ent_map_lng() + "', "
                + COLUMN_ent_2_ent_type + " = '" + contact.getent_2_ent_type() + "', "
                + COLUMN_ent_2_ent_name + " = '" + contact.getent_2_ent_name() + "', "
                + COLUMN_ent_2_ent_website + " = '" + contact.getent_2_ent_website() + "', "
                + COLUMN_ent_2_ent_phone + " = '" + contact.getent_2_ent_phone() + "', "
                + COLUMN_ent_2_ent_map + " = '" + contact.getent_2_ent_map() + "', "
                + COLUMN_ent_2_ent_map_address + " = '" + contact.getent_2_ent_map_address() + "', "
                + COLUMN_ent_2_ent_map_lat + " = '" + contact.getent_2_ent_map_lat() + "', "
                + COLUMN_ent_2_ent_map_lng + " = '" + contact.getent_2_ent_map_lng() + "', "
                + COLUMN_ent_3_ent_type + " = '" + contact.getent_3_ent_type() + "', "
                + COLUMN_ent_3_ent_name + " = '" + contact.getent_3_ent_name() + "', "
                + COLUMN_ent_3_ent_website + " = '" + contact.getent_3_ent_website() + "', "
                + COLUMN_ent_3_ent_phone + " = '" + contact.getent_3_ent_phone() + "', "
                + COLUMN_ent_3_ent_map + " = '" + contact.getent_3_ent_map() + "', "
                + COLUMN_ent_3_ent_map_address + " = '" + contact.getent_3_ent_map_address() + "', "
                + COLUMN_ent_3_ent_map_lat + " = '" + contact.getent_3_ent_map_lat() + "', "
                + COLUMN_ent_3_ent_map_lng + " = '" + contact.getent_3_ent_map_lng() + "', "
                + COLUMN_ent_4_ent_type + " = '" + contact.getent_4_ent_type() + "', "
                + COLUMN_ent_4_ent_name + " = '" + contact.getent_4_ent_name() + "', "
                + COLUMN_ent_4_ent_website + " = '" + contact.getent_4_ent_website() + "', "
                + COLUMN_ent_4_ent_phone + " = '" + contact.getent_4_ent_phone() + "', "
                + COLUMN_ent_4_ent_map + " = '" + contact.getent_4_ent_map() + "', "
                + COLUMN_ent_4_ent_map_address + " = '" + contact.getent_4_ent_map_address() + "', "
                + COLUMN_ent_4_ent_map_lat + " = '" + contact.getent_4_ent_map_lat() + "', "
                + COLUMN_ent_4_ent_map_lng + " = '" + contact.getent_4_ent_map_lng() + "', "
                + COLUMN_ent_5_ent_type + " = '" + contact.getent_5_ent_type() + "', "
                + COLUMN_ent_5_ent_name + " = '" + contact.getent_5_ent_name() + "', "
                + COLUMN_ent_5_ent_website + " = '" + contact.getent_5_ent_website() + "', "
                + COLUMN_ent_5_ent_phone + " = '" + contact.getent_5_ent_phone() + "', "
                + COLUMN_ent_5_ent_map + " = '" + contact.getent_5_ent_map() + "', "
                + COLUMN_ent_5_ent_map_address + " = '" + contact.getent_5_ent_map_address() + "', "
                + COLUMN_ent_5_ent_map_lat + " = '" + contact.getent_5_ent_map_lat() + "', "
                + COLUMN_ent_5_ent_map_lng + " = '" + contact.getent_5_ent_map_lng() + "', "
                + COLUMN_ent_6_ent_type + " = '" + contact.getent_6_ent_type() + "', "
                + COLUMN_ent_6_ent_name + " = '" + contact.getent_6_ent_name() + "', "
                + COLUMN_ent_6_ent_website + " = '" + contact.getent_6_ent_website() + "', "
                + COLUMN_ent_6_ent_phone + " = '" + contact.getent_6_ent_phone() + "', "
                + COLUMN_ent_6_ent_map + " = '" + contact.getent_6_ent_map() + "', "
                + COLUMN_ent_6_ent_map_address + " = '" + contact.getent_6_ent_map_address() + "', "
                + COLUMN_ent_6_ent_map_lat + " = '" + contact.getent_6_ent_map_lat() + "', "
                + COLUMN_ent_6_ent_map_lng + " = '" + contact.getent_6_ent_map_lng() + "', "
                + COLUMN_ent_7_ent_type + " = '" + contact.getent_7_ent_type() + "', "
                + COLUMN_ent_7_ent_name + " = '" + contact.getent_7_ent_name() + "', "
                + COLUMN_ent_7_ent_website + " = '" + contact.getent_7_ent_website() + "', "
                + COLUMN_ent_7_ent_phone + " = '" + contact.getent_7_ent_phone() + "', "
                + COLUMN_ent_7_ent_map + " = '" + contact.getent_7_ent_map() + "', "
                + COLUMN_ent_7_ent_map_address + " = '" + contact.getent_7_ent_map_address() + "', "
                + COLUMN_ent_7_ent_map_lat + " = '" + contact.getent_7_ent_map_lat() + "', "
                + COLUMN_ent_7_ent_map_lng + " = '" + contact.getent_7_ent_map_lng() + "', "
                + COLUMN_ent_8_ent_type + " = '" + contact.getent_8_ent_type() + "', "
                + COLUMN_ent_8_ent_name + " = '" + contact.getent_8_ent_name() + "', "
                + COLUMN_ent_8_ent_website + " = '" + contact.getent_8_ent_website() + "', "
                + COLUMN_ent_8_ent_phone + " = '" + contact.getent_8_ent_phone() + "', "
                + COLUMN_ent_8_ent_map + " = '" + contact.getent_8_ent_map() + "', "
                + COLUMN_ent_8_ent_map_address + " = '" + contact.getent_8_ent_map_address() + "', "
                + COLUMN_ent_8_ent_map_lat + " = '" + contact.getent_8_ent_map_lat() + "', "
                + COLUMN_ent_8_ent_map_lng + " = '" + contact.getent_8_ent_map_lng() + "', "
                + COLUMN_rsb_3_rbs_type + " = '" + contact.getrsb_3_rbs_type() + "', "
                + COLUMN_rsb_3_rbs_name + " = '" + contact.getrsb_3_rbs_name() + "', "
                + COLUMN_rsb_3_rbs_website + " = '" + contact.getrsb_3_rbs_website() + "', "
                + COLUMN_rsb_3_rbs_phone + " = '" + contact.getrsb_3_rbs_phone() + "', "
                + COLUMN_rsb_3_rbs_map + " = '" + contact.getrsb_3_rbs_map() + "', "
                + COLUMN_rsb_3_rbs_map_address + " = '" + contact.getrsb_3_rbs_map_address() + "', "
                + COLUMN_rsb_3_rbs_map_lat + " = '" + contact.getrsb_3_rbs_map_lat() + "', "
                + COLUMN_rsb_3_rbs_map_lng + " = '" + contact.getrsb_3_rbs_map_lng() + "', "
                + COLUMN_rsb_4_rbs_type + " = '" + contact.getrsb_4_rbs_type() + "', "
                + COLUMN_rsb_4_rbs_name + " = '" + contact.getrsb_4_rbs_name() + "', "
                + COLUMN_rsb_4_rbs_website + " = '" + contact.getrsb_4_rbs_website() + "', "
                + COLUMN_rsb_4_rbs_phone + " = '" + contact.getrsb_4_rbs_phone() + "', "
                + COLUMN_rsb_4_rbs_map + " = '" + contact.getrsb_4_rbs_map() + "', "
                + COLUMN_rsb_4_rbs_map_address + " = '" + contact.getrsb_4_rbs_map_address() + "', "
                + COLUMN_rsb_4_rbs_map_lat + " = '" + contact.getrsb_4_rbs_map_lat() + "', "
                + COLUMN_rsb_4_rbs_map_lng + " = '" + contact.getrsb_4_rbs_map_lng() + "', "
                + COLUMN_rsb_5_rbs_type + " = '" + contact.getrsb_5_rbs_type() + "', "
                + COLUMN_rsb_5_rbs_name + " = '" + contact.getrsb_5_rbs_name() + "', "
                + COLUMN_rsb_5_rbs_website + " = '" + contact.getrsb_5_rbs_website() + "', "
                + COLUMN_rsb_5_rbs_phone + " = '" + contact.getrsb_5_rbs_phone() + "', "
                + COLUMN_rsb_5_rbs_map + " = '" + contact.getrsb_5_rbs_map() + "', "
                + COLUMN_rsb_5_rbs_map_address + " = '" + contact.getrsb_5_rbs_map_address() + "', "
                + COLUMN_rsb_5_rbs_map_lat + " = '" + contact.getrsb_5_rbs_map_lat() + "', "
                + COLUMN_rsb_5_rbs_map_lng + " = '" + contact.getrsb_5_rbs_map_lng() + "', "
                + COLUMN_rsb_6_rbs_type + " = '" + contact.getrsb_6_rbs_type() + "', "
                + COLUMN_rsb_6_rbs_name + " = '" + contact.getrsb_6_rbs_name() + "', "
                + COLUMN_rsb_6_rbs_website + " = '" + contact.getrsb_6_rbs_website() + "', "
                + COLUMN_rsb_6_rbs_phone + " = '" + contact.getrsb_6_rbs_phone() + "', "
                + COLUMN_rsb_6_rbs_map + " = '" + contact.getrsb_6_rbs_map() + "', "
                + COLUMN_rsb_6_rbs_map_address + " = '" + contact.getrsb_6_rbs_map_address() + "', "
                + COLUMN_rsb_6_rbs_map_lat + " = '" + contact.getrsb_6_rbs_map_lat() + "', "
                + COLUMN_rsb_6_rbs_map_lng + " = '" + contact.getrsb_6_rbs_map_lng() + "', "
                + COLUMN_rsb_7_rbs_type + " = '" + contact.getrsb_7_rbs_type() + "', "
                + COLUMN_rsb_7_rbs_name + " = '" + contact.getrsb_7_rbs_name() + "', "
                + COLUMN_rsb_7_rbs_website + " = '" + contact.getrsb_7_rbs_website() + "', "
                + COLUMN_rsb_7_rbs_phone + " = '" + contact.getrsb_7_rbs_phone() + "', "
                + COLUMN_rsb_7_rbs_map + " = '" + contact.getrsb_7_rbs_map() + "', "
                + COLUMN_rsb_7_rbs_map_address + " = '" + contact.getrsb_7_rbs_map_address() + "', "
                + COLUMN_rsb_7_rbs_map_lat + " = '" + contact.getrsb_7_rbs_map_lat() + "', "
                + COLUMN_rsb_7_rbs_map_lng + " = '" + contact.getrsb_7_rbs_map_lng() + "', "
                + COLUMN_rsb_8_rbs_type + " = '" + contact.getrsb_8_rbs_type() + "', "
                + COLUMN_rsb_8_rbs_name + " = '" + contact.getrsb_8_rbs_name() + "', "
                + COLUMN_rsb_8_rbs_website + " = '" + contact.getrsb_8_rbs_website() + "', "
                + COLUMN_rsb_8_rbs_phone + " = '" + contact.getrsb_8_rbs_phone() + "', "
                + COLUMN_rsb_8_rbs_map + " = '" + contact.getrsb_8_rbs_map() + "', "
                + COLUMN_rsb_8_rbs_map_address + " = '" + contact.getrsb_8_rbs_map_address() + "', "
                + COLUMN_rsb_8_rbs_map_lat + " = '" + contact.getrsb_8_rbs_map_lat() + "', "
                + COLUMN_rsb_8_rbs_map_lng + " = '" + contact.getrsb_8_rbs_map_lng() + "', "
                + COLUMN_name + " = '" + contact.getname() + "' where "
                + COLUMN_ID + " = '" + contact.getID() + "'");


        // updating row alternat
        database.close();
    }
    /*done*/

    /*done*/
    // Deleting single contact
    public void deleteContact() {
        database = this.getReadableDatabase();
        database.delete(TABLE_NAME, null, null);
        database.close();
    }
    /*done*/

    /*done*/
    public void deleteAllRecordsAlternate() {
        database = this.getReadableDatabase();
        database.execSQL("delete from " + TABLE_NAME);
        database.close();
    }
    /*done*/


    /*done*/
   /* public void deleteRecord(Contact contact) {
        database = this.getReadableDatabase();
        database.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{contact.getID()});
        database.close();
    }*/
    /*done*/


    /*done*/
    // Getting contacts Count
    public ArrayList<String> getAllTableName() {
        database = this.getReadableDatabase();
        ArrayList<String> allTableNames = new ArrayList<String>();
        Cursor cursor = database.rawQuery("SELECT a_name FROM sqlite_master WHERE type='table'", null);
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                allTableNames.add(cursor.getString(cursor.getColumnIndex("a_name")));
            }
        }
        cursor.close();
        database.close();
        return allTableNames;
    }
    /*done*/


    /*********************************** NOT IN USE***************************************/

}