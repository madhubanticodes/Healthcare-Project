package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Yash Rathore", "Hospital Address : Vinobapuri", "Exp : 7yrs", "Contact : 9867541234", "500"},
                    {"Doctor Name : Tanvi Nagpal", "Hospital Address : Gole Marg", "Exp : 5yrs", "Contact : 9412981132", "800"},
                    {"Doctor Name : Chhavi Garg", "Hospital Address : Ring Road", "Exp : 11yrs", "Contact : 9904311267", "900"},
                    {"Doctor Name : Mahendra S", "Hospital Address : Amar Colony", "Exp : 6yrs", "Contact : 8875607812", "400"},
                    {"Doctor Name : Vidyut Rathee", "Hospital Address : Lajpat Nagar", "Exp : 15yrs", "Contact : 7734987120", "1000"},
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Tania Bhalla", "Hospital Address : Faridabad", "Exp : 5yrs", "Contact : 9867541234", "700"},
                    {"Doctor Name : Keshav S", "Hospital Address : Mandir Marg", "Exp : 7yrs", "Contact : 9412981132", "400"},
                    {"Doctor Name : Alok Saharia", "Hospital Address : Juneja Street", "Exp : 9yrs", "Contact : 9904311267", "800"},
                    {"Doctor Name : Tanu Garia", "Hospital Address : Chirag Delhi", "Exp : 6yrs", "Contact : 8875607812", "900"},
                    {"Doctor Name : Komal Yadav", "Hospital Address : CPr", "Exp : 5yrs", "Contact : 7734987120", "400"},
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Mahipal Singh", "Hospital Address : Palk Sreet", "Exp : 7yrs", "Contact : 9867541234", "600"},
                    {"Doctor Name : Indu Bhosle", "Hospital Address : Sabi Gali", "Exp : 5yrs", "Contact : 9412981132", "800"},
                    {"Doctor Name : Usha Arora", "Hospital Address : Ring Road", "Exp : 11yrs", "Contact : 9904311267", "900"},
                    {"Doctor Name : Kavita Mitra", "Hospital Address : Amar Colony", "Exp : 6yrs", "Contact : 8875607812", "800"},
                    {"Doctor Name : Joan Mathew", "Hospital Address : Kamla Nagar", "Exp : 15yrs", "Contact : 7734987120", "1000"},
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Utpal Yadav", "Hospital Address : Vinobapuri", "Exp : 8yrs", "Contact : 9412345671", "500"},
                    {"Doctor Name : Tanvi Nagpal", "Hospital Address : Gole Marg", "Exp : 5yrs", "Contact : 9412981132", "800"},
                    {"Doctor Name : Chhavi Garg", "Hospital Address : Ring Road", "Exp : 11yrs", "Contact : 9904311267", "900"},
                    {"Doctor Name : Mahendra S", "Hospital Address : Amar Colony", "Exp : 6yrs", "Contact : 8875607812", "400"},
                    {"Doctor Name : Vidyut Rathee", "Hospital Address : Lajpat Nagar", "Exp : 15yrs", "Contact : 7734987120", "1000"},
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Tanvi Radhakrishnan", "Hospital Address : Palika Road", "Exp : 7yrs", "Contact : 9867541234", "500"},
                    {"Doctor Name : Amar Jyoti", "Hospital Address : Gole Marg", "Exp : 15yrs", "Contact : 9412983488", "600"},
                    {"Doctor Name : Chitra Murmu", "Hospital Address : Alishan Sthal", "Exp : 2yrs", "Contact : 9004061362", "850"},
                    {"Doctor Name : Gyawni Singh", "Hospital Address : Noida", "Exp : 5yrs", "Contact : 98126120865", "900"},
                    {"Doctor Name : Gaurav Khetrapal", "Hospital Address : Sector 65", "Exp : 8yrs", "Contact : 9824886427", "950"},
            };
    TextView tv;
    Button btn;
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String,String> item;
    String[][] doctor_details = {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.DDBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
            if(title.compareTo("Dentist")==0)
        doctor_details = doctor_details3;
        else
            if(title.compareTo("Surgeon")==0)
                doctor_details = doctor_details4;
            else
                doctor_details = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));

            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Consultation Fees: "+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

    }
}
