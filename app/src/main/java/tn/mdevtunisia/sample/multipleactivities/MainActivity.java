package tn.mdevtunisia.sample.multipleactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etLogin, etPassword;
    Button btnValider;
    private String mLogin, mPassword;

    private static String LOGIN = "android";
    private static String PASSWORD = "root";

    public static final String LOGIN_KEY = "login";
    public static final String PASSWORD_KEY = "password";


    public static final int REQUEST_CODE = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        etLogin = (EditText) findViewById(R.id.et_login);
        etPassword = (EditText) findViewById(R.id.et_password);

        btnValider = (Button) findViewById(R.id.btn_valider);
        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLogin = etLogin.getText().toString();
                mPassword = etPassword.getText().toString();

                if (mLogin.equalsIgnoreCase(LOGIN) && mPassword.equalsIgnoreCase(PASSWORD)){
                    Intent intent = new Intent(MainActivity.this, VoteActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putString(LOGIN_KEY, mLogin);
                    bundle.putString(PASSWORD, mPassword);
                    intent.putExtra("bundle", bundle);

                    //startActivity(intent);
                    startActivityForResult(intent, REQUEST_CODE);
                } else {
                    Toast.makeText(MainActivity.this, "Erreur", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK){

            String value = data.getStringExtra(VoteActivity.RATE_KEY);
            Toast.makeText(this, "rate value = "+value, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
