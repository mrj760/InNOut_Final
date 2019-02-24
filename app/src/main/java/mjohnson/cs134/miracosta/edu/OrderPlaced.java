package mjohnson.cs134.miracosta.edu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mjohnson.cs134.miracosta.edu.Order.Order;

public class OrderPlaced extends AppCompatActivity {

    private TextView order;
    private Button orderAnother;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_placed);

        Intent i = getIntent();
        Order o = i.getParcelableExtra("order");

        order = findViewById(R.id.order);
        orderAnother = findViewById(R.id.orderAnother);

        order.setText(o.toString());




    }

    Intent startOver;
    public void orderAnother(View v) {
        startOver = new Intent(OrderPlaced.this, MainActivity.class);
        startActivity(startOver);
    }
}
