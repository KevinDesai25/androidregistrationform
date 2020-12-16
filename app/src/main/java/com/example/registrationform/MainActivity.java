package com.example.registrationform;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText Name,Phone,Dob,Email;
    RadioButton Rmale,Rfemale;
    CheckBox Computer,Civil,Chemical;
    Button Submit;
    TextView ans;
    String res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name=findViewById(R.id.Name);
        Phone=findViewById(R.id.Phone);
        Dob=findViewById(R.id.Dob);
        Email=findViewById(R.id.Email);
        Rmale=findViewById(R.id.Rmale);
        Rfemale=findViewById(R.id.Rfemale);
        Computer=findViewById(R.id.Computer);
        Civil=findViewById(R.id.Civil);
        Chemical=findViewById(R.id.Chemical);
        Submit=findViewById(R.id.Submit);
        ans=findViewById(R.id.ans);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dialog function
                showDialog();
            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String S1=Name.getText().toString();

                    if(TextUtils.isEmpty(S1))
                    {
                        Name.setError("Please enter your name!");
                        return;
                    }
                res ="Name :"+S1;

                String S2=Phone.getText().toString();

                if(TextUtils.isEmpty(S2))
                {
                    Phone.setError("Please enter your phone!");
                    return;
                }
                res += "\n Phone Number :"+S2;

                String S3=Dob.getText().toString();
                if(TextUtils.isEmpty(S3))
                {
                    Dob.setError("Please enter your Dob!");
                    return;
                }
                res+= "\n D.O.B :"+S3;

                String S4=Email.getText().toString();
                if(TextUtils.isEmpty(S4))
                {
                    Email.setError("Please enter your Email!");
                    return;
                }
                res+="\n Email :"+S4;

                if((Rmale.isChecked()&&Rfemale.isChecked())==false)
                {
                    Rmale.setError("Please Select Your Gender");
                    return;
                }


                    if (Rmale.isChecked()) {
                        String S5 = Rmale.getText().toString();
                        res += "\n Gender :" + S5;
                    }

                    if (Rfemale.isChecked()) {
                        String S6 = Rfemale.getText().toString();
                        res += "\n Gender :" + S6;
                    }


                if((Computer.isChecked()&&Civil.isChecked())&&(Chemical.isChecked())==false)
                {
                    Computer.setError("Please Select Your Department");
                    return;
                }
                if(Computer.isChecked()) {
                    String S7 = Computer.getText().toString();
                    res+= "\n Department :"+S7;
                }

                if(Civil.isChecked()) {
                    String S8 = Civil.getText().toString();
                    res+= "\n Department :"+S8;
                }

                if(Chemical.isChecked()) {
                    String S9 = Chemical.getText().toString();
                    res+="\n Department :"+S9;
                }

               ans.setText(res);

            }
        });

    }

    //show alret
    void showDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setIcon(R.drawable.ic_dialog);
        builder.setTitle("Confirm");
        builder.setMessage("are you sure ?");

        //builder.setView(R.layout.dialog);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);

                intent.putExtra("user","Raj");
                intent.putExtra("age",29);
                intent.putExtra("isCheked",true);

                startActivity(intent);

            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Nagative Button", Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();

    }

}
