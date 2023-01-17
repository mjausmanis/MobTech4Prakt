package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String input1 = "";
    String input2 = "";
    String operation;
    boolean input1Done = false;
    double MemoryValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        Button buttonDot = (Button) findViewById(R.id.buttonDot);
        Button buttonMS = (Button) findViewById(R.id.buttonMS);
        Button buttonMR = (Button) findViewById(R.id.buttonMR);
        Button buttonMC = (Button) findViewById(R.id.buttonMC);
        Button buttonSum = (Button) findViewById(R.id.buttonSum);
        Button buttonSub = (Button) findViewById(R.id.buttonSub);
        Button buttonMult = (Button) findViewById(R.id.buttonMult);
        Button buttonDiv = (Button) findViewById(R.id.buttonDiv);
        Button buttonResult = (Button) findViewById(R.id.buttonResult);
        Button buttonDel = (Button) findViewById(R.id.buttonDel);
        Button buttonClear = (Button) findViewById(R.id.buttonClear);

        TextView screen1 = (TextView) findViewById(R.id.screen1);
        TextView screen2 = (TextView) findViewById(R.id.screen2);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addInput("0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addInput("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addInput("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addInput("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addInput("4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addInput("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addInput("6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addInput("7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addInput("8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addInput("9");
            }
        });
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addInput(".");
            }
        });


        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input1Done) {
                    input1Done = true;
                } else if (input2.length() != 0) {
                    doMath();
                }
                operation = "+";
                updateText();
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input1Done) {
                    input1Done = true;
                } else if (input2.length() != 0) {
                    doMath();
                }
                operation = "-";
                updateText();
            }
        });
        buttonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input1Done) {
                    input1Done = true;
                } else if (input2.length() != 0) {
                    doMath();
                }
                operation = "*";
                updateText();
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input1Done) {
                    input1Done = true;
                } else if (input2.length() != 0) {
                    doMath();
                }
                operation = "/";
                updateText();
            }
        });

        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input1.length() != 0) {
                    if (!input1Done ){
                        input1 = input1.substring(0, input1.length()-1);
                    } else {
                        if (input2.length() != 0) {
                            input2 = input2.substring(0, input2.length()-1);
                        } else {
                            input1Done = false;
                            operation = "";
                        }
                    }
                }
                updateText();
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1Done = false;
                input1 = "";
                input2 = "";
                operation = "";
                screen2.setText("");
                updateText();
            }
        });

        buttonMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input1.length() != 0 && !input1Done) {
                    MemoryValue = Double.parseDouble(input1);
                } else {
                    Toast.makeText(MainActivity.this, "Can only save the first number if it exists.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MemoryValue != 0) {
                    if (!input1Done) {
                        input1 = MemoryValue+"";
                        updateText();
                    } else {
                        input2 = MemoryValue+"";
                        updateText();
                    }
                }
            }
        });
        buttonMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MemoryValue = 0;
            }
        });


        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input2.length() != 0) {
                    doMath();
                } else {
                    Toast.makeText(MainActivity.this, "You need 2 numbers to make finish the operation.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void addInput(String val) {

        if (!input1Done) {
            input1 += val;
        } else {
            input2 += val;
        }
        updateText();
    }
    private void updateText() {
        TextView screen1 = (TextView) findViewById(R.id.screen1);
        if (!input1Done) {
            screen1.setText(input1);
        } else {
            screen1.setText(input1 + operation + input2);
        }
        screen1.setGravity(Gravity.BOTTOM | Gravity.RIGHT);
    }

    private double doMath() {
        TextView screen2 = (TextView) findViewById(R.id.screen2);
        double first = Double.parseDouble(input1);
        double second = Double.parseDouble(input2);
        double result = 0.0;
        switch (operation) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                result = first / second;
                break;
        }
        input1 = result+"";
        input2 = "";
        screen2.setText(first + operation + second);
        screen2.setGravity(Gravity.TOP|Gravity.RIGHT);
        operation = "";
        updateText();
        return result;
    }
}