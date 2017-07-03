package com.example.camera;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    public static final int REQ_CAPTURE = 1234;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                imageUri = Uri.fromFile(
                        new File(
                                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),
                                String.valueOf(System.currentTimeMillis()) + ".jpg"
                        )
                );
                intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, REQ_CAPTURE);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            if (requestCode == REQ_CAPTURE) {

                //use imageUri here to access the image

               /* Bundle extras = data.getExtras();
                Bitmap bmp = (Bitmap) extras.get("data");*/

                // here you will get the image as bitmap

                ((ImageView) findViewById(R.id.imageView)).setImageURI(imageUri);

            } else {
                Toast.makeText(this, "Problem ", Toast.LENGTH_SHORT).show();
            }
        }
    }
}