package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Intent.ACTION_SENDTO;

public class MainActivity extends AppCompatActivity {


    int numberOfCoffees=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void submitOrder(View view)
    {
        EditText nameField= (EditText) findViewById(R.id.name_text_field);
        String name=nameField.getText().toString();
       // Log.v("MainActivity","Name:"+name);
        CheckBox whippedCheckBox=(CheckBox) findViewById(R.id.whipped_chechbox);
        boolean haswhippedCheckBox=whippedCheckBox.isChecked();
        CheckBox chocoCheckbox=(CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean isChocoRequired= chocoCheckbox.isChecked();

        //Log.v("MainActivity","Has whipped cream"+haswhippedCheckBox);
        int price=calculatePrice(haswhippedCheckBox, isChocoRequired);
        String priceMsg=createOrderSummary(name,price, haswhippedCheckBox, isChocoRequired);

        Intent intent = new Intent(ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
       // intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just java order for "+name);
       // intent.putExtra(Intent.EXTRA_STREAM, attachment);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        displayMessage(priceMsg);

    }
    int calculatePrice(boolean whippedTopping, boolean chocoToppings)
    {
        int basePrice=5;
        if(whippedTopping)
        {
            basePrice+=1;
        }
        if(chocoToppings)
        {
            basePrice+=2;
        }
        return  numberOfCoffees*basePrice;
    }
    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChoco){
        //String priceMessage = getString(R.string.order_summary_name, name);
        String priceMessage="Name:"+name;
        priceMessage+="\n Quantity:"+ (numberOfCoffees);
        priceMessage+="\n Add whipped cream : "+addWhippedCream;
        priceMessage+="\n Add Chocolate required : "+addChoco;
        priceMessage+="\nTotal is Rs.:"+price;
        priceMessage+="\n Thank You";
        return priceMessage;
    }
    private void display(int number)
    {
        TextView quantityTextView =(TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }
    private void displayMessage(String number)
    {
        TextView quantityTextView =(TextView) findViewById(R.id.price_text_view);
        quantityTextView.setText(""+number);
    }
    private void displayPrice(int number)
    {
        String priceMessage ="Total is :"+(number * 5);
        priceMessage+="\n Thank You";
        TextView priceTextView =(TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(priceMessage);
    }
    public void increment(View view)
    {
        if(numberOfCoffees==100) {
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        numberOfCoffees=numberOfCoffees+1;
        display(numberOfCoffees);
    }

    public void decrement(View view)
    {
        if(numberOfCoffees==1) {
            Toast.makeText(this, "You cannot have less than 0 coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        numberOfCoffees=numberOfCoffees-1;
        display(numberOfCoffees);
    }
}