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

public class RestoBarShopTwoActivity extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout = null;
    @BindView(R.id.toolbar_accomodation)
    Toolbar toolbaraccommodation;

    Bitmap bitmaptoolbarimage;

    @BindView(R.id.rlmain_rsbtwo_type)
    RelativeLayout rlrsbtwo_type;

    @BindView(R.id.rlmain_rsbtwo_name)
    RelativeLayout rlrsbtwo_name;

    @BindView(R.id.rlmain_rsbtwo_weblink)
    RelativeLayout rlrsbtwo_weblink;

    @BindView(R.id.rlmain_rsbtwo_number)
    RelativeLayout rlrsbtwo_number;

    @BindView(R.id.rlmain_rsbtwo_address)
    RelativeLayout rlrsbtwo_address;

    @BindView(R.id.tv_rsbtwo_type)
    TextView TVtrsbtwo_type;

    @BindView(R.id.tv_rsbtwo_name)
    TextView TVtrsbtwo_name;

    @BindView(R.id.tv_rsbtwo_weblink)
    TextView TVtrsbtwo_weblink;

    @BindView(R.id.tv_rsbtwo_number)
    TextView TVtrsbtwo_number;

    @BindView(R.id.tv_rsbtwo_address)
    TextView TVtrsbtwo_address;

    String
            rsb_1_rbs_type,
            rsb_1_rbs_name,
            rsb_1_rbs_website,
            rsb_1_rbs_phone,
            rsb_1_rbs_map,
            rsb_1_rbs_map_address,
            rsb_1_rbs_map_lat,
            rsb_1_rbs_map_lng;

    DatabaseHandler db = new DatabaseHandler(this);

    @BindView(R.id.tv_restobar_shop_two_aoname)
    TextView tvwelcome_accomodation;
    @BindView(R.id.iv_restobar_shop_two_image_one)
    ImageView aoImageOne;
    @BindView(R.id.iv_restobar_shop_two_image_two)
    ImageView aoImageTwo;

    String logoImagepath = "", pictureImagepath = "", name;
    Bitmap bitmaplogo;
    Bitmap bitmappicture;
    File SharedLogoImage, SharedPictureImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restobar_shop_two);
        ButterKnife.bind(this);

        // Reading all contacts
        Log.e("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.Get_All_Contacts();

        for (Contact cn : contacts) {
            String log =
                    "Id: " + cn.getID()
                            + " ,getrsb_1_rbs_type: " + cn.getrsb_1_rbs_type()
                            + " ,getrsb_1_rbs_name: " + cn.getrsb_1_rbs_name()
                            + " ,getrsb_1_rbs_website: " + cn.getrsb_1_rbs_website()
                            + " ,getrsb_1_rbs_phone: " + cn.getrsb_1_rbs_phone()
                            + " ,getrsb_1_rbs_map: " + cn.getrsb_1_rbs_map()
                            + " ,getrsb_1_rbs_map_address: " + cn.getrsb_1_rbs_map_address()
                            + " ,getrsb_1_rbs_map_lat: " + cn.getrsb_1_rbs_map_lat()
                            + " ,getrsb_1_rbs_map_lng: " + cn.getrsb_1_rbs_map_lng()
                            + " ,geta_logo_image: " + cn.geta_logo_image()
                            + " ,geta_picture_image: " + cn.geta_picture_image()
                            + " ,getname: " + cn.getname();
            // Writing Contacts to log
            Log.e("Restobar Shop Two Sqlite Data: ", log);

            rsb_1_rbs_type = cn.getrsb_1_rbs_type();
            rsb_1_rbs_name =cn.getrsb_1_rbs_name();
            rsb_1_rbs_website =cn.getrsb_1_rbs_website();
            rsb_1_rbs_phone =cn.getrsb_1_rbs_phone();
            rsb_1_rbs_map =cn.getrsb_1_rbs_map();
            rsb_1_rbs_map_address =cn.getrsb_1_rbs_map_address();
            rsb_1_rbs_map_lat =cn.getrsb_1_rbs_map_lat();
            rsb_1_rbs_map_lng =cn.getrsb_1_rbs_map_lng();
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


            if (rsb_1_rbs_type != null && !rsb_1_rbs_type.isEmpty()){
                TVtrsbtwo_type.setText(rsb_1_rbs_type);
                Log.e("rsb_1_rbs_type is NOT null :", "YES");
            }else {
                rlrsbtwo_type.setVisibility(View.GONE);
                Log.e("rsb_1_rbs_type is null :", "YES");
            }

            if (rsb_1_rbs_name != null && !rsb_1_rbs_name.isEmpty()){
                TVtrsbtwo_name.setText(rsb_1_rbs_name);
                Log.e("rsb_1_rbs_name is NOT null :", "YES");
            }else {
                rlrsbtwo_name.setVisibility(View.GONE);
                Log.e("rsb_1_rbs_name is null :", "YES");
            }

            if (rsb_1_rbs_website != null && !rsb_1_rbs_website.isEmpty()){
                TVtrsbtwo_weblink.setText(rsb_1_rbs_website);
                Log.e("rsb_1_rbs_website is NOT null :", "YES");
            }else {
                rlrsbtwo_weblink.setVisibility(View.GONE);
                Log.e("rsb_1_rbs_website is null :", "YES");
            }

            if (rsb_1_rbs_phone != null && !rsb_1_rbs_phone.isEmpty()){
                TVtrsbtwo_number.setText(rsb_1_rbs_phone);
                Log.e("rsb_1_rbs_phone is NOT null :", "YES");
            }else {
                rlrsbtwo_number.setVisibility(View.GONE);
                Log.e("rsb_1_rbs_phone is null :", "YES");
            }

            if (rsb_1_rbs_map_address != null && !rsb_1_rbs_map_address.isEmpty()){
                TVtrsbtwo_address.setText(rsb_1_rbs_map_address);
                Log.e("rsb_1_rbs_map_address is NOT null :", "YES");
            }else {
                rlrsbtwo_address.setVisibility(View.GONE);
                Log.e("rsb_1_rbs_map_address is null :", "YES");
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

        rlrsbtwo_weblink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = rsb_1_rbs_website;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        rlrsbtwo_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + rsb_1_rbs_phone));
                startActivity(intent);
            }
        });



        rlrsbtwo_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geoUri = "http://maps.google.com/maps?q=loc:"
                        + rsb_1_rbs_map_lat + "," + rsb_1_rbs_map_lng + " (" + rsb_1_rbs_map_address + ")";
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
