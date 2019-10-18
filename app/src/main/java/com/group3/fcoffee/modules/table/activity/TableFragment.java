package com.group3.fcoffee.modules.table.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.group3.fcoffee.R;
import com.group3.fcoffee.modules.table.adapter.TableAdapter;
import com.group3.fcoffee.modules.table.model.DTOresponse.TableDetailData;
import com.group3.fcoffee.modules.table.model.DTOresponse.TableData;
import com.group3.fcoffee.modules.table.presenter.TablePresenter;
import com.group3.fcoffee.modules.table.view.TableView;

public class TableFragment extends Fragment implements TableView, View.OnLongClickListener {

    private View mView;
    private RecyclerView mRecyclerView;
    private TableAdapter mTableAdapter;
    private TableData mTables;
    private TablePresenter mTablePresenter;
    private static TableFragment fragment;

    public static TableFragment newInstance() {
        fragment = new TableFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_table, container, false);
        initView();
        initData();
        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();
        initView();
        initData();
    }

    private void initView() {
        mRecyclerView = mView.findViewById(R.id.rcv_table);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        mRecyclerView.setLayoutManager(gridLayoutManager);
    }

    private void initData() {
        mTablePresenter = new TablePresenter(this);
        mTablePresenter.getAll();
    }

    @Override
    public void onTableSuccessGetAll(TableData dto) {
        if (dto != null) {
            mTables = dto;
            updateRcv();
        }
    }

    @Override
    public void onTableSuccessGetByNumber(TableDetailData tableDetail) {
        // TODO- TableDetailActivity
    }

    @Override
    public void onTableFail(String message) {
        Toast.makeText(mView.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void updateRcv() {
        if (mTableAdapter == null) {
            mTableAdapter = new TableAdapter(getContext(), mTables, fragment);
            mRecyclerView.setAdapter(mTableAdapter);
        } else {
            mTableAdapter.updateTableDetailData(mTables);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}