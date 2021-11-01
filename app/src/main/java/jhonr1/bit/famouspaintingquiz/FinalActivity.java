package jhonr1.bit.famouspaintingquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Gets result score from question activity class
 */
public class FinalActivity extends AppCompatActivity implements View.OnClickListener{

    int score;
    TextView txtViewScore;
    Button playAgain;

    /**
     * Passing result score to the final activity class
     * @param savedInstanceState Passing result score to the final activity class
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Intent finalResult = getIntent();
        score = finalResult.getIntExtra("results", 0);
        txtViewScore = findViewById(R.id.txtViewScore);
        txtViewScore.setText("Your score is "+ score + "/10");
        playAgain = findViewById(R.id.btnPlayAgain);
        playAgain.setOnClickListener(this);
    }

    /**
     *
     * @param v Passing Button "Play Again" click event to the view.
     */
    @Override
    public void onClick(View v) {
        Intent changeActivity = new Intent(FinalActivity.this, MainActivity.class);
        startActivity(changeActivity);

    }
}
