package com.example.lsc.perrerampal;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.RequiresPermission;
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

    //Declaraciones del XML
    String opc;
    Button enviarBtn, borrarBtn, gpsBtn;
    TextView msgTV;
    EditText campo1, campo2, campo3, campo4;
    Spinner spn;
    ArrayAdapter<CharSequence> adapter;

    //Declaraciones datos reporte
    String gpsUser, locProvider;
    int contClick = 0;

    //Funciones:
    void camposVisibles(){ //Activa la edición de los campos EditText y hace visibles los Hints.msg
        campo1.setHint(getString(R.string.lugRepHint));
        campo2.setHint(getString(R.string.repDescHint));
        campo3.setHint(getString(R.string.nombreRepHint));
        campo4.setHint(getString(R.string.telContactHint));
        itallicDesactivado();
        editarActivado();
    }

    void camposNoVisibles(){ //Desactiva los campos, no se puede ingresar texto en los EditText.
        campo1.setHint(""); campo1.setFocusable(false);
        campo2.setHint(""); campo2.setFocusable(false);
        campo3.setHint(""); campo3.setFocusable(false);
        campo4.setHint(""); campo4.setFocusable(false);
    }

    void borraCampos(){ //Borra el texto existente en los campos (los Hints permanecen)
        campo1.setText(""); itallicDesactivado(); campo1.setHint(R.string.lugRepHint); //Reestablecer el hint por si se queda activado el del botón "GPS"
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
                // No hacer nada :v
            }
        });
        //Crear la alerta con la información que ya le dimos y ordenarle que la muestre
        builder.create();
        builder.show();
    }

    //Procedimiento para cuando el usuario quiere usar su ubicación actual.
    protected void obtenerUbicación(){
        final LocationManager ubicacion = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener ubicacionListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) { //Este retorna las coordenadas de la ubicación
                gpsUser = location.toString();
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) { //Este indica qué método obtuvo ubicación (GPS 1 o 2)
                locProvider = s + " " + i;
            }

            @Override
            public void onProviderEnabled(String s) { //Indica si el proovedor de servicio está activado
                campo4.setText(s);
            }

            @Override
            public void onProviderDisabled(String s) { //O si no lo está.
                mandarUsuarioActivarGPS();
            }
        };
        //Atributos: Proveedor, tiempo de refrescado (milisegundos), distancia para refrescar (si se aleja de esta) (en metros) y listener.
        ubicacion.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, ubicacionListener); //A veces muestra error, ignorar.
    }




    //Procedimiento para realizar la llamada al 072
    public void esLlamada()
    {
        Intent llamaInt = new Intent(Intent.ACTION_CALL);
        llamaInt.setData(Uri.parse("tel:072"));
        startActivity(llamaInt); //A veces muestra error, ignorar.
    }

    //¿Es Urgencia? Lo primero que sale al llegar a este activity.
    public void esUrgenciaDialog()
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(ReporteActivity.this);
        builder.setTitle("¿Es una emergencia?").setMessage("Si lo prefiere puede levantar el reporte por llamada telefónica");
        builder.setPositiveButton("Hacer llamada", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) { //Hay un onClick para cada uno para establecer qué hacer para cada botón
                // Código para el onClick del Cancelar
                esLlamada();
            }
        });
        builder.setNegativeButton("Llenar manualmente", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Código para el onClick del Hacer llamada

            }
        });
        //Paso 4: Crear la alerta con la información que ya le dimos y ordenarle que la muestre
        builder.create();
        builder.show();
    }

    protected void mandarUsuarioActivarGPS()
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(ReporteActivity.this);
        builder.setTitle(R.string.activGPS).setMessage(R.string.descrpGPSStr);
        builder.setPositiveButton("Ir a activarlos", new DialogInterface.OnClickListener() { //Hay un onClick para cada uno para establecer qué hacer para cada botón
            public void onClick(DialogInterface dialog, int id) {
                // Código para el onClick del "ir a activarlos"
                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);
            }
        });
        builder.setNegativeButton("Llenar manualmente", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Código para el onClick del "Llenar manualmente"
                campo1.setFocusable(false);
                campo1.setHint(R.string.lugRepHint);
                itallicDesactivado();
            }
        });
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
        msgTV = (TextView) findViewById(R.id.selecReporteTV);
        campo1 = (EditText) findViewById(R.id.lugarRepEditText); campo2 = (EditText) findViewById(R.id.descripcionRepEditText);
        campo3 = (EditText) findViewById(R.id.nombreRepEditText); campo4 = (EditText) findViewById(R.id.telContactoEditText);
        spn = (Spinner) findViewById(R.id.reportSpinner);
        adapter = (ArrayAdapter<CharSequence>) ArrayAdapter.createFromResource(this, R.array.reportesArray,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adapter);

        int i = 0;

        esUrgenciaDialog();
        camposNoVisibles();


        //Spinner y sus elementos
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                opc = (String) spn.getSelectedItem();
                msgTV.setText(opc); //Por añadir R.string.genRep
                switch(i){ //int i nos indica qué opción ha sido seleccionada y acorde se ha implementado el switch.
                    case 0:
                        camposNoVisibles();
                        break;

                    case 1:
                        camposVisibles();
                        break;

                    case 2:
                        camposVisibles();
                        break;

                    case 3:
                        camposVisibles();
                        break;

                    case 4:
                        camposVisibles();
                        break;

                    case 5:
                        camposVisibles();
                        break;

                    case 6:
                        camposVisibles();
                        break;
                    case 7:
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

                //Evento onClick del botón "ubicación actual"
                gpsBtn.setOnClickListener(new View.OnClickListener() { //Evento del botón "GPS"
                    @Override
                    public void onClick(View view) {
                        contClick++;
                        if (contClick % 2 != 0) { //Al primer click, determinado por el residuo de (contClick/2), se activa el GPS
                            //Obtener ubicación actual
                            obtenerUbicación();
                            Toast.makeText(getApplicationContext(), "Obteniendo ubicación actual", Toast.LENGTH_SHORT).show();
                            itallicActivado();
                            campo1.setHint(getString(R.string.gpsStr));
                            campo1.setFocusable(false); //Una vez seleccionado, no se puede editar el campo de la ubicación.
                        }
                        else { //Al segundo click se desactiva GPS.
                            itallicDesactivado();
                            campo1.setFocusable(true);
                            campo1.setHint(R.string.lugRepHint);
                        }
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
