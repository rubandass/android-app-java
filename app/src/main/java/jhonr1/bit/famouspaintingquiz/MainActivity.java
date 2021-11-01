package jhonr1.bit.famouspaintingquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Loads the welcome page
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txtViewWelcome;

    /**
     * Creates the welcome page
     * @param savedInstanceState Default instance gets loaded
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtViewWelcome = findViewById(R.id.txtViewWelcome);
        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);
    }

    /**
     * Passing Start button as a click event view to load next view.
     * @param v Passing Start button as a click event view to load next view.
     */
    @Override
    public void onClick(View v) {
        Intent changeActivity = new Intent(MainActivity.this, QuestionActivity.class);
        startActivity(changeActivity);
    }
}
