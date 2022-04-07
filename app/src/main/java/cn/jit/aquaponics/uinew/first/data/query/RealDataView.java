package cn.jit.aquaponics.uinew.first.data.query;

//import cn.jit.aquaponics.model.response.OrgResponse;
//import cn.jit.aquaponics.model.response.RealResponse;
import com.zxl.baselib.ui.base.BaseView;

import java.util.List;

/**
 * @author crazyZhangxl on 2018/9/27.
 * Describe: 获得所有塘口信息的View层
 */
public interface RealDataView extends BaseView {
    void getRealDataSuccess(List<RealResponse> realResponseList);
    void getRealDataFailure(String error);

    void getOrgDataSuccess(List<OrgResponse> orgResponseList);
    void getOrgDataFailure(String error);
}
