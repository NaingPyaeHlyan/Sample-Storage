package mm.com.examplestoragesampleapplication;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

public class ExternalStorageActivity extends AppCompatActivity {

    private EditText mEditText;
    private TextView mTextView;
    private final String TAG = "FW_OUTPUT";
    private String mDir = "";
    private String mFileName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("External Storage");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_color));
        setContentView(R.layout.activity_data);

        mEditText = findViewById(R.id.editTextInput);
        mTextView = findViewById(R.id.textViewOutPut);

        mDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + getPackageName() + "/";

        mFileName = mDir + "myfile.txt";
        Log.d(TAG, mDir);

        File dir = new File(mDir);

        if (!dir.exists())
            dir.mkdir();
    }

    public void saveData(View view){
        String data = mEditText.getText().toString();
        FileOutputStream fos;

        try {
            File myFile = new File(mFileName);

            myFile.createNewFile();

            fos = new FileOutputStream(myFile);

            OutputStreamWriter mOutWriter = new OutputStreamWriter(fos);

            mOutWriter.append(data);
            mOutWriter.close();
            fos.close();

            Toast.makeText(this, "External Storage saved as " + mFileName, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getData(View view){
        String line = "", aBuffer = "";

        try {
            File myFile = new File(mFileName);

            FileInputStream fIn = new FileInputStream(myFile);

            BufferedReader mReader = new BufferedReader(new InputStreamReader(fIn));

            while ((line = mReader.readLine()) != null){
                aBuffer += line + "\n";
            }

            mReader.close();

            mTextView.setText(aBuffer);

            Toast.makeText(this, "External Storage retrieved from " + mFileName, Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
