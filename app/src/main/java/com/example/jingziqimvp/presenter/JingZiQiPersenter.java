package com.example.jingziqimvp.presenter;

import android.view.View;

import com.example.jingziqimvp.model.Board;
import com.example.jingziqimvp.model.Player;
import com.example.jingziqimvp.view.IMainView;

/**
 * @author bsm
 * @name jingziqimvp
 * @class name：com.example.jingziqimvp.presenter
 * @class describe
 * @time 2020/3/19 11:03
 */
public class JingZiQiPersenter {

    private Board model;
    private IMainView iMainView;

    public JingZiQiPersenter(IMainView iMainView) {
        this.iMainView = iMainView;
        model = new Board();
    }

    public void onButtonSelect(int row, int col){
        Player playerThatMoved = model.mark(row,col);
        if(playerThatMoved !=null){
            iMainView.setButtonTest(row,col,playerThatMoved.toString());
            if(model.getWiner()!=null){
                iMainView.showWinner(playerThatMoved.toString());
            }
        }
    }

    public void onResetSellected(){
        model.restart();
        iMainView.clearWinnerDisplay();
        iMainView.clearButton();
    }

}
