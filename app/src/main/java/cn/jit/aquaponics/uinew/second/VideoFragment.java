package cn.jit.aquaponics.uinew.second;

import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import cn.jit.aquaponics.R;
//import cn.jit.aquaponics.model.bean.MainBean;
import cn.jit.aquaponics.uinew.second.feeding.FeedingFoodListActivity;
import cn.jit.aquaponics.uinew.second.fishInput.FishInputListActivity;
import cn.jit.aquaponics.uinew.second.guding.GudingActivity;
import cn.jit.aquaponics.uinew.second.input.InputListActivity;
import cn.jit.aquaponics.uinew.second.reagent.ReagentInputListActivity;
import cn.jit.aquaponics.uinew.second.template.FeedingTemplateListActivity;
import cn.jit.aquaponics.uinew.second.xiaoyi.goumai.GoumaiActivity;
import cn.jit.aquaponics.uinew.second.xiaoyi.xiaoshou.XiaoshouActivity;
import com.zxl.baselib.ui.base.BaseFragment;
import com.zxl.baselib.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by yuanyuan on 2019/3/11.
 */

public class VideoFragment extends BaseFragment {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private BaseQuickAdapter<MainBean, BaseViewHolder> mAdapter;
    private List<MainBean> mMainBeanList = new ArrayList<>();

    public static VideoFragment newInstance() {

        Bundle args = new Bundle();

        VideoFragment fragment = new VideoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void init() {
        /*购销记录*/
//        mMainBeanList.add(new MainBean(R.mipmap.record,""));
//        mMainBeanList.add(new MainBean(R.mipmap.blank_icon,""));
        mMainBeanList.add(new MainBean(R.mipmap.icon_d_goumai,"购买记账"));
        mMainBeanList.add(new MainBean(R.mipmap.icon_d_xiaoyi,"销售记账"));
//        mMainBeanList.add(new MainBean(R.mipmap.icon_d_richang,"日常投入"));
//        mMainBeanList.add(new MainBean(R.mipmap.icon_d_moban,"日常投入模板"));
        /*基础配置*/
//        mMainBeanList.add(new MainBean(R.mipmap.base_settings,""));
//        mMainBeanList.add(new MainBean(R.mipmap.blank_icon,""));
        mMainBeanList.add(new MainBean(R.mipmap.icon_d_guding,"固定投入"));
        mMainBeanList.add(new MainBean(R.mipmap.icon_d_input,"投入品配置"));
        mMainBeanList.add(new MainBean(R.mipmap.icon_d_fish_input_add,"鱼苗投入"));
        mMainBeanList.add(new MainBean(R.mipmap.icon_d_moban,"投喂模板"));
        /*养殖日志*/
//        mMainBeanList.add(new MainBean(R.mipmap.raise_record,""));
//        mMainBeanList.add(new MainBean(R.mipmap.blank_icon,""));
        mMainBeanList.add(new MainBean(R.mipmap.icon_d_food_input,"投喂饲料"));
        mMainBeanList.add(new MainBean(R.mipmap.icon_d_reagent,"投喂调水剂"));
//        mMainBeanList.add(new MainBean(R.mipmap.icon_d_xunshi,"巡视检查"));
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_video;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void initView(View rootView) {
        initAdapter();
    }

    private void initAdapter() {
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
        if (mAdapter == null){
            mAdapter = new BaseQuickAdapter<MainBean, BaseViewHolder>(R.layout.item_diary,mMainBeanList) {
                @Override
                protected void convert(BaseViewHolder helper, MainBean item) {
                    ImageView ivImage =  helper.getView(R.id.iv_dtype);
                    Glide.with(getActivity()).load(item.getImageSource()).into(ivImage);
                    helper.setText(R.id.tv_dname,item.getImageDes());
                }
            };
        }
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            switch (position){
                case 0:
                    jumpToActivity(GoumaiActivity.class);
                    break;
                case 1:
                    jumpToActivity(XiaoshouActivity.class);
                    break;
                case 2:
                    jumpToActivity(GudingActivity.class);
                    break;
                case 3:
                    jumpToActivity(InputListActivity.class);
                    break;
                case 4:
                    jumpToActivity(FishInputListActivity.class);
                    break;
                case 5:
                    jumpToActivity(FeedingTemplateListActivity.class);
                    break;
                case 6:
                    jumpToActivity(FeedingFoodListActivity.class);
                    break;
                case 7:
                    jumpToActivity(ReagentInputListActivity.class);
                    break;
//                case 8:
//                    jumpToActivity(RizhiActivity.class);
//                    break;
//                case 3:
//                    jumpToActivity(RichangActivity.class);
//                    break;
//                case 2:
//                    jumpToActivity(MobanActivity.class);
//                    break;
            }
        });
    }
}
