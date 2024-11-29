package com.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Magnifier;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listPhoneBook;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> phoneBook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickRequestPermission();
        //showListBook();
    }
    //phuong thuc nay ap dung ddc cho nhieu phuong thuc khac ben manifest
    private void clickRequestPermission() {
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            showListBook();
            return;
        }
        if(checkSelfPermission(Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED){
            showListBook();
        }else{
            String [] permission = {Manifest.permission.READ_CONTACTS};
            requestPermissions(permission,123);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode== 123){
            if(grantResults.length<0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                showListBook();
                Toast.makeText(this, "thanh cong", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"ko thanh cong",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showListBook() {
        listPhoneBook =findViewById(R.id.phoneBook);
        phoneBook = new ArrayList<>();

        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Contactables.CONTENT_URI
                ,null,null,null,null);
        while (cursor.moveToNext()){
            //lay ten ng trong danh ba
            @SuppressLint("Range") String name = cursor.getString(cursor.
                    getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            //lay sdt trong danh ba t.ung
            @SuppressLint("Range") String phoneNumber = cursor.getString(cursor.
                    getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            phoneBook.add(phoneNumber+" "+name);
            arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,phoneBook);
            listPhoneBook.setAdapter(arrayAdapter);
        }
        listPhoneBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String Number = listPhoneBook.getItemAtPosition(i).toString();
                //cai tren dang lay ca chu lan so.
                //dung ham split de tach so ra.

                Intent intent =new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+Number));
                startActivity(intent);
            }
        });
    }
}



























