package com.example.iveci.mad4;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by iveci on 2017-03-30.
 */

public class Fragment1 extends Fragment {
    final String[] LIST_MENU = {"사과 Table","포도 Table","키위 Table","자몽 Table"};
    final Boolean[] EMPTY = {true, true, true, true};
    Button b1,b2,b3;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragv1 = inflater.inflate(R.layout.fragment1,null);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, LIST_MENU) ;
        ListView listview = (ListView) fragv1.findViewById(R.id.list01) ;
        listview.setAdapter(adapter);
        b1 = (Button) fragv1.findViewById(R.id.neworder);
        b2 = (Button) fragv1.findViewById(R.id.correct);
        b3 = (Button) fragv1.findViewById(R.id.initia);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = View.inflate(getActivity(), R.layout.order, null);
                AlertDialog.Builder order = new AlertDialog.Builder(getActivity());
                order.setTitle("새 주문")
                        .setView(view)
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity(),
                                        "입력을 취소했습니다.",Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity(),
                                        "정보가 입력되었습니다.",Toast.LENGTH_SHORT)
                                        .show();
                            }
                        }).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = View.inflate(getActivity(), R.layout.order, null);
                AlertDialog.Builder order = new AlertDialog.Builder(getActivity());
                order.setTitle("새 주문")
                        .setView(view)
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity(),
                                        "입력을 취소했습니다.",Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity(),
                                        "정보가 수정되었습니다.",Toast.LENGTH_SHORT)
                                        .show();
                            }
                        }).show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"초기화 되었습니다.",Toast.LENGTH_SHORT).show();
            }
        });

        return fragv1;
    }
}
