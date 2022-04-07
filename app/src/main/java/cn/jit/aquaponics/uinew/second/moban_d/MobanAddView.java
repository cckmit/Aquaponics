package cn.jit.aquaponics.uinew.second.moban_d;

//import cn.jit.aquaponics.model.response.TemplateResponse;
import com.zxl.baselib.ui.base.BaseView;

/**
 * @author crazyZhangxl on 2018/9/27.
 * Describe:
 */
public interface MobanAddView extends BaseView {

    void addMobanSuccess(TemplateResponse templateResponse);

    void addMobanFailure(String error);

    void getErliaoTypeSuccess(String [] erliaoType);

    void getErliaoTypeFailure(String error);
}
