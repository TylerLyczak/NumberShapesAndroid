package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    public class myNum {
        int userNum;

        public myNum (int num)  {
            this.userNum = num;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
