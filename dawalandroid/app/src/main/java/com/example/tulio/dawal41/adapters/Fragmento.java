package com.example.tulio.dawal41.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.tulio.dawal41.MainActivity;
import com.example.tulio.dawal41.Tabs.AbaPai;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tulio on 06/12/2016.
 */

public class Fragmento extends FragmentStatePagerAdapter {

    private MainActivity activity;
    private List<AbaPai> abas = new ArrayList<>();

    public Fragmento(MainActivity activity, FragmentManager fm) {
        super(fm);
        this.activity = activity;
    }

    public void addAba(AbaPai aba) {
        abas.add(aba);
    }

    @Override
    public Fragment getItem(int position) {
        return abas.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return abas.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return abas.get(position).getNome();
    }
}