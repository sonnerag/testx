package vn.edu.usth.createserver;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.edu.usth.chatbox.R;
import vn.edu.usth.listserver.SearchActivity;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private EditText usernameEditText, portEditText, nicknameEditText, realNameEditText, channelEditText, nickServPasswordEditText;
    private Switch sslSwitch;
    private Button doneButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createserver_fragment); // Make sure the layout is named correctly

        // Initialize UI components
        spinner = findViewById(R.id.spinner);
        usernameEditText = findViewById(R.id.username);
        portEditText = findViewById(R.id.port_edit_text); // Make sure to match with your XML ID
        nicknameEditText = findViewById(R.id.nickname_edit_text); // Update with the actual ID
        realNameEditText = findViewById(R.id.realname_edit_text); // Update with the actual ID
        channelEditText = findViewById(R.id.channel_edit_text); // Update with the actual ID
        nickServPasswordEditText = findViewById(R.id.nickserv_password_edit_text); // Update with the actual ID
        sslSwitch = findViewById(R.id.ssl_switch); // Update with the actual ID
        doneButton = findViewById(R.id.savetouser);
        cancelButton = findViewById(R.id.cancel_button); // Ensure this ID exists

        // Set listeners for buttons
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectToIRCServer();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle cancel action
                finish(); // Closes the activity
            }
        });
    }

    private void connectToIRCServer() {
        // Retrieve user input
        String username = usernameEditText.getText().toString().trim();
        String port = portEditText.getText().toString().trim();
        String nickname = nicknameEditText.getText().toString().trim();
        String realName = realNameEditText.getText().toString().trim();
        String channel = channelEditText.getText().toString().trim();
        String nickServPassword = nickServPasswordEditText.getText().toString().trim();
        boolean useSSL = sslSwitch.isChecked();

        // Add your connection logic here

        // Example feedback
        Toast.makeText(this, "Connecting to IRC server...", Toast.LENGTH_SHORT).show();
    }
}