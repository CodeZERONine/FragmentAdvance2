package org.akshanshgusain.fragmentadvance2;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements MyCustomDialog.OnInputListner {
    private Button mOpenDialog;
    public TextView mInputDisplay;
    public String mInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mOpenDialog=(Button)findViewById(R.id.button1);
        mInputDisplay=(TextView)findViewById(R.id.resultTextView);
        mOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//          MyCustomDialog dialog=new MyCustomDialog();
//            dialog.show(getFragmentManager(),"MyCustomDialog");
                MyCustomDialog dialog = new MyCustomDialog();
                dialog.show(getSupportFragmentManager(),"s");

            }
        });
    }
///Interface Method Overriden
    @Override
    public void sendInput(String input) {
    mInputDisplay.setText(input);
    //new MyCustomDialog().getDialog().dismiss();
    }
}
