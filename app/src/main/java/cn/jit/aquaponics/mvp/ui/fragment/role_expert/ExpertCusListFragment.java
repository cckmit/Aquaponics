package cn.jit.aquaponics.mvp.ui.fragment.role_expert;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.xrecyclerview.XRecyclerView;
import cn.jit.aquaponics.R;
//import cn.jit.aquaponics.model.response.PageResponse;
//import cn.jit.aquaponics.model.response.RoleUserInfo;
import cn.jit.aquaponics.mvp.presenter.expert_baike.ECustomerFgPresenter;
import cn.jit.aquaponics.mvp.ui.activity.role_expert.RoleExpertActivity;
import cn.jit.aquaponics.mvp.ui.view.expert_baike.ECustomerFgView;
import cn.jit.aquaponics.uinew.first.CellListActivity;
import cn.jit.aquaponics.uinew.second.richang.RichangActivity;
import com.zxl.baselib.ui.base.BaseFragment;
import com.zxl.baselib.util.image.GlideLoaderUtils;
import com.zxl.baselib.util.ui.UIUtils;
import com.zxl.baselib.widget.CustomDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author crazyZhangxl on 2018/10/29.
 * Describe: 用户客户列表Fragment
 */
public class ExpertCusListFragment extends BaseFragment<ECustomerFgView, ECustomerFgPresenter> implements ECustomerFgView {
    @BindView(R.id.recCustom)
    XRecyclerView mRecCustom;

    private BaseQuickAdapter<RoleUserInfo,BaseViewHolder> mAdapter;
    private List<RoleUserInfo> mList = new ArrayList<>();
    /**
     * 用于保存当前获取页
     */
    private int mPage;
    private String mUserName;

    private boolean mIsFirst = true;

    private View mUserDetailView;
    private CustomDialog mUserDetailDialog;
    @Override
    public void init() {

    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_role_expert_cus_list;
    }

    @Override
    protected ECustomerFgPresenter createPresenter() {
        return new ECustomerFgPresenter((RoleExpertActivity) getActivity());
    }

    @Override
    public void initView(View rootView) {
        initAdapter();
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        mAdapter.setOnItemClickListener((adapter, view, position) -> {

            mUserName = mList.get(position-1).getUsername();

            if (mUserDetailView == null){
                mUserDetailView = View.inflate(getActivity(),R.layout.dialog_user_detail,null);
                mUserDetailDialog = new CustomDialog(getActivity(),mUserDetailView,R.style.MyDialog);
                mUserDetailView.findViewById(R.id.tvExitAccount).setOnClickListener(v1 -> {
                    mUserDetailDialog.dismiss();
//                        doLogout();
                    Intent intent = new Intent(getActivity(), RichangActivity.class);
                    intent.putExtra("username",mUserName);
                    jumpToActivity(intent);
                });

                mUserDetailView.findViewById(R.id.tvExitApp).setOnClickListener(v12 -> {
                    mUserDetailDialog.dismiss();
//                        AppManager.getAppManager().finishAllActivity();
                    Intent intent = new Intent(getActivity(), CellListActivity.class);
                    intent.putExtra("username",mUserName);
                    jumpToActivity(intent);
                });

                mUserDetailView.findViewById(R.id.tvChangePwd).setOnClickListener(v13 -> {
                    mUserDetailDialog.dismiss();
//                        jumpToActivity(ChangePwdActivity.class);
                });
            }
            mUserDetailDialog.show();
        });
    }

    private void initAdapter() {
        mRecCustom.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        mAdapter = new BaseQuickAdapter<RoleUserInfo, BaseViewHolder>(R.layout.item_customer_info,mList) {
            @Override
            protected void convert(BaseViewHolder helper, RoleUserInfo item) {
                ImageView imageView =  helper.getView(R.id.iv_expert);
                GlideLoaderUtils.display(mContext,imageView,item.getImage());
                helper.setText(R.id.tv_name,item.getUsername());
                if (TextUtils.isEmpty(item.getRealName())) {
                    helper.setVisible(R.id.tvEmailTitle,false);
                }else {
                    helper.setText(R.id.tv_email, item.getRealName());
                }
//                helper.setText(R.id.tv_maj,item.getTel());
            }
        };

        mRecCustom.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //设置的刷新
                mPage = 1;
                mPresenter.queryRoleUserInfo(mPage,2);
            }

            @Override
            public void onLoadMore() {
                // 加载更多
                mPage++;
                mPresenter.queryRoleUserInfo(mPage,2);
            }
        });
        mRecCustom.setAdapter(mAdapter);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPage = 1;
        mPresenter.queryRoleUserInfo(mPage,2);
    }

    @Override
    public void queryCustomersSuccess(PageResponse<RoleUserInfo> customerInfoPageResponse) {
        if (mIsFirst){
            if (customerInfoPageResponse != null){
                mList.clear();
                mList.addAll(customerInfoPageResponse.getList());
                mAdapter.notifyDataSetChanged();
            }
            mIsFirst = false;
        }else {
            if (mPage == 1){
                if (customerInfoPageResponse != null){
                    mList.clear();
                    mList.addAll(customerInfoPageResponse.getList());
                    mAdapter.notifyDataSetChanged();
                    // 刷新成功
                    mRecCustom.refreshComplete();
                }

            }else {
                if (customerInfoPageResponse !=null && customerInfoPageResponse.getList() != null && customerInfoPageResponse.getList().size() >0){
                    mList.addAll(customerInfoPageResponse.getList());
                    mAdapter.notifyDataSetChanged();
                    mRecCustom.refreshComplete();
                }else {
                    mRecCustom.noMoreLoading();
                }
            }
        }
    }

    @Override
    public void queryCustomerFailure(String error) {
        UIUtils.showToast(error);
        mRecCustom.refreshComplete();
        if (mIsFirst){
            mIsFirst = false;
        }

        if (mPage > 1) {
            mPage--;
        }
    }


}
