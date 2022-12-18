package achraf.elbrini.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReviewActivity extends AppCompatActivity implements View.OnClickListener {

    TextView question;
    Button ansA,ansB,ansC,ansD;
    Button submit;

    int score=0;
    int totalQuestion= AndroidQuestionner.question.length;
    int currentQuestionindex=0;
    String selectedAnswer="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        question=findViewById(R.id.question);
        ansA=findViewById(R.id.result);
        ansB=findViewById(R.id.ansB);
        ansC=findViewById(R.id.ansC);
        ansD=findViewById(R.id.ansD);
        submit=findViewById(R.id.submit);

        submit.setOnClickListener(this);
        loadNewQuestion();
    }

    @Override
    public void onClick(View v) {
        Button clickedButton=(Button) v;
        ansA.setBackgroundColor(Color.GRAY);
        ansB.setBackgroundColor(Color.GRAY);
        ansC.setBackgroundColor(Color.GRAY);
        ansD.setBackgroundColor(Color.GRAY);

            if(currentQuestionindex< AndroidQuestionner.question.length-1){

                currentQuestionindex++;
                loadNewQuestion();
            }
            else{
                Intent inn= new Intent(ReviewActivity.this,ResutActivity.class);

                startActivity(inn);

            }





    }

    public void loadNewQuestion(){
        question.setText(AndroidQuestionner.question[currentQuestionindex]);
        ansA.setText(AndroidQuestionner.choices[currentQuestionindex][0]);

        ansB.setText(AndroidQuestionner.choices[currentQuestionindex][1]);
        ansC.setText(AndroidQuestionner.choices[currentQuestionindex][2]);
        ansD.setText(AndroidQuestionner.choices[currentQuestionindex][3]);
        if(ansA.getText().toString().equals(AndroidQuestionner.answerUser[currentQuestionindex])){
            ansA.setBackgroundColor(Color.RED);
        }
        if(ansB.getText().toString().equals(AndroidQuestionner.answerUser[currentQuestionindex])){
            ansB.setBackgroundColor(Color.RED);
        }
        if(ansC.getText().toString().equals(AndroidQuestionner.answerUser[currentQuestionindex])){
            ansC.setBackgroundColor(Color.RED);
        }
        if(ansD.getText().toString().equals(AndroidQuestionner.answerUser[currentQuestionindex])){
            ansD.setBackgroundColor(Color.RED);
        }
        if(ansA.getText().toString().equals(AndroidQuestionner.answer[currentQuestionindex])){
            ansA.setBackgroundColor(Color.GREEN);
        }
        if(ansB.getText().toString().equals(AndroidQuestionner.answer[currentQuestionindex])){
            ansB.setBackgroundColor(Color.GREEN);
        }
        if(ansC.getText().toString().equals(AndroidQuestionner.answer[currentQuestionindex])){
            ansC.setBackgroundColor(Color.GREEN);
        }
        if(ansD.getText().toString().equals(AndroidQuestionner.answer[currentQuestionindex])){
            ansD.setBackgroundColor(Color.GREEN);
        }
    }

}