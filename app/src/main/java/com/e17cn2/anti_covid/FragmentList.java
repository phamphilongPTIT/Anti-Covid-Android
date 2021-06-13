package com.e17cn2.anti_covid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e17cn2.anti_covid.model.Declaration;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentList extends Fragment implements TextWatcher {

    private RecyclerView recycleView;
    private RecycleViewAdapter recycleViewAdapter;
    private SQLiteDeclaration sqLiteDeclaration;
    private Button btGetAll, btSearch;
    private AutoCompleteTextView txtSearch;
    private String[] list;
    private FloatingActionButton bt;



    public FragmentList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        btGetAll = view.findViewById(R.id.btGetAll);
        btSearch = view.findViewById(R.id.btSearch);
        txtSearch = view.findViewById(R.id.txtTimNoiDen);
        recycleView = view.findViewById(R.id.recyclerview);
        bt= view.findViewById(R.id.fab);
        recycleView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recycleViewAdapter = new RecycleViewAdapter();
        recycleView.setAdapter(recycleViewAdapter);
        sqLiteDeclaration = new SQLiteDeclaration(requireContext());
        list=getResources().getStringArray(R.array.auto);
        txtSearch.setAdapter(new ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1,list));
        txtSearch.addTextChangedListener(this);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireActivity(), PhieuKhaiBaoYTe.class));
            }
        });


        btGetAll.setOnClickListener(v -> {
            List<Declaration> declarations = sqLiteDeclaration.getAllDeclaration();
            recycleViewAdapter.setList(declarations);
            recycleViewAdapter.notifyDataSetChanged();
            recycleView.setAdapter(recycleViewAdapter);
        });

        btSearch.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                String textName = txtSearch.getText().toString().trim();
                if (textName.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Bạn cần nhập tên cần search", Toast.LENGTH_SHORT).show();
                }else {
                    List<Declaration> declarations = sqLiteDeclaration.getListDeclarationByName(textName);
                    if (declarations.size()==0){
                        Toast.makeText(getApplicationContext(), "Không tìm thấy đối tượng nào", Toast.LENGTH_SHORT).show();
                    }
                    recycleViewAdapter.setList(declarations);
                    recycleViewAdapter.notifyDataSetChanged();
                    recycleView.setAdapter(recycleViewAdapter);
                }
            }
        });

        return view;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

}
