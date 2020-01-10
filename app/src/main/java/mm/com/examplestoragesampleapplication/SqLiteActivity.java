package mm.com.examplestoragesampleapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SqLiteActivity extends AppCompatActivity {

    private EditText mEditText;
    private TextView mTextView;
    private Button mBtnUpdate, mBtnDelete;
    DataOpenHelper mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("SQLite");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_color));
        setContentView(R.layout.activity_data);
        mEditText = findViewById(R.id.editTextInput);
        mTextView = findViewById(R.id.textViewOutPut);

        mDb = new DataOpenHelper(SqLiteActivity.this);

        mBtnUpdate = findViewById(R.id.btnUpdate);
        mBtnUpdate.setVisibility(View.VISIBLE);
        mBtnDelete = findViewById(R.id.btnDelete);
        mBtnDelete.setVisibility(View.VISIBLE);

//        mBtnUpdate.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//        mBtnDelete.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
    }

    public void saveData(View view){
        mDb.addValue(mEditText.getText().toString());
        mTextView.setText(mDb.getValue());
        Toast.makeText(this, "SQLite data insert in table [data] with column [value] in database [mydb]", Toast.LENGTH_SHORT).show();
    }

    public void getData(View view){
        mTextView.setText(mDb.getValue());

        Toast.makeText(this, "SQLite data list retrieved all form table [data] with column [value] in database [mydb]", Toast.LENGTH_SHORT).show();
    }

    public void updateData(View view){
        mDb.setValue(mEditText.getText().toString());
        mTextView.setText(mDb.getValue());
        Toast.makeText(this, "SQLite data updated in table [data] with column [value] where id = 1 in database [mydb]", Toast.LENGTH_SHORT).show();
    }

    public void deleteData(View view){
        mDb.deleteValue(mEditText.getText().toString());
        mTextView.setText(mDb.getValue());
        mEditText.setText("");
        Toast.makeText(this, "SQLite data deleted in table [data] where [data] = ' " + mEditText.getText().toString() + "' in database [mydb]", Toast.LENGTH_SHORT).show();
    }

    public class DataOpenHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "mydb", DATA_TABLE_NAME = "data";
        private static final int DATABASE_VERSION = 2;

        private static final String DATA_TABLE_CREATE = "CREATE TABLE " + DATA_TABLE_NAME + " (" + "id INTEGER PRIMARY KEY AUTOINCREMENT, value TEXT);";

        DataOpenHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATA_TABLE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATA_TABLE_NAME);
            onCreate(db);
        }

        void addValue(String text){
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("value", text);

            // Inserting row
            db.insert(DATA_TABLE_NAME, null, values);   // 2nd argument is String containing nullColumnHack
            db.close();
        }

        public String getValue(){
            SQLiteDatabase db = this.getReadableDatabase();
            String ret = "";

            Cursor cursor = db.query(DATA_TABLE_NAME, new String[] {"value"}, null, null, null, null, null, null);

            if (cursor.moveToFirst()){
                do {

                    ret += cursor.getString(0) + "\n";

                } while (cursor.moveToNext());
            }
            return ret;
        }

        public void setValue(String text){
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put("value", text);

            db.update(DATA_TABLE_NAME, values, "id=?", new String[]{"1"});
            db.close();
        }

        public void deleteValue(String text){
            SQLiteDatabase db = this.getWritableDatabase();

            db.delete(DATA_TABLE_NAME, "value=?", new String[] {text});
            db.close();
        }
    }
}
