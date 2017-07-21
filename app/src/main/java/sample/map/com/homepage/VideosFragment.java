package sample.map.com.homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class VideosFragment extends Fragment {
    private ArrayList<VideosDTO> mList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vedios_fragement, container, false);
        RecyclerView mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        VideosAdapter mAdapter = new VideosAdapter(mList);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        prepareData();
        return view;
    }

    private void prepareData() {
        VideosDTO videos = new VideosDTO("Emptiness ft.justin tiblekar", "18 hours ago", "Loerm ipsum simply dummy text Loerm ipsum simply dummy text",R.drawable.images1);
        mList.add(videos);
        videos = new VideosDTO("Emptiness ft.justin tiblekar", "18 hours ago", "Loerm ipsum simply dummy text Loerm ipsum simply dummy text",R.drawable.tedy1);
        mList.add(videos);
        videos = new VideosDTO("i'm falling love with you", "20 hours ago", "Loerm ipsum simply dummy text Loerm ipsum simply dummy text",R.drawable.tedy2);
        mList.add(videos);
        videos = new VideosDTO("baby ft.justin baber", "22 hours ago", "Loerm ipsum simply dummy text Loerm ipsum simply dummy text",R.drawable.tedy3);
        mList.add(videos);
        videos = new VideosDTO("Emptiness ft.justin tiblekar", "23 hours ago", "Loerm ipsum simply dummy text Loerm ipsum simply dummy text",R.drawable.test5);
        mList.add(videos);
        videos = new VideosDTO("Emptiness ft.justin tiblekar", "25 hours ago", "Loerm ipsum simply dummy text Loerm ipsum simply dummy text",R.drawable.images1);
        mList.add(videos);
    }
}
