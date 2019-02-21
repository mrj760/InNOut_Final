package mjohnson.cs134.miracosta.edu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import mjohnson.cs134.miracosta.edu.Order.Order;

public class OrderConfirmScreen extends AppCompatActivity {


    ListView orderListView;
    ArrayList<String> orderItems;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_order_confirm_screen);

        /** Okay so I know there has to be a way to transfer over a whole object but I have no idea how to do that
         *  and I was kind of hoping I would just be able to without looking into it too much but I saw the words
         *  'bundle' and 'parcelable' and I was like hell nah I'm out so here's the crappy space wasting
         *  workaround */

        Order o = new Order();

        Intent intent = getIntent();

        int doubleDoubleQuant = Integer.parseInt(intent.getStringExtra("doubleDoubleQuant"));
        int cheeseburgerQuant = Integer.parseInt(intent.getStringExtra("cheeseburgerQuant"));
        int fryQuant = Integer.parseInt(intent.getStringExtra("fryQuant"));
        int shakeQuant = Integer.parseInt(intent.getStringExtra("shakeQuant"));
        int smallDrinkQuant = Integer.parseInt(intent.getStringExtra("smallDrinkQuant"));
        int mediumDrinkQuant = Integer.parseInt(intent.getStringExtra("mediumDrinkQuant"));
        int largeDrinkQuant = Integer.parseInt(intent.getStringExtra("largeDrinkQuant"));

        int totalItemsCount = doubleDoubleQuant+cheeseburgerQuant+fryQuant+shakeQuant+smallDrinkQuant+mediumDrinkQuant+largeDrinkQuant;

        /** well this is unprofessional */
        for (int i =0; i<doubleDoubleQuant; i++) {
            o.addDoubleDouble();
        }
        for (int i =0; i<cheeseburgerQuant; i++) {
            o.addCheeseburger();
        }
        for (int i =0; i<fryQuant; i++) {
            o.addFrenchFries();
        }
        for (int i =0; i<shakeQuant; i++) {
            o.addShake();
        }
        for (int i =0; i<smallDrinkQuant; i++) {
            o.addSmallDrink();
        }
        for (int i =0; i<mediumDrinkQuant; i++) {
            o.addMediumDrink();
        }
        for (int i =0; i<largeDrinkQuant; i++) {
            o.addLargeDrink();
        }





        orderListView = findViewById(R.id._dynamic_orderList);
        orderItems = new ArrayList<>();
        orderItems.add("First Item - added on Activity Create");
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, orderItems);
        orderListView.setAdapter(adapter);
        orderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {

            }
        });




    }
}
