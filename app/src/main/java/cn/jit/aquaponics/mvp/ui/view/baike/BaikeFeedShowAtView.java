package cn.jit.aquaponics.mvp.ui.view.baike;

////import cn.jit.aquaponics.model.response.BaikeFeedBean;
import com.zxl.baselib.ui.base.BaseView;

import cn.jit.aquaponics.mvp.model.entity.db.BaikeFeedBean;

/**
 * @author crazyZhangxl on 2018/10/15.
 * Describe:
 */
public interface BaikeFeedShowAtView extends BaseView {

    void  queryBaikeShowSuccess(BaikeFeedBean baikeSeedResponse);

    void queryBaikeShowFailure(String error);
}
