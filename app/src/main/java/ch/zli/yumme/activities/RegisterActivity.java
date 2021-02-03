package ch.zli.yumme.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

import ch.zli.yumme.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private EditText etEmail;
    private EditText etPassword;
    private Button register;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        etEmail = findViewById(R.id.regEmail);
        etPassword = findViewById(R.id.regPassword);
        register = findViewById(R.id.create);
        back = findViewById(R.id.back);

        register.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.create:
                if (!etEmail.getText().toString().equals("") && !etPassword.getText().toString().equals("")) {
                    mAuth.createUserWithEmailAndPassword(etEmail.getText().toString(), etPassword.getText().toString())
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    System.out.println("Registered");
                                    Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                                    startActivity(intent);
                                } else {
                                    FirebaseAuthException e = (FirebaseAuthException ) task.getException();
                                    Toast.makeText(RegisterActivity.this, "Failed Registration: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(RegisterActivity.this, "Email and password can't be empty", Toast.LENGTH_SHORT).show();
                }

            case R.id.back:
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            default:
                break;
        }
    }
}