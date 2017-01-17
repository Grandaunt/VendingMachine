package com.example.sjs.vendingmachine;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FetchCodeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FetchCodeFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private Button zeroBtn,oneBtn,twoBtn,threeBtn,fourBtn,fiveBtn,sixBtn,sevenBtn,eightBtn,nineBtn,xingBtn,jingBtn,ceBtn,okBtn;
    private ImageButton acImBtn;
    private EditText fetchCodeEditText;
    private StringBuffer stringFetchCode;


    // TODO: Rename and change types of parameters
    private String mParam1;
//    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FetchCodeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment FetchCodeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FetchCodeFragment newInstance(String param1) {
        FetchCodeFragment fragment = new FetchCodeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fetch_code, container, false);
         stringFetchCode = new StringBuffer("");
        oneBtn   = (Button) view.findViewById(R.id.btn_keybox_one);
        twoBtn   = (Button) view.findViewById(R.id.btn_keybox_two);
        threeBtn = (Button) view.findViewById(R.id.btn_keybox_three);
        fourBtn  = (Button) view.findViewById(R.id.btn_keybox_four);
        fiveBtn  = (Button) view.findViewById(R.id.btn_keybox_five);
        sixBtn   = (Button) view.findViewById(R.id.btn_keybox_six);
        sevenBtn = (Button) view.findViewById(R.id.btn_keybox_seven);
        eightBtn = (Button) view.findViewById(R.id.btn_keybox_eight);
        nineBtn  = (Button) view.findViewById(R.id.btn_keybox_nine);
        zeroBtn  = (Button) view.findViewById(R.id.btn_keybox_zero);
//        jingBtn  = (Button) view.findViewById(R.id.btn_keybox_jing);
//        xingBtn  = (Button) view.findViewById(R.id.btn_keybox_xing);
//        ceBtn    = (Button) view.findViewById(R.id.btn_keybox_ce);
        okBtn    = (Button) view.findViewById(R.id.btn_keybox_ok);
        acImBtn  = (ImageButton) view.findViewById(R.id.btn_keybox_ac);
        fetchCodeEditText= (EditText) view.findViewById(R.id.et_fetchcode);
        zeroBtn.setOnClickListener(this);
        oneBtn.setOnClickListener(this);
        twoBtn.setOnClickListener(this);
        threeBtn.setOnClickListener(this);
        fourBtn.setOnClickListener(this);
        fiveBtn.setOnClickListener(this);
        sixBtn.setOnClickListener(this);
        sevenBtn.setOnClickListener(this);
        eightBtn.setOnClickListener(this);
        nineBtn.setOnClickListener(this);
//        xingBtn.setOnClickListener(this);
//        jingBtn.setOnClickListener(this);
//        ceBtn.setOnClickListener(this);
        okBtn.setOnClickListener(this);
        acImBtn.setOnClickListener(this);
        fetchCodeEditText.setOnClickListener(this);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
//                String s = “abc”;
//                StringBuffer sb1 = new StringBuffer(“123”);
//                StringBuffer sb2 = new StringBuffer(s); //String转换为StringBuffer
//                String s1 = sb1.toString(); //StringBuffer转换为String
            case R.id.btn_keybox_zero:
                stringFetchCode.append(0);
                fetchCodeEditText.setText(stringFetchCode);
                break;
            case R.id.btn_keybox_one:
                stringFetchCode.append(1);
                fetchCodeEditText.setText(stringFetchCode);
                break;
            case R.id.btn_keybox_two:
                stringFetchCode.append(2);
                fetchCodeEditText.setText(stringFetchCode);
                break;
            case R.id.btn_keybox_three:
                stringFetchCode.append(3);
                fetchCodeEditText.setText(stringFetchCode);
                break;
            case R.id.btn_keybox_four:
                stringFetchCode.append(4);
                fetchCodeEditText.setText(stringFetchCode);
                break;
            case R.id.btn_keybox_five:
                stringFetchCode.append(5);
                fetchCodeEditText.setText(stringFetchCode);
                break;
            case R.id.btn_keybox_six:
                stringFetchCode.append(6);
                fetchCodeEditText.setText(stringFetchCode);
                break;
            case R.id.btn_keybox_seven:
                stringFetchCode.append(7);
                fetchCodeEditText.setText(stringFetchCode);
                break;
            case R.id.btn_keybox_eight:
                stringFetchCode.append(8);
                fetchCodeEditText.setText(stringFetchCode);
                break;
            case R.id.btn_keybox_nine:
                stringFetchCode.append(9);
                fetchCodeEditText.setText(stringFetchCode);
                break;

            case R.id.btn_keybox_ac:
                stringFetchCode = new StringBuffer("");
                fetchCodeEditText.setText(stringFetchCode);
                break;
//            case R.id.btn_keybox_jing:
//                String s1 = "#";
//                stringFetchCode.append(s1);
//                fetchCodeEditText.setText(stringFetchCode);
//                break;
//            case R.id.btn_keybox_xing:
//                String s2 = "*";
//                stringFetchCode.append(s2);
//                fetchCodeEditText.setText(stringFetchCode);
//                break;
//            case R.id.btn_keybox_ce:
//                InputConnection ic = getCurrentInputConnection();
//                ic.deleteSurroundingText(4, 0);
//                fetchCodeEditText.setText(stringFetchCode);
//                break;
            case R.id.btn_keybox_ok:
             //向服务器提交数据
                break;
                default:
                    break;


        }

    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
