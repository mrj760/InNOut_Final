package mjohnson.cs134.miracosta.edu;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import mjohnson.cs134.miracosta.edu.Order.Order;

public class OrderActivity extends AppCompatActivity {

    /** These are the text views that will be set at runtime (price and quantity) */
    private TextView doubleDoublePriceTV;
    private TextView doubleDoubleQuantTV;
    private TextView cheeseburgerPriceTV;
    private TextView cheeseBurgerQuantTV;
    private TextView frenchFriesPriceTV;
    private TextView frenchFriesQuantTV;
    private TextView shakePriceTV;
    private TextView shakeQuantTV;
    private TextView smallDrinkPriceTV;
    private TextView smallDrinkQuantTV;
    private TextView mediumDrinkPriceTV;
    private TextView mediumDrinkQuantTV;
    private TextView largeDrinkPriceTV;
    private TextView largeDrinkQuantTV;

    /** These are the buttons that add and remove objects from our Order objects arrayLists */
    private Button addDoubleDouble;
    private Button removeDoubleDouble;
    private Button addCheeseburger;
    private Button removeCheeseburger;
    private Button addFry;
    private Button removeFry;
    private Button addShake;
    private Button removeShake;
    private Button addSmallDrink;
    private Button removeSmallDrink;
    private Button addMediumDrink;
    private Button removeMediumDrink;
    private Button addLargeDrink;
    private Button removeLargeDrink;
    private Button confirmOrder;

    private RadioGroup flavor;


    Order o = new Order();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        DecimalFormat df = new DecimalFormat("0.00");
        Intent intent = getIntent();




        doubleDoublePriceTV=findViewById(R.id.doubleDoublePriceTV);
        doubleDoubleQuantTV = findViewById(R.id.doubleDoubleQuantTV);
        cheeseburgerPriceTV=findViewById(R.id.cheeseburgerPriceTV);
        cheeseBurgerQuantTV = findViewById(R.id.cheeseburgerQuantTV);
        frenchFriesPriceTV=findViewById(R.id.frenchFriesPriceTV);
        frenchFriesQuantTV = findViewById(R.id.frenchFriesQuantTV);
        shakePriceTV=findViewById(R.id.shakePriceTV);
        shakeQuantTV = findViewById(R.id.shakeQuantTV);
        smallDrinkPriceTV=findViewById(R.id.smallDrinkPriceTV);
        smallDrinkQuantTV = findViewById(R.id.smallDrinkQuantTV);
        mediumDrinkPriceTV=findViewById(R.id.mediumDrinkPriceTV);
        mediumDrinkQuantTV = findViewById(R.id.mediumDrinkQuantTV);
        largeDrinkPriceTV=findViewById(R.id.largeDrinkPriceTV);
        largeDrinkQuantTV = findViewById(R.id.largeDrinkQuantTV);

        addDoubleDouble=findViewById(R.id.addDoubleDoubleBtn);
        removeDoubleDouble=findViewById(R.id.removeDoubleDoubleButton);
        addCheeseburger =findViewById(R.id.addCheeseburgerBtn);
        removeCheeseburger =findViewById(R.id.removeCheeseburgerBtn);
        addFry=findViewById(R.id.addFryBtn);
        removeFry=findViewById(R.id.removeFryBtn);
        addShake=findViewById(R.id.addShakeBtn);
        removeShake=findViewById(R.id.removeShakeBtn);
        addSmallDrink=findViewById(R.id.addSmallDrinkBtn);
        removeSmallDrink=findViewById(R.id.removeSmallDrinkBtn);
        addMediumDrink=findViewById(R.id.addMedDrinkBtn);
        removeMediumDrink=findViewById(R.id.removeMedDrinkBtn);
        addLargeDrink=findViewById(R.id.addLargeDrinkBtn);
        removeLargeDrink=findViewById(R.id.removeLargeDrinkBtn);
        confirmOrder=findViewById(R.id.confirmOrderBtn);
        flavor = findViewById(R.id.flavor);



