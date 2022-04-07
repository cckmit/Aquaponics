package cn.jit.aquaponics.mvp.presenter.culture;

import android.annotation.SuppressLint;

//import cn.jit.aquaponics.api.ApiRetrofit;
import cn.jit.aquaponics.base.AppConstant;
import cn.jit.aquaponics.mvp.ui.view.culture.CulMainAtView;
import com.zxl.baselib.ui.base.BaseActivity;
import com.zxl.baselib.ui.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author crazyZhangxl on 2018/10/10.
 * Describe:
 */
public class CulMainAtPresenter extends BasePresenter<CulMainAtView> {

    public CulMainAtPresenter(BaseActivity context) {
        super(context);
    }

    @SuppressLint("CheckResult")
    public void loadPondMainData() {
        getView().showLoadingDialog();
        ApiRetrofit.getInstance().queryPondMainInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(pondMainResponseBaseListResponse -> {
                    getView().hideLoadingDialog();
                    if (pondMainResponseBaseListResponse.getCode() == AppConstant.REQUEST_SUCCESS){
                        getView().queryPondSuccess(pondMainResponseBaseListResponse.getData());
                    }else {
                        getView().queryPondFailure(pondMainResponseBaseListResponse.getMsg());
                    }
                }, throwable -> {
                    getView().hideLoadingDialog();
                    getView().queryPondFailure(throwable.getLocalizedMessage());
                });
    }
}
