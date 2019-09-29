package com.orange_infinity.vkhack.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.orange_infinity.vkhack.R;

import java.util.ArrayList;
import java.util.List;

public class OrganizationViewerFragment extends Fragment {

    private List<String> orgNames = new ArrayList<>();
    private RecyclerView organizationRecycler;
    private OrganizationAdapter organizationAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_viewer, container, false);
        orgNames.add("Политехнический музей");
        orgNames.add("Organization 2");
        orgNames.add("Organization 3");
        orgNames.add("Organization 4");
        orgNames.add("Organization 5");

        setUpRecycler(v);
        return v;
    }

    private void setUpRecycler(View v) {
        organizationAdapter = new OrganizationAdapter(orgNames);
        organizationRecycler = v.findViewById(R.id.organizationRecycler);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        organizationRecycler.setLayoutManager(layoutManager);
        organizationRecycler.setAdapter(organizationAdapter);
    }

    private class OrganizationHolder extends RecyclerView.ViewHolder {

        private View organizationView;

        OrganizationHolder(@NonNull View organizationView) {
            super(organizationView);
            this.organizationView = organizationView;
        }

        void bindView(String orgName) {
            TextView tvOrganizationName = organizationView.findViewById(R.id.tvOrganizationName);
            tvOrganizationName.setText(orgName);

            ImageView imgOrganization = organizationView.findViewById(R.id.imgOrganization);
            imgOrganization.setImageDrawable(getContext().getResources().getDrawable(R.drawable.organization));
        }
    }

    private class OrganizationAdapter extends RecyclerView.Adapter<OrganizationHolder> {

        private List<String> orgNames;

        public OrganizationAdapter(List<String> orgNames) {
            this.orgNames = orgNames;
        }

        @NonNull
        @Override
        public OrganizationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            View view = layoutInflater.inflate(R.layout.organization_cell, parent, false);

            return new OrganizationHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull OrganizationHolder holder, int position) {
            String orgName = orgNames.get(position);
            holder.bindView(orgName);
        }

        @Override
        public int getItemCount() {
            return orgNames.size();
        }
    }
}
