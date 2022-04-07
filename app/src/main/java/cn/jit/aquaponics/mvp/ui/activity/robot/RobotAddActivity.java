package cn.jit.aquaponics.mvp.ui.activity.robot;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaredrummler.materialspinner.MaterialSpinner;
import cn.jit.aquaponics.R;
import cn.jit.aquaponics.base.AppConstant;
////import cn.jit.aquaponics.model.response.RobotMainResponse;
import cn.jit.aquaponics.mvp.presenter.robot.RobotAddPresenter;
import cn.jit.aquaponics.mvp.ui.view.robot.RobotAddView;
import com.zxl.baselib.ui.base.BaseActivity;
import com.zxl.baselib.util.ui.UIUtils;

import butterknife.BindView;

/**
 * @author crazyZhangxl on 2018-9-28 15:20:41.
 * Describe: 机器人录入
 */

public class RobotAddActivity extends BaseActivity<RobotAddView, RobotAddPresenter> implements RobotAddView {
    @BindView(R.id.ivToolbarNavigation)
    ImageView mIvToolbarNavigation;
    @BindView(R.id.vToolbarDivision)
    View mVToolbarDivision;
    @BindView(R.id.tvToolbarTitle)
    TextView mTvToolbarTitle;
    @BindView(R.id.etRobotNumber)
    EditText mEtRobotNumber;
    @BindView(R.id.spRobotType)
    MaterialSpinner mSpRobotType;
    @BindView(R.id.btnAddRobot)
    Button mBtnAddRobot;
    @BindView(R.id.layout_wrapper)
    LinearLayout mLayoutWrapper;

    @Override
    protected void init() {

    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_robot_add;
    }

    @Override
    protected RobotAddPresenter createPresenter() {
        return new RobotAddPresenter(this);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mTvToolbarTitle.setText("");
    }

    @Override
    protected void initData() {
        mSpRobotType.setItems(AppConstant.ROBOT_TYPE);
        mSpRobotType.setSelectedIndex(0);
    }

    @Override
    protected void initListener() {
        mIvToolbarNavigation.setOnClickListener(view -> onBackPressed());

        mBtnAddRobot.setOnClickListener(view -> doAddRobot());
    }

    private void doAddRobot() {
        String robotNumber = mEtRobotNumber.getText().toString();
        if (TextUtils.isEmpty(robotNumber)){
            UIUtils.showToast(getString(R.string.input_robot_number));
            return;
        }
        mPresenter.doAddRobot(robotNumber,AppConstant.ROBOT_TYPE[mSpRobotType.getSelectedIndex()]);
    }

    @Override
    public void addRobotSuccess(RobotMainResponse robotMainResponse) {
        mRxManager.post(AppConstant.RX_ADD_ROBOT,robotMainResponse);
        finish();
    }

    @Override
    public void addRobotFailure(String error) {
        UIUtils.showToast(error);
    }

}
