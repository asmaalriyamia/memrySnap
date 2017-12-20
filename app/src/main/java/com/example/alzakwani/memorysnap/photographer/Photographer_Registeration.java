package com.example.alzakwani.memorysnap.photographer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.alzakwani.memorysnap.R;

import java.io.IOException;

public class Photographer_Registeration extends AppCompatActivity {
    private static final int RESULT_LOAD_IMG = 2;
    private final int REQUEST_CODE = 1;
    ImageView profile_image;
    EditText editText;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    CheckBox wedding, birthday, graduate, newbaby,product,national;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photographer__registeration);

       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        profile_image = (ImageView) findViewById(R.id.profile_image);

        initControls();
    }

    private void initControls() {

        wedding = (CheckBox) findViewById(R.id.wedding);
        birthday = (CheckBox) findViewById(R.id.birthday);
        graduate = (CheckBox) findViewById(R.id.graduate);
        newbaby = (CheckBox) findViewById(R.id.newbaby);
        national = (CheckBox) findViewById(R.id.national);
        product = (CheckBox) findViewById(R.id.product);
        button1 = (Button) findViewById(R.id.button1);


    }

    public void clear(View view) {


        editText = (EditText) findViewById(R.id.editText);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText.setText("");
        editText1.setText("");
        editText2.setText("");
        editText3.setText("");
        editText4.setText("");
    }

    public void onClick(View view) {

        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                ImageView imageView = (ImageView) findViewById(R.id.profile_image);
                imageView.setImageBitmap(bitmap);
                Toast.makeText(this, "hello", Toast.LENGTH_LONG).show();

            } catch (IOException e) {
                Log.i("TAG", "Some exception " + e);
            }


        }

    }

    public void register(View view) {


        switch (view.getId()) {
            case R.id.button1:
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(wedding.isChecked() ? "wedding is checked" : "wedding is unchecked");
                stringBuffer.append(birthday.isChecked() ? "\nbirthday is checked" : "\nbirthday is unchecked");
                stringBuffer.append(graduate.isChecked() ? "\ngraduate is checked" : "\ngraduate is unchecked");
                stringBuffer.append(newbaby.isChecked() ? "\nnewbaby is checked" : "\nnewbaby is unchecked");
                stringBuffer.append(national.isChecked() ? "\nnational is checked" : "\nnational is unchecked");
                stringBuffer.append(product.isChecked() ? "\nproduct is checked" : "\nproduct is unchecked");
                Toast.makeText(this, stringBuffer, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }

}
