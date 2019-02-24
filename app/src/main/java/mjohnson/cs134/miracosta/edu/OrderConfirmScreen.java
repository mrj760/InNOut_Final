package mjohnson.cs134.miracosta.edu;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import mjohnson.cs134.miracosta.edu.Order.Order;

public class OrderConfirmScreen extends AppCompatActivity {


    ListView orderListView;
    ArrayList<String> orderItems;
    ArrayAdapter<String> adapter;

    private TextView subTotal;
    private TextView tax;
    private TextView total;
    private Button placeOrder;
    DecimalFormat df = new DecimalFormat("0.00");

    Order o;
    int dd;
    int cb;
    int ff;
    int sh;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm_screen);



        Intent intent = getIntent();


        o = intent.getParcelableExtra("order");

        // updates price totals
        o.toString();


        subTotal = findViewById(R.id.subTotalAmt);
        subTotal.setText("$" + df.format(o.getSubTotal()));
        tax = findViewById(R.id.taxAmt);
        tax.setText("$" + df.format(o.getTax()));
        total = findViewById(R.id.totalAmt);
        total.setText("$" + df.format(o.getTotal()));



        placeOrder = findViewById(R.id.placeOrderBtn);
        orderListView = findViewById(R.id._dynamic_orderList);
        orderItems = new ArrayList<>();

        dd = o.getDoubleDoubleQuant();
        cb = o.getCheeseburgerQuant();
        ff = o.getFryQuant();
        sh = o.getShakeQuant();



        orderItems.add("Your Order: ");







        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, orderItems);
        orderListView.setAdapter(adapter);

        for (int i =0; i < o.getTotalItems()+1; i++) {
            if (i < dd)
                adapter.add(o.getDoubleDouble(i).toString());
            else if (i < dd+cb)
                adapter.add(o.getCheeseburger(i-dd).toString());
            else if ( i < dd+cb+ff)
                adapter.add(o.getFrenchFries(i-dd-cb).toString());
            else if (i < dd+cb+ff+sh)
                adapter.add(o.getShake(i-dd-cb-ff).toString());
            else
                if (o.getSmallDrinks()+o.getMediumDrinks()+o.getLargeDrinks() > 0)
                    adapter.add(o.drinksToString());
        }





        orderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {
                sendItem(position);

            }
        });




    }


    public Intent secretIntent;

    public void sendItem(int position) {

        secretIntent = new Intent(OrderConfirmScreen.this, SecretMenu.class);


        secretIntent.putExtra("order", o);

        if (position<=0)
            return;
        else if (position <= dd) {
            secretIntent.putExtra("itemType", "doubleDouble");
            secretIntent.putExtra("item", position);
           startActivity(secretIntent);
           this.finish();
        }
        else if (position <= dd+cb) {
            secretIntent.putExtra("itemType", "cheeseburger");
            secretIntent.putExtra("item", position-dd);
            startActivity(secretIntent);
            this.finish();
        }
        else if ( position <= dd+cb+ff) {
            secretIntent.putExtra("itemType", "frenchFries");
            secretIntent.putExtra("item", position-dd-cb);
            startActivity(secretIntent);
            this.finish();
        }
        else if (position <= dd+cb+ff+sh) {
            secretIntent.putExtra("itemType", "shake");
            secretIntent.putExtra("item", position-dd-cb-ff);
            startActivity(secretIntent);
            this.finish();
        }
        // else it's a fountain drink and those ain't got anything secret
        else
        {return;}
    }

    Intent placeOrderI;

    public void placeOrder(View v) {
        placeOrderI = new Intent(OrderConfirmScreen.this, OrderPlaced.class);
        placeOrderI.putExtra("order", o);
        startActivity(placeOrderI);
        this.finish();
    }


}
