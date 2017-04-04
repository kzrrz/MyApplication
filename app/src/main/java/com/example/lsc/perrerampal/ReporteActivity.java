package com.example.lsc.perrerampal;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ReporteActivity extends ActionBarActivity {

    //Declaraciones
    String opc;
    Button enviarBtn, borrarBtn, gpsBtn;
    TextView msgTV, tV1, tV2, tV3, tV4;
    EditText campo1, campo2, campo3, campo4;
    Spinner spn;
    ArrayAdapter<CharSequence> adapter;

    //Funciones:
    void camposVisibles(){ //Activa la edición de los campos EditText y hace visibles los Hints.
        tV1.setText(getString(R.string.arrowRep));
        tV2.setText(getString(R.string.arrowRep));
        tV3.setText(getString(R.string.arrowRep));
        tV4.setText(getString(R.string.arrowRep));
        campo1.setHint(getString(R.string.lugRepHint));
        campo2.setHint(getString(R.string.repDescHint));
        campo3.setHint(getString(R.string.nombreRepHint));
        campo4.setHint(getString(R.string.telContactHint));
        itallicDesactivado();
        editarActivado();
    }

    void camposNoVisibles(){ //Desactiva los campos, no se puede ingresar texto en los EditText.
        tV1.setText("");
        tV2.setText("");
        tV3.setText("");
        tV4.setText("");
        campo1.setHint(""); campo1.setFocusable(false);
        campo2.setHint(""); campo2.setFocusable(false);
        campo3.setHint(""); campo3.setFocusable(false);
        campo4.setHint(""); campo4.setFocusable(false);
    }

    void borraCampos(){ //Borra el texto existente en los campos (los Hints permanecen)
        campo1.setText(""); itallicDesactivado(); campo1.setHint(""); //Reestablecer el hint por si se queda activado el del botón "GPS"
        campo2.setText("");
        campo3.setText("");
        campo4.setText("");
    }

    void editarActivado(){ //Activa la entrada de texto en los EditText
        campo1.setFocusableInTouchMode(true);
        campo2.setFocusableInTouchMode(true);
        campo3.setFocusableInTouchMode(true);
        campo4.setFocusableInTouchMode(true);
    }

    void itallicActivado(){ //Activa el Itallic para cuando se selecciona "GPS"
        campo1.setTypeface(null, Typeface.BOLD_ITALIC);
    }

    void itallicDesactivado(){ //Desactiva el Itallic, vuelve a su edo. original.
        campo1.setTypeface(null, Typeface.NORMAL);
    }

    public void estasSeguroAlert(){
        //Generar el constructor del diálogo
        final AlertDialog.Builder builder = new AlertDialog.Builder(ReporteActivity.this);
        //Construir el diálogo, setTitle da el título y setMessage da el contenido del diálogo
        builder.setTitle(getString(R.string.alertBorrarCampos)).setMessage(getString(R.string.alertBorrarCamposExt));
        //Establecer los botones para las opciones positiva y negativa
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { //Hay un onClick para cada uno para establecer qué hacer para cada botón
            public void onClick(DialogInterface dialog, int id) {
                // Código para el onClick del Aceptar
                borraCampos();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Código para el onClick del Cancelar
            }
        });
        //Crear la alerta con la información que ya le dimos y ordenarle que la muestre
        builder.create();
        builder.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);

        //Código principal
        enviarBtn = (Button) findViewById(R.id.envioReporteBtn);
        borrarBtn = (Button) findViewById(R.id.borrarBtn);
        gpsBtn = (Button) findViewById(R.id.ubicacionBtn);
        msgTV = (TextView) findViewById(R.id.selecReporteTV); tV1 = (TextView) findViewById(R.id.textViewRep1);
                tV2 =(TextView) findViewById(R.id.textViewRep2); tV3 = (TextView) findViewById(R.id.textViewRep3);
                tV4 = (TextView) findViewById(R.id.textViewRep4);
        campo1 = (EditText) findViewById(R.id.lugarRepEditText); campo2 = (EditText) findViewById(R.id.descripcionRepEditText);
                campo3 = (EditText) findViewById(R.id.nombreRepEditText); campo4 = (EditText) findViewById(R.id.telContactoEditText);
        spn = (Spinner) findViewById(R.id.reportSpinner);
        adapter = (ArrayAdapter<CharSequence>) ArrayAdapter.createFromResource(this, R.array.reportesArray,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adapter);

        camposNoVisibles();

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                opc = (String) spn.getSelectedItem();
                msgTV.setText(opc + " (opción " + Integer.toString(i) + ")");
                switch(i){ //int i nos indica qué opción ha sido seleccionada y acorde se ha implementado el switch.
                    case 0:
                            camposNoVisibles();
                        break;

                    case 1:
                        Toast.makeText(getApplicationContext(), "Reporte de perro agresor", Toast.LENGTH_SHORT).show();
                            camposVisibles();
                        break;

                    case 2:
                        Toast.makeText(getApplicationContext(), "Reporte de perro abandonado", Toast.LENGTH_SHORT).show();
                            camposVisibles();
                        break;

                    case 3:
                        Toast.makeText(getApplicationContext(), "Reporte de perro perdido", Toast.LENGTH_SHORT).show();
                            camposVisibles();
                        break;

                    case 4:
                        Toast.makeText(getApplicationContext(), "Reporte de perro en situación de calle", Toast.LENGTH_SHORT).show();
                            camposVisibles();
                        break;

                    case 5:
                        Toast.makeText(getApplicationContext(), "Reporte de perro enfermo", Toast.LENGTH_SHORT).show();
                            camposVisibles();
                        break;

                    case 6:
                        Toast.makeText(getApplicationContext(), "Reporte de cadaver", Toast.LENGTH_SHORT).show();
                            camposVisibles();
                        break;
                    case 7: //maltrato animal
                        Toast.makeText(getApplicationContext(), "Reporte de maltrato animal", Toast.LENGTH_SHORT).show();
                            camposVisibles();
                        break;
                }

                borrarBtn.setOnClickListener(new View.OnClickListener() { //Evento del botón "Borrar campos"
                    @Override
                    public void onClick(View view) {
                        //Desplegar alerta de si estás seguro.
                        estasSeguroAlert();
                    }
                });

                gpsBtn.setOnClickListener(new View.OnClickListener() { //Evento del botón "GPS"
                    @Override
                    public void onClick(View view) {
                        //Obtener ubicación actual
                        Toast.makeText(getApplicationContext(), "Obteniendo ubicación actual", Toast.LENGTH_SHORT).show();
                        itallicActivado();
                        campo1.setHint(getString(R.string.gpsStr));
                        campo1.setFocusable(false); //Una vez seleccionado, no se puede editar el campo de la ubicación.
                    }
                });

                enviarBtn.setOnClickListener(new View.OnClickListener() { //Evento del botón "Enviar reporte"
                    @Override
                    public void onClick(View view) {
                        //Generar reporte y ejecutar formulario PHP para mandarlo a BD.
                        Toast.makeText(getApplicationContext(), "Reporte enviado", Toast.LENGTH_SHORT).show();
                    }
                });

            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                camposNoVisibles();
            }


        });

    }


}
