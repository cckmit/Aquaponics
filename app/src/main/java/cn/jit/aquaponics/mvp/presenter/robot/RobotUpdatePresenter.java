package cn.jit.aquaponics.mvp.presenter.robot;

import android.annotation.SuppressLint;

//import cn.jit.aquaponics.api.ApiRetrofit;
import cn.jit.aquaponics.base.AppConstant;
//import cn.jit.aquaponics.model.cache.UserCache;
//import cn.jit.aquaponics.model.request.RobotActionRequest;
import cn.jit.aquaponics.mvp.ui.view.robot.RobotUpdateView;
import com.zxl.baselib.ui.base.BaseActivity;
import com.zxl.baselib.ui.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author crazyZhangxl on 2018/9/28.
 * Describe:
 */
public class RobotUpdatePresenter extends BasePresenter<RobotUpdateView> {

    public RobotUpdatePresenter(BaseActivity context) {
        super(context);
    }

    @SuppressLint("CheckResult")
    public void updateRobot(int robotID, String robotNumber, String type){
        RobotActionRequest robotActionRequest = new RobotActionRequest();
        robotActionRequest.setType(type);
        robotActionRequest.setNumber(robotNumber);
        robotActionRequest.setCustomer_id(UserCache.getUserUser_id());
        getView().showLoadingDialog();
        ApiRetrofit.getInstance().updateRobot(robotID,robotActionRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(baseResponse -> {
                    getView().hideLoadingDialog();
                    if (baseResponse.getCode() == AppConstant.REQUEST_SUCCESS){
                        getView().robotUpdateSuccess(baseResponse.getData());
                    }else {
                        getView().robotUpdateFailure(baseResponse.getMsg());
                    }
                }, throwable -> {
                    getView().hideLoadingDialog();
                    getView().robotUpdateFailure(throwable.getLocalizedMessage());
                });

    }
}
