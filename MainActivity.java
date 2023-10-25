package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView workingsTV;
    TextView resultsTV;
    String workings = "";
    String formula = "";
    String tempFormula = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextView();
    }
    private void initTextView() {
        workingsTV = (TextView) findViewbyId(R.id.workingsTextView);
        workingsTV = (TextView) findViewbyId(R.id.resultTextView);
    }
    private void setWorkings(String givenValue) {
        workings = workings + givenValue;
        workingsTV.setText(workings);
    }

    public void equaltoOnclick(view view) {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        checkForPowerof();

        try{
            result = (double) engine.eval(formula);
        }
        catch (ScriptException e) {
            Toast.makeText(context: this, text: "Invalid Input", Toast.LENGTH_SHORT).show();

        }
        if (result != null){
            resultsTV.setText(String.valueOf(result.doubleValue()));
        }
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
        for (int i = index - 1; i > 0; i--) {
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
    public void clearOnclick(view view) {
        workingsTV.setText("");
        workings = "";
        resultsTV.setText("");
        leftBracket = true;
    }

    boolean leftBracket = true;

    public void bracketOnclick(view view) {
        if(leftBracket == true) {
            setworkings("(");
            leftBracket = false;
        }
        else {
            setWorkings(")");
            leftBracket = true;
        }
    }
    public void addOnclick(View view){
        setWorkings("+");
    }

    public void subOnclick(View view){
        setWorkings("-");
    }

    public void PowerOfOnclick(View view){
        setWorkings("^");
    }

    public void mulOnclick(View view){
        setWorkings("*");
    }

    public void divOnclick(View view){
        setWorkings("/");
    }

    public void oneOnclick(View view){
        setWorkings("1");
    }

    public void twoOnclick(View view){
        setWorkings("2");
    }
    public void threeOnclick(View view){
        setWorkings("3");
    }

    public void fourOnclick(View view){
        setWorkings("4");
    }

    public void fiveOnclick(View view){
        setWorkings("5");
    }

    public void sixOnclick(View view){
        setWorkings("6");
    }

    public void sevenOnclick(View view){
        setWorkings("7");
    }

    public void eightOnclick(View view){
        setWorkings("8");
    }

    public void nineOnclick(View view){
        setWorkings("9");
    }

    public void zeroOnclick(View view){
        setWorkings("0");
    }


}
//NayanaTara
