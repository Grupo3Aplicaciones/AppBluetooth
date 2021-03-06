package com.example.bluetooth;

import androidx.appcompat.app.AppCompatActivity;
import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //creamos los objetos de las clases
    ImageView imagen;
    BluetoothAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //enlazamos el objeto de la clase con el id del xml
        imagen=findViewById(R.id.Imgblue);
        //instanciamos al adaptador con el estado actual del bluetooth
        adaptador=BluetoothAdapter.getDefaultAdapter();
        //consultamos si el adapador es igual a nulo entonces lo indicamos que muestre un toast
        if (adaptador==null){
            imagen.setVisibility(View.VISIBLE);
            Toast.makeText(this,"No se puede activar el Bluetooth",Toast.LENGTH_LONG).show();
        }
        //si el if no cumple con la condición entonces el adaptador esta activado
        else{
            setimageblue(adaptador.isEnabled());}
    }
    //este método es para cuando hagamos click en la imagen llamamos al método set estadoblue
    public void click_imagen(View v){
        setestadoblue();
    }

    //en este método consultado segun las condicionales si el adaptador esta activado entonces que me muestre las imagen correspondiente sino también me va mostrar otra imagen según su estado
    public void setimageblue(boolean valor)
    {
        if (valor)imagen.setImageResource(R.drawable.blue_on);
        else imagen.setImageResource(R.drawable.blue_off);
    }
    //consultamos el estado de la adaptador y si esta activado mostramos la imagen llamando al metodo setimageblue y lo desactivamos y lo mismo con la siguiente condición
    public void setestadoblue()
    {
        if(adaptador.isEnabled()){
            setimageblue(false);
            adaptador.disable();
        }
        else{
            setimageblue(true);
            adaptador.enable();
        }
    }
}
