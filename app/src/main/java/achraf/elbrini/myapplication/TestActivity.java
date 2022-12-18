package achraf.elbrini.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {
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
        setContentView(R.layout.activity_test);
        question=findViewById(R.id.question);
        ansA=findViewById(R.id.result);
        ansB=findViewById(R.id.ansB);
        ansC=findViewById(R.id.ansC);
        ansD=findViewById(R.id.ansD);
        submit=findViewById(R.id.submit);
        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
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
        if(clickedButton.getId()==R.id.submit){
            if(currentQuestionindex< AndroidQuestionner.question.length-1){
                if(selectedAnswer.equals(AndroidQuestionner.answer[currentQuestionindex])){
                    score++;
                }
                AndroidQuestionner.answerUser[currentQuestionindex]=selectedAnswer;
                currentQuestionindex++;
                System.out.println(currentQuestionindex);
                loadNewQuestion();
            }
            else{
                Intent inn= new Intent(TestActivity.this,ResutActivity.class);
                inn.putExtra("score",String.valueOf(score));
                startActivity(inn);
                System.out.println(currentQuestionindex+"hhhh");
            }

        }
        else{
                clickedButton.setBackgroundColor(R.color.purple);
                selectedAnswer=clickedButton.getText().toString();


        }


    }

    public void loadNewQuestion(){
        question.setText(AndroidQuestionner.question[currentQuestionindex]);
        ansA.setText(AndroidQuestionner.choices[currentQuestionindex][0]);
        ansB.setText(AndroidQuestionner.choices[currentQuestionindex][1]);
        ansC.setText(AndroidQuestionner.choices[currentQuestionindex][2]);
        ansD.setText(AndroidQuestionner.choices[currentQuestionindex][3]);
    }
}