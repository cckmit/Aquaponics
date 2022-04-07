package cn.jit.aquaponics.uinew.second.fishInput;

////import cn.jit.aquaponics.model.response.FishPondResponse;
import com.zxl.baselib.bean.response.BaseResponse;
import com.zxl.baselib.ui.base.BaseView;

import java.util.List;

public interface FishInputAddView extends BaseView {
    void addFishInputSuccess(BaseResponse baseResponse);
    void addFishInputFailure(String error);

    void getAllUserPondsSuccess(List<FishPondResponse> baseResponseList);
    void getAllUserPondsFailure(String error);
}
