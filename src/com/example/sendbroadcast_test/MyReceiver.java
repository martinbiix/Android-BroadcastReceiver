package com.example.sendbroadcast_test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MyReceiver  extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent arg1) {
		// TODO Auto-generated method stub
		//Iniciar el servicio
		Bundle extras = arg1.getExtras();
		if(extras != null){
			try{
				String state = extras.getString(TelephonyManager.EXTRA_STATE);
				Log.w(MainActivity.log,state);
				
				if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
					
					TelephonyManager telManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
					String myPhoneNumber = telManager.getLine1Number();
					String phoneNumber = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
					
					Log.w(MainActivity.log,"My Number: "+myPhoneNumber);
					Log.w(MainActivity.log,"External Number: "+phoneNumber);
				}
			}catch(Exception e){
				Log.w(MainActivity.log,"ERROR: "+e);
			}
			
		}
		
	}
}
