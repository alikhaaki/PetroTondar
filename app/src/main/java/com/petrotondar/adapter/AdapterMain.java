package com.petrotondar.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.petrotondar.model.Model;
import com.petrotondar.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.HolderMain> {
	private List<Model> list;
	public AdapterMain(List<Model> list) {
		this.list = list;
	}
	@NonNull
	@Override
	public HolderMain onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
		return new HolderMain(v);
	}
	@Override
	public void onBindViewHolder(@NonNull HolderMain holder, int position) {
		holder.Bind(list.get(position));
	}
	@Override
	public int getItemCount() {
		return list.size();
	}
	public class HolderMain extends RecyclerView.ViewHolder {
		private ImageView imageView;
		private TextView textTitle;
		private TextView textPrice;
		public HolderMain(@NonNull View itemView) {
			super(itemView);
			imageView=itemView.findViewById(R.id.image_list);
			textTitle=itemView.findViewById(R.id.text_title_list);
			textPrice=itemView.findViewById(R.id.text_price_list);
		}
		public void Bind(Model model){
			textTitle.setText(model.getTitle());
			textPrice.setText(model.getPrice());
			imageView.setImageResource(model.getImage());
		}
	}
	
}
