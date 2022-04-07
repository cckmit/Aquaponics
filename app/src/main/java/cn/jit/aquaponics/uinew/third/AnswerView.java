package cn.jit.aquaponics.uinew.third;

//import cn.jit.aquaponics.model.bean.AnswerBean;
//import cn.jit.aquaponics.model.bean.QuestionListBean;
import com.zxl.baselib.ui.base.BaseView;

/**
 * @author crazyZhangxl on 2018/10/12.
 * Describe: 百科View层
 */
public interface AnswerView extends BaseView {

    void queryQuestionSuccess(QuestionListBean questionListBean);

    void queryQuestionFailure(String error);

    void answerSuccess(AnswerBean answerBean);

    void answerFailure(String error);
}
