package com.example.iveci.mad4;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.ContentValues.TAG;

/**
 * Created by iveci on 2017-03-30.
 */

public class Fragment1 extends Fragment {
    final Table[] LIST_MENU = {new Table("사과 Table"),new Table("포도 Table"),new Table("키위 Table"),new Table("자몽 Table")};
    Button b1,b2,b3;
    TextView t1,t2,t3,t4,t5,t6,t7,t8;
    EditText e1,e2;
    RadioGroup r1;
    int i;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View fragv1 = inflater.inflate(R.layout.fragment1,null);
        b1 = (Button) fragv1.findViewById(R.id.neworder);
        b2 = (Button) fragv1.findViewById(R.id.correct);
        b3 = (Button) fragv1.findViewById(R.id.initia);
        t3 = (TextView) fragv1.findViewById(R.id.tablename);
        t4 = (TextView) fragv1.findViewById(R.id.tenter);
        t5 = (TextView) fragv1.findViewById(R.id.tspag);
        t6 = (TextView) fragv1.findViewById(R.id.tpizza);
        t7 = (TextView) fragv1.findViewById(R.id.tmember);
        t8 = (TextView) fragv1.findViewById(R.id.tprice);
        final ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, LIST_MENU) ;
        ListView listview = (ListView) fragv1.findViewById(R.id.list01) ;
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (LIST_MENU[position].isEmpty()){
                    i = position;
                    Refresh(i);
                    Toast.makeText(getActivity(),
                            "빈 테이블입니다.",Toast.LENGTH_SHORT)
                            .show();
                }
                else {
                    i = position;
                    Refresh(i);
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = View.inflate(getActivity(), R.layout.order, null);
                AlertDialog.Builder order = new AlertDialog.Builder(getActivity());
                Buttoninit(view);
                for ( i = 0; i < LIST_MENU.length; i++){
                    if (LIST_MENU[i].isEmpty()) {
                        t1.setText(" " + LIST_MENU[i].getTablename());
                        break;
                    }
                }
                if (i >= LIST_MENU.length) Snackbar.make(fragv1, "더이상 주문을 받을수 없습니다.", Snackbar.LENGTH_SHORT).show();
                else {
                    t2.setText(" " + new SimpleDateFormat("yyyyMMdd HH:mm")
                            .format(new Date(System.currentTimeMillis())));
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
                                    boolean mem;
                                    if (r1.getCheckedRadioButtonId() == R.id.normalman) mem = false;
                                    else mem = true;
                                    String sp = e1.getText().toString().equals("") ? "0" : e1.getText().toString();
                                    String pz = e2.getText().toString().equals("") ? "0" : e2.getText().toString();
                                    LIST_MENU[i].modTable(t2.getText().toString(),
                                            Integer.parseInt(sp),
                                            Integer.parseInt(pz), mem);
                                            Snackbar.make(fragv1, "정보가 입력되었습니다.", Snackbar.LENGTH_SHORT).show();
                                    adapter.notifyDataSetChanged();
                                    Refresh(i);
                                }
                            }).show();
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = View.inflate(getActivity(), R.layout.order, null);
                AlertDialog.Builder order = new AlertDialog.Builder(getActivity());
                Buttoninit(view);
                if (i >= LIST_MENU.length) Snackbar.make(fragv1, "수정할 주문이 없습니다.", Snackbar.LENGTH_SHORT).show();
                else if (LIST_MENU[i].isEmpty()) Snackbar.make(fragv1, "비어있는 테이블은 수정할 수 없습니다.", Snackbar.LENGTH_SHORT).show();
                else{
                    t1.setText(t3.getText().toString());
                    t2.setText(t4.getText().toString());
                    order.setTitle("주문 수정")
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
                                    boolean mem;
                                    if (r1.getCheckedRadioButtonId() == R.id.normalman) mem = false;
                                    else mem = true;
                                    String sp = e1.getText().toString().equals("") ? "0" : e1.getText().toString();
                                    String pz = e2.getText().toString().equals("") ? "0" : e2.getText().toString();
                                    LIST_MENU[i].modTable(
                                            Integer.parseInt(sp),
                                            Integer.parseInt(pz), mem);
                                    Snackbar.make(fragv1, "정보가 수정되었습니다.", Snackbar.LENGTH_SHORT).show();
                                    adapter.notifyDataSetChanged();
                                    Refresh(i);
                                }
                            }).show();
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i >= LIST_MENU.length) Snackbar.make(fragv1, "초기화할 테이블을 선택하시기 바랍니다.", Snackbar.LENGTH_SHORT).show();
                else {
                    LIST_MENU[i].modTable("",0,0,false);
                    Snackbar.make(fragv1, "초기화 되었습니다.",Snackbar.LENGTH_SHORT).show();
                    adapter.notifyDataSetChanged();
                    Refresh(i);
                }
            }
        });
        return fragv1;
    }

    public void Refresh(int position){//notifyDataChanged 이후 변경된 Data를 화면에 반영.
        t3.setText(LIST_MENU[position].toString());
        if (!LIST_MENU[position].isEmpty()){
            int spa = LIST_MENU[position].getNumspag();
            int piz = LIST_MENU[position].getNumpizza();
            t4.setText(LIST_MENU[position].getEnterDate());
            t5.setText(spa+"");
            t6.setText(piz+"");
            t7.setText(LIST_MENU[position].getMember() ? "VIP멤버쉽" : "기본멤버쉽");
            t8.setText(LIST_MENU[position].getMember() ? ((spa * 10000 + piz * 12000)/10)*7 + "원" : ((spa * 10000 + piz * 12000)/10)*9 + "원" );
        }
        else{
            t4.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
            t8.setText("0원");
        }
    }

    public void Buttoninit(View v){//주문,수정용 초기화.
        t1 = (TextView) v.findViewById(R.id.autotab);
        t2 = (TextView) v.findViewById(R.id.autotime);
        e1 = (EditText) v.findViewById(R.id.spagetti);
        e2 = (EditText) v.findViewById(R.id.pizza);
        r1 = (RadioGroup) v.findViewById(R.id.membership);
    }

}
