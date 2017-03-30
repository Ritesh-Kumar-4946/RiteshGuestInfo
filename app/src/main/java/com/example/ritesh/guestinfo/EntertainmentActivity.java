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

public class EntertainmentActivity extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout = null;
    @BindView(R.id.toolbar_accomodation)
    Toolbar toolbaraccommodation;

    Bitmap bitmaptoolbarimage;

    @BindView(R.id.rlmain_entertainment_one)
    RelativeLayout rlentertainment_one;

    @BindView(R.id.rlmain_entertainment_two)
    RelativeLayout rlentertainment_two;

    @BindView(R.id.rlmain_entertainment_three)
    RelativeLayout rlentertainment_three;

    @BindView(R.id.rlmain_entertainment_four)
    RelativeLayout rlentertainment_four;

    @BindView(R.id.rlmain_entertainment_five)
    RelativeLayout rlentertainment_five;

    @BindView(R.id.rlmain_entertainment_six)
    RelativeLayout rlentertainment_six;

    @BindView(R.id.rlmain_entertainment_seven)
    RelativeLayout rlentertainment_seven;

    @BindView(R.id.rlmain_entertainment_eight)
    RelativeLayout rlentertainment_eight;

    @BindView(R.id.rlmain_entertainment_nine)
    RelativeLayout rlentertainment_nine;

    @BindView(R.id.tv_address_one)
    TextView TVaddress_one;

    @BindView(R.id.tv_address_two)
    TextView TVaddress_two;

    @BindView(R.id.tv_address_three)
    TextView TVaddress_three;

    @BindView(R.id.tv_address_four)
    TextView TVaddress_four;

    @BindView(R.id.tv_address_five)
    TextView TVaddress_five;

    @BindView(R.id.tv_address_six)
    TextView TVaddress_six;

    @BindView(R.id.tv_address_seven)
    TextView TVaddress_seven;

    @BindView(R.id.tv_address_eight)
    TextView TVaddress_eight;

    @BindView(R.id.tv_address_nine)
    TextView TVaddress_nine;

    String
            ent_0_ent_type,
            ent_1_ent_type,
            ent_2_ent_type,
            ent_3_ent_type,
            ent_4_ent_type,
            ent_5_ent_type,
            ent_6_ent_type,
            ent_7_ent_type,
            ent_8_ent_type;

    DatabaseHandler db = new DatabaseHandler(this);

    @BindView(R.id.tv_entertainment_aoname)
    TextView tvwelcome_accomodation;
    @BindView(R.id.iv_entertainment_image_one)
    ImageView aoImageOne;
    @BindView(R.id.iv_entertainment_image_two)
    ImageView aoImageTwo;

    String logoImagepath = "", pictureImagepath = "", name;
    Bitmap bitmaplogo;
    Bitmap bitmappicture;
    File SharedLogoImage, SharedPictureImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertainment);
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
            Log.e("Entertainment Sqlite Data: ", log);


            ent_0_ent_type = cn.getent_0_ent_type();
            ent_1_ent_type = cn.getent_1_ent_type();
            ent_2_ent_type = cn.getent_2_ent_type();
            ent_3_ent_type = cn.getent_3_ent_type();
            ent_4_ent_type = cn.getent_4_ent_type();
            ent_5_ent_type = cn.getent_5_ent_type();
            ent_6_ent_type = cn.getent_6_ent_type();
            ent_7_ent_type = cn.getent_7_ent_type();
            ent_8_ent_type = cn.getent_8_ent_type();
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







            if (ent_0_ent_type != null && !ent_0_ent_type.isEmpty()){
                TVaddress_one.setText(ent_0_ent_type);
                Log.e("ent_0_ent_type is NOT null :", "YES");
            }else {
                rlentertainment_one.setVisibility(View.GONE);
                Log.e("ent_0_ent_type is null :", "YES");
            }

            if (ent_1_ent_type != null && !ent_1_ent_type.isEmpty()){
                TVaddress_two.setText(ent_1_ent_type);
                Log.e("ent_1_ent_type is NOT null :", "YES");
            }else {
                rlentertainment_two.setVisibility(View.GONE);
                Log.e("ent_1_ent_type is null :", "YES");
            }

            if (ent_2_ent_type != null && !ent_2_ent_type.isEmpty()){
                TVaddress_three.setText(ent_2_ent_type);
                Log.e("ent_2_ent_type is NOT null :", "YES");
            }else {
                rlentertainment_three.setVisibility(View.GONE);
                Log.e("ent_2_ent_type is null :", "YES");
            }

            if (ent_3_ent_type != null && !ent_3_ent_type.isEmpty()){
                TVaddress_four.setText(ent_3_ent_type);
                Log.e("ent_3_ent_type is NOT null :", "YES");
            }else {
                rlentertainment_four.setVisibility(View.GONE);
                Log.e("ent_3_ent_type is null :", "YES");
            }

            if (ent_4_ent_type != null && !ent_4_ent_type.isEmpty()){
                TVaddress_five.setText(ent_4_ent_type);
                Log.e("ent_4_ent_type is NOT null :", "YES");
            }else {
                rlentertainment_five.setVisibility(View.GONE);
                Log.e("ent_4_ent_type is null :", "YES");
            }

            if (ent_5_ent_type != null && !ent_5_ent_type.isEmpty()){
                TVaddress_six.setText(ent_5_ent_type);
                Log.e("ent_5_ent_type is NOT null :", "YES");
            }else {
                rlentertainment_six.setVisibility(View.GONE);
                Log.e("ent_5_ent_type is null :", "YES");
            }

            if (ent_6_ent_type != null && !ent_6_ent_type.isEmpty()){
                TVaddress_seven.setText(ent_6_ent_type);
                Log.e("ent_6_ent_type is NOT null :", "YES");
            }else {
                rlentertainment_seven.setVisibility(View.GONE);
                Log.e("ent_6_ent_type is null :", "YES");
            }

            if (ent_7_ent_type != null && !ent_7_ent_type.isEmpty()){
                TVaddress_eight.setText(ent_7_ent_type);
                Log.e("ent_7_ent_type is NOT null :", "YES");
            }else {
                rlentertainment_eight.setVisibility(View.GONE);
                Log.e("ent_7_ent_type is null :", "YES");
            }


            if (ent_8_ent_type != null && !ent_8_ent_type.isEmpty()){
                TVaddress_nine.setText(ent_8_ent_type);
                Log.e("ent_8_ent_type is NOT null :", "YES");
            }else {
                rlentertainment_nine.setVisibility(View.GONE);
                Log.e("ent_8_ent_type is null :", "YES");
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
                Intent fdba = new Intent(getApplicationContext(), EntertainmentOneActivity.class);
                startActivity(fdba);
            }
        });

        rlentertainment_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fdba = new Intent(getApplicationContext(), EntertainmentTwoActivity.class);
                startActivity(fdba);
            }
        });

        rlentertainment_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fdba = new Intent(getApplicationContext(), EntertainmentThreeActivity.class);
                startActivity(fdba);
            }
        });

        rlentertainment_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fdba = new Intent(getApplicationContext(), EntertainmentFourActivity.class);
                startActivity(fdba);
            }
        });

        rlentertainment_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fdba = new Intent(getApplicationContext(), EntertainmentFiveActivity.class);
                startActivity(fdba);
            }
        });

        rlentertainment_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fdba = new Intent(getApplicationContext(), EntertainmentSixActivity.class);
                startActivity(fdba);
            }
        });

        rlentertainment_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fdba = new Intent(getApplicationContext(), EntertainmentSevenActivity.class);
                startActivity(fdba);
            }
        });

        rlentertainment_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fdba = new Intent(getApplicationContext(), EntertainmentEightActivity.class);
                startActivity(fdba);
            }
        });

        rlentertainment_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fdba = new Intent(getApplicationContext(), EntertainmentNineActivity.class);
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
