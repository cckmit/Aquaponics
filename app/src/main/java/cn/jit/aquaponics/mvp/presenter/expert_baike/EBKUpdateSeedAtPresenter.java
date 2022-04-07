package cn.jit.aquaponics.mvp.presenter.expert_baike;

import android.annotation.SuppressLint;

//import cn.jit.aquaponics.api.ApiRetrofit;
import cn.jit.aquaponics.base.AppConstant;
//import cn.jit.aquaponics.model.response.BaikeSeedBean;
import cn.jit.aquaponics.mvp.ui.view.expert_baike.EBKUpdateSeedAtView;
import com.zxl.baselib.ui.base.BaseActivity;
import com.zxl.baselib.ui.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author crazyZhangxl on 2018/10/30.
 * Describe:
 */
public class EBKUpdateSeedAtPresenter extends BasePresenter<EBKUpdateSeedAtView> {

    public EBKUpdateSeedAtPresenter(BaseActivity context) {
        super(context);
    }

    @SuppressWarnings("AlibabaMethodTooLong")
    @SuppressLint("CheckResult")
    public void queryBaikeDetail(int index) {

        getView().showLoadingDialog();
        ApiRetrofit.getInstance().queryDetailBaikeInfo(index)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(baikeShowResponseBaseResponse -> {
                    getView().hideLoadingDialog();
                    if (baikeShowResponseBaseResponse.getCode() == AppConstant.REQUEST_SUCCESS){
                        getView().queryBaikeShowSuccess(baikeShowResponseBaseResponse.getData());
                    }else {
                        getView().queryBaikeShowFailure(baikeShowResponseBaseResponse.getMsg());
                    }
                }, throwable -> {
                    getView().hideLoadingDialog();
                    getView().queryBaikeShowFailure(throwable.getLocalizedMessage());
                });
    }


    @SuppressLint("CheckResult")
    public void doSeedBaikeUpdateWithPic(
                                 int ID,
                                 String name,
                                 String company,
                                 String description,
                                 String image){
        BaikeSeedBean baikeSeedBean = new BaikeSeedBean();
        baikeSeedBean.setName(name);
        baikeSeedBean.setSource(company);
        baikeSeedBean.setContent(description);
        baikeSeedBean.setImage(image);
        ApiRetrofit.getInstance().updateSeedBaikeWithPic(ID,baikeSeedBean)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(baseResponse -> {
                    getView().hideLoadingDialog();
                    if (baseResponse.getCode() == AppConstant.REQUEST_SUCCESS){
                        getView().updateSeedSuccess(baseResponse.getData());
                    }else {
                        getView().updateSeedFailure(baseResponse.getMsg());
                    }
                }, throwable -> {
                    getView().hideLoadingDialog();
                    getView().updateSeedFailure(throwable.getLocalizedMessage());
                });
    }

    @SuppressLint("CheckResult")
    public void doSeedBaikeUpdateNoPic(
            int ID,
            String name,
            String company,
            String description){
        BaikeSeedBean baikeSeedBean = new BaikeSeedBean();
        baikeSeedBean.setName(name);
        baikeSeedBean.setSource(company);
        baikeSeedBean.setContent(description);
        ApiRetrofit.getInstance().updateSeedBaikeNoPic(ID,baikeSeedBean)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(baseResponse -> {
                    getView().hideLoadingDialog();
                    if (baseResponse.getCode() == AppConstant.REQUEST_SUCCESS){
                        getView().updateSeedSuccess(baseResponse.getData());
                    }else {
                        getView().updateSeedFailure(baseResponse.getMsg());
                    }
                }, throwable -> {
                    getView().hideLoadingDialog();
                    getView().updateSeedFailure(throwable.getLocalizedMessage());
                });
    }
}
