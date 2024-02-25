package com.example.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView t1;
     int count= 0;
    Button b1,b2,b3,o1,o2,o3;

    ImageView cartimage;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = findViewById(R.id.cart_text);
        b1 = findViewById(R.id.cartb1);
        b2 = findViewById(R.id.cartb2);
        b3 = findViewById(R.id.cartb3);
        cartimage = findViewById(R.id.cart);

        o1 = findViewById(R.id.bn1);
        o2 = findViewById(R.id.bn2);
        o3 = findViewById(R.id.bn3);

        // Initialize SharedPreferences
        sharedPreferences = getPreferences(MODE_PRIVATE);

        // Retrieve the count value from SharedPreferences
        count = sharedPreferences.getInt("count", 0);
        updateCountAndButtonText();


        o1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(i);
            }
        });

        o2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(i);
            }
        });

        o3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(i);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (b1.getText().equals("Add to Cart")) {
                    count++;
                } else {
                    count--;
                }

                // Save the updated count to SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("count", count);
                editor.apply();

                updateCountAndButtonText();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (b2.getText().equals("Add to Cart")) {
                    count++;
                    t1.setText(String.valueOf(count));
                    b2.setText("Remove Item");
                } else {
                    count--;
                    t1.setText(String.valueOf(count));
                    b2.setText("Add to Cart");
                }

                // Save the updated count to SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("count", count);
                editor.apply();

                updateCountAndButtonText();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (b3.getText().equals("Add to Cart")) {
                    count++;
                    t1.setText(String.valueOf(count));
                    b3.setText("Remove Item");
                } else {
                    count--;
                    t1.setText(String.valueOf(count));
                    b3.setText("Add to Cart");
                }

                // Save the updated count to SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("count", count);
                editor.apply();

                updateCountAndButtonText();
            }
        });

        cartimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("items",count);
                startActivity(intent);

            }
        });

    }

    private void updateCountAndButtonText() {
        t1.setText(String.valueOf(count));

        // Update button text based on the count
        if (count > 0) {
            b1.setText("Remove Item");
        } else {
            b1.setText("Add to Cart");
        }
    }
}