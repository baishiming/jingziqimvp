package com.example.jingziqimvp.view;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.jingziqimvp.R;
import com.example.jingziqimvp.model.Board;
import com.example.jingziqimvp.model.Player;
import com.example.jingziqimvp.presenter.JingZiQiPersenter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements IMainView {

    private static String TAG = MainActivity.class.getName();

    private ViewGroup buttonGroup;
    private View winnerPlayerViewGroup;
    private TextView winnerPlayerLabel;



    private JingZiQiPersenter persenter = new JingZiQiPersenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        winnerPlayerLabel = (TextView)findViewById(R.id.winnerPlayerLabel);
        winnerPlayerViewGroup = findViewById(R.id.winnerPlayerViewGroup);
        buttonGroup = (ViewGroup)findViewById(R.id.buttonGroup);
        persenter.onResetSellected();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_jingziqi,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_reset){
            persenter.onResetSellected();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private Button currentButton ;
    public void onCellClicked(View v){
        currentButton = (Button) v;
        String tag = currentButton.getTag().toString();
        int row = Integer.valueOf(tag.substring(0,1));
        int col = Integer.valueOf(tag.substring(1,2));
        Log.e(TAG,"click row =="+row + ", col == "+ col);

        persenter.onButtonSelect(row,col);


    }


    @Override
    public void showWinner(String winnerString) {
        winnerPlayerLabel.setText(winnerString);
        winnerPlayerViewGroup.setVisibility(View.VISIBLE);
    }

    @Override
    public void clearWinnerDisplay() {
        winnerPlayerViewGroup.setVisibility(View.GONE);
        winnerPlayerLabel.setText("");
    }

    @Override
    public void clearButton() {
        for (int i = 0 ; i < buttonGroup.getChildCount();  i++){
            ((Button)buttonGroup.getChildAt(i)).setText("");
        }
    }

    @Override
    public void setButtonTest(int row, int col, String text) {
        currentButton.setText(text);
    }
}
