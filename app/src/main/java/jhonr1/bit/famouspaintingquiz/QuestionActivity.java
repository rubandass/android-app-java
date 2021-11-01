package jhonr1.bit.famouspaintingquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.TooltipCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Loads the questions page
 */
public class QuestionActivity extends AppCompatActivity {

    ImageView imageQuestion;
    RadioGroup optionGroup;
    RadioButton rdbtnOption1;
    RadioButton rdbtnOption2;
    RadioButton rdbtnOption3;
    RadioButton rdbtnOption4;
    Button btnAnswer, btnNext;
    //TextView txtViewInfo;
    int score;
    int index;
    private ArrayList<Questions> questionsList = new ArrayList<Questions>();

    /**
     * Sets the question image and optional answers
     *
     * @param savedInstanceState Sets the question image and optional answers
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        setupQuestions();
        score = 0;
        index = 0;
        imageQuestion = findViewById(R.id.imageQuestion);
        rdbtnOption1 = findViewById(R.id.rdbtnOption1);
        rdbtnOption2 = findViewById(R.id.rdbtnOption2);
        rdbtnOption3 = findViewById(R.id.rdbtnOption3);
        rdbtnOption4 = findViewById(R.id.rdbtnOption4);
        optionGroup = findViewById(R.id.optionsGroup);
        //txtViewInfo = findViewById(R.id.txtViewInfo);
        loadQuestion();

        btnAnswer = findViewById(R.id.btnAnswer);
        btnNext = findViewById(R.id.btnNext);


        btnAnswer.setOnClickListener(new btnAnswerclickhandler());
        btnNext.setOnClickListener(new btnNextclickhandler());


    }

    /**
     * Sets the question image and optional answers
     */
    private void loadQuestion() {
        imageQuestion.setImageResource(questionsList.get(index).getPicture());
        rdbtnOption1.setText(questionsList.get(index).getOption1());
        rdbtnOption2.setText(questionsList.get(index).getOption2());
        rdbtnOption3.setText(questionsList.get(index).getOption3());
        rdbtnOption4.setText(questionsList.get(index).getOption4());
        //TooltipCompat.setTooltipText(txtViewInfo, "First Author");
    }

    /**
     * Creating all the questions for the Question object as ArrayList
     */
    private void setupQuestions() {
        questionsList.add(new Questions(R.drawable.adam_sistine, "Andy Warhol", "Michelangelo", "Vincent Van Gogh", "Rene Magritte", "Michelangelo", "Michelangelo chose scenes from the Old Testament. This is the moment of God creating Adam"));
        questionsList.add(new Questions(R.drawable.earring_jan, "Michelangelo", "Pablo Picasso", "Leonardo da Vinci", "Jan Vermeer", "Jan Vermeer", "Jan Vermeer painted this iconic portraits and is a beautiful example of the Baroque style and the use of light."));
        questionsList.add(new Questions(R.drawable.field_claude, "Claude Monet", "Andy Warhol", "Rene Magritte", "Vincent Van Gogh", "Claude Monet", "This beautiful pastoral scene encapsulates the essence of how the impressionists captured the beauty and simplicity of nature."));
        questionsList.add(new Questions(R.drawable.galette_jean, "Picasso", "Leonardo da Vinci", "Jean Renoir", "Vincent Van Gogh", "Jean Renoir", " Auguste Renoir captures the buzz and excitement of this outdoor scene in Paris."));
        questionsList.add(new Questions(R.drawable.lastsupper_leonardo, "Michelangelo", "Leonardo da Vinci", "Jackson Pollock", "Henri Matisse", "Leonardo da Vinci", "Leonardo da Vinci paints one of the most famous scenes in the Bible – The Last Supper"));
        questionsList.add(new Questions(R.drawable.monalisa_leonardo, "Leonardo da Vinci", "Claude Monet", "Edvard Munch", "Henri Matisse", "Leonardo da Vinci", "Leonardo da Vinci worked on his masterpiece over a period of 20 years. The enigmatic smile has captured the imagination of the world. "));
        questionsList.add(new Questions(R.drawable.peace_picasso, "Henri Matisse", "Claude Monet", "Picasso", "Leonardo da Vinci", "Picasso", "The simplicity of this symbol of peace by Pablo Picasso remains one of the most powerful pieces of art."));
        questionsList.add(new Questions(R.drawable.pipe_rene, "Vincent Van Gogh", "Henri Matisse", "Andy Warhol", "Rene Magritte", "Rene Magritte", "A classic example of modern surrealist art. This is not a pipe, but the picture is of a pipe."));
        questionsList.add(new Questions(R.drawable.scream_edward, "Picasso", "Claude Monet", "Edvard Munch", "Michelangelo", "Edvard Munch", "A painting that symbolises the anguish and pain of modern life."));
        questionsList.add(new Questions(R.drawable.sunflowers_vincent, "Vincent Van Gogh", "Edward Hopper", "Frida Kahlo", "Yayoi Kusama", "Vincent Van Gogh", "The genius of Vincent Van Gogh is captured in this painting of 12 sunflowers. It has become one of the most recognisable of his works."));
    }

