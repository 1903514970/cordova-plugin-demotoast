package org.apache.cordova.toast;

import android.widget.Toast;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by dengjun on 2019/1/23.
 */

public class DemoToast extends CordovaPlugin {


    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        final String message;
        if(args != null){
            message = args.getString(0);
        }else{
            message = null;
        }
        if(message == null){
            callbackContext.error("toast message is null");
            return true;
        }
        if("toastLong".equals(action)){
            cordova.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(cordova.getContext(),message,Toast.LENGTH_LONG).show();
                }
            });
        }else if("toast".equals(action)){
            cordova.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(cordova.getContext(),message,Toast.LENGTH_SHORT).show();
                }
            });
        }else{
            return false;
        }
        return true;
    }
}
