package cn.jit.aquaponics.uinew.second.input;

//import cn.jit.aquaponics.model.response.InputResponse;
import com.zxl.baselib.ui.base.BaseView;

import java.util.List;

public interface InputListView extends BaseView {
    void deleteInputSuccess();
    void deleteInputFailure(String error);

    void getInputSuccess(List<InputResponse> inputResponseList);
    void getInputFailure(String error);
}
