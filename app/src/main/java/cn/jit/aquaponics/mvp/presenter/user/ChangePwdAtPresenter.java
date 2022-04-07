package cn.jit.aquaponics.mvp.presenter.user;

import android.annotation.SuppressLint;

//import cn.jit.aquaponics.api.ApiRetrofit;
import cn.jit.aquaponics.base.AppConstant;
//import cn.jit.aquaponics.model.cache.UserCache;
import cn.jit.aquaponics.mvp.ui.view.user.IChangePwdAtView;
import com.zxl.baselib.ui.base.BaseActivity;
import com.zxl.baselib.ui.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author crazyZhangxl on 2018/10/31.
 * Describe:
 */
public class ChangePwdAtPresenter extends BasePresenter<IChangePwdAtView> {

    public ChangePwdAtPresenter(BaseActivity context) {
        super(context);
    }

    @SuppressLint("CheckResult")
    public void changePwd(String oldPwd, String newPwd) {
        getView().showLoadingDialog();
        ApiRetrofit.getInstance().changePwd(oldPwd,newPwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(changePwdResponse -> {
                    getView().hideLoadingDialog();
                    if (changePwdResponse.getCode() == AppConstant.REQUEST_SUCCESS){
                        UserCache.setUserPwd(newPwd);
                        getView().changePwdSuccess();
                    }else {
                        getView().changePwdFailure(changePwdResponse.getMsg());
                    }
                }, throwable -> {
                    getView().hideLoadingDialog();
                    getView().changePwdFailure(throwable.getLocalizedMessage());
                });
    }
}
