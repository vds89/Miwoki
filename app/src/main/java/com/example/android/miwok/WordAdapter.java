package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pcvincenzo on 16/11/17.
 */
/**
 * This is our own custom constructor (it doesn't mirror a superclass constructor).
 * The context is used to inflate the layout file, and the list is the data we want
 * to populate into the lists.
 *
 * param context        The current context. Used to inflate the layout file.
 * param wordAdapter    A List of AndroidFlavor objects to display in a list
 */
public class WordAdapter extends ArrayAdapter<Word> {

    // The gesture threshold expressed in dp
    private static final float GESTURE_THRESHOLD_DP = 44.0f;
    // Get the screen's density scale
    final float scale = getContext().getResources().getDisplayMetrics().density;
    // Convert the dps to pixels, based on density scale
    int mGestureThreshold = (int) (GESTURE_THRESHOLD_DP * scale + 0.5f);

    private int mColorResourceId;


    public WordAdapter(Activity context, ArrayList<Word> wordAdapter, int ColorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, wordAdapter);
        mColorResourceId = ColorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID defaultTranslation
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the default translation from the current Word object and
        // set this text on the name TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());


        // Find the TextView in the list_item.xml layout with the ID miwokTranslation
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the miwok translation from the current Word object and
        // set this text on the number TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the ImageView in the list_item.xml layout with the ID icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.icon_view);



        if(currentWord.hasImage()) {
            // Get the icon image from the current Word object and
            // set this image on the image ImageView
            iconView.setImageResource(currentWord.getImageResourceId());
            //Make sure the view is visible
            iconView.setVisibility(View.VISIBLE);


        }
        else {

            iconView.setVisibility(View.GONE);
        }

            // Set the theme color for the list item
            View textContainer = listItemView.findViewById(R.id.text_container);
            // Find the color that the resource ID maps to
            int color = ContextCompat.getColor(getContext(), mColorResourceId);
            // Set the background color of the text container View
            textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
