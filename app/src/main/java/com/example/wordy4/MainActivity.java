package com.example.wordy4;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.wordy4.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private ActivityMainBinding binding;
    //ArrayList<String> =
    private String WORD;
    FirebaseDatabase FD;
    static DatabaseReference DR;
    Button clearText;
    Button resetText;
    Button createButt;
    View.OnClickListener clear = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            clearAllEditTexts();
        }
    };
    View.OnClickListener reset = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getRandomStringFromFirebase("words");
            clearAllEditTexts();
        }
    };
    View.OnClickListener create = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent lCreate = new Intent(MainActivity.this, CreateWord.class);
            startActivity(lCreate);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getRandomStringFromFirebase("words");
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        keepPassingFocus();

        binding.edt15.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() == 1) {
                    validateRow(
                            binding.edt11,
                            binding.edt12,
                            binding.edt13,
                            binding.edt14,
                            binding.edt15
                    );
                }
                binding.edt11.setEnabled(false);
                binding.edt12.setEnabled(false);
                binding.edt13.setEnabled(false);
                binding.edt14.setEnabled(false);
                binding.edt15.setEnabled(false);
            }
        });
        binding.edt25.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() == 1) {
                    validateRow(
                            binding.edt21,
                            binding.edt22,
                            binding.edt23,
                            binding.edt24,
                            binding.edt25
                    );
                }
                binding.edt21.setEnabled(false);
                binding.edt22.setEnabled(false);
                binding.edt23.setEnabled(false);
                binding.edt24.setEnabled(false);
                binding.edt25.setEnabled(false);
            }
        });
        binding.edt35.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() == 1) {
                    validateRow(
                            binding.edt31,
                            binding.edt32,
                            binding.edt33,
                            binding.edt34,
                            binding.edt35
                    );
                }
                binding.edt31.setEnabled(false);
                binding.edt32.setEnabled(false);
                binding.edt33.setEnabled(false);
                binding.edt34.setEnabled(false);
                binding.edt35.setEnabled(false);
            }
        });
        binding.edt45.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() == 1) {
                    validateRow(
                            binding.edt41,
                            binding.edt42,
                            binding.edt43,
                            binding.edt44,
                            binding.edt45
                    );
                }
                binding.edt41.setEnabled(false);
                binding.edt42.setEnabled(false);
                binding.edt43.setEnabled(false);
                binding.edt44.setEnabled(false);
                binding.edt45.setEnabled(false);
            }
        });
        binding.edt55.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() == 1) {
                    validateRow(
                            binding.edt51,
                            binding.edt52,
                            binding.edt53,
                            binding.edt54,
                            binding.edt55
                    );
                }
                binding.edt51.setEnabled(false);
                binding.edt52.setEnabled(false);
                binding.edt53.setEnabled(false);
                binding.edt54.setEnabled(false);
                binding.edt55.setEnabled(false);
            }
        });
        binding.edt65.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() == 1) {
                    validateRow(
                            binding.edt61,
                            binding.edt62,
                            binding.edt63,
                            binding.edt64,
                            binding.edt65
                    );
                }
                binding.edt61.setEnabled(false);
                binding.edt62.setEnabled(false);
                binding.edt63.setEnabled(false);
                binding.edt64.setEnabled(false);
                binding.edt65.setEnabled(false);
            }
        });
        DR = FD.getInstance().getReference();
        clearText = findViewById(R.id.ClearButton);
        clearText.setOnClickListener(clear);

        resetText = findViewById(R.id.resetButton);
        resetText.setOnClickListener(reset);

        createButt = findViewById(R.id.CreateButton);
        createButt.setOnClickListener(create);



    }
    private void makeGameInactive() {
        // Disabling all EditTexts to make the game inactive.
        binding.edt11.setEnabled(false);
        binding.edt12.setEnabled(false);
        binding.edt13.setEnabled(false);
        binding.edt14.setEnabled(false);
        binding.edt15.setEnabled(false);
        binding.edt21.setEnabled(false);
        binding.edt22.setEnabled(false);
        binding.edt23.setEnabled(false);
        binding.edt24.setEnabled(false);
        binding.edt25.setEnabled(false);
        binding.edt31.setEnabled(false);
        binding.edt32.setEnabled(false);
        binding.edt33.setEnabled(false);
        binding.edt34.setEnabled(false);
        binding.edt35.setEnabled(false);
        binding.edt41.setEnabled(false);
        binding.edt42.setEnabled(false);
        binding.edt43.setEnabled(false);
        binding.edt44.setEnabled(false);
        binding.edt45.setEnabled(false);
        binding.edt51.setEnabled(false);
        binding.edt52.setEnabled(false);
        binding.edt53.setEnabled(false);
        binding.edt54.setEnabled(false);
        binding.edt55.setEnabled(false);
        binding.edt61.setEnabled(false);
        binding.edt62.setEnabled(false);
        binding.edt63.setEnabled(false);
        binding.edt64.setEnabled(false);
        binding.edt65.setEnabled(false);
    }
    private void validateRow(
            EditText edt1,
            EditText edt2,
            EditText edt3,
            EditText edt4,
            EditText edt5
    ) {
        String edt1Txt = edt1.getText().toString();
        String edt2Txt = edt2.getText().toString();
        String edt3Txt = edt3.getText().toString();
        String edt4Txt = edt4.getText().toString();
        String edt5Txt = edt5.getText().toString();

        String w1 = String.valueOf(WORD.charAt(0));
        String w2 = String.valueOf(WORD.charAt(1));
        String w3 = String.valueOf(WORD.charAt(2));
        String w4 = String.valueOf(WORD.charAt(3));
        String w5 = String.valueOf(WORD.charAt(4));

        if (edt1Txt.equals(w2) || edt1Txt.equals(w3) || edt1Txt.equals(w4) || edt1Txt.equals(w5)) {
            edt1.setBackgroundColor(Color.parseColor("#ffff00"));
        }
        if (edt2Txt.equals(w1) || edt2Txt.equals(w3) || edt2Txt.equals(w4) || edt2Txt.equals(w5)) {
            edt2.setBackgroundColor(Color.parseColor("#ffff00"));
        }
        if (edt3Txt.equals(w1) || edt3Txt.equals(w2) || edt3Txt.equals(w4) || edt3Txt.equals(w5)) {
            edt3.setBackgroundColor(Color.parseColor("#ffff00"));
        }
        if (edt4Txt.equals(w1) || edt4Txt.equals(w2) || edt4Txt.equals(w3) || edt4Txt.equals(w5)) {
            edt4.setBackgroundColor(Color.parseColor("#ffff00"));
        }
        if (edt5Txt.equals(w1) || edt5Txt.equals(w2) || edt5Txt.equals(w3) || edt5Txt.equals(w4)) {
            edt5.setBackgroundColor(Color.parseColor("#ffff00"));
        }

        if (edt1Txt.equals(w1)) {
            edt1.setBackgroundColor(Color.parseColor("#33cc33"));
        }
        if (edt2Txt.equals(w2)) {
            edt2.setBackgroundColor(Color.parseColor("#33cc33"));
        }
        if (edt3Txt.equals(w3)) {
            edt3.setBackgroundColor(Color.parseColor("#33cc33"));
        }
        if (edt4Txt.equals(w4)) {
            edt4.setBackgroundColor(Color.parseColor("#33cc33"));
        }
        if (edt5Txt.equals(w5)) {
            edt5.setBackgroundColor(Color.parseColor("#33cc33"));
        }

        if (edt1Txt.equals(w1) && edt2Txt.equals(w2) && edt3Txt.equals(w3) && edt4Txt.equals(w4) && edt5Txt.equals(w5)) {
            binding.winText.setText("YAY YOU WON!");
            binding.winText.setVisibility(View.VISIBLE);
            makeGameInactive();
            Toast.makeText(
                    getApplicationContext(),
                    "YAY!!!! YOU GOT IT RIGHT",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        if (edt5.getId() == R.id.edt_65) {
            binding.winText.setText("OH NO YOU DIDN'T WIN");
            binding.winText.setVisibility(View.VISIBLE);
            makeGameInactive();
            Toast.makeText(
                    getApplicationContext(),
                    "Oh no! You got it Wrong",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
    private void keepPassingFocus() {
        passFocusToNextEdt(binding.edt11, binding.edt12);
        passFocusToNextEdt(binding.edt12, binding.edt13);
        passFocusToNextEdt(binding.edt13, binding.edt14);
        passFocusToNextEdt(binding.edt14, binding.edt15);
        passFocusToNextEdt(binding.edt15, binding.edt21);
        passFocusToNextEdt(binding.edt21, binding.edt22);
        passFocusToNextEdt(binding.edt22, binding.edt23);
        passFocusToNextEdt(binding.edt23, binding.edt24);
        passFocusToNextEdt(binding.edt24, binding.edt25);
        passFocusToNextEdt(binding.edt25, binding.edt31);
        passFocusToNextEdt(binding.edt31, binding.edt32);
        passFocusToNextEdt(binding.edt32, binding.edt33);
        passFocusToNextEdt(binding.edt33, binding.edt34);
        passFocusToNextEdt(binding.edt34, binding.edt35);
        passFocusToNextEdt(binding.edt35, binding.edt41);
        passFocusToNextEdt(binding.edt41, binding.edt42);
        passFocusToNextEdt(binding.edt42, binding.edt43);
        passFocusToNextEdt(binding.edt43, binding.edt44);
        passFocusToNextEdt(binding.edt44, binding.edt45);
        passFocusToNextEdt(binding.edt45, binding.edt51);
        passFocusToNextEdt(binding.edt51, binding.edt52);
        passFocusToNextEdt(binding.edt52, binding.edt53);
        passFocusToNextEdt(binding.edt53, binding.edt54);
        passFocusToNextEdt(binding.edt54, binding.edt55);
        passFocusToNextEdt(binding.edt55, binding.edt61);
        passFocusToNextEdt(binding.edt61, binding.edt62);
        passFocusToNextEdt(binding.edt62, binding.edt63);
        passFocusToNextEdt(binding.edt63, binding.edt64);
        passFocusToNextEdt(binding.edt64, binding.edt65);
    }
    private void passFocusToNextEdt(EditText edt1, EditText edt2) {
        edt1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() == 1) {
                    edt2.requestFocus();
                }
            }
        });
    }
    private void clearAllEditTexts() {
        binding.edt11.setText("");
        binding.edt12.setText("");
        binding.edt13.setText("");
        binding.edt14.setText("");
        binding.edt15.setText("");
        binding.edt21.setText("");
        binding.edt22.setText("");
        binding.edt23.setText("");
        binding.edt24.setText("");
        binding.edt25.setText("");
        binding.edt31.setText("");
        binding.edt32.setText("");
        binding.edt33.setText("");
        binding.edt34.setText("");
        binding.edt35.setText("");
        binding.edt41.setText("");
        binding.edt42.setText("");
        binding.edt43.setText("");
        binding.edt44.setText("");
        binding.edt45.setText("");
        binding.edt51.setText("");
        binding.edt52.setText("");
        binding.edt53.setText("");
        binding.edt54.setText("");
        binding.edt55.setText("");
        binding.edt61.setText("");
        binding.edt62.setText("");
        binding.edt63.setText("");
        binding.edt64.setText("");
        binding.edt65.setText("");
        binding.edt11.setEnabled(true);
        binding.edt12.setEnabled(true);
        binding.edt13.setEnabled(true);
        binding.edt14.setEnabled(true);
        binding.edt15.setEnabled(true);
        binding.edt21.setEnabled(true);
        binding.edt22.setEnabled(true);
        binding.edt23.setEnabled(true);
        binding.edt24.setEnabled(true);
        binding.edt25.setEnabled(true);
        binding.edt31.setEnabled(true);
        binding.edt32.setEnabled(true);
        binding.edt33.setEnabled(true);
        binding.edt34.setEnabled(true);
        binding.edt35.setEnabled(true);
        binding.edt41.setEnabled(true);
        binding.edt42.setEnabled(true);
        binding.edt43.setEnabled(true);
        binding.edt44.setEnabled(true);
        binding.edt45.setEnabled(true);
        binding.edt51.setEnabled(true);
        binding.edt52.setEnabled(true);
        binding.edt53.setEnabled(true);
        binding.edt54.setEnabled(true);
        binding.edt61.setEnabled(true);
        binding.edt62.setEnabled(true);
        binding.edt63.setEnabled(true);
        binding.edt64.setEnabled(true);
        binding.edt65.setEnabled(true);
        binding.edt11.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt12.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt13.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt14.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt15.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt21.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt22.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt23.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt24.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt25.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt31.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt32.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt33.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt34.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt35.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt41.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt42.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt43.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt44.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt45.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt51.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt52.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt53.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt54.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt55.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt61.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt62.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt63.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt64.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.edt65.setBackgroundColor(Color.parseColor("#FFFFFF"));
        binding.winText.setText("");
    }
    private void getRandomStringFromFirebase(String node) {
        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference().child(node);

        databaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<String> stringList = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // Assuming each child node contains a string value
                    String stringValue = snapshot.getValue(String.class);
                    stringList.add(stringValue);
                }

                // Get a random string from the list
                if (!stringList.isEmpty()) {
                    int randomIndex = (int) (Math.random() * stringList.size());
                    String randomString = stringList.get(randomIndex);

                    // Use the randomString retrieved
                    WORD = randomString;
                    // or perform any operation with the randomString
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors
            }
        });
    }



}
