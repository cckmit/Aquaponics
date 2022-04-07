package cn.jit.aquaponics.mvp.presenter.expert_baike;

import android.annotation.SuppressLint;

//import cn.jit.aquaponics.api.ApiRetrofit;
import cn.jit.aquaponics.base.AppConstant;
//import cn.jit.aquaponics.model.request.DiseaseAddRequest;
import cn.jit.aquaponics.mvp.ui.view.expert_baike.EBKAddAtView;
import com.zxl.baselib.ui.base.BaseActivity;
import com.zxl.baselib.ui.base.BasePresenter;

import java.io.File;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author crazyZhangxl on 2018/10/29.
 * Describe:
 */
public class EBKDisAddAtPresenter extends BasePresenter<EBKAddAtView> {

    public EBKDisAddAtPresenter(BaseActivity context) {
        super(context);
    }

    @SuppressLint("CheckResult")
    public void doDiseaseBaikeAdd(String diseaseName, String subKind, String symptom, String treatment, String imagePath){
        getView().showLoadingDialog();
        DiseaseAddRequest diseaseAddRequest = new DiseaseAddRequest(diseaseName,subKind,symptom,treatment,new File(imagePath));
        ApiRetrofit.getInstance().addDiseaseBaike(diseaseAddRequest)
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
