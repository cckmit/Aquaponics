package cn.jit.aquaponics.uinew.first.data;

import com.zxl.baselib.bean.response.BaseResponse;
import com.zxl.baselib.ui.base.BaseView;

public interface FishPondAddView extends BaseView {
    void addFishPondSuccess(BaseResponse baseResponse);
    void addFishPondFailure(String error);
}
