package achraf.elbrini.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResutActivity extends AppCompatActivity {
    TextView result;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resut);
        result=findViewById(R.id.result);
        Intent in=getIntent();
        String score=in.getStringExtra("score");
        result.setText(score+"\n  ");
        bt=findViewById(R.id.review);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResutActivity.this,ReviewActivity.class));
            }
        });


    }
}