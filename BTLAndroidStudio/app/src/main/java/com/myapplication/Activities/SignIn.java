package com.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.myapplication.databinding.ActivitySignInBinding;
import com.myapplication.utilities.Constants;
import com.myapplication.utilities.PreferenceManager;

import java.util.HashMap;

public class SignIn extends AppCompatActivity {

    private ActivitySignInBinding binding; //view binding thay the cho findViewById()
    private PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sign_in);

        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferenceManager = new PreferenceManager(this);

        setListeners();
    }

    private void setListeners(){
        binding.tvSignUp.setOnClickListener(view ->
                startActivity(new Intent(getApplicationContext(),SignUp.class)));
        binding.btnSignIn.setOnClickListener(view -> {
            if(isValidSignInDetails()){
                signIn();
            }
        });
        //binding.btnSignIn.setOnClickListener(view -> addDataToFirestore());//de test thoi
    }
/*
    private void addDataToFirestore(){
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        HashMap<String, Object> data = new HashMap<>();
        data.put("first_name", "abcdefgh");
        data.put("last_name", "XYZT");
        database.collection("users")
                .add(data)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(exception -> {
                    Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }*/

    private void signIn(){
        loading(true);
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        database.collection(Constants.KEY_CONLLECTION_USERS)
                .whereEqualTo(Constants.KEY_EMAIL,binding.edtUserName.getText().toString())
                .whereEqualTo(Constants.KEY_PASSWORD,binding.edtPassword.getText().toString())
                .get()
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()&&task.getResult()!=null
                    && task.getResult().getDocuments().size()>0){
                        DocumentSnapshot documentSnapshot = task.getResult().getDocuments().get(0);
                        preferenceManager.putBoolean(Constants.KEY_IS_SIGNED_IN,true);
                        preferenceManager.putString(Constants.KEY_USER_ID,documentSnapshot.getId());
                        preferenceManager.putString(Constants.KEY_NAME,documentSnapshot.getString((Constants.KEY_NAME)));
                        Intent intent = new Intent(this,MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }else{
                        loading(false);
                        showToast("Unable to sign in");
                    }
                });
    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void loading(Boolean isLoading){
        if(isLoading){
            binding.btnSignIn.setVisibility(View.INVISIBLE);
            binding.progressBar.setVisibility(View.VISIBLE);
        }else {
            binding.progressBar.setVisibility(View.INVISIBLE);
            binding.btnSignIn.setVisibility(View.VISIBLE);
        }
    }

    private Boolean isValidSignInDetails(){
        if(binding.edtUserName.getText().toString().trim().isEmpty()){
            showToast("Enter user name");
            return  false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(binding.edtUserName.getText().toString().toString()).matches()){
            showToast("Enter user name");
            return false;
        }else if(binding.edtPassword.getText().toString().isEmpty()){
            showToast("Enter password");
            return false;
        }else{
            return true;
        }
    }
}
