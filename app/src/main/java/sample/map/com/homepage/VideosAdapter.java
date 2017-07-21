package sample.map.com.homepage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.MyViewHolder> {
    private ArrayList<VideosDTO> mItemList;

    public VideosAdapter(ArrayList<VideosDTO> mItemList) {
        this.mItemList = mItemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.vedios_items_layout,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
       VideosDTO dto =mItemList.get(position);
        holder.mImage.setImageResource(dto.getVideoImage());
        holder.mTitle.setText(dto.getVideosTitle());
        holder.mTime.setText(dto.getVideosTime());
        holder.mDecs.setText(dto.getVideosDecs());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle, mTime, mDecs;
        ImageView mImage;

        MyViewHolder(View itemView) {
            super(itemView);

            mImage = (ImageView) itemView.findViewById(R.id.vedios_image);
            mTitle = (TextView) itemView.findViewById(R.id.video_title);
            mTime = (TextView) itemView.findViewById(R.id.video_time);
            mDecs = (TextView) itemView.findViewById(R.id.video_description);
        }
    }
}
