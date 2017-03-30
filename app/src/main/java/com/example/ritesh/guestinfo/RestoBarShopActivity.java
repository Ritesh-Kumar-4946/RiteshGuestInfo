package com.example.ritesh.guestinfo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
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
 * Created by ritesh on 10/11/16.
 */

public class RestoBarShopActivity extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout = null;
    @BindView(R.id.toolbar_accomodation)
    Toolbar toolbaraccommodation;

    Bitmap bitmaptoolbarimage;

    @BindView(R.id.rlmain_resto_one)
    RelativeLayout rlentertainment_one;

    @BindView(R.id.rlmain_resto_two)
    RelativeLayout rlentertainment_two;

    @BindView(R.id.rlmain_resto_three)
    RelativeLayout rlentertainment_three;

    @BindView(R.id.rlmain_resto_four)
    RelativeLayout rlentertainment_four;

    @BindView(R.id.rlmain_resto_five)
    RelativeLayout rlentertainment_five;

    @BindView(R.id.rlmain_resto_six)
    RelativeLayout rlentertainment_six;

    @BindView(R.id.rlmain_resto_seven)
    RelativeLayout rlentertainment_seven;

    @BindView(R.id.rlmain_resto_eight)
    RelativeLayout rlentertainment_eight;

    @BindView(R.id.rlmain_resto_nine)
    RelativeLayout rlentertainment_nine;

    @BindView(R.id.tv_resto_zero)
    TextView TVresto_zero;

    @BindView(R.id.tv_resto_one)
    TextView TVresto_one;

    @BindView(R.id.tv_resto_two)
    TextView TVresto_two;

    @BindView(R.id.tv_resto_three)
    TextView TVresto_three;

    @BindView(R.id.tv_resto_four)
    TextView TVresto_four;

    @BindView(R.id.tv_resto_five)
    TextView TVresto_five;

    @BindView(R.id.tv_resto_six)
    TextView TVresto_six;

    @BindView(R.id.tv_resto_seven)
    TextView TVresto_seven;

    @BindView(R.id.tv_resto_eight)
    TextView TVresto_eight;


    String
            name,
            rsb_0_rbs_type,
            rsb_1_rbs_type,
            rsb_2_rbs_type,
            rsb_3_rbs_type,
            rsb_4_rbs_type,
            rsb_5_rbs_type,
            rsb_6_rbs_type,
            rsb_7_rbs_type,
            rsb_8_rbs_type;

    DatabaseHandler db = new DatabaseHandler(this);

    @BindView(R.id.tv_restobar_aoname)
    TextView tvwelcome_accomodation;
    @BindView(R.id.iv_restobar_image_one)
    ImageView aoImageOne;
    @BindView(R.id.iv_restobar_image_two)
    ImageView aoImageTwo;

    String logoImagepath = "", pictureImagepath = "";
    Bitmap bitmaplogo;
    Bitmap bitmappicture;
    File SharedLogoImage, SharedPictureImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restobar_shop);
        ButterKnife.bind(this);

        // Reading all contacts
        Log.e("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.Get_All_Contacts();

        for (Contact cn : contacts) {
            String log =
                    "Id: " + cn.getID()
                            + " ,getent_0_ent_type: " + cn.getent_0_ent_type()
                            + " ,getent_1_ent_type: " + cn.getent_1_ent_type()
                            + " ,getent_2_ent_type: " + cn.getent_2_ent_type()
                            + " ,getent_3_ent_type: " + cn.getent_3_ent_type()
                            + " ,getent_4_ent_type: " + cn.getent_4_ent_type()
                            + " ,getent_5_ent_type: " + cn.getent_5_ent_type()
                            + " ,getent_6_ent_type: " + cn.getent_6_ent_type()
                            + " ,getent_7_ent_type: " + cn.getent_7_ent_type()
                            + " ,getent_8_ent_type: " + cn.getent_8_ent_type()
                            + " ,geta_logo_image: " + cn.geta_logo_image()
                            + " ,geta_picture_image: " + cn.geta_picture_image()
                            + " ,getname: " + cn.getname();
            // Writing Contacts to log
            Log.e("Restobar Shop Sqlite Data: ", log);


            name = cn.getname();
            rsb_0_rbs_type = cn.getrsb_0_rbs_type();
            rsb_1_rbs_type = cn.getrsb_1_rbs_type();
            rsb_2_rbs_type = cn.getrsb_2_rbs_type();
            rsb_3_rbs_type = cn.getrsb_3_rbs_type();
            rsb_4_rbs_type = cn.getrsb_4_rbs_type();
            rsb_5_rbs_type = cn.getrsb_5_rbs_type();
            rsb_6_rbs_type = cn.getrsb_6_rbs_type();
            rsb_7_rbs_type = cn.getrsb_7_rbs_type();
            rsb_8_rbs_type = cn.getrsb_8_rbs_type();

            logoImagepath = cn.geta_logo_image();
            pictureImagepath = cn.geta_picture_image();

            tvwelcome_accomodation.setText(name);

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

            if (rsb_0_rbs_type != null && !rsb_0_rbs_type.isEmpty()){
                TVresto_zero.setText(rsb_0_rbs_type);
                Log.e("rsb_0_rbs_type is NOT null :", "YES");
            }else {
                rlentertainment_one.setVisibility(View.GONE);
                Log.e("rsb_0_rbs_type is null :", "YES");
            }

            if (rsb_1_rbs_type != null && !rsb_1_rbs_type.isEmpty()){
                TVresto_one.setText(rsb_1_rbs_type);
                Log.e("rsb_1_rbs_type is NOT null :", "YES");
            }else {
                rlentertainment_two.setVisibility(View.GONE);
                Log.e("rsb_1_rbs_type is null :", "YES");
            }

            if (rsb_2_rbs_type != null && !rsb_2_rbs_type.isEmpty()){
                TVresto_two.setText(rsb_2_rbs_type);
                Log.e("rsb_2_rbs_type is NOT null :", "YES");
            }else {
                rlentertainment_three.setVisibility(View.GONE);
                Log.e("rsb_2_rbs_type is null :", "YES");
            }

            if (rsb_3_rbs_type != null && !rsb_3_rbs_type.isEmpty()){
                TVresto_three.setText(rsb_3_rbs_type);
                Log.e("rsb_3_rbs_type is NOT null :", "YES");
            }else {
                rlentertainment_four.setVisibility(View.GONE);
                Log.e("rsb_3_rbs_type is null :", "YES");
            }

            if (rsb_4_rbs_type != null && !rsb_4_rbs_type.isEmpty()){
                TVresto_four.setText(rsb_4_rbs_type);
                Log.e("rsb_4_rbs_type is NOT null :", "YES");
            }else {
                rlentertainment_five.setVisibility(View.GONE);
                Log.e("rsb_4_rbs_type is null :", "YES");
            }


            if (rsb_5_rbs_type != null && !rsb_5_rbs_type.isEmpty()){
                TVresto_five.setText(rsb_5_rbs_type);
                Log.e("rsb_5_rbs_type is NOT null :", "YES");
            }else {
                rlentertainment_six.setVisibility(View.GONE);
                Log.e("rsb_5_rbs_type is null :", "YES");
            }
            if (rsb_6_rbs_type != null && !rsb_6_rbs_type.isEmpty()){
                TVresto_six.setText(rsb_6_rbs_type);
                Log.e("rsb_6_rbs_type is NOT null :", "YES");
            }else {
                rlentertainment_seven.setVisibility(View.GONE);
                Log.e("rsb_6_rbs_type is null :", "YES");
            }

            if (rsb_7_rbs_type != null && !rsb_7_rbs_type.isEmpty()){
                TVresto_seven.setText(rsb_7_rbs_type);
                Log.e("rsb_7_rbs_type is NOT null :", "YES");
            }else {
                rlentertainment_eight.setVisibility(View.GONE);
                Log.e("rsb_7_rbs_type is null :", "YES");
            }


            if (rsb_8_rbs_type != null && !rsb_8_rbs_type.isEmpty()){
                TVresto_eight.setText(rsb_8_rbs_type);
                Log.e("rsb_8_rbs_type is NOT null :", "YES");
            }else {
                rlentertainment_nine.setVisibility(View.GONE);
                Log.e("rsb_8_rbs_type is null :", "YES");
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



        rlentertainment_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fdba = new Intent(getApplicationContext(), RestoBarShopOneActivity.class);
                startActivity(fdba);
            }
        });

        rlentertainment_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fdba = new Intent(getApplicationContext(), RestoBarShopTwoActivity.class);
                startActivity(fdba);
            }
        });

        rlentertainment_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fdba = new Intent(getApplicationContext(), RestoBarShopThreeActivity.class);
                startActivity(fdba);
            }
        });

        rlentertainment_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fdba = new Intent(getApplicationContext(), RestoBarShopFourActivity.class);
                startActivity(fdba);
            }
        });

        rlentertainment_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fdba = new Intent(getApplicationContext(), RestoBarShopFiveActivity.class);
                startActivity(fdba);
            }
        });

        rlentertainment_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fdba = new Intent(getApplicationContext(), RestoBarShopSixActivity.class);
                startActivity(fdba);
            }
        });

        rlentertainment_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fdba = new Intent(getApplicationContext(), RestoBarShopSevenActivity.class);
                startActivity(fdba);
            }
        });

        rlentertainment_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fdba = new Intent(getApplicationContext(), RestoBarShopEightActivity.class);
                startActivity(fdba);
            }
        });

        rlentertainment_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fdba = new Intent(getApplicationContext(), RestoBarShopNineActivity.class);
                startActivity(fdba);
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
