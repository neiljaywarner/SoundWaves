package org.bottiger.podcast.flavors.CrashReporter;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import org.acra.ACRA;
import org.bottiger.podcast.SoundWaves;

/**
 * Created by apl on 26-02-2015.
 */
public class VendorCrashReporter {

    public static void init(@NonNull Application argApplication) {
    }
	
	public static void report(@NonNull String argKey, @NonNull String argValue) {
    }

    public static void handleException(@NonNull Throwable argException) {
    }

}
