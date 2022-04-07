package cn.jit.aquaponics.mvp.ui.view.culture;

//import cn.jit.aquaponics.model.response.PondMainResponse;
import com.zxl.baselib.ui.base.BaseView;

import java.util.List;

/**
 * @author crazyZhangxl on 2018/10/10.
 * Describe:
 */
public interface CulMainAtView extends BaseView {

    void queryPondSuccess(List<PondMainResponse> responses);

    void queryPondFailure(String error);

}
