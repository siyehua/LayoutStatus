package com.siyehua.layoutstatus.widget;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A class control layout status.<br><br>
 * more information, you can <a href="http://baidu.com">click this</a>.<br><br>
 * Created by siyehua on 2017/3/29.
 */
public class LayoutStatusControl implements StatusI {
    /**
     * root view
     */
    private View rootView;
    /**
     * the parent view you want to replace
     */
    private ViewGroup parentView;


    /**
     * loading view
     */
    private View loadingView;
    /**
     * the view you want to replace
     */
    private View successView;
    /**
     * empty view
     */
    private View emptyView;
    /**
     * error view
     */
    private View errorView;
    /**
     * the view is showing
     */
    private View currentView;

    /**
     * init control
     *
     * @param activity activity, use it find root view
     * @param resID    the view you want to replace
     */
    public LayoutStatusControl(Activity activity, @IdRes int resID) {
        this.rootView = activity.findViewById(android.R.id.content);
        currentView = successView = rootView.findViewById(resID);
        if (successView == null) {
            throw new IllegalStateException("Check view's id is right, And you should init this class below Activity.setContent() method.");
        }
        parentView = (ViewGroup) successView.getParent();
        if (parentView == null) {
            throw new IllegalStateException("You should init this class below Activity.setContent() method.");
        }
    }


    /**
     * set show view
     *
     * @param view view type
     */
    private void setViewInCenter(View view) {
        int index = 0;
        for (int i = 0; i < parentView.getChildCount(); i++) {
            if (parentView.getChildAt(i) == currentView) {
                index = i;
                break;
            }
        }
        parentView.removeView(currentView);
        view.setId(currentView.getId());
        ViewGroup.LayoutParams params = currentView.getLayoutParams();
        parentView.addView(view, index, params);
        currentView = view;
        parentView.postInvalidate();
    }

    /**
     * create a textView use show
     *
     * @param text tips
     * @return show View
     */
    private View createView(String text) {
        TextView textView = new TextView(parentView.getContext());
        textView.setText(text);
        textView.setTextColor(Color.parseColor("#FF00FF"));
        textView.setGravity(Gravity.CENTER);
//        textView.setBackgroundColor(Color.parseColor("#000000"));
        return textView;
    }

    /**
     * set loading view
     *
     * @param view layout
     */
    public void setLoadingView(View view) {
        loadingView = view;
        setViewInCenter(view);
    }

    /**
     * set loading view
     *
     * @param resID layout id
     */
    public void setLoadingView(@LayoutRes int resID) {
        View view = LayoutInflater.from(parentView.getContext()).inflate(resID, parentView, false);
        loadingView = view;
        setViewInCenter(view);
    }

    /**
     * set empty view
     *
     * @param view layout
     */
    public void setEmptyView(View view) {
        emptyView = view;
        setViewInCenter(view);
    }

    /**
     * set empty view
     *
     * @param resID layout id
     */
    public void setEmptyView(@LayoutRes int resID) {
        View view = LayoutInflater.from(parentView.getContext()).inflate(resID, parentView, false);
        emptyView = view;
        setViewInCenter(view);
    }

    /**
     * set error view
     *
     * @param view layout
     */
    public void setErrorView(View view) {
        errorView = view;
        setViewInCenter(view);
    }

    /**
     * set error view
     *
     * @param resID layout id
     */
    public void setErrorView(@LayoutRes int resID) {
        View view = LayoutInflater.from(parentView.getContext()).inflate(resID, parentView, false);
        errorView = view;
        setViewInCenter(view);
    }

    /**
     * set empty layout click listener
     *
     * @param listener listener
     * @param viewID   click view's id, click all empty view if viewID=-1.
     */
    public void setEmptyListener(View.OnClickListener listener, int viewID) {
        if (emptyView == null) emptyView = createView("暂无数据");
        if (viewID == -1) {
            emptyView.setOnClickListener(listener);
        } else emptyView.findViewById(viewID).setOnClickListener(listener);
    }

    /**
     * set error layout click listener
     *
     * @param listener listener
     * @param viewID   click view's id, click all error view if viewID=-1.
     */
    public void setErrorListener(View.OnClickListener listener, int viewID) {
        if (errorView == null) errorView = createView("无法连接到服务器");
        if (viewID == -1) {
            errorView.setOnClickListener(listener);
        } else errorView.findViewById(viewID).setOnClickListener(listener);
    }


    @Override
    public void showLoadingView() {
        if (loadingView == null) {
            setLoadingView(createView("正在加载..."));
        } else {
            setViewInCenter(loadingView);
        }
    }

    @Override
    public void showSuccessView() {
        setViewInCenter(successView);
    }

    @Override
    public void showEmptyView() {
        if (emptyView == null) {
            setEmptyView(createView("暂无数据"));
        } else {
            setViewInCenter(emptyView);
        }
    }

    @Override
    public void showErrorView() {
        if (errorView == null) {
            setErrorView(createView("无法连接到服务器"));
        } else {
            setViewInCenter(errorView);
        }
    }
}
