package com.example.ritesh.guestinfo;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ritesh on 9/11/16.
 */

public class LocalContactPerson extends AppCompatActivity {

    private CollapsingToolbarLayout collapsingToolbarLayout = null;
    @BindView(R.id.toolbar_accomodation)
    Toolbar toolbaraccommodation;

    Bitmap bitmaptoolbarimage;
    String l_firstname,
            l_lastname,
            l_address,
            l_zip,
            l_town,
            l_country,
            l_telephone,
            l_mobile,
            l_email,
            l_skype,
            l_facebook,
            l_twitter,
            l_language;
    DatabaseHandler db = new DatabaseHandler(this);

    @BindView(R.id.tv_localper_fname)
    TextView lfname;

    @BindView(R.id.tv_localper_lname)
    TextView llname;

    @BindView(R.id.tv_localper_address)
    TextView laddress;

    @BindView(R.id.tv_localper_zip)
    TextView lzip;

    @BindView(R.id.tv_localper_town)
    TextView ltown;

    @BindView(R.id.tv_localper_country)
    TextView lcountry;

    @BindView(R.id.tv_localper_language)
    TextView llanguage;

    @BindView(R.id.tv_localper_telephonne)
    TextView ltelephone;

    @BindView(R.id.tv_localper_mobilee)
    TextView lmobile;

    @BindView(R.id.tv_localper_emmaill)
    TextView lemail;

    @BindView(R.id.tv_local_facebookpage)
    TextView lfacebook;

    @BindView(R.id.tv_localper_twitterpage)
    TextView ltweet;

    @BindView(R.id.tv_localper_skypepage)
    TextView lskyppe;

    @BindView(R.id.rlmain_localper_fname)
    RelativeLayout rllocalper_fname;

    @BindView(R.id.rlmain_localper_lname)
    RelativeLayout rllocalper_lname;

    @BindView(R.id.rlmain_localper_address)
    RelativeLayout rllocalper_address;

    @BindView(R.id.rlmain_localper_zip)
    RelativeLayout rllocalper_zip;

    @BindView(R.id.rlmain_localper_town)
    RelativeLayout rllocalper_town;

    @BindView(R.id.rlmain_localper_country)
    RelativeLayout rllocalper_country;

    @BindView(R.id.rlmain_localper_language)
    RelativeLayout rllocalper_language;

    @BindView(R.id.rlmain_localper_telephonne)
    RelativeLayout telephoneactivity;

    @BindView(R.id.rlmain_localper_mobilee)
    RelativeLayout mobileactivity;

    @BindView(R.id.rlmain_localper_emmaill)
    RelativeLayout emailactivity;

    @BindView(R.id.rlmain_localper_facebookpage)
    RelativeLayout faceboooklactivity;

    @BindView(R.id.rlmain_localper_twitterpage)
    RelativeLayout twitteeerrlactivity;

    @BindView(R.id.rlmain_localper_skypepage)
    RelativeLayout skyyypelactivity;

    @BindView(R.id.tv_localcont_aoname)
    TextView tvwelcome_accomodation;
    @BindView(R.id.iv_localcont_image_one)
    ImageView aoImageOne;
    @BindView(R.id.iv_localcont_image_two)
    ImageView aoImageTwo;

