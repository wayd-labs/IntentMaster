package com.e16din.intentmaster;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.io.Serializable;

public class IntentMaster {

    private IntentMaster() {
    }

    public static String KEY_DATA = "data";

    public static Serializable getExtra(@NonNull Intent intent, @NonNull String key) {
        return intent.getExtras() == null ? null : intent.getExtras().getSerializable(key);
    }

    public static Serializable getExtra(@NonNull Intent intent) {
        return getExtra(intent, 0);
    }

    public static Serializable getExtra(@NonNull Intent intent, int position) {
        return getExtra(intent, KEY_DATA + "_" + position);
    }

    public static Serializable getExtra(@NonNull Activity activity) {
        return getExtra(activity, 0);
    }

    public static Serializable getExtra(@NonNull Activity activity, @NonNull String key) {
        return getExtra(activity.getIntent(), key);
    }

    public static Serializable getExtra(@NonNull Activity activity, int position) {
        return getExtra(activity.getIntent(), KEY_DATA + "_" + position);
    }


    public static Parcelable getExtraP(@NonNull Intent intent, @NonNull String key) {
        return intent.getExtras() == null ? null : intent.getExtras().getParcelable(key);
    }

    public static Parcelable getExtraP(@NonNull Intent intent) {
        return getExtraP(intent, 0);
    }

    public static Parcelable getExtraP(@NonNull Intent intent, int position) {
        return getExtraP(intent, KEY_DATA + "_" + position);
    }

    public static Parcelable getExtraP(@NonNull Activity activity) {
        return getExtraP(activity, 0);
    }

    public static Parcelable getExtraP(@NonNull Activity activity, @NonNull String key) {
        return getExtraP(activity.getIntent(), key);
    }

    public static Parcelable getExtraP(@NonNull Activity activity, int position) {
        return getExtraP(activity.getIntent(), KEY_DATA + "_" + position);
    }


    public static boolean containsKey(@NonNull Intent intent, @NonNull String key) {
        return intent.getExtras() != null && intent.getExtras().containsKey(key);
    }

    public static int getExtrasCount(@NonNull Intent intent) {
        return intent.getExtras() == null ? 0 : intent.getExtras().size();
    }

    public static int getExtrasCount(@NonNull Activity activity) {
        return getExtrasCount(activity.getIntent());
    }

    public static boolean hasExtra(@NonNull Intent intent) {
        return getExtrasCount(intent) > 0;
    }

    public static boolean hasExtra(@NonNull Activity activity) {
        return hasExtra(activity.getIntent());
    }

    public static Intent createResultIntent(@NonNull Activity activity, Serializable... data) {
        Intent intent = new Intent();
        activity.setResult(Activity.RESULT_OK, intent);
        putExtra(intent, data);
        return intent;
    }

    public static Intent createResultIntent(@NonNull Activity activity, Parcelable... data) {
        Intent intent = new Intent();
        activity.setResult(Activity.RESULT_OK, intent);
        putExtra(intent, data);
        return intent;
    }

    public static Intent createResultIntent(@NonNull Activity activity, Data... data) {
        Intent intent = new Intent();
        activity.setResult(Activity.RESULT_OK, intent);
        putExtra(intent, data);
        return intent;
    }

    public static void finishWithResult(@NonNull Activity activity, Serializable... data) {
        createResultIntent(activity, data);
        activity.finish();
    }

    public static void finishWithResult(@NonNull Activity activity, Parcelable... data) {
        createResultIntent(activity, data);
        activity.finish();
    }

    public static void finishWithResult(@NonNull Activity activity, Data... data) {
        createResultIntent(activity, data);
        activity.finish();
    }

    public static Intent createIntent(@NonNull Context context, @NonNull Class cls, Serializable... data) {
        Intent intent = new Intent(context, cls);
        putExtra(intent, data);
        return intent;
    }

