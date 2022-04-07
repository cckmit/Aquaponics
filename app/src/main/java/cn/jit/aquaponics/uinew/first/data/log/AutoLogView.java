package cn.jit.aquaponics.uinew.first.data.log;

//import cn.jit.aquaponics.model.response.AutoLogResponse;
import com.zxl.baselib.ui.base.BaseView;

import java.util.List;

/**
 * @author crazyZhangxl on 2018/9/27.
 * Describe: 获得所有塘口信息的View层
 */
public interface AutoLogView extends BaseView {
    void getAutoLogSuccess(List<AutoLogResponse> equipResponseList);
    void getCellAutoLogFailure(String error);
}
