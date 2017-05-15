package com.example.lsc.perrerampal;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Animal_detalle extends AppCompatActivity {

    ImageView imagen;
    TextView nombre, descripcion;
    Button inscripBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detalle);

        imagen=(ImageView)findViewById(R.id.id_imagen_detalle);
        nombre=(TextView)findViewById(R.id.id_nombre_detalle);
        descripcion=(TextView)findViewById(R.id.id_descripcion_detalle);
        inscripBtn = (Button) findViewById(R.id.accionBtn2);

        imagen.setImageResource(getIntent().getIntExtra("imagen",00));
        nombre.setText("Nombre: " + getIntent().getStringExtra("nombre"));
        descripcion.setText("Descripción: " + getIntent().getStringExtra("descripcion"));

        inscripBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                solicitudAdopcion(view);
            }
        });

    }


    public void solicitudAdopcion(View v)
    {
        //Código para la inscripción al taller. Añadir botón enviar y cancelar y hacer que muestre todos los campos
        AlertDialog.Builder alerta = new AlertDialog.Builder(Animal_detalle.this);
        View aView = getLayoutInflater().inflate(R.layout.solicitud_adopcion_dialog, null);

        //Inicializamos los elementos mediante aView porque éstos no están en Taller_detalle sino en otro lugar
        // y a través del inflater llegamos a él.
        final EditText etNombre = (EditText) aView.findViewById(R.id.nombreAdopcionET);
        final EditText etApell = (EditText) aView.findViewById(R.id.apellidosAdopcionET);
        final EditText etDir = (EditText) aView.findViewById(R.id.dirSolAdopcionET);
        final EditText etTel = (EditText) aView.findViewById(R.id.telSolAdopcionET);
        final EditText etMail = (EditText) aView.findViewById(R.id.emailSolAdopET);
        Button inscripBtn = (Button) aView.findViewById(R.id.adoptarBtn);

        //Evento del botón "Inscribir Taller"
        inscripBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Si los campos no están vacíos
                if (!etNombre.getText().toString().isEmpty() && !etApell.getText().toString().isEmpty() &&
                        etDir.getText().toString().isEmpty() && etTel.getText().toString().isEmpty() &&
                        etMail.getText().toString().isEmpty()) {
                    Toast.makeText(Animal_detalle.this, "Enviando solicitud de adopción", Toast.LENGTH_SHORT).show();
                    //Enviar solicitud PHP de inscripción
                }
                //Si los campos están vacíos mostrar este Toast
                else
                    Toast.makeText(Animal_detalle.this, "Llene todos los campos, por favor", Toast.LENGTH_SHORT).show();
            }
        });

        //Finalmente construímos todo lo anterior y lo mostramos.
        alerta.setView(aView);
        alerta.create().show();
    }

}
