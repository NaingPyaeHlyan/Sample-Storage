package mm.com.examplestoragesampleapplication.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import mm.com.examplestoragesampleapplication.MainActivity;
import mm.com.examplestoragesampleapplication.R;

public class ListViewActivity extends AppCompatActivity {

    private ListView mListView;
    private GridView mGridVeiw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mListView = findViewById(R.id.listView);
        mGridVeiw = findViewById(R.id.gridView);
        loadListView(); loadGridView();
    }

    public void loadListView(){
        String[] values = getResources().getStringArray(R.array.database_name);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.tvListItem, values);

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemValue = (String)mListView.getItemAtPosition(position);

                startActivity(new Intent(ListViewActivity.this, MainActivity.class));
                Toast.makeText(ListViewActivity.this, itemValue, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void loadGridView(){
        final String[] values = new String[]{"Share Preference", "Internal Storage", "External Storage", "SQLite", "Http"};

        mGridVeiw = findViewById(R.id.gridView);
        mGridVeiw.setAdapter(new GridViewAdapter(this, values));

        mGridVeiw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, ((TextView) view.findViewById(R.id.tvGrid)).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
