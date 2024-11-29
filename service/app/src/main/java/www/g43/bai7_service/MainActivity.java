package www.g43.bai7_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggle=findViewById(R.id.toggle);
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doService(view);
            }

            private void doService(View view) {
                boolean checked = ((ToggleButton)view).isChecked();
                if(checked){
                    clickStartService();
                }else{
                    clickStopService();
                }
            }

            private void clickStartService() {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startService(intent);
            }

            private void clickStopService() {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                stopService(intent);
            }
        });
    }
}