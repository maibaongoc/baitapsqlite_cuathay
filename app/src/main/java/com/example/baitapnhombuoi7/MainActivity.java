package com.example.baitapnhombuoi7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.baitapnhombuoi7.adapter.ProductAdapter;
import com.example.baitapnhombuoi7.dao.ProductDAO;
import com.example.baitapnhombuoi7.model.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton= findViewById(R.id.floatingActionButton);
        CustomeAlertDialog customeAlertDialog= new CustomeAlertDialog(this);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                customeAlertDialog.show();
            }
        });
        recyclerView=findViewById(R.id.recyclerView);
        //hàm lấy danh sách product
        ProductDAO productDAO = new ProductDAO(this);
        List<Product> productList= productDAO.GetAll();
        //đổ dữ liệu lên productAdapter
        ProductAdapter productAdapter = new ProductAdapter(productList);
        //gán dữ liệu vào RecyclerView
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}