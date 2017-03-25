package com.example.android.miwok;

/**
 * Created by Daguru34 on 3/18/2017.
 */

public class Word {


    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId= NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED= -1;
    private int mAudioResourceID;



    public Word(String mDefaultTranslation, String mMiwokTranslation, int mImageResourceId, int mAudioResourceID) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mImageResourceId = mImageResourceId;
        this.mAudioResourceID= mAudioResourceID;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation, int mAudioResourceID) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mAudioResourceID= mAudioResourceID;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;

    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation() {

        return mMiwokTranslation;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId!=NO_IMAGE_PROVIDED;
    }

    public int getmAudioResourceID(){
        return mAudioResourceID;
    }

}



