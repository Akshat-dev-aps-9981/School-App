package com.aksapps.svmstudentsagar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.aksapps.svmstudentsagar.SliderAdapter.SliderViewHolder;
import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderViewHolder>
{
	private int[] images;
	private String[] text;
	
	public SliderAdapter(int[] images, String[] text)
			{
				this.images = images;
				this.text = text;
			}
	
	@Override
	public SliderViewHolder onCreateViewHolder(ViewGroup parent)
			{
				View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item_layout, null);
	 		   return new SliderViewHolder(view);
			}

	@Override
	public void onBindViewHolder(SliderViewHolder viewHolder, int position)
			{
				viewHolder.imageView.setImageResource(images[position]);
					
			//	Glide.with(viewHolder.itemView).load("").into(viewHolder.imageView);
				viewHolder.textView.setText(text[position]);
			/*	viewHolder.itemView.setOnClickListener(new View.OnClickListener()
						{
							@Override
							public void onClick(View view)
									{
										
									}
							
						});	*/
			}
	
	@Override
	public int getCount()
			{
			    return images.length;
			}

	public class SliderViewHolder extends SliderViewAdapter.ViewHolder
	{
		private ImageView imageView;
		private TextView textView;
		
		public SliderViewHolder(View itemView)
				{
					super(itemView);
					imageView = itemView.findViewById(R.id.image);
					textView = itemView.findViewById(R.id.textDecs);
				}
	}
}