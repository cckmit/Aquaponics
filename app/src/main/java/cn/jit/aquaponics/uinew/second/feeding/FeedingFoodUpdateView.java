package cn.jit.aquaponics.uinew.second.feeding;

////import cn.jit.aquaponics.model.response.FeedingTemplateResponse;
////import cn.jit.aquaponics.model.response.InputResponse;
import com.zxl.baselib.ui.base.BaseView;

import java.util.List;

public interface FeedingFoodUpdateView extends BaseView {
    void updateFeedingFoodSuccess();

    void updateFeedingFoodFailure(String error);

    void getAllUserFeedingTemplateSuccess(List<FeedingTemplateResponse> feedingTemplateResponseList);
    void getAllUserFeedingTemplateFailure(String error);

    void getAllUserInputsSuccess(List<InputResponse> inputResponseList);
    void getAllUserInputsFailure(String error);
}
