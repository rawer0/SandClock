package com.ovwvwvo.sandclock.skin;

import android.support.annotation.LayoutRes;
import android.view.View;

import com.ovwvwvo.sandclock.R;
import com.ovwvwvo.sandclock.skin.mainItem.BaseViewHolder;
import com.ovwvwvo.sandclock.skin.mainItem.ViewHolder001;
import com.ovwvwvo.sandclock.skin.mainItem.ViewHolderDefault;

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
            default:
            case SkinId.SKIN_DEFAULT:
                return new ViewHolderDefault(listener.getView(R.layout.item_home_defaut));
            case SkinId.SKIN_001:
                return new ViewHolder001(listener.getView(R.layout.item_home_001));
        }
    }

    public interface IListener {
        View getView(@LayoutRes int layoutId);
    }
}
