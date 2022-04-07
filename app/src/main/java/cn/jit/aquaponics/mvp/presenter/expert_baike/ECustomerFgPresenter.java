package cn.jit.aquaponics.mvp.presenter.expert_baike;

import android.annotation.SuppressLint;

//import cn.jit.aquaponics.api.ApiRetrofit;
import cn.jit.aquaponics.base.AppConstant;
import cn.jit.aquaponics.mvp.ui.view.expert_baike.ECustomerFgView;
import com.zxl.baselib.ui.base.BaseActivity;
import com.zxl.baselib.ui.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author crazyZhangxl on 2018/11/1.
 * Describe:
 */
public class ECustomerFgPresenter extends BasePresenter<ECustomerFgView> {
    public ECustomerFgPresenter(BaseActivity context) {
        super(context);
    }


    @SuppressLint("CheckResult")
    public void queryRoleUserInfo(int pageNum,int role){
        ApiRetrofit.getInstance().queryRoleUserInfo(pageNum,role)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(pageResponseBaseResponse -> {
                    if (pageResponseBaseResponse.getCode() == AppConstant.REQUEST_SUCCESS){
                        getView().queryCustomersSuccess(pageResponseBaseResponse.getData());
                    }else {
                        getView().queryCustomerFailure(pageResponseBaseResponse.getMsg());
                    }
                }, throwable -> getView().queryCustomerFailure(throwable.getLocalizedMessage()));
    }
}
