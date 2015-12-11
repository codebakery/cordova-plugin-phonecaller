package io.codebakery.phonecaller;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.net.Uri;

import android.content.Intent;

public class PhoneCaller extends CordovaPlugin {
    /**
    * Executes the request and returns PluginResult.
    *
    * @param action            The action to execute.
    * @param args              JSONArray of arguments for the plugin.
    * @param callbackContext   The callback id used when calling back into JavaScript.
    * @return                  True if the action was valid, false if not.
    */
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException{
        if ("call".equals(action)) {
            try {
                Uri phoneNumber = Uri.parse("tel:" + args.getString(0));
                Intent callIntent = new Intent(Intent.ACTION_CALL, phoneNumber);
                this.cordova.getActivity().startActivity(callIntent);
                callbackContext.success();
            } catch (Exception e) {
                callbackContext.error("Exception: " + e.getMessage());
            }
            return true;
        }
        return false;
    }
}