    String logoImagepath = "", pictureImagepath = "", name;
    Bitmap bitmaplogo;
    Bitmap bitmappicture;
    File SharedLogoImage, SharedPictureImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localcontactperson);
        ButterKnife.bind(this);
        // Reading all contacts
        Log.e("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.Get_All_Contacts();

        for (Contact cn : contacts) {
            String log =
                    "Id: " + cn.getID()
                            + " ,getPOST_ID: " + cn.getPOST_ID()
                            + " ,getl_firstname: " + cn.getl_firstname()
                            + " ,getl_lastname: " + cn.getl_lastname()
                            + " ,getl_address: " + cn.getl_address()
                            + " ,getl_zip: " + cn.getl_zip()
                            + " ,getl_town: " + cn.getl_town()
                            + " ,getl_country: " + cn.getl_country()
                            + " ,getl_telephone: " + cn.getl_telephone()
                            + " ,getl_mobile: " + cn.getl_mobile()
                            + " ,getl_email: " + cn.getl_email()
                            + " ,getl_skype: " + cn.getl_skype()
                            + " ,getl_facebook: " + cn.getl_facebook()
                            + " ,getl_twitter: " + cn.getl_twitter()
                            + " ,getl_language: " + cn.getl_language()
                            + " ,geta_logo_image: " + cn.geta_logo_image()
                            + " ,geta_picture_image: " + cn.geta_picture_image()
                            + " ,getname: " + cn.getname();
            // Writing Contacts to log
            Log.e("Local Contact Person Sqlite Data: ", log);
            l_firstname = cn.getl_firstname();
            l_lastname =cn.getl_lastname();
            l_address =cn.getl_address();
            l_zip =cn.getl_zip();
            l_town =cn.getl_town();
            l_country =cn.getl_country();
            l_language =cn.getl_language();
            l_telephone =cn.getl_telephone();
            l_mobile =cn.getl_mobile();
            l_email =cn.getl_email();
            l_facebook = cn.getl_facebook();
            l_twitter = cn.getl_twitter();
            l_skype = cn.getl_skype();

            tvwelcome_accomodation.setText(cn.getname());
            logoImagepath = cn.geta_logo_image();
            pictureImagepath = cn.geta_picture_image();

            if (logoImagepath != null && !logoImagepath.isEmpty()) {
                Log.e("logoImagepath is NOT null :", "YES");
//                    tvwelcomparent.setText(Html.fromHtml(a_welcome));
                SharedLogoImage = new File(logoImagepath);
                Log.e(" ********** final Logo image from file **********", "" + logoImagepath);

                if (SharedLogoImage.exists()) {

                    long length = SharedLogoImage.length();
                    length = length / 1024;

                    double bytes = SharedLogoImage.length();
                    double kilobytes = (bytes / 1024);
                    double megabytes = (kilobytes / 1024);
                    double gigabytes = (megabytes / 1024);

                    Log.e("Image Size :", "" + bytes + "\n" + "" + kilobytes + "\n" + "" + megabytes);
                    Log.e("Image Size :", "" + kilobytes + "\n" + "" + megabytes);

                    if (SharedLogoImage.length() >= 1048576) {
                        Log.e("Image Size is greater than 1 mb :", "YES");

                /*http://stackoverflow.com/questions/5125779/how-to-compress-image-for-imageview-in-android*/
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inTempStorage = new byte[24 * 1024];
                        options.inJustDecodeBounds = false;
                        options.inSampleSize = 2;
                        bitmaplogo = BitmapFactory.decodeFile(SharedLogoImage.getAbsolutePath(), options);
                        Bitmap b1 = ThumbnailUtils.extractThumbnail(bitmaplogo, 1024, 1024);
                        aoImageOne.setImageBitmap(b1);
                        if (bitmaplogo != null) {
                            bitmaplogo.recycle();
                            Log.e("bitmaplogo recycle 1", "YES");
                        }
                        bitmaplogo = BitmapFactory.decodeFile(SharedLogoImage.getAbsolutePath(), options);
                        Bitmap b2 = ThumbnailUtils.extractThumbnail(bitmaplogo, 1024, 1024);  // 1024 , 1024 is image size after convert
                        aoImageOne.setImageBitmap(b2);

                        int oldWidth = b2.getWidth();
                        int oldHeight = b2.getHeight();
                        Log.e("Image Height (b2):", "" + oldHeight + "\n" + "Image Width (b2) :" + "" + oldWidth);

                        if (bitmaplogo != null) {
                            bitmaplogo.recycle();
                            Log.e("bitmaplogo recycle 2", "YES");
                        }
                /*http://stackoverflow.com/questions/5125779/how-to-compress-image-for-imageview-in-android*/

                    } else {

                        bitmaplogo = BitmapFactory.decodeFile(SharedLogoImage.getAbsolutePath());

                        int oldWidth = bitmaplogo.getWidth();
                        int oldHeight = bitmaplogo.getHeight();

                        Log.e("Image Height (bitmaplogo) :", "" + oldHeight + "\n" + "Image Width (bitmaplogo) :" + "" + oldWidth);

                        aoImageOne.setImageBitmap(bitmaplogo);
                        Log.e("Image Size is greater than 1 mb :", "NO");
                    }


                } else {
                    Log.e("File does not exists!", "YES");
                }

                Log.e(" original bitmap bitmaplogo : ", "" + bitmaplogo);


            } else {

                Log.e("logoImagepath is null :", "YES");
            }


            if (pictureImagepath != null && !pictureImagepath.isEmpty()) {
                Log.e("pictureImagepath is NOT null :", "YES");
//                    tvwelcomparent.setText(Html.fromHtml(a_welcome));
                SharedPictureImage = new File(pictureImagepath);
                Log.e(" ********** final Picture image from file **********", "" + pictureImagepath);

                if (SharedPictureImage.exists()) {

                    long length = SharedPictureImage.length();
                    length = length / 1024;

                    double bytes = SharedPictureImage.length();
                    double kilobytes = (bytes / 1024);
                    double megabytes = (kilobytes / 1024);
                    double gigabytes = (megabytes / 1024);

                    Log.e("Image Size :", "" + bytes + "\n" + "" + kilobytes + "\n" + "" + megabytes);
                    Log.e("Image Size :", "" + kilobytes + "\n" + "" + megabytes);

                    if (SharedLogoImage.length() >= 1048576) {
                        Log.e("Image Size is greater than 1 mb :", "YES");

                /*http://stackoverflow.com/questions/5125779/how-to-compress-image-for-imageview-in-android*/
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inTempStorage = new byte[24 * 1024];
                        options.inJustDecodeBounds = false;
                        options.inSampleSize = 2;
                        bitmappicture = BitmapFactory.decodeFile(SharedPictureImage.getAbsolutePath(), options);
                        Bitmap b1 = ThumbnailUtils.extractThumbnail(bitmappicture, 1024, 1024);
                        aoImageTwo.setImageBitmap(b1);
                        if (bitmappicture != null) {
                            bitmappicture.recycle();
                            Log.e("bitmaplogo recycle 1", "YES");
                        }
                        bitmappicture = BitmapFactory.decodeFile(SharedPictureImage.getAbsolutePath(), options);
                        Bitmap b2 = ThumbnailUtils.extractThumbnail(bitmappicture, 1024, 1024);  // 1024 , 1024 is image size after convert
                        aoImageTwo.setImageBitmap(b2);

                        int oldWidth = b2.getWidth();
                        int oldHeight = b2.getHeight();
                        Log.e("Image Height (b2):", "" + oldHeight + "\n" + "Image Width (b2) :" + "" + oldWidth);

                        if (bitmappicture != null) {
                            bitmappicture.recycle();
                            Log.e("bitmaplogo recycle 2", "YES");
                        }
                /*http://stackoverflow.com/questions/5125779/how-to-compress-image-for-imageview-in-android*/

                    } else {

                        bitmappicture = BitmapFactory.decodeFile(SharedPictureImage.getAbsolutePath());

                        int oldWidth = bitmappicture.getWidth();
                        int oldHeight = bitmappicture.getHeight();

                        Log.e("Image Height (bitmappicture) :", "" + oldHeight + "\n" + "Image Width (bitmappicture) :" + "" + oldWidth);

                        aoImageTwo.setImageBitmap(bitmappicture);
                        Log.e("Image Size is greater than 1 mb :", "NO");
                    }

                } else {
                    Log.e("File does not exists!", "YES");
                }

                Log.e(" original bitmap bitmappicture : ", "" + bitmappicture);


            } else {
                Log.e("pictureImagepath is null :", "YES");
            }




            if (l_firstname != null && !l_firstname.isEmpty()){
                lfname.setText(l_firstname);
                Log.e("l_firstname is NOT null :", "YES");
            }else {
                rllocalper_fname.setVisibility(View.GONE);
                Log.e("l_firstname is null :", "YES");
            }

            if (l_lastname != null && !l_lastname.isEmpty()){
                llname.setText(l_lastname);
                Log.e("l_lastname is NOT null :", "YES");
            }else {
                rllocalper_lname.setVisibility(View.GONE);
                Log.e("l_lastname is null :", "YES");
            }

            if (l_address != null && !l_address.isEmpty()){
                laddress.setText(l_address);
                Log.e("l_address is NOT null :", "YES");
            }else {
                rllocalper_address.setVisibility(View.GONE);
                Log.e("l_address is null :", "YES");
            }

            if (l_zip != null && !l_zip.isEmpty()){
                lzip.setText(l_zip);
                Log.e("l_zip is NOT null :", "YES");
            }else {
                rllocalper_zip.setVisibility(View.GONE);
                Log.e("l_zip is null :", "YES");
            }

            if (l_town != null && !l_town.isEmpty()){
                ltown.setText(l_town);
                Log.e("l_town is NOT null :", "YES");
            }else {
                rllocalper_town.setVisibility(View.GONE);
                Log.e("l_town is null :", "YES");
            }

            if (l_country != null && !l_country.isEmpty()){
                lcountry.setText(l_country);
                Log.e("l_country is NOT null :", "YES");
            }else {
                rllocalper_country.setVisibility(View.GONE);
                Log.e("l_country is null :", "YES");
            }

            if (l_language != null && !l_language.isEmpty()){
                llanguage.setText(l_language);
                Log.e("l_language is NOT null :", "YES");
            }else {
                rllocalper_language.setVisibility(View.GONE);
                Log.e("l_language is null :", "YES");
            }

            if (l_telephone != null && !l_telephone.isEmpty()){
                ltelephone.setText(l_telephone);
                Log.e("l_telephone is NOT null :", "YES");
            }else {
                telephoneactivity.setVisibility(View.GONE);
                Log.e("l_telephone is null :", "YES");
            }

            if (l_mobile != null && !l_mobile.isEmpty()){
                lmobile.setText(l_mobile);
                Log.e("l_mobile is NOT null :", "YES");
            }else {
                mobileactivity.setVisibility(View.GONE);
                Log.e("l_mobile is null :", "YES");
            }

            if (l_email != null && !l_email.isEmpty()){
                lemail.setText(l_email);
                Log.e("l_email is NOT null :", "YES");
            }else {
                emailactivity.setVisibility(View.GONE);
                Log.e("l_email is null :", "YES");
            }

            if (l_facebook != null && !l_facebook.isEmpty()){
                lfacebook.setText(l_facebook);
                Log.e("l_facebook is NOT null :", "YES");
            }else {
                faceboooklactivity.setVisibility(View.GONE);
                Log.e("l_facebook is null :", "YES");
            }

            if (l_twitter != null && !l_twitter.isEmpty()){
                ltweet.setText(l_twitter);
                Log.e("l_twitter is NOT null :", "YES");
            }else {
                twitteeerrlactivity.setVisibility(View.GONE);
                Log.e("l_twitter is null :", "YES");
            }

            if (l_skype != null && !l_skype.isEmpty()){
                lskyppe.setText(l_skype);
                Log.e("l_skype is NOT null :", "YES");
            }else {
                skyyypelactivity.setVisibility(View.GONE);
                Log.e("l_skype is null :", "YES");
            }


        }

        setSupportActionBar(toolbaraccommodation);
        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_accommodatoin);
