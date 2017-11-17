package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
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


    public WordAdapter(Activity context, ArrayList<Word> wordAdapter) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, wordAdapter);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
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
            // set to phrase miwok TextView a padding Left of 16dp
            miwokTextView.setPadding(16,0,0,0);
            // set to phrase miwok TextView an height of 44dp
            miwokTextView.setHeight(mGestureThreshold);
            // set to phrase default TextView a padding Left of 16dp
            defaultTextView.setPadding(16,0,0,0);
            // set to phrase default TextView an height of 44dp
            defaultTextView.setHeight(mGestureThreshold);
            // set phrase specific background color
            miwokTextView.setBackgroundColor(getContext().getResources().getColor(R.color.category_phrases));
            defaultTextView.setBackgroundColor(getContext().getResources().getColor(R.color.category_phrases));
            //set color text as white
            miwokTextView.setTextColor(getContext().getResources().getColor(R.color.white_text));
            defaultTextView.setTextColor(getContext().getResources().getColor(R.color.white_text));

            iconView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
