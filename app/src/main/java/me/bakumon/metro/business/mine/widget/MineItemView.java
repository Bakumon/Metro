package me.bakumon.metro.business.mine.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import me.bakumon.metro.R;
import me.bakumon.metro.utils.ConvertUtil;

/**
 * 设置 tab 自定义 view
 *
 * @author Bakumon
 * @date 2018/1/7
 */

public class MineItemView extends CardView {
    private LayoutInflater inflater;
    private ImageView ivIcon;
    private TextView ivTitle;
    private TextView ivSubTitle;

    public MineItemView(@NonNull Context context) {
        this(context, null);
    }

    public MineItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MineItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs) {
        View view = inflate(context, R.layout.layout_mine_item);
        addView(view);
        setCardElevation(ConvertUtil.dp2px(2));
        setRadius(ConvertUtil.dp2px(5));

        ivIcon = view.findViewById(R.id.iv_setting_tab_icon);
        ivTitle = view.findViewById(R.id.tv_setting_title);
        ivSubTitle = view.findViewById(R.id.tv_setting_subtitle);

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MineItemView);
            ivIcon.setImageDrawable(a.getDrawable(R.styleable.MineItemView_icon));
            ivTitle.setText(a.getString(R.styleable.MineItemView_title));
            ivSubTitle.setText(a.getString(R.styleable.MineItemView_subtitle));
            a.recycle();
        }
    }

    private View inflate(@NonNull Context context, @LayoutRes int resource) {
        if (inflater == null) {
            inflater = LayoutInflater.from(context);
        }
        return inflater.inflate(resource, null);
    }

    public void setIcon(@DrawableRes int imageRes) {
        ivIcon.setImageResource(imageRes);
    }

    public void setTitle(String title) {
        ivTitle.setText(title);
    }

    public void setSubTitle(String subTitle) {
        ivSubTitle.setText(subTitle);
    }

}
