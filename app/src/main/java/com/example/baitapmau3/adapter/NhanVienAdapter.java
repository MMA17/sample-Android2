package com.example.baitapmau3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.baitapmau3.Class.NhanVien;
import com.example.baitapmau3.R;

import java.util.List;

public class NhanVienAdapter extends BaseAdapter {
    private List<NhanVien> listNV;
    private Context context;

    private class viewHolder{
        TextView id,ten;

    }

    public NhanVienAdapter(List<NhanVien> listNV, Context context) {
        this.listNV = listNV;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listNV.size();
    }

    @Override
    public Object getItem(int i) {
        return listNV.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewHolder vh = new viewHolder();
        if (view == null) {
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.nhanvien_item, null);
            vh.id = view.findViewById(R.id.textIDNV);
            vh.ten = view.findViewById(R.id.textTenNV);

            view.setTag(vh);
        }
        else {
            vh = (viewHolder) view.getTag();
        }
        vh.id.setText(listNV.get(i).getId());
        vh.ten.setText(listNV.get(i).getTen());


        return view;
    }
}
