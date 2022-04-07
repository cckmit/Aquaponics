package cn.jit.aquaponics.uinew.second.template;

//import cn.jit.aquaponics.model.response.FeedingTemplateResponse;
import com.zxl.baselib.ui.base.BaseView;

import java.util.List;

public interface FeedingTemplateListView extends BaseView {
    void deleteFeedingTemplateSuccess();
    void deleteFeedingTemplateFailure(String error);

    void getFeedingTemplateSuccess(List<FeedingTemplateResponse> feedingTemplateResponsesList);
    void getFeedingTemplateFailure(String error);
}
