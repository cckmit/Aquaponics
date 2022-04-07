package cn.jit.aquaponics.mvp.ui.view.expert_baike;

//import cn.jit.aquaponics.model.response.PageResponse;
//import cn.jit.aquaponics.model.response.RoleUserInfo;
import com.zxl.baselib.ui.base.BaseView;

/**
 * @author crazyZhangxl on 2018/11/1.
 * Describe:专家用户的View
 */
public interface ECustomerFgView extends BaseView {

    void queryCustomersSuccess(PageResponse<RoleUserInfo> customerInfoPageResponse);

    void queryCustomerFailure(String error);
}
