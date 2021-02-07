package com.example.creddemo;

import android.view.View;

public interface MainActivityViewInterface {

    void setUpEmiBottomSheet();
    void hideEmiSheet();
    void showEmiSheet();

    void setUpBankAccountBottomSheet();
    void hideBankAccountSheet();
    void showBankAccountSheet();
    void onEmiProceedClick(View view);
    void onBankAccountClick(View view);
    void onCreditAmountClick(View view);
}
