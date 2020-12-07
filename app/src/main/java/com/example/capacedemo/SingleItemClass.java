package com.example.capacedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SingleItemClass extends AppCompatActivity {

    ImageView emp_img_id;
  //  String image_ul;
    TextView p_text_name_id;
    TextView p_text_id_id;
    TextView text_catogry_id;
    TextView text_address_id;
    TextView text_description_id;
    TextView text_contact_id;
    TextView text_empid_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_item_class);

        getSupportActionBar().hide();

        emp_img_id  = findViewById(R.id.emp_img_id);
        p_text_name_id  = findViewById(R.id.p_text_name_id);
        p_text_id_id  = findViewById(R.id.p_text_id_id);
        text_catogry_id  = findViewById(R.id.text_catogry_id);
        text_address_id  = findViewById(R.id.text_address_id);
        text_description_id  = findViewById(R.id.text_description_id);
        text_contact_id  = findViewById(R.id.text_contact_id);
        text_empid_id  = findViewById(R.id.text_empid_id);

//         Serializable bundle = getIntent().getSerializableExtra("mypojo");
//        List<JSONResponse.Datum> array = new ArrayList<>();
//        array.add((JSONResponse.Datum) bundle);
//        System.out.println("alsidfkjajshdflashdf+++++++++++"+getIntent().getSerializableExtra("mypojo"));
//        String id = ((JSONResponse.Datum) array).getId();
//        String name = ((JSONResponse.Datum) array).getName();
//        String image = ((JSONResponse.Datum) array).getImage();
//        String category = ((JSONResponse.Datum) array).getCategory();
//        String empid = ((JSONResponse.Datum) array).getEmpcode();
//        String descrription = ((JSONResponse.Datum) array).getDescription();
//        String phone = ((JSONResponse.Datum) array).getContact();
//        String address = ((JSONResponse.Datum) array).getAddress();


        Bundle bundle = getIntent().getExtras();
        String id = bundle.getString("id");
        String name = bundle.getString("name");
        String image = bundle.getString("image");
        String category = bundle.getString("category");
        String empid = bundle.getString("empid");
        String descrription = bundle.getString("description");
        String phone = bundle.getString("phone");
        String address = bundle.getString("address");

        RequestOptions requestOptions = new RequestOptions()
                .transform(new RoundedCorners(20));

        Glide.with(getApplicationContext())
                .load(image)
                .apply(requestOptions)
                .into(emp_img_id);

        p_text_id_id.setText("ID : "+id);
        p_text_name_id.setText("Name : "+name);
        text_catogry_id.setText("Category : "+category);
        text_address_id.setText("Emp ID : "+empid);
        text_description_id.setText("Description : "+descrription);
        text_contact_id.setText("Phone : "+phone);
        text_empid_id.setText("Address : "+address);




    }
}