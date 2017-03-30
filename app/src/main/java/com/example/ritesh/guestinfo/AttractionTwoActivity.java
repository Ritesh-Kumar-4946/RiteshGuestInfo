package com.example.ritesh.guestinfo;

import android.content.Intent;
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
 * Created by ritesh on 7/12/16.
 */

public class AttractionTwoActivity extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout = null;
    @BindView(R.id.toolbar_accomodation)
    Toolbar toolbaraccommodation;

    Bitmap bitmaptoolbarimage;

    @BindView(R.id.rlmain_attrtwo_name)
    RelativeLayout rlattrac_name;

    @BindView(R.id.rlmain_attrtwo_description)
    RelativeLayout rlattrac_discription;

    @BindView(R.id.rlmain_attrtwo_weblink)
    RelativeLayout rlattrac_weblink;

    @BindView(R.id.rlmain_attrtwo_address)
    RelativeLayout rlattrac_address;

    @BindView(R.id.tv_attraction_attr_one_aoname)
    TextView TVattraction_AOname;

    @BindView(R.id.tv_attrtwo_name)
    TextView TVattrtwo_name;

    @BindView(R.id.tv_attrtwo_description)
    TextView TVattrtwo_description;

    @BindView(R.id.tv_attrtwo_weblink)
    TextView TVattrtwo_weblink;

    @BindView(R.id.tv_attrtwo_address)
    TextView TVattrtwo_address;

    @BindView(R.id.iv_attraction_attr_one_one)
    ImageView IVattraction_attr_one_one;

    String AttractionTwoImagepath = "";
    Bitmap bitmapAttractionTwo;
    File SharedAttractionTwoImage;

    String
            name,
            attr_repeat_1_attr_name,
            attr_repeat_1_attr_website,
            attr_repeat_1_attr_descript,
            attr_repeat_1_attr_map,
            attr_repeat_1_attr_map_address,
            attr_repeat_1_attr_map_lat,
            attr_repeat_1_attr_map_lng;

    DatabaseHandler db = new DatabaseHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions_two);
        ButterKnife.bind(this);

        // Reading all contacts
        Log.e("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.Get_All_Contacts();

        for (Contact cn : contacts) {
            String log =
                    "Id: " + cn.getID()
                            + " ,getname: " + cn.getname()
                            + " ,getattr_repeat_1_attr_name: " + cn.getattr_repeat_1_attr_name()
                            + " ,getattr_repeat_1_attr_picture_image: " + cn.getattr_repeat_1_attr_picture_image()
                            + " ,getattr_repeat_1_attr_website: " + cn.getattr_repeat_1_attr_website()
                            + " ,getattr_repeat_1_attr_descript: " + cn.getattr_repeat_1_attr_descript()
                            + " ,getattr_repeat_1_attr_map: " + cn.getattr_repeat_1_attr_map()
                            + " ,getattr_repeat_1_attr_map_address: " + cn.getattr_repeat_1_attr_map_address()
                            + " ,getattr_repeat_1_attr_map_lat: " + cn.getattr_repeat_1_attr_map_lat()
                            + " ,getattr_repeat_1_attr_map_lng: " + cn.getattr_repeat_1_attr_map_lng();
            // Writing Contacts to log
            Log.e("Attraction TWO Sqlite Data: ", log);

            name = cn.getname();
            AttractionTwoImagepath = cn.getattr_repeat_1_attr_picture_image();
            attr_repeat_1_attr_name = cn.getattr_repeat_1_attr_name();
            attr_repeat_1_attr_website =cn.getattr_repeat_1_attr_website();
            attr_repeat_1_attr_descript =cn.getattr_repeat_1_attr_descript();
            attr_repeat_1_attr_map =cn.getattr_repeat_1_attr_map();
            attr_repeat_1_attr_map_address =cn.getattr_repeat_1_attr_map_address();
            attr_repeat_1_attr_map_lat =cn.getattr_repeat_1_attr_map_lat();
            attr_repeat_1_attr_map_lng =cn.getattr_repeat_1_attr_map_lng();

            TVattraction_AOname.setText(name);

            if (AttractionTwoImagepath != null && !AttractionTwoImagepath.isEmpty()) {
                Log.e("AttractionTwoImagepath is NOT null :", "YES");
//                    tvwelcomparent.setText(Html.fromHtml(a_welcome));
                SharedAttractionTwoImage = new File(AttractionTwoImagepath);
                Log.e(" ********** final Attraction One image from file **********", "" + AttractionTwoImagepath);

                if (SharedAttractionTwoImage.exists()) {

                    long length = SharedAttractionTwoImage.length();
                    length = length / 1024;

                    double bytes = SharedAttractionTwoImage.length();
                    double kilobytes = (bytes / 1024);
                    double megabytes = (kilobytes / 1024);
                    double gigabytes = (megabytes / 1024);

                    Log.e("Image Size :", "" + bytes + "\n" + "" + kilobytes + "\n" + "" + megabytes);
                    Log.e("Image Size :", "" + kilobytes + "\n" + "" + megabytes);

                    if (SharedAttractionTwoImage.length() >= 1048576) {
                        Log.e("Image Size is greater than 1 mb :", "YES");

                /*http://stackoverflow.com/questions/5125779/how-to-compress-image-for-imageview-in-android*/
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inTempStorage = new byte[24 * 1024];
                        options.inJustDecodeBounds = false;
                        options.inSampleSize = 2;
                        bitmapAttractionTwo = BitmapFactory.decodeFile(SharedAttractionTwoImage.getAbsolutePath(), options);
                        Bitmap b1 = ThumbnailUtils.extractThumbnail(bitmapAttractionTwo, 1024, 1024);
                        IVattraction_attr_one_one.setImageBitmap(b1);
                        if (bitmapAttractionTwo != null) {
                            bitmapAttractionTwo.recycle();
                            Log.e("bitmapAttractionTwo recycle 1", "YES");
                        }
                        bitmapAttractionTwo = BitmapFactory.decodeFile(SharedAttractionTwoImage.getAbsolutePath(), options);
                        Bitmap b2 = ThumbnailUtils.extractThumbnail(bitmapAttractionTwo, 1024, 1024);  // 1024 , 1024 is image size after convert
                        IVattraction_attr_one_one.setImageBitmap(b2);

                        int oldWidth = b2.getWidth();
                        int oldHeight = b2.getHeight();
                        Log.e("Image Height (b2):", "" + oldHeight + "\n" + "Image Width (b2) :" + "" + oldWidth);

                        if (bitmapAttractionTwo != null) {
                            bitmapAttractionTwo.recycle();
                            Log.e("bitmapAttractionTwo recycle 2", "YES");
                        }
                /*http://stackoverflow.com/questions/5125779/how-to-compress-image-for-imageview-in-android*/

                    } else {

                        bitmapAttractionTwo = BitmapFactory.decodeFile(SharedAttractionTwoImage.getAbsolutePath());

                        int oldWidth = bitmapAttractionTwo.getWidth();
                        int oldHeight = bitmapAttractionTwo.getHeight();

                        Log.e("Image Height (bitmapAttractionTwo) :", "" + oldHeight + "\n" + "Image Width (bitmapAttractionTwo) :" + "" + oldWidth);

                        IVattraction_attr_one_one.setImageBitmap(bitmapAttractionTwo);
                        Log.e("Image Size is greater than 1 mb :", "NO");
                    }


                } else {
                    Log.e("File does not exists!", "YES");
                }

                Log.e(" original bitmap bitmapAttractionTwo : ", "" + bitmapAttractionTwo);


            } else {

                Log.e("AttractionTwoImagepath is null :", "YES");
            }
            
            
            

            if (attr_repeat_1_attr_name != null && !attr_repeat_1_attr_name.isEmpty()){
                TVattrtwo_name.setText(attr_repeat_1_attr_name);
                Log.e("attr_repeat_1_attr_name is NOT null :", "YES");
            }else {
                rlattrac_name.setVisibility(View.GONE);
                Log.e("attr_repeat_1_attr_name is null :", "YES");
            }

            if (attr_repeat_1_attr_website != null && !attr_repeat_1_attr_website.isEmpty()){
                TVattrtwo_weblink.setText(attr_repeat_1_attr_website);
                Log.e("attr_repeat_1_attr_website is NOT null :", "YES");
            }else {
                rlattrac_weblink.setVisibility(View.GONE);
                Log.e("attr_repeat_1_attr_website is null :", "YES");
            }

            if (attr_repeat_1_attr_descript != null && !attr_repeat_1_attr_descript.isEmpty()){
                TVattrtwo_description.setText(Html.fromHtml(attr_repeat_1_attr_descript));
                Log.e("attr_repeat_1_attr_descript is NOT null :", "YES");
            }else {
                rlattrac_discription.setVisibility(View.GONE);
                Log.e("attr_repeat_1_attr_descript is null :", "YES");
            }

            if (attr_repeat_1_attr_map_address != null && !attr_repeat_1_attr_map_address.isEmpty()){
                TVattrtwo_address.setText(attr_repeat_1_attr_map_address);
                Log.e("attr_repeat_1_attr_map_address is NOT null :", "YES");
            }else {
                rlattrac_address.setVisibility(View.GONE);
                Log.e("attr_repeat_1_attr_map_address is null :", "YES");
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

        rlattrac_weblink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = attr_repeat_1_attr_website;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        rlattrac_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geoUri = "http://maps.google.com/maps?q=loc:"
                        + attr_repeat_1_attr_map_lat + "," + attr_repeat_1_attr_map_lng + " (" + attr_repeat_1_attr_map_address + ")";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                startActivity(intent);
            }
        });

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