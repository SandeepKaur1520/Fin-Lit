package com.android.finlit.auth;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.finlit.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpBottomSheet extends BottomSheetDialogFragment {
    private static final String TAG = "SignUpBottomSheet";
    private FirebaseAuth mAuth;
// ...

    private BottomSheetBehavior bottomSheetBehavior;
    TextInputLayout til_fullname, til_gender, til_email, til_password, til_confirmPassword;
    Button btn_signup ;


    public static SignUpBottomSheet newInstance() {
        return new SignUpBottomSheet();
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);

        View view = View.inflate(getContext(), R.layout.bottom_sheet_signup, null);
        dialog.setContentView(view);

        til_fullname = dialog.findViewById(R.id.til_fullName);
        til_gender= dialog.findViewById(R.id.til_gender);
        til_email = dialog.findViewById(R.id.til_email);
        til_password = dialog.findViewById(R.id.til_password);
        til_confirmPassword = dialog.findViewById(R.id.til_confirm_password);

        btn_signup = dialog.findViewById(R.id.btn_signup);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isFullName = isFullName();
                boolean isEmail = isEmail();
                boolean isGender  = isGender();
                boolean isConfirmPassword = isConfirmPassword();
                boolean isPassword = isPassword();

                if (isFullName && isEmail && isGender && isConfirmPassword && isPassword){

                }


            }
        });


        bottomSheetBehavior = BottomSheetBehavior.from((View) view.getParent());
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        return dialog;
    }
    @Override
    public void onStart() {
        super.onStart();
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    boolean isFullName(){
        String fullName = til_fullname.getEditText().getText().toString() ;


        return false;
    }
    boolean isGender(){
        String gender = til_gender.getEditText().getText().toString();

        return false;
    }
    boolean isEmail(){
        String email = til_email.getEditText().getText().toString() ;

        return false;
    }
    boolean isPassword(){
        String password = til_password.getEditText().getText().toString() ;

        return false;
    }
    boolean isConfirmPassword(){
        String cnfPass = til_confirmPassword.getEditText().getText().toString() ;
        String password = til_password.getEditText().getText().toString() ;

        return false;
    }
}
