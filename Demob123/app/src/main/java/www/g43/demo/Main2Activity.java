package www.g43.demo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    Button btnMove;
    ImageView imgIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnMove=findViewById(R.id.btnMove);
 //       imgIcon=findViewById(R.id.addImage);

//        //goi gian tiep activity (Lay thu vien anh). Co ma day la cai cu. nen nos chua chay duoc.
//        imgIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent gallery = new Intent(Intent.ACTION_GET_CONTENT);
//                gallery.setType("image/*");
//                startActivityForResult(gallery,123);//1 so bat ki de nhan ma thoi
//            }
//        });

        //goi truc tiep Activity. chay duoc nha. Ma la nut chuyen tu Main2Activity sang MainActivity.
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }

    //tren goi activity roi. va day la ham lay ket qua. nhung ma nos chua chay. Tai la do muc dich la lay anh. ma cai tren chua chay dc ^^
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
//        super.onActivityResult(requestCode,resultCode,data);
//        if(requestCode==123 && resultCode==RESULT_OK && data!=null){
//            Uri uri = data.getData();
//            imgIcon.setImageURI(uri);
//        }
//    }
}