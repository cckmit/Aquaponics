package cn.jit.aquaponics.uinew.second.input;

import com.zxl.baselib.ui.base.BaseView;

public interface InputUpdateView extends BaseView {

    void updateInputSuccess();

    void updateInputFailure(String error);
}
