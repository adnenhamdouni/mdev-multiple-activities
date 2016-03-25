package tn.mdevtunisia.sample.multipleactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class VoteActivity extends AppCompatActivity {

    private TextView tvLogin;
    private RatingBar rbVote;
    private String mLogin, mRateValue;

    public static final String RATE_KEY = "rate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        tvLogin = (TextView) findViewById(R.id.tv_login);
        rbVote = (RatingBar) findViewById(R.id.rb_vote);

        //firstMethod();
        //secondMethod();
        thirdMethod();

    }

    private void firstMethod(){
        // use it if we need to get String values only
        mLogin = getIntent().getStringExtra(MainActivity.LOGIN_KEY);
        if(mLogin!=null){
            tvLogin.setText(mLogin);
        }
    }

    private void secondMethod(){
        // use it when you send data with putExtra only
        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){
            mLogin = bundle.getString(MainActivity.LOGIN_KEY);
            tvLogin.setText(mLogin);
        }

    }

    private void thirdMethod(){
        Bundle bundle = getIntent().getBundleExtra("bundle");
        if(bundle!=null){
            mLogin = bundle.getString(MainActivity.LOGIN_KEY);
            tvLogin.setText(mLogin);
        }
    }


    @Override
    public void onBackPressed() {

        mRateValue = String.valueOf(rbVote.getProgress());
        Intent data = new Intent();
        data.putExtra(RATE_KEY, mRateValue);
        setResult(RESULT_OK, data);

        super.onBackPressed();
    }

    @Override
    public void finish() {
        super.finish();
    }
}
