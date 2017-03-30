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

public class AoEditPostTwoActivity extends AppCompatActivity {

    @BindView(R.id.rl_refresh_two)
    RelativeLayout rlrefreshbtn;

    @BindView(R.id.rl_change_accommodation_two)
    RelativeLayout rlchangeaccommodationbtn;

    @BindView(R.id.rl_back_two)
    RelativeLayout rlbackbtn;

    @BindView(R.id.rl_ao_post_id_edit_two)
    RelativeLayout rlAOpostidedit;

    @BindView(R.id.rl_ao_post_id_text_two)
    RelativeLayout rlAOpostidtext;

    @BindView(R.id.btn_ao_done_two)
    Button btnAOedid;

    @BindView(R.id.et_ao_post_id_two)
    EditText etAOpostid;

    @BindView(R.id.tv_ao_id_two)
    TextView tvPostid;

    private boolean isButtonClicked = false;
    String sharedPreferenceValue = "";

    String s, etpostidvalue;
    public static int r = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ao_edit_two);
        ButterKnife.bind(this);

        s = getIntent().getStringExtra("FRAGTYPE");
        Log.e(" Intent FRAGTYPE :", "" + s);
        Log.e(" Intent FRAGTYPE :", "" + s);

//        etAOpostid.setText("3565");
        AppconstPostOne.sharedpreferences = getSharedPreferences(AppconstPostOne.MyPREFERENCES, Context.MODE_PRIVATE);
        if (AppconstPostOne.sharedpreferences.contains(AppconstPostOne.PostIdTwo)) {
            etAOpostid.setText(AppconstPostOne.sharedpreferences.getString(AppconstPostOne.PostIdTwo, ""));

            sharedPreferenceValue = AppconstPostOne.sharedpreferences.getString(AppconstPostOne.PostIdTwo, "");
            Log.e(" ** ** SharedPreference value OnCreate PostIdTwo(id) ** ** : ", "" + sharedPreferenceValue);
            Log.e(" ** ** SharedPreference value OnCreate PostIdTwo(id) ** ** : ", "" + sharedPreferenceValue);
        }


        etpostidvalue = etAOpostid.getText().toString();
        tvPostid.setText(etpostidvalue);

        rlrefreshbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*r = 10;
                Intent inttt = new Intent(AoEditPostTwoActivity.this, SelectByAOActivity.class);
                startActivity(inttt);
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
                if (AppconstPostOne.sharedpreferences.contains(AppconstPostOne.PostIdTwo)) {
                    etAOpostid.setText(AppconstPostOne.sharedpreferences.getString(AppconstPostOne.PostIdTwo, ""));
                }

            }
        });
        rlbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*TastyToast.makeText(getApplicationContext(), "Yeah... Comming Soon", TastyToast.LENGTH_LONG,
                        TastyToast.ERROR);*/
                /*Intent bck = new Intent(getApplicationContext(), SelectByAOActivity.class);
                startActivity(bck);*/
//                finish();
                onBackPressed();
            }
        });
    }

    public void Save(View view) {

        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibe.vibrate(50);

        String ntwo = etAOpostid.getText().toString();

        AppconstPostOne.editor = AppconstPostOne.sharedpreferences.edit();
        AppconstPostOne.editor.putString(AppconstPostOne.PostIdTwo, ntwo);
        AppconstPostOne.editor.commit();
        Log.e("Set Value IN Shared Preference :", "" + ntwo);
        Log.e("Set Value IN Shared Preference :", "" + ntwo);
        Log.e("Set Value IN Shared Preference :", "" + ntwo);
        /*r = 10;
        Intent inttt = new Intent(AoEditPostTwoActivity.this, SelectByAOActivity.class);
        startActivity(inttt);
        finish();*/
    }

    public void Get(View view) {
        AppconstPostOne.sharedpreferences = getSharedPreferences(AppconstPostOne.MyPREFERENCES, Context.MODE_PRIVATE);

        if (AppconstPostOne.sharedpreferences.contains(AppconstPostOne.PostIdTwo)) {
            etAOpostid.setText(AppconstPostOne.sharedpreferences.getString(AppconstPostOne.PostIdTwo, ""));

            Log.e("Get Value From Shared Preference :", "" +
                    AppconstPostOne.sharedpreferences.getString(AppconstPostOne.PostIdTwo, ""));
            Log.e("Get Value From Shared Preference :", "" +
                    AppconstPostOne.sharedpreferences.getString(AppconstPostOne.PostIdTwo, ""));
            Log.e("Get Value From Shared Preference :", "" +
                    AppconstPostOne.sharedpreferences.getString(AppconstPostOne.PostIdTwo, ""));

        }
    }

    public void onStart() {
        super.onStart();
        Log.e("LifeCycleEvents For AoEditPostTwoActivity", "In the onStart() event");
    }

    public void onRestart() {
        super.onRestart();
        Log.e("LifeCycleEvents For AoEditPostTwoActivity", "In the onRestart() event");
    }

    public void onResume() {
        super.onResume();
        Log.e("LifeCycleEvents For AoEditPostTwoActivity", "In the onResume() event");
    }

    public void onPause() {
        super.onPause();
        Log.e("LifeCycleEvents For AoEditPostTwoActivity", "In the onPause() event");
    }

    public void onStop() {
        super.onStop();
        Log.e("LifeCycleEvents For AoEditPostTwoActivity", "In the onStop() event");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.e("LifeCycleEvents For AoEditPostTwoActivity", "In the onDestroy() event");
    }

    @Override
    public void onBackPressed() {
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
        Log.e("onBackPressed For AoEditPostTwoActivity", "event");
        Log.e("onBackPressed For AoEditPostTwoActivity", "event");
        Log.e("onBackPressed For AoEditPostTwoActivity", "event");

        r = 10;
        Intent intentback = new Intent(AoEditPostTwoActivity.this, SelectByAOActivity.class);
        startActivity(intentback);
//        finish();
    }

}
