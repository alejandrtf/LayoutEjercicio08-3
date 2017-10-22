package com.android.alejandra.layoutejercicio08_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvRojo, tvNaranja, tvAmarillo, tvVerde, tvAzul, tvIndigo, tvVioleta;
    private int contPulsadas = 0; //no bandas pulsadas
    private String textoPrimero;
    private TextView bandaAnterior = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //obtengo referencias
        initReferencias();
        initListeners();

    }

    /**
     * Asigno listeners
     */
    private void initListeners() {
        tvRojo.setOnClickListener(this);
        tvAmarillo.setOnClickListener(this);
        tvAzul.setOnClickListener(this);
        tvIndigo.setOnClickListener(this);
        tvNaranja.setOnClickListener(this);
        tvVerde.setOnClickListener(this);
        tvVioleta.setOnClickListener(this);
    }

    /**
     * Obtengo referencias
     */
    private void initReferencias() {
        tvRojo = (TextView) findViewById(R.id.tvRojo);
        tvAmarillo = (TextView) findViewById(R.id.tvAmarillo);
        tvAzul = (TextView) findViewById(R.id.tvAzul);
        tvIndigo = (TextView) findViewById(R.id.tvIndigo);
        tvNaranja = (TextView) findViewById(R.id.tvNaranja);
        tvVerde = (TextView) findViewById(R.id.tvVerde);
        tvVioleta = (TextView) findViewById(R.id.tvViolet);

    }


    /**
     * Método que  permite intercambiar el nombre de dos colores, al pulsar primero en uno y luego
     * en otro.
     *
     * @param tvPrimera TextView pulsada en primer lugar
     * @param tvSegunda TextView pulsada en segundo lugar
     */
    public void intercambiarTexto(TextView tvPrimera, TextView tvSegunda) {

        // intercambiar los textos
        // guardo el texto de la primera banda en una auxiliar
        textoPrimero = tvPrimera.getText().toString();
        // cambio el texto a la primera banda
        tvPrimera.setText(tvSegunda.getText());
        // cambio el texto a la segunda banda
        tvSegunda.setText(textoPrimero);
        // reinicio el contador
        contPulsadas = 0;
    }


    @Override
    public void onClick(View v) {
        TextView pulsada = (TextView) v;

        Toast.makeText(this, "Has pulsado " + pulsada.getText().toString() + "!!!", Toast.LENGTH_SHORT).show();

        if (contPulsadas == 0) {
            // primera vez que se pulsa una banda
            bandaAnterior = pulsada;
            contPulsadas++;
        } else {
            // no es la primera banda que se pulsa
            if (contPulsadas == 1) {
                intercambiarTexto(bandaAnterior, pulsada);
            }
        }
    }
}