        doubleDoublePriceTV.setText("$" + df.format(o.getDoubleDoublePrice()));
        cheeseburgerPriceTV.setText("$" + df.format(o.getCheeseBurgerPrice()));
        frenchFriesPriceTV.setText("$" + df.format(o.getFrenchFriesPrice()));
        shakePriceTV.setText("$" + df.format(o.getShakePrice()));
        smallDrinkPriceTV.setText("$" + df.format(o.getSmallDrinkPrice()));
        mediumDrinkPriceTV.setText("$" + df.format(o.getMediumDrinkPrice()));
        largeDrinkPriceTV.setText("$" + df.format(o.getLargeDrinkPrice()));







    }




    /** Button functions below */

    public void addDoubleDouble(View v) {o.addDoubleDouble(); doubleDoubleQuantTV.setText(o.getDoubleDoubleQuant() + "");}
    public void addCheeseburger(View v) {o.addCheeseburger(); cheeseBurgerQuantTV.setText(o.getCheeseburgerQuant() +"");}
    public void addFry(View v) {o.addFrenchFries(); frenchFriesQuantTV.setText(o.getFryQuant() +"");}
    public void addShake(View v) {

        switch (flavor.getCheckedRadioButtonId())
        {

            case(R.id.vanilla) :
                Toast.makeText(this, R.string.vanilla_added,
                        Toast.LENGTH_SHORT).show();
                o.addShake(1);
                break;
            case(R.id.chocolate) :
                Toast.makeText(this, R.string.chocolate_added,
                        Toast.LENGTH_SHORT).show();
                o.addShake(2);
                break;
            case(R.id.strawberry) :
                Toast.makeText(this, R.string.strawberry_added,
                        Toast.LENGTH_SHORT).show();
                o.addShake(3);
                break;
            default:
                break;
        }

        shakeQuantTV.setText(o.getShakeQuant() +"");

    }
    public void addSmallDrink (View v) {o.addSmallDrink(); smallDrinkQuantTV.setText(o.getSmallDrinks() +"");}
    public void addMediumDrink (View v) {o.addMediumDrink(); mediumDrinkQuantTV.setText(o.getMediumDrinks() + "");}
    public void addLargeDrink (View v) {o.addLargeDrink(); largeDrinkQuantTV.setText(o.getLargeDrinks() + "");}



    /** these simply remove the last in the array since this isn't the secret menu */


    public void removeDoubleDouble (View v) {
            o.removeDoubleDouble(o.getDoubleDoubleQuant()-1);
            doubleDoubleQuantTV.setText(o.getDoubleDoubleQuant() + "");
    }
    public void removeCheeseburger (View v) {
            o.removeCheeseburger(o.getCheeseburgerQuant()-1);
            cheeseBurgerQuantTV.setText(o.getCheeseburgerQuant() + "");
    }
    public void removeFry (View v) {
            o.removeFrenchFries(o.getFryQuant()-1);
            frenchFriesQuantTV.setText(o.getFryQuant() + "");
    }

    public void removeShake (View v) {

            // if there are shakes in the order
            if (o.getShakeQuant()>=1) {

                // get the shake flavor of the last element of the arrayList (1: vanilla, 2: choc, 3: strawberry)
                    // and toast it
                int f = o.getShake(o.getShakeQuant()-1).getFlavor();
                // toast to let user know which flavor was removed
                switch (f) {
                    case (1):
                        Toast.makeText(this, R.string.vanilla_removed,
                                Toast.LENGTH_SHORT).show();
                        break;
                    case (2):
                        Toast.makeText(this, R.string.chocolate_removed,
                                Toast.LENGTH_SHORT).show();
                        break;
                    case (3):
                        Toast.makeText(this, R.string.strawberry_removed,
                                Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }


                // remove it
                o.removeShake(o.getShakeQuant()-1);
                shakeQuantTV.setText(o.getShakeQuant() + "");
            }

            // if there are no shakes in the order
            else
                shakeQuantTV.setText("0");

    }
    public void removeSmallDrink (View v) {o.removeSmallDrink(); smallDrinkQuantTV.setText(o.getSmallDrinks() +"");}
    public void removeMediumDrink (View v) {o.removeMediumDrink(); mediumDrinkQuantTV.setText(o.getMediumDrinks() + "");}
    public void removeLargeDrink (View v) {o.removeLargeDrink(); largeDrinkQuantTV.setText(o.getLargeDrinks() + "");}



    /** getting ready to confirm the order (and hit the secret menu ) */

    public void confirmOrder(View v) {
        if (o.getTotalItems()<=0)
        {
            Toast.makeText(this, R.string.no_food_ordered,
                    Toast.LENGTH_SHORT).show();
            return;
        }

        Intent i = new Intent(this, OrderConfirmScreen.class);

        i.putExtra("order", o);

        startActivity(i);
        this.finish();
    }



}
