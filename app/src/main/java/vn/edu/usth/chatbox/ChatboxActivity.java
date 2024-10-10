package vn.edu.usth.chatbox;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChatboxActivity extends AppCompatActivity {

    private TextView chatTextView;
    private EditText messageEditText;
    private Button sendButton;
    private ScrollView scrollView;

    private float currentTextSize = 16f; // Default text size
    private ScaleGestureDetector scaleGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.box_chat);


    }
}
