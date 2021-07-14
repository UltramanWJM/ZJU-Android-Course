package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {

    private LottieAnimationView lt;
    private AnimatorSet animatorSet;
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_placeholder, container, false);

        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件

        //获取实例
        recyclerView = v.findViewById(R.id.recycler_view);
        //更改数据时不会变更宽高
        recyclerView.setHasFixedSize(true);
        //创建线性布局管理器
        LinearLayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(getContext());
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //创建Adapter
        mAdapter = new MyAdapter(TestDataSet.getData());
        //设置Adapter
        recyclerView.setAdapter(mAdapter);
        //分割线
        //LinearItemDecoration itemDecoration = new LinearItemDecoration(Color.BLUE);
//        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        //动画
        DefaultItemAnimator animator = new DefaultItemAnimator();
        animator.setAddDuration(3000);
        recyclerView.setItemAnimator(animator);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                ObjectAnimator animator0 = ObjectAnimator.ofFloat(getView().findViewById(R.id.animation_view),"alpha",1f,0f);
                animator0.setDuration(10);
                animator0.setRepeatCount(1);
                animator0.setInterpolator(new LinearInterpolator());
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(getView().findViewById(R.id.recycler_view),"alpha",0f,1f);
                animator1.setDuration(10);
                animator0.setRepeatCount(1);
                animator1.setInterpolator(new LinearInterpolator());
                animatorSet = new AnimatorSet();
                animatorSet.playTogether(animator0,animator1);
                animatorSet.start();



            }
        }, 5000);
    }
}
