package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompatSideChannelService;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

    public class MainActivity extends AppCompatActivity
    {
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        double value1 = 0, value2 = 0;
        String operator = "";

        public void Number(View v)
        {
            Button b = (Button) v;
            String buttontext = b.getText().toString();
            EditText s = findViewById(R.id.screen);
            s.setText(s.getText() + buttontext);
        }

        public void clear(View v)
        {
            EditText s = findViewById(R.id.screen);
            s.setText("");
            value1 = 0;
            value2 = 0;
        }

        public void operator(View v)
        {
            Button b = (Button) v;
            String opbutton = b.getText().toString();
            EditText s = findViewById(R.id.screen);
            if (s.getText().toString().isEmpty())
            {
                value1 = 0;
            }
            else
            {
                 value1 = Double.parseDouble((s.getText().toString()));
                 s.setText("");
                 operator = opbutton;
            }

        }
        public void equal(View v)
        {
            EditText s = findViewById(R.id.screen);
             if (s.getText().toString().isEmpty())
             {
                 value1 = 0;
             }
             if (s.getText().toString().contains("."))
             {
                 value1 = 0;
             }
             else
             {
                value2 = Double.parseDouble(s.getText().toString());

                switch (operator)
                {
                    case "+": s.setText(String.valueOf(value1 + value2)); break;
                    case "-": s.setText((String.valueOf(value1 - value2))); break;
                    case "/": s.setText(String.valueOf(value1 / value2)); break;
                    case "*": s.setText(String.valueOf(value1 * value2)); break;
                }
             }
            }
        }