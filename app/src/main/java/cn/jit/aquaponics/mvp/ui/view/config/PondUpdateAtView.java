package cn.jit.aquaponics.mvp.ui.view.config;

//import cn.jit.aquaponics.model.response.PondMainResponse;
import com.zxl.baselib.ui.base.BaseView;

/**
 * @author crazyZhangxl on 2018/9/27.
 * Describe:
 */
public interface PondUpdateAtView extends BaseView {
    void updatePondSuccess(PondMainResponse response);
    void updatePondFailure(String error);
}
