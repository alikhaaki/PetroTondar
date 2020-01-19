package com.petrotondar.adapter;

import com.petrotondar.R;

import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class SlideAdapter extends SliderAdapter {
	
	@Override
	public int getItemCount() {
		return 3;
	}
	@Override
	public void onBindImageSlide(int position, ImageSlideViewHolder viewHolder) {
		
		switch (position){
			case 0:
				viewHolder.bindImageSlide(R.drawable.style_banner);
				break;
			case 1:
				viewHolder.bindImageSlide(R.drawable.woman);
				break;
			case 2:
				viewHolder.bindImageSlide(R.drawable.monaghese);
				break;
				
		}
	}
}
