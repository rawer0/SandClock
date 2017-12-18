package com.ovwvwvo.sandclock.skin;

import android.support.annotation.LayoutRes;
import android.view.View;

import com.ovwvwvo.sandclock.R;

/**
 * Created by guang on 2017/12/15
 */

public class ViewHolderFactory {

    private static ViewHolderFactory viewHolderFactory = new ViewHolderFactory();

    public static ViewHolderFactory getDefault() {
        return viewHolderFactory;
    }

    private ViewHolderFactory() {
    }

    public BaseViewHolder buildViewHolder(int type, IListener listener) {
        switch (type) {
            case SkinId.SKIN_DEFAULT:
            default:
                return buildDefaultViewHolder(listener.getView(R.layout.item_detail_list));
            case SkinId.SKIN_001:
                return buildDefaultViewHolder(listener.getView(R.layout.item_detail_list_1));
        }
    }

    private BaseViewHolder buildDefaultViewHolder(View view) {
        return new ViewHolderDefault(view);
    }

    public interface IListener {
        View getView(@LayoutRes int layoutId);
    }
}
