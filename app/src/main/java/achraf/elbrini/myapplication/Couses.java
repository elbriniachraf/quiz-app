package achraf.elbrini.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Couses extends AppCompatActivity {
    TextView tv;
    CardView c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_couses);
        tv=findViewById(R.id.title);
        c=findViewById(R.id.javaa);
        Intent intent=getIntent();
        String nom=intent.getStringExtra("myname");
        tv.setText("hello "+nom);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Couses.this,TestActivity.class);
                startActivity(in);
            }
        });



    }
}