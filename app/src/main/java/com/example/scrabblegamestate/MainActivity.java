package com.example.scrabblegamestate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button runTest = (Button)findViewById(R.id.button);
        EditText info = (EditText)findViewById(R.id.editTextTextMultiLine);

        runTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.getText().clear();

                ScrabbleState firstInstance = new ScrabbleState();
                ScrabbleState secondInstance = new ScrabbleState(firstInstance);
                firstInstance.playWord(firstInstance);
                info.append("The player is writing down the word frog\n");

                firstInstance.isLegal(firstInstance);
                info.append("The move the player made was legal\n");

                firstInstance.exchange(firstInstance);
                info.append("The player did a letter exchange\n");

                firstInstance.pass(firstInstance);
                info.append("The player passed on their turn\n");

                ScrabbleState thirdInstance = new ScrabbleState();
                ScrabbleState fourthInstance = new ScrabbleState(thirdInstance);

                info.append(secondInstance.toString());
                info.append(fourthInstance.toString());
            }
        });
    }
}