package mm.com.examplestoragesampleapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InternalStorageActivity extends AppCompatActivity {

    private EditText mEditText;
    private TextView mTextView;
    private final String FILE_NAME = "myfile.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Internal Storage");
        setContentView(R.layout.activity_data);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_color));

        mEditText = findViewById(R.id.editTextInput);
        mTextView = findViewById(R.id.textViewOutPut);
    }

    public void saveData(View view){

        String string = mEditText.getText().toString();

        FileOutputStream fos;

        try{
            fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);

            fos.write(string.getBytes());

            fos.close();

            Toast.makeText(this, "Internal Storage saved as " + FILE_NAME, Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getData(View view){

        FileInputStream fin;

        try {
            fin = openFileInput(FILE_NAME);

            int c;

            String temp = "";

            while ((c = fin.read()) != -1){

                temp = temp + Character.toString((char)c);

            }
            mTextView.setText(temp);

            fin.close();

            Toast.makeText(this, "Internal Storage retrieved from " + FILE_NAME, Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