    public static Intent createIntent(@NonNull Context context, @NonNull Class cls, Parcelable... data) {
        Intent intent = new Intent(context, cls);
        putExtra(intent, data);
        return intent;
    }

    public static Intent createIntent(@NonNull Context context, @NonNull Class cls, Data... data) {
        Intent intent = new Intent(context, cls);
        putExtra(intent, data);
        return intent;
    }

    public static Intent createIntent(@NonNull Context context, @NonNull Class cls) {
        return new Intent(context, cls);
    }

    public static Intent createIntent(@NonNull String action, Serializable... data) {
        Intent intent = new Intent(action);
        putExtra(intent, data);
        return intent;
    }

    public static Intent createIntent(@NonNull String action, Parcelable... data) {
        Intent intent = new Intent(action);
        putExtra(intent, data);
        return intent;
    }

    public static Intent createIntent(@NonNull String action, Data... data) {
        Intent intent = new Intent(action);
        putExtra(intent, data);
        return intent;
    }

    public static Intent createIntent(@NonNull String action) {
        return new Intent(action);
    }

    public static void startActivity(Context context, @NonNull Class cls) {
        Intent intent = createIntent(context, cls);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, @NonNull Class cls, Data... data) {
        Intent intent = createIntent(context, cls, data);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, @NonNull Class cls, Serializable... data) {
        Intent intent = createIntent(context, cls, data);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, @NonNull Class cls, Parcelable... data) {
        Intent intent = createIntent(context, cls, data);
        context.startActivity(intent);
    }

    public static void startActivityForResult(@NonNull Activity activity, @NonNull Class cls, int requestCode) {
        Intent intent = createIntent(activity, cls);
        activity.startActivityForResult(intent, requestCode);
    }

    public static void startActivityForResult(@NonNull Activity activity, @NonNull Class cls, int requestCode,
                                              Data... data) {
        Intent intent = createIntent(activity, cls, data);
        activity.startActivityForResult(intent, requestCode);
    }

    public static void startActivityForResult(@NonNull Activity activity, @NonNull Class cls, int requestCode,
                                              Serializable... data) {
        Intent intent = createIntent(activity, cls, data);
        activity.startActivityForResult(intent, requestCode);
    }

    public static void startActivityForResult(@NonNull Activity activity, @NonNull Class cls, int requestCode,
                                              Parcelable... data) {
        Intent intent = createIntent(activity, cls, data);
        activity.startActivityForResult(intent, requestCode);
    }

    public static void startActivityForResult0(@NonNull Activity activity, @NonNull Class cls) {
        startActivityForResult(activity, cls, 0);
    }

    public static void startActivityForResult0(@NonNull Activity activity, @NonNull Class cls, Data... data) {
        startActivityForResult(activity, cls, 0, data);
    }

    public static void startActivityForResult0(@NonNull Activity activity, @NonNull Class cls,
                                               Serializable... data) {
        startActivityForResult(activity, cls, 0, data);
    }

    public static void startActivityForResult0(@NonNull Activity activity, @NonNull Class cls,
                                               Parcelable... data) {
        startActivityForResult(activity, cls, 0, data);
    }

    ///
    public static void startActivityForResult(@NonNull Fragment fragment, @NonNull Class cls, int requestCode) {
        Activity activity = fragment.getActivity();
        Intent intent = createIntent(activity, cls);
        fragment.startActivityForResult(intent, requestCode);
    }

    public static void startActivityForResult(@NonNull Fragment fragment, @NonNull Class cls, int requestCode,
                                              Data... data) {
        Activity activity = fragment.getActivity();
        Intent intent = createIntent(activity, cls, data);
        fragment.startActivityForResult(intent, requestCode);
    }

    public static void startActivityForResult(@NonNull Fragment fragment, @NonNull Class cls, int requestCode,
                                              Serializable... data) {
        Activity activity = fragment.getActivity();
        Intent intent = createIntent(activity, cls, data);
        fragment.startActivityForResult(intent, requestCode);
    }

