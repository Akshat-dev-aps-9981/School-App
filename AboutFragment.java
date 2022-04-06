package com.aksapps.svmstudentsagar;

import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.aksapps.svmstudentsagar.BranchAdapter;
import com.aksapps.svmstudentsagar.BranchModel;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment
{
	private ViewPager viewPager;
	private BranchAdapter adapter;
	private List<BranchModel> list;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_about, container, false);
		
		list = new ArrayList<>();
		
		list.add(new BranchModel(R.drawable.ic_math, "Mathematics", "Mathematics Teacher:  Mr. Sunil Gawali.\nPhone Number:	(+91)9981132391."));
		list.add(new BranchModel(R.drawable.ic_bio, "Biology", "Biology Teacher:  Mr. Rahul.\nPhone Number:	(+91)9981132391."));
		list.add(new BranchModel(R.drawable.ic_commerce, "Commerce", "Account Teacher:  Mr. Rahul.\nPhone Number:	(+91)9981132391."));
		list.add(new BranchModel(R.drawable.ic_arts, "Arts", "History Teacher:  Mr. Subhash Maldavadiya.\nPhone Number:	(+91)9981132391."));
		
		adapter = new BranchAdapter(getContext(), list);
		
		viewPager = view.findViewById(R.id.viewPager);
		
		viewPager.setAdapter(adapter);
		
	/*	ImageView imageView = view.findViewById(R.id.image1);
		Glide.with(getContext()).load(Uri.parse("")).into(imageView);	*/
		
		return view;
	}
}