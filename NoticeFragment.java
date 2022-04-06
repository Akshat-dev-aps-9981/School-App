package com.aksapps.svmstudentsagar;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.firebase.database.DatabaseError;
import com.aksapps.svmstudentsagar.NoticeData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.aksapps.svmstudentsagar.NoticeAdapter;
import androidx.fragment.app.Fragment;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;

public class NoticeFragment extends Fragment
{
	private RecyclerView noticeRecycler;
	private ProgressBar progressBar;
	private ArrayList<NoticeData> list;
	private NoticeAdapter adapter;
	
	private DatabaseReference databaseReference;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_notice, container, false);
		
		noticeRecycler = view.findViewById(R.id.noticeRecycler);
		progressBar = view.findViewById(R.id.progressBar);
		
		databaseReference = FirebaseDatabase.getInstance().getReference().child("Notice");
		
		noticeRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
		noticeRecycler.setHasFixedSize(true);
		
		getNotice();
		
		return view;
	}
	private void getNotice()
			{
				databaseReference.addValueEventListener(new ValueEventListener()
						{
							@Override
							public void onDataChange(@NonNull DataSnapshot dataSnapshot)
									{
										list = new ArrayList<>();
										for(DataSnapshot snapshot : dataSnapshot.getChildren())
												{
													NoticeData data = snapshot.getValue(NoticeData.class);
													list.add(data);
												}
										
										adapter = new NoticeAdapter(getContext(), list);
										adapter.notifyDataSetChanged();
										progressBar.setVisibility(View.GONE);
										noticeRecycler.setAdapter(adapter);
									}

							@Override
							public void onCancelled(@NonNull DatabaseError databaseError)
									{
										progressBar.setVisibility(View.GONE);
										Toast.makeText(getContext(), "Error while fetching data. Error: " + databaseError.getMessage(), Toast.LENGTH_LONG).show();
									}
							
						});
			}
}