//        collapsingToolbarLayout.setTitle(getResources().getString(R.string.guestinfo));
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        dynamicToolbarColor();
        toolbarTextAppernce();

        telephoneactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + l_telephone));
                startActivity(intent);
            }
        });

        mobileactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + l_mobile));
                startActivity(intent);
            }
        });

        emailactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{l_email});
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        faceboooklactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    int versionCode = getPackageManager().getPackageInfo("com.facebook.katana", 0).versionCode;
                    if (versionCode >= 3002850) {
                        Log.e(" Facebook App New Version :", "" +versionCode);
                        Uri uri = Uri.parse(l_facebook);
                        startActivity(new Intent(Intent.ACTION_VIEW, uri));
                    } else {
                        Log.e(" Facebook App Old Version :", "" +versionCode);
                        Uri uri = Uri.parse(l_facebook);
                        startActivity(new Intent(Intent.ACTION_VIEW, uri));
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(l_facebook)));
                }
            }
        });

        twitteeerrlactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isPackageExisted("com.twitter.android")) {

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/" + l_twitter));
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/" + l_twitter));
                    startActivity(intent);
                }
            }
        });

        skyyypelactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sky = new Intent("android.intent.action.VIEW");
                sky.setData(Uri.parse("skype:" + l_skype));
                startActivity(sky);
            }
        });

    }

    public boolean isPackageExisted(String targetPackage) {
        PackageManager pm = getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(targetPackage, PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
        return true;
    }


    private void dynamicToolbarColor() {
        bitmaptoolbarimage = BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_home);
        Palette.from(bitmaptoolbarimage).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(R.attr.colorPrimary));
                collapsingToolbarLayout.setStatusBarScrimColor(palette.getMutedColor(R.attr.colorPrimaryDark));
            }
        });
    }

    private void toolbarTextAppernce() {
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
