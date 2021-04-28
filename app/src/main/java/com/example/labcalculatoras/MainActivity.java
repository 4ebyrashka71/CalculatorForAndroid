package com.example.labcalculatoras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20;
    TextView tvLog, tvRes;
    String action;
    int str_int = 0;
    char op;
    boolean flag = false;
    boolean flagInNum1 = false;
    boolean memoryFlag = false;
    boolean clickedEqual = false;
    Double memory = 0.0;
    Double num = 0.0, num1 = 0.0, num2=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.buttonC);
        btn2 = findViewById(R.id.buttonMultiply);
        btn3 = findViewById(R.id.buttonDivider);
        btn4 = findViewById(R.id.buttonFact);
        btn5 = findViewById(R.id.button1);
        btn6 = findViewById(R.id.button2);
        btn7 = findViewById(R.id.button3);
        btn8 = findViewById(R.id.buttonMR);
        btn9 = findViewById(R.id.button4);
        btn10 = findViewById(R.id.button5);
        btn11 = findViewById(R.id.button6);
        btn12 = findViewById(R.id.buttonPlus);
        btn13 = findViewById(R.id.button7);
        btn14 = findViewById(R.id.button8);
        btn15 = findViewById(R.id.button9);
        btn16 = findViewById(R.id.buttonMinus);
        btn17 = findViewById(R.id.buttonZero);
        btn18 = findViewById(R.id.buttonEqual);
        btn19 = findViewById(R.id.buttonPoint);
        btn20 = findViewById(R.id.buttonTo2);

        tvLog = findViewById(R.id.log);
        tvRes = findViewById(R.id.res);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
        btn15.setOnClickListener(this);
        btn16.setOnClickListener(this);
        btn17.setOnClickListener(this);
        btn18.setOnClickListener(this);
        btn19.setOnClickListener(this);
        btn20.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.buttonC:
                tvLog.setText("");
                tvRes.setText("");
                flag = false;
                btn19.setEnabled(true);
                clickedEqual = false;
                break;
            case R.id.buttonEqual:
                if(str_int == 0){
                    action = tvLog.getText().toString();
                    num = Double.parseDouble(action);
                    tvRes.setText(num.toString());
                }
                else {
                    action = tvLog.getText().toString();
                    num1 = Double.parseDouble(action.substring(str_int));
                    num2 = CountRes(num, op, num1);
                    num = num2;
                    action = num.toString();
                    tvRes.setText(num.toString());
                    flagInNum1 = false;
                    flag = false;
                    clickedEqual = true;
                    btn19.setEnabled(true);
                }
                break;
            case R.id.buttonPlus:
                if(flag || clickedEqual){
                    tvLog.setText(action + "+");
                    op = '+';
                    str_int = action.length()+1;
                    flag = true;
                }
                else if(flagInNum1){
                    action = tvLog.getText().toString();
                    num1 = Double.parseDouble(action.substring(str_int));
                    num = CountRes(num, op, num1);
                    tvLog.setText(action + "+");
                    str_int = action.length()+1;
                    flagInNum1 = false;
                    flag = true;
                    op = '+';

                }
                else {
                    action = tvLog.getText().toString();
                    num = Double.parseDouble(action);
                    tvLog.setText(action + "+");
                    op = '+';
                    str_int = action.length()+1;
                    flag = true;
                }
                btn19.setEnabled(true);
                break;
            case R.id.buttonMinus:
                if(flag || clickedEqual){
                    action = tvLog.getText().toString();
                    tvLog.setText(action + "-");
                    op = '-';
                    str_int = action.length()+1;
                    flag = true;
                }
                else if(flagInNum1){
                    action = tvLog.getText().toString();
                    num1 = Double.parseDouble(action.substring(str_int));
                    num = CountRes(num, op, num1);
                    tvLog.setText(action + "-");
                    str_int = action.length()+1;
                    flagInNum1 = false;
                    flag = true;
                    op = '-';

                }
                else {
                    action = tvLog.getText().toString();
                    num = Double.parseDouble(action);
                    tvLog.setText(action + "-");
                    op = '-';
                    str_int = action.length()+1;
                    flag = true;
                }
                btn19.setEnabled(true);
                break;
            case R.id.buttonMultiply:
                if(flag || clickedEqual){
                    action = tvLog.getText().toString();
                    tvLog.setText(action + "*");
                    op = '*';
                    str_int = action.length()+1;
                    flag = true;
                }
                else if(flagInNum1){
                    action = tvLog.getText().toString();
                    num1 = Double.parseDouble(action.substring(str_int));
                    num = CountRes(num, op, num1);
                    tvLog.setText(action + "*");
                    str_int = action.length()+1;
                    flagInNum1 = false;
                    flag = true;
                    op = '*';

                }
                else {
                    action = tvLog.getText().toString();
                    num = Double.parseDouble(action);
                    tvLog.setText(action + "*");
                    op = '*';
                    str_int = action.length()+1;
                    flag = true;
                }
                btn19.setEnabled(true);
                break;
            case R.id.buttonDivider:
                if(flag || clickedEqual){
                    tvLog.setText(action + "/");
                    op = '/';
                    str_int = action.length()+1;
                    flag = true;
                }
                else if(flagInNum1){
                    action = tvLog.getText().toString();
                    num1 = Double.parseDouble(action.substring(str_int));
                    num = CountRes(num, op, num1);
                    tvLog.setText(action + "/");
                    str_int = action.length()+1;
                    flagInNum1 = false;
                    flag = true;
                    op = '/';

                }
                else {
                    action = tvLog.getText().toString();
                    num = Double.parseDouble(action);
                    tvLog.setText(action + "/");
                    op = '/';
                    str_int = action.length()+1;
                    flag = true;
                }
                btn19.setEnabled(true);
                break;
            case R.id.buttonFact:
                action = tvLog.getText().toString();
                tvLog.setText(action + "!");
                int result = (int) Math.round(num);
                String ans = Integer.toString(Factorial(result));
                tvLog.setText("");
                tvRes.setText(ans);
                btn19.setEnabled(true);
                break;
            case R.id.button1:
                action = tvLog.getText().toString();
                if(flag){
                    flag = false;
                    clickedEqual = false;
                    flagInNum1 = true;
                }
                tvLog.setText(action + "1");
                break;
            case R.id.button2:
                action = tvLog.getText().toString();
                if(flag){
                    flag = false;
                    clickedEqual = false;
                    flagInNum1 = true;
                }
                tvLog.setText(action + "2");
                break;
            case R.id.button3:
                action = tvLog.getText().toString();
                if(flag){
                    flag = false;
                    clickedEqual = false;
                    flagInNum1 = true;
                }
                tvLog.setText(action + "3");
                break;
            case R.id.button4:
                action = tvLog.getText().toString();
                if(flag){
                    flag = false;
                    clickedEqual = false;
                    flagInNum1 = true;
                }
                tvLog.setText(action + "4");
                break;
            case R.id.button5:
                action = tvLog.getText().toString();
                if(flag){
                    flag = false;
                    clickedEqual = false;
                    flagInNum1 = true;
                }
                tvLog.setText(action + "5");
                break;
            case R.id.button6:
                action = tvLog.getText().toString();
                if(flag){
                    flag = false;
                    clickedEqual = false;
                    flagInNum1 = true;
                }
                tvLog.setText(action + "6");
                break;
            case R.id.button7:
                action = tvLog.getText().toString();
                if(flag){
                    flag = false;
                    clickedEqual = false;
                    flagInNum1 = true;
                }
                tvLog.setText(action + "7");
                break;
            case R.id.button8:
                action = tvLog.getText().toString();
                if(flag){
                    flag = false;
                    clickedEqual = false;
                    flagInNum1 = true;
                }
                tvLog.setText(action + "8");
                break;
            case R.id.button9:
                action = tvLog.getText().toString();
                if(flag){
                    flag = false;
                    clickedEqual = false;
                    flagInNum1 = true;
                }
                tvLog.setText(action + "9");
                break;
            case R.id.buttonTo2:
                action = tvLog.getText().toString();

                double result1 = Math.pow(2,num);
                String ans1 = Double.toString(result1);
                tvLog.setText("");
                tvRes.setText(ans1);
                btn19.setEnabled(true);
                break;
            case R.id.buttonPoint:
                action = tvLog.getText().toString();
                action +=".";
                btn19.setEnabled(false);
                tvLog.setText(action);
                break;
            case R.id.buttonZero:
                action = tvLog.getText().toString();
                if(flag){
                    flag = false;
                    clickedEqual = false;
                    flagInNum1 = true;
                }
                tvLog.setText(action + "0");
                break;
            case R.id.buttonMR:
                if(memoryFlag){
                    double memNum;
                    memNum = CountRes(memory, op, num);
                    num = memNum;
                    tvRes.setText(Double.toString(memNum));
                    memoryFlag = false;
                    tvLog.append(memory.toString());
                }
                else {
                    if(num2 != 0.0)
                    {
                        memory = num;
                        memoryFlag = true;
                    }
                }

        }
    }
    public double CountRes(double number1, char op, double number2){
        if(op == '-'){number1 = number1 - number2;}
        else if(op == '+'){number1 = number1 + number2;}
        else if(op == '*'){number1 = number1 * number2;}
        else if(op == '/'){number1 = number1 / number2;}
        return number1;
    }

    public int Factorial(int n){
        int result = 1;
        for (int i = 1; i <=n; i++){
            result = result*i;
        }
        return result;
    }

}