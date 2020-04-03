package com.example.hackathonapp.util;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;

import androidx.test.runner.lifecycle.ActivityLifecycleMonitor;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.Stage;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.CountDownLatch;


public class ActivityFinisher2 implements Runnable{

    private ActivityLifecycleMonitor activityLifecycleMonitor = ActivityLifecycleMonitorRegistry.getInstance();
    private CountDownLatch latch;
    private List<Activity> activities;

    public ActivityFinisher2(CountDownLatch latch, List<Activity> activities) {
        this.latch = latch;
        this.activities = activities;
    }

    public ActivityFinisher2() {

    }

    public static void finishOpenActivities() {
        new Handler(Looper.getMainLooper()).post(new ActivityFinisher2());
    }
    @Override
    public void run() {
        List<Activity> activities = this.activities != null ? this.activities: new ArrayList<Activity>();

        for (Stage stage : EnumSet.range(Stage.CREATED, Stage.STOPPED)) {
            activities.addAll(activityLifecycleMonitor.getActivitiesInStage(stage));
        }

        if (latch != null) {
            latch.countDown();
        } else {
            for (Activity activity : activities) {
                if (!activity.isFinishing()) {
                    activity.finish();
                }

            }
        }
    }
}
