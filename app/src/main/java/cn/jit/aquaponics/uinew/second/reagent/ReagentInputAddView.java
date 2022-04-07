package cn.jit.aquaponics.uinew.second.reagent;

//import cn.jit.aquaponics.model.response.FishInputResponse;
//import cn.jit.aquaponics.model.response.FishPondResponse;
//import cn.jit.aquaponics.model.response.InputResponse;
import com.zxl.baselib.bean.response.BaseResponse;
import com.zxl.baselib.ui.base.BaseView;

import java.util.List;

public interface ReagentInputAddView extends BaseView {
    void addReagentSuccess(BaseResponse baseResponse);
    void addReagentFailure(String error);

    void getAllUserInputsSuccess(List<InputResponse> inputResponseList);
    void getAllUserInputsFailure(String error);

    void getAllUserFishInputSuccess(List<FishInputResponse> fishInputResponseList);
    void getAllUserFishInputFailure(String error);

    void getAllUserPondsSuccess(List<FishPondResponse> fishPondResponseList);
    void getAllUserPondsFailure(String error);
}