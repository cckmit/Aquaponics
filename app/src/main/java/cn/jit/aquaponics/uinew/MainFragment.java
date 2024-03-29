package cn.jit.aquaponics.uinew;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.jit.aquaponics.R;
import cn.jit.aquaponics.uinew.first.data.CellListFragment;
import cn.jit.aquaponics.uinew.fourth.ProfileFragment;
import cn.jit.aquaponics.uinew.second.VideoFragment;
import cn.jit.aquaponics.uinew.third.DiaryFragment;
import cn.jit.aquaponics.uinew.view.BottomBar;
import cn.jit.aquaponics.uinew.view.BottomBarTab;

import me.yokeyword.fragmentation.SupportFragment;


/**
 * Created by YoKeyword on 16/6/30.
 */
public class MainFragment extends SupportFragment {
    private static final int REQ_MSG = 10;

    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOURTH = 3;
//    public static final int FIFTH = 3;

    private SupportFragment[] mFragments = new SupportFragment[4];

    private BottomBar mBottomBar;


    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        if (savedInstanceState == null) {
            mFragments[FIRST] = CellListFragment.newInstance();
            mFragments[SECOND] = VideoFragment.newInstance();
            mFragments[THIRD] = DiaryFragment.newInstance();
            mFragments[FOURTH] = ProfileFragment.newInstance();
//            mFragments[FIFTH] = ExpertSysFragment.newInstance();

            loadMultipleRootFragment(R.id.fl_tab_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOURTH]);
//                    mFragments[FIFTH]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用,也可以通过getChildFragmentManager.getFragments()自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[FIRST] = findChildFragment(CellListFragment.class);
            mFragments[SECOND] = findChildFragment(VideoFragment.class);
            mFragments[THIRD] = findChildFragment(DiaryFragment.class);
            mFragments[FOURTH] = findChildFragment(ProfileFragment.class);
//            mFragments[FIFTH] = findChildFragment(ExpertSysFragment.class);
        }

        initView(view);
        return view;
    }

    private void initView(View view) {
//        EventBus.getDefault().register(this);
        mBottomBar = (BottomBar) view.findViewById(R.id.bottomBar);

        mBottomBar
                .addItem(new BottomBarTab(_mActivity, R.mipmap.tab_cruise_normal, "数据管理"))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.tab_rzhi_normal, "种养日志"))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.tab_breed_normal, "专家问答"))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.tab_my_normal, "个人中心"));
//                .addItem(new BottomBarTab(_mActivity, R.drawable.ic_expert_white, "专家系统"));

        // 模拟未读消息
        mBottomBar.getItem(FIRST).setUnreadCount(0);

        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments[position], mFragments[prePosition]);

//                BottomBarTab tab = mBottomBar.getItem(FIRST);
//                if (position == FIRST) {
//                    tab.setUnreadCount(0);
//                } else {
//                    tab.setUnreadCount(tab.getUnreadCount() + 1);
//                }
        }

        @Override
        public void onTabUnselected(int position) {

        }

            @Override
            public void onTabReselected(int position) {
                // 这里推荐使用EventBus来实现 -> 解耦
                // 在FirstPagerFragment,FirstHomeFragment中接收, 因为是嵌套的Fragment
                // 主要为了交互: 重选tab 如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
//                EventBus.getDefault().post(new TabSelectedEvent(position));
            }
        });
    }

//    @Override
//    protected void onFragmentResult(int requestCode, int resultCode, Bundle data) {
//        super.onFragmentResult(requestCode, resultCode, data);
//        if (requestCode == REQ_MSG && resultCode == RESULT_OK) {
//
//        }
//    }



    /**
     * start other BrotherFragment
     */
//    @Subscribe
//    public void startBrother(StartBrotherEvent event) {
//        start(event.targetFragment);
//    }

    @Override
    public void onDestroyView() {
//        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }


}
