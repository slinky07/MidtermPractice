package com.slinky.midtermpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    StoreLogic store = StoreLogic.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initIds();
        setCheckoutListener();
    }

/*================================ listener method ================================*/

    /**
     * Checkout Button listener
     */
    private void setCheckoutListener() {
        checkOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Log.d("mainActivity", "insideListener");

            store.totalGateway(milkCB, milkED, store.milk);
            store.totalGateway(eggCB, eggED, store.egg);
            store.totalGateway(beefCB, beefED, store.beef);
            store.totalGateway(sodaCB, sodaED, store.soda);
            store.totalGateway(biscuitCB, biscuitEd, store.biscuits);
            store.totalGateway(fruitCB, fruitED, store.fruits);
            store.totalGateway(vegesCB, vegesED, store.veges);

            String str = String.valueOf(store.getTotal());
            valueTV.setText(""); // erase previous amount
            valueTV.setText(str);
            store.setTotal(0);
            }
        });
    }

/*================================ init methods && IDs ================================*/
    private void initIds() {
        milkED = findViewById(R.id.milkED);
        eggED = findViewById(R.id.eggED);
        beefED = findViewById(R.id.beefED);
        sodaED = findViewById(R.id.sodaED);
        biscuitEd = findViewById(R.id.biscuitED);
        fruitED = findViewById(R.id.fruitsED);
        vegesED = findViewById(R.id.vegesED);

        milkCB = findViewById(R.id.milkCB);
        eggCB = findViewById(R.id.eggCB);
        beefCB = findViewById(R.id.beefCB);
        sodaCB = findViewById(R.id.sodaCB);
        biscuitCB = findViewById(R.id.biscuitCB);
        fruitCB = findViewById(R.id.fruitsCB);
        vegesCB = findViewById(R.id.vegesCB);

        checkOutBtn = findViewById(R.id.checkoutBtn);
        valueTV = findViewById(R.id.valueID);
    }


    Button checkOutBtn;
    TextView valueTV;

    EditText milkED;
    EditText eggED;
    EditText beefED;
    EditText sodaED;
    EditText biscuitEd;
    EditText fruitED;
    EditText vegesED;

    CheckBox milkCB;
    CheckBox eggCB;
    CheckBox beefCB;
    CheckBox sodaCB;
    CheckBox biscuitCB;
    CheckBox fruitCB;
    CheckBox vegesCB;
}