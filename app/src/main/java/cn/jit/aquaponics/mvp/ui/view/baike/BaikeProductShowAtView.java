package cn.jit.aquaponics.mvp.ui.view.baike;

////import cn.jit.aquaponics.model.response.BaikeProductBean;
import com.zxl.baselib.ui.base.BaseView;

import cn.jit.aquaponics.mvp.model.entity.db.BaikeProductBean;

/**
 * @author crazyZhangxl on 2018/10/15.
 * Describe:
 */
public interface BaikeProductShowAtView extends BaseView {

    void  queryBaikeShowSuccess(BaikeProductBean baikeSeedResponse);

    void queryBaikeShowFailure(String error);
}
