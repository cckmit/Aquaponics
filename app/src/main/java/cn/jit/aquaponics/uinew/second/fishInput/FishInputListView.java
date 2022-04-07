package cn.jit.aquaponics.uinew.second.fishInput;

//import cn.jit.aquaponics.model.response.FishInputResponse;
//import cn.jit.aquaponics.model.response.FishPondResponse;
import com.zxl.baselib.ui.base.BaseView;

import java.util.List;

public interface FishInputListView extends BaseView {
    void getFishInputSuccess(List<FishInputResponse> fishInputResponseList);
    void getFishInputFailure(String error);

    void deleteFishInputSuccess();
    void deleteFishInputFailure(String error);

    void getFishPondSuccess(List<FishPondResponse> fishPondResponseList);
    void getFishPondFailure(String error);
}
