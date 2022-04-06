package com.aksapps.svmstudentsagar;

import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
	private DrawerLayout drawerLayout;
	private BottomNavigationView bottomNavigationView;
	private NavController navController;
	
	private ActionBarDrawerToggle toggle;
	private NavigationView navigationView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		drawerLayout = findViewById(R.id.drawerLayout);
		bottomNavigationView = findViewById(R.id.bottomNavigationView);
		navController = Navigation.findNavController(this, R.id.frame_layout);
		
		navigationView = findViewById(R.id.navigation_view);
		
		toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);
		
		drawerLayout.addDrawerListener(toggle);
		
		toggle.syncState();
		
		Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
		
		navigationView.setNavigationItemSelectedListener(this);
		
		NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
	
	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item)
	{
		if(toggle.onOptionsItemSelected(item))
				{
					return true;
				}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onNavigationItemSelected(@NonNull MenuItem item)
	{
		
				switch (item.getItemId())
						{
							case R.id.navigation_video:
								Toast.makeText(MainActivity.this, "Video Lectures.", Toast.LENGTH_SHORT).show();
								break;
								
							case R.id.navigation_developer:
								Toast.makeText(MainActivity.this, "Developer.", Toast.LENGTH_SHORT).show();
								break;
								
							case R.id.navigation_review:
								Toast.makeText(MainActivity.this, "Rate us please.", Toast.LENGTH_SHORT).show();
								break;
								
							case R.id.navigation_ebook:
								Toast.makeText(MainActivity.this, "Read Ebooks.", Toast.LENGTH_SHORT).show();
								break;
								
							case R.id.navigation_theme:
								Toast.makeText(MainActivity.this, "Select theme.", Toast.LENGTH_SHORT).show();
								break;
							
							case R.id.navigation_share:
								Toast.makeText(MainActivity.this, "Share our app please.", Toast.LENGTH_SHORT).show();
								break;
							
							case R.id.navigation_website:
								Toast.makeText(MainActivity.this, "View our website.", Toast.LENGTH_SHORT).show();
								break;
								
							default :
								Toast.makeText(MainActivity.this, "IDK", Toast.LENGTH_SHORT).show();
								break;
						}
		return true;
	}
}