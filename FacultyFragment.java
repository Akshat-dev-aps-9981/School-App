package com.aksapps.svmstudentsagar;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.Toast;
import android.widget.LinearLayout;
import com.google.firebase.database.DatabaseError;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import java.util.List;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class FacultyFragment extends Fragment
{
	private RecyclerView csDepartment, mechanicalDepartment, physicsDepartment, chemistryDepartment;
	private LinearLayout csNoData, mechanicalNoData, physicsNoData, chemistryNoData;
	private List<TeacherData> list1, list2, list3, list4;
	private DatabaseReference databaseReference, dbRef;
	private TeacherAdapter adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_faculty, container, false);
		
		csDepartment = view.findViewById(R.id.csDepartment);
		mechanicalDepartment = view.findViewById(R.id.mechanicalDepartment);
		physicsDepartment = view.findViewById(R.id.physicsDepartment);
		chemistryDepartment = view.findViewById(R.id.chemistryDepartment);
		
		csNoData = view.findViewById(R.id.csNoData);
		mechanicalNoData = view.findViewById(R.id.mechanicalNoData);
		physicsNoData = view.findViewById(R.id.physicsNoData);
		chemistryNoData = view.findViewById(R.id.chemistryNoData);
		
		databaseReference = FirebaseDatabase.getInstance().getReference().child("Teacher");
		
		
		csDepartment();
		mechanicalDepartment();
		physicsDepartment();
		chemistryDepartment();
		
		return view;
	}
	
	private void csDepartment()
			{
				dbRef = databaseReference.child("Computer Science");
				dbRef.addValueEventListener(new ValueEventListener()
						{
							@Override
							public void onDataChange(DataSnapshot dataSnapshot)
									{
										list1 = new ArrayList<>();
										if(!dataSnapshot.exists())
												{
													csNoData.setVisibility(View.VISIBLE);
													csDepartment.setVisibility(View.GONE);
												}
										else 
												{
													csNoData.setVisibility(View.GONE);
													csDepartment.setVisibility(View.VISIBLE);
													
													for(DataSnapshot snapshot : dataSnapshot.getChildren())
															{
																TeacherData data = snapshot.getValue(TeacherData.class);
																list1.add(data);
															}
															
													csDepartment.setHasFixedSize(true);
													csDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
													adapter = new TeacherAdapter(list1, getContext());
													csDepartment.setAdapter(adapter);
												}
									}

							@Override
							public void onCancelled(DatabaseError databaseError)
									{
										Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_LONG).show();
									}
							
						});
			}
			
	private void mechanicalDepartment()
			{
				dbRef = databaseReference.child("Mechanical");
				dbRef.addValueEventListener(new ValueEventListener()
						{
							@Override
							public void onDataChange(DataSnapshot dataSnapshot)
									{
										list2 = new ArrayList<>();
										if(!dataSnapshot.exists())
												{
													mechanicalNoData.setVisibility(View.VISIBLE);
													mechanicalDepartment.setVisibility(View.GONE);
												}
										else 
												{
													mechanicalNoData.setVisibility(View.GONE);
													mechanicalDepartment.setVisibility(View.VISIBLE);
													
													for(DataSnapshot snapshot : dataSnapshot.getChildren())
															{
																TeacherData data = snapshot.getValue(TeacherData.class);
																list2.add(data);
															}
															
													mechanicalDepartment.setHasFixedSize(true);
													mechanicalDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
													adapter = new TeacherAdapter(list2, getContext());
													mechanicalDepartment.setAdapter(adapter);
												}
									}

							@Override
							public void onCancelled(DatabaseError databaseError)
									{
										Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_LONG).show();
									}
							
						});
			}
			
	private void physicsDepartment()
	{
		dbRef = databaseReference.child("Physics");
		dbRef.addValueEventListener(new ValueEventListener()
		{
			@Override
			public void onDataChange(DataSnapshot dataSnapshot)
			{
				list3 = new ArrayList<>();
				if(!dataSnapshot.exists())
				{
					physicsNoData.setVisibility(View.VISIBLE);
					physicsDepartment.setVisibility(View.GONE);
				}
				else
				{
					physicsNoData.setVisibility(View.GONE);
					physicsDepartment.setVisibility(View.VISIBLE);
					
					for(DataSnapshot snapshot : dataSnapshot.getChildren())
					{
						TeacherData data = snapshot.getValue(TeacherData.class);
						list3.add(data);
					}
					
					physicsDepartment.setHasFixedSize(true);
					physicsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
					adapter = new TeacherAdapter(list3, getContext());
					physicsDepartment.setAdapter(adapter);
				}
			}
			
			@Override
			public void onCancelled(DatabaseError databaseError)
			{
				Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_LONG).show();
			}
			
		});
	}
	
	private void chemistryDepartment()
	{
		dbRef = databaseReference.child("Chemistry");
		dbRef.addValueEventListener(new ValueEventListener()
		{
			@Override
			public void onDataChange(DataSnapshot dataSnapshot)
			{
				list4 = new ArrayList<>();
				if(!dataSnapshot.exists())
				{
					chemistryNoData.setVisibility(View.VISIBLE);
					chemistryDepartment.setVisibility(View.GONE);
				}
				else
				{
					chemistryNoData.setVisibility(View.GONE);
					chemistryDepartment.setVisibility(View.VISIBLE);
					
					for(DataSnapshot snapshot : dataSnapshot.getChildren())
					{
						TeacherData data = snapshot.getValue(TeacherData.class);
						list4.add(data);
					}
					
					chemistryDepartment.setHasFixedSize(true);
					chemistryDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
					adapter = new TeacherAdapter(list4, getContext());
					chemistryDepartment.setAdapter(adapter);
				}
			}
			
			@Override
			public void onCancelled(DatabaseError databaseError)
			{
				Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_LONG).show();
			}
			
		});
	}
}