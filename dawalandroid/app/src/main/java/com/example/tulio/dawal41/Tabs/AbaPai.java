package com.example.tulio.dawal41.Tabs;

import android.support.v4.app.Fragment;

/**
 * Created by Tulio on 04/01/2017.
 */

public abstract class AbaPai extends Fragment {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Fragment getFragment() {
        return this;
    }
}
