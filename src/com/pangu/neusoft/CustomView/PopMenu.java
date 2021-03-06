package com.pangu.neusoft.CustomView;

import com.pangu.neusoft.healthe.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager.LayoutParams;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.view.View;
import android.view.View.OnClickListener;

@SuppressLint("NewApi")
public class PopMenu extends PopupWindow
{
	private View conentView;
	 
    public  PopMenu(final Activity context,final int contentViewLayout) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        conentView = inflater.inflate(contentViewLayout, null);
        int h = context.getWindowManager().getDefaultDisplay().getHeight();
        int w = context.getWindowManager().getDefaultDisplay().getWidth();
        // 设置SelectPicPopupWindow的View
        this.setContentView(conentView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(w / 2 + 50);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
        this.update();
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0000000000);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(dw);
        // mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
        // 设置SelectPicPopupWindow弹出窗体动画效果
        //this.setAnimationStyle(R.style.AnimationPreview);
        /*
        LinearLayout addTaskLayout = (LinearLayout) conentView
                .findViewById(R.id.add_task_layout);
        LinearLayout teamMemberLayout = (LinearLayout) conentView
                .findViewById(R.id.team_member_layout);
        addTaskLayout.setOnClickListener(new OnClickListener() {
 
            @Override
            public void onClick(View arg0) {
            	CustomPopMenu.this.dismiss();
            }
        });
 
        teamMemberLayout.setOnClickListener(new OnClickListener() {
 
            @Override
            public void onClick(View v) {
            	CustomPopMenu.this.dismiss();
            }
        });*/
        if (this.isTouchable())
		{
			this.dismiss();
		} 
    }
    	
    /**
     * 显示popupWindow
     * 
     * @param parent
     */
    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            // 以下拉方式显示popupwindow
            this.showAsDropDown(parent, parent.getLayoutParams().width / 2, 18);
        } else {
            this.dismiss();
        }
    }
    
    public View getContentView(){
    	
    	return conentView;
    }
	
}
