package com.example.umerfarooq.office;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";
    private static final int ERROR_DIALOG_REQUEST=9001;
    private RecyclerView recyclerView;
    ProductAdapter adapter;
    List<Product> productList;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(isServicesOk())
        {
            init();
        }
//        context = this;
//        productList= new ArrayList<>();
//        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        productList.add(
//                new Product(
//                        1,
//                        "Apple MacBook Air Core i5 5th Gen - (8 GB/128 GB SSD/Mac OS Sierra)",
//                        "13.3 inch, Silver, 1.35 kg",
//                        4.3,
//                        60000,
//                        R.drawable.macbook));
//
//        productList.add(
//                new Product(
//                        1,
//                        "Dell Inspiron 7000 Core i5 7th Gen - (8 GB/1 TB HDD/Windows 10 Home)",
//                        "14 inch, Gray, 1.659 kg",
//                        4.3,
//                        60000,
//                        R.drawable.dellinspiron));
//
//        productList.add(
//                new Product(
//                        1,
//                        "Microsoft Surface Pro 4 Core m3 6th Gen - (4 GB/128 GB SSD/Windows 10)",
//                        "13.3 inch, Silver, 1.35 kg",
//                        4.3,
//                        60000,
//                        R.drawable.surface));
//        productList.add(
//                new Product(
//                        1,
//                        "Apple MacBook Air Core i5 5th Gen - (8 GB/128 GB SSD/Mac OS Sierra)",
//                        "13.3 inch, Silver, 1.35 kg",
//                        4.3,
//                        60000,
//                        R.drawable.macbook));
//
//        productList.add(
//                new Product(
//                        1,
//                        "Dell Inspiron 7000 Core i5 7th Gen - (8 GB/1 TB HDD/Windows 10 Home)",
//                        "14 inch, Gray, 1.659 kg",
//                        4.3,
//                        60000,
//                        R.drawable.dellinspiron));
//
//        productList.add(
//                new Product(
//                        1,
//                        "Microsoft Surface Pro 4 Core m3 6th Gen - (4 GB/128 GB SSD/Windows 10)",
//                        "13.3 inch, Silver, 1.35 kg",
//                        4.3,
//                        60000,
//                        R.drawable.surface));
//        productList.add(
//                new Product(
//                        1,
//                        "Apple MacBook Air Core i5 5th Gen - (8 GB/128 GB SSD/Mac OS Sierra)",
//                        "13.3 inch, Silver, 1.35 kg",
//                        4.3,
//                        60000,
//                        R.drawable.macbook));
//
//        productList.add(
//                new Product(
//                        1,
//                        "Dell Inspiron 7000 Core i5 7th Gen - (8 GB/1 TB HDD/Windows 10 Home)",
//                        "14 inch, Gray, 1.659 kg",
//                        4.3,
//                        60000,
//                        R.drawable.dellinspiron));
//
//        productList.add(
//                new Product(
//                        1,
//                        "Microsoft Surface Pro 4 Core m3 6th Gen - (4 GB/128 GB SSD/Windows 10)",
//                        "13.3 inch, Silver, 1.35 kg",
//                        4.3,
//                        60000,
//                        R.drawable.surface));
//        productList.add(
//                new Product(
//                        1,
//                        "Apple MacBook Air Core i5 5th Gen - (8 GB/128 GB SSD/Mac OS Sierra)",
//                        "13.3 inch, Silver, 1.35 kg",
//                        4.3,
//                        60000,
//                        R.drawable.macbook));
//
//        productList.add(
//                new Product(
//                        1,
//                        "Dell Inspiron 7000 Core i5 7th Gen - (8 GB/1 TB HDD/Windows 10 Home)",
//                        "14 inch, Gray, 1.659 kg",
//                        4.3,
//                        60000,
//                        R.drawable.dellinspiron));
//
//        productList.add(
//                new Product(
//                        1,
//                        "Microsoft Surface Pro 4 Core m3 6th Gen - (4 GB/128 GB SSD/Windows 10)",
//                        "13.3 inch, Silver, 1.35 kg",
//                        4.3,
//                        60000,
//                        R.drawable.surface));
//
//        //creating recyclerview adapter
//        ProductAdapter adapter = new ProductAdapter(this, productList);
//
//        //setting adapter to recyclerview
//        recyclerView.setAdapter(adapter);
//
//
//
//        recyclerView.addOnItemTouchListener(
//                new RecyclerItemClickListener(this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
//                    @Override public void onItemClick(View view, int position) {
//                        // do whatever
//                        Intent i = new Intent(context , MapsActivity.class);
//                        startActivity(i);
//                    }
//
//                    @Override public void onLongItemClick(View view, int position) {
//                        // do whatever
//                        Toast.makeText(context , "Ohoooooo", Toast.LENGTH_LONG).show();
//
//                    }
//                })
//        );

    }
    public void init() {
        Button btnMap=(Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,MapsActivity.class);
                startActivity(i);
            }
        });
    }
    public boolean isServicesOk() {
        Log.d(TAG,"isServicesOk: checking google services version");
        int available= GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);
        if(available== ConnectionResult.SUCCESS){
            Log.d(TAG,"isServicesOk: Google Play Services is Working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            Log.d(TAG,"isServicesOk: An error occured but we can fix it");
            Dialog dialog=GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this,available,ERROR_DIALOG_REQUEST);
            dialog.show();
        }
        else {
            Toast.makeText(this,"You Cannot make map requests",Toast.LENGTH_SHORT).show();
        }
        return false;
    }


}
