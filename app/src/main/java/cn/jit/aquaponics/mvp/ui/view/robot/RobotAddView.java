package cn.jit.aquaponics.mvp.ui.view.robot;

//import cn.jit.aquaponics.model.response.RobotMainResponse;
import com.zxl.baselib.ui.base.BaseView;

/**
 * @author crazyZhangxl on 2018/9/28.
 * Describe:
 */
public interface RobotAddView extends BaseView {

    void addRobotSuccess(RobotMainResponse robotMainResponse);

    void addRobotFailure(String error);
}
