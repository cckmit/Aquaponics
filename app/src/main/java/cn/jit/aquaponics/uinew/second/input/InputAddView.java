package cn.jit.aquaponics.uinew.second.input;

import com.zxl.baselib.bean.response.BaseResponse;
import com.zxl.baselib.ui.base.BaseView;

public interface InputAddView extends BaseView {
    void addInputSuccess(BaseResponse baseResponse);
    void addInputFailure(String error);
}
