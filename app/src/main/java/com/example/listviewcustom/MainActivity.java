package com.example.listviewcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    public class Product{
        private String name;
        private int price;


        public Product(String name, int price){
            this.name = name;
            this.price = price;
        }
    }

    public static final String NAME = "name";

    private ListView lvProduct;

    private String nameProduct[] = {"Remera", "Buzo", "Pantalon", "Zapatillas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Product p1 = new Product("Remera", 5000);
        Product p2 = new Product("Buzo", 7000);
        Product p3 = new Product("Pantalon", 8000);
        Product p4 = new Product("Zapatillas", 11000);
        Product listProduct[] = {p1, p2, p3, p4};

        lvProduct = (ListView) findViewById(R.id.lv_product);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nameProduct);
        lvProduct.setAdapter(adapter);

        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                    String message = lvProduct.getItemAtPosition(position).toString();
                String message = "Producto: " + listProduct[position].name + " Precio: " + listProduct[position].price;
//                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra(NAME, message);
                    startActivity(intent);
            }
        });
    }
}