package com.ryanmattison.samples.activeandroidtest;

import com.ryanmattison.samples.activeandroidtest.model.InitDatabase;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Singleton.getInstance().setContext(this.getApplicationContext());

		setContentView(R.layout.activity_main);
		InitDatabase id = new InitDatabase(); 
		id.init();
	}
	

	

}