    /**
     * Sets the next question
     */
    public class btnNextclickhandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            optionGroup.clearCheck();
            clearColor();
            index += 1;
            if (index < 10) {
                loadQuestion();
                btnNext.setVisibility(View.INVISIBLE);
                btnAnswer.setVisibility(View.VISIBLE);

            } else {
                Intent changeActivity = new Intent(QuestionActivity.this, FinalActivity.class);
                changeActivity.putExtra("results", score);
                startActivity(changeActivity);
            }
        }
    }

    /**
     * Clear the background color for the optional answers
     */
    private void clearColor() {
        rdbtnOption1.setBackgroundColor(Color.WHITE);
        rdbtnOption2.setBackgroundColor(Color.WHITE);
        rdbtnOption3.setBackgroundColor(Color.WHITE);
        rdbtnOption4.setBackgroundColor(Color.WHITE);
    }

    /**
     * Validates the selected answer with correct answer
     */
    public class btnAnswerclickhandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (optionGroup.getCheckedRadioButtonId() == -1) {
                // no radio buttons are checked
                Toast.makeText(getApplicationContext(), "Select any one option", Toast.LENGTH_SHORT).show();
            } else {
                // one of the radio buttons is checked
                int selected = optionGroup.getCheckedRadioButtonId();
                RadioButton chosen = findViewById(selected);

                if (chosen.getText().equals(questionsList.get(index).getCorrectAns())) {
                    score++;
                    chosen.setBackgroundColor(Color.rgb(34, 255, 34));

                } else {
                    chosen.setBackgroundColor(Color.rgb(255, 43, 43));
                    correctAnswerColor();
                }
                btnNext.setVisibility(View.VISIBLE);
                btnAnswer.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), questionsList.get(index).getInfo() , Toast.LENGTH_SHORT).show();
            }

        }

        /**
         * Sets the red color for wrong answer and green color for the right answer
         */
        private void correctAnswerColor() {
            String value1 = rdbtnOption1.getText().toString();
            String value2 = rdbtnOption2.getText().toString();
            String value3 = rdbtnOption3.getText().toString();
            String value4 = rdbtnOption4.getText().toString();
            if (value1.equals(questionsList.get(index).getCorrectAns())) {
                rdbtnOption1.setBackgroundColor(Color.rgb(34, 255, 34));
            }
            if (value2.equals(questionsList.get(index).getCorrectAns())) {
                rdbtnOption2.setBackgroundColor(Color.rgb(34, 255, 34));
            }
            if (value3.equals(questionsList.get(index).getCorrectAns())) {
                rdbtnOption3.setBackgroundColor(Color.rgb(34, 255, 34));
            }
            if (value4.equals(questionsList.get(index).getCorrectAns())) {
                rdbtnOption4.setBackgroundColor(Color.rgb(34, 255, 34));
            }
        }
    }


}
