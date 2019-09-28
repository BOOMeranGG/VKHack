package com.orange_infinity.vkhack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.orange_infinity.vkhack.ui.activities.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private List<String> skills = new ArrayList<>();
    private SkillHolder skillHolder;
    private SkillAdapter skillAdapter;
    private RecyclerView skillRecycler;

    public MainActivity() {
        super(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpBottomNavigation();
        skills.add("Hello");
        skills.add("Kitty");
        skills.add("Motherfucker");
        skills.add("fu*ck");
        skills.add("mamaamakriminak");
        skills.add("255");

        setUpRecycler();
    }

    private void setUpRecycler() {
        skillAdapter = new SkillAdapter(skills);
        skillRecycler = findViewById(R.id.recyclerSkills);
        skillRecycler.setLayoutManager(new GridLayoutManager(this, 3));
        skillRecycler.setAdapter(skillAdapter);
    }

    private void updateUi() {
        skillAdapter.skills = skills;
        skillAdapter.notifyDataSetChanged();
    }

    private class SkillHolder extends RecyclerView.ViewHolder {

        private View skillView;

        SkillHolder(View skillView) {
            super(skillView);
            this.skillView = skillView;
        }

        private void bindView(String skill) {
            TextView tvSkill = skillView.findViewById(R.id.tvSkill);
            tvSkill.setText(skill);
        }
    }

    private class SkillAdapter extends RecyclerView.Adapter<SkillHolder>{

        private List<String> skills;

        SkillAdapter(List<String> skills) {
            this.skills = skills;
        }

        @NonNull
        @Override
        public SkillHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
            View view = layoutInflater.inflate(R.layout.skill_list , parent, false);

            return new SkillHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull SkillHolder holder, int position) {
            String skill = skills.get(position);
            holder.bindView(skill);
        }

        @Override
        public int getItemCount() {
            return skills.size();
        }
    }
}
