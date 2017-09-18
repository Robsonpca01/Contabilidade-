package br.com.dev.robson.contabilidade;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageButton buttonLogo;
    WebView webView;
    TabLayout tabx;
    ArrayList<String> textoAbas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


*/
        buttonLogo = (ImageButton) findViewById(R.id.imageButtonLogo);
        buttonLogo.setVisibility(View.INVISIBLE);
        webView = (WebView) findViewById(R.id.webview);
        webView.setVisibility(View.INVISIBLE);

        tabx =(TabLayout) findViewById(R.id.tabx);
        tabx.setVisibility(View.INVISIBLE);


        tabx.addOnTabSelectedListener (new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(!textoAbas.isEmpty())
                webView.loadData(textoAbas.get(tab.getPosition()), "text/html; charset=utf-8", "UTF-8");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
// called when tab unselected
                int t = 44;
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
// called when a tab is reselected
                int t = 44;
            }
        });
        //

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        drawer.openDrawer(Gravity.LEFT);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_regime_trib) {
            //remove todas as abas
            tabx.removeAllTabs();

            //cria abas novas para o item selecionado
            tabx.addTab(tabx.newTab().setText("Regime Tributário"));
            tabx.addTab(tabx.newTab().setText("Lucro Real"));
            tabx.addTab(tabx.newTab().setText("Lucro Presumido"));

            textoAbas.clear();
            textoAbas.add(getResources().getString(R.string.regime_tributario1));
            textoAbas.add(getResources().getString(R.string.regime_tributario2));
            textoAbas.add(getResources().getString(R.string.regime_tributario3));


            buttonLogo.setVisibility(View.INVISIBLE);
            tabx.setVisibility(View.VISIBLE);
            webView.setVisibility(View.VISIBLE);
            //altera o webview com o texto correto
            webView.loadData(getResources().getString(R.string.regime_tributario1), "text/html; charset=utf-8", "UTF-8");

        } else if (id == R.id.nav_tipo_juridico) {
            //remove todas as abas
            tabx.removeAllTabs();

            //cria abas novas para o item selecionado
            tabx.addTab(tabx.newTab().setText("Tipos Jurídicos"));

            //remove todos os textos
            textoAbas.clear();
            textoAbas.add(getResources().getString(R.string.tipos_juridicos1));


            buttonLogo.setVisibility(View.INVISIBLE);
            tabx.setVisibility(View.VISIBLE);
            webView.setVisibility(View.VISIBLE);
            //altera o webview com o texto correto
            webView.loadData(getResources().getString(R.string.tipos_juridicos1), "text/html; charset=utf-8", "UTF-8");
        } else if (id == R.id.nav_abertura_empresas) {
            //remove todas as abas
            tabx.removeAllTabs();

            //cria abas novas para o item selecionado
            tabx.addTab(tabx.newTab().setText("1ª Seção"));
            tabx.addTab(tabx.newTab().setText("2ª Seção"));

            textoAbas.clear();
            textoAbas.add(getResources().getString(R.string.abertura_empresas1));
            textoAbas.add(getResources().getString(R.string.abertura_empresas2));


            buttonLogo.setVisibility(View.INVISIBLE);
            tabx.setVisibility(View.VISIBLE);
            webView.setVisibility(View.VISIBLE);
            //altera o webview com o texto correto
            webView.loadData(getResources().getString(R.string.abertura_empresas1), "text/html; charset=utf-8", "UTF-8");


        } else if (id == R.id.nav_decore) {

            //remove todas as abas
            tabx.removeAllTabs();

            //cria abas novas para o item selecionado
            tabx.addTab(tabx.newTab().setText("1ª Seção"));
            tabx.addTab(tabx.newTab().setText("2ª Seção"));
            tabx.addTab(tabx.newTab().setText("3ª Seção"));

            textoAbas.clear();
            textoAbas.add(getResources().getString(R.string.decore1));
            textoAbas.add(getResources().getString(R.string.decore2));
            textoAbas.add(getResources().getString(R.string.decore3));


            buttonLogo.setVisibility(View.INVISIBLE);
            tabx.setVisibility(View.VISIBLE);
            webView.setVisibility(View.VISIBLE);
            //altera o webview com o texto correto
            webView.loadData(getResources().getString(R.string.decore1), "text/html; charset=utf-8", "UTF-8");

        } else if (id == R.id.nav_dpto_pessoal) {

            //remove todas as abas
            tabx.removeAllTabs();

            //cria abas novas para o item selecionado
            tabx.addTab(tabx.newTab().setText("DEPARTAMENTO PESSOAL"));

            textoAbas.clear();
            textoAbas.add(getResources().getString(R.string.dpto_pessoal1));


            buttonLogo.setVisibility(View.INVISIBLE);
            tabx.setVisibility(View.VISIBLE);
            webView.setVisibility(View.VISIBLE);
            //altera o webview com o texto correto
            webView.loadData(getResources().getString(R.string.dpto_pessoal1), "text/html; charset=utf-8", "UTF-8");

        }


        //fecha drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
