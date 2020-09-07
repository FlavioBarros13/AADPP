package com.mocedesenhos.aadpp.QuickHelp;

import android.graphics.Bitmap;
import android.net.Uri;

import java.io.OutputStream;

public class Constants {
    public static final int REQUEST_CODE_NINE = 9;
    public static final int REQUEST_CODE_FOR_PDF_SELECTION = 86;
    public static  String PRODUCT_QUANTITY;
    public static  int CART_TOTAL=0;


    Constants(){}

    //DataBase


    //Signature
    public static final String EMPTY_STRING="";
    public static final String ORDERS="ORDERS";

    //Send BroadCast
    public static final String BROADCAST_ITEM_DELETED="ITEM_DELETED";
    public static final String BROADCAST_CUSTOMER_DETAIL_FIELDS_FILLED="CUSTOMER_DETAIL_FIELDS_FILLED";

    //Send BroadCast action message
    public static final String CUSTOMER_DETAIL_FIELDS_FILLED="CUSTOMER_DETAIL_FIELDS_FILLED";


    //Get Date from calendar
    public static final String DATE_PICKER="DatePicker";


    //ViewPagePageLimit
    public static final int VIEW_PAGE_PAGE_LIMIT =3;
    public static final String DESCENDING=" DESC";
    public static final String EQUAL_SIGN="=";


    //Numbers
    public static final int ONE=1;
    public static final int TWO=2;
    public static final int THREE=3;
    public static final int ZERO=0;
    public static final int TWENTY=20;
    public static final int HUNDRED=100;

    //Customer Detail Fragment
    public static String SELECTED_FORM_TYPE="";
    public static String SELECTED_FORM_BRAND_NAME="";

    //StartStepView
    static final String STEP_COMPANY_DETAILS ="Company details";
    static final String STEP_PRODUCT_INSTRUCTIONS="Instructions";
    static final String STEP_CUSTOMER_SIGNATURE ="Signature";
    static final String STEP_CUSTOMER_CONFIRMATION ="Confirm";

    //Customer Detail Fragment
    public static String CUSTOMER_NAME="";
    public static String CUSTOMER_PHONE="";
    public static String CUSTOMER_EMAIL="";
    public static String CUSTOMER_FAX="";
    public static String CUSTOMER_ADDRESS="";
    public static String CUSTOMER_EXPECTED_DATE="";


    public static final String INPUT_ERROR_MESSAGE_USER_EMAIL ="Please insert email" ;
    public static final String INPUT_ERROR_MESSAGE_CUSTOMER_USER_ERROR_MESSAGE ="Wrong email" ;
    public static final String INPUT_ERROR_MESSAGE_USER_EMPTY_PASSWORD = "Please insert password";
    public static final String INPUT_ERROR_MESSAGE_USER_PASSWORD_LENGTH ="Password is too short" ;
    public static final String INPUT_ERROR_MESSAGE_USER_EMAIL_PATTERN ="[a-zA-Z0-9._-]+@[a-z]+\\\\.+[a-z]+" ;


    //Customer Detail Fragment
    public static String INPUT_ERROR_MESSAGE_FIRST_NAME ="Insert first name";
    public static String INPUT_ERROR_MESSAGE_LAST_NAME="Insert last name";
    public static String INPUT_ERROR_MESSAGE_EMAIL ="Insert email";
    public static String INPUT_ERROR_MESSAGE_LINK ="Insert submission link";
    public static String INPUT_ERROR_MESSAGE_CUSTOMER_ADDRESS="Please insert address";
    public static String INPUT_ERROR_MESSAGE_CUSTOMER_EXPECTED_DATE="Please choose date";

    //Signature
    public static final String INPUT_ERROR_CHECK_TERMS_AND_CONDITIONS_CHECK_BOX="Please confirm by checking this box";
    public static final String INPUT_ERROR_ADD_SIGNATURE="Please add signature";

    public static Bitmap CustomerSignature=null;
    public static OutputStream CustomerOutPutStream;
    public static Uri CustomerSignatureUri;

    public static int PRODUCT_TOTAL_AMOUNT =0;
    public static int PRODUCT_TOTAL_AMOUNT_DELETED =0;
    public static  String COUNTRY = "ZA";
    public static  String LANGUAGE = "en";














}
