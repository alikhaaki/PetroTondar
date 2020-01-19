package com.petrotondar.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.petrotondar.R;

public class RegisterActivity extends AppCompatActivity {
	private TextView textView;
	private Button buttonSignSend;
	private EditText editName;
	private EditText editPhone;
	private EditText editNameCodeMelli;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		editName=findViewById(R.id.editTextName_register);
		editPhone=findViewById(R.id.editTextPhone_register);
		editNameCodeMelli=findViewById(R.id.editCodeMelli);
		textView=findViewById(R.id.text_send_pic);
		buttonSignSend=findViewById(R.id.button_signUp);
		
		buttonSignSend.setOnClickListener(new View.OnClickListener() {
			
			String phone=editPhone.getText().toString();
			String name=editName.getText().toString();
			String code=editNameCodeMelli.getText().toString();
			
			
			@Override
			public void onClick(View v) {
				
				if (editPhone.length()<11||editNameCodeMelli.length()<10||editName.length()<1){
				 
					Toast.makeText(RegisterActivity.this, "لطفا فرم را به صورت کامل پر نمایید", Toast.LENGTH_SHORT).show();
				}else {
					startActivity(new Intent(RegisterActivity.this,HomeActivity.class));
					finish();
				}
				
				
			}
		});
		textView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
				getIntent.setType("image/*");
				
				Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				pickIntent.setType("image/*");
				
				Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
				chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});
				
				startActivityForResult(chooserIntent, 1);
				
			}
		});
	}
}
