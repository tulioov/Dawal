package com.example.tulio.dawal41;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.tulio.dawal41.Tabs.Eletrica;
import com.example.tulio.dawal41.Tabs.Inicial;
import com.example.tulio.dawal41.Tabs.Motor;
import com.example.tulio.dawal41.Tabs.Navegacao;
import com.example.tulio.dawal41.Tabs.Proa;
import com.example.tulio.dawal41.Tabs.Tanques;
import com.example.tulio.dawal41.Ultil.DawalBluetoothObservable;
import com.example.tulio.dawal41.Ultil.DawalProperties;
import com.example.tulio.dawal41.adapters.Fragmento;


public class MainActivity extends AppCompatActivity {

    //TextView textView_Status;

    private TabLayout tab;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tab = (TabLayout) findViewById(R.id.tab);
        pager = (ViewPager) findViewById(R.id.pager);

        Fragmento abasAdapter = new Fragmento(this, getSupportFragmentManager());

        DawalProperties prop = new DawalProperties();
        prop.criarPropertie();

        Inicial inicial = new Inicial();
        inicial.setNome(getResources().getString(R.string.abaInicialNome));

        Navegacao navegacao = new Navegacao();
        navegacao.setNome(getResources().getString(R.string.abaNavegacaoNome));

        Tanques tanques = new Tanques();
        tanques.setNome(getResources().getString(R.string.abaTanqueNome));

        Eletrica eletrica = new Eletrica();
        eletrica.setNome(getResources().getString(R.string.abaEletricaNome));

        Motor motor = new Motor();
        motor.setNome(getResources().getString(R.string.abaMotorNome));

        Proa proa = new Proa();
        proa.setNome("Proa");

        abasAdapter.addAba(inicial);
        abasAdapter.addAba(navegacao);
        abasAdapter.addAba(eletrica);
        abasAdapter.addAba(tanques);
        abasAdapter.addAba(motor);
        abasAdapter.addAba(proa);

        DawalBluetoothObservable.registerObserver(inicial);
        DawalBluetoothObservable.registerObserver(navegacao);
        DawalBluetoothObservable.registerObserver(eletrica);
        DawalBluetoothObservable.registerObserver(tanques);
        DawalBluetoothObservable.registerObserver(motor);
        DawalBluetoothObservable.registerObserver(proa);

        pager.setAdapter(abasAdapter);

        tab.setupWithViewPager(pager);
    }

    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == BluetoothState.REQUEST_CONNECT_DEVICE) {
            if (resultCode == RESULT_OK) {
                String address = data.getStringExtra(BluetoothState.EXTRA_DEVICE_ADDRESS);
                spp.connect(address);
                Log.e("spp", "conectando");
            }
        }
    }
    */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
