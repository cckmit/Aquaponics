package cn.jit.aquaponics.mvp.presenter.expert_baike;

import android.annotation.SuppressLint;

//import cn.jit.aquaponics.api.ApiRetrofit;
import cn.jit.aquaponics.base.AppConstant;
//import cn.jit.aquaponics.model.response.BaikeDrugBean;
import cn.jit.aquaponics.mvp.ui.view.expert_baike.EBKAddAtView;
import com.zxl.baselib.ui.base.BaseActivity;
import com.zxl.baselib.ui.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author crazyZhangxl on 2018/10/30.
 * Describe:
 */
public class EBKDrugAddPresenter extends BasePresenter<EBKAddAtView> {
    public EBKDrugAddPresenter(BaseActivity context) {
        super(context);
    }

    @SuppressLint("CheckResult")
    public void  doDrugAddRequest(BaikeDrugBean baikeDrugBean){
        getView().showLoadingDialog();
        ApiRetrofit.getInstance().addDrugBaike(baikeDrugBean)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(baseResponse -> {
                    getView().hideLoadingDialog();
                    if (baseResponse.getCode() == AppConstant.REQUEST_SUCCESS){
                        getView().ebkAddSuccess();
                    }else {
                        getView().ebkAddFailure(baseResponse.getMsg());
                    }
                }, throwable -> {
                    getView().hideLoadingDialog();
                    getView().ebkAddFailure(throwable.getLocalizedMessage());
                });
    }
}
