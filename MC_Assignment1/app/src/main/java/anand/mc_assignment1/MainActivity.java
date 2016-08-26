package anand.mc_assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button correct_incorrect, next, hint, cheat;
    TextView number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random r = new Random();
        number= (TextView)findViewById(R.id.num);
        int n = r.nextInt(1000);
        number.setText(String.valueOf(n));
        addListenerOnButton();
    }
    boolean Isprime(int n)
    {
        int i, flag=0;
        for(i=2;i<=n/2;++i)
        {
            if(n%i == 0)
            {
                 flag = 1;
                break;
            }
        }
        if(flag == 0)
        {
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void sendMessage1(View view) {
        Intent intent = new Intent(this, Display.class);
        startActivity(intent);

    }
    public void sendMessage2(View view) {
        Intent intent = new Intent(this, Show_Cheat.class);
        startActivity(intent);

    }
    private void addListenerOnButton()
    {
        correct_incorrect= (Button)findViewById(R.id.button);

        next= (Button)findViewById(R.id.button3);
        hint = (Button)findViewById(R.id.button2);
        cheat = (Button)findViewById(R.id.button4);
        correct_incorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = number.getText().toString();
                if(Isprime(Integer.parseInt(text))) {
                    Toast.makeText(getApplicationContext(), "Given Number is a Prime number", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Given Number is not a Prime number", Toast.LENGTH_LONG).show();
                }
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int n = r.nextInt(1000);
                number= (TextView)findViewById(R.id.num);
                number.setText(String.valueOf(n));
            }
        });
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage1(v);
            }
        });
        cheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage2(v);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
