package com.example.hwandroid111;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DataItemsAdapter extends BaseAdapter {

    private List<DataItems> dataItems;
    private LayoutInflater inflater;

    public DataItemsAdapter(List<DataItems> dataItems, Context context) {
        this.dataItems = dataItems;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataItems != null ? dataItems.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return dataItems != null ? dataItems.get(position) : 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View currentView;

        if (convertView != null) {
            currentView = convertView;
        } else {
            currentView = inflater.inflate(R.layout.item_list_view, parent, false);
        }

        DataItems dataItems = (DataItems) getItem(position);

        if (dataItems != null)  {
            TextView title = currentView.findViewById(R.id.title);
            TextView subTitle = currentView.findViewById(R.id.subtitle);
            CheckBox checkBox = currentView.findViewById(R.id.checkbox);
            ImageView imageView = currentView.findViewById(R.id.icon_view);

            imageView.setBackgroundResource(dataItems.getImageID());
            title.setText(dataItems.getTitle_view());
            subTitle.setText(dataItems.getSubTitle_view());
            checkBox.setOnCheckedChangeListener(myCheckChangeList);
            checkBox.setTag(position);
            checkBox.setChecked(dataItems.isChecked());

        }
        return currentView;
    }

    CompoundButton.OnCheckedChangeListener myCheckChangeList = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {

        }
    };
}
