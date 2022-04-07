package cn.jit.aquaponics.mvp.ui.view.repair;

//import cn.jit.aquaponics.model.response.RepairStateResponse;
import com.zxl.baselib.ui.base.BaseView;

import java.util.List;

/**
 * @author crazyZhangxl on 2018/11/8.
 * Describe:
 */
public interface RepairListAtView extends BaseView {

    void queryRepairListSuccess(List<RepairStateResponse> mLists);

    void queryRepairListFailure(String error);
}
