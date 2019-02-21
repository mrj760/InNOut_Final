package mjohnson.cs134.miracosta.edu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.startOrder);



    }

    public void startOrder(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
        this.finish();
    }
}
