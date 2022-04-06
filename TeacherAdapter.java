package com.aksapps.svmstudentsagar;

import android.view.LayoutInflater;
import com.aksapps.svmstudentsagar.R;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.aksapps.svmstudentsagar.TeacherAdapter.TeacherViewAdapter;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewAdapter>
{
	private List<TeacherData> list;
	private Context context;
	
	public TeacherAdapter(List<TeacherData> list, Context context)
			{
				this.list = list;
				this.context = context;
			}
	
	@NonNull
	@Override
	public TeacherViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
	{
		View view = LayoutInflater.from(context).inflate(R.layout.faculty_item_layout, parent, false);
	    return new TeacherViewAdapter(view);
	}

	@Override
	public void onBindViewHolder(@NonNull TeacherViewAdapter holder, int position)
	{
		TeacherData item = list.get(position);
		holder.name.setText(item.getName());
		holder.email.setText(item.getEmail());
		holder.phoneNumber.setText(item.getPhoneNumber());
		
		try {
				Glide.with(context).load(item.getImage()).placeholder(R.drawable.profile).into(holder.imageView);
			//	Picasso.get().load(item.getImage()).into(holder.imageView);
			}
		catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}

	@Override
	public int getItemCount()
	{
	    return list.size();
	}
	
	
	public class TeacherViewAdapter extends RecyclerView.ViewHolder
	{
		private TextView name, email, phoneNumber;
		private ImageView imageView;
		
		public TeacherViewAdapter(@NonNull View itemView)
				{
					super(itemView);
					name = itemView.findViewById(R.id.teacherName);
					email = itemView.findViewById(R.id.teacherEmail);
					phoneNumber = itemView.findViewById(R.id.teacherPhoneNumber);
					imageView = itemView.findViewById(R.id.teacherImage);
					
				}
	}
}