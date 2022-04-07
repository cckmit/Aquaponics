package cn.jit.aquaponics.uinew.role_admin;

////import cn.jit.aquaponics.model.response.PageResponse;
////import cn.jit.aquaponics.model.response.RoleUserInfo;
import com.zxl.baselib.ui.base.BaseView;

/**
 * @author crazyZhangxl on 2018/9/27.
 * Describe:
 */
public interface TermUpdateView extends BaseView {
    void updateTermSuccess();
    void updateTermFailure(String error);

    void queryCustomersSuccess(PageResponse<RoleUserInfo> customerInfoPageResponse);

    void queryCustomerFailure(String error);
}
