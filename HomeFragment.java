package com.aksapps.svmstudentsagar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.aksapps.svmstudentsagar.SliderAdapter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class HomeFragment extends Fragment
{
	private int[] images;
	private String[] text;
	private SliderAdapter adapter;
	private SliderView sliderView;
	private ImageView map;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_home, container, false);
		
		sliderView = view.findViewById(R.id.sliderView);
		images = new int[] {R.drawable.c1, R.drawable.c2, R.drawable.c3};
		text = new String[] {"First Image", "Second Image", "Third Image"};
		
		adapter = new SliderAdapter(images, text);
		sliderView.setSliderAdapter(adapter);
		sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
		sliderView.setIndicatorAnimation(IndicatorAnimationType.DROP);
		sliderView.startAutoCycle();
		
		map =  view.findViewById(R.id.map);
		
		map.setOnClickListener(new View.OnClickListener()
				{
					@Override
					public void onClick(View view)
							{
								Uri uri = Uri.parse("geo:0, 0?q=Sarasvati Vidya Mandir Agar Malwa");
								Intent intent = new Intent(Intent.ACTION_VIEW, uri);
								intent.setPackage("com.google.android.apps.maps");
								startActivity(intent);
							}
					
				});
		
		return view;
	}
	
}