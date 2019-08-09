package com.lcoa.facebookloginauth;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import java.util.Arrays;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class signupwith extends AppCompatActivity {
FirebaseAuth firebaseAuth;

    CallbackManager callbackManager;
    LoginButton loginButton;
    private static final String EMAIL = "email";



GoogleSignInClient mGoogleSignInClient;
private static final int  RC_SIGN_IN=234;
SignInButton signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupwith);
        firebaseAuth=FirebaseAuth.getInstance();

signin=(SignInButton) findViewById(R.id.googleid);


        callbackManager = CallbackManager.Factory.create();
        loginButton =  findViewById(R.id.facebokid);
        loginButton.setReadPermissions(Arrays.asList(EMAIL));
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Toast.makeText(signupwith.this, "LoginSuccesful", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(getApplicationContext(),facebook.class);
                        startActivity(i);
                    }
                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });








        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
mGoogleSignInClient = GoogleSignIn.getClient(this,gso);
signin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        signinto();
    }
});

    }
private void signinto()
{
    Intent signinIntent= mGoogleSignInClient.getSignInIntent();
    startActivityForResult(signinIntent,RC_SIGN_IN);
}
public void firebaseAuth(GoogleSignInAccount acct)
{
    AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
    firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        FirebaseUser user = firebaseAuth.getCurrentUser();
                        Intent i = new Intent(signupwith.this, profileactivity.class);
                        startActivity(i);
                        Toast.makeText(signupwith.this, "user sign in", Toast.LENGTH_LONG).show();
                    } else {

                        Toast.makeText(signupwith.this, "Authentication failed", Toast.LENGTH_LONG).show();
                    }
                }
                });


}
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN)
        {
            Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);
            try
            {
                GoogleSignInAccount account=task.getResult(ApiException.class);
                firebaseAuth(account);
            }
            catch (ApiException e)
            {
                Toast.makeText(signupwith.this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
    }

}
