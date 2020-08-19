package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class CalculatorActivity extends AppCompatActivity {
    public static final String BUNDLE_KEY_STACK_INPUTS = "stackInputs";
    public static final String BUNDLE_KEY_STACK_TEMPS = "stackTemps";
    public static final String BUNDLE_KEY_CURRENT_VALUE = "currentValue";
    public static final String BUNDLE_KEY_CURRENT_OPERATOR = "currentOperator";
    public static final String BUNDLE_KEY_WHOLE_RESULT_TEXT_VIEW = "wholeResultTextView";
    public static final String BUNDLE_KEY_WHOLE_INPUTS = "WholeInputs";
    public static final String BUNDLE_KEY_CURRENT_RESULT = "currentResult";
    private TextView mTextViewResult;
    private TextView mTextViewError;
    private Button mButtonZero;
    private Button mButtonOne;
    private Button mButtonTwo;
    private Button mButtonThree;
    private Button mButtonFour;
    private Button mButtonFive;
    private Button mButtonSix;
    private Button mButtonSeven;
    private Button mButtonEight;
    private Button mButtonNine;
    private Button mButtonDot;
    private Button mButtonPlus;
    private Button mButtonMinus;
    private Button mButtonMultiply;
    private Button mButtonDivision;
    private Button mButtonEquals;
    private Button mButtonDelete;
    private Stack<String> mInputsSrack = new Stack<>();
    private Stack<String> mTempStack = new Stack<>();
    private String mCurrentValue = "";
    private String mWholeInputs = "";
    private String mWholeResultTextView = "";
    private double mCurrentResult = 0;
    private String mCurrentOperator = "";
    private boolean mZeroExcp = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        findViews();
        if (savedInstanceState!=null)
        {
            mInputsSrack= (Stack<String>) savedInstanceState.getSerializable(BUNDLE_KEY_STACK_INPUTS);
            mTempStack= (Stack<String>) savedInstanceState.getSerializable(BUNDLE_KEY_STACK_TEMPS);
            mCurrentValue=savedInstanceState.getString(BUNDLE_KEY_CURRENT_VALUE);
            mCurrentOperator=savedInstanceState.getString(BUNDLE_KEY_CURRENT_OPERATOR);
            mCurrentResult=savedInstanceState.getDouble(BUNDLE_KEY_CURRENT_RESULT);
            mWholeResultTextView=savedInstanceState.getString(BUNDLE_KEY_WHOLE_RESULT_TEXT_VIEW);
            mWholeInputs=savedInstanceState.getString(BUNDLE_KEY_WHOLE_INPUTS);
            mTextViewResult.setText(mWholeResultTextView);
            mTextViewError.setText(mWholeInputs);
        }
        setListeners();

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(BUNDLE_KEY_STACK_INPUTS,mInputsSrack);
        outState.putSerializable(BUNDLE_KEY_STACK_TEMPS,mTempStack);
        outState.putString(BUNDLE_KEY_CURRENT_VALUE,mCurrentValue);
        outState.putString(BUNDLE_KEY_CURRENT_OPERATOR,mCurrentOperator);
        outState.putString(BUNDLE_KEY_WHOLE_RESULT_TEXT_VIEW,mWholeResultTextView);
        outState.putString(BUNDLE_KEY_WHOLE_INPUTS,mWholeInputs);
        outState.putDouble(BUNDLE_KEY_CURRENT_RESULT,mCurrentResult);
    }

    private void setListeners() {
        mButtonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mCurrentValue += "0";
                showInput("0");

            }
        });
        mButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mCurrentValue += "1";
                showInput("1");

            }
        });
        mButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mCurrentValue += "2";
                showInput("2");

            }
        });
        mButtonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mCurrentValue += "3";
                showInput("3");
            }
        });
        mButtonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mCurrentValue += "4";
                showInput("4");

            }
        });
        mButtonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mCurrentValue += "5";
                showInput("5");
            }
        });
        mButtonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mCurrentValue += "6";
                showInput("6");

            }
        });
        mButtonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mCurrentValue += "7";
                showInput("7");
            }
        });
        mButtonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mCurrentValue += "8";
                showInput("8");
            }
        });
        mButtonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mCurrentValue += "9";
                showInput("9");

            }
        });
        mButtonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurrentValue.isEmpty()) {
                    mCurrentValue = "0.";
                    showInput("0.");
                } else {
                    mCurrentValue += ".";
                    showInput(".");
                }
            }
        });
        mButtonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showInput("+");
                mCurrentOperator = "+";
                mInputsSrack.push(mCurrentValue);
                mInputsSrack.push(mCurrentOperator);

                mCurrentValue = "";
            }
        });
        mButtonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showInput("-");
                mCurrentOperator = "-";
                mInputsSrack.push(mCurrentValue);
                mInputsSrack.push(mCurrentOperator);

                mCurrentValue = "";
            }
        });
        mButtonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showInput("*");
                mCurrentOperator = "*";
                mInputsSrack.push(mCurrentValue);
                mInputsSrack.push(mCurrentOperator);
                mCurrentValue = "";

            }
        });
        mButtonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInput("/");
                mCurrentOperator = "/";
                mInputsSrack.push(mCurrentValue);
                mInputsSrack.push(mCurrentOperator);
                mCurrentValue = "";
            }
        });
        mButtonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mInputsSrack.push(mCurrentValue);

                calcResult();
                if (mZeroExcp) {
                    mTextViewError.setText(R.string.invalid_division);
                    mTextViewError.setTextColor(Color.RED);
                    resetAll();
                } else {
                    mTextViewError.setText(mWholeInputs);
                    mWholeResultTextView = String.valueOf(mCurrentResult);
                    mTextViewResult.setText(mWholeResultTextView);
                }
            }
        });
        mButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetAll();
            }
        });
    }

    private void resetAll() {
        mTextViewResult.setText("");
        mTextViewError.setText("");
        mCurrentValue = "";
        mCurrentResult = 0;
        mWholeResultTextView = "";
        mWholeInputs = "";
        mZeroExcp = false;
    }

    private void calcResult() {

        String temp;
        while (!mInputsSrack.empty()) {
            temp = mInputsSrack.pop();
            try {
                String mCurrentOperator = mInputsSrack.pop();
                switch (mCurrentOperator) {
                    case "*":
                        mCurrentResult = Double.parseDouble(mInputsSrack.pop()) * Double.parseDouble(temp);
                        mTempStack.push(String.valueOf(mCurrentResult));
                        break;
                    case "/":
                        try {
                            mCurrentResult = Double.parseDouble(mInputsSrack.pop()) / Double.parseDouble(temp);
                            mTempStack.push(String.valueOf(mCurrentResult));
                        } catch (Exception e) {
                            mZeroExcp = true;
                            mCurrentResult = 0;
                            mCurrentValue = "";
                            mCurrentOperator = "";
                        }
                        break;
                    default:
                        mTempStack.push(temp);
                        mTempStack.push(mCurrentOperator);
                }
            } catch (Exception e) {
                mTempStack.push(temp);
            }

        }
        while (!mTempStack.empty()) {
            temp = mTempStack.pop();
            try {
                switch (mTempStack.pop()) {
                    case "+":
                        mCurrentResult = Double.parseDouble(temp) + Double.parseDouble(mTempStack.pop());
                        mTempStack.push(String.valueOf(mCurrentResult));
                        break;
                    case "-":
                        mCurrentResult = Double.parseDouble(temp) - Double.parseDouble(mTempStack.pop());
                        mTempStack.push(String.valueOf(mCurrentResult));
                }
            } catch (Exception e) {

                mCurrentResult = Double.parseDouble(temp);
                mCurrentValue = String.valueOf(mCurrentResult);
            }

        }
    }

    private void showInput(String next) {
        if (next.matches("^[*]|[-]|[+]|[/]|[=]$")) {
            mWholeInputs += " " + next + " ";
            mWholeResultTextView += " " + next + " ";
        } else {
            mWholeInputs += next;
            mWholeResultTextView += next;
        }
        mTextViewResult.setText(mWholeResultTextView);

    }

    private void findViews() {
        mTextViewResult = findViewById(R.id.textViewResult);
        mTextViewError = findViewById(R.id.textViewError);
        mButtonZero = findViewById(R.id.buttonZero);
        mButtonOne = findViewById(R.id.buttonOne);
        mButtonTwo = findViewById(R.id.buttonTwo);
        mButtonThree = findViewById(R.id.buttonThree);
        mButtonFour = findViewById(R.id.buttonFour);
        mButtonFive = findViewById(R.id.buttonFive);
        mButtonSix = findViewById(R.id.buttonSix);
        mButtonSeven = findViewById(R.id.buttonSeven);
        mButtonEight = findViewById(R.id.buttonEight);
        mButtonNine = findViewById(R.id.buttonNine);
        mButtonMinus = findViewById(R.id.buttonMinus);
        mButtonPlus = findViewById(R.id.buttonPlus);
        mButtonMultiply = findViewById(R.id.buttonMultiply);
        mButtonDivision = findViewById(R.id.buttonDivision);
        mButtonEquals = findViewById(R.id.buttonEqual);
        mButtonDot = findViewById(R.id.buttonDot);
        mButtonDelete = findViewById(R.id.buttonDelete);
    }


}