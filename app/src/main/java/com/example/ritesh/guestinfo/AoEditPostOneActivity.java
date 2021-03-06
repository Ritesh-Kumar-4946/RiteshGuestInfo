package com.example.ritesh.guestinfo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ritesh.guestinfo.constant.AppconstPostOne;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ritesh on 22/10/16.
 */

public class AoEditPostOneActivity extends AppCompatActivity {

    @BindView(R.id.rlmain_refresh_one)
    RelativeLayout rlrefreshbtn;

    @BindView(R.id.rlmain_change_accommodation_one)
    RelativeLayout rlchangeaccommodationbtn;

    @BindView(R.id.rlmain_back_one)
    RelativeLayout rlbackbtn;

    @BindView(R.id.rl_ao_post_id_edit_one)
    RelativeLayout rlAOpostidedit;

    @BindView(R.id.rl_ao_post_id_text_one)
    RelativeLayout rlAOpostidtext;

    @BindView(R.id.btn_ao_done_one)
    Button btnAOedid;

    @BindView(R.id.et_ao_post_id_one)
    EditText etAOpostid;

    @BindView(R.id.tv_ao_id_one)
    TextView tvPostid;

    private boolean isButtonClicked = false;
    String sharedPreferenceValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ao_edit_one);
        ButterKnife.bind(this);


        etAOpostid.setText("3565");
        AppconstPostOne.sharedpreferences = getSharedPreferences(AppconstPostOne.MyPREFERENCES, Context.MODE_PRIVATE);
        if (AppconstPostOne.sharedpreferences.contains(AppconstPostOne.PostIdOne)) {
            etAOpostid.setText(AppconstPostOne.sharedpreferences.getString(AppconstPostOne.PostIdOne, ""));

            sharedPreferenceValue = AppconstPostOne.sharedpreferences.getString(AppconstPostOne.PostIdOne, "");
            Log.e(" ** ** SharedPreference value OnCreate PostIdOne(id) ** ** : ", "" + sharedPreferenceValue);
            Log.e(" ** ** SharedPreference value OnCreate PostIdOne(id) ** ** : ", "" + sharedPreferenceValue);
        }

        String etpostidvalue = etAOpostid.getText().toString();
        tvPostid.setText(etpostidvalue);

        rlrefreshbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*TastyToast.makeText(getApplicationContext(), "Yeah... Comming Soon", TastyToast.LENGTH_LONG,
                        TastyToast.INFO);*/
                /*Intent bck = new Intent(getApplicationContext(), SelectByAOActivity.class);
                startActivity(bck);
                finish();*/
                onBackPressed();
            }
        });
        rlchangeaccommodationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*TastyToast.makeText(getApplicationContext(), "Yeah... Comming Soon", TastyToast.LENGTH_LONG,
                        TastyToast.SUCCESS);*/
                rlAOpostidedit.setVisibility(View.VISIBLE);
                rlAOpostidtext.setVisibility(View.GONE);

                AppconstPostOne.sharedpreferences = getSharedPreferences(AppconstPostOne.MyPREFERENCES, Context.MODE_PRIVATE);
                if (AppconstPostOne.sharedpreferences.contains(AppconstPostOne.PostIdOne)) {
                    etAOpostid.setText(AppconstPostOne.sharedpreferences.getString(AppconstPostOne.PostIdOne, ""));
                }

            }
        });
        rlbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*TastyToast.makeText(getApplicationContext(), "Yeah... Comming Soon", TastyToast.LENGTH_LONG,
                        TastyToast.ERROR);*/
                /*Intent bck = new Intent(getApplicationContext(), SelectByAOActivity.class);
                startActivity(bck);
                finish();*/
                onBackPressed();
            }
        });
    }

    public void Save(View view) {

        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibe.vibrate(50);

        String n = etAOpostid.getText().toString();

        AppconstPostOne.editor = AppconstPostOne.sharedpreferences.edit();
        AppconstPostOne.editor.putString(AppconstPostOne.PostIdOne, n);
        AppconstPostOne.editor.commit();
        Log.e("Set Value IN Shared Preference :", "" + n);
        Log.e("Set Value IN Shared Preference :", "" + n);
        Log.e("Set Value IN Shared Preference :", "" + n);
//            onBackPressed();


    }

    public void Get(View view) {
        AppconstPostOne.sharedpreferences = getSharedPreferences(AppconstPostOne.MyPREFERENCES, Context.MODE_PRIVATE);

        if (AppconstPostOne.sharedpreferences.contains(AppconstPostOne.PostIdOne)) {
            etAOpostid.setText(AppconstPostOne.sharedpreferences.getString(AppconstPostOne.PostIdOne, ""));

            Log.e("Get Value From Shared Preference :", "" +
                    AppconstPostOne.sharedpreferences.getString(AppconstPostOne.PostIdOne, ""));
            Log.e("Get Value From Shared Preference :", "" +
                    AppconstPostOne.sharedpreferences.getString(AppconstPostOne.PostIdOne, ""));
            Log.e("Get Value From Shared Preference :", "" +
                    AppconstPostOne.sharedpreferences.getString(AppconstPostOne.PostIdOne, ""));

        }
    }

    public void onStart() {
        super.onStart();
        Log.e("LifeCycleEvents", "In the onStart() event");
    }

    public void onRestart() {
        super.onRestart();
        Log.e("LifeCycleEvents", "In the onRestart() event");
    }

    public void onResume() {
        super.onResume();
        Log.e("LifeCycleEvents", "In the onResume() event");
    }

    public void onPause() {
        super.onPause();
        Log.e("LifeCycleEvents", "In the onPause() event");
    }

    public void onStop() {
        super.onStop();
        Log.e("LifeCycleEvents", "In the onStop() event");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.e("LifeCycleEvents", "In the onDestroy() event");
    }

    @Override
    public void onBackPressed() {
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
        Log.e("onBackPressed For AoEditPostOneActivity", "event");
        Log.e("onBackPressed For AoEditPostOneActivity", "event");
        Log.e("onBackPressed For AoEditPostOneActivity", "event");

        Intent intentback = new Intent(this, SelectByAOActivity.class);
       /* intentback.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intentback.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);*/
        startActivity(intentback);
//        finish();
    }
}
