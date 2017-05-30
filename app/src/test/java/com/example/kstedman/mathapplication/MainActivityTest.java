package com.example.kstedman.mathapplication;

import android.os.Build;
import android.util.Log;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertTrue;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void validateTextViewContent() {
        TextView appNameTitle = (TextView) activity.findViewById(R.id.pageTitle);
        assertTrue("SOLVR".equals(appNameTitle.getText().toString()));
    }

    @Test
    public void validateSolvrButtonContent() {
        TextView appNameTitle = (TextView) activity.findViewById(R.id.solveButton);
        assertTrue("Solvr".equals(appNameTitle.getText().toString()));
    }

    @Test
    public void validateContactButtonContent() {
        TextView appNameTitle = (TextView) activity.findViewById(R.id.contactbutton);
        assertTrue("Contact".equals(appNameTitle.getText().toString()));
    }

    @Test
    public void validateConvertButtonContent() {
        TextView appNameTitle = (TextView) activity.findViewById(R.id.convertButton);
        assertTrue("Convert".equals(appNameTitle.getText().toString()));
    }

    @Test
    public void validateAboutButtonContent() {
        TextView appNameTitle = (TextView) activity.findViewById(R.id.aboutButton);
        assertTrue("Ab".equals(appNameTitle.getText().toString()));
    }
}