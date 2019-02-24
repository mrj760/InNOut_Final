package mjohnson.cs134.miracosta.edu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import mjohnson.cs134.miracosta.edu.Order.Order;

public class SecretMenu extends AppCompatActivity {



    Order o;
    int pos;
    String type;
    private TextView item;
    private Button setAnimalStyle;
    private Switch vanillaSw;
    private Switch chocolateSw;
    private Switch strawberrySw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret_menu);

        Intent intent = getIntent();


        intent.getExtras();
        o = intent.getParcelableExtra("order");
        pos = intent.getIntExtra("item",-1);
        pos--;
        type = intent.getStringExtra("itemType");

        item = findViewById(R.id.item);
        setAnimalStyle = findViewById(R.id.setAnimalStyleBtn);
        vanillaSw = findViewById(R.id.vanillaSwitch);
        chocolateSw = findViewById(R.id.chocolateSwitch);
        strawberrySw = findViewById(R.id.strawberrySwitch);








        /** if vanilla gets checked, add or remove the flavor depending on whether it's checked */
        vanillaSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    // 1 = vanilla, 2 = chocolate, 3 = strawberry
                    o.getShake(pos).addFlavor(1);
                else
                    o.getShake(pos).removeFlavor(1);
                item.setText(o.getShake(pos).toString());
                /** this bit makes it so that if our shake is defaulted back to vanilla in Order.Shake.removeFlavor()
                 *  the vanilla switch will show as checked */
                if (o.getShake(pos).getFlavor()==1)
                    vanillaSw.setChecked(true);


            }
        });
        /** same for chocolate */
        chocolateSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    o.getShake(pos).addFlavor(2);
                else
                    o.getShake(pos).removeFlavor(2);
                item.setText(o.getShake(pos).toString());
                if (o.getShake(pos).getFlavor()==1)
                    vanillaSw.setChecked(true);
            }
        });
        /** strawberry */
        strawberrySw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    o.getShake(pos).addFlavor(3);
                else
                    o.getShake(pos).removeFlavor(3);
                item.setText(o.getShake(pos).toString());
                if (o.getShake(pos).getFlavor()==1)
                    vanillaSw.setChecked(true);
            }
        });





        /** depending on the item type we'll do some different things */

        /** if it's one of these set the layout accordingly */
        if (type.equals("doubleDouble") || type.equals("cheeseburger") || type.equals("frenchFries")) {

            setAnimalStyle.setVisibility(View.VISIBLE);
            vanillaSw.setVisibility(View.INVISIBLE);
            chocolateSw.setVisibility(View.INVISIBLE);
            strawberrySw.setVisibility(View.INVISIBLE);

            /** Here we'll further check what kind of item it is to manipulate the layout more specifically */

            if (type.equals("doubleDouble")) {
                item.setText(o.getDoubleDouble(pos).toString());
                setAnimalStyleBtnText(o.getDoubleDouble(pos).getAnimalStyle());
                setAnimalStyle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setDoubleDoubleAnimalStyle();
                        item.setText(o.getDoubleDouble(pos).toString());
                        setAnimalStyleBtnText(o.getDoubleDouble(pos).getAnimalStyle());
                    }
                });
            }
            else if (type.equals("cheeseburger")) {
                item.setText(o.getCheeseburger(pos).toString());
                setAnimalStyleBtnText(o.getCheeseburger(pos).getAnimalStyle());
                setAnimalStyle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setCheeseburgerAnimalStyle();
                        item.setText(o.getCheeseburger(pos).toString());
                        setAnimalStyleBtnText(o.getCheeseburger(pos).getAnimalStyle());
                    }
                });
            }
            else if (type.equals("frenchFries")) {
                item.setText(o.getFrenchFries(pos).toString());
                setAnimalStyleBtnText(o.getFrenchFries(pos).getAnimalStyle());
                setAnimalStyle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setFrenchFriesAnimalStyle();
                        item.setText(o.getFrenchFries(pos).toString());
                        setAnimalStyleBtnText(o.getFrenchFries(pos).getAnimalStyle());
                    }
                });
            }



        }


        else if  (type.equals("shake")) {
                setAnimalStyle.setVisibility(View.INVISIBLE);
                vanillaSw.setVisibility(View.VISIBLE);
                chocolateSw.setVisibility(View.VISIBLE);
                strawberrySw.setVisibility(View.VISIBLE);
                item.setText(o.getShake(pos).toString());

                boolean [] shakeFlavors = o.getShake(pos).getFlavors();

                if (shakeFlavors[0])
                    vanillaSw.setChecked(true);
                if(shakeFlavors[1])
                    chocolateSw.setChecked(true);
                if(shakeFlavors[2])
                    strawberrySw.setChecked(true);

        }

        else
            System.out.println("check around line 135 in secret Order");



    }

    public void setDoubleDoubleAnimalStyle() {
        o.getDoubleDouble(pos).setAnimalStyle();
    }
    public void setCheeseburgerAnimalStyle() {
        o.getCheeseburger(pos).setAnimalStyle();
    }
    public void setFrenchFriesAnimalStyle() {
        o.getFrenchFries(pos).setAnimalStyle();
    }

    public void setAnimalStyleBtnText (boolean isAnimalStyle)
    {

        if (isAnimalStyle)
            setAnimalStyle.setText(R.string.undo_animal_style);
        else
            setAnimalStyle.setText(R.string.make_animal_style);
    }

    Intent goBack;
    public void close(View v) {
        goBack = new Intent(SecretMenu.this, OrderConfirmScreen.class);
        goBack.putExtra("order", o);
        startActivity(goBack);
        this.finish();
    }
}
