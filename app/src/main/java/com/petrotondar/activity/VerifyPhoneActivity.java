package com.petrotondar.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bigbangbutton.editcodeview.EditCodeView;
import com.petrotondar.R;

public class VerifyPhoneActivity extends AppCompatActivity {
	
	private TextView textViewCode;
	private Button button;
	private TextView textDigit;
	private EditCodeView editCodeView;
	private static final String TAG = "VerifyPhoneActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_verifty_phone);
		
		textViewCode = findViewById(R.id.text_code_send);
		button = findViewById(R.id.button_confirm);
		textDigit=findViewById(R.id.textPhoneDigit);
		editCodeView=findViewById(R.id.edit_verify_code);
		
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		
		String bbbb = bundle.getString("key");

		String digit=getString(R.string.text_4_digit,bbbb );
		textDigit.setText(digit);
		
//		String codeText = getString(R.string.send_over, bundlebbb);
//		textViewCode.setText(codeText);
		
		new CountDownTimer(30000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				textViewCode.setText(getString(R.string.send_over, millisUntilFinished / 1000));
			}
			@Override
			public void onFinish() {
				start();
			}
		}.start();
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int getLength=editCodeView.getCodeLength();
				
				Log.i(TAG, "onClick: "+getLength);
				if (editCodeView.getCodeLength()<4){
					Toast.makeText(VerifyPhoneActivity.this, "لطفا کد را به صورت کامل وارد نمایید", Toast.LENGTH_SHORT).show();
					
				}else {
					
					startActivity(new Intent(VerifyPhoneActivity.this, RegisterActivity.class));
					finish();
				}
			}
		});
	}
}
