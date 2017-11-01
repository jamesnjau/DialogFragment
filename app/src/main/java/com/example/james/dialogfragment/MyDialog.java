package com.example.james.dialogfragment;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by JAMES on 10/31/2017.
 */

public class MyDialog extends DialogFragment implements View.OnClickListener {
    Button yes,no;
    Communicator communicator;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        communicator = (Communicator) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_dialog,null);
        yes = (Button) view.findViewById(R.id.yes);
        no = (Button) view.findViewById(R.id.no);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
       setCancelable(false);
        return  view;

    }

    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.yes)
        {
           dismiss();
            /* Toast.makeText(getActivity(),"Yes button selected",Toast.LENGTH_SHORT).show();*/
           communicator.onDialogMessage("Yes was clicked");
        }
        else
        {
            dismiss();
           /* Toast.makeText(getActivity(),"No button selected",Toast.LENGTH_SHORT).show();*/
            communicator.onDialogMessage("No was clicked");
        }
    }
    interface Communicator
    {
         void onDialogMessage(String message);
    }
}
