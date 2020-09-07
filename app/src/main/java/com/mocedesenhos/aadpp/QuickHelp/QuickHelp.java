package com.mocedesenhos.aadpp.QuickHelp;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.mocedesenhos.aadpp.R;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public abstract class QuickHelp {

    public static final String ORDER_FRAGMENT ="OrderFragment" ;
    public static final String USER_FRAGMENT ="UserFragment" ;
    public static int OrderViewPagerNumber=0;

    public static final String EMAIL_PATTERN="[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
    public static String getIntent="";
    public static String getCategory="";
    public static String getCategoryName="";

    QuickHelp(){}


    public static void ExitActivityWithSlideAnimation(Activity activity)
    {

        activity.overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);

    }

    public static void EnterActivityWithSlideAnimation(Activity activity)
    {

        activity.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

    }
    public static void GotoActivity(Activity activity, Class<?>OtherClass)
    {
        Intent SignOutActivity =new Intent(activity, OtherClass);
        activity.startActivity(SignOutActivity);
    }

    public static void GotoActivityWithTimer(final Activity activity, Class<?>OtherClass)
    {
        final Intent StartViaAngolana =new Intent(activity, OtherClass);


        Thread timer =new Thread() {

            public void run ()
            {
                try {
                    sleep(5000);
                }
                catch (InterruptedException e)

                {
                    e.printStackTrace();

                }
                finally {

                    activity.startActivity(StartViaAngolana);
                    activity.finish();

                }

            }

        };

        timer.start();


    }

    /**
     * method to check if internet connection exist
     */
    public static boolean isInternetAvailable(Activity activity) {
        ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = null;
        if (connectivityManager != null) {
            netInfo = connectivityManager.getActiveNetworkInfo();
        }
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }



    public static void getDialogDAtePicker(Fragment fragment)
    {
        // DialogFragment datePicker=new DatePickerFragment();

        if (fragment.getFragmentManager() != null) {
            //      datePicker.show(fragment.getFragmentManager(), Constants.DATE_PICKER);
        }

    }

    public static void startCalendar(DatePicker datePicker, int year, int month, int day, TextView tv, String currentDate)
    {
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH,day);
        currentDate= DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        tv.setText(currentDate);
    }

    public static void sendLocalBroadCastOne(LocalBroadcastManager localBroadcastManager, Activity activity, String actionMessage)
    {
        localBroadcastManager= LocalBroadcastManager.getInstance(activity);
        Intent intent=new Intent(actionMessage);
        //intent.putExtra("Enable", enable);
        localBroadcastManager.sendBroadcast(intent);
    }

    public static String getCurrentDate(TextView setDate)
    {
        String date= new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        setDate.setText(date);
        return date;
    }

    public static void sendLocalBroadCastWithOneContent(LocalBroadcastManager localBroadcastManager, Activity activity,String actionMessage)
    {


        localBroadcastManager=LocalBroadcastManager.getInstance(activity);
        Intent intent=new Intent("ENABLE_NEXT_BUTTON");
        intent.putExtra("Enable", actionMessage);
        localBroadcastManager.sendBroadcast(intent);

    }



    public static void startProgressDialog(ProgressDialog progressDialog, String title, String message, Activity activity)
    {
        progressDialog =new ProgressDialog(activity);
        progressDialog.setIcon(R.drawable.logo);
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.show();
    }
    static private Uri getImageUriFromBitmap(Context context , Bitmap bitmap){
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, "Title", null);
        return Uri.parse(path);
    }
    /**
     * method to Hint Reload layout
     */

    public static void HintReloadLayoutVisibility(View view, boolean setVisible)
    {
        if(setVisible)
        {
            view.setVisibility(View.VISIBLE);
        }
        else
        {
            view.setVisibility(View.GONE);
        }

    }

    public static void GotoActivityWithOneString(Activity activity, Class<?> OtherClass, String Id, String value) {
        Intent SignOutActivity =new Intent(activity, OtherClass);
        SignOutActivity.putExtra(Id,value);
        activity.startActivity(SignOutActivity);

    }


    private void SelectPDF(Activity activity) {

        Intent selectPdf=new Intent();
        selectPdf.setType("application/pdf");
        selectPdf.setAction(Intent.ACTION_GET_CONTENT);//Intent to fetch files
        activity.startActivityForResult(selectPdf,Constants.REQUEST_CODE_FOR_PDF_SELECTION);

    }

}
