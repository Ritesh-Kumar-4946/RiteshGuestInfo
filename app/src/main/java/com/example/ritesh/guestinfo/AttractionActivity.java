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

public class AttractionActivity extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout = null;
    @BindView(R.id.toolbar_accomodation)
    Toolbar toolbaraccommodation;

    Bitmap bitmaptoolbarimage;

    @BindView(R.id.rlmain_attraction_one)
    RelativeLayout rlattrac_one;

    @BindView(R.id.rlmain_attraction_two)
    RelativeLayout rlattrac_two;

    @BindView(R.id.rlmain_attraction_three)
    RelativeLayout rlattrac_three;

    @BindView(R.id.rlmain_attraction_four)
    RelativeLayout rlattrac_four;

    @BindView(R.id.rlmain_attraction_five)
    RelativeLayout rlattrac_five;

    @BindView(R.id.tv_attraction_one)
    TextView TVattraction_one;

    @BindView(R.id.tv_attraction_two)
    TextView TVattraction_two;

    @BindView(R.id.tv_attraction_three)
    TextView TVattraction_three;

    @BindView(R.id.tv_attraction_four)
    TextView TVattraction_four;

    @BindView(R.id.tv_attraction_five)
    TextView TVattraction_five;

    @BindView(R.id.tv_attraction_aoname)
    TextView TVattraction_AOname;

    @BindView(R.id.iv_attraction_one)
    ImageView aoImageOne;

    @BindView(R.id.iv_attraction_two)
    ImageView aoImageTwo;

    String logoImagepath = "", pictureImagepath = "";
    Bitmap bitmaplogo;
    Bitmap bitmappicture;
    File SharedLogoImage, SharedPictureImage;

    String
            name,
            attr_repeat_0_attr_name,
            attr_repeat_1_attr_name,
            attr_repeat_2_attr_name,
            attr_repeat_3_attr_name,
            attr_repeat_4_attr_name;

    DatabaseHandler db = new DatabaseHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions);
        ButterKnife.bind(this);

        // Reading all contacts
        Log.e("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.Get_All_Contacts();

        for (Contact cn : contacts) {
            String log =
                    "Id: " + cn.getID()
                            + " ,getname: " + cn.getname()
                            + " ,getattr_repeat_0_attr_name: " + cn.getattr_repeat_0_attr_name()
                            + " ,getattr_repeat_1_attr_name: " + cn.getattr_repeat_1_attr_name()
                            + " ,getattr_repeat_2_attr_name: " + cn.getattr_repeat_2_attr_name()
                            + " ,getattr_repeat_3_attr_name: " + cn.getattr_repeat_3_attr_name()
                            + " ,getattr_repeat_4_attr_name: " + cn.getattr_repeat_4_attr_name();
            // Writing Contacts to log
            Log.e("Attraction Sqlite Data: ", log);


            name = cn.getname();
            attr_repeat_0_attr_name = cn.getattr_repeat_0_attr_name();
            attr_repeat_1_attr_name = cn.getattr_repeat_1_attr_name();
            attr_repeat_2_attr_name = cn.getattr_repeat_2_attr_name();
            attr_repeat_3_attr_name = cn.getattr_repeat_3_attr_name();
            attr_repeat_4_attr_name = cn.getattr_repeat_4_attr_name();
            logoImagepath = cn.geta_logo_image();
            pictureImagepath = cn.geta_picture_image();

            TVattraction_AOname.setText(name);

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

            if (attr_repeat_0_attr_name != null && !attr_repeat_0_attr_name.isEmpty()){
                TVattraction_one.setText(attr_repeat_0_attr_name);
                Log.e("attr_repeat_0_attr_name is NOT null :", "YES");
            }else {
                rlattrac_one.setVisibility(View.GONE);
                Log.e("attr_repeat_0_attr_name is null :", "YES");
            }

            if (attr_repeat_1_attr_name != null && !attr_repeat_1_attr_name.isEmpty()){
                TVattraction_two.setText(attr_repeat_1_attr_name);
                Log.e("attr_repeat_1_attr_name is NOT null :", "YES");
            }else {
                rlattrac_two.setVisibility(View.GONE);
                Log.e("attr_repeat_1_attr_name is null :", "YES");
            }

            if (attr_repeat_2_attr_name != null && !attr_repeat_2_attr_name.isEmpty()){
                TVattraction_three.setText(attr_repeat_2_attr_name);
                Log.e("attr_repeat_2_attr_name is NOT null :", "YES");
            }else {
                rlattrac_three.setVisibility(View.GONE);
                Log.e("attr_repeat_2_attr_name is null :", "YES");
            }

            if (attr_repeat_3_attr_name != null && !attr_repeat_3_attr_name.isEmpty()){
                TVattraction_four.setText(attr_repeat_3_attr_name);
                Log.e("attr_repeat_3_attr_name is NOT null :", "YES");
            }else {
                rlattrac_four.setVisibility(View.GONE);
                Log.e("attr_repeat_3_attr_name is null :", "YES");
            }

            if (attr_repeat_4_attr_name != null && !attr_repeat_4_attr_name.isEmpty()){
                TVattraction_five.setText(attr_repeat_4_attr_name);
                Log.e("attr_repeat_4_attr_name is NOT null :", "YES");
            }else {
                rlattrac_five.setVisibility(View.GONE);
                Log.e("attr_repeat_4_attr_name is null :", "YES");
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


        rlattrac_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fdba = new Intent(getApplicationContext(), AttractionOneActivity.class);
                startActivity(fdba);
            }
        });

        rlattrac_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fdba = new Intent(getApplicationContext(), AttractionTwoActivity.class);
                startActivity(fdba);
            }
        });

        rlattrac_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fdba = new Intent(getApplicationContext(), AttractionThreeActivity.class);
                startActivity(fdba);
            }
        });

        rlattrac_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fdba = new Intent(getApplicationContext(), AttractionFourActivity.class);
                startActivity(fdba);
            }
        });

        rlattrac_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fdba = new Intent(getApplicationContext(), AttractionFiveActivity.class);
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