package cn.jit.aquaponics.mvp.ui.view.config;

//import cn.jit.aquaponics.model.response.ConfigMainResponse;
//import cn.jit.aquaponics.model.response.PondMainResponse;
//import cn.jit.aquaponics.model.response.RobotPageResponse;
import com.zxl.baselib.ui.base.BaseView;

import java.util.List;

/**
 * @author zxl on 2018/9/5.
 *         discription:
 */

public interface ConfigUpdateAtView extends BaseView {

    void updateConfigSuccess(ConfigMainResponse configMainResponse);

    void updateConfigFailure(String error);


    void getPondInfoSuccess(List<PondMainResponse> pondBeanList, List<String> pondStrList);

    void getPondInfoFailure(String error);


    void queryMyRobotSuccess(RobotPageResponse robotPageResponse);

    void queryMyRobotFailure(String error);

}
