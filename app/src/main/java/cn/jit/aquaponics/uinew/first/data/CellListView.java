package cn.jit.aquaponics.uinew.first.data;

//import cn.jit.aquaponics.model.response.FishPondResponse;
import com.zxl.baselib.ui.base.BaseView;

import java.util.List;

/**
 * @author crazyZhangxl on 2018/9/27.
 * Describe: 获得所有塘口信息的View层
 */
public interface CellListView extends BaseView {
    void deleteFishPondSuccess();
    void deleteFishPondFailure(String error);

    void getFishPondSuccess(List<FishPondResponse> FishPondResponseList);
    void getFishPondFailure(String error);

}
