package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public class myNum {
        double userNum;

        public myNum (double num)  {
            this.userNum = num;
        }

        public double getUserNum()   {
            return userNum;
        }

        public boolean isSquare()   {
            // If the number is less than 0, then its not a square
            if (userNum < 0)    {
                return false;
            }

            // Square roots the number
            double testNum = Math.sqrt(userNum);

            // If the difference of the number minus its floor is 0, it will return true
            return ((testNum - Math.floor(testNum)) == 0);
        }

        public boolean isTriangular() {
            // If the number is less than 0, then its not a square
            if (userNum < 0)    {
                return false;
            }

            // Using 8*n+1 method of getting a triangular
            double testNum = ((Math.sqrt(8 * userNum + 1) - 1) / 2);

            // If the number can divide evenly with 1, then its a triangular number
            return (testNum % 1 == 0);
        }
    }


    public void onClick (View view) {

        EditText editText = (EditText)findViewById(R.id.userText);
        if (editText.getText().toString().isEmpty())    {
            Toast.makeText(this, "Please Input A Number", Toast.LENGTH_SHORT).show();
            return;
        }

        String userText = editText.getText().toString();
        double userDouble = Double.parseDouble(userText);

        myNum userNum = new myNum(userDouble);

        boolean checkSquare = userNum.isSquare();
        boolean checkTri = userNum.isTriangular();

        // Number is both not square and triangular
        if (!checkSquare && !checkTri)  {
            String msg = userText + " is not Square nor Triangular";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
        // Number is square, but not triangular
        else if (checkSquare && !checkTri)  {
            String msg = userText + " is Square";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
        // Number is triangular but not square
        else if (!checkSquare && checkTri)  {
            String msg = userText + " is Triangular";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
        // Number is both
        else if (checkSquare && checkTri)   {
            String msg = userText + " is both Square and Triangular";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
        // ERROR
        else    {
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
