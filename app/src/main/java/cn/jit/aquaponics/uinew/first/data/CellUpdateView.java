package cn.jit.aquaponics.uinew.first.data;

import com.zxl.baselib.ui.base.BaseView;

/**
 * @author crazyZhangxl on 2018/9/27.
 * Describe:
 */
public interface CellUpdateView extends BaseView {
    void updateFishPondSuccess();

    void updateFishPondFailure(String error);

//    void getFishPondProductSuccess(String[] FishPondList);
//
//    void getFishPondProductFailure(String error);

}
