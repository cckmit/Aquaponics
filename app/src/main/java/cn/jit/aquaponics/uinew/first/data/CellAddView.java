package cn.jit.aquaponics.uinew.first.data;

//import cn.jit.aquaponics.model.response.CellProTypeResponse;
//import cn.jit.aquaponics.model.response.CellResponse;
import com.zxl.baselib.ui.base.BaseView;

import java.util.List;

/**
 * @author crazyZhangxl on 2018/9/27.
 * Describe:
 */
public interface CellAddView extends BaseView {

    void addCellSuccess(CellResponse cellResponse);

    void addCellFailure(String error);

    void getCellProTypeSuccess(List<CellProTypeResponse> cellProTypeResponseList);

    void getCellProTypeFailure(String error);

    void getCellProSuccess(String[] cellProList);

    void getCellProFailure(String error);
}
