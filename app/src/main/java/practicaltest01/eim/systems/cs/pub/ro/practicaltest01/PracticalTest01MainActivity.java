package practicaltest01.eim.systems.cs.pub.ro.practicaltest01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01MainActivity extends AppCompatActivity {
    Button plus;
    Button minus;
    EditText sus;
    EditText jos;
    TextView rezultat;
    Button secondary_activity;
    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);
        plus = (Button) findViewById(R.id.buton_plus);
        plus.setOnClickListener(buttonClickListener);
        minus = (Button) findViewById(R.id.buton_minus);
        minus.setOnClickListener(buttonClickListener);
        sus = (EditText) findViewById(R.id.edittext_sus);
        jos = (EditText) findViewById(R.id.edittext_jos);
        rezultat = (TextView) findViewById(R.id.textview_eticheta);
        secondary_activity = (Button) findViewById(R.id.buton_next_activity);
        secondary_activity.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("sus"))
                sus.setText(savedInstanceState.getString("sus"));
            if (savedInstanceState.containsKey("jos"))
                jos.setText(savedInstanceState.getString("jos"));
            if (savedInstanceState.containsKey("rezultat"))
                rezultat.setText(savedInstanceState.getString("rezultat"));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        if (sus.getText() != null)
            try {
                savedInstanceState.putString("sus", sus.getText().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

        if (jos.getText() != null)
            savedInstanceState.putString("jos", jos.getText().toString());
        if (rezultat.getText() != null)
            savedInstanceState.putString("rezultat", rezultat.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("sus"))
                sus.setText(savedInstanceState.getString("sus"));
            if (savedInstanceState.containsKey("jos"))
                jos.setText(savedInstanceState.getString("jos"));
            if (savedInstanceState.containsKey("rezultat"))
                rezultat.setText(savedInstanceState.getString("rezultat"));
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK)
                Toast.makeText(this, "Rezultat corect ", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "Rezultat incorect ", Toast.LENGTH_LONG).show();

        }
    }

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int first_nb = 0, second_nb = 0;
            try {
                first_nb = Integer.parseInt(sus.getText().toString());
            }
            catch (Exception e) {
                // rezultat.setText("Invalid first number");
                Toast.makeText(PracticalTest01MainActivity.this, "Invalid first number", Toast.LENGTH_LONG).show();
                return;
            }
            try {
                second_nb = Integer.parseInt(jos.getText().toString());
            }
            catch (Exception e) {
                // rezultat.setText("Invalid second number");
                Toast.makeText(PracticalTest01MainActivity.this, "Invalid second number", Toast.LENGTH_LONG).show();

                return;
            }
            switch(view.getId()) {
                case R.id.buton_plus:
                    int suma = first_nb + second_nb;
                    rezultat.setText(first_nb + " + " + second_nb + " = " + suma);
                    break;
                case R.id.buton_minus:
                    int diferenta = first_nb - second_nb;
                    rezultat.setText(first_nb + " - " + second_nb + " = " + diferenta);
                    break;
                case R.id.buton_next_activity:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02SecondaryActivity.class);
                    String rez = rezultat.getText().toString();
                    intent.putExtra("rezultat", rez);
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
            }
        }

    }




}
