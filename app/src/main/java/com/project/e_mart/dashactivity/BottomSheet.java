package com.project.e_mart.dashactivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.project.e_mart.R;

public class BottomSheet extends BottomSheetDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new com.google.android.material.bottomsheet.BottomSheetDialog(requireContext(), getTheme());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.number_add, container, false);

        Button payBtn = view.findViewById(R.id.payBtn);
        payBtn.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Payment Successful", Toast.LENGTH_SHORT).show();
            dismiss();

        });


        Button cancel = view.findViewById(R.id.cancelBtn);
        cancel.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Thank You! Get Lost!", Toast.LENGTH_SHORT).show();
            dismiss();

        });
        return view;

    }
}
