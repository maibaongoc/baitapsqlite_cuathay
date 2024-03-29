package com.example.baitapnhombuoi7.dao;

import static android.icu.text.MessagePattern.ArgType.SELECT;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.baitapnhombuoi7.database.DBHelper;
import com.example.baitapnhombuoi7.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    DBHelper dbHelper;
    public ProductDAO(Context context)
    {
        dbHelper = new DBHelper(context);
    }
//hàm lấy tất cả các sản phẩm trong product
    public List<Product> GetAll()
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        List<Product> listProduct = new ArrayList<>();
        String query = "SELECT * FROM product";
        Cursor c = db.rawQuery(query, null);
        while (c.moveToNext())
        {
            Product temp = new Product();
            temp.setID(c.getInt(0));
            temp.setName(c.getString(1));
            temp.setImage(c.getString(2));
            temp.setPrice(c.getFloat(3));
            listProduct.add(temp);
        }
        return listProduct;
    }
    //hàm thêm một sản phẩm
    public void Insert(Product p) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
    //c1: sử dụng contentValues
        ContentValues values = new ContentValues();
    // values.put(&quot;id&quot;, p.getID());
        values.put("name", p.getName());
        values.put("image", p.getImage());
        values.put("price", p.getPrice());
        db.insert("product", null, values);
    //c2: sử dụng câu queyry thuần
    }
    //hàm xóa một sản phẩm
    public void Delete(int productId) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //c1: sử dụng delete
        db.delete("product", "id=?", new String[]{String.valueOf(productId)});
    }
    //hàm sửa (cập nhật) một sản phẩm
}
