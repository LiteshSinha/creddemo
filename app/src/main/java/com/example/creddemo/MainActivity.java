package com.example.creddemo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dualcores.swagpoints.SwagPoints;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.card.MaterialCardView;

import net.igenius.customcheckbox.CustomCheckBox;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.android.material.bottomsheet.BottomSheetBehavior.from;

public class MainActivity extends AppCompatActivity implements MainActivityViewInterface {

    BottomSheetBehavior emiLayoutBottomSheet;
    BottomSheetBehavior bankLayoutBottomSheet;
    @BindView(R.id.card_emi)
    CoordinatorLayout cardEmi;
    @BindView(R.id.card_bank_acc)
    MaterialCardView cardBankAcc;
    @BindView(R.id.tv_emi_proceed)
    TextView tvEmiProceed;
    @BindView(R.id.iv_emi_down_arrow)
    ImageView ivEmiDownArrow;
    @BindView(R.id.tv_bank_acc_proceed)
    TextView tvBankAccProceed;
    @BindView(R.id.iv_close)
    ImageView ivClose;
    @BindView(R.id.iv_help)
    ImageView ivHelp;
    @BindView(R.id.tv_credit_heading)
    TextView tvCreditHeading;
    @BindView(R.id.tv_credit_sub_heading)
    TextView tvCreditSubHeading;
    @BindView(R.id.tv_amount)
    TextView tvAmount;
    @BindView(R.id.seekbar_credit)
    SwagPoints seekbarCredit;
    @BindView(R.id.card_credit_limit)
    CardView cardCreditLimit;
    @BindView(R.id.iv_account_down_arrow)
    ImageView ivAccountDownArrow;
    @BindView(R.id.ll_expanded_credit_view)
    LinearLayout llExpandedCreditView;
    @BindView(R.id.tv_collapsed_heading)
    TextView tvCollapsedHeading;
    @BindView(R.id.tv_collapsed_credit_amount)
    TextView tvCollapsedCreditAmount;
    @BindView(R.id.iv_credit_amount_down_arrow)
    ImageView ivCreditAmountDownArrow;
    @BindView(R.id.rl_collapsed_view)
    RelativeLayout rlCollapsedView;
    @BindView(R.id.emi_expanded_view)
    LinearLayout emiExpandedView;
    @BindView(R.id.emi_collapsed_view)
    RelativeLayout emiCollapsedView;
    @BindView(R.id.emi_hide_view)
    RelativeLayout emiHideView;
    @BindView(R.id.rv_emi_plans)
    RecyclerView rvEmiPlans;
    @BindView(R.id.tv_emi_head)
    TextView tvEmiHead;
    @BindView(R.id.tv_emi_amount)
    TextView tvEmiAmount;
    @BindView(R.id.bank_collapsed_view)
    RelativeLayout bankCollapsedView;
    @BindView(R.id.bank_expanded_view)
    LinearLayout bankExpandedView;
    @BindView(R.id.iv_bank_logo)
    ImageView ivBankLogo;
    @BindView(R.id.tv_bank_name)
    TextView tvBankName;
    @BindView(R.id.tv_bank_acc_no)
    TextView tvBankAccNo;
    @BindView(R.id.cb_plan)
    CustomCheckBox cbPlan;
    @BindView(R.id.emi_bg)
    MaterialCardView emiBg;
    @BindView(R.id.bankbg)
    MaterialCardView bankbg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUpEmiBottomSheet();
        setUpBankAccountBottomSheet();

        seekbarCredit.setOnSwagPointsChangeListener(new SwagPoints.OnSwagPointsChangeListener() {
            @Override
            public void onPointsChanged(SwagPoints swagPoints, int points, boolean fromUser) {
                tvAmount.setText("Rs." + String.valueOf(points));
            }

            @Override
            public void onStartTrackingTouch(SwagPoints swagPoints) {

            }

            @Override
            public void onStopTrackingTouch(SwagPoints swagPoints) {

            }
        });

