package www.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtSave,edtRead;
    Button btnSave,btnRead;

    String saveData;
    String readingData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtRead=findViewById(R.id.edtRead);
        edtSave=findViewById(R.id.edtSave);
        btnRead=findViewById(R.id.btnRead);
        btnSave=findViewById(R.id.btnSave);

        btnSave.setOnClickListener(this);
        btnRead.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSave:
                saveData =edtSave.getText().toString();
                writeInternalMemory(saveData);
                break;
            case R.id.btnRead:
                readingData = readData();
                edtRead.setText(readingData);
                break;
        }
    }
//thay dl code ghi doc file doi voi khi bo nho ngoai
    private String readData() {
        String data ="";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput("testData.txt");
            byte[] buffer = new byte[20];//mang dong max0=20
            int count = fileInputStream.read(buffer);
            data = new String(buffer);
            Toast.makeText(this, "Read Successfully", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  data;
    }

    private void writeInternalMemory(String saveData) {
        try {
            FileOutputStream fileOutputStream = openFileOutput("testData.txt", Context.MODE_APPEND);
            fileOutputStream.write(saveData.getBytes());
            fileOutputStream.close();
            Toast.makeText(this, "Save successfully", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}










