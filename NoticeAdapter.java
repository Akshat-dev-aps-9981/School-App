package com.aksapps.svmstudentsagar;

import com.aksapps.svmstudentsagar.R;
import android.content.Context;
import android.content.DialogInterface;
import androidx.cardview.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.aksapps.svmstudentsagar.NoticeAdapter.NoticeViewAdapter;
import com.aksapps.svmstudentsagar.NoticeData;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewAdapter>
{
	private Context context;
	private ArrayList<NoticeData> list;
	
	public NoticeAdapter(Context context, ArrayList<NoticeData> list)
			{
				this.context = context;
				this.list = list;
			}
	
	@NonNull
	@Override
	public NoticeViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
	{
		View view = LayoutInflater.from(context).inflate(R.layout.newsfeed_item_layout, parent, false);
	    return new NoticeViewAdapter(view);
	}

	@Override
	public void onBindViewHolder(@NonNull NoticeViewAdapter holder, int position)
	{
		final NoticeData currentItem = list.get(position);
		
		holder.noticeTitle.setText(currentItem.getTitle());
		holder.date.setText(currentItem.getDate());
		holder.time.setText(currentItem.getTime());
		
		try 
			{
				if(currentItem.getImage() != null)
						{
						//	Glide.with(context).load(currentItem.getImage()).into(holder.noticeImage);
							Picasso.get().load(currentItem.getImage()).into(holder.noticeImage);
							holder.noticeImage.setVisibility(View.VISIBLE);
							holder.imagecard.setVisibility(View.VISIBLE);
						}
				else if(currentItem.getImage().equals(""))
						{
							holder.noticeImage.setVisibility(View.GONE);
						}
			}
		catch(Exception e)
				{
					e.printStackTrace();
				}
				
	/*	holder.deleteNoticeBtn.setOnClickListener(new View.OnClickListener()
				{
					@Override
					public void onClick(View view)
							{
								AlertDialog.Builder builder = new AlertDialog.Builder(context);
								builder.setTitle("Attention!");
								builder.setMessage("Are you sure that you want to delete this notice?");
								builder.setCancelable(true);
								builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
										{
											@Override
											public void onClick(DialogInterface dialogInterface, int i)
													{
														DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Notice");
														databaseReference.child(currentItem.getKey()).removeValue()
														.addOnCompleteListener(new OnCompleteListener<Void>()
															{
																@Override
																public void onComplete(Task<Void> task)
																		{
																			Toast.makeText(context, "Notice deleted successfully.", Toast.LENGTH_SHORT).show();
																		}
											
															}).addOnFailureListener(new OnFailureListener()
																		{
																			@Override
																			public void onFailure(Exception e)
																					{
																						Toast.makeText(context, "Notice failed to delete. Excepton: " + e, Toast.LENGTH_LONG).show();
																					}
														
																		});
													
														notifyItemRemoved(position);
													}
											
										});
								builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
										{
											@Override
											public void onClick(DialogInterface dialogInterface, int i)
													{
														dialogInterface.cancel();
													}
											
										});
										
								AlertDialog dialog = null;
								try 
									{
										dialog = builder.create();
									}
								catch(Exception e)
										{
											e.printStackTrace();
										}
								if(dialog != null)
										dialog.show();
							}
					
				});	*/
	}

	@Override
	public int getItemCount()
	{
	    return list.size();
	}
	
	public class NoticeViewAdapter extends RecyclerView.ViewHolder
	{
		CircleImageView noticeProfile;
		TextView noticeSender, noticeTitle, date, time;
	//	MaterialButton deleteNoticeBtn;
		ImageView noticeImage;
		CardView imagecard;
		
		public NoticeViewAdapter(@NonNull View itemView)
				{
					super(itemView);
					noticeProfile = itemView.findViewById(R.id.noticeProfile);
					noticeSender = itemView.findViewById(R.id.noticeSender);
					noticeTitle = itemView.findViewById(R.id.noticeTitle);
				//	deleteNoticeBtn = itemView.findViewById(R.id.noticeBtn);
					noticeImage = itemView.findViewById(R.id.noticeImage);
					imagecard = itemView.findViewById(R.id.imagecard);
					
					date = itemView.findViewById(R.id.date);
					time = itemView.findViewById(R.id.time);
				}
	
	}
}