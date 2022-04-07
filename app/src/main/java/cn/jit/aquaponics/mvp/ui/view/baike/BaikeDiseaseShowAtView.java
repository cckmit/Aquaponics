package cn.jit.aquaponics.mvp.ui.view.baike;

////import cn.jit.aquaponics.model.response.BaikeDiseaseBean;
import com.zxl.baselib.ui.base.BaseView;

import cn.jit.aquaponics.mvp.model.entity.db.BaikeDiseaseBean;

/**
 * @author crazyZhangxl on 2018/10/15.
 * Describe:
 */
public interface BaikeDiseaseShowAtView extends BaseView {

    void  queryBaikeShowSuccess(BaikeDiseaseBean baikeSeedResponse);

    void queryBaikeShowFailure(String error);
}
