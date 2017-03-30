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

public class EntertainmentFourActivity extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout = null;
    @BindView(R.id.toolbar_accomodation)
    Toolbar toolbaraccommodation;

    Bitmap bitmaptoolbarimage;

    @BindView(R.id.rlmain_entfour_type)
    RelativeLayout rlentfour_type;

    @BindView(R.id.rlmain_entfour_name)
    RelativeLayout rlentfour_name;

    @BindView(R.id.rlmain_entfour_weblink)
    RelativeLayout rlentfour_weblink;

    @BindView(R.id.rlmain_entfour_number)
    RelativeLayout rlentfour_number;

    @BindView(R.id.rlmain_entfour_address)
    RelativeLayout rlentfour_address;

    @BindView(R.id.tv_entfour_type)
    TextView TVtentfour_type;

    @BindView(R.id.tv_entfour_name)
    TextView TVtentfour_name;

    @BindView(R.id.tv_entfour_weblink)
    TextView TVtentfour_weblink;

    @BindView(R.id.tv_entfour_number)
    TextView TVtentfour_number;

    @BindView(R.id.tv_entfour_address)
    TextView TVtentfour_address;

    String
            ent_3_ent_type,
            ent_3_ent_name,
            ent_3_ent_website,
            ent_3_ent_phone,
            ent_3_ent_map,
            ent_3_ent_map_address,
            ent_3_ent_map_lat,
            ent_3_ent_map_lng;

    DatabaseHandler db = new DatabaseHandler(this);

    @BindView(R.id.tv_entertainment_four_aoname)
    TextView tvwelcome_accomodation;
    @BindView(R.id.iv_entertainment_four_image_one)
    ImageView aoImageOne;
    @BindView(R.id.iv_entertainment_four_image_two)
    ImageView aoImageTwo;

    String logoImagepath = "", pictureImagepath = "", name;
    Bitmap bitmaplogo;
    Bitmap bitmappicture;
    File SharedLogoImage, SharedPictureImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertainment_four);
        ButterKnife.bind(this);


        // Reading all contacts
        Log.e("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.Get_All_Contacts();

        for (Contact cn : contacts) {
            String log =
                    "Id: " + cn.getID()
                            + " ,getent_3_ent_type: " + cn.getent_3_ent_type()
                            + " ,getent_3_ent_name: " + cn.getent_3_ent_name()
                            + " ,getent_3_ent_website: " + cn.getent_3_ent_website()
                            + " ,getent_3_ent_phone: " + cn.getent_3_ent_phone()
                            + " ,getent_3_ent_map: " + cn.getent_3_ent_map()
                            + " ,getent_3_ent_map_address: " + cn.getent_3_ent_map_address()
                            + " ,getent_3_ent_map_lat: " + cn.getent_3_ent_map_lat()
                            + " ,getent_3_ent_map_lng: " + cn.getent_3_ent_map_lng()
                            + " ,geta_logo_image: " + cn.geta_logo_image()
                            + " ,geta_picture_image: " + cn.geta_picture_image()
                            + " ,getname: " + cn.getname();

            // Writing Contacts to log
            Log.e("Entertainment Four Sqlite Data: ", log);

            ent_3_ent_type = cn.getent_3_ent_type();
            ent_3_ent_name =cn.getent_3_ent_name();
            ent_3_ent_website =cn.getent_3_ent_website();
            ent_3_ent_phone =cn.getent_3_ent_phone();
            ent_3_ent_map =cn.getent_3_ent_map();
            ent_3_ent_map_address =cn.getent_3_ent_map_address();
            ent_3_ent_map_lat =cn.getent_3_ent_map_lat();
            ent_3_ent_map_lng =cn.getent_3_ent_map_lng();
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


            if (ent_3_ent_type != null && !ent_3_ent_type.isEmpty()){
                TVtentfour_type.setText(ent_3_ent_type);
                Log.e("ent_3_ent_type is NOT null :", "YES");
            }else {
                rlentfour_type.setVisibility(View.GONE);
                Log.e("ent_3_ent_type is null :", "YES");
            }

            if (ent_3_ent_name != null && !ent_3_ent_name.isEmpty()){
                TVtentfour_name.setText(ent_3_ent_name);
                Log.e("ent_3_ent_name is NOT null :", "YES");
            }else {
                rlentfour_name.setVisibility(View.GONE);
                Log.e("ent_3_ent_name is null :", "YES");
            }

            if (ent_3_ent_website != null && !ent_3_ent_website.isEmpty()){
                TVtentfour_weblink.setText(ent_3_ent_website);
                Log.e("ent_3_ent_website is NOT null :", "YES");
            }else {
                rlentfour_weblink.setVisibility(View.GONE);
                Log.e("ent_3_ent_website is null :", "YES");
            }

            if (ent_3_ent_phone != null && !ent_3_ent_phone.isEmpty()){
                TVtentfour_number.setText(ent_3_ent_phone);
                Log.e("ent_3_ent_phone is NOT null :", "YES");
            }else {
                rlentfour_number.setVisibility(View.GONE);
                Log.e("ent_3_ent_phone is null :", "YES");
            }

            if (ent_3_ent_map_address != null && !ent_3_ent_map_address.isEmpty()){
                TVtentfour_address.setText(ent_3_ent_map_address);
                Log.e("ent_3_ent_map_address is NOT null :", "YES");
            }else {
                rlentfour_address.setVisibility(View.GONE);
                Log.e("ent_3_ent_map_address is null :", "YES");
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


        rlentfour_weblink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = ent_3_ent_website;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        rlentfour_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + ent_3_ent_phone));
                startActivity(intent);
            }
        });



        rlentfour_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geoUri = "http://maps.google.com/maps?q=loc:"
                        + ent_3_ent_map_lat + "," + ent_3_ent_map_lng + " (" + ent_3_ent_map_address + ")";
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
