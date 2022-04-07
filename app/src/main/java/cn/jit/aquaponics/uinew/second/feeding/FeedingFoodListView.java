package cn.jit.aquaponics.uinew.second.feeding;

////import cn.jit.aquaponics.model.response.FeedingFoodResponse;
import com.zxl.baselib.ui.base.BaseView;

import java.util.List;

public interface FeedingFoodListView extends BaseView {
    void deleteFeedingFoodSuccess();
    void deleteFeedingFoodFailure(String error);

    void getFeedingFoodSuccess(List<FeedingFoodResponse> feedingFoodResponseList);
    void getFeedingFoodFailure(String error);
}
