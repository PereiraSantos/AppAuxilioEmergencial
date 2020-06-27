package br.com.unipar.auxilioenergencial;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SaqueBeneficio extends AppCompatActivity {

    // Classe carrega xml
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saquebeneficio);

        setaValores();
    }

    // Classe seta valores textView
    public void setaValores(){

        // Recebe valor intent
        Bundle b = getIntent().getExtras();
        String pagamentoBeneficio = b.getString("dataPagamento");
        Double saldoReceberBeneficio = b.getDouble("saldoReceber");

        //seta valores xml
        TextView textElementAtivo = (TextView) findViewById(R.id.pagamento);
        textElementAtivo.setText("Data receber\n"+pagamentoBeneficio);

        TextView textElement = (TextView) findViewById(R.id.receber);
    textElement.setText("Total receber\n"+"R$:"+saldoReceberBeneficio.toString());
    }
}
