package mm.com.examplestoragesampleapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class HTTPActivity extends AppCompatActivity {

    private EditText mEditText;
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_color));
        setTitle("Http");
        setContentView(R.layout.activity_data);

        mEditText = findViewById(R.id.editTextInput);
        mTextView = findViewById(R.id.textViewOutPut);
    }

    public void saveData(View view){

    }

    public void getData(View view){

    }
}
