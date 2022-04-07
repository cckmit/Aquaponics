package cn.jit.aquaponics.uinew.second.template;

//import cn.jit.aquaponics.model.response.FishInputResponse;
//import cn.jit.aquaponics.model.response.InputResponse;
import com.zxl.baselib.bean.response.BaseResponse;
import com.zxl.baselib.ui.base.BaseView;

import java.util.List;

public interface FeedingTemplateAddView extends BaseView {
    void addFeedingTemplateSuccess(BaseResponse baseResponse);
    void addFeedingTemplateFailure(String error);

    void getAllUserFishInputSuccess(List<FishInputResponse> fishInputResponseList);
    void getAllUserFishInputFailure(String error);

//    void getAllUserPondSuccess(List<FishPondResponse> fishPondResponseList);
//    void getAllUserPondFailure(String error);

    void getAllUserInputSuccess(List<InputResponse> inputResponseList);
    void getAllUserInputFailure(String error);
}
