package mm.com.examplestoragesampleapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SharePreferenceActivity extends AppCompatActivity {

    private EditText mEditText;
    private TextView mTextView;
    private final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Share Preference");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_color));
        setContentView(R.layout.activity_data);
        mEditText = findViewById(R.id.editTextInput);
        mTextView = findViewById(R.id.textViewOutPut);
    }

    public void saveData(View view){

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        SharedPreferences.Editor editor = settings.edit();

        String data = mEditText.getText().toString();

        editor.putString("sample", data);

        editor.commit();

        Toast.makeText(this, "Preference saved", Toast.LENGTH_SHORT).show();

        mEditText.setText("");
    }

    public void getData(View view){

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        String data = settings.getString("sample", "No data");

        Toast.makeText(this, "Preference retrieved", Toast.LENGTH_SHORT).show();

        mTextView.setText(data);
    }
}
