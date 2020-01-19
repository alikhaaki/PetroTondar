package com.petrotondar.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.petrotondar.R;

public class MainActivity extends AppCompatActivity {
	private Button buttonSignUp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		buttonSignUp=findViewById(R.id.button_signUp);
		buttonSignUp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,SignUpActivity.class));
				finish();
			}
		});
	}
}
