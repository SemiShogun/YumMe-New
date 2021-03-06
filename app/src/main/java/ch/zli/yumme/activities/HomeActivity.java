package ch.zli.yumme.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import ch.zli.yumme.R;
import ch.zli.yumme.models.User;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mUser;
    private DatabaseReference refUsers;
    private TextView tvUsername;
    private TextView tvFollowing;
    private TextView tvFollowers;
    private TextView tvRecipes;
    private ImageView profilePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        setNavigationView();

        tvUsername = findViewById(R.id.username);
        tvFollowing = findViewById(R.id.following);
        tvFollowers = findViewById(R.id.followers);
        tvRecipes = findViewById(R.id.recipes);

        profilePicture = findViewById(R.id.profilePicture);

        mFirebaseAuth = FirebaseAuth.getInstance();

        mUser = mFirebaseAuth.getCurrentUser();
        refUsers = FirebaseDatabase.getInstance().getReference().child("users").child(mUser.getUid());

        // Display user name, profile picture, followers, following and amount of recipes
        refUsers.addValueEventListener(new ValueEventListener() {
            // Successfully load user information
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    User user = dataSnapshot.getValue(User.class);
                    System.out.println(user.toString());
                    Picasso.get().load(user.getImage()).into(profilePicture);
                    tvUsername.setText(user.getUsername());
                    tvFollowing.setText(String.valueOf(user.getFollowing()));
                    tvFollowers.setText(String.valueOf(user.getFollowers()));
                    tvRecipes.setText(String.valueOf(user.getRecipes()));
                }
            }

            // Failed to load user information
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Error loading data", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void setNavigationView() {

        drawerLayout = (DrawerLayout) findViewById(R.id.activity_home);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.Open, R.string.Close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView) findViewById(R.id.nv);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                System.out.println("Hello");
                switch (item.getItemId()) {
                    case R.id.home:
                        Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                        intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.add:
                        Toast.makeText(getApplicationContext(), "Add Recipe", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.marketplace:
                        Toast.makeText(getApplicationContext(), "Marketplace", Toast.LENGTH_SHORT).show();
                        intent = new Intent(getApplicationContext(), MarketplaceActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "Wait what did you press lol", Toast.LENGTH_SHORT).show();
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}