package com.aksapps.svmstudentsagar;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;

import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.aksapps.svmstudentsagar.GalleryAdapter;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment
{
	RecyclerView convoRecycler, indRecycler, otherRecycler;
	GalleryAdapter adapter;
	DatabaseReference databaseReference;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_gallery, container, false);
		
		convoRecycler = view.findViewById(R.id.convoRecycler);
		indRecycler = view.findViewById(R.id.indRecycler);
		otherRecycler = view.findViewById(R.id.otherRecycler);
		
		databaseReference = FirebaseDatabase.getInstance().getReference().child("Gallery");
		
		getConvoImage();
		getIndImage();
		getOtherImage();
		
		return view;
	}
	
	private void getConvoImage()
			{
				databaseReference.child("Convocation").addValueEventListener(new ValueEventListener()
						{
							private List<String> imageList = new ArrayList<>();
							
							@Override
							public void onDataChange(@NonNull DataSnapshot dataSnapshot)
									{
										for(DataSnapshot snapshot : dataSnapshot.getChildren())
												{
													String data = snapshot.getValue().toString();
													imageList.add(data);
												}
												
										adapter = new GalleryAdapter(getContext(), imageList);
										convoRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
										convoRecycler.setAdapter(adapter);
										
									}

							@Override
							public void onCancelled(@NonNull DatabaseError databaseError)
									{
										Toast.makeText(getContext(), "An error occured. Error: " + databaseError.getMessage(), Toast.LENGTH_LONG).show();
									}
							
						});
			}
			
	private void getIndImage()
			{
				databaseReference.child("Independance Day").addValueEventListener(new ValueEventListener()
						{
							private List<String> imageList = new ArrayList<>();
							
							@Override
							public void onDataChange(@NonNull DataSnapshot dataSnapshot)
									{
										for(DataSnapshot snapshot : dataSnapshot.getChildren())
												{
													String data = (String) snapshot.getValue();
													imageList.add(data);
												}
												
										adapter = new GalleryAdapter(getContext(), imageList);
										indRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
										indRecycler.setAdapter(adapter);
										
									}

							@Override
							public void onCancelled(@NonNull DatabaseError databaseError)
									{
										Toast.makeText(getContext(), "An error occured. Error: " + databaseError.getMessage(), Toast.LENGTH_LONG).show();
									}
							
						});
			}
			
	private void getOtherImage()
			{
				databaseReference.child("Other Events").addValueEventListener(new ValueEventListener()
						{
							private List<String> imageList = new ArrayList<>();
							
							@Override
							public void onDataChange(@NonNull DataSnapshot dataSnapshot)
									{
										for(DataSnapshot snapshot : dataSnapshot.getChildren())
												{
													String data = (String) snapshot.getValue();
													imageList.add(data);
												}
												
										adapter = new GalleryAdapter(getContext(), imageList);
										otherRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
										otherRecycler.setAdapter(adapter);
										
									}

							@Override
							public void onCancelled(@NonNull DatabaseError databaseError)
									{
										Toast.makeText(getContext(), "An error occured. Error: " + databaseError.getMessage(), Toast.LENGTH_LONG).show();
									}
							
						});
			}
}