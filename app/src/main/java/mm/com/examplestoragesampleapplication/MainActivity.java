package mm.com.examplestoragesampleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    public void loadSharePreference(View view) {
        startActivity(new Intent(this, SharePreferenceActivity.class));
        overridePendingTransition(0,0);
    }

    public void loadInternalStorage(View view) {
        startActivity(new Intent(this, InternalStorageActivity.class));
        overridePendingTransition(0,0);
    }

    public void loadExternalStorage(View view) {
        startActivity(new Intent(this, ExternalStorageActivity.class));
        overridePendingTransition(0,0);
    }

    public void loadSqLite(View view) {
        startActivity(new Intent(this, SqLiteActivity.class));
        overridePendingTransition(0,0);
    }

    public void loadHTTP(View view) {
        startActivity(new Intent(this, HTTPActivity.class));
        overridePendingTransition(0,0);
    }
}
