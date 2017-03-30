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
 * Created by ritesh on 15/11/16.
 */
@SuppressWarnings("deprecation")
public class EmmergencyDoctorActivity extends AppCompatActivity {

    private CollapsingToolbarLayout collapsingToolbarLayout = null;

    @BindView(R.id.toolbar_accomodation)
    Toolbar toolbaraccommodation;

    Bitmap bitmaptoolbarimage;

    @BindView(R.id.rlmain_emmergency_doctor_name)
    RelativeLayout emmergencyDoctorName;

    @BindView(R.id.rlmain_emmergency_doctor_address)
    RelativeLayout emmergencyDoctorAddress;

    @BindView(R.id.rlmain_emmergency_doctor_number)
    RelativeLayout emmergencyDoctorNumber;

    @BindView(R.id.tv_emmergency_doctor_name)
    TextView TVemmergencyDoctorName;

    @BindView(R.id.tv_emmergency_doctor_address)
    TextView TVemmergencyDoctorAddress;

    @BindView(R.id.tv_emmergency_doctor_number)
    TextView TVemmergencyDoctorNumber;


    String
            DoctorName,
            Doctoraddress,
            Doctoraddress_lat,
            Doctoraddress_lng,
            DoctorNumber;

    DatabaseHandler db = new DatabaseHandler(this);



    @BindView(R.id.tv_emmer_aoname_doct)
    TextView tvwelcome_emmer_doct;
    @BindView(R.id.iv_emmer_doct_image_one)
    ImageView aoImageOne;
    @BindView(R.id.iv_emmer_doct_image_two)
    ImageView aoImageTwo;


    String logoImagepath = "", pictureImagepath = "", name;
    Bitmap bitmaplogo;
    Bitmap bitmappicture;
    File SharedLogoImage, SharedPictureImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emm_doctor);
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
                            + " ,getem_docter_name: " + cn.getem_docter_name()
                            + " ,getem_docter_address_address: " + cn.getem_docter_address_address()
                            + " ,getem_docter_address_lat: " + cn.getem_docter_address_lat()
                            + " ,getem_docter_address_lng: " + cn.getem_docter_address_lng()
                            + " ,getem_docter_telephone: " + cn.getem_docter_telephone()
                            + " ,geta_logo_image: " + cn.geta_logo_image()
                            + " ,geta_picture_image: " + cn.geta_picture_image()
                            + " ,getname: " + cn.getname();

            // Writing Contacts to log
            Log.e("Emmergencr Doctor Data: ", log);
            DoctorName = cn.getem_docter_name();
            Doctoraddress = cn.getem_docter_address_address();
            Doctoraddress_lat = cn.getem_docter_address_lat();
            Doctoraddress_lng = cn.getem_docter_address_lng();
            DoctorNumber = cn.getem_docter_telephone();
            name = cn.getname();
            logoImagepath = cn.geta_logo_image();
            pictureImagepath = cn.geta_picture_image();


            if (name != null && !name.isEmpty()) {
                tvwelcome_emmer_doct.setText(name);
                Log.e("a_name is NOT null :", "YES");
            } else {
                Log.e("a_name is null :", "YES");
            }


            if (logoImagepath != null && !logoImagepath.isEmpty()) {
                Log.e("logoImagepath is NOT null :", "YES");
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


            if (DoctorName != null && !DoctorName.isEmpty()) {
                TVemmergencyDoctorName.setText(DoctorName);
                Log.e("DoctorName is NOT null :", "YES" + "Docter Name" + "" + DoctorName);
            } else {
                emmergencyDoctorName.setVisibility(View.GONE);
                Log.e("DoctorName is null :", "YES");
            }

            if (DoctorNumber != null && !DoctorNumber.isEmpty()) {
                TVemmergencyDoctorNumber.setText(DoctorNumber);
                Log.e("DoctorNumber is NOT null :", "YES");
            } else {
                emmergencyDoctorNumber.setVisibility(View.GONE);
                Log.e("DoctorNumber is null :", "YES");
            }

            if (Doctoraddress != null && !Doctoraddress.isEmpty()) {
                TVemmergencyDoctorAddress.setText(Doctoraddress);
                Log.e("Doctoraddress is NOT null :", "YES");
            } else {
                emmergencyDoctorAddress.setVisibility(View.GONE);
                Log.e("Doctoraddress is null :", "YES");
            }
        }


        emmergencyDoctorNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + DoctorNumber));
                startActivity(intent);
            }
        });

        emmergencyDoctorAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geoUri = "http://maps.google.com/maps?q=loc:"
                        + Doctoraddress_lat + "," + Doctoraddress_lng + " (" + Doctoraddress + ")";
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