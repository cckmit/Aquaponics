package cn.jit.aquaponics.uinew.second.reagent;

import android.annotation.SuppressLint;

//import cn.jit.aquaponics.api.ApiRetrofit;
import cn.jit.aquaponics.base.AppConstant;
import com.zxl.baselib.ui.base.BaseActivity;
import com.zxl.baselib.ui.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ReagentInputUpdatePresenter extends BasePresenter<ReagentInputUpdateView> {

    public ReagentInputUpdatePresenter(BaseActivity context) {
        super(context);
    }

    @SuppressLint("CheckResult")
    public void updateReagentInput(int id,String batchNumber,String pond,String reagent,double amount,String unit,String time,String remarks){
        getView().showLoadingDialog();
        ApiRetrofit.getInstance().updateReagentInput(id, batchNumber, pond, reagent, amount, unit, time, remarks)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(baseResponse -> {
                    getView().hideLoadingDialog();
                    if (baseResponse.getCode() == AppConstant.REQUEST_SUCCESS){
                        getView().updateReagentInputSuccess();
                    }else {
                        getView().updateReagentInputFailure(baseResponse.getMsg());
                    }
                }, throwable -> {
                    getView().hideLoadingDialog();
                    getView().updateReagentInputFailure(throwable.getLocalizedMessage());
                });
    }
}
