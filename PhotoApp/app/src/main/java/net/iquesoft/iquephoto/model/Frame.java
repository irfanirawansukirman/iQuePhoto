package net.iquesoft.iquephoto.model;

import android.support.annotation.DrawableRes;

import net.iquesoft.iquephoto.R;

import java.util.Arrays;
import java.util.List;

public class Frame {
    private String mTitle;

    @DrawableRes
    private int mImage;

    private boolean mIsSelected;

    public static List<Frame> getFramesList() {
        return Arrays.asList(frames);
    }

    private static Frame[] frames = {
            new Frame("GRUNGE01", R.drawable.frame_grunge_01)
    };

    public Frame(String title, @DrawableRes int image) {
        mTitle = title;
        mImage = image;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = mImage;
    }

    public boolean isSelected() {
        return mIsSelected;
    }

    public void setSelected(boolean isSelected) {
        mIsSelected = isSelected;
    }
}