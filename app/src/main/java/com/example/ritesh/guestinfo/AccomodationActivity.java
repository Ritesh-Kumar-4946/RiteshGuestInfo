package com.example.ritesh.guestinfo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ritesh on 9/11/16.
 */

public class AccomodationActivity extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout = null;
    @BindView(R.id.toolbar_accomodation)
    Toolbar toolbaraccommodation;

    Bitmap bitmaptoolbarimage;

    /*@BindView(R.id.tv_ao_nameeeeeeee)
    TextView tvaoname;*/

    @BindView(R.id.rlmain_accomod_welcome_messa)
    RelativeLayout rlAccommoWelcomeActivity;

    @BindView(R.id.rlmain_accomooo_address)
    RelativeLayout rlAccommoAddressActivity;

    @BindView(R.id.rlmain_accomooo_zipp)
    RelativeLayout rlAccommoZipActivity;

    @BindView(R.id.rlmain_accomooo_townww)
    RelativeLayout rlAccommoTownActivity;

    @BindView(R.id.rlmain_accomod_conttry)
    RelativeLayout rlAccommoCountryActivity;

    @BindView(R.id.rlmain_accomo_map_addre)
    RelativeLayout rlAccommoMapAddressActivity;

    @BindView(R.id.rlmain_accomo_weblink)
    RelativeLayout rlAccommoWebLinkActivity;

    @BindView(R.id.rlmain_accomo_facebookpage)
    RelativeLayout rlAccommoFacebookActivity;

    @BindView(R.id.rlmain_accomo_twitterpage)
    RelativeLayout rlAccommoTwitterpageActivity;

    @BindView(R.id.rlmain_accomo_calll)
    RelativeLayout rlAccommoTelephoneActivity;

    @BindView(R.id.tv_accomod_welcome_messa)
    TextView tvaccomoowelcomemessage;

    @BindView(R.id.tv_accomooo_address)
    TextView tvaccomooaddress;

    @BindView(R.id.tv_accomooo_zipp)
    TextView tvaccomoozip;

    @BindView(R.id.tv_accomooo_townww)
    TextView tvaccomootown;

    @BindView(R.id.tv_accomod_counttry)
    TextView tvaccomoocountry;

    @BindView(R.id.tv_accomo_map_addre)
    TextView tvaccomooaddressMap;

    @BindView(R.id.tv_accomo_weblink)
    TextView tvaccomooweblinkk;

    @BindView(R.id.tv_accomo_facebookpage)
    TextView tvaccomoofacebookpage;

    @BindView(R.id.tv_accomo_twitterpage)
    TextView tvaccomootwitterpage;

    @BindView(R.id.tv_accomo_calll)
    TextView tvaccomootelephone;

    @BindView(R.id.iv_accomo_image_one)
    ImageView aoImageOne;

    @BindView(R.id.iv_accomo_image_two)
    ImageView aoImageTwo;

    String logoImagepath = "", pictureImagepath = "";
    Bitmap bitmaplogo;
    Bitmap bitmappicture;
    File SharedLogoImage, SharedPictureImage;

    String
            name,
            a_welcome,
            a_zip,
            a_town,
            a_country,
            a_address,
            a_map_address,
            a_map_address_lat,
            a_map_address_lng,
            a_facebook,
            a_twitter,
            a_website,
            a_telephone;

    DatabaseHandler db = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accomodation);
        ButterKnife.bind(this);
        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.Get_All_Contacts();

        for (Contact cn : contacts) {
            String log =
                    "Id: " + cn.getID()
                            + " ,getPOST_ID: " + cn.getPOST_ID()
                            + " ,getname: " + cn.getname()
                            + " ,geta_logo_image: " + cn.geta_logo_image()
                            + " ,geta_picture_image: " + cn.geta_picture_image()
                            + " ,geta_welcome: " + cn.geta_welcome()
                            + " ,geta_address: " + cn.geta_address()
                            + " ,geta_zip: " + cn.geta_zip()
                            + " ,geta_town: " + cn.geta_town()
                            + " ,geta_country: " + cn.geta_country()
                            + " ,geta_map_address: " + cn.geta_map_address()
                            + " ,geta_map_address_lat: " + cn.geta_map_address_lat()
                            + " ,geta_map_address_lng: " + cn.geta_map_address_lng()
                            + " ,geta_website: " + cn.geta_website()
                            + " ,geta_telephone: " + cn.geta_telephone()
                            + " ,geta_facebook: " + cn.geta_facebook()
                            + " ,geta_twitter: " + cn.geta_twitter();
            // Writing Contacts to log
            Log.e(" ^^^^^^ ^^^^^^^ ^^^ Accomodation Sqlite data ^^^^^^ ^^^^^^^ ^^^ : ", log);

            name= cn.getname();
            a_welcome = cn.geta_welcome();
            a_address = cn.geta_address();
            a_zip = cn.geta_zip();
            a_map_address = cn.geta_map_address();
            a_map_address_lat = cn.geta_map_address_lat();
            a_map_address_lng = cn.geta_map_address_lng();
            a_town = cn.geta_town();
            a_country = cn.geta_country();
            a_website = cn.geta_website();
            a_facebook = cn.geta_facebook();
            a_twitter = cn.geta_twitter();
            a_telephone = cn.geta_telephone();
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

            if (a_welcome !=null  && !a_welcome.isEmpty()){
                Log.e("a_welcome is NOT null :", "YES");
                tvaccomoowelcomemessage.setText(Html.fromHtml(a_welcome));
            }else {
                rlAccommoWelcomeActivity.setVisibility(View.GONE);
                Log.e("a_welcome is null :", "YES");
            }


            if (a_address !=null  && !a_address.isEmpty()){
                Log.e("a_address is NOT null :", "YES");
                tvaccomooaddress.setText(a_address);
            }else {
                rlAccommoAddressActivity.setVisibility(View.GONE);
                Log.e("a_address is null :", "YES");
            }


            if (a_zip !=null  && !a_zip.isEmpty()){
                Log.e("a_zip is NOT null :", "YES");
                tvaccomoozip.setText(a_zip);
            }else {
                rlAccommoZipActivity.setVisibility(View.GONE);
                Log.e("a_zip is null :", "YES");
            }


            if (a_town !=null  && !a_town.isEmpty()){
                Log.e("a_town is NOT null :", "YES");
                tvaccomootown.setText(a_town);
            }else {
                rlAccommoTownActivity.setVisibility(View.GONE);
                Log.e("a_town is null :", "YES");
            }


            if (a_country !=null  && !a_country.isEmpty()){
                Log.e("a_country is NOT null :", "YES");
                tvaccomoocountry.setText(a_country);
            }else {
                rlAccommoCountryActivity.setVisibility(View.GONE);
                Log.e("a_country is null :", "YES");
            }


            if (a_map_address !=null  && !a_map_address.isEmpty()){
                Log.e("a_map_address is NOT null :", "YES");
                tvaccomooaddressMap.setText(a_map_address);
            }else {
                rlAccommoMapAddressActivity.setVisibility(View.GONE);
                Log.e("a_map_addressss is null :", "YES");
            }


            if (a_website !=null  && !a_website.isEmpty()){
                Log.e("a_website is NOT null :", "YES");
                tvaccomooweblinkk.setText(a_website);
            }else {
                rlAccommoWebLinkActivity.setVisibility(View.GONE);
                Log.e("a_website is null :", "YES");
            }


            if (a_facebook !=null  && !a_facebook.isEmpty()){
                Log.e("a_facebook is NOT null :", "YES");
                tvaccomoofacebookpage.setText(a_facebook);
            }else {
                rlAccommoFacebookActivity.setVisibility(View.GONE);
                Log.e("a_facebook is null :", "YES");
            }


            if (a_twitter !=null  && !a_twitter.isEmpty()){
                Log.e("a_twitter is NOT null :", "YES");
                tvaccomootwitterpage.setText(a_twitter);
            }else {
                rlAccommoTwitterpageActivity.setVisibility(View.GONE);
                Log.e("a_twitter is null :", "YES");
            }


            if (a_telephone !=null  && !a_telephone.isEmpty()){
                Log.e("a_telephone is NOT null :", "YES");
                tvaccomootelephone.setText(a_telephone);
            }else {
                rlAccommoTelephoneActivity.setVisibility(View.GONE);
                Log.e("a_telephone is null :", "YES");
            }

            Log.e(" << SQLite DATA FOR ACCOMODATION >>: ", "" + log);
        }

        setSupportActionBar(toolbaraccommodation);
        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_accommodatoin);
