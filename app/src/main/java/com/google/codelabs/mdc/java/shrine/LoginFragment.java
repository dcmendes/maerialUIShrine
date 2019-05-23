package com.google.codelabs.mdc.java.shrine;

import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/**
 * Fragment representing the login screen for Shrine.
 */
public class LoginFragment extends Fragment {

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.shr_login_fragment, container, false);
        final TextInputLayout passwordTextInput = view.findViewById(R.id.password_text_input);
        final TextInputEditText passwordEditText = view.findViewById(R.id.pasword_edit_text);
        MaterialButton nextButton = view.findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPasswordValid(passwordEditText.getText())){
                    passwordTextInput.setError(getString(R.string.shr_error_password));
                } else{
                    passwordTextInput.setError(null);
                    ((NavigationHost) getActivity()).navigateTo(new ProductGridFragment(), false);
                }
            }
        });

        passwordEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (isPasswordValid(passwordEditText.getText())){
                    passwordTextInput.setError(null);
                }
                return false;
            }
        });
        // Snippet from "Navigate to the next Fragment" section goes here.

        return view;
    }

    // "isPasswordValid" from "Navigate to the next Fragment" section method goes here
    private boolean isPasswordValid(Editable text){
        return text != null && text.length() >=8;
    }

}
