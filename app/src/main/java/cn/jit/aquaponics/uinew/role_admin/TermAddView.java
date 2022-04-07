package cn.jit.aquaponics.uinew.role_admin;

////import cn.jit.aquaponics.model.response.ManuInfo;
////import cn.jit.aquaponics.model.response.PageResponse;
////import cn.jit.aquaponics.model.response.RoleUserInfo;
////import cn.jit.aquaponics.model.response.TermResponse;
import com.zxl.baselib.ui.base.BaseView;

import java.util.List;

/**
 * @author crazyZhangxl on 2018/9/27.
 * Describe:
 */
public interface TermAddView extends BaseView {

    void addTermSuccess(TermResponse termResponse);

    void addTermFailure(String error);

    void getManuSuccess(List<ManuInfo> manuInfoList);

    void getManuFailure(String error);

    void queryCustomersSuccess(PageResponse<RoleUserInfo> customerInfoPageResponse);

    void queryCustomerFailure(String error);
}
