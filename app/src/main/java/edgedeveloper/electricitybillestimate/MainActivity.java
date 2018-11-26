package edgedeveloper.electricitybillestimate;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.text.DecimalFormat;
import java.util.ArrayList;

import edgedeveloper.electricitybillestimate.Controller.FeedAdapter;
import edgedeveloper.electricitybillestimate.Controller.Post;
import edgedeveloper.electricitybillestimate.Controller.RecyclerViewAdapter;
import edgedeveloper.electricitybillestimate.Model.Abuja;
import edgedeveloper.electricitybillestimate.Model.Benin;
import edgedeveloper.electricitybillestimate.Model.Eko;
import edgedeveloper.electricitybillestimate.Model.Enugu;
import edgedeveloper.electricitybillestimate.Model.Ibadan;
import edgedeveloper.electricitybillestimate.Model.Ikeja;
import edgedeveloper.electricitybillestimate.Model.Jos;
import edgedeveloper.electricitybillestimate.Model.Kaduna;
import edgedeveloper.electricitybillestimate.Model.Kano;
import edgedeveloper.electricitybillestimate.Model.PortHarcout;
import edgedeveloper.electricitybillestimate.Model.Yola;

import static java.lang.Integer.parseInt;


public class MainActivity extends AppCompatActivity {
    final String TAG = MainActivity.class.getSimpleName();
    private final Context c = this;
    private String wattageString, hoursOrMinsString;
    private String distco, tarrifCode, theAppliance;
    private int theValueOfTheWatt;
    private float bill;
    private float theHoursofUSE;
    private FeedAdapter adapter;
    private ArrayList<Post> arrayList;
    private RecyclerView mRecyclerView;
    private ArrayList<Float> myMonthlyBills;
    private Post post;
    private Spinner disco, appliance, tarrif, spinnerHoursOrMins;
    private EditText theWattageEditText, hoursOfUsage;
    private float tarrifCodePRICE, usage, totalTimeOfUsage;
    private int indexOFtarrif, indexOFdisco;
    private DecimalFormat formatter;
    private AdView mAdView;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this,"ca-app-pub-9297690518647609~6165838175");

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        arrayList = new ArrayList<>();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this);
        mRecyclerView.setAdapter(recyclerViewAdapter);

        myMonthlyBills = new ArrayList<>();

        indexOFtarrif = 0;
        indexOFdisco = 0;
        formatter = new DecimalFormat("#,###.##");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private float myBillPerMonth() {
        tarrifCodePRICE = 0;
        if (("Abuja").equals(distco)) {
            Abuja abuja = new Abuja();
            if (("R1").equals(tarrifCode)) {
                tarrifCodePRICE = abuja.getR1();
            } else if (("R2").equals(tarrifCode)) {
                tarrifCodePRICE = abuja.getR2();
            } else if (("R3").equals(tarrifCode)) {
                tarrifCodePRICE = abuja.getR3();
            } else if (("R4").equals(tarrifCode)) {
                tarrifCodePRICE = abuja.getR4();
            } else if (("C1").equals(tarrifCode)) {
                tarrifCodePRICE = abuja.getC1();
            } else if (("C2").equals(tarrifCode)) {
                tarrifCodePRICE = abuja.getC2();
            } else if (("C3").equals(tarrifCode)) {
                tarrifCodePRICE = abuja.getC3();
            } else if (("D1").equals(tarrifCode)) {
                tarrifCodePRICE = abuja.getD1();
            } else if (("D2").equals(tarrifCode)) {
                tarrifCodePRICE = abuja.getD2();
            } else if (("D3").equals(tarrifCode)) {
                tarrifCodePRICE = abuja.getD3();
            } else if (("A1").equals(tarrifCode)) {
                tarrifCodePRICE = abuja.getA1();
            } else if (("A2").equals(tarrifCode)) {
                tarrifCodePRICE = abuja.getA2();
            } else if (("A3").equals(tarrifCode)) {
                tarrifCodePRICE = abuja.getA3();
            } else if (("S1").equals(tarrifCode)) {
                tarrifCodePRICE = abuja.getS1();
            } else {
                useTheToast();
            }
        } else if (("Benin").equals(distco)) {
            Benin benin = new Benin();
            if (("R1").equals(tarrifCode)) {
                tarrifCodePRICE = benin.getR1();
            } else if (("R2S").equals(tarrifCode)) {
                tarrifCodePRICE = benin.getR2s();
            } else if (("R2T").equals(tarrifCode)) {
                tarrifCodePRICE = benin.getR2t();
            } else if (("R3").equals(tarrifCode)) {
                tarrifCodePRICE = benin.getR3();
            } else if (("R4").equals(tarrifCode)) {
                tarrifCodePRICE = benin.getR4();
            } else if (("C1S").equals(tarrifCode)) {
                tarrifCodePRICE = benin.getC1s();
            } else if (("C1S").equals(tarrifCode)) {
                tarrifCodePRICE = benin.getC1t();
            } else if (("C2").equals(tarrifCode)) {
                tarrifCodePRICE = benin.getC2();
            } else if (("C3").equals(tarrifCode)) {
                tarrifCodePRICE = benin.getC3();
            } else if (("D1S").equals(tarrifCode)) {
                tarrifCodePRICE = benin.getD1s();
            } else if (("D1T").equals(tarrifCode)) {
                tarrifCodePRICE = benin.getD1t();
            } else if (("D2").equals(tarrifCode)) {
                tarrifCodePRICE = benin.getD2();
            } else if (("D3").equals(tarrifCode)) {
                tarrifCodePRICE = benin.getD3();
            } else if (("A1S").equals(tarrifCode)) {
                tarrifCodePRICE = benin.getA1s();
            } else if (("A1T").equals(tarrifCode)) {
                tarrifCodePRICE = benin.getA1t();
            } else if (("A2").equals(tarrifCode)) {
                tarrifCodePRICE = benin.getA2();
            } else if (("A3").equals(tarrifCode)) {
                tarrifCodePRICE = benin.getA3();
            } else if (("L1").equals(tarrifCode)) {
                tarrifCodePRICE = benin.getL1();
            } else {
                useTheToast();
            }
        } else if (("Eko").equals(distco)) {
            Eko eko = new Eko();

            if (("R1").equals(tarrifCode)) {
                tarrifCodePRICE = eko.getR1();
            } else if (("R2S").equals(tarrifCode)) {
                tarrifCodePRICE = eko.getR2S();
            } else if (("R2T").equals(tarrifCode)) {
                tarrifCodePRICE = eko.getR2T();
            } else if (("R3").equals(tarrifCode)) {
                tarrifCodePRICE = eko.getR3();
            } else if (("R4").equals(tarrifCode)) {
                tarrifCodePRICE = eko.getR4();
            } else if (("C1S").equals(tarrifCode)) {
                tarrifCodePRICE = eko.getC1S();
            } else if (("C1T").equals(tarrifCode)) {
                tarrifCodePRICE = eko.getC1T();
            } else if (("C2").equals(tarrifCode)) {
                tarrifCodePRICE = eko.getC2();
            } else if (("C3").equals(tarrifCode)) {
                tarrifCodePRICE = eko.getC3();
            } else if (("D1S").equals(tarrifCode)) {
                tarrifCodePRICE = eko.getD1S();
            } else if (("D1T").equals(tarrifCode)) {
                tarrifCodePRICE = eko.getD1T();
            } else if (("D2").equals(tarrifCode)) {
                tarrifCodePRICE = eko.getD2();
            } else if (("D3").equals(tarrifCode)) {
                tarrifCodePRICE = eko.getD3();
            } else if (("A1S").equals(tarrifCode)) {
                tarrifCodePRICE = eko.getA1S();
            } else if (("A1T").equals(tarrifCode)) {
                tarrifCodePRICE = eko.getA1T();
            } else if (("A2").equals(tarrifCode)) {
                tarrifCodePRICE = eko.getA2();
            } else if (("A3").equals(tarrifCode)) {
                tarrifCodePRICE = eko.getA3();
            } else if (("L1").equals(tarrifCode)) {
                tarrifCodePRICE = eko.getL1();
            } else {
                useTheToast();
            }
        } else if (("Enugu").equals(distco)) {
            Enugu enugu = new Enugu();

            if (("R1").equals(tarrifCode)) {
                tarrifCodePRICE = enugu.getR1();
            } else if (("R2S").equals(tarrifCode)) {
                tarrifCodePRICE = enugu.getR2s();
            } else if (("R2T").equals(tarrifCode)) {
                tarrifCodePRICE = enugu.getR2t();
            } else if (("R3").equals(tarrifCode)) {
                tarrifCodePRICE = enugu.getR3();
            } else if (("R4").equals(tarrifCode)) {
                tarrifCodePRICE = enugu.getR4();
            } else if (("C1S").equals(tarrifCode)) {
                tarrifCodePRICE = enugu.getC1s();
            } else if (("C1T").equals(tarrifCode)) {
                tarrifCodePRICE = enugu.getC1t();
            } else if (("C2").equals(tarrifCode)) {
                tarrifCodePRICE = enugu.getC2();
            } else if (("C3").equals(tarrifCode)) {
                tarrifCodePRICE = enugu.getC3();
            } else if (("D1S").equals(tarrifCode)) {
                tarrifCodePRICE = enugu.getD1s();
            } else if (("D1T").equals(tarrifCode)) {
                tarrifCodePRICE = enugu.getD1t();
            } else if (("D2").equals(tarrifCode)) {
                tarrifCodePRICE = enugu.getD2();
            } else if (("D3").equals(tarrifCode)) {
                tarrifCodePRICE = enugu.getD3();
            } else if (("A1S").equals(tarrifCode)) {
                tarrifCodePRICE = enugu.getA1t();
            } else if (("A1T").equals(tarrifCode)) {
                tarrifCodePRICE = enugu.getA1t();
            } else if (("A2").equals(tarrifCode)) {
                tarrifCodePRICE = enugu.getA2();
            } else if (("A3").equals(tarrifCode)) {
                tarrifCodePRICE = enugu.getA3();
            } else if (("L1").equals(tarrifCode)) {
                tarrifCodePRICE = enugu.getL1();
            } else {
                useTheToast();
            }
        } else if (("Ibadan").equals(distco)) {
            Ibadan ibadan = new Ibadan();

            if (("R1").equals(tarrifCode)) {
                tarrifCodePRICE = ibadan.getR1();
            } else if (("R2").equals(tarrifCode)) {
                tarrifCodePRICE = ibadan.getR2();
            } else if (("R3").equals(tarrifCode)) {
                tarrifCodePRICE = ibadan.getR3();
            } else if (("R4").equals(tarrifCode)) {
                tarrifCodePRICE = ibadan.getR4();
            } else if (("C1").equals(tarrifCode)) {
                tarrifCodePRICE = ibadan.getC1();
            } else if (("C2").equals(tarrifCode)) {
                tarrifCodePRICE = ibadan.getC2();
            } else if (("C3").equals(tarrifCode)) {
                tarrifCodePRICE = ibadan.getC3();
            } else if (("D1").equals(tarrifCode)) {
                tarrifCodePRICE = ibadan.getD1();
            } else if (("D2").equals(tarrifCode)) {
                tarrifCodePRICE = ibadan.getD2();
            } else if (("D3").equals(tarrifCode)) {
                tarrifCodePRICE = ibadan.getD3();
            } else if (("A1").equals(tarrifCode)) {
                tarrifCodePRICE = ibadan.getA1();
            } else if (("A2").equals(tarrifCode)) {
                tarrifCodePRICE = ibadan.getA2();
            } else if (("A3").equals(tarrifCode)) {
                tarrifCodePRICE = ibadan.getA3();
            } else if (("S1").equals(tarrifCode)) {
                tarrifCodePRICE = ibadan.getS1();
            } else {
                useTheToast();
            }
        } else if (("Ikeja").equals(distco)) {
            Ikeja ikeja = new Ikeja();

            if (("R1").equals(tarrifCode)) {
                tarrifCodePRICE = ikeja.getR1();
            } else if (("R2 SP").equals(tarrifCode)) {
                tarrifCodePRICE = ikeja.getR2_TP();
            } else if (("R2 TP").equals(tarrifCode)) {
                tarrifCodePRICE = ikeja.getR2_TP();
            } else if (("R3").equals(tarrifCode)) {
                tarrifCodePRICE = ikeja.getR3();
            } else if (("R4").equals(tarrifCode)) {
                tarrifCodePRICE = ikeja.getR4();
            } else if (("C1 SP").equals(tarrifCode)) {
                tarrifCodePRICE = ikeja.getC1_SP();
            } else if (("C1 Tp").equals(tarrifCode)) {
                tarrifCodePRICE = ikeja.getC1_TP();
            } else if (("C2").equals(tarrifCode)) {
                tarrifCodePRICE = ikeja.getC2();
            } else if (("C3").equals(tarrifCode)) {
                tarrifCodePRICE = ikeja.getC3();
            } else if (("D1").equals(tarrifCode)) {
                tarrifCodePRICE = ikeja.getD1();
            } else if (("D2").equals(tarrifCode)) {
                tarrifCodePRICE = ikeja.getD2();
            } else if (("D3").equals(tarrifCode)) {
                tarrifCodePRICE = ikeja.getD3();
            } else if (("A1").equals(tarrifCode)) {
                tarrifCodePRICE = ikeja.getA1();
            } else if (("A2").equals(tarrifCode)) {
                tarrifCodePRICE = ikeja.getA2();
            } else if (("A3").equals(tarrifCode)) {
                tarrifCodePRICE = ikeja.getA3();
            } else if (("S1").equals(tarrifCode)) {
                tarrifCodePRICE = ikeja.getS1();
            } else {
                useTheToast();
            }
        } else if (("Jos").equals(distco)) {
            Jos jos = new Jos();

            if (("R1").equals(tarrifCode)) {
                tarrifCodePRICE = jos.getR1();
            } else if (("R2").equals(tarrifCode)) {
                tarrifCodePRICE = jos.getR2();
            } else if (("R3").equals(tarrifCode)) {
                tarrifCodePRICE = jos.getR3();
            } else if (("R4").equals(tarrifCode)) {
                tarrifCodePRICE = jos.getR4();
            } else if (("C1").equals(tarrifCode)) {
                tarrifCodePRICE = jos.getC1();
            } else if (("C2").equals(tarrifCode)) {
                tarrifCodePRICE = jos.getC2();
            } else if (("C3").equals(tarrifCode)) {
                tarrifCodePRICE = jos.getC3();
            } else if (("D1").equals(tarrifCode)) {
                tarrifCodePRICE = jos.getD1();
            } else if (("D2").equals(tarrifCode)) {
                tarrifCodePRICE = jos.getD2();
            } else if (("D3").equals(tarrifCode)) {
                tarrifCodePRICE = jos.getD3();
            } else if (("A1").equals(tarrifCode)) {
                tarrifCodePRICE = jos.getA1();
            } else if (("A2").equals(tarrifCode)) {
                tarrifCodePRICE = jos.getA2();
            } else if (("A3").equals(tarrifCode)) {
                tarrifCodePRICE = jos.getA3();
            } else if (("S1").equals(tarrifCode)) {
                tarrifCodePRICE = jos.getS1();
            } else {
                useTheToast();
            }
        } else if (("Kaduna").equals(distco)) {
            Kaduna kaduna = new Kaduna();

            if (("R1").equals(tarrifCode)) {
                tarrifCodePRICE = kaduna.getR1();
            } else if (("R2 SP").equals(tarrifCode)) {
                tarrifCodePRICE = kaduna.getR2_TP();
            } else if (("R2 TP").equals(tarrifCode)) {
                tarrifCodePRICE = kaduna.getR2_TP();
            } else if (("R3").equals(tarrifCode)) {
                tarrifCodePRICE = kaduna.getR3();
            } else if (("R4").equals(tarrifCode)) {
                tarrifCodePRICE = kaduna.getR4();
            } else if (("C1").equals(tarrifCode)) {
                tarrifCodePRICE = kaduna.getC1();
            } else if (("C2").equals(tarrifCode)) {
                tarrifCodePRICE = kaduna.getC2();
            } else if (("C3").equals(tarrifCode)) {
                tarrifCodePRICE = kaduna.getC3();
            } else if (("D1").equals(tarrifCode)) {
                tarrifCodePRICE = kaduna.getD1();
            } else if (("D2").equals(tarrifCode)) {
                tarrifCodePRICE = kaduna.getD2();
            } else if (("D3").equals(tarrifCode)) {
                tarrifCodePRICE = kaduna.getD3();
            } else if (("A1").equals(tarrifCode)) {
                tarrifCodePRICE = kaduna.getA1();
            } else if (("A2").equals(tarrifCode)) {
                tarrifCodePRICE = kaduna.getA2();
            } else if (("A3").equals(tarrifCode)) {
                tarrifCodePRICE = kaduna.getA3();
            } else if (("L1").equals(tarrifCode)) {
                tarrifCodePRICE = kaduna.getL1();
            } else {
                useTheToast();
            }
        } else if (("Kano").equals(distco)) {
            Kano kano = new Kano();

            if (("R1").equals(tarrifCode)) {
                tarrifCodePRICE = kano.getR1();
            } else if (("R2A").equals(tarrifCode)) {
                tarrifCodePRICE = kano.getR2A();
            } else if (("R2B").equals(tarrifCode)) {
                tarrifCodePRICE = kano.getR2B();
            } else if (("R3").equals(tarrifCode)) {
                tarrifCodePRICE = kano.getR3();
            } else if (("R4").equals(tarrifCode)) {
                tarrifCodePRICE = kano.getR4();
            } else if (("C1A").equals(tarrifCode)) {
                tarrifCodePRICE = kano.getC1A();
            } else if (("C1").equals(tarrifCode)) {
                tarrifCodePRICE = kano.getC1B();
            } else if (("C2").equals(tarrifCode)) {
                tarrifCodePRICE = kano.getC2();
            } else if (("C3").equals(tarrifCode)) {
                tarrifCodePRICE = kano.getC3();
            } else if (("D1").equals(tarrifCode)) {
                tarrifCodePRICE = kano.getD1();
            } else if (("D2").equals(tarrifCode)) {
                tarrifCodePRICE = kano.getD2();
            } else if (("D3").equals(tarrifCode)) {
                tarrifCodePRICE = kano.getD3();
            } else if (("A1").equals(tarrifCode)) {
                tarrifCodePRICE = kano.getA1();
            } else if (("A2").equals(tarrifCode)) {
                tarrifCodePRICE = kano.getA2();
            } else if (("A3").equals(tarrifCode)) {
                tarrifCodePRICE = kano.getA3();
            } else if (("S1").equals(tarrifCode)) {
                tarrifCodePRICE = kano.getS1();
            } else {
                useTheToast();
            }
        } else if (("Port Harcourt").equals(distco)) {
            PortHarcout portHarcout = new PortHarcout();
            if (("R1").equals(tarrifCode)) {
                tarrifCodePRICE = portHarcout.getR1();
            } else if (("R2").equals(tarrifCode)) {
                tarrifCodePRICE = portHarcout.getR2();
            } else if (("R3").equals(tarrifCode)) {
                tarrifCodePRICE = portHarcout.getR3();
            } else if (("R4").equals(tarrifCode)) {
                tarrifCodePRICE = portHarcout.getR4();
            } else if (("C1").equals(tarrifCode)) {
                tarrifCodePRICE = portHarcout.getC1();
            } else if (("C2").equals(tarrifCode)) {
                tarrifCodePRICE = portHarcout.getC2();
            } else if (("C3").equals(tarrifCode)) {
                tarrifCodePRICE = portHarcout.getC3();
            } else if (("D1").equals(tarrifCode)) {
                tarrifCodePRICE = portHarcout.getD1();
            } else if (("D2").equals(tarrifCode)) {
                tarrifCodePRICE = portHarcout.getD2();
            } else if (("D3").equals(tarrifCode)) {
                tarrifCodePRICE = portHarcout.getD3();
            } else if (("A1").equals(tarrifCode)) {
                tarrifCodePRICE = portHarcout.getA1();
            } else if (("A2").equals(tarrifCode)) {
                tarrifCodePRICE = portHarcout.getA2();
            } else if (("A3").equals(tarrifCode)) {
                tarrifCodePRICE = portHarcout.getA3();
            } else if (("S1").equals(tarrifCode)) {
                tarrifCodePRICE = portHarcout.getS1();
            } else {
                useTheToast();
            }
        } else if (("Yola").equals(distco)) {
            Yola yola = new Yola();

            if (("R1").equals(tarrifCode)) {
                tarrifCodePRICE = yola.getR1();
            } else if (("R2A").equals(tarrifCode)) {
                tarrifCodePRICE = yola.getR2S();
            } else if (("R2B").equals(tarrifCode)) {
                tarrifCodePRICE = yola.getR2T();
            } else if (("R3").equals(tarrifCode)) {
                tarrifCodePRICE = yola.getR3();
            } else if (("C1S").equals(tarrifCode)) {
                tarrifCodePRICE = yola.getC1S();
            } else if (("C1T").equals(tarrifCode)) {
                tarrifCodePRICE = yola.getC1T();
            } else if (("C2").equals(tarrifCode)) {
                tarrifCodePRICE = yola.getC2();
            } else if (("C3").equals(tarrifCode)) {
                tarrifCodePRICE = yola.getC3();
            } else if (("D1S").equals(tarrifCode)) {
                tarrifCodePRICE = yola.getD1S();
            } else if (("D1T").equals(tarrifCode)) {
                tarrifCodePRICE = yola.getD1T();
            } else if (("D2").equals(tarrifCode)) {
                tarrifCodePRICE = yola.getD2();
            } else if (("D3").equals(tarrifCode)) {
                tarrifCodePRICE = yola.getD3();
            } else if (("A1S").equals(tarrifCode)) {
                tarrifCodePRICE = yola.getA1S();
            } else if (("A1T").equals(tarrifCode)) {
                tarrifCodePRICE = yola.getA1T();
            } else if (("A2").equals(tarrifCode)) {
                tarrifCodePRICE = yola.getA2();
            } else if (("A3").equals(tarrifCode)) {
                tarrifCodePRICE = yola.getA3();
            } else if (("L1").equals(tarrifCode)) {
                tarrifCodePRICE = yola.getL1();
            } else {
                useTheToast();
            }
        }

        usage = theValueOfTheWatt * totalTimeOfUsage * 30;
        bill = (usage * tarrifCodePRICE) / 1000;
        return bill;
    }

    private void useTheToast() {
        Toast.makeText(c, "Invalid Tarrif", Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_how_it_works) {
            startActivity(new Intent(this, HowItWorks.class));
            return true;
        } else if (id == R.id.rate_app) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=edgedeveloper.electricitybillestimate")));
            return true;
        } else if (id == R.id.action_launch_web_app) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.enugudisco.com/billing-calculator/")));
            return true;
        } else if (id == R.id.action_quit) {
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
            return true;
        } else if (id == R.id.action_add) {
            LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
            final View mView = layoutInflaterAndroid.inflate(R.layout.dialog, null);
            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
            alertDialogBuilderUserInput.setView(mView);

            theWattageEditText = (EditText) mView.findViewById(R.id.userInputDialog);
            disco = (Spinner) mView.findViewById(R.id.discoSpinner);
            disco.setSelection(indexOFdisco);
            spinnerHoursOrMins = (Spinner) mView.findViewById(R.id.hourOrMinsSpinner);
            appliance = (Spinner) mView.findViewById(R.id.applianceSpinner);
            appliance.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    switch (i) {
                        case 0:
                            theWattageEditText.setText(null);
                            theWattageEditText.setHint("Input Watt");
                            break;
                        case 1:
                            theWattageEditText.setText("50");
                            break;
                        case 2:
                            theWattageEditText.setText("100");
                            break;
                        case 3:
                            theWattageEditText.setText("200");
                            break;
                        case 4:
                            theWattageEditText.setText("1000");
                            break;
                        case 5:
                            theWattageEditText.setText("1200");
                            break;
                        case 6:
                            theWattageEditText.setText("1400");
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

            tarrif = (Spinner) mView.findViewById(R.id.tarrifSpinner);
            tarrif.setSelection(indexOFtarrif);
            hoursOfUsage = (EditText) mView.findViewById(R.id.applianceHoursOfUsage);
            alertDialogBuilderUserInput
                    .setCancelable(false)
                    .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogBox, int id) {
                            wattageString = theWattageEditText.getText().toString();
                            hoursOrMinsString = spinnerHoursOrMins.getSelectedItem().toString();
                            if (TextUtils.isEmpty(wattageString)) {
                                return;
                            } else {
                                theValueOfTheWatt = parseInt(wattageString);
                                distco = disco.getSelectedItem().toString();
                                tarrifCode = tarrif.getSelectedItem().toString();
                                theAppliance = appliance.getSelectedItem().toString();
                                theHoursofUSE = Float.parseFloat(hoursOfUsage.getText().toString());
                                if (("Min").equals(hoursOrMinsString)) {
                                    totalTimeOfUsage = theHoursofUSE / 60;
                                } else {
                                    totalTimeOfUsage = theHoursofUSE;
                                }
                                post = new Post(theAppliance, theValueOfTheWatt + " Watt", theHoursofUSE + " " + hoursOrMinsString, "₦ "+ formatter.format(myBillPerMonth()));
                                recyclerViewAdapter.addEntry(post);
                                RecyclerViewAdapter.mymonthlyBills.add(myBillPerMonth());
                                indexOFtarrif = tarrif.getSelectedItemPosition();
                                indexOFdisco = disco.getSelectedItemPosition();

                            }
                        }
                    })
                    .setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogBox, int id) {
                                    dialogBox.cancel();
                                }
                            });

            AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
            alertDialogAndroid.show();
            return true;
        } else if (id == R.id.action_equals) {
            float total = 0;
            for (int i = 0; i < RecyclerViewAdapter.mymonthlyBills.size(); i++) {
                total += RecyclerViewAdapter.mymonthlyBills.get(i);
            }

            float abcd = total * 0.05f;
            float theRealTotal = total + abcd;

            LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
            final View mView = layoutInflaterAndroid.inflate(R.layout.my_result, null);
            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
            TextView myResult = (TextView) mView.findViewById(R.id.myResult);
            myResult.setText("₦ " + formatter.format(theRealTotal));
            alertDialogBuilderUserInput.setView(mView);
            alertDialogBuilderUserInput
//                .setCancelable(false)
//                .setPositiveButton("More...", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialogBox, int id) {
//                        Snackbar.make(this, "Watch This Space More")
//                    }
//                })
                    .setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogBox, int id) {
                                    dialogBox.cancel();
                                }
                            });

            AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
            alertDialogAndroid.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}