        rvEmiPlans.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvEmiPlans.setAdapter(new EmiPlanAdapter(this));

    }

    @Override
    public void setUpEmiBottomSheet() {
        cardEmi = findViewById(R.id.card_emi);
        emiLayoutBottomSheet = from(cardEmi);

        emiLayoutBottomSheet.setHideable(false);//Important to add
        emiLayoutBottomSheet.setState(BottomSheetBehavior.STATE_COLLAPSED);
        emiLayoutBottomSheet.setPeekHeight(200);
        emiLayoutBottomSheet.setDraggable(false);
        cardEmi.setBackground(getResources().getDrawable(R.drawable.card_collapsed_bg));
        emiLayoutBottomSheet.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    emiLayoutBottomSheet.setHideable(false);
                    setUpBankAccountBottomSheet();
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });


    }

    @Override
    public void hideEmiSheet() {

        if (emiLayoutBottomSheet != null) {
            emiLayoutBottomSheet.setHideable(false);
            emiLayoutBottomSheet.setState(BottomSheetBehavior.STATE_COLLAPSED);
            emiBg.setBackground(getResources().getDrawable(R.drawable.card_collapsed_bg));

            emiHideView.setVisibility(View.VISIBLE);
            emiCollapsedView.setVisibility(View.GONE);
            llExpandedCreditView.setVisibility(View.GONE);
        }

    }

    @Override
    public void showEmiSheet() {

        emiLayoutBottomSheet.setState(BottomSheetBehavior.STATE_EXPANDED);
        rlCollapsedView.setVisibility(View.VISIBLE);
        llExpandedCreditView.setVisibility(View.GONE);
    }

    @Override
    public void setUpBankAccountBottomSheet() {
        cardBankAcc = findViewById(R.id.card_bank_acc);
        bankLayoutBottomSheet = from(cardBankAcc);
        bankLayoutBottomSheet.setHideable(false);//Important to add
        bankLayoutBottomSheet.setState(BottomSheetBehavior.STATE_COLLAPSED);
        bankLayoutBottomSheet.setPeekHeight(200);
        bankLayoutBottomSheet.setDraggable(false);
        bankLayoutBottomSheet.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN) {
//                    view.findViewById(R.id.overlay).setVisibility(View.GONE);
                    bankLayoutBottomSheet.setHideable(false);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });


    }

    @Override
    public void hideBankAccountSheet() {
        if (bankLayoutBottomSheet != null) {
            bankLayoutBottomSheet.setHideable(false);
            bankLayoutBottomSheet.setState(BottomSheetBehavior.STATE_COLLAPSED);
            ivEmiDownArrow.setVisibility(View.GONE);
            bankbg.setBackground(getResources().getDrawable(R.drawable.card_collapsed_bg));

            bankExpandedView.setVisibility(View.GONE);
            bankCollapsedView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showBankAccountSheet() {

    }

    @Override
    public void onEmiProceedClick(View view) {
        if (bankLayoutBottomSheet.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            hideBankAccountSheet();
            bankExpandedView.setVisibility(View.GONE);
            bankCollapsedView.setVisibility(View.VISIBLE);
        }
        emiLayoutBottomSheet.setState(BottomSheetBehavior.STATE_EXPANDED);
        emiBg.setBackground(getResources().getDrawable(R.drawable.card_emi_bg));
        rlCollapsedView.setVisibility(View.VISIBLE);
        llExpandedCreditView.setVisibility(View.GONE);
        emiExpandedView.setVisibility(View.VISIBLE);
        emiCollapsedView.setVisibility(View.GONE);
        emiHideView.setVisibility(View.GONE);
    }

    @Override
    public void onBankAccountClick(View view) {
        ivEmiDownArrow.setVisibility(View.VISIBLE);
        bankLayoutBottomSheet.setState(BottomSheetBehavior.STATE_EXPANDED);
        bankbg.setBackground(getResources().getDrawable(R.drawable.card_account_bg));


        emiExpandedView.setVisibility(View.GONE);
        emiCollapsedView.setVisibility(View.VISIBLE);
        emiHideView.setVisibility(View.GONE);

        bankExpandedView.setVisibility(View.VISIBLE);
        bankCollapsedView.setVisibility(View.GONE);
    }

    @Override
    public void onCreditAmountClick(View view) {
        hideBankAccountSheet();
        hideEmiSheet();

        emiExpandedView.setVisibility(View.GONE);
        emiCollapsedView.setVisibility(View.GONE);
        emiHideView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {


        if (bankLayoutBottomSheet.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            hideBankAccountSheet();
        } else if (emiLayoutBottomSheet.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            hideEmiSheet();
        } else {
            super.onBackPressed();
        }
    }
}