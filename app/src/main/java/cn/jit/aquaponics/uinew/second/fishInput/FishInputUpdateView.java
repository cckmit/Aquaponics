package cn.jit.aquaponics.uinew.second.fishInput;

//import cn.jit.aquaponics.model.response.FishPondResponse;
import com.zxl.baselib.ui.base.BaseView;

import java.util.List;

public interface FishInputUpdateView extends BaseView {
    void updateFishInputSuccess();

    void updateFishInputFailure(String error);

    void getAllUserPondsSuccess(List<FishPondResponse> baseResponseList);

    void getAllUserPondsFailure(String error);
}
