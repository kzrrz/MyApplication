package com.example.lsc.perrerampal;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Taller_detalle extends AppCompatActivity {

    ImageView imagen;
    TextView nombre, descripcion;
    Button accionBtn;
    RelativeLayout Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taller_detalle);

        imagen=(ImageView)findViewById(R.id.id_imagen_detalle);
        nombre=(TextView)findViewById(R.id.id_nombre_detalle);
        descripcion=(TextView)findViewById(R.id.id_descripcion_detalle);
        accionBtn = (Button) findViewById(R.id.accionBtn);

        imagen.setImageResource(getIntent().getIntExtra("imagen",00));
        nombre.setText("Nombre: " + getIntent().getStringExtra("nombre"));
        descripcion.setText("Descripción: " + getIntent().getStringExtra("descripcion"));

        accionBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                inscribirTaller(view);
            }
        });

    }

    public void inscribirTaller(View v)
    {
        //Código para la inscripción al taller. Añadir botón enviar y cancelar y hacer que muestre todos los campos
        AlertDialog.Builder alerta = new AlertDialog.Builder(Taller_detalle.this);
        View aView = getLayoutInflater().inflate(R.layout.inscripcion_taller_dialog, null);

        //Inicializamos los elementos mediante aView porque éstos no están en Taller_detalle sino en otro lugar
        // y a través del inflater llegamos a él.
        final EditText etNombre = (EditText) aView.findViewById(R.id.nombreSolTallEdit);
        final EditText etApell = (EditText) aView.findViewById(R.id.apellidosSolTallEdit);
        final EditText etDir = (EditText) aView.findViewById(R.id.dirSolTallEdit);
        final EditText etTel = (EditText) aView.findViewById(R.id.telSolTallEdit);
        final EditText etMail = (EditText) aView.findViewById(R.id.emailSolTallEdit);
        Button inscripBtn = (Button) aView.findViewById(R.id.inscripTallerBtn);

        //Evento del botón "Inscribir Taller"
        inscripBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Si los campos no están vacíos
                if (!etNombre.getText().toString().isEmpty() && !etApell.getText().toString().isEmpty() &&
                        etDir.getText().toString().isEmpty() && etTel.getText().toString().isEmpty() &&
                        etMail.getText().toString().isEmpty()) {
                    Toast.makeText(Taller_detalle.this, "Enviando Inscripción", Toast.LENGTH_SHORT).show();
                    //Enviar solicitud PHP de inscripción
                }
                //Si los campos están vacíos mostrar este Toast
                else
                    Toast.makeText(Taller_detalle.this, "Llene todos los campos, por favor", Toast.LENGTH_SHORT).show();
            }
        });

        //Finalmente construímos todo lo anterior y lo mostramos.
        alerta.setView(aView);
        alerta.create().show();
    }
}
