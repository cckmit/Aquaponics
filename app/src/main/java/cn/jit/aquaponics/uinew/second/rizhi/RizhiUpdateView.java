package cn.jit.aquaponics.uinew.second.rizhi;

//import cn.jit.aquaponics.model.response.RizhiResponse;
import com.zxl.baselib.ui.base.BaseView;

/**
 * @author crazyZhangxl on 2018/9/27.
 * Describe:
 */
public interface RizhiUpdateView extends BaseView {
    void updateRizhiSuccess(RizhiResponse rizhiResponse);
    void updateRizhiFailure(String error);

    void getRizhiTypeSuccess(String [] gudingType);
    void getRizhiTypeFailure(String error);
}
