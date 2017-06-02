package jp.ac.titech.itpro.sdl.activityuser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final static int MYREQCODE = 1234;

    TextView answerView;
    RadioGroup requestGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answerView = (TextView) findViewById(R.id.answer_view);
        requestGroup = (RadioGroup) findViewById(R.id.request_group);
        requestGroup.check(R.id.request_1);
    }

    public void onClickStartButton(View view) {
        String request = null;
        switch (requestGroup.getCheckedRadioButtonId()) {
            case R.id.request_1:
                request = getString(R.string.request_1_text);
                break;
            case R.id.request_2:
                request = getString(R.string.request_2_text);
                break;
            case R.id.request_3:
                request = getString(R.string.request_3_text);
                break;
        }
        Intent intent = new Intent("OKACHIMACHI");
        intent.putExtra("request", request);
        startActivityForResult(intent, MYREQCODE);
    }

    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent data) {
        super.onActivityResult(reqCode, resCode, data);
        switch (reqCode) {
            case MYREQCODE:
                if (resCode == RESULT_OK) {
                    String answer = data.getStringExtra("answer");
                    answerView.setText(answer);
                }
        }
    }
}
