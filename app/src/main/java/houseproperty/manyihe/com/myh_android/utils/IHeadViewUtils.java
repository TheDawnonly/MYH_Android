package houseproperty.manyihe.com.myh_android.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.IHeaderView;
import com.lcodecore.tkrefreshlayout.OnAnimEndListener;

import houseproperty.manyihe.com.myh_android.R;


/**
 * Created by Mr.周 on 2018/4/3.
 */

public class IHeadViewUtils extends FrameLayout implements IHeaderView {

    private ImageView imageView;
    private TextView textView;
    private View view;

    public IHeadViewUtils(@NonNull Context context) {
        super(context);
    }

    public IHeadViewUtils(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public IHeadViewUtils(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (view==null){
            view = View.inflate(getContext(), R.layout.head_view, null);
            //view = LayoutInflater.from(getContext()).inflate(R.layout.head_view, this);
            imageView = view.findViewById(R.id.head_iv);
            textView = view.findViewById(R.id.head_tv_new);
            addView(view);
        }
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void onPullingDown(float fraction, float maxHeadHeight, float headHeight) {
        if (fraction < 1f) textView.setText("下拉刷新");
        if (fraction > 1f) textView.setText("松开刷新");
        imageView.setRotation(fraction * headHeight / maxHeadHeight * 180);
    }

    @Override
    public void onPullReleasing(float fraction, float maxHeadHeight, float headHeight) {
        if (fraction < 1f) {
            textView.setText("下拉刷新");
            imageView.setRotation(fraction * headHeight / maxHeadHeight * 180);
            if (imageView.getVisibility() == GONE) {
                imageView.setVisibility(VISIBLE);
            }
        }

    }

    @Override
    public void startAnim(float maxHeadHeight, float headHeight) {
        textView.setText("松开刷新");
        imageView.setVisibility(VISIBLE);
    }

    @Override
    public void onFinish(OnAnimEndListener animEndListener) {
        animEndListener.onAnimEnd();
    }

    @Override
    public void reset() {

    }
}
