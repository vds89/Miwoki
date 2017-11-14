package com.example.android.miwok;
import android.content.Context;
/**
 * Created by pcvincenzo on 14/11/17.
 * Displays text to the user.
 */

public class Word{

        // Default translation for the word
        private String mDefaultTranslation;

        // Miwok translation for the word
        private String mMiwokTranslation;

        /**
         * Constructs a new TextView with initial values for text and text color.
         */
        public Word(String defaultTranslation, String miwokTranslation) {
            mDefaultTranslation = defaultTranslation;
            mMiwokTranslation = miwokTranslation;
        }

        /**
         * Gets the default translation of the word.
         *
         */
        public String getDefaultTranslation() {
            return mDefaultTranslation;
        }

        /**
         * Gets the miwok translation of the word.
         *
         */
        public String getMiwokTranslation() {
            return mMiwokTranslation;
        }

}
