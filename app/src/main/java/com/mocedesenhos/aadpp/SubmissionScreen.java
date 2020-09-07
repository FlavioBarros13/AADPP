package com.mocedesenhos.aadpp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.mocedesenhos.aadpp.QuickHelp.Constants;
import com.mocedesenhos.aadpp.QuickHelp.QuickHelp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubmissionScreen extends AppCompatActivity {

    @BindView(R.id.SubmissionScreenReturnBtn)
    ImageButton SubmissionScreenReturnBtn;

    @BindView(R.id.SubmissionScreenFirstName)
    EditText SubmissionScreenFirstName;


    @BindView(R.id.SubmissionScreenLastName)
    EditText SubmissionScreenLastName;


    @BindView(R.id.SubmissionScreenLastEmail)
    EditText SubmissionScreenLastEmail;


    @BindView(R.id.SubmissionScreenLastLink)
    EditText SubmissionScreenLastLink;

    @BindView(R.id.SubmissionScreenSubmitBtn)
    Button SubmissionScreenSubmitBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission_screen);
        ButterKnife.bind(this); // Bind Butter knife
        QuickHelp.EnterActivityWithSlideAnimation(this);// Start Enter Activity Animation

        SubmissionScreenReturnBtn.setOnClickListener(v->finish());

        SubmissionScreenSubmitBtn.setOnClickListener(v->CheckInputs());



    }

    private void CheckInputs()
    {

            String FirstName= SubmissionScreenFirstName.getText().toString().trim();
            String LastName= SubmissionScreenLastName.getText().toString().trim();
            String Email= SubmissionScreenLastEmail.getText().toString().trim();
            String Link= SubmissionScreenLastLink.getText().toString().trim();


            if (TextUtils.isEmpty(FirstName)) {

                SubmissionScreenFirstName.setError(Constants.INPUT_ERROR_MESSAGE_FIRST_NAME);

            } else if (TextUtils.isEmpty(LastName)) {

                SubmissionScreenLastName.setError(Constants.INPUT_ERROR_MESSAGE_LAST_NAME);

            } else if (TextUtils.isEmpty(Email) && Email.matches(QuickHelp.EMAIL_PATTERN)) {

                SubmissionScreenLastEmail.setError(Constants.INPUT_ERROR_MESSAGE_EMAIL);

            } else if (TextUtils.isEmpty(Link))
            {

                SubmissionScreenLastLink.setError(Constants.INPUT_ERROR_MESSAGE_LINK);
            }


            else {

                startDialog();


            }





    }

    private void startDialog()
    {
        AlertDialog.Builder dialog =new AlertDialog.Builder(this);

        View dialogView= LayoutInflater.from(this).inflate(R.layout.custom_confirm_submission_dialog,null);
        dialog.setCancelable(false);
        dialog.setView(dialogView);


        Button Custom_confirm_submission_Cancel_btn=dialogView.findViewById(R.id.Custom_confirm_submission_Cancel_btn);
        Button Custom_confirm_submission_Confirm_btn=dialogView.findViewById(R.id.Custom_confirm_submission_Confirm_btn);

        AlertDialog AlertDialog = dialog.create();
        AlertDialog.show();


        Custom_confirm_submission_Cancel_btn.setOnClickListener(v->AlertDialog.dismiss());


    }

    @Override
    public void finish() {
        super.finish();
        QuickHelp.ExitActivityWithSlideAnimation(this);
    }
}