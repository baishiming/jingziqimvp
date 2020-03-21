package com.example.jingziqimvp.view;

/**
 * @author bsm
 * @name jingziqimvp
 * @class name：com.example.jingziqimvp.view
 * @class describe
 * @time 2020/3/19 11:05
 */
public interface IMainView {
    void showWinner(String winnerString);
    void clearWinnerDisplay();
    void clearButton();
    void setButtonTest(int row,int col,String text);



}
