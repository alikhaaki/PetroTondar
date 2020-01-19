package com.petrotondar.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.petrotondar.R;

public class SignUpActivity extends AppCompatActivity {
	
	private Button buttonSignUp;
	private EditText editTextPhone;
	private static final String TAG = "SignUpActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
		
		buttonSignUp = findViewById(R.id.button_signUp);
		editTextPhone = findViewById(R.id.editText_phone);
		
		
		
		buttonSignUp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String phoneString = editTextPhone.getText().toString();
				
				if (phoneString.equals("") || phoneString.isEmpty()) {
					Toast.makeText(SignUpActivity.this, "شماره تلفن نباید خالی باشد", Toast.LENGTH_SHORT).show();
				} else if (phoneString.length() < 11) {
					Toast.makeText(SignUpActivity.this, "شماره تلفن را کامل وارد نمایید", Toast.LENGTH_SHORT).show();
				} else {
					
					String subPhone = editTextPhone.getText().toString().substring(0, 2);
					if (!subPhone.equals("09")) {
						Toast.makeText(SignUpActivity.this, "شماره تلفن را با صفر وارد نمایید", Toast.LENGTH_SHORT).show();
					}else{
						Intent intent = new Intent(SignUpActivity.this, VerifyPhoneActivity.class);
						intent.putExtra("key", phoneString);
						startActivity(intent);
						finish();
					}
			 
					
				}
//
			}
		});
	}
}
