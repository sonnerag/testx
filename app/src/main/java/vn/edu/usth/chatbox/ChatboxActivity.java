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

        chatTextView = findViewById(R.id.chatTextView);
        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);
        scrollView = findViewById(R.id.scrollView);

        // Initialize scale gesture detector for pinch to zoom
        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());

        // Send message
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageEditText.getText().toString().trim();
                if (!message.isEmpty()) {
                    chatTextView.append("You: " + message + "\n");
                    messageEditText.setText(""); // Clear input field
                    scrollToBottom();
                }
            }
        });

        // Set touch listener to detect pinch gestures
        chatTextView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                scaleGestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }

    // Scroll to the bottom of the chat when a new message is added
    private void scrollToBottom() {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }

    // Custom scale listener class to handle pinch zoom
    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            float scaleFactor = detector.getScaleFactor();
            currentTextSize = currentTextSize * scaleFactor;

            // Limit text size to a reasonable range
            currentTextSize = Math.max(7f, Math.min(currentTextSize, 55f));

            chatTextView.setTextSize(currentTextSize);
            return true;
        }
    }
}
