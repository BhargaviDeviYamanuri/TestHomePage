package sample.map.com.homepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MenuListAdapter extends BaseAdapter {
    private Context mContext;
    ArrayList<MenuDTO> mMenuOptions;
    public MenuListAdapter(Context context, ArrayList<MenuDTO> optionList) {
        mContext = context;
        mMenuOptions = optionList;
    }

    @Override
    public int getCount() {
        return mMenuOptions.size();
    }

    @Override
    public Object getItem(int i) {
        return mMenuOptions.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View listView;
        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            listView = inflater.inflate(R.layout.menu_list_item,null);
        }else {
            listView = view;
        }
        TextView titleView = (TextView) listView.findViewById(R.id.title);
        TextView subtitleView = (TextView) listView.findViewById(R.id.subTitle);
        ImageView iconView = (ImageView) listView.findViewById(R.id.icon);

        titleView.setText( mMenuOptions.get(i).mTitle );
        subtitleView.setText( mMenuOptions.get(i).mSubTitle );
        iconView.setImageResource(mMenuOptions.get(i).mOptionIcon);

        return listView;
    }
}
