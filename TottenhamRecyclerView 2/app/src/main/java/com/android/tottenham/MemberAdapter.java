package com.android.tottenham;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.MyViewHolder> {
   //받

    private ArrayList<Member> mDataset;


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mName;
        public TextView mNumber;
        public ImageView mPicture;

        public MyViewHolder(View v) {
            super(v);
            mName = v.findViewById(R.id.tv_name);
            mPicture = v.findViewById(R.id.iv_picture);
            mNumber = v.findViewById(R.id.tv_number);
        }
    }

    // 메인 액티비티에서 받은 myDataset을 가져오
    public MemberAdapter(MainActivity mainActivity, int member, ArrayList<Member> myDataset) {
        mDataset = myDataset;
//
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MemberAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.member, parent, false);
                    //     반복할 xml 파일
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // 표시하는 메소드
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //데이터를 받은걸 올리기
        holder.mName.setText(mDataset.get(position).getMember());
        holder.mPicture.setImageResource(mDataset.get(position).getIcon());
        holder.mNumber.setText(mDataset.get(position).getNumber());


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
