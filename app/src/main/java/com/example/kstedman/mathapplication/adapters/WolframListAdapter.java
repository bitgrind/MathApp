package com.example.kstedman.mathapplication.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.kstedman.mathapplication.R;
import com.example.kstedman.mathapplication.models.WolframResponseModel;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WolframListAdapter extends RecyclerView.Adapter<WolframListAdapter.WolframViewHolder> {
    private ArrayList<WolframResponseModel> mResponses = new ArrayList<>();
    private Context mContext;

    public WolframListAdapter(Context context, ArrayList<WolframResponseModel> responses) {
        mContext = context;
        mResponses = responses;
    }

    @Override
    public int getItemCount() {
        return mResponses.size();
    }

    public class WolframViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.solveValueView) TextView mSolveValue;
        @Bind(R.id.solveTitleView) TextView mSolveTitle;

        private Context mContext;

        public WolframViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindWolframResponse(WolframResponseModel responseModel) {
            mSolveValue.setText(responseModel.getValue());
            mSolveTitle.setText(responseModel.getTitle());
        }
    }

}
