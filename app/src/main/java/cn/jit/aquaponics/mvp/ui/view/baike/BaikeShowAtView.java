package cn.jit.aquaponics.mvp.ui.view.baike;

////import cn.jit.aquaponics.model.response.BaikeSeedBean;
import com.zxl.baselib.ui.base.BaseView;

import cn.jit.aquaponics.mvp.model.entity.db.BaikeSeedBean;

/**
 * @author crazyZhangxl on 2018/10/15.
 * Describe:
 */
public interface BaikeShowAtView extends BaseView {

    void  queryBaikeShowSuccess(BaikeSeedBean baikeSeedBean);

    void queryBaikeShowFailure(String error);
}
