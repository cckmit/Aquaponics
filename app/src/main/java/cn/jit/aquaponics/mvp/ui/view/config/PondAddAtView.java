package cn.jit.aquaponics.mvp.ui.view.config;

//import cn.jit.aquaponics.model.response.PondMainResponse;
import com.zxl.baselib.ui.base.BaseView;

/**
 * @author crazyZhangxl on 2018/9/27.
 * Describe:
 */
public interface PondAddAtView extends BaseView {

    void addPondSuccess(PondMainResponse response);

    void addPondFailure(String error);
}
