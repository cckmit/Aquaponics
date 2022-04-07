package cn.jit.aquaponics.mvp.ui.view.baike;

////import cn.jit.aquaponics.model.response.BaikeProductBean;
////import cn.jit.aquaponics.model.response.PageResponse;
import com.zxl.baselib.ui.base.BaseView;

import cn.jit.aquaponics.mvp.model.entity.db.BaikeProductBean;
import cn.jit.aquaponics.mvp.model.entity.db.PageBean;

/**
 * @author crazyZhangxl on 2018/10/12.
 * Describe: 百科View层
 */
public interface BaikeProductFgView extends BaseView {

    void queryBaikeSuccess(PageBean<BaikeProductBean> pageResponse);

    void queryBaikeFailure(String error);

    void deleteBaikeSuccess(int itemIndex);

    void deleteBaikeFailure(String error);
}
