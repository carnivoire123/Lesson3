package ru.gb.lesson3;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CounterActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView counterText;
    private CheckBox counterCheck;
    public static final String COUNTER="COUNTER";

    User user = new User();

    //private int counter = 0;
    private Counter counter = new Counter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        counterText = findViewById(R.id.counter);
        counterCheck = findViewById(R.id.check_me);

        // при запуске активити       savedInstanceState == null
        if(savedInstanceState != null)
        {
            // counter = savedInstanceState.getInt(COUNTER, 0);
            counter = savedInstanceState.getParcelable(COUNTER);
        }


        counterCheck.setOnClickListener(this);
        // counterText.setText("" + counter);
        counterText.setText("" + counter.getCounter());

    }

    @Override
    public void onClick(View view) {
//        counter++;
//        counterText.setText("" + counter);
        counter.increment();
        counterText.setText("" + counter.getCounter());
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // outState.putInt(COUNTER, counter);
        outState.putParcelable(COUNTER, counter);
        outState.putSerializable(USER, user);
    }

    public static final String USER = "USER";
}
