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
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ritesh on 19/10/16.
 */
@SuppressWarnings("deprecation")
public class SelectByTRActivity extends AppCompatActivity {

    private CollapsingToolbarLayout collapsingToolbarLayout = null;
    @BindView(R.id.toolbar_accomodation)
    Toolbar toolbaraccommodation;

    Bitmap bitmaptoolbarimage;

    @BindView(R.id.tv_welcome_parent)
    TextView tvwelcomparent;

    @BindView(R.id.rlmain_welcome)
    RelativeLayout rlwelcome;

    @BindView(R.id.rl_emmergency)
    RelativeLayout Emmergency;

    @BindView(R.id.rl_accomodation)
    RelativeLayout Accomodation;

    @BindView(R.id.rl_localcontactperson)
    RelativeLayout LocalContactPerson;

    @BindView(R.id.rl_owner)
    RelativeLayout Owner;

    @BindView(R.id.rl_food_drink)
    RelativeLayout FoodDrink;

    @BindView(R.id.rl_transport)
    RelativeLayout Transport;

    @BindView(R.id.rl_services)
    RelativeLayout Services;

    @BindView(R.id.rl_attractions)
    RelativeLayout Attractions;

    @BindView(R.id.rl_entertainment)
    RelativeLayout Entertainment;

    @BindView(R.id.rl_resto_bar_shop)
    RelativeLayout RestoBarShop;

    @BindView(R.id.rl_comfort)
    RelativeLayout Comfort;

    @BindView(R.id.iv_aoimage_one)
    ImageView aoImageOne;

    @BindView(R.id.iv_aoimage_two)
    ImageView aoImageTwo;

    String logoImagepath = "", pictureImagepath = "", a_welcome;

    Bitmap bitmaplogo;
    Bitmap bitmappicture;
    File SharedLogoImage, SharedPictureImage;

    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_by_tr);
        ButterKnife.bind(this);
        db = new DatabaseHandler(this);

        Log.e("Reading: ", "Reading all contacts..");

        ArrayList<Contact> contacts = db.Get_All_Contacts();
        if (contacts.size() >= 0) {
            Contact contactss;
            for (int i = 0; i < contacts.size(); i++) {
                contactss = contacts.get(i);
                String log =
                        "Id: " + contactss.getID()
                                + " ,getPOST_ID: " + contactss.getPOST_ID()
                                + " ,geta_logo_image: " + contactss.geta_logo_image()
                                + " ,geta_picture_image: " + contactss.geta_picture_image()
                                + " ,geta_welcome: " + contactss.geta_welcome();
                // Writing Contacts to log
                Log.e(" <<DataBase Recored for select by tr activity>>: ", "" + log);
                a_welcome = contactss.geta_welcome();
                logoImagepath = contactss.geta_logo_image();
                pictureImagepath = contactss.geta_picture_image();

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

           /* bitmaplogo = BitmapFactory.decodeFile(SharedLogoImage.getAbsolutePath());
            ivphoto.setImageBitmap(bitmaplogo);*/

                    } else {
                        Log.e("File does not exists!", "YES");
                    }

                    Log.e(" original bitmap bitmappicture : ", "" + bitmappicture);


                } else {
//                    rlwelcome.setVisibility(View.GONE);
                    Log.e("pictureImagepath is null :", "YES");
                }

                if (a_welcome != null && !a_welcome.isEmpty()) {
                    tvwelcomparent.setText(Html.fromHtml(a_welcome));
                } else {
                    rlwelcome.setVisibility(View.GONE);
                    Log.e("a_welcome is null :", "YES");
                }
            }
        }




           /*image setting by universal image loader */
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(SelectByTRActivity.this).defaultDisplayImageOptions(defaultOptions).build();
        ImageLoader.getInstance().init(config);
        /*image settin by universal image loader */

        setSupportActionBar(toolbaraccommodation);
        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);


        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_accommodatoin);
//        collapsingToolbarLayout.setTitle(getResources().getString(R.string.guestinfo));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        dynamicToolbarColor();
        toolbarTextAppernce();


        Emmergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*TastyToast.makeText(getApplicationContext(), "Yeah... Comming Soon", TastyToast.LENGTH_LONG,
                        TastyToast.INFO);*/

                Intent emmer = new Intent(getApplicationContext(), EmmergencyActivity.class);
                startActivity(emmer);
            }
        });
        Accomodation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* TastyToast.makeText(getApplicationContext(), "Yeah... Comming Soon", TastyToast.LENGTH_LONG,
                        TastyToast.WARNING);*/
                Intent accom = new Intent(getApplicationContext(), AccomodationActivity.class);
                startActivity(accom);
            }
        });
        LocalContactPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*TastyToast.makeText(getApplicationContext(), "Yeah... Comming Soon", TastyToast.LENGTH_LONG,
                        TastyToast.DEFAULT);*/
                Intent LocConPer = new Intent(getApplicationContext(), LocalContactPerson.class);
                startActivity(LocConPer);
            }
        });
        Owner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*TastyToast.makeText(getApplicationContext(), "Yeah... Comming Soon", TastyToast.LENGTH_LONG,
                        TastyToast.ERROR);*/
                Intent own = new Intent(getApplicationContext(), OwnerActivity.class);
                startActivity(own);
            }
        });
        FoodDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*TastyToast.makeText(getApplicationContext(), "Yeah... Comming Soon", TastyToast.LENGTH_LONG,
                        TastyToast.SUCCESS);*/
                Intent foo = new Intent(getApplicationContext(), FoodDrinkActivity.class);
                startActivity(foo);
            }
        });
        Transport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*TastyToast.makeText(getApplicationContext(), "Yeah... Comming Soon", TastyToast.LENGTH_LONG,
                        TastyToast.INFO);*/
                Intent trans = new Intent(getApplicationContext(), TransportActivity.class);
                startActivity(trans);
            }
        });
        Services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Toast.makeText(getApplicationContext(),
                        "Yeah... Comming Soon", Toast.LENGTH_LONG).show();*/
                Intent serv = new Intent(getApplicationContext(), ServicesActivity.class);
                startActivity(serv);
            }
        });
        Attractions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*TastyToast.makeText(getApplicationContext(), "Yeah... Comming Soon", TastyToast.LENGTH_LONG,
                        TastyToast.INFO);*/
                Intent attr = new Intent(getApplicationContext(), AttractionActivity.class);
                startActivity(attr);
            }
        });
        Entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*TastyToast.makeText(getApplicationContext(), "Yeah... Comming Soon", TastyToast.LENGTH_LONG,
                        TastyToast.INFO);*/
                Intent ente = new Intent(getApplicationContext(), EntertainmentActivity.class);
                startActivity(ente);
            }
        });
        RestoBarShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*TastyToast.makeText(getApplicationContext(), "Yeah... Comming Soon", TastyToast.LENGTH_LONG,
                        TastyToast.INFO);*/
                Intent resto = new Intent(getApplicationContext(), RestoBarShopActivity.class);
                startActivity(resto);
            }
        });
        Comfort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*TastyToast.makeText(getApplicationContext(), "Yeah... Comming Soon", TastyToast.LENGTH_LONG,
                        TastyToast.INFO);*/
                Intent comf = new Intent(getApplicationContext(), ComfortActivity.class);
                startActivity(comf);
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
