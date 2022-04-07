package cn.jit.aquaponics.mvp.presenter.control;

import android.annotation.SuppressLint;

//import cn.jit.aquaponics.api.ApiRetrofit;
import cn.jit.aquaponics.base.AppConstant;
import cn.jit.aquaponics.mvp.ui.view.control.HandCruiseView;
import com.zxl.baselib.ui.base.BaseActivity;
import com.zxl.baselib.ui.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author crazyZhangxl on 2018/9/29.
 * Describe: 机器人配置 P层
 */
public class HandCruisePresenter extends BasePresenter<HandCruiseView> {

    public HandCruisePresenter(BaseActivity context) {
        super(context);
    }

    @SuppressLint("CheckResult")
    public void queryAllConfig(){
        getView().showLoadingDialog();
        ApiRetrofit.getInstance().queryAllConfig()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(configMainResponseBaseListResponse -> {
                    getView().hideLoadingDialog();
                    if (configMainResponseBaseListResponse.getCode() == AppConstant.REQUEST_SUCCESS){
                        getView().queryConfigSuccess(configMainResponseBaseListResponse.getData());
                    }else {
                        getView().queryConfigFailure(configMainResponseBaseListResponse.getMsg());
                    }
                }, throwable -> {
                    getView().hideLoadingDialog();
                    getView().queryConfigFailure(throwable.getLocalizedMessage());
                });
    }
}
