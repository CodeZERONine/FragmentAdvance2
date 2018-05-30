package org.akshanshgusain.fragmentadvance2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class MyCustomDialog extends DialogFragment {
    //Creating an interface
    public interface OnInputListner{
          public void sendInput(String input);
    }
    //Create Interface Reference
    private OnInputListner mOnInputListner;

    //Widgets
    private EditText mInput;
    private TextView mActionOK,mActionCancel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.dialog_my_custom,container,false);
        mInput=(EditText)view.findViewById(R.id.input);
        mActionOK=(TextView)view.findViewById(R.id.action_ok);
        mActionCancel=(TextView)view.findViewById(R.id.action_cancel);


        mActionCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        mActionOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=mInput.getText().toString();
                if(!temp.equals("")){
                    //call Interface Method
                    mOnInputListner.sendInput(temp);
                    getDialog().dismiss();
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mOnInputListner = (OnInputListner) getActivity();
        } catch(Exception e){

        }
    }
}
