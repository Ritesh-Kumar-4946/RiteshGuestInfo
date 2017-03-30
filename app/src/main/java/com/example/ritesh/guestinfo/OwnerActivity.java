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
 * Created by ritesh on 10/11/16.
 */

public class OwnerActivity extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout = null;
    @BindView(R.id.toolbar_accomodation)
    Toolbar toolbaraccommodation;

    Bitmap bitmaptoolbarimage;

    @BindView(R.id.tv_owner_fname)
    TextView ofname;

    @BindView(R.id.tv_owner_lname)
    TextView olname;

    @BindView(R.id.tv_owner_address)
    TextView oaddress;

    @BindView(R.id.tv_owner_zip)
    TextView ozip;

    @BindView(R.id.tv_owner_town)
    TextView otown;

    @BindView(R.id.tv_owner_country)
    TextView ocountry;

    @BindView(R.id.tv_owner_language)
    TextView olanguage;

    @BindView(R.id.tv_owner_telephonne)
    TextView otelephone;

    @BindView(R.id.tv_owner_mobilee)
    TextView omobile;

    @BindView(R.id.tv_owner_emmaill)
    TextView oemail;

    @BindView(R.id.tv_owner_facebookpage)
    TextView ofacebook;

    @BindView(R.id.tv_owner_twitterpage)
    TextView otweet;

    @BindView(R.id.tv_owner_skypepage)
    TextView oskyppe;

    @BindView(R.id.rlmain_owner_fname)
    RelativeLayout OFnameactivity;

    @BindView(R.id.rlmain_owner_lname)
    RelativeLayout OLastnamectivity;

    @BindView(R.id.rlmain_owner_address)
    RelativeLayout OAddressactivity;

    @BindView(R.id.rlmain_owner_zip)
    RelativeLayout OZipactivity;

    @BindView(R.id.rlmain_owner_town)
    RelativeLayout OTownactivity;

    @BindView(R.id.rlmain_owner_country)
    RelativeLayout OCountryactivity;

    @BindView(R.id.rlmain_owner_language)
    RelativeLayout OLanguageactivity;

    @BindView(R.id.rlmain_owner_telephonne)
    RelativeLayout telephoneactivity;

    @BindView(R.id.rlmain_owner_mobilee)
    RelativeLayout mobileactivity;

    @BindView(R.id.rlmain_owner_emmaill)
    RelativeLayout emailactivity;

    @BindView(R.id.rlmain_owner_facebookpage)
    RelativeLayout faceboooklactivity;

    @BindView(R.id.rlmain_owner_twitterpage)
    RelativeLayout twitteeerrlactivity;

    @BindView(R.id.rlmain_owner_skypepage)
    RelativeLayout skyyypelactivity;

    String o_firstname,
            o_lastname,
            o_address,
            o_zip,
            o_town,
            o_country,
            o_telephone,
            o_mobile,
            o_email,
            o_skype,
            o_facebook,
            o_twitter,
            o_language;
    DatabaseHandler db = new DatabaseHandler(this);



    @BindView(R.id.tv_owner_aoname)
    TextView tvwelcome_accomodation;
    @BindView(R.id.iv_owner_image_one)
    ImageView aoImageOne;
    @BindView(R.id.iv_owner_image_two)
    ImageView aoImageTwo;

    String logoImagepath = "", pictureImagepath = "", name;
    Bitmap bitmaplogo;
    Bitmap bitmappicture;
    File SharedLogoImage, SharedPictureImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);
        ButterKnife.bind(this);

        // Reading all contacts
        Log.e("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.Get_All_Contacts();

        for (Contact cn : contacts) {
            String log =
                    "Id: " + cn.getID()
                            + " ,getPOST_ID: " + cn.getPOST_ID()
                            + " ,geto_firstname: " + cn.geto_firstname()
                            + " ,geto_lastname: " + cn.geto_lastname()
                            + " ,geto_address: " + cn.geto_address()
                            + " ,geto_zip: " + cn.geto_zip()
                            + " ,geto_town: " + cn.geto_town()
                            + " ,geto_country: " + cn.geto_country()
                            + " ,geto_telephone: " + cn.geto_telephone()
                            + " ,geto_mobile: " + cn.geto_mobile()
                            + " ,geto_email: " + cn.geto_email()
                            + " ,geto_skype: " + cn.geto_skype()
                            + " ,geto_facebook: " + cn.geto_facebook()
                            + " ,geto_twitter: " + cn.geto_twitter()
                            + " ,geto_language: " + cn.geto_language()
                            + " ,geta_logo_image: " + cn.geta_logo_image()
                            + " ,geta_picture_image: " + cn.geta_picture_image()
                            + " ,getname: " + cn.getname();
            // Writing Contacts to log
            Log.e("Owner Sqlite Data: ", log);
            o_firstname = cn.geto_firstname();
            o_lastname =cn.geto_lastname();
            o_address =cn.geto_address();
            o_zip =cn.geto_zip();
            o_town =cn.geto_town();
            o_country =cn.geto_country();
            o_telephone =cn.geto_telephone();
            o_mobile =cn.geto_mobile();
            o_email =cn.geto_email();
            o_facebook = cn.geto_facebook();
            o_twitter = cn.geto_twitter();
            o_skype = cn.geto_skype();
            o_language = cn.geto_language();
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

            if (o_firstname != null && !o_firstname.isEmpty()){
                ofname.setText(o_firstname);
                Log.e("o_firstname is NOT null :", "YES");
            }else {
                OFnameactivity.setVisibility(View.GONE);
                Log.e("o_firstname is null :", "YES");
            }

            if (o_lastname != null && !o_lastname.isEmpty()){
                olname.setText(o_lastname);
                Log.e("o_lastname is NOT null :", "YES");
            }else {
                OLastnamectivity.setVisibility(View.GONE);
                Log.e("o_lastname is null :", "YES");
            }

            if (o_zip != null && !o_zip.isEmpty()){
                ozip.setText(o_zip);
                Log.e("o_zip is NOT null :", "YES");
            }else {
                OZipactivity.setVisibility(View.GONE);
                Log.e("o_zip is null :", "YES");
            }

            if (o_town != null && !o_town.isEmpty()){
                otown.setText(o_town);
                Log.e("o_town is NOT null :", "YES");
            }else {
                OTownactivity.setVisibility(View.GONE);
                Log.e("o_town is null :", "YES");
            }

            if (o_country != null && !o_country.isEmpty()){
                ocountry.setText(o_country);
                Log.e("o_country is NOT null :", "YES");
            }else {
                OCountryactivity.setVisibility(View.GONE);
                Log.e("o_country is null :", "YES");
            }

            if (o_language != null && !o_language.isEmpty()){
                olanguage.setText(o_language);
                Log.e("o_language is NOT null :", "YES");
            }else {
                OLanguageactivity.setVisibility(View.GONE);
                Log.e("o_language is null :", "YES");
            }

            if (o_telephone != null && !o_telephone.isEmpty()){
                otelephone.setText(o_telephone);
                Log.e("o_telephone is NOT null :", "YES");
            }else {
                telephoneactivity.setVisibility(View.GONE);
                Log.e("o_telephone is null :", "YES");
            }

            if (o_address != null && !o_address.isEmpty()){
                oaddress.setText(o_address);
                Log.e("o_address is NOT null :", "YES");
            }else {
                OAddressactivity.setVisibility(View.GONE);
                Log.e("o_address is null :", "YES");
            }


            if (o_mobile != null && !o_mobile.isEmpty()){
                omobile.setText(o_mobile);
                Log.e("o_mobile is NOT null :", "YES");
            }else {
                mobileactivity.setVisibility(View.GONE);
                Log.e("o_mobile is null :", "YES");
            }

            if (o_email != null && !o_email.isEmpty()){
                oemail.setText(o_email);
                Log.e("o_email is NOT null :", "YES");
            }else {
                emailactivity.setVisibility(View.GONE);
                Log.e("o_email is null :", "YES");
            }

            if (o_facebook != null && !o_facebook.isEmpty()){
                ofacebook.setText(o_facebook);
                Log.e("o_facebook is NOT null :", "YES");
            }else {
                faceboooklactivity.setVisibility(View.GONE);
                Log.e("o_facebook is null :", "YES");
            }

            if (o_twitter != null && !o_twitter.isEmpty()){
                otweet.setText(o_twitter);
                Log.e("o_twitter is NOT null :", "YES");
            }else {
                twitteeerrlactivity.setVisibility(View.GONE);
                Log.e("o_twitter is null :", "YES");

            }

            if (o_skype != null && !o_skype.isEmpty()){
                oskyppe.setText(o_skype);
                Log.e("o_skype is NOT null :", "YES");
            }else {
                skyyypelactivity.setVisibility(View.GONE);
                Log.e("o_skype is null :", "YES");
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

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + o_telephone));
                startActivity(intent);
            }
        });

        mobileactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + o_mobile));
                startActivity(intent);
            }
        });

        emailactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{o_email});
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
                        Uri uri = Uri.parse(o_facebook);
                        startActivity(new Intent(Intent.ACTION_VIEW, uri));
                    } else {
                        Log.e(" Facebook App Old Version :", "" +versionCode);
                        Uri uri = Uri.parse(o_facebook);
                        startActivity(new Intent(Intent.ACTION_VIEW, uri));
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(o_facebook)));
                }
            }
        });

        twitteeerrlactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isPackageExisted("com.twitter.android")) {

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/" + o_twitter));
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/" + o_twitter));
                    startActivity(intent);
                }
            }
        });

        skyyypelactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sky = new Intent("android.intent.action.VIEW");
                sky.setData(Uri.parse("skype:" + o_skype));
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
