package vn.edu.usth.threadit.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import vn.edu.usth.threadit.R;
import vn.edu.usth.threadit.fragment.ChatFragment;
import vn.edu.usth.threadit.fragment.CreateFragment;
import vn.edu.usth.threadit.fragment.HomeFragment;
import vn.edu.usth.threadit.fragment.ProfileFragment;
import vn.edu.usth.threadit.fragment.UsersFragment;

public class HomeActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    String myuid;
    ActionBar actionBar;
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        actionBar = getSupportActionBar();
        firebaseAuth = FirebaseAuth.getInstance();

        navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(selectedListener);
        actionBar.setTitle("Home");

        // When we open the application first time show home fragment
        HomeFragment fragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment, "");
        fragmentTransaction.commit();
    }

    // Change fragment with bottom nav
    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.nav_home) {
                actionBar.setTitle("Home");
                HomeFragment fragment = new HomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content, fragment, "");
                fragmentTransaction.commit();
                return true;
            } else if (itemId == R.id.nav_profile) {
                actionBar.setTitle("Profile");
                ProfileFragment fragment1 = new ProfileFragment();
                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.content, fragment1);
                fragmentTransaction1.commit();
                return true;
            } else if (itemId == R.id.nav_users) {
                actionBar.setTitle("Users");
                UsersFragment fragment2 = new UsersFragment();
                FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.content, fragment2, "");
                fragmentTransaction2.commit();
                return true;
            } else if (itemId == R.id.nav_chat) {
                actionBar.setTitle("Chats");
                ChatFragment listFragment = new ChatFragment();
                FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction3.replace(R.id.content, listFragment, "");
                fragmentTransaction3.commit();
                return true;
            } else if (itemId == R.id.nav_create) {
                actionBar.setTitle("Add Blogs");
                CreateFragment fragment4 = new CreateFragment();
                FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction4.replace(R.id.content, fragment4, "");
                fragmentTransaction4.commit();
                return true;
            }
            return false;
        }
    };



}