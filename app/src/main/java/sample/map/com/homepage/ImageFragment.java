package sample.map.com.homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ImageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vedios_fragement, container, false);
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        TextView mNoItems = (TextView)view.findViewById(R.id.no_items);
        mRecyclerView.setVisibility(View.GONE);
        mNoItems.setVisibility(View.VISIBLE);
        mNoItems.setText("There is no images");
        mNoItems.setTextColor(getResources().getColor(R.color.colorAccent));
        return view;
    }
}
