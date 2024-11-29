package www.g43.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("test","create");

        edtName=findViewById(R.id.edtName);
        btnClick=findViewById(R.id.btnClick);

//        //cách 1
//        btnClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SayHello(view);
//            }
//        });

         //cách 2
        btnClick.setOnClickListener(this::SayHello);

         //cách 3. goi trong res.button cua no

    }

    public void SayHello(View v){
        String name= edtName.getText().toString().trim();
        Toast.makeText(MainActivity.this, "Hello "+ name,Toast.LENGTH_SHORT).show();
    }




    @Override
    protected void onPostResume(){
        super.onPostResume();
        Log.e("test","Resume");
    }
    @Override
    protected  void onStart(){
        super.onStart();
        Log.e("test","Start");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.e("test","Stop");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.e("test","Pause");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.e("test","Destroy");
    }
}
/*
*   Intent = action+data.
* Truyen dl
*   Trực tiếp: AD cho 1 d.tuong
Intent intent = new Intent();
intent.putExtra(“SoNguyenX”, x);
    Thông qua Bundle:AD cho 1 nhom d.tuong
Intent intent = new Intent();
Bundle bundle = new Bundle();
bundle.putInt(“SoNguyenX”, x);
intent.putExtras(bundle);
*DEMOB4.
*--------------------------------------
* 2 dl khac nhau chia se dl cho nhau can 1 Content Providers trung gian.
* ben nao can lay dl thi goi CP cua cai do.
*demo o muc do he thong.Telephony
* uri(url thuong b.dau bang http ,urn chi la duong dan ko phai link)
* nhung thiet bi co duong dan content tuc la no dang lay dl trong thiet bi cua mk
* content://authority/path
* VD:
* A goi de truy xuat dl
* B noi luu dl
* C,phan loai dl
* D ploai chi tiet hon
* */