    public static void startActivityForResult(@NonNull Fragment fragment, @NonNull Class cls, int requestCode,
                                              Parcelable... data) {
        Activity activity = fragment.getActivity();
        Intent intent = createIntent(activity, cls, data);
        fragment.startActivityForResult(intent, requestCode);
    }

    public static void startActivityForResult0(@NonNull Fragment fragment, @NonNull Class cls) {
        startActivityForResult(fragment, cls, 0);
    }

    public static void startActivityForResult0(@NonNull Fragment fragment, @NonNull Class cls, Data... data) {
        startActivityForResult(fragment, cls, 0, data);
    }

    public static void startActivityForResult0(@NonNull Fragment fragment, @NonNull Class cls,
                                               Serializable... data) {
        startActivityForResult(fragment, cls, 0, data);
    }

    public static void startActivityForResult0(@NonNull Fragment fragment, @NonNull Class cls,
                                               Parcelable... data) {
        startActivityForResult(fragment, cls, 0, data);
    }

    ///

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void startActivityForResult(@NonNull android.app.Fragment fragment, @NonNull Class cls, int requestCode) {
        Activity activity = fragment.getActivity();
        Intent intent = createIntent(activity, cls);
        fragment.startActivityForResult(intent, requestCode);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void startActivityForResult(@NonNull android.app.Fragment fragment, @NonNull Class cls, int requestCode,
                                              Data... data) {
        Activity activity = fragment.getActivity();
        Intent intent = createIntent(activity, cls, data);
        fragment.startActivityForResult(intent, requestCode);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void startActivityForResult(@NonNull android.app.Fragment fragment, @NonNull Class cls, int requestCode,
                                              Serializable... data) {
        Activity activity = fragment.getActivity();
        Intent intent = createIntent(activity, cls, data);
        fragment.startActivityForResult(intent, requestCode);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void startActivityForResult(@NonNull android.app.Fragment fragment, @NonNull Class cls, int requestCode,
                                              Parcelable... data) {
        Activity activity = fragment.getActivity();
        Intent intent = createIntent(activity, cls, data);
        fragment.startActivityForResult(intent, requestCode);
    }

    public static void startActivityForResult0(@NonNull android.app.Fragment fragment, @NonNull Class cls) {
        startActivityForResult(fragment, cls, 0);
    }

    public static void startActivityForResult0(@NonNull android.app.Fragment fragment, @NonNull Class cls, Data... data) {
        startActivityForResult(fragment, cls, 0, data);
    }

    public static void startActivityForResult0(@NonNull android.app.Fragment fragment, @NonNull Class cls,
                                               Serializable... data) {
        startActivityForResult(fragment, cls, 0, data);
    }

    public static void startActivityForResult0(@NonNull android.app.Fragment fragment, @NonNull Class cls,
                                               Parcelable... data) {
        startActivityForResult(fragment, cls, 0, data);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void sendBroadcast(@NonNull android.app.Fragment fragment, @NonNull String action) {
        Intent intent = createIntent(action);
        fragment.getActivity().sendBroadcast(intent);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void sendBroadcast(@NonNull android.app.Fragment fragment, @NonNull String action, Data... data) {
        Intent intent = createIntent(action, data);
        fragment.getActivity().sendBroadcast(intent);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void sendBroadcast(@NonNull android.app.Fragment fragment, @NonNull String action, Serializable... data) {
        Intent intent = createIntent(action, data);
        fragment.getActivity().sendBroadcast(intent);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void sendBroadcast(@NonNull android.app.Fragment fragment, @NonNull String action, Parcelable... data) {
        Intent intent = createIntent(action, data);
        fragment.getActivity().sendBroadcast(intent);
    }


    public static void sendBroadcast(@NonNull Fragment fragment, @NonNull String action) {
        Intent intent = createIntent(action);
        fragment.getActivity().sendBroadcast(intent);
    }

    public static void sendBroadcast(@NonNull Fragment fragment, @NonNull String action, Data... data) {
        Intent intent = createIntent(action, data);
        fragment.getActivity().sendBroadcast(intent);
    }

    public static void sendBroadcast(@NonNull Fragment fragment, @NonNull String action, Serializable... data) {
        Intent intent = createIntent(action, data);
        fragment.getActivity().sendBroadcast(intent);
    }

    public static void sendBroadcast(@NonNull Fragment fragment, @NonNull String action, Parcelable... data) {
        Intent intent = createIntent(action, data);
        fragment.getActivity().sendBroadcast(intent);
    }


    public static void sendBroadcast(@NonNull Activity activity, @NonNull String action) {
        Intent intent = createIntent(action);
        activity.sendBroadcast(intent);
    }

    public static void sendBroadcast(@NonNull Activity activity, @NonNull String action, Data... data) {
        Intent intent = createIntent(action, data);
        activity.sendBroadcast(intent);
    }

    public static void sendBroadcast(@NonNull Activity activity, @NonNull String action, Serializable... data) {
        Intent intent = createIntent(action, data);
        activity.sendBroadcast(intent);
    }

    public static void sendBroadcast(@NonNull Activity activity, @NonNull String action, Parcelable... data) {
        Intent intent = createIntent(action, data);
        activity.sendBroadcast(intent);
    }


    public static void putExtra(@NonNull Intent intent, Data[] data) {
        for (int i = 0; i < data.length; i++) {
            intent.putExtra(data[i].getKey(), data[i].getValue());
        }
    }

    public static void putExtra(@NonNull Intent intent, Serializable[] data) {
        for (int i = 0; i < data.length; i++) {
            intent.putExtra(KEY_DATA + "_" + i, data[i]);
        }
    }

    public static void putExtra(@NonNull Intent intent, Parcelable[] data) {
        for (int i = 0; i < data.length; i++) {
            intent.putExtra(KEY_DATA + "_" + i, data[i]);
        }
    }

    ///Services

    public static void startService(@NonNull Context context, @NonNull Class cls) {
        Intent intent = createIntent(context, cls);
        context.startService(intent);
    }

    public static void call(@NonNull Activity activity, @NonNull String phone) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phone));
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Log.w(IntentMaster.class.getSimpleName(), "call: here to request the missing permission " +
                    "<uses-permission android:name=\"android.permission.CALL_PHONE\" />");
            return;
        }
        activity.startActivity(intent);
    }

    public static void sendSms(@NonNull Activity activity, @NonNull String phone, @NonNull String message) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("sms:" + phone));
        intent.putExtra("sms_body", message);
        activity.startActivity(intent);
    }

    public static void openMap(@NonNull Activity activity, double lat, double lng, @NonNull String title) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("geo:0,0?q=" + lat + "," + lng + " (" + title + ")"));
        activity.startActivity(intent);
    }

    public static void openGoogleMap(@NonNull Activity activity, @NonNull String text) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("geo:0,0?q=" + text));
        intent.setPackage("com.google.android.apps.maps");
        activity.startActivity(intent);
    }

    public static void openNavigationMap(@NonNull Activity activity, @NonNull String address) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("google.navigation:q=" + address));
        activity.startActivity(intent);
    }

    public static void openMap(@NonNull Activity activity, @NonNull String lat, @NonNull String lng, @NonNull String title) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("geo:0,0?q=" + lat + "," + lng + " (" + title + ")"));
        activity.startActivity(intent);
    }

    public static void openMap(@NonNull Activity activity, double lat, double lng) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("geo:0,0?q=" + lat + "," + lng));
        activity.startActivity(intent);
    }

    public static void openMap(@NonNull Activity activity, @NonNull String lat, @NonNull String lng) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("geo:0,0?q=" + lat + "," + lng));
        activity.startActivity(intent);
    }
}