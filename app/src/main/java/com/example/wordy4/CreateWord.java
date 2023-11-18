package com.example.wordy4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class CreateWord extends AppCompatActivity {
    Button addButt;
    Button goBack;
    EditText addedWord;
    boolean wordAlreadyIn;
    View.OnClickListener adding = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String checkWord = String.valueOf(addedWord.getText());
            String actualCheckWord = checkWord.toLowerCase();
            if (actualCheckWord.isEmpty() == false) {
                if (isAlpha(actualCheckWord) == true) {
                    if (actualCheckWord.length() == 5){

                        addedWord.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        addItemIfNotExists(actualCheckWord);
                    }
                    else{
                        addedWord.setBackgroundColor(Color.parseColor("#800080"));
                    }
                }
                else{
                    addedWord.setBackgroundColor(Color.parseColor("#800080"));
                }
            }
            else{
                addedWord.setBackgroundColor(Color.parseColor("#800080"));
            }
        }
    };
    View.OnClickListener backing = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent lPlay = new Intent(CreateWord.this, MainActivity.class);
            startActivity(lPlay);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_word);
        addedWord = findViewById(R.id.EditWord);

        addButt = findViewById(R.id.addButton);
        addButt.setOnClickListener(adding);

        goBack = findViewById(R.id.goBackButt);
        goBack.setOnClickListener(backing);
    }
    public boolean isAlpha(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }
    private void addItemIfNotExists(String newItem) {
        DatabaseReference itemsRef = FirebaseDatabase.getInstance().getReference().child("words");
        // Check if the item already exists in the database
        itemsRef.orderByValue().equalTo(newItem).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!dataSnapshot.exists()) {
                    MainActivity.DR.child("words").push().setValue(newItem.toLowerCase());

                    Toast.makeText(getApplicationContext(), "Data Added", Toast.LENGTH_SHORT).show();
                } else {
                    // Item already exists in the database
                    Toast.makeText(getApplicationContext(), "Duplicate", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors
            }
        });
    }

}