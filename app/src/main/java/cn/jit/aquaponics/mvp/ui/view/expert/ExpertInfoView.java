package cn.jit.aquaponics.mvp.ui.view.expert;

//import cn.jit.aquaponics.model.response.PageResponse;
//import cn.jit.aquaponics.model.response.RoleUserInfo;
import com.zxl.baselib.ui.base.BaseView;

/**
 * @author crazyZhangxl on 2018/10/12.
 * Describe: 百科View层
 */
public interface ExpertInfoView extends BaseView {

    void queryExpertInfoSuccess(PageResponse<RoleUserInfo> pageResponse);

    void queryExpertInfoFailure(String error);
}
