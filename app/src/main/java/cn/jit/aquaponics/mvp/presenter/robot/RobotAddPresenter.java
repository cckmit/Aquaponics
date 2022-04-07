package cn.jit.aquaponics.mvp.presenter.robot;

import android.annotation.SuppressLint;

//import cn.jit.aquaponics.api.ApiRetrofit;
import cn.jit.aquaponics.base.AppConstant;
//import cn.jit.aquaponics.model.cache.UserCache;
//import cn.jit.aquaponics.model.request.RobotActionRequest;
import cn.jit.aquaponics.mvp.ui.view.robot.RobotAddView;
import com.zxl.baselib.ui.base.BaseActivity;
import com.zxl.baselib.ui.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author crazyZhangxl on 2018/9/28.
 * Describe:
 */
public class RobotAddPresenter extends BasePresenter<RobotAddView> {
    public RobotAddPresenter(BaseActivity context) {
        super(context);
    }

    @SuppressLint("CheckResult")
    public void doAddRobot(String robotNumber,String type){
        RobotActionRequest robotActionRequest = new RobotActionRequest();
        robotActionRequest.setCustomer_id(UserCache.getUserUser_id());
        robotActionRequest.setNumber(robotNumber);
        robotActionRequest.setType(type);
        getView().showLoadingDialog();
        ApiRetrofit.getInstance().requestAddRobot(robotActionRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(robotMainResponseBaseResponse -> {
                    getView().hideLoadingDialog();
                    if (robotMainResponseBaseResponse.getCode() == AppConstant.REQUEST_SUCCESS){
                        getView().addRobotSuccess(robotMainResponseBaseResponse.getData());
                    }else {
                        getView().addRobotFailure(robotMainResponseBaseResponse.getMsg());
                    }
                }, throwable -> {
                   getView().hideLoadingDialog();
                   getView().addRobotFailure(throwable.getLocalizedMessage());
                });
    }
}
