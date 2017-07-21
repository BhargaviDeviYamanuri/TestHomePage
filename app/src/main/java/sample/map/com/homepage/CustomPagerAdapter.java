package sample.map.com.homepage;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


class CustomPagerAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    private int[] mResources = {
            R.drawable.tedy1,
            R.drawable.tedy2,
            R.drawable.tedy3,
            R.drawable.test5,
            R.drawable.images1,
    };
    private String[] mTitleResources = {
            "chain smoker new album 2016",
            "chain smoker new album 2015",
            "chain smoker new album 2014",
            "chain smoker new album 2013",
            "chain smoker new album 2012",
    };
    private String[] mSubTitleResources = {
            "ft.rihan and user",
            "ft.rihan and user 2015",
            "ft.rihan and user 2014",
            "ft.rihan and user 2013",
            "ft.rihan and user 2012",
    };
    public CustomPagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.image_slide_layout, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.item_image);
        TextView title = (TextView)itemView.findViewById(R.id.main_title);
        TextView subtitle = (TextView)itemView.findViewById(R.id.sub_title);
        imageView.setImageResource(mResources[position]);
        title.setText(mTitleResources[position]);
        subtitle.setText(mSubTitleResources[position]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}