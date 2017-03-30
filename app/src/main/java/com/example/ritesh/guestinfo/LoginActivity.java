package com.example.ritesh.guestinfo;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.ritesh.guestinfo.constant.Appconstant;
import com.example.ritesh.guestinfo.constant.HttpUrlPath;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ritesh on 19/10/16.
 */

@SuppressWarnings("deprecation")
public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btn_loginclick)
    Button loginclick;
    @BindView(R.id.et_name)
    EditText username;
    @BindView(R.id.et_emailiddd)
    EditText useremailid;

    String result = "",
            str_UserEmail = "",
            str_UserName = "",
            str_UserPassword = "",
            str_UserNiceName = "",
            str_UserUrl = "",
            str_UserregisterDate = "",
            str_UserDisplaymname = "",
            userid = " ";

    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        if (checkAndRequestPermissions()) {
            // carry on the normal flow, as the case of  permissions  granted.
        }

        Appconstant.preferenceguestinfo = getSharedPreferences(Appconstant.MyPREFERENCES, Context.MODE_PRIVATE);

        loginclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean iserror = false;

                str_UserEmail = useremailid.getText().toString().trim();
                str_UserName = username.getText().toString().trim();

                /* make edittext condition for empty, input etc match */
                if (str_UserEmail.equals("")) {
                    iserror = true;
                    /**************** Start Animation ****************/
                    YoYo.with(Techniques.Tada)
                            .duration(700)
                            .playOn(useremailid);
                    /**************** End Animation ****************/

                    Toast.makeText(getApplicationContext(), "Please enter email address.", Toast.LENGTH_LONG).show();
                } else if (!isValidEmail(str_UserEmail)) {
                    iserror = true;
                    useremailid.requestFocus();

                    /**************** Start Animation ****************/
                    YoYo.with(Techniques.Shake)
                            .duration(700)
                            .playOn(useremailid);
                    /**************** End Animation ****************/

                    Toast.makeText(getApplicationContext(), "Enter valid email.", Toast.LENGTH_SHORT).show();

                } else if (username.equals("")) {
                    iserror = true;

                    /**************** Start Animation ****************/
                    YoYo.with(Techniques.Tada)
                            .duration(700)
                            .playOn(username);
                    /**************** End Animation ****************/

                    Toast.makeText(getApplicationContext(), "Please enter your User Name", Toast.LENGTH_LONG).show();
                }
                if (!iserror) {

                    if (Utils.isConnected(getApplicationContext())) {
                        Loginjsontask task = new Loginjsontask();
                        task.execute();
                    } else {
                        //Toast.makeText(getApplicationContext(), "Please Cheeck network conection..", Toast.LENGTH_SHORT).show();

                        //  TODO Auto-generated method stub

                        LayoutInflater layoutInflater = LayoutInflater.from(LoginActivity.this);
                        View promptView = layoutInflater.inflate(R.layout.activity_wificheck_customalert, null);
                        final AlertDialog alertD = new AlertDialog.Builder(LoginActivity.this).create();
            /*prevent alert dialog from outside click and back button click (Star)*/
                        alertD.setCanceledOnTouchOutside(false);
                        alertD.setCancelable(false);
            /*prevent alert dialog from outside click and back button click (Star)*/
                        Button Tryagain = (Button) promptView.findViewById(R.id.btn_tryagain);
                        Tryagain.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = getIntent();
                                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                finish();
                                overridePendingTransition(0, 0);
                                startActivity(getIntent());
                                overridePendingTransition(0, 0);
                            }
                        });
                        alertD.setView(promptView);
                        alertD.show();

                    }
                }
            }
        });
    }

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target)
                    .matches();
        }
    }

    public class Loginjsontask extends AsyncTask<String, Void, String> {

        boolean iserror = false;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            //  loginprogressbar.setVisibility(View.VISIBLE);
            Log.e("******* NOW LOGIN WEB SERVICE IS RUNNING *******", "YES");
            Log.e("******* NOW LOGIN WEB SERVICE IS RUNNING *******", "YES");
        }

        @Override
        protected String doInBackground(String... params) {
            Log.e("******* NOW LOGIN BACKGROUND TASK IS RUNNING *******", "YES");
            Log.e("******* NOW LOGIN BACKGROUND TASK IS RUNNING *******", "YES");

            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(HttpUrlPath.urlPath + "login&");

            try {
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(7);
                nameValuePairs.add(new BasicNameValuePair("email", str_UserEmail));
                nameValuePairs.add(new BasicNameValuePair("user", str_UserName));

                post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = client.execute(post);
                String object = EntityUtils.toString(response.getEntity());
                Log.e("****************object*******************=", "" + object);
                Log.e("****************object*******************=", "" + object);
                Log.e("****************object*******************=", "" + object);
                System.out.println("****************object*******************=" + object);
                System.out.println("****************object*******************=" + object);
                System.out.println("****************object*******************=" + object);

                //JSONArray js = new JSONArray(object);
                JSONObject jobect = new JSONObject(object);
                result = jobect.getString("result");
                if (result.equalsIgnoreCase("Success")) {
                    userid = jobect.getString("ID");
                    Log.e("******* ID RETURN BY SERVER *******", "" + userid);
                    Log.e("******* ID RETURN BY SERVER *******", "" + userid);
                    Log.e("******* ID RETURN BY SERVER *******", "" + userid);

                    str_UserEmail = jobect.getString("user_email");
                    Log.e("******* EMAIL RETURN BY SERVER *******", "" + str_UserEmail);
                    Log.e("******* EMAIL RETURN BY SERVER *******", "" + str_UserEmail);
                    Log.e("******* EMAIL RETURN BY SERVER *******", "" + str_UserEmail);

                    str_UserName = jobect.getString("user_login");
                    Log.e("******* USER NAME RETURN BY SERVER *******", "" + str_UserName);
                    Log.e("******* USER NAME RETURN BY SERVER *******", "" + str_UserName);
                    Log.e("******* USER NAME RETURN BY SERVER *******", "" + str_UserName);

                    str_UserPassword = jobect.getString("user_pass");
                    Log.e("******* PASSWORD RETURN BY SERVER *******", "" + str_UserPassword);
                    Log.e("******* PASSWORD RETURN BY SERVER *******", "" + str_UserPassword);
                    Log.e("******* PASSWORD RETURN BY SERVER *******", "" + str_UserPassword);

                    str_UserNiceName = jobect.getString("user_nicename");
                    Log.e("******* USER NICE NAME RETURN BY SERVER *******", "" + str_UserNiceName);
                    Log.e("******* USER NICE NAME RETURN BY SERVER *******", "" + str_UserNiceName);
                    Log.e("******* USER NICE NAME RETURN BY SERVER *******", "" + str_UserNiceName);

                    str_UserUrl = jobect.getString("user_url");
                    Log.e("******* USER URL RETURN BY SERVER *******", "" + str_UserUrl);
                    Log.e("******* USER URL RETURN BY SERVER *******", "" + str_UserUrl);
                    Log.e("******* USER URL RETURN BY SERVER *******", "" + str_UserUrl);

                    str_UserregisterDate = jobect.getString("user_registered");
                    Log.e("******* USER REGISTER DATE RETURN BY SERVER *******", "" + str_UserregisterDate);
                    Log.e("******* USER REGISTER DATE RETURN BY SERVER *******", "" + str_UserregisterDate);
                    Log.e("******* USER REGISTER DATE RETURN BY SERVER *******", "" + str_UserregisterDate);

                    str_UserDisplaymname = jobect.getString("display_name");
                    Log.e("******* USER DISPLAY NAME RETURN BY SERVER *******", "" + str_UserDisplaymname);
                    Log.e("******* USER DISPLAY NAME RETURN BY SERVER *******", "" + str_UserDisplaymname);
                    Log.e("******* USER DISPLAY NAME RETURN BY SERVER *******", "" + str_UserDisplaymname);


                }


            } catch (Exception e) {
                Log.v("22", "22" + e.getMessage());
                e.printStackTrace();
                iserror = true;
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result1) {
            // TODO Auto-generated method stub
            super.onPostExecute(result1);

            if (!iserror) {
                if (result.equalsIgnoreCase("Success")) {

                    //  loginprogressbar.setVisibility(View.GONE);
                    Appconstant.preferenceguestinfo = getSharedPreferences(Appconstant.MyPREFERENCES, Context.MODE_PRIVATE);
                    Appconstant.editorguestinfo = Appconstant.preferenceguestinfo.edit();
                    Appconstant.editorguestinfo.putString("LoginSuccessfully", Appconstant.islogin);
                    Appconstant.editorguestinfo.putString("ID", userid);
                    Appconstant.editorguestinfo.putString("loginTest", "true");
                    Appconstant.editorguestinfo.putString("user_email", str_UserEmail);
                    Appconstant.editorguestinfo.putString("user_login", str_UserName);

                    Log.e("********* SHARED PREFERENCE USER EMAIL ID *********", "user_email :" + "" + str_UserEmail);
                    Log.e("********* SHARED PREFERENCE USER EMAIL ID *********", "user_email :" + "" + str_UserEmail);
                    Log.e("********* SHARED PREFERENCE USER EMAIL ID *********", "user_email :" + "" + str_UserEmail);

                    Log.e("********* SHARED PREFERENCE USER NAME *********", "user_login" + "" + str_UserName);
                    Log.e("********* SHARED PREFERENCE USER NAME *********", "user_login" + "" + str_UserName);
                    Log.e("********* SHARED PREFERENCE USER NAME *********", "user_login" + "" + str_UserName);

                    Log.e("********* GET USER ID *********", "" + userid + "\nSuccess USERNAME PASSWORD MATCH");
                    Log.e("********* GET USER ID *********", "" + userid + "\nSuccess USERNAME PASSWORD MATCH");
                    Log.e("********* GET USER ID *********", "" + userid + "\nSuccess USERNAME PASSWORD MATCH");
                    Appconstant.editorguestinfo.commit();

                    Log.e("********* Login Detail SEND *********", "Success USERNAME PASSWORD MATCH GOTO MAINPAGE");
                    Log.e("********* Login Detail SEND *********", "Success USERNAME PASSWORD MATCH GOTO MAINPAGE");
                    Log.e("********* Login Detail SEND *********", "Success USERNAME PASSWORD MATCH GOTO MAINPAGE");

                    Toast.makeText(LoginActivity.this, "Login Successfully ", Toast.LENGTH_SHORT).show();
                    /*Intent in = new Intent(LoginActivity.this, CameraActivity.class);
                    in.putExtra("EXIT", "0");
                    in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    LoginActivity.this.startActivity(in);
                    finish();*/

                    Intent abount = new Intent(getApplicationContext(), SelectByAOActivity.class);
                    abount.putExtra("EXIT", "0");
                    abount.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(abount);

                } else {

                    /**************** Start Animation ****************/
                    YoYo.with(Techniques.Swing)
                            .duration(700)
                            .playOn(useremailid);

                    YoYo.with(Techniques.Swing)
                            .duration(700)
                            .playOn(username);
                    /**************** End Animation ****************/

                    Log.e("********* Login Detail SEND *********", "NOT Success USERNAME PASSWORD ERROR");
                    Log.e("********* Login Detail SEND *********", "NOT Success USERNAME PASSWORD ERROR");
                    Log.e("********* Login Detail SEND *********", "NOT Success USERNAME PASSWORD ERROR");

                    Toast.makeText(getApplicationContext(), "Username or Password is wrong",
                            Toast.LENGTH_SHORT).show();
//									// TODO Auto-generated method stub
                }
            } else {
                Log.e("********* Login Detail SEND *********", "NOT Success");
                Log.e("********* Login Detail SEND *********", "NOT Success");
                Log.e("********* Login Detail SEND *********", "NOT Success");

                Toast.makeText(getApplicationContext(), "Oops!! Please check server connection .",
                        Toast.LENGTH_SHORT).show();
//								// TODO Auto-generated method stub
            }
        }
    }


    private boolean checkAndRequestPermissions() {
        int permissionSendMessage = ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS);
        int locationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        List<String> listPermissionsNeeded = new ArrayList<>();
        if (locationPermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (permissionSendMessage != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.SEND_SMS);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        Log.e("Permission callback called-------", "yes");
        switch (requestCode) {
            case REQUEST_ID_MULTIPLE_PERMISSIONS: {

                Map<String, Integer> perms = new HashMap<>();
                // Initialize the map with both permissions
                perms.put(Manifest.permission.SEND_SMS, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.ACCESS_FINE_LOCATION, PackageManager.PERMISSION_GRANTED);
                // Fill with actual results from user
                if (grantResults.length > 0) {
                    for (int i = 0; i < permissions.length; i++)
                        perms.put(permissions[i], grantResults[i]);
                    // Check for both permissions
                    if (perms.get(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED
                            && perms.get(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        Log.e("sms & location services permission granted", "ok");
                        // process the normal flow
                        //else any one or both the permissions are not granted
                    } else {
                        Log.d("Some permissions are not granted ask again ", "ok");
                        //permission is denied (this is the first time, when "never ask again" is not checked) so ask again explaining the usage of permission
//                        // shouldShowRequestPermissionRationale will return true
                        //show the dialog or snackbar saying its necessary and try again otherwise proceed with setup.
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS) || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                            showDialogOK("SMS and Location Services Permission required for this app",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            switch (which) {
                                                case DialogInterface.BUTTON_POSITIVE:
                                                    checkAndRequestPermissions();
                                                    break;
                                                case DialogInterface.BUTTON_NEGATIVE:
                                                    // proceed with logic by disabling the related features or quit the app.
                                                    break;
                                            }
                                        }
                                    });
                        }
                        //permission is denied (and never ask again is  checked)
                        //shouldShowRequestPermissionRationale will return false
                        else {
                            Toast.makeText(this, "Go to settings and enable permissions", Toast.LENGTH_LONG)
                                    .show();
                            //                            //proceed with logic by disabling the related features or quit the app.
                        }
                    }
                }
            }
        }

    }

    private void showDialogOK(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", okListener)
                .create()
                .show();
    }
}
