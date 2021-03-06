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
 * Created by ritesh on 7/12/16.
 */

public class AoEditPostThreeActivity extends AppCompatActivity {

    @BindView(R.id.rl_refresh_three)
    RelativeLayout rlrefreshbtn;

    @BindView(R.id.rl_change_accommodation_three)
    RelativeLayout rlchangeaccommodationbtn;

    @BindView(R.id.rl_back_three)
    RelativeLayout rlbackbtn;

    @BindView(R.id.rl_ao_post_id_edit_three)
    RelativeLayout rlAOpostidedit;

    @BindView(R.id.rl_ao_post_id_text_three)
    RelativeLayout rlAOpostidtext;

    @BindView(R.id.btn_ao_done_three)
    Button btnAOedid;

    @BindView(R.id.et_ao_post_id_three)
    EditText etAOpostid;

    @BindView(R.id.tv_ao_id_three)
    TextView tvPostid;

    private boolean isButtonClicked = false;
    String sharedPreferenceValue = "";

    String s;
    public static int r = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ao_edit_three);
        ButterKnife.bind(this);

        s = getIntent().getStringExtra("FRAGTYPE");
        Log.e(" Intent FRAGTYPE :", "" + s);
        Log.e(" Intent FRAGTYPE :", "" + s);


//        etAOpostid.setText("3565");
        AppconstPostOne.sharedpreferences = getSharedPreferences(AppconstPostOne.MyPREFERENCES, Context.MODE_PRIVATE);
        if (AppconstPostOne.sharedpreferences.contains(AppconstPostOne.PostIdThree)) {
            etAOpostid.setText(AppconstPostOne.sharedpreferences.getString(AppconstPostOne.PostIdThree, ""));

            sharedPreferenceValue = AppconstPostOne.sharedpreferences.getString(AppconstPostOne.PostIdThree, "");
            Log.e(" ** ** SharedPreference value OnCreate PostIdThree(id) ** ** : ", "" + sharedPreferenceValue);
            Log.e(" ** ** SharedPreference value OnCreate PostIdThree(id) ** ** : ", "" + sharedPreferenceValue);
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
                if (AppconstPostOne.sharedpreferences.contains(AppconstPostOne.PostIdThree)) {
                    etAOpostid.setText(AppconstPostOne.sharedpreferences.getString(AppconstPostOne.PostIdThree, ""));
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

        String nthree = etAOpostid.getText().toString();
        AppconstPostOne.editor = AppconstPostOne.sharedpreferences.edit();
        AppconstPostOne.editor.putString(AppconstPostOne.PostIdThree, nthree);
        AppconstPostOne.editor.commit();
        Log.e("Set Value IN Shared Preference :", "" + nthree);
        Log.e("Set Value IN Shared Preference :", "" + nthree);
        Log.e("Set Value IN Shared Preference :", "" + nthree);

    }

    public void Get(View view) {
        AppconstPostOne.sharedpreferences = getSharedPreferences(AppconstPostOne.MyPREFERENCES, Context.MODE_PRIVATE);

        if (AppconstPostOne.sharedpreferences.contains(AppconstPostOne.PostIdThree)) {
            etAOpostid.setText(AppconstPostOne.sharedpreferences.getString(AppconstPostOne.PostIdThree, ""));

            Log.e("Get Value From Shared Preference :", "" +
                    AppconstPostOne.sharedpreferences.getString(AppconstPostOne.PostIdThree, ""));
            Log.e("Get Value From Shared Preference :", "" +
                    AppconstPostOne.sharedpreferences.getString(AppconstPostOne.PostIdThree, ""));
            Log.e("Get Value From Shared Preference :", "" +
                    AppconstPostOne.sharedpreferences.getString(AppconstPostOne.PostIdThree, ""));

        }
    }

    public void onStart() {
        super.onStart();
        Log.e("LifeCycleEvents  For AoEditPostThreeActivity", "In the onStart() event");
    }

    public void onRestart() {
        super.onRestart();
        Log.e("LifeCycleEvents  For AoEditPostThreeActivity", "In the onRestart() event");
    }

    public void onResume() {
        super.onResume();
        Log.e("LifeCycleEvents  For AoEditPostThreeActivity", "In the onResume() event");
    }

    public void onPause() {
        super.onPause();
        Log.e("LifeCycleEvents  For AoEditPostThreeActivity", "In the onPause() event");
    }

    public void onStop() {
        super.onStop();
        Log.e("LifeCycleEvents  For AoEditPostThreeActivity", "In the onStop() event");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.e("LifeCycleEvents  For AoEditPostThreeActivity", "In the onDestroy() event");
    }

    @Override
    public void onBackPressed() {
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
        Log.e("onBackPressed For AoEditPostThreeActivity", "event");
        Log.e("onBackPressed For AoEditPostThreeActivity", "event");
        Log.e("onBackPressed For AoEditPostThreeActivity", "event");

        r = 20;
        Intent intentback = new Intent(AoEditPostThreeActivity.this, SelectByAOActivity.class);
        startActivity(intentback);
    }

}