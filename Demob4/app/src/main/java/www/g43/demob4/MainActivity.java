package www.g43.demob4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Uri uri;
    ImageView imgAvata;
    Button btnPlay;
    EditText edtName;

    // gui dl di
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        btnPlay= findViewById(R.id.btnPlay);
        imgAvata = findViewById(R.id.imgAvata);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= edtName.getText().toString().trim();
                String strUri = uri.toString();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                //gui dl truc tiep thong qua intent
//                intent.putExtra("name",name);
//                startActivity(intent);

                //gui gin tiep thong qua bundle
                Bundle bundle =new Bundle();
                bundle.putString("name",name);
                bundle.putString("img",strUri);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


        imgAvata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,123);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123 && resultCode == RESULT_OK && data != null) {
            uri = data.getData();
            imgAvata.setImageURI(uri);
        }
    }
}