package org.bottiger.podcast.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.graphics.Palette;
import android.text.TextUtils;
import android.util.AttributeSet;

import org.bottiger.podcast.listeners.PaletteListener;
import org.bottiger.podcast.utils.ColorExtractor;

/**
 * Created by apl on 12-02-2015.
 */
public class FloatingActionButton extends android.support.design.widget.FloatingActionButton implements PaletteListener {

    private String mURL;
    private Context mContext;

    public FloatingActionButton(Context context) {
        super(context);
        mContext = context;
    }

    public FloatingActionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public FloatingActionButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
    }

    @Override
    public void onPaletteFound(Palette argChangedPalette) {
        ColorExtractor extractor = new ColorExtractor(mContext, argChangedPalette);
        setBackgroundTintList(ColorStateList.valueOf(extractor.getPrimary()));
        super.setRippleColor(extractor.getPrimaryTint());

        invalidate();
    }

    @Override
    public String getPaletteUrl() {
        if (!TextUtils.isEmpty(mURL)) {
            throw new IllegalStateException("URL must not be null");
        }

        return mURL;
    }
}