//        collapsingToolbarLayout.setTitle(getResources().getString(R.string.guestinfo));
        getSupportActionBar().setDisplayShowTitleEnabled(false);




        dynamicToolbarColor();
        toolbarTextAppernce();

        rlAccommoMapAddressActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*String geoUri = "http://maps.google.com/maps?q=loc:"
                        + a_map_address_lat + "," + a_map_address_lng + " (" + a_map_address + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,  Uri.parse(url));
                startActivity(intent);*/

                String geoUri = "http://maps.google.com/maps?q=loc:"
                        + a_map_address_lat + "," + a_map_address_lng + " (" + a_map_address + ")";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                startActivity(intent);
            }
        });

        rlAccommoTelephoneActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                String uri = "tel:" + a_telephone.trim() ;
//                Intent intent = new Intent(Intent.ACTION_CALL);
//                intent.setData(Uri.parse(uri));
//                startActivity(intent);

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + a_telephone));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
            }
        });

        rlAccommoWebLinkActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = a_website;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        rlAccommoFacebookActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    int versionCode = getPackageManager().getPackageInfo("com.facebook.katana", 0).versionCode;
                    if (versionCode >= 3002850) {
                        Log.e(" Facebook App New Version :", "" +versionCode);
                        Uri uri = Uri.parse(a_facebook);
                        startActivity(new Intent(Intent.ACTION_VIEW, uri));
                    } else {
                        Log.e(" Facebook App Old Version :", "" +versionCode);
                        Uri uri = Uri.parse(a_facebook);
                        startActivity(new Intent(Intent.ACTION_VIEW, uri));
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(a_facebook)));
                }
            }
        });

        rlAccommoTwitterpageActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isPackageExisted("com.twitter.android")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/" + a_twitter));
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/" + a_twitter));
                    startActivity(intent);
                }
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
