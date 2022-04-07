package cn.jit.aquaponics.uinew.second.template;

//import cn.jit.aquaponics.model.response.FishInputResponse;
//import cn.jit.aquaponics.model.response.InputResponse;
import com.zxl.baselib.ui.base.BaseView;

import java.util.List;

public interface FeedingTemplateUpdateView extends BaseView {
    void updateFeedingTemplateSuccess();

    void updateFeedingTemplateFailure(String error);

    void getAllUserFishInputSuccess(List<FishInputResponse> fishInputResponseList);
    void getAllUserFishInputFailure(String error);

    void getAllUserInputSuccess(List<InputResponse> inputResponseList);
    void getAllUserInputFailure(String error);
}
