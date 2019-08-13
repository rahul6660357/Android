package com.lcoa.ocr;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.face.FirebaseVisionFace;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetector;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;

import java.util.List;

public class MainActivity extends AppCompatActivity {
Button button;
private final static int REQUEST_CAMERA_CAPTURE=124;
private FirebaseVisionTextRecognizer textRecognizer;
FirebaseVisionImage firebaseVisionImage;
FirebaseVisionFaceDetector detector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.mybutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(i.resolveActivity(getPackageManager())!=null)
                {
                    startActivityForResult(i,REQUEST_CAMERA_CAPTURE);
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
       if(requestCode==REQUEST_CAMERA_CAPTURE &&resultCode==RESULT_OK){
           Bundle extras=data.getExtras();
           Bitmap bitmap=(Bitmap)extras.get("data");
          // recognizeMytext(bitmap);
           detectface(bitmap);
       }



        super.onActivityResult(requestCode, resultCode, data);
    }

    private void detectface(Bitmap bitmap)
    {
        FirebaseVisionFaceDetectorOptions options=
                new FirebaseVisionFaceDetectorOptions.Builder().setModeType(FirebaseVisionFaceDetectorOptions.ACCURATE_MODE)
                .setClassificationType(FirebaseVisionFaceDetectorOptions.ALL_LANDMARKS)
                .setClassificationType(FirebaseVisionFaceDetectorOptions.ALL_CLASSIFICATIONS)
                .setMinFaceSize(0.15f)
                .setTrackingEnabled(true)
                .build();

try {
    firebaseVisionImage=FirebaseVisionImage.fromBitmap(bitmap);
   detector =FirebaseVision.getInstance().getVisionFaceDetector();

}
catch (Exception e)
{
    e.printStackTrace();
}
detector.detectInImage(firebaseVisionImage).addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionFace>>() {
    @Override
    public void onSuccess(List<FirebaseVisionFace> firebaseVisionFaces) {
        String resultText="";
        int i=1;
        for(FirebaseVisionFace face: firebaseVisionFaces)
        {
            resultText=resultText.concat("\n"+i+".")
                    .concat("\nsmile: "+face.getSmilingProbability()*100+"%")
                    .concat("\nLefteye"+ face.getLeftEyeOpenProbability()*100+"%");
            i++;
        }
        if(firebaseVisionFaces.size()==0)
        {
            Toast.makeText(MainActivity.this, "NO FACES", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Bundle bundle=new Bundle();
            bundle.putString("result",resultText);
            DialogFragment resultDialog= new ResultDialog();
            resultDialog.setArguments(bundle);
            resultDialog.setCancelable(false);
            resultDialog.show(getFragmentManager(),"result");

        }
    }
}).addOnFailureListener(new OnFailureListener(){
    @Override
    public void onFailure(@NonNull Exception e){

    }
});
    }

//    private  void recognizeMytext(Bitmap bitmap)
//    {
//        try{
//            firebaseVisionImage=FirebaseVisionImage.fromBitmap(bitmap);
//            textRecognizer= FirebaseVision.getInstance().getOnDeviceTextRecognizer();
//        }
//        catch (Exception e)
//        {
//           e.printStackTrace();
//        }
//        textRecognizer.processImage(firebaseVisionImage).addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
//            @Override
//            public void onSuccess(FirebaseVisionText firebaseVisionText) {
//                String resultText=firebaseVisionText.getText();
//
//                if(resultText.isEmpty()){
//                    Toast.makeText(MainActivity.this, "NO TEXT RECOGNISED", Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    Intent i= new Intent(MainActivity.this, Resultactivity.class);
//                    i.putExtra("result",resultText);
//                    startActivity(i);
//                }
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

}
