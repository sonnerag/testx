package vn.edu.usth.loginsignup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import vn.edu.usth.chatbox.R;
import vn.edu.usth.listserver.IRC;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.loginsignup_firstpage);


        Button fbButton = findViewById(R.id.fb);
        Button gmButton = findViewById(R.id.gm);

        fbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to open the IRC activity
                Intent intent = new Intent(MainActivity2.this, IRC.class);
                startActivity(intent);
            }
        });

        gmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity2.this, IRC.class);
                startActivity(intent);
            }
        });


        TextView moveTextView = findViewById(R.id.Move);

        // Set click listener for the TextView
        moveTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent); // Start MainActivity3
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void LogIn(View view) {
        // Create an Intent to start the new activity
        Intent intent = new Intent(this, MainActivity.class); // Replace NextActivity with your target activity
        startActivity(intent);
    }


}