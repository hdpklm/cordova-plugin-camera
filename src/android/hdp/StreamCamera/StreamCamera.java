package hdp.StreamCamera;

import org.apache.cordova.PluginResult;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.*;
import android.graphics.*;
import android.hardware.*;
import android.os.*;
import android.util.*;
import android.view.*;
import java.io.*;
import java.util.*;
import javax.security.auth.callback.*;

import android.hardware.Camera;

/**
	* This class echoes a string called from JavaScript.
*/
public class StreamCamera extends CordovaPlugin
{
	
	private CallbackContext eventCallback;
	
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException
	{
		if (action.equals("openCam"))
		{
			String message = args.getString(0);
			this.openCam(message, callbackContext);
			return true;
		}
		
		if (action.equals("Start"))
		{
			String message = args.getString(0);
			this.Start(message, callbackContext);
			return true;
		}
		
		return false;
	}
	
	private void openCam(String message, CallbackContext callbackContext)
	{
		if (message != null && message.length() > 0)
		{
			Create();
			callbackContext.success("ok");
		}
		else
		{
			callbackContext.error("Expected one non-empty string argument.");
		}
	}
	
	private void Start(String message, CallbackContext callbackContext)
	{
		if (message != null && message.length() > 0)
		{
			eventCallback = callbackContext;
			PluginResult result = new PluginResult(PluginResult.Status.OK, "registered");
			result.setKeepCallback(true);
			eventCallback.sendPluginResult(result);
			
			// callbackContext.success(message);
		}
		else
		{
			callbackContext.error("Expected one non-empty string argument.");
		}
	}
	
}