package cn.jit.aquaponics.uinew.second.reagent;

//import cn.jit.aquaponics.model.response.ReagentInputResponse;
import com.zxl.baselib.ui.base.BaseView;

import java.util.List;

public interface ReagentInputListView extends BaseView {
    void deleteReagentInputSuccess();
    void deleteReagentInputFailure(String error);

    void getReagentInputSuccess(List<ReagentInputResponse> reagentInputResponseList);
    void getReagentInputFailure(String error);
}
