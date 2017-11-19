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

        /** Constant value that represents no image was provided for this word */
        private static final int NO_IMAGE_PROVIDED = -1;

        /** Image resource ID for the word */
        private int mImageResourceId = NO_IMAGE_PROVIDED;

        private int mAudioResourceId;

        /**
        * Create a new Word object.
        *
        * @param defaultTranslation is the word in a language that the user is already familiar with
        *                           (such as English)
        * @param miwokTranslation is the word in the Miwok language
        */
        public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
            mDefaultTranslation = defaultTranslation;
            mMiwokTranslation = miwokTranslation;
            mAudioResourceId = audioResourceId;
        }

        /**
         * Create a new Word object.
         *
         * @param defaultTranslation is the word in a language that the user is already familiar with
         *                           (such as English)
         * @param miwokTranslation is the word in the Miwok language
         * @param image is the drawable resource ID for the image associated with the word
         *
         */
        public Word(String defaultTranslation, String miwokTranslation, int image, int audioResourceId) {
            mDefaultTranslation = defaultTranslation;
            mMiwokTranslation = miwokTranslation;
            mImageResourceId = image;
            mAudioResourceId = audioResourceId;
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

        /**
         * Gets the image resource ID
         */
        public int getImageResourceId() { return mImageResourceId; }

        /**
         * Returns whether or not there is an image for this word.
         */
        public boolean hasImage() {
                return mImageResourceId != NO_IMAGE_PROVIDED;
            }


        public int getAudioResourceId() { return mAudioResourceId; }
}
