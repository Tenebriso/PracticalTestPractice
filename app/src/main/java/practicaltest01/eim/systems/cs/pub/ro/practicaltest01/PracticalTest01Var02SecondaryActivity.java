package practicaltest01.eim.systems.cs.pub.ro.practicaltest01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var02SecondaryActivity extends AppCompatActivity {
    TextView rezultat = null;
    Button corect = null;
    Button incorect = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_secondary);
        rezultat = (TextView) findViewById(R.id.rezultat);
        corect = (Button) findViewById(R.id.buton_corect);
        corect.setOnClickListener(buttonClickListener);
        incorect = (Button) findViewById(R.id.buton_incorect);
        incorect.setOnClickListener(buttonClickListener);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("rezultat")) {
            rezultat.setText(intent.getStringExtra("rezultat"));
        }
    }
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.buton_corect:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.buton_incorect:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }
}

