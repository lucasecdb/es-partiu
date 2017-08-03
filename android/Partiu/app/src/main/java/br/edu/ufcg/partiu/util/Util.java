package br.edu.ufcg.partiu.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import br.edu.ufcg.partiu.model.User;

/**
 * Created by caiovidal on 12/07/17.
 */

public class Util {

    private static SharedPreferences preferences;

    public static SharedPreferences getPreferences(Context context) {
        if (preferences == null)
            preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences;
    }

    public static String getSessionToken(Context context) {
        return getPreferences(context).getString(Constants.TOKEN, "");
    }
}
