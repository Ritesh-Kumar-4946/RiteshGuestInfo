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
import android.widget.Toast;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ritesh on 24/11/16.
 */

public class TransportMotoQuadScootHireActivity extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout = null;
    @BindView(R.id.toolbar_accomodation)
    Toolbar toolbaraccommodation;

    Bitmap bitmaptoolbarimage;

    @BindView(R.id.rlmain_motosquadscoothire_name)
    RelativeLayout rlmotosquadscoothire_name;

    @BindView(R.id.rlmain_motosquadscoothire_address)
    RelativeLayout rlmotosquadscoothire_address;

    @BindView(R.id.rlmain_motosquadscoothire_mobilee)
    RelativeLayout rlmotosquadscoothire_mobilee;

    @BindView(R.id.rlmain_motosquadscoothire_emmaill)
    RelativeLayout rlmotosquadscoothire_emmaill;

    @BindView(R.id.rlmain_motosquadscoothire_weblink)
    RelativeLayout rlmotosquadscoothire_weblink;

    @BindView(R.id.tv_motosquadscoothire_name)
    TextView motosquadscoothire_name;

    @BindView(R.id.tv_motosquadscoothire_address)
    TextView motosquadscoothire_address;

    @BindView(R.id.tv_motosquadscoothire_mobilee)
    TextView motosquadscoothire_mobilee;

    @BindView(R.id.tv_motosquadscoothire_emmaill)
    TextView motosquadscoothire_emmaill;

    @BindView(R.id.tv_motosquadscoothire_weblink)
    TextView motosquadscoothire_weblink;

    String
            MotoQuadScootHire_name,
            MotoQuadScootHire_mobilee,
            MotoQuadScootHire_address,
            MotoQuadScootHire_address_address,
            MotoQuadScootHire_address_address_lat,
            MotoQuadScootHire_address_address_lng,
            MotoQuadScootHire_website,
            MotoQuadScootHire_email;

    DatabaseHandler db = new DatabaseHandler(this);


    @BindView(R.id.tv_transport_motoquad_aoname)
    TextView tvwelcome_accomodation;
    @BindView(R.id.iv_transport_motoquad_image_one)
    ImageView aoImageOne;
    @BindView(R.id.iv_transport_motoquad_image_two)
    ImageView aoImageTwo;

    String logoImagepath = "", pictureImagepath = "", name;
    Bitmap bitmaplogo;
    Bitmap bitmappicture;
    File SharedLogoImage, SharedPictureImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_motoquadscoothire);
        ButterKnife.bind(this);

        setSupportActionBar(toolbaraccommodation);
        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_accommodatoin);
//        collapsingToolbarLayout.setTitle(getResources().getString(R.string.guestinfo));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        dynamicToolbarColor();
        toolbarTextAppernce();


        // Reading all contacts
        Log.e("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.Get_All_Contacts();

        for (Contact cn : contacts) {
            String log =
                    "Id: " + cn.getID()
                            + " ,getPOST_ID: " + cn.getPOST_ID()
                            + " ,gettrm_name: " + cn.gettrm_name()
                            + " ,gettrm_phone: " + cn.gettrm_phone()
                            + " ,gettrm_email: " + cn.gettrm_email()
                            + " ,gettrm_website: " + cn.gettrm_website()
                            + " ,gettrm_address: " + cn.gettrm_address()
                            + " ,gettrm_address_address: " + cn.gettrm_address_address()
                            + " ,gettrm_address_address_lat: " + cn.gettrm_address_address_lat()
                            + " ,gettrm_address_address_lng: " + cn.gettrm_address_address_lng()
                            + " ,geta_logo_image: " + cn.geta_logo_image()
                            + " ,geta_picture_image: " + cn.geta_picture_image()
                            + " ,getname: " + cn.getname();
            // Writing Contacts to log
            Log.e("Transport MotoSquad Sqlite Data: ", log);
            MotoQuadScootHire_name = cn.gettrm_name();
            MotoQuadScootHire_mobilee = cn.gettrm_phone();
            MotoQuadScootHire_address = cn.gettrm_address();
            MotoQuadScootHire_address_address = cn.gettrm_address_address();
            MotoQuadScootHire_address_address_lat = cn.gettrm_address_address_lat();
            MotoQuadScootHire_address_address_lng = cn.gettrm_address_address_lng();
            MotoQuadScootHire_email = cn.gettrm_email();
            MotoQuadScootHire_website = cn.gettrm_website();

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



            if (MotoQuadScootHire_name != null && !MotoQuadScootHire_name.isEmpty()) {
                motosquadscoothire_name.setText(MotoQuadScootHire_name);
                Log.e("motosquadscoothire_name is NOT null :", "YES");
            } else {
                rlmotosquadscoothire_name.setVisibility(View.GONE);
                Log.e("motosquadscoothire_name is null :", "YES");
            }

            if (MotoQuadScootHire_mobilee != null && !MotoQuadScootHire_mobilee.isEmpty()) {
                motosquadscoothire_mobilee.setText(MotoQuadScootHire_mobilee);
                Log.e("MotoQuadScootHire_mobilee is NOT null :", "YES");
            } else {
                rlmotosquadscoothire_mobilee.setVisibility(View.GONE);
                Log.e("MotoQuadScootHire_mobilee is null :", "YES");
            }

            if (MotoQuadScootHire_address != null && !MotoQuadScootHire_address.isEmpty()) {
                motosquadscoothire_address.setText(MotoQuadScootHire_address_address);
                Log.e("MotoQuadScootHire_address is NOT null :", "YES");
            } else {
                rlmotosquadscoothire_address.setVisibility(View.GONE);
                Log.e("MotoQuadScootHire_address is null :", "YES");
            }

            if (MotoQuadScootHire_email != null && !MotoQuadScootHire_email.isEmpty()) {
                motosquadscoothire_emmaill.setText(MotoQuadScootHire_email);
                Log.e("MotoQuadScootHire_email is NOT null :", "YES");
            } else {
                rlmotosquadscoothire_emmaill.setVisibility(View.GONE);
                Log.e("MotoQuadScootHire_email is null :", "YES");
            }

            if (MotoQuadScootHire_website != null && !MotoQuadScootHire_website.isEmpty()) {
                motosquadscoothire_weblink.setText(MotoQuadScootHire_website);
                Log.e("MotoQuadScootHire_website is NOT null :", "YES");
            } else {
                rlmotosquadscoothire_weblink.setVisibility(View.GONE);
                Log.e("MotoQuadScootHire_website is null :", "YES");
            }

            rlmotosquadscoothire_mobilee.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + MotoQuadScootHire_mobilee));
                    startActivity(intent);
                }
            });


            rlmotosquadscoothire_emmaill.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("message/rfc822");
                    i.putExtra(Intent.EXTRA_EMAIL  , new String[]{MotoQuadScootHire_email});
                    try {
                        startActivity(Intent.createChooser(i, "Send mail..."));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                    }
                }
            });


            rlmotosquadscoothire_weblink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = MotoQuadScootHire_website;
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            });

            rlmotosquadscoothire_address.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String geoUri = "http://maps.google.com/maps?q=loc:"
                            + MotoQuadScootHire_address_address_lat + "," + MotoQuadScootHire_address_address_lng + " (" + MotoQuadScootHire_address_address + ")";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                    startActivity(intent);
                }
            });

        }

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
