package com.example.kstedman.mathapplication.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kstedman.mathapplication.R;
import com.example.kstedman.mathapplication.models.WolframResponseModel;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ResponseDetailFragment extends Fragment {

    @Bind(R.id.responseValueView) TextView mResponseValue;
    @Bind(R.id.responseTitleView) TextView mResponseTitle;
    @Bind(R.id.step1TitleText) TextView mResponseStep1Title;
    @Bind(R.id.step1ValueText) TextView mResponseStep1Value;
    @Bind(R.id.step2TitleText) TextView mResponseStep2Title;
    @Bind(R.id.step2ValueText) TextView mResponseStep2Value;
    @Bind(R.id.step3TitleText) TextView mResponseStep3Title;
    @Bind(R.id.step3ValueText) TextView mResponseStep3Value;

    private WolframResponseModel mResponseModel;

    public static ResponseDetailFragment newInstance(WolframResponseModel wolframModel) {
        ResponseDetailFragment responseDetailFragment = new ResponseDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("wolfarmModel", Parcels.wrap(wolframModel));
        responseDetailFragment.setArguments(args);
        return responseDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mResponseModel = Parcels.unwrap(getArguments().getParcelable("wolframModel"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_response_detail, container, false);
        ButterKnife.bind(this, view);


        Log.v("detail frag", "this is where we set text");
        mResponseValue.setText(mResponseModel.getValue());
        mResponseTitle.setText(mResponseModel.getTitle());



        return view;
    }

}
