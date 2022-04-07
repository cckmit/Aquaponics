package cn.jit.aquaponics.mvp.presenter.culture;

import android.annotation.SuppressLint;

//import cn.jit.aquaponics.api.ApiRetrofit;
import cn.jit.aquaponics.base.AppConstant;
//import cn.jit.aquaponics.model.request.InsertFeedRequest;
//import cn.jit.aquaponics.model.request.InsertWaterRequest;
//import cn.jit.aquaponics.model.response.PondMainResponse;
import cn.jit.aquaponics.mvp.ui.view.culture.CultureSubAtView;
import com.zxl.baselib.ui.base.BaseActivity;
import com.zxl.baselib.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author crazyZhangxl on 2018/9/30.
 * Describe:
 */
public class CultureSubAtPresenter extends BasePresenter<CultureSubAtView> {

    public CultureSubAtPresenter(BaseActivity context) {
        super(context);
    }

    @SuppressLint("CheckResult")
    public void queryPondInfo(){
        getView().showLoadingDialog();
        ApiRetrofit.getInstance().queryPondMainInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(pondMainResponseBaseListResponse -> {
                    getView().hideLoadingDialog();
                    if (pondMainResponseBaseListResponse.getCode() == AppConstant.REQUEST_SUCCESS){
                        List<String> pondStrList = new ArrayList<>();
                        if (pondMainResponseBaseListResponse.getData() != null){
                            for (PondMainResponse pondMainResponse : pondMainResponseBaseListResponse.getData()){
                                pondStrList.add(pondMainResponse.getName());
                            }
                        }
                        getView().getPondInfoSuccess(pondMainResponseBaseListResponse.getData(),pondStrList);
                    }else {
                        getView().getPondInfoFailure(pondMainResponseBaseListResponse.getMsg());
                    }
                }, throwable -> {
                    getView().hideLoadingDialog();
                    getView().getPondInfoFailure(throwable.getLocalizedMessage());
                });
    }

    /**
     * 投放水质信息以及投喂信息
     */
    @SuppressLint("CheckResult")
    public void submitWaterWithFeed(InsertWaterRequest insertWaterRequest, InsertFeedRequest insertFeedRequest){
        getView().showLoadingDialog();
        ApiRetrofit.getInstance().insertWater(insertWaterRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .flatMap(response -> {
                    if (response != null && response.getCode() == AppConstant.REQUEST_SUCCESS) {
                        return ApiRetrofit.getInstance().insertFeed(insertFeedRequest);
                    }
                    return null;
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    getView().hideLoadingDialog();
                    if (response != null && response.getCode() == 1) {
                        getView().cultureSubmitSuccess();
                    } else {
                        getView().cultureSubmitFailure(response.getMsg());
                    }
                }, throwable -> {
                    getView().hideLoadingDialog();
                    getView().cultureSubmitFailure(throwable.getLocalizedMessage());
                });
    }
}
