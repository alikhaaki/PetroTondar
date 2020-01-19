package com.petrotondar.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import q.rorbin.badgeview.QBadgeView;
import ss.com.bannerslider.Slider;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.petrotondar.adapter.AdapterMain;
import com.petrotondar.helper.ImageLoadService;
import com.petrotondar.model.Model;
import com.petrotondar.R;
import com.petrotondar.adapter.SlideAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
	
	private ImageView imageNotification;
	private ImageView imageChat;
	private Slider slider;
	private RecyclerView recyclerView;
	private AdapterMain adapterMain;
	private List<Model> list;
	private Model model;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		imageNotification = findViewById(R.id.image_notification);
		imageChat = findViewById(R.id.image_chat);
		slider = findViewById(R.id.slider);
		
		imageChat.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(HomeActivity.this, "گفتگوها", Toast.LENGTH_SHORT).show();
				
				
			}
		});
		imageNotification.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(HomeActivity.this, "پیام ها", Toast.LENGTH_SHORT).show();
			}
		});
		new QBadgeView(this).setBadgePadding(2, false)
			.bindTarget(imageNotification).setBadgeNumber(2).setBadgeGravity(Gravity.BOTTOM | Gravity.START);
		new QBadgeView(this).setBadgePadding(2, false)
			.bindTarget(imageChat).setBadgeNumber(5).setBadgeGravity(Gravity.BOTTOM | Gravity.END);
		
		Slider.init(new ImageLoadService());
		slider.setAdapter(new SlideAdapter());
		
		recyclerView = findViewById(R.id.recycler_home);
		recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
		list = new ArrayList<>();
		
		model = new Model();
		
		model.setImage(R.drawable.pirahan_square);
		model.setTitle("مزایده پیراهن");
		model.setPrice("از 99 هزار تومان");
		
		list.add(model);
		model = new Model();
		
		model.setImage(R.drawable.shoe);
		model.setTitle("مزایده کفش");
		model.setPrice("از 199 هزار تومان");
		
		list.add(model);
		model = new Model();
		
		model.setImage(R.drawable.eynak);
		model.setTitle("مزایده عینک");
		model.setPrice("از 50 هزار تومان");
		
		list.add(model);
		
		model = new Model();
		model.setImage(R.drawable.saat);
		model.setTitle("مزایده ساعت");
		model.setPrice("از هزار تومان");
		
		list.add(model);
		adapterMain=new AdapterMain(list);
		recyclerView.setAdapter(adapterMain);
	}
}
