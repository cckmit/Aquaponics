package cn.jit.aquaponics.mvp.ui.view.baike;

////import cn.jit.aquaponics.model.response.BaikeDrugBean;
import com.zxl.baselib.ui.base.BaseView;

import cn.jit.aquaponics.mvp.model.entity.db.BaikeDrugBean;

/**
 * @author crazyZhangxl on 2018/10/15.
 * Describe:
 */
public interface BaikeDrugShowAtView extends BaseView {

    void  queryBaikeShowSuccess(BaikeDrugBean baikeSeedResponse);

    void queryBaikeShowFailure(String error);
}
