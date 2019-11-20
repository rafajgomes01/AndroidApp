package com.example.dietmaker;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.MenuItem;

import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.dietmaker.telas.GanhodePeso;
import com.example.dietmaker.telas.Login;
import com.example.dietmaker.telas.Logout;
import com.example.dietmaker.telas.PerderPeso;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GanhodePeso.OnFragmentInteractionListener, PerderPeso.OnFragmentInteractionListener, Logout.OnFragmentInteractionListener {

    private AppBarConfiguration mAppBarConfiguration;
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    public FirebaseAuth usuario = FirebaseAuth.getInstance();
    private Button btnLogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send /*R.id.testeFragment*/)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        DatabaseReference user = referencia.child("user");


        // método para logar
        /*
        usuario.signInWithEmailAndPassword("batata@gmail.com", "batata123").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.i("LoginUser", "Sucesso ao logar");
                } else {
                    Log.i("LoginUser", "Erro ao logar usuário");
                }
            }
        });

        */

        // método para deslogar
        //usuario.signOut();

        // metodo para verificar se está logado

        if(usuario.getCurrentUser() != null){
            Toast toast = Toast.makeText(this, "Seja bem vindo", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Intent it = new Intent(this, Login.class);
            startActivity(it);
        }



        // cadastrar um usuario
        /*
        usuario.createUserWithEmailAndPassword("batata@gmail.com", "batata123")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.i("CreateUser", "Sucesso ao cadastrar usuário");
                } else {
                    Log.i("CreateUser", "Erro ao cadastrar usuário");
                }
            }
        });
        */


        // faz um select no banco
        /*
        user.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("FIREBASE", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        */

        // adicionar dados estaticos

        //DatabaseReference user = referencia.child("user");

        /*
        DietaPerderPeso dietaPerderPeso = new DietaPerderPeso();
        dietaPerderPeso.setConteudo("teste");
        dietaPerderPeso.setHorario("1555");
        dietaPerderPeso.setTitulo("teste");
        */


        //user.child("001").setValue(dietaPerderPeso);

        //gerar um identificador unico para um nó
        //user.push().setValue(dietaPerderPeso);


        // filtro pelo ID unico
        //DatabaseReference usuarioPesquisa = usuarios.child("-Ltg7OgGYFC7cfQTNVpS");

        // pesquisar por um nó com um valor especifico
        //final Query usuarioPesquisa = user.orderByChild("horario").equalTo("1555");

        // mostrar os primeiros e ultimos valores da tabela
        //final Query usuarioPesquisa = user.orderByKey().limitToFirst(3);
        //final Query usuarioPesquisa = user.orderByKey().limitToLast(3);

        // pesquisar por maior ou igual
        //final Query usuarioPesquisa = user.orderByChild("horario").startAt("1999");

        // pesquisar por menor ou igual
        //final Query usuarioPesquisa = user.orderByChild("horario").endAt("1500");


        // pesquisar entre dois valores
        // final Query usuarioPesquisa = user.orderByChild("horario").startAt("1400").endAt("1500");


        /*
        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //puxa os dados do usuário em forma de lista
                Log.i("DadosUser", dataSnapshot.toString());

                // como recuperar um user utilziando um objeto
                //DietaPerderPeso dadosUsuario = dataSnapshot.getValue(DietaPerderPeso.class);
                //Log.i("DadosUser", "nome " + dadosUsuario.getTitulo());
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

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


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();


    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void browser(View view) {
        Intent ballserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(ballserIntent);
    }

    public void ligarContato(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:(11)5555-5555"));
        startActivity(intent);
    }

    public void emailContato(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:contato@dietmaker"));
        startActivity(Intent.createChooser(emailIntent, "Send feedback"));
    }

    public void localContato(View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/maps/place/UNINOVE+-+Campus+Santo+Amaro/@-23.6527467,-46.7116689,15z/data=!4m5!3m4!1s0x0:0x4578b756c7a1a2e7!8m2!3d-23.6527467!4d-46.7116689"));
        startActivity(intent);
    }

    public void manualPdf(View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("https://drive.google.com/file/d/16GOus6L1nHlo1ksG-QRyTbT_EmP9ghNH/view?usp=sharing"));
        startActivity(intent);
    }

    // Código botão Voltar
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Handle the back button
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            checkExit();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }


    public void checkExit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Você deseja sair?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finishAffinity();
                        //Ação tomada caso o usuário escolha sim.
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }


}
