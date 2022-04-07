package cn.jit.aquaponics.uinew.third;

//import cn.jit.aquaponics.model.bean.QuestionListBean;
//import cn.jit.aquaponics.model.response.PageResponse;
import com.zxl.baselib.ui.base.BaseView;

/**
 * @author crazyZhangxl on 2018/10/12.
 * Describe: 百科View层
 */
public interface QuestionListView extends BaseView {

    void queryQuestionSuccess(PageResponse<QuestionListBean> pageResponse);

    void queryQuestionFailure(String error);
}
