package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void CheckForPowerOf() {
        ArrayList<Integer> indexOfPowers = new ArrayList<>();
        for (int i = 0; i < workings.length(); i++) {
            if (workings.charAt(i) == '^') {
                indexOfPowers.add(i);
            }
        }
        formula = workings;
        tempFormula = workings;
        for (integer index : indexOfPowers) {
            changeFormula(index);
        }
        formula = tempFormula;
    }

    private void changeFormula(int index) {
        String numberLeft = "";
        String numberRight = "";

        for (int i = index + 1; i < workings.length(); i++) {
            if (isNumeric(workings.charAt(i)) == true) {
                numberRight = numberRight + workings.charAt(i);
            } else
                break;
        }
        for (int i = index + 1; i > 0; i++) {
            if (isNumeric(workings.charAt(i)) == true) {
                numberLeft = workings.charAt(i) + numberLeft;
            } else
                break;
        }
        String original = numberLeft + "^" + numberRight;
        String changed = "Math.pow(" + numberLeft + "," + numberRight + ")";
        tempFormula = tempFormula.replace(original, changed);
    }
    private_boolean isNumeric(char c) {
        if ((c <= '9' && c >= '0') || c == '.') {
            return true;
        }
        return false;
    }
}

//NayanaTara
