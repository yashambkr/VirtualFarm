package com.example.virtualfarm2020;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Plants> {

    public ListAdapter(Activity context, ArrayList<Plants> words) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_items, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Plants currentPlant = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView PlantType  = (TextView) listItemView.findViewById(R.id.Plant_Type_textView);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView


        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.Plant_Type_textView);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentPlant.getmPlantName());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.List_item_image);

        if (currentPlant.hasImage()) {
            imageView.setImageResource(currentPlant.getimageResourceID());
            imageView.setVisibility(View.VISIBLE);
        }else{
            imageView.setVisibility(View.GONE);
        }



        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}