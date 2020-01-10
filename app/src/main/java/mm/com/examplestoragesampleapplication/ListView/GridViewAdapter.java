package mm.com.examplestoragesampleapplication.ListView;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import mm.com.examplestoragesampleapplication.R;

public class GridViewAdapter extends BaseAdapter {

    private Context context;
    private final String[] storageValues;

    public GridViewAdapter(Context context, String[] storageValues) {
        this.context = context;
        this.storageValues = storageValues;
    }

    @Override
    public int getCount() {
        return storageValues.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView;
        if (convertView == null){
            rootView = new View(context);

            rootView = inflater.inflate(R.layout.grid_item, null);
        }else {
            rootView = (View) convertView;
        }

        TextView textView = (TextView) rootView.findViewById(R.id.tvGrid);
        textView.setText(storageValues[position]);

        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageGridView);

        imageView.setImageResource(R.mipmap.ic_launcher);
        /*
        String storage  = storageValues[position];
        if (storage.equals("Share Preference")){
            imageView.setImageResource(R.drawable.sharepreference);
        }
        */

        return rootView;
    }
}
