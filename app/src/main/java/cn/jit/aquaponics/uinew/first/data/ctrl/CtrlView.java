package cn.jit.aquaponics.uinew.first.data.ctrl;

//import cn.jit.aquaponics.model.response.CtrlResponse;
//import cn.jit.aquaponics.model.response.EquipStatusResponse;
import com.zxl.baselib.ui.base.BaseView;

import java.util.List;

/**
 * @author crazyZhangxl on 2018/9/27.
 * Describe: 获得所有塘口信息的View层
 */
public interface CtrlView extends BaseView {
    void getCellEquipStatusSuccess(List<EquipStatusResponse> equipResponseList);
    void getCellEquipStatusFailure(String error);

    void ctrlEquipSuccess(CtrlResponse ctrlResponse);
    void ctrlEquipFailure(String error);
}
